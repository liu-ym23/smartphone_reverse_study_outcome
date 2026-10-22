package com.lynx.tasm.core;

import com.lynx.tasm.base.LLog;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxLayoutProxy {
    public long a;
    public final ReadWriteLock b;

    private native long nativeCreate(long r1);

    private native void nativeRelease(long r1);

    private native void nativeRunOnLayoutThread(long r1, Runnable r3);

    public void a() {
        ((ReentrantReadWriteLock) this.b).writeLock().lock();
        if (this.a == 0) goto L5;
        LLog.i("LynxLayoutProxy", "LynxLayoutProxy will be destroyed");
        nativeRelease(this.a);
        this.a = 0;
    L5:
        ((ReentrantReadWriteLock) this.b).writeLock().unlock();
    }

    public LynxLayoutProxy(long r2) {
        this.b = new ReentrantReadWriteLock();
        b(r2);
        LLog.i("LynxLayoutProxy", "LynxLayoutProxy is created");
    }

    public void b(long r1) {
        this.a = nativeCreate(r1);
    }

    public void c(Runnable r6) {
        ((ReentrantReadWriteLock) this.b).readLock().lock();
        if (this.a == 0) goto L5;
        LLog.i("LynxLayoutProxy", "runOnLayoutThread is invoked");
        nativeRunOnLayoutThread(this.a, r6);
    L5:
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
    }
}
