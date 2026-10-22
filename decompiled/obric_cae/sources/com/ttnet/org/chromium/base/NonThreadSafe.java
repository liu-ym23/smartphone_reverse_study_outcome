package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class NonThreadSafe {
    private Long mThreadId;

    public NonThreadSafe() {
        ensureThreadIdAssigned();
    }

    private void ensureThreadIdAssigned() {
        if (this.mThreadId != null) goto L6;
        this.mThreadId = Long.valueOf(Thread.currentThread().getId());
        return;
    }

    public synchronized boolean calledOnValidThread() {
        monitor-enter(this);
        ensureThreadIdAssigned();     // Catch: Throwable -> L6
        boolean r8 = this.mThreadId.equals(Long.valueOf(Thread.currentThread().getId()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public synchronized void detachFromThread() {
        monitor-enter(this);
        this.mThreadId = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
