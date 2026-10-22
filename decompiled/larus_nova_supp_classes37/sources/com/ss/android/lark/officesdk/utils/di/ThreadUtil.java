package com.ss.android.lark.officesdk.utils.di;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ntb.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ThreadUtil {
    public static final Lazy<Handler> a = null;
    public static final Lazy<ExecutorService> b = null;
    public static final Lazy<ExecutorService> c = null;
    public static final Lazy<ExecutorService> d = null;
    public static final Lazy<ExecutorService> e = null;
    public static final Lazy<ScheduledExecutorService> f = null;

    public static final class a {
        @JvmStatic
        public static w c() {
            DependencyContainer r0 = DependencyContainer.a;
            return (w) DependencyContainer.a(w.class, null);
        }

        @JvmStatic
        public static void a(Runnable r1) {
            Intrinsics.checkNotNullParameter(r1, "runnable");
            w r0 = c();
            if (r0 == null) goto L6;
            ExecutorService r2 = r0.S();
            if (r2 == null) goto L6;
        L7:
            if (r2 == null) goto L9;
            r2.execute(r1);
            return;
        L9:
            f(r1);
            return;
        L6:
            r2 = (ExecutorService) ThreadUtil.c.getValue();
            goto L7
        }

        @JvmStatic
        public static void b(Runnable r1) {
            Intrinsics.checkNotNullParameter(r1, "runnable");
            w r0 = c();
            if (r0 == null) goto L6;
            ExecutorService r2 = r0.a0();
            if (r2 == null) goto L6;
        L7:
            if (r2 == null) goto L9;
            r2.execute(r1);
            return;
        L9:
            f(r1);
            return;
        L6:
            r2 = (ExecutorService) ThreadUtil.b.getValue();
            goto L7
        }

        public static void e(Runnable r1) {
            Intrinsics.checkNotNullParameter(r1, "runnable");
            ((Handler) ThreadUtil.a.getValue()).removeCallbacks(r1);
        }

        @JvmStatic
        public static void f(Runnable r1) {
            Intrinsics.checkNotNullParameter(r1, "runnable");
            w r0 = c();
            if (r0 == null) goto L5;
            r0.E(r1);
            return;
        L5:
            ((ExecutorService) ThreadUtil.c.getValue()).execute(r1);
        }

        @JvmStatic
        public static void g(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "runnable");
            w r0 = c();
            if (r0 == null) goto L6;
            r0.c(r2);
            return;
        L6:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
            r2.run();
            return;
        L8:
            ((Handler) ThreadUtil.a.getValue()).post(r2);
        }

        public static void d(Runnable r1, long r2) {
            Intrinsics.checkNotNullParameter(r1, "runnable");
            ((Handler) ThreadUtil.a.getValue()).postDelayed(r1, r2);
        }
    }

    static {
        a = LazyKt.lazy(ThreadUtil$Companion$mainHandler$2.INSTANCE);
        b = LazyKt.lazy(ThreadUtil$Companion$fixedThreadPool$2.INSTANCE);
        c = LazyKt.lazy(ThreadUtil$Companion$cachedThreadPool$2.INSTANCE);
        d = LazyKt.lazy(ThreadUtil$Companion$ioThreadPool$2.INSTANCE);
        e = LazyKt.lazy(ThreadUtil$Companion$cpuThreadPool$2.INSTANCE);
        f = LazyKt.lazy(ThreadUtil$Companion$scheduledExecutor$2.INSTANCE);
    }
}
