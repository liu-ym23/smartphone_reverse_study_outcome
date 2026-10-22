package com.ss.ttvideoengine.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class ABLock {
    public static int LOCK_IMPL_NORMAL = 0;
    public static int LOCK_IMPL_READ_WRITE = 2;
    public static int LOCK_IMPL_VOID = 1;
    private static final String TAG = "ABLock";
    public static int TYPE_READ = 1;
    public static int TYPE_VOID = 0;
    public static int TYPE_WRITE = 2;
    private final int mImplType;

    public static class NormalLock extends ABLock {
        private ReentrantLock mLock;

        public NormalLock(int r1) {
            super(r1);
            this.mLock = new ReentrantLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r1) {
            this.mLock.lock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r1) {
            return this.mLock.tryLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r1) {
            this.mLock.unlock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r1, long r2, TimeUnit r4) throws InterruptedException {
            return this.mLock.tryLock(r2, r4);
        }
    }

    public static class OptimizedLock extends ABLock {
        private final ReentrantReadWriteLock.ReadLock mReadLock;
        private final ReentrantReadWriteLock.WriteLock mWriteLock;

        public OptimizedLock(int r2) {
            super(r2);
            ReentrantReadWriteLock r3 = new ReentrantReadWriteLock();
            this.mReadLock = r3.readLock();
            this.mWriteLock = r3.writeLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r2) {
            if (r2 != ABLock.TYPE_READ) goto L6;
            this.mReadLock.lock();
            return;
        L6:
            if (r2 != ABLock.TYPE_WRITE) goto L10;
            this.mWriteLock.lock();
            return;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r2) {
            if (r2 != ABLock.TYPE_READ) goto L7;
            return this.mReadLock.tryLock();
        L7:
            if (r2 == ABLock.TYPE_WRITE) goto L9;
            return true;
        L9:
            return this.mWriteLock.tryLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r2) {
            if (r2 != ABLock.TYPE_READ) goto L6;
            this.mReadLock.unlock();
            return;
        L6:
            if (r2 != ABLock.TYPE_WRITE) goto L10;
            this.mWriteLock.unlock();
            return;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r2, long r3, TimeUnit r5) throws InterruptedException {
            if (r2 != ABLock.TYPE_READ) goto L7;
            return this.mReadLock.tryLock(r3, r5);
        L7:
            if (r2 == ABLock.TYPE_WRITE) goto L9;
            return true;
        L9:
            return this.mWriteLock.tryLock(r3, r5);
        }
    }

    public static class VoidLock extends ABLock {
        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r1) {
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r1) {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r1, long r2, TimeUnit r4) throws InterruptedException {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r1) {
        }

        public VoidLock(int r1) {
            super(r1);
        }
    }

    public abstract void lock(int r1);

    public abstract boolean tryLock(int r1);

    public abstract boolean tryLock(int r1, long r2, TimeUnit r4) throws InterruptedException;

    public abstract void unlock(int r1);

    public void lock() {
        lock(TYPE_VOID);
    }

    public void unlock() {
        unlock(TYPE_VOID);
    }

    public int getType() {
        return this.mImplType;
    }

    public ABLock(int r1) {
        this.mImplType = r1;
    }

    public static ABLock create(int r2) {
        TTVideoEngineLog.i(TAG, "create ABLock type: " + r2);
        int r0 = LOCK_IMPL_NORMAL;
        if (r2 != r0) goto L7;
        return new NormalLock(r2);
    L7:
        if (r2 != LOCK_IMPL_VOID) goto L11;
        return new VoidLock(r2);
    L11:
        if (r2 != LOCK_IMPL_READ_WRITE) goto L15;
        return new OptimizedLock(r2);
    L15:
        return new NormalLock(r0);
    }
}
