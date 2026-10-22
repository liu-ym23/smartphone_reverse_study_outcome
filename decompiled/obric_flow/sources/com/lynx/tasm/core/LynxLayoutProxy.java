package com.lynx.tasm.core;

import com.lynx.base.log.LynxLog;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class LynxLayoutProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f10830b;

    public LynxLayoutProxy(long r5) {
        this.f10830b = new ReentrantReadWriteLock();
        this.f10829a = nativeCreate(r5);
        LynxLog.b(2, "LynxLayoutProxy", "LynxLayoutProxy is created");
    }

    private native long nativeCreate(long r5);

    private native void nativeRelease(long r5);

    private native void nativeRunOnLayoutThread(long r5, Runnable r10);

    public final void a() {
        ReentrantReadWriteLock r5 = this.f10830b;
        r5.writeLock().lock();
        if (this.f10829a == 0) goto L5;
        LynxLog.b(2, "LynxLayoutProxy", "LynxLayoutProxy will be destroyed");
        nativeRelease(this.f10829a);
        this.f10829a = 0;
    L5:
        r5.writeLock().unlock();
    }

    public final void b(Runnable r10) {
        ReentrantReadWriteLock r5 = this.f10830b;
        r5.readLock().lock();
        if (this.f10829a == 0) goto L5;
        LynxLog.b(2, "LynxLayoutProxy", "runOnLayoutThread is invoked");
        nativeRunOnLayoutThread(this.f10829a, r10);
    L5:
        r5.readLock().unlock();
    }
}
