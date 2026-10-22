package com.bytedance.frameworks.baselib.network.asynctask;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2283a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<NetworkAsyncTaskType, b> f2284b = null;
    private final ConcurrentHashMap<com.bytedance.frameworks.baselib.network.asynctask.a, ScheduledFuture> c;
    private final ConcurrentHashMap<com.bytedance.frameworks.baselib.network.asynctask.a, Runnable> d;
    private final NetworkAsyncTaskType e;
    private final ScheduledThreadPoolExecutor f;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.asynctask.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.frameworks.baselib.network.asynctask.a f2285a;

        private a(com.bytedance.frameworks.baselib.network.asynctask.a r1) {
            this.f2285a = r1;
        }

        /* synthetic */ a(com.bytedance.frameworks.baselib.network.asynctask.a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f2285a.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(b.c(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f2285a.isLoop() == true) goto L13;
        L7:
            b.a(this.f2285a.getTaskType()).a().remove(this.f2285a);
            b.a(this.f2285a.getTaskType()).b().remove(this.f2285a);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(b.c(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f2285a.isLoop() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f2285a.isLoop() == true) goto L18;
            b.a(this.f2285a.getTaskType()).a().remove(this.f2285a);
            b.a(this.f2285a.getTaskType()).b().remove(this.f2285a);
        L18:
            throw th;
        }
    }

    static {
        f2284b = new ConcurrentHashMap();
    }

    private b(NetworkAsyncTaskType r3) {
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = r3;
        this.f = new ScheduledThreadPoolExecutor(1, new c(r3.name()));
    }

    public static b a(NetworkAsyncTaskType r3) {
        if (r3 == null) goto L18;
        ConcurrentHashMap<NetworkAsyncTaskType, b> r1 = f2284b;
        if (r1.get(r3) != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r1.get(r3) != null) goto L10;
        r1.put(r3, new b(r3));     // Catch: Throwable -> L12
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
    L16:
        return (b) ZeusTransformUtils.preCheckCast(r1.get(r3), b.class, "com.obric.memorydata.plugin");
    L18:
        throw new IllegalArgumentException("unsupported async task type");
    }

    static /* synthetic */ String c() {
        return f2283a;
    }

    public ConcurrentHashMap<?, ?> a() {
        return this.d;
    }

    public void a(com.bytedance.frameworks.baselib.network.asynctask.a r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setTaskType(this.e);
        a r0 = new a(r9, null);     // Catch: Throwable -> L11
        if (r9.isLoop() == false) goto L8;
        ScheduledFuture<?> r1 = this.f.scheduleWithFixedDelay(r0, r9.getInitialDelay(), r9.getLoopInterval(), r9.getTimeUnit());     // Catch: Throwable -> L11
    L9:
        this.d.put(r9, r0);     // Catch: Throwable -> L11
        this.c.put(r9, r1);     // Catch: Throwable -> L11
        return;
    L8:
        r1 = this.f.schedule(r0, r9.getInitialDelay(), r9.getTimeUnit());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public ConcurrentHashMap<?, ?> b() {
        return this.c;
    }

    public void b(com.bytedance.frameworks.baselib.network.asynctask.a r4) {
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.d.remove(r4), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 == null) goto L6;
        this.f.remove(r1);     // Catch: Throwable -> L10
    L6:
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.c.remove(r4), ScheduledFuture.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L15;
        r3.cancel(true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        Logger.e(f2283a, "removeTask failed", th);
    }
}
