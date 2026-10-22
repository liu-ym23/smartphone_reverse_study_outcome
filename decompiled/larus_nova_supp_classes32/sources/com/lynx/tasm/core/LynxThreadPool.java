package com.lynx.tasm.core;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.g0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxThreadPool {
    public static volatile Executor a;
    public static volatile Executor b;
    public static volatile Executor c;
    public static volatile Executor d;
    public static volatile Executor e;

    public static final enum ConcurrentTaskType extends Enum<ConcurrentTaskType> {
        public static final ConcurrentTaskType HIGH_PRIORITY = null;
        public static final /* synthetic */ ConcurrentTaskType[] a = null;

        static {
            ConcurrentTaskType r0 = new ConcurrentTaskType();
            HIGH_PRIORITY = r0;
            a = new ConcurrentTaskType[]{r0};
        }

        public ConcurrentTaskType() {
            super("HIGH_PRIORITY", 0);
        }

        public static ConcurrentTaskType[] values() {
            return (ConcurrentTaskType[]) a.clone();
        }

        public static ConcurrentTaskType valueOf(String r1) {
            return (ConcurrentTaskType) r27.a.a(ConcurrentTaskType.class, r1);
        }
    }

    public static class a implements ThreadFactory {
        public final AtomicInteger a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.lynx.tasm.core.LynxThreadPool$a$a, reason: collision with other inner class name */
        public class C0059a implements Thread.UncaughtExceptionHandler {
            public C0059a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread r1, Throwable r2) {
                r2.toString();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r4, this.b + "-" + this.a.getAndIncrement());
            if (r0.isDaemon() == false) goto L5;
            r0.setDaemon(false);
        L5:
            ThreadMethodProxy.setPriority(r0, this.c);
            r0.setUncaughtExceptionHandler(new C0059a());
            return r0;
        }

        public a(String r1, int r2) {
            this.b = r1;
            this.c = r2;
            this.a = new AtomicInteger(1);
        }
    }

    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r1) {
        }
    }

    public LynxThreadPool() {
    }

    public static Executor a() {
        if (b != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = c("lynx-card-service-thread", 10, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public static Executor b() {
        if (a != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = c("lynx-brief-io-thread", 3, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public static Executor d() {
        if (c != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = c("lynx-image-request-thread", 10, 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public static Executor e() {
        if (d != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = c("lynx-svg-thread", 3, 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static Future f(g0 r2) {
        FutureTask r0 = new FutureTask(r2);
        LynxEnv.runJavaTaskOnConcurrentLoop(new m(r0), ConcurrentTaskType.HIGH_PRIORITY.ordinal());
        return r0;
    }

    public static void g(Runnable r1) {
        LynxEnv.runJavaTaskOnConcurrentLoop(r1, ConcurrentTaskType.HIGH_PRIORITY.ordinal());
    }

    public static Executor c(String r1, int r2, int r3) {
        return PThreadExecutorsUtils.newFixedThreadPool(r3, new a(r1, r2));
    L4:
        th = move-exception;
        th.toString();
        return new b();
    }
}
