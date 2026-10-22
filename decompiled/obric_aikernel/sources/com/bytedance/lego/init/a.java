package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AtomicInteger f2077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<FeedShowTaskInfo> f2078b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2080d = null;

    /* JADX INFO: renamed from: com.bytedance.lego.init.a$a, reason: collision with other inner class name */
    static final class RunnableC0060a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final RunnableC0060a f2081c = null;

        /* JADX INFO: renamed from: com.bytedance.lego.init.a$a$a, reason: collision with other inner class name */
        static final class RunnableC0061a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ FeedShowTaskInfo f2082c;

            RunnableC0061a(FeedShowTaskInfo r10) {
                this.f2082c = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.c(a.f2080d, this.f2082c, true);
            }
        }

        static {
            f2081c = new RunnableC0060a();
        }

        RunnableC0060a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r10 = a.f2080d;
            List r11 = a.a(r10);
            List<FeedShowTaskInfo> r12 = k.b();
            Intrinsics.checkExpressionValueIsNotNull(r12, "TaskCollectorManager.getAllFeedShowTaskInfo()");
            r11.addAll(r12);
            CollectionsKt.sort(a.a(r10));
            a.b(r10, a.a(r10));
            Iterator r13 = a.a(r10).iterator();
        L4:
            if (r13.hasNext() == false) goto L9;
            FeedShowTaskInfo r14 = (FeedShowTaskInfo) r13.next();
            if (r14.mustRunInMainThread == true) goto L7;
            a.c(a.f2080d, r14, false);
            goto L4
        L7:
            DelayTaskDispatcher.f2036h.g().post(new RunnableC0061a(r14));
            goto L4
        }
    }

    static {
        f2080d = new a();
        f2077a = new AtomicInteger(0);
        f2078b = new ArrayList();
    }

    private a() {
    }

    public static final /* synthetic */ List a(a r10) {
        return f2078b;
    }

    public static final /* synthetic */ void b(a r10, List r11) {
        r10.e(r11);
    }

    public static final /* synthetic */ void c(a r10, FeedShowTaskInfo r11, boolean r12) {
        r10.f(r11, r12);
    }

    private final void e(List<? extends FeedShowTaskInfo> r10) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L13;
        StringBuilder r11 = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        FeedShowTaskInfo r13 = (FeedShowTaskInfo) r12.next();
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        r14.append('\n');
        r11.append(r14.toString());
        goto L8
    L10:
        com.bytedance.lego.init.util.c r15 = com.bytedance.lego.init.util.c.f2121a;
        String r16 = r11.toString();
        Intrinsics.checkExpressionValueIsNotNull(r16, "sb.toString()");
        r15.a("FeedShowTaskDispatcher", r16);
        return;
    }

    private final void f(FeedShowTaskInfo r10, boolean r11) {
        System.currentTimeMillis();     // Catch: Exception -> L5
        com.bytedance.lego.init.monitor.b.f2115c.c(r10, r11);     // Catch: Exception -> L5
        com.bytedance.lego.init.util.c.f2121a.a("FeedShowTaskDispatcher", r10.taskId + " start. isUIThread: " + r11);     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.lego.init.util.c r12 = com.bytedance.lego.init.util.c.f2121a;
        r12.c("FeedShowTaskDispatcher", "\nerror!error!error!  " + r10.taskId + " run error.\n");
        String r13 = Log.getStackTraceString(e);
        Intrinsics.checkExpressionValueIsNotNull(r13, "Log.getStackTraceString(e)");
        r12.c("FeedShowTaskDispatcher", r13);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_FEED_SHOW_TASK_EXCEPTION:" + r10.taskId);
        return;
    L10:
        throw e;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f2079c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f2079c = true;     // Catch: Throwable -> L11
        new Thread(RunnableC0060a.f2081c, "A-FeedShowTaskDispatcher").start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
