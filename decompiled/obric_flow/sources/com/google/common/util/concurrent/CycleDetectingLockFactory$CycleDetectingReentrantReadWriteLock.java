package com.google.common.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements h0 {
    private final i0 lockGraphNode;
    private final CycleDetectingLockFactory$CycleDetectingReentrantReadLock readLock;
    private final CycleDetectingLockFactory$CycleDetectingReentrantWriteLock writeLock;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadLock] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantWriteLock] */
    public CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(final j0 r5, i0 r10, boolean r11, g0 r12) {
        super(r11);
        this.readLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadLock(r5, this);
        this.writeLock = new CycleDetectingLockFactory$CycleDetectingReentrantWriteLock(r5, this);
        throw null;
    }

    @Override // com.google.common.util.concurrent.h0
    public i0 getLockGraphNode() {
        return null;
    }

    @Override // com.google.common.util.concurrent.h0
    public boolean isAcquiredByCurrentThread() {
        if (isWriteLockedByCurrentThread() == false) goto L5;
    L8:
        return true;
    L5:
        if (getReadHoldCount() > 0) goto L8;
        return false;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public /* bridge */ /* synthetic */ Lock readLock() {
        return readLock();
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public /* bridge */ /* synthetic */ Lock writeLock() {
        return writeLock();
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public ReentrantReadWriteLock.ReadLock readLock() {
        return this.readLock;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public ReentrantReadWriteLock.WriteLock writeLock() {
        return this.writeLock;
    }
}
