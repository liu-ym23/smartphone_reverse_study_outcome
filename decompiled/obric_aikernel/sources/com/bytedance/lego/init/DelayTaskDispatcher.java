package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.DelayTime;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DelayTaskDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<DelayTime, PriorityQueue<DelayTaskInfo>> f2029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f2030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile AtomicInteger f2031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f2033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f2034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f2035g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DelayTaskDispatcher f2036h = null;

    static {
        f2036h = new DelayTaskDispatcher();
        f2029a = new LinkedHashMap();
        f2031c = new AtomicInteger(0);
        f2034f = -1;
        f2035g = new Handler(Looper.getMainLooper(), DelayTaskDispatcher$mainHandler$1.f2038c);
    }

    private DelayTaskDispatcher() {
    }

    public static final /* synthetic */ void a(DelayTaskDispatcher r10, PriorityQueue r11) {
        r10.f(r11);
    }

    public static final /* synthetic */ Map b(DelayTaskDispatcher r10) {
        return f2029a;
    }

    public static final /* synthetic */ long c(DelayTaskDispatcher r10) {
        return f2034f;
    }

    public static final /* synthetic */ void d(DelayTaskDispatcher r10) {
        r10.h();
    }

    public static final /* synthetic */ void e(DelayTaskDispatcher r10, DelayTaskInfo r11, boolean r12) {
        r10.j(r11, r12);
    }

    private final void f(PriorityQueue<DelayTaskInfo> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if ((!r10.isEmpty()) == false) goto L8;
        final DelayTaskInfo r11 = r10.poll();
        g.a(new DelayTaskDispatcher$dispatchTask$1(r11));
        goto L4
    }

    @WorkerThread
    private final void h() {
        if (f2033e == false) goto L5;
        return;
    L5:
        f2033e = true;
        com.bytedance.lego.init.util.c.f2121a.a("DelayTaskDispatcher", "initDelayTasks, curTimeFromCreateEnd: " + (System.currentTimeMillis() - f2034f));
        long r10 = System.currentTimeMillis();
        List<DelayTaskInfo> r11 = k.a();
        if (r11 == null) goto L21;
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L21;
        DelayTaskInfo r13 = (DelayTaskInfo) r12.next();
        Intrinsics.checkExpressionValueIsNotNull(r13, "delayTaskInfo");
        if (com.bytedance.lego.init.util.b.a(r13) == false) goto L9;
        Map<DelayTime, PriorityQueue<DelayTaskInfo>> r14 = f2029a;
        if (r14.get(r13.delayTime) != null) goto L17;
        DelayTime r15 = r13.delayTime;
        Intrinsics.checkExpressionValueIsNotNull(r15, "delayTaskInfo.delayTime");
        r14.put(r15, new PriorityQueue());
        Unit r16 = Unit.INSTANCE;
    L17:
        PriorityQueue<DelayTaskInfo> r17 = r14.get(r13.delayTime);
        if (r17 == null) goto L20;
        r17.add(r13);
    L20:
        f2030b++;
    L21:
        long r18 = System.currentTimeMillis();
        i(r11);
        com.bytedance.lego.init.util.c r19 = com.bytedance.lego.init.util.c.f2121a;
        StringBuilder r20 = new StringBuilder();
        r20.append("init cos: ");
        long r21 = r18 - r10;
        r20.append(r21);
        r19.a("DelayTaskDispatcher", r20.toString());
        com.bytedance.lego.init.monitor.a.f2112c.d("DelayTaskDispatcher.initDelayTasks", r21, false);
    }

    private final void i(List<? extends DelayTaskInfo> r10) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L19;
        StringBuilder r11 = new StringBuilder("\n-------------------------   AllDelayTasks   ------------------------\n");
        Iterator r12 = CollectionsKt.sorted(r10).iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        DelayTaskInfo r13 = (DelayTaskInfo) r12.next();
        if (com.bytedance.lego.init.util.b.a(r13) == false) goto L8;
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        r14.append('\n');
        r11.append(r14.toString());
        goto L8
    L12:
        com.bytedance.lego.init.util.c r15 = com.bytedance.lego.init.util.c.f2121a;
        String r16 = r11.toString();
        Intrinsics.checkExpressionValueIsNotNull(r16, "sb.toString()");
        r15.a("DelayTaskDispatcher", r16);
        return;
    }

    private final void j(DelayTaskInfo r10, boolean r11) {
        long r12 = System.currentTimeMillis();     // Catch: Exception -> L5
        com.bytedance.lego.init.monitor.a.f2112c.e(r10, r11);     // Catch: Exception -> L5
        com.bytedance.lego.init.util.c r13 = com.bytedance.lego.init.util.c.f2121a;     // Catch: Exception -> L5
        r13.a("DelayTaskDispatcher", r10.taskId + " start. startTimeFromOnCreateEnd: " + (r12 - f2034f));     // Catch: Exception -> L5
        r13.a("DelayTaskDispatcher", r10.taskId + " run. isUIThread: " + r11);     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        com.bytedance.lego.init.util.c r14 = com.bytedance.lego.init.util.c.f2121a;
        r14.c("DelayTaskDispatcher", "\nerror!error!error!  " + r10.taskId + " run error.\n");
        String r15 = Log.getStackTraceString(e);
        Intrinsics.checkExpressionValueIsNotNull(r15, "Log.getStackTraceString(e)");
        r14.c("DelayTaskDispatcher", r15);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_DELAY_TASK_EXCEPTION:" + r10.taskId);
        return;
    L10:
        throw e;
    }

    public final Handler g() {
        return f2035g;
    }

    public final synchronized void k() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f2032d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f2032d = true;     // Catch: Throwable -> L11
        f2034f = System.currentTimeMillis();     // Catch: Throwable -> L11
        com.bytedance.lego.init.util.c.f2121a.a("DelayTaskDispatcher", "start, curTime: " + f2034f);     // Catch: Throwable -> L11
        com.bytedance.lego.init.monitor.a.f2112c.g(f2034f);     // Catch: Throwable -> L11
        Handler r10 = f2035g;     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(1000, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(1001, 5000);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HAND, 8000);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, 15000);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(1005, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, AnrManager.ANR_MIN_INTERVAL);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CROSSHAIR, 300000);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_TEXT, 600000);     // Catch: Throwable -> L11
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_VERTICAL_TEXT, 900000);     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
