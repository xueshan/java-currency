package com.lxs;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        this.startThread();
        assertTrue( true );
    }

    private static ReentrantLock lock = new ReentrantLock();

    public void startThread() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }

}
