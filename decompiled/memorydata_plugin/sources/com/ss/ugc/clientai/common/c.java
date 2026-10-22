package com.ss.ugc.clientai.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f15811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f15812b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static boolean f15813a = false;

        /* JADX INFO: renamed from: com.ss.ugc.clientai.common.c$a$a, reason: collision with other inner class name */
        private static class C0843a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ScheduledExecutorService f15814a;

            static {
                f15814a = Executors.newSingleThreadScheduledExecutor();
            }
        }

        static {
        }

        public static ScheduledExecutorService a() {
            if (b.f15808a == false) goto L8;
            if (f15813a == true) goto L8;
            f15813a = true;
            b.a("ml#task", "use Default ScheduledExecutorService!", new Throwable("for debug!!"));
        L8:
            return C0843a.f15814a;
        }
    }

    static {
    }

    public c() {
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService r0 = f15812b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (com.ss.ugc.clientai.common.a.f15807b == null) goto L21;
        monitor-enter(c.class);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (f15812b != null) goto L14;
        ScheduledExecutorService r1 = com.ss.ugc.clientai.common.a.f15807b.b();     // Catch: Throwable -> L17
        f15812b = r1;     // Catch: Throwable -> L17
        if (r1 != null) goto L14;
        f15812b = a.a();     // Catch: Throwable -> L17
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L17
        return f15812b;
    L21:
        return a.a();
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        a().execute(r3);
    }

    public static void a(Runnable r2, long r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r3 > 0) goto L5;
        a(r4);
        return;
    L5:
        a().schedule(r4, r3, TimeUnit.MILLISECONDS);
    }
}
