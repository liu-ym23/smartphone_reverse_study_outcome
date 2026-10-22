package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InitTaskDispatcher implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2053c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final h f2054g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Thread f2055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f2056i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f2057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f2058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final CountDownLatch f2059l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final List<InitPeriod> f2060m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final List<InitPeriod> f2061n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f2062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final List<i> f2063p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f2064q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f2065r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final CopyOnWriteArrayList<i> f2066s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Handler f2067t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final InitTaskDispatcher f2068u = null;

    public static final class a implements i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private m3.g f2069c;

        a(m3.g r10) {
            this.f2069c = r10;
        }

        @Override // com.bytedance.lego.init.i
        public m3.g I() {
            return this.f2069c;
        }

        @Override // java.lang.Runnable
        public void run() {
            InitTaskDispatcher.e(InitTaskDispatcher.f2068u, I());
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private m3.g f2070c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.ObjectRef r10) {
            this.f2070c = (m3.g) r10.element;
        }

        @Override // com.bytedance.lego.init.i
        public m3.g I() {
            return this.f2070c;
        }

        @Override // java.lang.Runnable
        public void run() {
            InitTaskDispatcher.e(InitTaskDispatcher.f2068u, I());
        }
    }

    static {
        f2053c = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitTaskDispatcher.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f2068u = new InitTaskDispatcher();
        f2054g = new h();
        f2056i = LazyKt.lazy(LazyThreadSafetyMode.NONE, InitTaskDispatcher$executor$2.INSTANCE);
        f2059l = new CountDownLatch(1);
        f2060m = new ArrayList();
        f2061n = new ArrayList();
        f2063p = new ArrayList();
        f2064q = new Object();
        f2066s = new CopyOnWriteArrayList();
        f2067t = new Handler(Looper.getMainLooper());
    }

    private InitTaskDispatcher() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList a(InitTaskDispatcher r10) {
        return f2066s;
    }

    public static final /* synthetic */ CountDownLatch b(InitTaskDispatcher r10) {
        return f2059l;
    }

    public static final /* synthetic */ Handler c(InitTaskDispatcher r10) {
        return f2067t;
    }

    public static final /* synthetic */ h d(InitTaskDispatcher r10) {
        return f2054g;
    }

    public static final /* synthetic */ void e(InitTaskDispatcher r10, m3.g r11) {
        r10.m(r11);
    }

    public static final /* synthetic */ void f(InitTaskDispatcher r10, boolean r11) {
        f2057j = r11;
    }

    @UiThread
    private final boolean h(InitPeriod r10, boolean r11) {
        List<InitPeriod> r12 = f2060m;
        if (r12.contains(r10) == false) goto L5;
        return false;
    L5:
        Iterator<T> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L14;
        Object r14 = r13.next();
        if (((InitPeriod) r14).getValue() < r10.getValue()) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L7;
    L16:
        if (((InitPeriod) r14) == null) goto L18;
        return false;
    L18:
        if (r11 == false) goto L20;
        f2060m.add(r10);
    L20:
        return true;
    L11:
        r15 = false;
        goto L12
    L14:
        r14 = null;
        goto L16
    }

    private final ThreadPoolExecutor i() {
        Lazy r10 = f2056i;
        KProperty r11 = f2053c[0];
        return (ThreadPoolExecutor) r10.getValue();
    }

    private final void k() {
        long r10 = System.currentTimeMillis();
        com.bytedance.lego.init.util.c r11 = com.bytedance.lego.init.util.c.f2121a;
        if (r11.e() == false) goto L5;
        r11.f("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " start");
    L5:
        InitMonitor r12 = InitMonitor.INSTANCE;
        r12.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        com.bytedance.lego.init.util.f r13 = com.bytedance.lego.init.util.f.f2123a;
        r13.a("InitTaskDispatcher.initInternal");
        InitTaskDispatcher r14 = f2068u;
        d(r14).f();
        f(r14, true);
        b(r14).countDown();
        Unit r15 = Unit.INSTANCE;
        r13.c();
        r12.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        r12.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - r10, false);
        if (r11.e() == false) goto L9;
        r11.a("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " done. cos: " + (System.currentTimeMillis() - r10) + "ms.");
        return;
    }

    private final void m(m3.g r11) {
        boolean r10 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        com.bytedance.lego.init.util.c.g(com.bytedance.lego.init.util.c.f2121a, null, "TaskStart - " + r11 + "  isUIThread:" + r10, 1, null);
        long r12 = System.currentTimeMillis();
        r11.f11040r = r12;
        InitMonitor.INSTANCE.monitorTaskStart(r11, r10);
        com.bytedance.lego.init.util.f.f2123a.b(r11);
        m3.d r13 = r11.f11031i;     // Catch: Exception -> L11
        if (r13 == null) goto L6;
    L5:
        r13.run();     // Catch: Exception -> L11
    L19:
        com.bytedance.lego.init.util.f.f2123a.d();
        InitMonitor r14 = InitMonitor.INSTANCE;
        r14.monitorTaskEnd(r11, r10);
        r14.monitorCosTime(r11, System.currentTimeMillis() - r12, r10);
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "Task " + r11.f11028c + " done. cos " + (System.currentTimeMillis() - r12) + "ms.", 1, null);
        f2054g.i(r11);
        return;
    L6:
        Object r15 = Class.forName(r11.f11030h).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
        if (r15 == null) goto L10;
        r13 = (m3.d) r15;     // Catch: Exception -> L11
        goto L5
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.lego.init.util.c r16 = com.bytedance.lego.init.util.c.f2121a;
        StringBuilder r17 = new StringBuilder();
        r17.append("\nerror!error!error! ");
        r17.append(r11.f11028c);
        r17.append(" run error.\n ");
        e.printStackTrace();
        r17.append(Unit.INSTANCE);
        r17.append(" \n");
        r16.c("InitTaskDispatcher", r17.toString());
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L15;
    L18:
        InitMonitor r18 = InitMonitor.INSTANCE;
        r18.ensureNotReachHere(e, "RUN_TASK_EXCEPTION:" + r11.f11030h);
        Category r19 = Category.RUN_TAK_EXCEPTION;
        String r20 = r11.f11030h + ":" + e.getClass().getName();
        JSONObject r21 = new JSONObject();
        r21.put("exception_detail", Log.getStackTraceString(e));
        r18.monitorEvent(r19, r20, r21);
        goto L19
    L15:
        if ((e instanceof ClassNotFoundException) == true) goto L18;
        throw e;
    }

    private final void n(InitPeriod r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L8
        Iterator<T> r12 = f2054g.d(r10.name() + "_END").iterator();     // Catch: Exception -> L8
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.append(((String) r12.next()) + ' ');     // Catch: Exception -> L8
        goto L4
    L6:
        InitMonitor r13 = InitMonitor.INSTANCE;     // Catch: Exception -> L8
        Category r14 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L8
        String r15 = r10.name();     // Catch: Exception -> L8
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        r16.put("dependencyTasks", r11.toString());     // Catch: Exception -> L8
        r13.monitorEvent(r14, r15, r16);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere(e, "sendPeriodTimeoutException");
    }

    private final void o(m3.g r10) {
        InitMonitor r11 = InitMonitor.INSTANCE;
        String r12 = r10.f11028c;
        Intrinsics.checkExpressionValueIsNotNull(r12, "task.taskId");
        r11.onTaskTimeout(r12);
        Category r13 = Category.TASK_TIMEOUT_EXCEPTION;
        String r14 = r10.f11028c;
        Intrinsics.checkExpressionValueIsNotNull(r14, "task.taskId");
        JSONObject r15 = new JSONObject();
        r15.put("startTime", r10.f11040r);
        r15.put("curTime", System.currentTimeMillis());
        r11.monitorEvent(r13, r14, r15);
    }

    @UiThread
    private final void q() {
        com.bytedance.lego.init.util.c.f2121a.a("InitTaskDispatcher", "startAsyncTask");
        com.bytedance.lego.init.util.f r10 = com.bytedance.lego.init.util.f.f2123a;
        r10.a("startAsyncTask");
        Thread r11 = new Thread(this);
        f2055h = r11;
        r11.start();
        f2058k = true;
        r10.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, m3.g] */
    /* JADX WARN: Type inference failed for: r5v12, types: [T, m3.g] */
    @UiThread
    private final void s(InitPeriod r13, boolean r14) {
    L3:
        if (f2061n.contains(r13) == true) goto L109;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        h r11 = f2054g;
        if (r14 == false) goto L57;
        ?? r12 = r11.l(0);
        r10.element = r12;
        if (((m3.g) r12) != null) goto L32;
        Object r15 = f2064q;
        monitor-enter(r15);
        Iterator<i> r16 = f2063p.iterator();     // Catch: Throwable -> L28
    L13:
        if (r16.hasNext() == false) goto L23;
        i r17 = r16.next();     // Catch: Throwable -> L28
        h r18 = f2054g;     // Catch: Throwable -> L28
        String r19 = r17.I().f11028c;     // Catch: Throwable -> L28
        Intrinsics.checkExpressionValueIsNotNull(r19, "runnable.initTaskInfo.taskId");     // Catch: Throwable -> L28
        float r20 = r18.c(r19);     // Catch: Throwable -> L28
        if (r20 <= 0) goto L13;
        InitPeriod r110 = r17.I().f11039q;     // Catch: Throwable -> L28
        Intrinsics.checkExpressionValueIsNotNull(r110, "runnable.initTaskInfo.endPeriod");     // Catch: Throwable -> L28
        if (r110.getValue() > r13.getValue()) goto L13;
        if (r20 <= r18.c(r13.name() + "_END")) goto L13;
        r16.remove();     // Catch: Throwable -> L28
        if (f2068u.i().remove(r17) == false) goto L13;
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "execute async-task:" + r17.I().f11028c + " in UIThread.", 1, null);     // Catch: Throwable -> L28
    L24:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r15);
        if (r17 == null) goto L32;
        r17.run();
        f2062o = System.currentTimeMillis();
        goto L32
    L23:
        r17 = null;
    L28:
        th = move-exception;
        throw th;
    L32:
        if (((m3.g) r10.element) != null) goto L55;
        if ((System.currentTimeMillis() - f2062o) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L53;
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "UIThread wait timeout.", 1, null);
        f2068u.n(r13);
        Iterator<T> r22 = f2054g.d(r13.name() + "_END").iterator();     // Catch: Exception -> L48
    L39:
        if (r22.hasNext() == false) goto L53;
        String r23 = (String) r22.next();     // Catch: Exception -> L48
        h r24 = f2054g;     // Catch: Exception -> L48
        m3.g r25 = r24.b(r23);     // Catch: Exception -> L48
        if (r25 == null) goto L39;
        long r26 = System.currentTimeMillis() - r25.f11040r;     // Catch: Exception -> L48
        if (r25.f11040r <= 0) goto L39;
        if (r26 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L39;
        r24.i(r25);     // Catch: Exception -> L48
        f2068u.o(r25);     // Catch: Exception -> L48
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "Task " + r25.f11028c + " timeout, is forced to complete.", 1, null);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L52;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "letTimeoutTaskCompele");
        goto L53
    L52:
        throw e;
    L53:
        Unit r27 = Unit.INSTANCE;
    L55:
        if (((m3.g) r10.element) == null) goto L3;
    L60:
        long r28 = System.currentTimeMillis();
        if (com.bytedance.lego.init.util.e.b((m3.g) r10.element) == false) goto L63;
    L71:
        com.bytedance.lego.init.util.f r29 = com.bytedance.lego.init.util.f.f2123a;
        r29.b((m3.g) r10.element);
        com.bytedance.lego.init.util.c r30 = com.bytedance.lego.init.util.c.f2121a;
        com.bytedance.lego.init.util.c.b(r30, null, ((m3.g) r10.element).f11028c + " complete directly. cos " + (System.currentTimeMillis() - r28) + "ms", 1, null);
        f2054g.i((m3.g) r10.element);
        r29.d();
        if (com.bytedance.lego.init.util.e.b((m3.g) r10.element) == true) goto L74;
    L76:
        f2062o = System.currentTimeMillis();
        goto L3
    L74:
        if (Intrinsics.areEqual(r13.name() + "_END", ((m3.g) r10.element).f11028c) == false) goto L76;
        InitMonitor.INSTANCE.monitorCosTime("wait: " + r13.name(), System.currentTimeMillis() - f2062o, true);
        com.bytedance.lego.init.util.c.b(r30, null, "wait: " + r13.name() + ' ' + (System.currentTimeMillis() - f2062o) + "ms.", 1, null);
        f2061n.add(r13);
        return;
    L63:
        if (com.bytedance.lego.init.util.e.a((m3.g) r10.element) == false) goto L71;
        if (((m3.g) r10.element).f11033k == true) goto L68;
    L70:
        m((m3.g) r10.element);
        goto L76
    L68:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L70;
        f2066s.add(new b(r10));
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, ((m3.g) r10.element).f11028c + " skip directly.", 1, null);
        f2054g.i((m3.g) r10.element);
        goto L76
    L57:
        ?? r31 = r11.l(0);
        if (r31 == 0) goto L110;
        r10.element = r31;
        goto L60
    L110:
        return;
    }

    public final void g() {
        f2054g.a();
    }

    public final void j() {
        if (f2057j == false) goto L5;
        return;
    L5:
        k();
    }

    @UiThread
    public final void l(InitPeriod r16, boolean r17) {
        Intrinsics.checkParameterIsNotNull(r16, TypedValues.CycleType.S_WAVE_PERIOD);
        long r10 = System.currentTimeMillis();
        if (r17 == false) goto L5;
        String r11 = "-END";
    L7:
        if (h(r16, r17) == true) goto L9;
        return;
    L9:
        InitMonitor r12 = InitMonitor.INSTANCE;
        r12.monitorStart(r16.name() + r11, true);
        com.bytedance.lego.init.util.f r13 = com.bytedance.lego.init.util.f.f2123a;
        r13.a("onPeriod-" + r16.name() + r11);
        if (f2057j == true) goto L13;
        com.bytedance.lego.init.util.c r14 = com.bytedance.lego.init.util.c.f2121a;
        com.bytedance.lego.init.util.c.b(r14, null, "wait init countdownlatch " + r16.name(), 1, null);
        long r15 = System.currentTimeMillis();
        f2059l.await();
        r12.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r15, true);
        r14.a("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r15));
    L13:
        if (f2065r == false) goto L17;
        com.bytedance.lego.init.util.c.d(com.bytedance.lego.init.util.c.f2121a, null, "No task.", 1, null);
        return;
    L17:
        if (f2058k == true) goto L19;
        q();
    L19:
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "onPeriod: " + r16.name() + r11, 1, null);
        s(r16, r17);
        r13.c();
        r12.monitorEnd(r16.name() + r11, true);
        r12.monitorCosTime("onPeriod-" + r16.name() + r11, System.currentTimeMillis() - r10, true);
        return;
    L5:
        r11 = "-START";
        goto L7
    }

    public final void p(boolean r10) {
        f2065r = r10;
    }

    public final void r() {
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "startPrivacyTask", 1, null);
        g.a(InitTaskDispatcher$startPrivacyTask$1.INSTANCE);
    }

    @Override // java.lang.Runnable
    public void run() {
    L2:
        h r10 = f2054g;
        m3.g r11 = h.k(r10, null, 1, null);
        if (r11 == null) goto L24;
        if (com.bytedance.lego.init.util.e.b(r11) == true) goto L22;
        if (com.bytedance.lego.init.util.e.a(r11) == false) goto L22;
        a r12 = new a(r11);
        if (r11.f11033k == false) goto L14;
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L14;
        f2066s.add(r12);
        com.bytedance.lego.init.util.c r13 = com.bytedance.lego.init.util.c.f2121a;
        StringBuilder r14 = new StringBuilder();
        r14.append(r11.f11028c);
        String r15 = " skip directly.";
    L23:
        r14.append(r15);
        com.bytedance.lego.init.util.c.b(r13, null, r14.toString(), 1, null);
        r10.i(r11);
    L14:
        i().execute(r12);
        Object r16 = f2064q;
        monitor-enter(r16);
        f2063p.add(r12);     // Catch: Throwable -> L19
        monitor-exit(r16);
    L19:
        th = move-exception;
        throw th;
    L22:
        r13 = com.bytedance.lego.init.util.c.f2121a;
        r14 = new StringBuilder();
        r14.append(r11.f11028c);
        r15 = " complete directly.";
        goto L23
    L24:
        com.bytedance.lego.init.util.c.g(com.bytedance.lego.init.util.c.f2121a, null, "异步调度线程 end.", 1, null);
    }
}
