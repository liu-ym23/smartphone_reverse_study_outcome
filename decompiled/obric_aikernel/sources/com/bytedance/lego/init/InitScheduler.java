package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0004H\u0001¢\u0006\u0004\b!\u0010\u001fJ\b\u0010#\u001a\u00020\u0004H\u0007J\u000f\u0010'\u001a\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010*\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0011\u0010,\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b+\u0010)J\u000f\u00100\u001a\u00020-H\u0000¢\u0006\u0004\b.\u0010/J\u0006\u00101\u001a\u00020$R\u0018\u00102\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010=\u001a\u00020<8\u0000@\u0000X\u0080D¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010;¨\u0006C"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "Lcom/bytedance/lego/init/config/TaskConfig;", "config", "", "Lcom/bytedance/lego/init/e;", "proxy", "setServiceManagerProxy", "initTasks", "initPeriodTask", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "Lcom/bytedance/lego/init/model/InitPeriod;", TypedValues.CycleType.S_WAVE_PERIOD, "onPeriodStart", "onPeriodEnd", "startDispatchDelayTask", "startDispatchIdleTask", "onFeedShow", "Landroid/app/Activity;", "mainActivity", "registerMainActivity", "splashActivity", "registerSplashActivity", "getMainActivity$initscheduler_release", "()Landroid/app/Activity;", "getMainActivity", "getSplashActivity$initscheduler_release", "getSplashActivity", "unRegisterMainActivity$initscheduler_release", "()V", "unRegisterMainActivity", "unRegisterSplashActivity$initscheduler_release", "unRegisterSplashActivity", "afterPrivacyPopupWindow", "", "isDebug$initscheduler_release", "()Z", "isDebug", "getExecutorService$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutorService", "getExecutorServiceOrNull$initscheduler_release", "getExecutorServiceOrNull", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode", "enableCatchException", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "Ljava/lang/ref/WeakReference;", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "", "INIT_SCHEDULER_CATEGORY", "Ljava/lang/String;", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "splashActivityWR", "<init>", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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
        InitTaskDispatcher.f2068u.r();     // Catch: Exception -> L4
    L8:
        TaskConfig r10 = config;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L11:
        r10.setAgreePrivacyPopupWindow(true);
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
    public static final void config(TaskConfig r10) {
        Intrinsics.checkParameterIsNotNull(r10, "config");
        config = r10;
        IdleTaskDispatcher.f2047i.f(r10.getIdleTaskConfig());
        IdleTaskMonitor.f2107e.l(r10.getApplicationStartTime());
    }

    @JvmStatic
    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r10 = mainActivityWR;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r10 = splashActivityWR;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    @JvmStatic
    public static final void initPeriodTask() {
        com.bytedance.lego.init.util.f r10 = com.bytedance.lego.init.util.f.f2123a;
        r10.a("initPeriodTask");
        PeriodTaskManager.f2076d.h();
        Unit r11 = Unit.INSTANCE;
        r10.c();
    }

    @JvmStatic
    public static final void initTasks() {
        com.bytedance.lego.init.util.f r10 = com.bytedance.lego.init.util.f.f2123a;
        r10.a("initTasks");
        InitTaskDispatcher.f2068u.j();
        Unit r11 = Unit.INSTANCE;
        r10.c();
    }

    @JvmStatic
    @UiThread
    public static final void onFeedShow() {
        TaskConfig r10 = config;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r10.isDebug();
        a.f2080d.d();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L13:
        throw e;
    }

    @JvmStatic
    @UiThread
    public static final void onPeriodEnd(InitPeriod r10) {
        Intrinsics.checkParameterIsNotNull(r10, TypedValues.CycleType.S_WAVE_PERIOD);
        InitTaskDispatcher.f2068u.l(r10, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r11 = InitMonitor.INSTANCE;
        Category r12 = Category.ON_PERIOD_EXCEPTION;
        String r13 = r10.name();
        JSONObject r14 = new JSONObject();
        r14.put("exception_detail", Log.getStackTraceString(e));
        r11.monitorEvent(r12, r13, r14);
        TaskConfig r15 = config;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        if (r15.getCatchException() == false) goto L13;
        r11.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r10.name());
        return;
    L13:
        throw e;
    }

    @JvmStatic
    @UiThread
    public static final void onPeriodStart(InitPeriod r10) {
        Intrinsics.checkParameterIsNotNull(r10, TypedValues.CycleType.S_WAVE_PERIOD);
        TaskConfig r11 = config;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r11.isDebug();
        InitTaskDispatcher.f2068u.l(r10, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r12 = InitMonitor.INSTANCE;
        Category r13 = Category.ON_PERIOD_EXCEPTION;
        String r14 = r10.name();
        JSONObject r15 = new JSONObject();
        r15.put("exception_detail", Log.getStackTraceString(e));
        r12.monitorEvent(r13, r14, r15);
        TaskConfig r16 = config;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L13:
        if (r16.getCatchException() == false) goto L16;
        r12.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r10.name());
        return;
    L16:
        throw e;
    }

    @JvmStatic
    public static final void registerMainActivity(Activity r10) {
        Intrinsics.checkParameterIsNotNull(r10, "mainActivity");
        mainActivityWR = new WeakReference(r10);
        boolean r11 = r10 instanceof LifecycleOwner;
        Lifecycle r12 = null;
        Object r13 = r10;
        if (r11 == true) goto L5;
        r13 = null;
    L5:
        LifecycleOwner r14 = (LifecycleOwner) r13;
        if (r14 == null) goto L8;
        r12 = r14.getLifecycle();
    L8:
        if (r12 == null) goto L12;
        PeriodTaskManager.f2076d.j(r12);
        return;
    L12:
        throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity r10) {
        Intrinsics.checkParameterIsNotNull(r10, "splashActivity");
        splashActivityWR = new WeakReference(r10);
        boolean r11 = r10 instanceof LifecycleOwner;
        Lifecycle r12 = null;
        Object r13 = r10;
        if (r11 == true) goto L5;
        r13 = null;
    L5:
        LifecycleOwner r14 = (LifecycleOwner) r13;
        if (r14 == null) goto L8;
        r12 = r14.getLifecycle();
    L8:
        if (r12 == null) goto L12;
        PeriodTaskManager.f2076d.k(r12);
        return;
    L12:
        throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor r10) {
        Intrinsics.checkParameterIsNotNull(r10, "executor");
        taskExecutor = r10;
    }

    @JvmStatic
    public static final void setServiceManagerProxy(e r10) {
        Intrinsics.checkParameterIsNotNull(r10, "proxy");
        j.f2093b.b(r10);
    }

    @JvmStatic
    @UiThread
    public static final void startDispatchDelayTask() {
        TaskConfig r10 = config;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r10.isDebug();
        DelayTaskDispatcher.f2036h.k();     // Catch: Exception -> L8
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
        IdleTaskDispatcher.f2047i.e();     // Catch: Exception -> L4
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
        WeakReference<Activity> r10 = mainActivityWR;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r10 = splashActivityWR;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r10 = config;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r10.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r10 = config;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        return r10;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r10 = taskExecutor;
        if (r10 == null) goto L7;
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r10;
    L7:
        TaskConfig r11 = config;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        ThreadPoolExecutor r12 = r11.getTaskExecutor();
        if (r12 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r12;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r10 = taskExecutor;
        if (r10 == null) goto L13;
        return r10;
    L13:
        TaskConfig r11 = config;     // Catch: Exception -> L10
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L10
    L8:
        return r11.getTaskExecutor();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r10 = config;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r10.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r10 = config;     // Catch: Exception -> L7
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L7
    L5:
        return r10.isDebug();
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final void setConfig$initscheduler_release(TaskConfig r10) {
        Intrinsics.checkParameterIsNotNull(r10, "<set-?>");
        config = r10;
    }
}
