package com.ss.ttvideoengine.utils;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ABLockWrapper extends ABLock {
    private ABLock mCurrentLock;
    private ABLock mLastLock;

    @Override // com.ss.ttvideoengine.utils.ABLock
    public int getType() {
        return this.mCurrentLock.getType();
    }

    public ABLockWrapper(int r1) {
        super(r1);
        this.mCurrentLock = ABLock.create(r1);
        this.mLastLock = ABLock.create(ABLock.LOCK_IMPL_VOID);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void lock(int r2) {
        this.mCurrentLock.lock(r2);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int r2) {
        return this.mCurrentLock.tryLock(r2);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void unlock(int r2) {
        this.mCurrentLock.unlock(r2);     // Catch: IllegalMonitorStateException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mLastLock.unlock(r2);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public void updateLockType(int r2) {
        if (this.mCurrentLock.getType() == r2) goto L6;
        this.mLastLock = this.mCurrentLock;
        this.mCurrentLock = ABLock.create(r2);
        return;
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int r2, long r3, TimeUnit r5) throws InterruptedException {
        return this.mCurrentLock.tryLock(r2, r3, r5);
    }
}
