package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001f\u0010\u001dJ\u0011\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b \u0010!J\u0011\u0010$\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b#\u0010!J\u000f\u0010&\u001a\u00020\u0006H\u0001¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0001¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H\u0007¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010-\u001a\u00020*H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0004\b.\u0010/J\u0011\u00102\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b1\u0010/J\u000f\u00106\u001a\u000203H\u0000¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u00020*¢\u0006\u0004\b7\u0010,R\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u0007R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0000X\u0080D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "<init>", "()V", "Lcom/bytedance/lego/init/config/TaskConfig;", "config", "", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "Lcom/bytedance/lego/init/f;", "proxy", "setServiceManagerProxy", "(Lcom/bytedance/lego/init/f;)V", "initTasks", "initPeriodTask", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "Lcom/bytedance/lego/init/model/InitPeriod;", "period", "onPeriodStart", "(Lcom/bytedance/lego/init/model/InitPeriod;)V", "onPeriodEnd", "startDispatchDelayTask", "startDispatchIdleTask", "onFeedShow", "Landroid/app/Activity;", "mainActivity", "registerMainActivity", "(Landroid/app/Activity;)V", "splashActivity", "registerSplashActivity", "getMainActivity$initscheduler_release", "()Landroid/app/Activity;", "getMainActivity", "getSplashActivity$initscheduler_release", "getSplashActivity", "unRegisterMainActivity$initscheduler_release", "unRegisterMainActivity", "unRegisterSplashActivity$initscheduler_release", "unRegisterSplashActivity", "afterPrivacyPopupWindow", "", "isDebug$initscheduler_release", "()Z", "isDebug", "getExecutorService$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutorService", "getExecutorServiceOrNull$initscheduler_release", "getExecutorServiceOrNull", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode", "enableCatchException", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "Ljava/lang/ref/WeakReference;", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "splashActivityWR", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "INIT_SCHEDULER_CATEGORY", "Ljava/lang/String;", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class InitScheduler {
    private static final String INIT_SCHEDULER_CATEGORY = "init_scheduler";
    public static final InitScheduler INSTANCE = null;
    public static TaskConfig config;
    private static WeakReference<Activity> mainActivityWR;
    private static WeakReference<Activity> splashActivityWR;
    private static ThreadPoolExecutor taskExecutor;

    static {
        INSTANCE = new InitScheduler();
        INIT_SCHEDULER_CATEGORY = "init_scheduler";
    }

    private InitScheduler() {
    }

    @JvmStatic
    public static final void afterPrivacyPopupWindow() {
        l.f6750m.getClass();     // Catch: Exception -> L4
        com.bytedance.lego.init.util.b.b("startPrivacyTask");     // Catch: Exception -> L4
        mh.e.t(InitTaskDispatcher$startPrivacyTask$1.INSTANCE);     // Catch: Exception -> L4
    L8:
        TaskConfig r5 = config;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L11:
        r5.setAgreePrivacyPopupWindow(true);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        goto L8
    L13:
        throw e;
    }

    @JvmStatic
    public static final void config(TaskConfig r5) {
        config = r5;
        IdleTaskConfig r10 = i.f6734a;
        IdleTaskConfig r11 = r5.getIdleTaskConfig();
        if (INSTANCE.getConfig$initscheduler_release().isMainProcess() == false) goto L8;
        i.g = false;
        i.f6734a = r11;
        if (r11.getAutoIdleTask() == false) goto L8;
        i.f.postDelayed(d.f6729c, i.f6734a.getBootFinishTimeOut());
    L8:
        com.bytedance.lego.init.monitor.c r12 = com.bytedance.lego.init.monitor.c.d;
        r5.getApplicationStartTime();
        r12.getClass();
        KProperty[] r13 = com.bytedance.lego.init.monitor.c.f6761a;
    }

    @JvmStatic
    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r5 = mainActivityWR;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.get();
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r5 = splashActivityWR;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.get();
    }

    @JvmStatic
    public static final void initPeriodTask() {
        InitScheduler r5 = INSTANCE;
        if (r5.isDebug$initscheduler_release() == false) goto L6;
        TraceCompat.beginSection("Task:initPeriodTask");
    L6:
        LinkedHashMap r10 = m.f6751a;
        if (o.d != null) goto L13;
        o.d = new ArrayList();
        ArrayList r11 = o.f6767a;
        r11.isEmpty();
        Iterator r12 = r11.iterator();
        if (r12.hasNext() == false) goto L13;
        throw androidx.constraintlayout.motion.widget.a.g(r12);
    L13:
        Iterator r13 = o.d.iterator();
        if (r13.hasNext() == true) goto L35;
        if (r5.isDebug$initscheduler_release() == false) goto L29;
        StringBuilder r14 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator r15 = m.f6751a.entrySet().iterator();
    L20:
        if (r15.hasNext() == false) goto L28;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (((Collection) r16.getValue()).isEmpty() == true) goto L20;
        r14.append(((ExecutionPeriod) r16.getKey()).name() + ": ");
        Iterator r17 = ((Iterable) r16.getValue()).iterator();
        if (r17.hasNext() == true) goto L27;
        r14.append("\n");
        goto L20
    L27:
        throw androidx.constraintlayout.motion.widget.a.g(r17);
    L28:
        com.bytedance.lego.init.util.b.a("PeriodTaskManager", r14.toString());
    L29:
        Unit r18 = Unit.INSTANCE;
        if (INSTANCE.isDebug$initscheduler_release() == false) goto L42;
        TraceCompat.endSection();
        return;
    L42:
        return;
    L35:
        throw androidx.constraintlayout.motion.widget.a.g(r13);
    }

    @JvmStatic
    public static final void initTasks() {
        InitScheduler r5 = INSTANCE;
        if (r5.isDebug$initscheduler_release() == false) goto L6;
        TraceCompat.beginSection("Task:initTasks");
    L6:
        l.f6750m.getClass();
        if (l.d == true) goto L23;
        long r10 = System.currentTimeMillis();
        if (r5.isDebug$initscheduler_release() == false) goto L12;
        com.bytedance.lego.init.util.b.c("InitTaskDispatcher", "InitTaskDispatcher.init start");
    L12:
        InitMonitor r11 = InitMonitor.INSTANCE;
        r11.monitorStart("InitTaskDispatcher.init", false);
        if (r5.isDebug$initscheduler_release() == false) goto L16;
        TraceCompat.beginSection("Task:InitTaskDispatcher.initInternal");
    L16:
        l.f6743b.init();
        l.d = true;
        l.f.countDown();
        Unit r12 = Unit.INSTANCE;
        if (r5.isDebug$initscheduler_release() == false) goto L20;
        TraceCompat.endSection();
    L20:
        r11.monitorEnd("InitTaskDispatcher.init", false);
        r11.monitorCosTime("InitTaskDispatcher.init", System.currentTimeMillis() - r10, false);
        if (r5.isDebug$initscheduler_release() == false) goto L23;
        com.bytedance.lego.init.util.b.a("InitTaskDispatcher", "InitTaskDispatcher.init done. cos: " + (System.currentTimeMillis() - r10) + "ms.");
    L23:
        Unit r13 = Unit.INSTANCE;
        if (r5.isDebug$initscheduler_release() == false) goto L28;
        TraceCompat.endSection();
        return;
    }

    @JvmStatic
    @UiThread
    public static final void onFeedShow() {
        TaskConfig r5 = config;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r5.isDebug();
        e r10 = e.f6733c;     // Catch: Exception -> L19
        monitor-enter(r10);     // Catch: Exception -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L9:
        if (e.f6732b == false) goto L13;
        monitor-exit(r10);     // Catch: Exception -> L19
        return;
    L13:
        e.f6732b = true;     // Catch: Throwable -> L16
        new Thread(d.f6728b, "A-FeedShowTaskDispatcher").start();     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L24;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L24:
        throw e;
    }

    @JvmStatic
    @UiThread
    public static final void onPeriodEnd(InitPeriod r10) {
        l.f6750m.a(r10, true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r5 = InitMonitor.INSTANCE;
        Category r11 = Category.ON_PERIOD_EXCEPTION;
        String r12 = r10.name();
        JSONObject r13 = new JSONObject();
        r13.put("exception_detail", Log.getStackTraceString(e));
        r5.monitorEvent(r11, r12, r13);
        TaskConfig r14 = config;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L9:
        if (r14.getCatchException() == false) goto L12;
        r5.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r10.name());
        return;
    L12:
        throw e;
    }

    @JvmStatic
    @UiThread
    public static final void onPeriodStart(InitPeriod r10) {
        TaskConfig r5 = config;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r5.isDebug();
        l.f6750m.a(r10, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r11 = InitMonitor.INSTANCE;
        Category r12 = Category.ON_PERIOD_EXCEPTION;
        String r13 = r10.name();
        JSONObject r14 = new JSONObject();
        r14.put("exception_detail", Log.getStackTraceString(e));
        r11.monitorEvent(r12, r13, r14);
        TaskConfig r15 = config;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L13:
        if (r15.getCatchException() == false) goto L16;
        r11.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r10.name());
        return;
    L16:
        throw e;
    }

    @JvmStatic
    public static final void registerMainActivity(Activity r5) {
        mainActivityWR = new WeakReference(r5);
        boolean r10 = r5 instanceof LifecycleOwner;
        Lifecycle r11 = null;
        Object r12 = r5;
        if (r10 == true) goto L5;
        r12 = null;
    L5:
        LifecycleOwner r13 = (LifecycleOwner) r12;
        if (r13 == null) goto L8;
        r11 = r13.getLifecycle();
    L8:
        if (r11 == null) goto L12;
        LinkedHashMap r14 = m.f6751a;
        r11.addObserver(new PeriodTaskManager$registerMain$1());
        return;
    L12:
        throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity r5) {
        splashActivityWR = new WeakReference(r5);
        boolean r10 = r5 instanceof LifecycleOwner;
        Lifecycle r11 = null;
        Object r12 = r5;
        if (r10 == true) goto L5;
        r12 = null;
    L5:
        LifecycleOwner r13 = (LifecycleOwner) r12;
        if (r13 == null) goto L8;
        r11 = r13.getLifecycle();
    L8:
        if (r11 == null) goto L12;
        LinkedHashMap r14 = m.f6751a;
        r11.addObserver(new PeriodTaskManager$registerSplash$1());
        return;
    L12:
        throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor r5) {
        taskExecutor = r5;
    }

    @JvmStatic
    public static final void setServiceManagerProxy(f r5) {
    }

    @JvmStatic
    @UiThread
    public static final void startDispatchDelayTask() {
        TaskConfig r5 = config;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r5.isDebug();
        c.f.c();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        return;
    L13:
        throw e;
    }

    @JvmStatic
    @UiThread
    public static final void startDispatchIdleTask() {
        IdleTaskConfig r5 = i.f6734a;     // Catch: Exception -> L4
        i.a();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L9;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_IDLE_TASK_DISPATCHER");
        return;
    L9:
        throw e;
    }

    @JvmStatic
    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> r5 = mainActivityWR;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r5 = splashActivityWR;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r5 = config;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r5.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r5 = config;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        return r5;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r5 = taskExecutor;
        if (r5 == null) goto L7;
        if (r5 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r5;
    L7:
        TaskConfig r10 = config;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        ThreadPoolExecutor r11 = r10.getTaskExecutor();
        if (r11 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r11;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r5 = taskExecutor;
        if (r5 == null) goto L14;
        return r5;
    L14:
        TaskConfig r10 = config;     // Catch: Exception -> L8
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L8
    L10:
        return r10.getTaskExecutor();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r5 = config;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r5.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r5 = config;     // Catch: Exception -> L5
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L5
    L7:
        return r5.isDebug();
    L5:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final void setConfig$initscheduler_release(TaskConfig r5) {
        config = r5;
    }
}
