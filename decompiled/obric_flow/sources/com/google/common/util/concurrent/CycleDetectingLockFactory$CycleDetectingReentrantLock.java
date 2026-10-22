package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class CycleDetectingLockFactory$CycleDetectingReentrantLock extends ReentrantLock implements h0 {
    private final i0 lockGraphNode;
    final /* synthetic */ j0 this$0;

    public CycleDetectingLockFactory$CycleDetectingReentrantLock(j0 r5, i0 r10, boolean r11, g0 r12) {
        super(r11);
        throw null;
    }

    @Override // com.google.common.util.concurrent.h0
    public i0 getLockGraphNode() {
        return null;
    }

    @Override // com.google.common.util.concurrent.h0
    public boolean isAcquiredByCurrentThread() {
        return isHeldByCurrentThread();
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void lock() {
        Logger r5 = j0.f9413a;
        throw null;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        Logger r5 = j0.f9413a;
        throw null;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public boolean tryLock() {
        Logger r5 = j0.f9413a;
        throw null;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void unlock() {
        super.unlock();     // Catch: Throwable -> L5
        j0.a(this);
        return;
    L5:
        th = move-exception;
        j0.a(this);
        throw th;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public boolean tryLock(long r5, TimeUnit r10) throws InterruptedException {
        Logger r11 = j0.f9413a;
        throw null;
    }
}
