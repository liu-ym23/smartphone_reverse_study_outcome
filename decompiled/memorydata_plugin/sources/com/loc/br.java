package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f5375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected bq.a f5376b;
    private ConcurrentHashMap<bq, Future<?>> c;

    public br() {
        this.c = new ConcurrentHashMap();
        this.f5376b = new AnonymousClass1(this);
    }

    private synchronized void a(bq r3, Future<?> r4) {
        monitor-enter(this);
        Future<?> r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.c.put(r3, r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        q.b(th, "TPool", "addQueue");     // Catch: Throwable -> L11
        th.printStackTrace();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private synchronized boolean c(bq r3) {
        monitor-enter(this);
        boolean r4 = this.c.containsKey(r3);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return r4;
    L5:
        th = move-exception;
        q.b(th, "TPool", "contain");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        r4 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(bq r3) {
        monitor-enter(this);
        this.c.remove(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        q.b(th, "TPool", "removeQueue");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final Executor b() {
        return this.f5375a;
    }

    public final void b(bq r2) {
        if (c(r2) == false) goto L5;
        return;
    L5:
        ThreadPoolExecutor r0 = this.f5375a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isShutdown() == true) goto L22;
        r2.d = this.f5376b;
        Future<?> r1 = this.f5375a.submit(r2);     // Catch: RejectedExecutionException -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        a(r2, r1);
        return;
    L16:
        e = move-exception;
        q.b(e, "TPool", "addTask");
        return;
    }
}
