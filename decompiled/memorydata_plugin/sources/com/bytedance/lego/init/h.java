package com.bytedance.lego.init;

import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0003J\u0006\u0010(\u001a\u00020$J\b\u0010)\u001a\u00020$H\u0002J\u0018\u0010*\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0007J\b\u0010+\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020$H\u0003J\u0018\u00103\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/lego/init/InitTaskDispatcher;", "Ljava/lang/Runnable;", "()V", "TAG", "", "allPeriods", "", "Lcom/bytedance/lego/init/model/InitPeriod;", "asyncStarted", "", "dispatchThread", "Ljava/lang/Thread;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor$delegate", "Lkotlin/Lazy;", "hasNoneTask", "getHasNoneTask$initscheduler_release", "()Z", "setHasNoneTask$initscheduler_release", "(Z)V", "initTaskCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "inited", "lastUITaskEnd", "", "nonUITaskList", "Lcom/bytedance/lego/init/ReadyTask;", "nonUITaskListLock", "", "periodDoneList", "taskManager", "Lcom/bytedance/lego/init/InitTaskManager;", "beforeSendMonitor", "", "checkPeriod", TypedValues.CycleType.S_WAVE_PERIOD, "isPeriodEnd", CommonConsts.APM_INNER_EVENT_COST_INIT, "initInternal", "onPeriod", "run", "runTask", "taskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "sendPeriodTimeoutException", "sendTaskTimeoutException", "task", "startAsyncTask", "takeTaskInMainThread", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f2770b = null;
    private static final i c = null;
    private static Thread d;
    private static final Lazy e = null;
    private static boolean f;
    private static boolean g;
    private static final CountDownLatch h = null;
    private static final List<InitPeriod> i = null;
    private static final List<InitPeriod> j = null;
    private static long k;
    private static final List<k> l = null;
    private static final Object m = null;
    private static boolean n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"com/bytedance/lego/init/InitTaskDispatcher$run$runnable$1", "Lcom/bytedance/lego/init/ReadyTask;", "initTaskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "getInitTaskInfo", "()Lcom/bytedance/lego/init/model/InitTaskInfo;", "setInitTaskInfo", "(Lcom/bytedance/lego/init/model/InitTaskInfo;)V", "run", "", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.lego.init.model.b f2771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.lego.init.model.b f2772b;

        a(com.bytedance.lego.init.model.b r1) {
            this.f2771a = r1;
            this.f2772b = r1;
        }

        @Override // com.bytedance.lego.init.k
        public com.bytedance.lego.init.model.b a() {
            return this.f2772b;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a(h.f2770b, a());
        }
    }

    static {
        f2769a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(h.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;")), KProperty.class, "com.obric.memorydata.plugin")};
        f2770b = new h();
        c = new i();
        e = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) ZeusTransformUtils.preCheckCast(InitTaskDispatcher$executor$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        h = new CountDownLatch(1);
        i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        j = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        l = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        m = new Object();
    }

    private h() {
    }

    public static final /* synthetic */ i a(h r0) {
        return c;
    }

    public static final /* synthetic */ void a(h r0, com.bytedance.lego.init.model.b r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(h r0, boolean r1) {
        f = r1;
    }

    private final void a(InitPeriod r6) {
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L9
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(c.b(r6.name() + "_END"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.append(((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) + ' ');     // Catch: Exception -> L9
        goto L5
    L7:
        InitMonitor r2 = InitMonitor.INSTANCE;     // Catch: Exception -> L9
        Category r3 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L9
        String r7 = r6.name();     // Catch: Exception -> L9
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("dependencyTasks", r0.toString());     // Catch: Exception -> L9
        r2.monitorEvent(r3, r7, r4);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "sendPeriodTimeoutException");
    }

    private final void a(com.bytedance.lego.init.model.b r6) {
        InitMonitor r5 = InitMonitor.INSTANCE;
        String r0 = r6.f2783a;
        Intrinsics.checkExpressionValueIsNotNull(r0, "task.taskId");
        r5.onTaskTimeout(r0);
        InitMonitor r7 = InitMonitor.INSTANCE;
        Category r1 = Category.TASK_TIMEOUT_EXCEPTION;
        String r2 = r6.f2783a;
        Intrinsics.checkExpressionValueIsNotNull(r2, "task.taskId");
        JSONObject r3 = new JSONObject();
        r3.put("startTime", r6.l);
        r3.put("curTime", System.currentTimeMillis());
        r7.monitorEvent(r1, r2, r3);
    }

    public static final /* synthetic */ CountDownLatch b(h r0) {
        return h;
    }

    private final void b(com.bytedance.lego.init.model.b r12) {
        boolean r0 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        com.bytedance.lego.init.util.d.a(com.bytedance.lego.init.util.d.f2800a, null, "TaskStart - " + r12 + "  isUIThread:" + r0, 1, null);
        long r1 = System.currentTimeMillis();
        r12.l = r1;
        InitMonitor.INSTANCE.monitorTaskStart(r12, r0);
        com.bytedance.lego.init.util.g.f2802a.a(r12);
    L12:
        e = move-exception;
        com.bytedance.lego.init.util.d r6 = com.bytedance.lego.init.util.d.f2800a;
        StringBuilder r7 = new StringBuilder().append("\nerror!error!error! ").append(r12.f2783a).append(" run error.\n ");
        e.printStackTrace();
        r6.c("InitTaskDispatcher", r7.append(Unit.INSTANCE).append(" \n").toString());
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L16;
    L20:
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "RUN_TASK_EXCEPTION:" + r12.c);
        InitMonitor r8 = InitMonitor.INSTANCE;
        Category r9 = Category.RUN_TAK_EXCEPTION;
        String r10 = r12.c + ParameterizedMessage.ERROR_MSG_SEPARATOR + e.getClass().getName();
        JSONObject r11 = new JSONObject();
        r11.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r8.monitorEvent(r9, r10, r11);
    L21:
        com.bytedance.lego.init.util.g.f2802a.a();
        InitMonitor.INSTANCE.monitorTaskEnd(r12, r0);
        long r5 = System.currentTimeMillis();
        r12.m = r5;
        InitMonitor.INSTANCE.monitorCosTime(r12, r5 - r1, r0);
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "Task " + r12.f2783a + " done. cos " + (System.currentTimeMillis() - r1) + "ms.", 1, null);
        c.a(r12);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(e, ClassNotFoundException.class) == true) goto L20;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L4:
        if (r12.d == null) goto L7;
        IInitTask r13 = r12.d;     // Catch: Exception -> L12
    L6:
        r13.run();     // Catch: Exception -> L12
        goto L21
    L7:
        Object r14 = ZeusTransformUtils.forName(r12.c, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L12
        if (r14 == null) goto L11;
        r13 = (IInitTask) ZeusTransformUtils.preCheckCast(r14, IInitTask.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        goto L6
    L11:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L12
    }

    private final boolean b(InitPeriod r7, boolean r8) {
        List<InitPeriod> r6 = i;
        if (r6.contains(r7) == false) goto L5;
        return false;
    L5:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r9.hasNext() == false) goto L14;
        Object r0 = r9.next();
        if (((InitPeriod) ZeusTransformUtils.preCheckCast(r0, InitPeriod.class, "com.obric.memorydata.plugin")).getValue() < r7.getValue()) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
    L16:
        if (((InitPeriod) ZeusTransformUtils.preCheckCast(r0, InitPeriod.class, "com.obric.memorydata.plugin")) == null) goto L18;
        return false;
    L18:
        if (r8 == false) goto L20;
        i.add(r7);
    L20:
        return true;
    L11:
        r4 = false;
        goto L12
    L14:
        r0 = null;
        goto L16
    }

    private final ThreadPoolExecutor c() {
        Lazy r2 = e;
        KProperty r0 = f2769a[0];
        return (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2.getValue(), ThreadPoolExecutor.class, "com.obric.memorydata.plugin");
    }

    private final void c(InitPeriod r14, boolean r15) {
    L3:
        if (j.contains(r14) == true) goto L101;
        com.bytedance.lego.init.model.b r4 = c.a(0);
        if (r15 == false) goto L56;
        if (r4 != null) goto L31;
        k r5 = (k) ZeusTransformUtils.preCheckCast(null, k.class, "com.obric.memorydata.plugin");
        Object r6 = m;
        monitor-enter(r6);
        Iterator<k> r7 = l.iterator();     // Catch: Throwable -> L28
    L12:
        if (r7.hasNext() == false) goto L22;
        k r8 = (k) ZeusTransformUtils.preCheckCast(r7.next(), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        i r9 = c;     // Catch: Throwable -> L28
        String r10 = r8.a().f2783a;     // Catch: Throwable -> L28
        Intrinsics.checkExpressionValueIsNotNull(r10, "runnable.initTaskInfo.taskId");     // Catch: Throwable -> L28
        float r11 = r9.c(r10);     // Catch: Throwable -> L28
        if (r11 <= 0) goto L12;
        InitPeriod r12 = r8.a().k;     // Catch: Throwable -> L28
        Intrinsics.checkExpressionValueIsNotNull(r12, "runnable.initTaskInfo.endPeriod");     // Catch: Throwable -> L28
        if (r12.getValue() > r14.getValue()) goto L12;
        if (r11 <= r9.c(r14.name() + "_END")) goto L12;
        r7.remove();     // Catch: Throwable -> L28
        if (f2770b.c().remove((Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.memorydata.plugin")) == false) goto L12;
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "execute async-task:" + r8.a().f2783a + " in UIThread.", 1, null);     // Catch: Throwable -> L28
        r5 = r8;
    L22:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r6);
        if (r5 == null) goto L26;
        r5.run();
        k = System.currentTimeMillis();
    L26:
        if (r5 != null) goto L31;
        r4 = c.a(r14);
    L28:
        th = move-exception;
        throw th;
    L31:
        if (r4 != null) goto L54;
        h r16 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin");
        if ((System.currentTimeMillis() - k) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L53;
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "UIThread wait timeout.", 1, null);
        f2770b.a(r14);
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(c.b(r14.name() + "_END"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L47
    L38:
        if (r17.hasNext() == false) goto L53;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L47
        i r19 = c;     // Catch: Exception -> L47
        com.bytedance.lego.init.model.b r20 = r19.a(r18);     // Catch: Exception -> L47
        if (r20 == null) goto L38;
        long r21 = System.currentTimeMillis() - r20.l;     // Catch: Exception -> L47
        if (r20.l <= 0) goto L38;
        if (r21 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L38;
        r19.a(r20);     // Catch: Exception -> L47
        f2770b.a(r20);     // Catch: Exception -> L47
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "Task " + r20.f2783a + " timeout, is forced to complete.", 1, null);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L52;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "letTimeoutTaskCompele");
        goto L53
    L52:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L53:
        Unit r0 = Unit.INSTANCE;
    L54:
        if (r4 == null) goto L3;
    L57:
        long r1 = System.currentTimeMillis();
        if (com.bytedance.lego.init.util.e.a(r4) == false) goto L60;
    L63:
        com.bytedance.lego.init.util.g.f2802a.a(r4);
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, r4.f2783a + " complete directly. cos " + (System.currentTimeMillis() - r1) + "ms", 1, null);
        c.a(r4);
        com.bytedance.lego.init.util.g.f2802a.a();
        if (com.bytedance.lego.init.util.e.a(r4) == true) goto L66;
    L68:
        k = System.currentTimeMillis();
        goto L3
    L66:
        if (Intrinsics.areEqual(r14.name() + "_END", r4.f2783a) == false) goto L68;
        InitMonitor.INSTANCE.monitorCosTime("wait: " + r14.name(), System.currentTimeMillis() - k, true);
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "wait: " + r14.name() + ' ' + (System.currentTimeMillis() - k) + "ms.", 1, null);
        j.add(r14);
        return;
    L60:
        if (com.bytedance.lego.init.util.e.b(r4) == false) goto L63;
        b(r4);
        goto L68
    L56:
        if (r4 != null) goto L57;
        return;
    }

    private final void d() {
        long r0 = System.currentTimeMillis();
        if (com.bytedance.lego.init.util.d.f2800a.a() == false) goto L5;
        com.bytedance.lego.init.util.d.f2800a.a("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " start");
    L5:
        InitMonitor.INSTANCE.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        com.bytedance.lego.init.util.g.f2802a.a("InitTaskDispatcher.initInternal");
        h r7 = f2770b;
        a(r7).a();
        a(r7, true);
        b(r7).countDown();
        Unit r8 = Unit.INSTANCE;
        com.bytedance.lego.init.util.g.f2802a.b();
        InitMonitor.INSTANCE.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        InitMonitor.INSTANCE.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - r0, false);
        if (com.bytedance.lego.init.util.d.f2800a.a() == false) goto L9;
        com.bytedance.lego.init.util.d.f2800a.b("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " done. cos: " + (System.currentTimeMillis() - r0) + "ms.");
        return;
    }

    private final void e() {
        com.bytedance.lego.init.util.d.f2800a.b("InitTaskDispatcher", "startAsyncTask");
        com.bytedance.lego.init.util.g.f2802a.a("startAsyncTask");
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));
        d = r0;
        if (r0 == null) goto L5;
        r0.start();
    L5:
        g = true;
        com.bytedance.lego.init.util.g.f2802a.b();
    }

    public final void a() {
        if (f == false) goto L5;
        return;
    L5:
        d();
    }

    public final void a(InitPeriod r13, boolean r14) {
        Intrinsics.checkParameterIsNotNull(r13, TypedValues.CycleType.S_WAVE_PERIOD);
        long r0 = System.currentTimeMillis();
        if (r14 == false) goto L5;
        String r2 = "-END";
    L7:
        if (b(r13, r14) == true) goto L9;
        return;
    L9:
        InitMonitor.INSTANCE.monitorStart(r13.name() + r2, true);
        com.bytedance.lego.init.util.g.f2802a.a("onPeriod-" + r13.name() + r2);
        if (f == true) goto L13;
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "wait init countdownlatch " + r13.name(), 1, null);
        long r7 = System.currentTimeMillis();
        h.await();
        InitMonitor.INSTANCE.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r7, true);
        com.bytedance.lego.init.util.d.f2800a.b("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r7));
    L13:
        if (n == false) goto L17;
        com.bytedance.lego.init.util.d.c(com.bytedance.lego.init.util.d.f2800a, null, "No task.", 1, null);
        return;
    L17:
        if (g == true) goto L19;
        e();
    L19:
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "onPeriod: " + r13.name() + r2, 1, null);
        c(r13, r14);
        com.bytedance.lego.init.util.g.f2802a.b();
        InitMonitor.INSTANCE.monitorEnd(r13.name() + r2, true);
        InitMonitor.INSTANCE.monitorCosTime("onPeriod-" + r13.name() + r2, System.currentTimeMillis() - r0, true);
        return;
    L5:
        r2 = "-START";
        goto L7
    }

    public final void a(boolean r1) {
        n = r1;
    }

    public final void b() {
        c.b();
    }

    @Override // java.lang.Runnable
    public void run() {
    L2:
        i r0 = c;
        com.bytedance.lego.init.model.b r3 = i.a(r0, null, 1, null);
        if (r3 == null) goto L18;
        if (com.bytedance.lego.init.util.e.a(r3) == true) goto L17;
        if (com.bytedance.lego.init.util.e.b(r3) == false) goto L17;
        a r1 = new a(r3);
        c().execute((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin"));
        Object r2 = m;
        monitor-enter(r2);
        l.add(r1);     // Catch: Throwable -> L14
        monitor-exit(r2);
    L14:
        th = move-exception;
        throw th;
    L17:
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, r3.f2783a + " complete directly.", 1, null);
        r0.a(r3);
        goto L2
    L18:
        com.bytedance.lego.init.util.d.a(com.bytedance.lego.init.util.d.f2800a, null, "异步调度线程 end.", 1, null);
    }
}
