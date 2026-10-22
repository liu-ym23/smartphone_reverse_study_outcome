package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: classes7.dex */
public class Mutex {
    private int lock_count;
    private Thread owner;

    public Mutex() {
        this.owner = null;
        this.lock_count = 0;
    }

    public synchronized void acquire() {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (tryToAcquire() == true) goto L7;
        wait();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public synchronized void release() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.owner != Thread.currentThread()) goto L11;
        int r0 = this.lock_count - 1;     // Catch: Throwable -> L12
        this.lock_count = r0;     // Catch: Throwable -> L12
        if (r0 > 0) goto L8;
        this.owner = null;     // Catch: Throwable -> L12
        notify();     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Thread calling release() doesn't own mutex");     // Catch: Throwable -> L12
    }

    public synchronized boolean tryToAcquire() {
        monitor-enter(this);
        Thread r0 = this.owner;     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
        this.owner = Thread.currentThread();     // Catch: Throwable -> L16
        this.lock_count = 1;     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L9:
        if (r0 != Thread.currentThread()) goto L14;
        this.lock_count++;     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }
}
