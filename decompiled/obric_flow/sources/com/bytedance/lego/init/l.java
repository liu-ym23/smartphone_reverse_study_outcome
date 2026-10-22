package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f6742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InitTaskManager f6743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f6744c = null;
    public static boolean d;
    public static boolean e;
    public static final CountDownLatch f = null;
    public static final ArrayList g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayList f6745h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArrayList f6746i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f6747j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f6748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CopyOnWriteArrayList f6749l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l f6750m = null;

    static {
        f6742a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f6750m = new l();
        f6743b = new InitTaskManager();
        f6744c = LazyKt.lazy(LazyThreadSafetyMode.NONE, InitTaskDispatcher$executor$2.INSTANCE);
        f = new CountDownLatch(1);
        g = new ArrayList();
        f6745h = new ArrayList();
        f6746i = new ArrayList();
        f6747j = new Object();
        f6749l = new CopyOnWriteArrayList();
        new Handler(Looper.getMainLooper());
    }

    public final void a(InitPeriod r13, boolean r14) {
        long r5 = System.currentTimeMillis();
        if (r14 == false) goto L5;
        String r10 = "-END";
    L6:
        ArrayList r11 = g;
        if (r11.contains(r13) == true) goto L114;
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        Object r15 = r12.next();
        if (((InitPeriod) r15).getValue() < r13.getValue()) goto L11;
    L17:
        if (((InitPeriod) r15) == null) goto L19;
        return;
    L19:
        if (r14 == false) goto L21;
        r11.add(r13);
    L21:
        InitMonitor r16 = InitMonitor.INSTANCE;
        r16.monitorStart(r13.name() + r10, true);
        String r17 = "onPeriod-" + r13.name() + r10;
        InitScheduler r18 = InitScheduler.INSTANCE;
        if (r18.isDebug$initscheduler_release() == false) goto L26;
        TraceCompat.beginSection("Task:" + r17);
    L26:
        if (d == true) goto L29;
        com.bytedance.lego.init.util.b.b("wait init countdownlatch " + r13.name());
        long r19 = System.currentTimeMillis();
        f.await();
        r16.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r19, true);
        com.bytedance.lego.init.util.b.a("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r19));
    L29:
        if (f6748k == false) goto L33;
        Log.e("#inittask#", " No task.");
        return;
    L33:
        if (e == true) goto L42;
        com.bytedance.lego.init.util.b.a("InitTaskDispatcher", "startAsyncTask");
        if (r18.isDebug$initscheduler_release() == false) goto L38;
        TraceCompat.beginSection("Task:startAsyncTask");
    L38:
        new Thread(this).start();
        e = true;
        if (r18.isDebug$initscheduler_release() == false) goto L42;
        TraceCompat.endSection();
    L42:
        com.bytedance.lego.init.util.b.b("onPeriod: " + r13.name() + r10);
    L44:
        if (f6745h.contains(r13) == true) goto L92;
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        if (r14 == false) goto L90;
        InitTaskManager r20 = f6743b;
        r20.takeUiTaskIfExist(0);
        r110.element = null;
        Object r21 = f6747j;
        monitor-enter(r21);
        Iterator r22 = f6746i.iterator();     // Catch: Throwable -> L81
        if (r22.hasNext() == true) goto L84;
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(r21);
        r20.takeNonUiTaskMainThreadIfExist(r13);
        r110.element = null;
        if (System.currentTimeMillis() < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L76;
        com.bytedance.lego.init.util.b.b("UIThread wait timeout.");
        f6750m.getClass();
        StringBuilder r24 = new StringBuilder();     // Catch: Exception -> L61
        Iterator<T> r25 = r20.getTaskDependencyById(r13.name() + "_END").iterator();     // Catch: Exception -> L61
    L59:
        if (r25.hasNext() == false) goto L63;
        r24.append(((String) r25.next()) + ' ');     // Catch: Exception -> L61
        goto L59
    L63:
        InitMonitor r26 = InitMonitor.INSTANCE;     // Catch: Exception -> L61
        Category r27 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L61
        String r28 = r13.name();     // Catch: Exception -> L61
        JSONObject r29 = new JSONObject();     // Catch: Exception -> L61
        r29.put("dependencyTasks", r24.toString());     // Catch: Exception -> L61
        r26.monitorEvent(r27, r28, r29);     // Catch: Exception -> L61
    L99:
        Iterator<T> r30 = f6743b.getTaskDependencyById(r13.name() + "_END").iterator();     // Catch: Exception -> L71
    L68:
        if (r30.hasNext() == false) goto L76;
        f6743b.getInitTaskInfoById((String) r30.next());     // Catch: Exception -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L75;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "letTimeoutTaskCompele");
        goto L76
    L75:
        throw e;
    L61:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere(e, "sendPeriodTimeoutException");
    L76:
        Unit r31 = Unit.INSTANCE;
        if (r110.element == 0) goto L44;
        throw new ClassCastException();
    L84:
        if (r22.next() != null) goto L87;
        throw null;     // Catch: Throwable -> L81
    L87:
        throw new ClassCastException();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    L90:
        f6743b.takeUiTaskIfExist(0);
    L92:
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L95;
        TraceCompat.endSection();
    L95:
        InitMonitor r111 = InitMonitor.INSTANCE;
        r111.monitorEnd(r13.name() + r10, true);
        r111.monitorCosTime("onPeriod-" + r13.name() + r10, System.currentTimeMillis() - r5, true);
        return;
    L15:
        r15 = null;
        goto L17
    L114:
        return;
    L5:
        r10 = "-START";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        InitTaskManager.takeNonUiTaskIfExist$default(f6743b, null, 1, null);
        com.bytedance.lego.init.util.b.c("", "异步调度线程 end.");
    }
}
