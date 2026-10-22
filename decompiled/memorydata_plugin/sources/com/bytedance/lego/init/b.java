package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/lego/init/FeedShowTaskDispatcher;", "", "()V", "TAG", "", "allFeedShowTask", "", "Lcom/bytedance/lego/init/model/FeedShowTaskInfo;", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "started", "", "onFeedShow", "", "printAllFeedShowTasks", "allFeedShowTaskInfo", "", "runTask", "taskInfo", "isUIThread", "sendMonitorData", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AtomicInteger f2759b;
    private static final List<FeedShowTaskInfo> c = null;
    private static boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2760a = null;

        /* JADX INFO: renamed from: com.bytedance.lego.init.b$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
        static final class RunnableC0141a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FeedShowTaskInfo f2761a;

            RunnableC0141a(FeedShowTaskInfo r1) {
                this.f2761a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.a(b.f2758a, this.f2761a, true);
            }
        }

        static {
            f2760a = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            List r4 = b.a(b.f2758a);
            List<FeedShowTaskInfo> r0 = m.h();
            Intrinsics.checkExpressionValueIsNotNull(r0, "TaskCollectorManager.getAllFeedShowTaskInfo()");
            r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
            CollectionsKt.sort(b.a(b.f2758a));
            b.a(b.f2758a, b.a(b.f2758a));
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(b.a(b.f2758a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            FeedShowTaskInfo r1 = (FeedShowTaskInfo) ZeusTransformUtils.preCheckCast(r5.next(), FeedShowTaskInfo.class, "com.obric.memorydata.plugin");
            if (r1.mustRunInMainThread == true) goto L7;
            b.a(b.f2758a, r1, false);
            goto L4
        L7:
            com.bytedance.lego.init.a.f2755a.a().post((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0141a(r1), Runnable.class, "com.obric.memorydata.plugin"));
            goto L4
        }
    }

    static {
        f2758a = new b();
        f2759b = new AtomicInteger(0);
        c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private b() {
    }

    public static final /* synthetic */ List a(b r0) {
        return c;
    }

    public static final /* synthetic */ void a(b r0, FeedShowTaskInfo r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(b r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final void a(FeedShowTaskInfo r7, boolean r8) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.b.f2791a.a(r7, r8);     // Catch: Exception -> L7
        com.bytedance.lego.init.util.d.f2800a.b("FeedShowTaskDispatcher", r7.taskId + " start. isUIThread: " + r8);     // Catch: Exception -> L7
        r7.task.run();     // Catch: Exception -> L7
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.b.f2791a.b(r7, r8);     // Catch: Exception -> L7
        long r4 = r3 - r1;     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.b.f2791a.a(r7, r4, r8);     // Catch: Exception -> L7
        com.bytedance.lego.init.util.d.f2800a.b("FeedShowTaskDispatcher", r7.taskId + " end. cos " + r4 + " ms.");     // Catch: Exception -> L7
        if (f2759b.incrementAndGet() != c.size()) goto L16;
        b();     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.lego.init.util.d.f2800a.c("FeedShowTaskDispatcher", "\nerror!error!error!  " + r7.taskId + " run error.\n");
        com.bytedance.lego.init.util.d r9 = com.bytedance.lego.init.util.d.f2800a;
        String r2 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r2, "Log.getStackTraceString(e)");
        r9.c("FeedShowTaskDispatcher", r2);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "RUN_FEED_SHOW_TASK_EXCEPTION:" + r7.taskId);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(List<? extends FeedShowTaskInfo> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L13;
        StringBuilder r5 = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        FeedShowTaskInfo r1 = (FeedShowTaskInfo) ZeusTransformUtils.preCheckCast(r6.next(), FeedShowTaskInfo.class, "com.obric.memorydata.plugin");
        r5.append(new StringBuilder().append(r1).append('\n').toString());
        goto L8
    L10:
        com.bytedance.lego.init.util.d r7 = com.bytedance.lego.init.util.d.f2800a;
        String r8 = r5.toString();
        Intrinsics.checkExpressionValueIsNotNull(r8, "sb.toString()");
        r7.b("FeedShowTaskDispatcher", r8);
        return;
    }

    private final void b() {
        com.bytedance.lego.init.util.d.f2800a.b("FeedShowTaskDispatcher", "sendMonitorData");     // Catch: Exception -> L4
        com.bytedance.lego.init.monitor.b.f2791a.b();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "DELAY_TASK_MONITOR_EXCEPTION");
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        d = true;     // Catch: Throwable -> L11
        new Thread((Runnable) ZeusTransformUtils.preCheckCast(a.f2760a, Runnable.class, "com.obric.memorydata.plugin"), "A-FeedShowTaskDispatcher").start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
