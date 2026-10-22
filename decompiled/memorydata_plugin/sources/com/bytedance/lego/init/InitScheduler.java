package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\r\u0010\u0016\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0013H\u0007J\b\u0010\"\u001a\u00020\u0013H\u0007J\r\u0010#\u001a\u00020\u0015H\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0013H\u0007J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u000fH\u0007J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000fH\u0007J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0012H\u0007J\u0010\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u000202H\u0007J\b\u00103\u001a\u00020\u0013H\u0007J\b\u00104\u001a\u00020\u0013H\u0007J\r\u00105\u001a\u00020\u0013H\u0001¢\u0006\u0002\b6J\r\u00107\u001a\u00020\u0013H\u0001¢\u0006\u0002\b8R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "()V", "INIT_SCHEDULER_CATEGORY", "", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "config", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "splashActivityWR", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "enableCatchException", "", "getExecutorService", "getExecutorService$initscheduler_release", "getExecutorServiceOrNull", "getExecutorServiceOrNull$initscheduler_release", "getMainActivity", "getMainActivity$initscheduler_release", "getProcessMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "getSplashActivity", "getSplashActivity$initscheduler_release", "initPeriodTask", "initTasks", "isDebug", "isDebug$initscheduler_release", "onFeedShow", "onPeriodEnd", TypedValues.CycleType.S_WAVE_PERIOD, "Lcom/bytedance/lego/init/model/InitPeriod;", "onPeriodStart", "registerMainActivity", "mainActivity", "registerSplashActivity", "splashActivity", "setExecutorService", "executor", "setServiceManagerProxy", "proxy", "Lcom/bytedance/lego/init/IServiceManagerProxy;", "startDispatchDelayTask", "startDispatchIdleTask", "unRegisterMainActivity", "unRegisterMainActivity$initscheduler_release", "unRegisterSplashActivity", "unRegisterSplashActivity$initscheduler_release", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
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
    public static final void config(TaskConfig r3) {
        Intrinsics.checkParameterIsNotNull(r3, "config");
        config = r3;
        d.f2763a.a(r3.getIdleTaskConfig());
        com.bytedance.lego.init.monitor.c.f2794b.a(r3.getApplicationStartTime());
    }

    @JvmStatic
    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final void initPeriodTask() {
        com.bytedance.lego.init.util.g.f2802a.a("initPeriodTask");
        j.f2775a.a();
        Unit r0 = Unit.INSTANCE;
        com.bytedance.lego.init.util.g.f2802a.b();
    }

    @JvmStatic
    public static final void initTasks() {
        com.bytedance.lego.init.util.g.f2802a.a("initTasks");
        h.f2770b.a();
        Unit r0 = Unit.INSTANCE;
        com.bytedance.lego.init.util.g.f2802a.b();
    }

    @JvmStatic
    public static final void onFeedShow() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        b.f2758a.a();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void onPeriodEnd(InitPeriod r8) {
        Intrinsics.checkParameterIsNotNull(r8, TypedValues.CycleType.S_WAVE_PERIOD);
        h.f2770b.a(r8, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r1 = InitMonitor.INSTANCE;
        Category r2 = Category.ON_PERIOD_EXCEPTION;
        String r3 = r8.name();
        JSONObject r4 = new JSONObject();
        r4.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r1.monitorEvent(r2, r3, r4);
        TaskConfig r5 = config;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        if (r5.getCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "ON_PERIOD_EXCEPTION:" + r8.name());
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void onPeriodStart(InitPeriod r9) {
        Intrinsics.checkParameterIsNotNull(r9, TypedValues.CycleType.S_WAVE_PERIOD);
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        h.f2770b.a(r9, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r2 = InitMonitor.INSTANCE;
        Category r3 = Category.ON_PERIOD_EXCEPTION;
        String r4 = r9.name();
        JSONObject r5 = new JSONObject();
        r5.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r2.monitorEvent(r3, r4, r5);
        TaskConfig r6 = config;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L13:
        if (r6.getCatchException() == false) goto L17;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "ON_PERIOD_EXCEPTION:" + r9.name());
        return;
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void registerMainActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "mainActivity");
        mainActivityWR = new WeakReference(r4);
        Lifecycle r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, LifecycleOwner.class) == true) goto L5;
        r4 = null;
    L5:
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        r2 = r5.getLifecycle();
    L8:
        if (r2 == null) goto L12;
        j.f2775a.a(r2);
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("mainActivity must be LifecycleOwner."), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "splashActivity");
        splashActivityWR = new WeakReference(r4);
        Lifecycle r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, LifecycleOwner.class) == true) goto L5;
        r4 = null;
    L5:
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        r2 = r5.getLifecycle();
    L8:
        if (r2 == null) goto L12;
        j.f2775a.b(r2);
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("splashActivity must be LifecycleOwner."), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor r1) {
        Intrinsics.checkParameterIsNotNull(r1, "executor");
        taskExecutor = r1;
    }

    @JvmStatic
    public static final void setServiceManagerProxy(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "proxy");
        l.f2777a.a(r3);
    }

    @JvmStatic
    public static final void startDispatchDelayTask() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        a.f2755a.b();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "START_DELAY_TASK_DISPATCHER");
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void startDispatchIdleTask() {
        d.f2763a.c();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "START_IDLE_TASK_DISPATCHER");
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r1 = config;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r1.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r1 = config;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        return r1;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L7;
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r1;
    L7:
        TaskConfig r2 = config;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        ThreadPoolExecutor r3 = r2.getTaskExecutor();
        if (r3 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r3;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L13;
        return r1;
    L13:
        TaskConfig r2 = config;     // Catch: Exception -> L10
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L10
    L8:
        return r2.getTaskExecutor();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r1 = config;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r1.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r1 = config;     // Catch: Exception -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L7
    L5:
        return r1.isDebug();
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final void setConfig$initscheduler_release(TaskConfig r1) {
        Intrinsics.checkParameterIsNotNull(r1, "<set-?>");
        config = r1;
    }
}
