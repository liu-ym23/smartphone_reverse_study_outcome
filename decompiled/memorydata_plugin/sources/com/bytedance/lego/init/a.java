package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.DelayTime;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\b\u0010#\u001a\u00020!H\u0003J\u0018\u0010$\u001a\u00020!2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0006\u0010+\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/lego/init/DelayTaskDispatcher;", "", "()V", "MSG_10min", "", "MSG_15min", "MSG_15s", "MSG_2min", "MSG_30s", "MSG_5min", "MSG_5s", "MSG_60s", "MSG_8s", "TAG", "", "allDelayTaskCount", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "delayTaskMap", "", "Lcom/bytedance/lego/init/model/DelayTime;", "Ljava/util/PriorityQueue;", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "inited", "", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onCreateEndTime", "", "started", "dispatchTask", "", "priorityQueue", "initDelayTasks", "printAllDelayTasks", "allDelayTaskInfo", "", "runTask", "taskInfo", "isUIThread", "sendMonitorData", CommonConsts.APM_INNER_EVENT_COST_START, "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<DelayTime, PriorityQueue<DelayTaskInfo>> f2756b = null;
    private static volatile int c;
    private static volatile AtomicInteger d;
    private static boolean e;
    private static volatile boolean f;
    private static long g;
    private static final Handler h = null;

    /* JADX INFO: renamed from: com.bytedance.lego.init.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, k = 3, mv = {1, 1, 13})
    static final class C0140a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0140a f2757a = null;

        static {
            f2757a = new C0140a();
        }

        C0140a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r7) {
            switch(r7.what) {
                case 1001: goto L13;
                case 1002: goto L12;
                case 1003: goto L11;
                case 1004: goto L10;
                case 1005: goto L9;
                case 1006: goto L8;
                case 1007: goto L7;
                case 1008: goto L6;
                case 1009: goto L5;
                default: goto L15;
            };
        L5:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_15min", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 15min tasks...");
            Object r6 = DelayTaskDispatcher$mainHandler$1$9.INSTANCE;
        L14:
            f.a((Function0) ZeusTransformUtils.preCheckCast(r6, Function0.class, "com.obric.memorydata.plugin"));
            goto L15
        L6:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_10min", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 10min tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$8.INSTANCE;
            goto L14
        L7:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_5min", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 5min tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$7.INSTANCE;
            goto L14
        L8:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_2min", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 2min tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$6.INSTANCE;
            goto L14
        L9:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_60s", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 60s tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$5.INSTANCE;
            goto L14
        L10:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_30s", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 30s tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$4.INSTANCE;
            goto L14
        L11:
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_15s", System.currentTimeMillis() - a.a(a.f2755a), true);
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 15s tasks...");
            r6 = DelayTaskDispatcher$mainHandler$1$3.INSTANCE;
            goto L14
        L12:
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 8s tasks...");
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_8s", System.currentTimeMillis() - a.a(a.f2755a), true);
            r6 = DelayTaskDispatcher$mainHandler$1$2.INSTANCE;
            goto L14
        L13:
            com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "Start dispatch 5s tasks...");
            com.bytedance.lego.init.monitor.a.f2789a.a("Start_Dispatch_5s", System.currentTimeMillis() - a.a(a.f2755a), true);
            r6 = DelayTaskDispatcher$mainHandler$1$1.INSTANCE;
        L15:
            return true;
        }
    }

    static {
        f2755a = new a();
        f2756b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        d = new AtomicInteger(0);
        g = -1;
        h = new Handler(Looper.getMainLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(C0140a.f2757a, Handler.Callback.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    public static final /* synthetic */ long a(a r2) {
        return g;
    }

    public static final /* synthetic */ void a(a r0, DelayTaskInfo r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, PriorityQueue r1) {
        r0.a(r1);
    }

    private final void a(DelayTaskInfo r9, boolean r10) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.a.f2789a.a(r9, r10);     // Catch: Exception -> L7
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", r9.taskId + " start. startTimeFromOnCreateEnd: " + (r1 - g));     // Catch: Exception -> L7
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", r9.taskId + " run. isUIThread: " + r10);     // Catch: Exception -> L7
        r9.task.run();     // Catch: Exception -> L7
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.a.f2789a.b(r9, r10);     // Catch: Exception -> L7
        long r2 = r3 - r1;     // Catch: Exception -> L7
        com.bytedance.lego.init.monitor.a.f2789a.a(r9, r2, r10);     // Catch: Exception -> L7
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", r9.taskId + " end. endTimeFromOnCreateEnd: " + (r3 - g) + ", cos " + r2 + " ms.");     // Catch: Exception -> L7
        if (d.incrementAndGet() != c) goto L16;
        d();     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        com.bytedance.lego.init.util.d.f2800a.c("DelayTaskDispatcher", "\nerror!error!error!  " + r9.taskId + " run error.\n");
        com.bytedance.lego.init.util.d r11 = com.bytedance.lego.init.util.d.f2800a;
        String r4 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r4, "Log.getStackTraceString(e)");
        r11.c("DelayTaskDispatcher", r4);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "RUN_DELAY_TASK_EXCEPTION:" + r9.taskId);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(List<? extends DelayTaskInfo> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L19;
        StringBuilder r5 = new StringBuilder("\n-------------------------   AllDelayTasks   ------------------------\n");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        DelayTaskInfo r1 = (DelayTaskInfo) ZeusTransformUtils.preCheckCast(r6.next(), DelayTaskInfo.class, "com.obric.memorydata.plugin");
        if (com.bytedance.lego.init.util.a.a(r1) == false) goto L8;
        r5.append(new StringBuilder().append(r1).append('\n').toString());
        goto L8
    L12:
        com.bytedance.lego.init.util.d r7 = com.bytedance.lego.init.util.d.f2800a;
        String r8 = r5.toString();
        Intrinsics.checkExpressionValueIsNotNull(r8, "sb.toString()");
        r7.b("DelayTaskDispatcher", r8);
        return;
    }

    private final void a(PriorityQueue<DelayTaskInfo> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        final DelayTaskInfo r2 = (DelayTaskInfo) ZeusTransformUtils.preCheckCast(r3.poll(), DelayTaskInfo.class, "com.obric.memorydata.plugin");
        f.a((Function0) ZeusTransformUtils.preCheckCast(new DelayTaskDispatcher$dispatchTask$1(r2), Function0.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public static final /* synthetic */ void b(a r0) {
        r0.c();
    }

    public static final /* synthetic */ Map c(a r0) {
        return f2756b;
    }

    private final void c() {
        if (f == false) goto L5;
        return;
    L5:
        f = true;
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "initDelayTasks, curTimeFromCreateEnd: " + (System.currentTimeMillis() - g));
        long r1 = System.currentTimeMillis();
        List<DelayTaskInfo> r4 = m.g();
        if (r4 == null) goto L21;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L21;
        DelayTaskInfo r7 = (DelayTaskInfo) ZeusTransformUtils.preCheckCast(r5.next(), DelayTaskInfo.class, "com.obric.memorydata.plugin");
        Intrinsics.checkExpressionValueIsNotNull(r7, "delayTaskInfo");
        if (com.bytedance.lego.init.util.a.a(r7) == false) goto L9;
        Map<DelayTime, PriorityQueue<DelayTaskInfo>> r8 = f2756b;
        if (((PriorityQueue) ZeusTransformUtils.preCheckCast(r8.get(r7.delayTime), PriorityQueue.class, "com.obric.memorydata.plugin")) != null) goto L17;
        DelayTime r9 = r7.delayTime;
        Intrinsics.checkExpressionValueIsNotNull(r9, "delayTaskInfo.delayTime");
        r8.put(r9, new PriorityQueue());
        Unit r10 = Unit.INSTANCE;
    L17:
        PriorityQueue r11 = (PriorityQueue) ZeusTransformUtils.preCheckCast(r8.get(r7.delayTime), PriorityQueue.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        r11.add(r7);
    L20:
        c++;
    L21:
        long r6 = System.currentTimeMillis();
        a(r4);
        long r12 = r6 - r1;
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "init cos: " + r12);
        com.bytedance.lego.init.monitor.a.f2789a.a("DelayTaskDispatcher.initDelayTasks", r12, false);
    }

    private final void d() {
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "sendMonitorData");     // Catch: Exception -> L5
        f.a((Function0) ZeusTransformUtils.preCheckCast(DelayTaskDispatcher$sendMonitorData$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "DELAY_TASK_MONITOR_EXCEPTION");
    }

    public final Handler a() {
        return h;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        e = true;     // Catch: Throwable -> L11
        g = System.currentTimeMillis();     // Catch: Throwable -> L11
        com.bytedance.lego.init.util.d.f2800a.b("DelayTaskDispatcher", "start, curTime: " + g);     // Catch: Throwable -> L11
        com.bytedance.lego.init.monitor.a.f2789a.a(g);     // Catch: Throwable -> L11
        Handler r0 = h;     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1001, 5000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1002, 8000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1003, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1004, 30000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1005, 60000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1006, 120000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1007, 300000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1008, 600000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1009, 900000);     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
