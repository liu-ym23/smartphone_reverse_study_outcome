package com.obric.memorydata;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.obric.memorydata.init.tasks.SlowEntityIndexInitTask;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.memory.v;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.npth.NpthInit;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.obric.memorydata.plugin_api.service.MemoryForegroundService;
import com.obric.memorydata.utils.an;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tJ6\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0082\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/PluginLaunch;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "app", "Landroid/app/Application;", "disableDebugEntryIcon", "alwaysInit", "initScheduler", "base", "traceInitStep", LocationMonitorConst.TAG, "allowLogcat", "", "block", "Lkotlin/Function0;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f9869a = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/PluginLaunch$init$2", "Lcom/obric/aiagent/flow/applog/IRegisterIPCListener;", "onSuccess", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.aiagent.flow.applog.b {
        a() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            RunLog.INSTANCE.debug("PluginLaunch", "applog ipc onSuccess, did = " + AppContext.INSTANCE.getServerDeviceId());
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }
    }

    static {
        f9869a = new f();
    }

    private f() {
    }

    private static final void a() {
        InitScheduler.initTasks();
    }

    private final void b(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ZeusTransformUtils.setComponentEnabledSetting(r2.getPackageManager(), new ComponentName(r2, "com.obric.memorydata.plugin_api.stub.activity.DebugMainActivity"), 2, 1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("DebugMainActivity", "disable component failed: " + e.getMessage());
    }

    private final void c(Context r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        long r3 = SystemClock.uptimeMillis();
        com.obric.memorydata.middleware.impl.app.b.f11700a.a();     // Catch: Throwable -> L112
        long r5 = SystemClock.uptimeMillis() - r3;
        if (com.ss.android.agilelogger.a.a() == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=StrictModeMonitor, duration=" + r5, false, 4, null);
    L7:
        long r4 = SystemClock.uptimeMillis();
        StoreManager.INSTANCE.init(r15);     // Catch: Throwable -> L107
        long r6 = SystemClock.uptimeMillis() - r4;
        if (com.ss.android.agilelogger.a.a() == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=StoreManager, duration=" + r6, false, 4, null);
    L12:
        long r7 = SystemClock.uptimeMillis();
        com.obric.memorydata.personalcontext.c.f12047a.a();     // Catch: Throwable -> L102
        long r8 = SystemClock.uptimeMillis() - r7;
        if (com.ss.android.agilelogger.a.a() == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=AtomicCapability, duration=" + r8, false, 4, null);
    L18:
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L29;
        long r9 = SystemClock.uptimeMillis();
        com.obric.memorydata.init.tasks.d.f9920a.a();     // Catch: Throwable -> L24
        long r10 = SystemClock.uptimeMillis() - r9;
        if (com.ss.android.agilelogger.a.a() == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=PapayaSDK, duration=" + r10, false, 4, null);
    L24:
        th = move-exception;
        long r11 = SystemClock.uptimeMillis() - r9;
        if (com.ss.android.agilelogger.a.a() == false) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=PapayaSDK, duration=" + r11, false, 4, null);
    L28:
        throw th;
    L29:
        long r12 = SystemClock.uptimeMillis();
        com.obric.memorydata.datastorage.dataaging.manager.a.f9702a.a();     // Catch: Throwable -> L97
        long r13 = SystemClock.uptimeMillis() - r12;
        if (com.ss.android.agilelogger.a.a() == false) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=DataAgingManager, duration=" + r13, false, 4, null);
    L35:
        if (AppContext.INSTANCE.isDebug() == false) goto L46;
        long r16 = SystemClock.uptimeMillis();
        EvaluationService.INSTANCE.initFlavor();     // Catch: Throwable -> L41
        long r17 = SystemClock.uptimeMillis() - r16;
        if (com.ss.android.agilelogger.a.a() == false) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EvaluationService, duration=" + r17, false, 4, null);
    L41:
        th = move-exception;
        long r18 = SystemClock.uptimeMillis() - r16;
        if (com.ss.android.agilelogger.a.a() == false) goto L45;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EvaluationService, duration=" + r18, false, 4, null);
    L45:
        throw th;
    L46:
        long r19 = SystemClock.uptimeMillis();
        IslandRouter.f10185a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
        long r20 = SystemClock.uptimeMillis() - r19;
        if (com.ss.android.agilelogger.a.a() == false) goto L51;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=IslandRouter, duration=" + r20, false, 4, null);
    L51:
        long r21 = SystemClock.uptimeMillis();
        v.f11572a.a();     // Catch: Throwable -> L87
        long r22 = SystemClock.uptimeMillis() - r21;
        if (com.ss.android.agilelogger.a.a() == false) goto L56;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=MemoryManagerWrapper, duration=" + r22, false, 4, null);
    L56:
        long r23 = SystemClock.uptimeMillis();
        EntityManager.INSTANCE.checkIfReDonateEntityWhenLaunch();     // Catch: Throwable -> L82
        long r24 = SystemClock.uptimeMillis() - r23;
        if (com.ss.android.agilelogger.a.a() == false) goto L61;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EntityManager, duration=" + r24, false, 4, null);
    L61:
        long r25 = SystemClock.uptimeMillis();
        SlowEntityIndexInitTask.Companion.a();     // Catch: Throwable -> L77
        long r26 = SystemClock.uptimeMillis() - r25;
        if (com.ss.android.agilelogger.a.a() == false) goto L66;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=SlowEntityIndexInitTask, duration=" + r26, false, 4, null);
    L66:
        long r27 = SystemClock.uptimeMillis();
        EntityConsistencyCheckTask.Companion.init();     // Catch: Throwable -> L72
        long r28 = SystemClock.uptimeMillis() - r27;
        if (com.ss.android.agilelogger.a.a() == false) goto L139;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EntityConsistencyCheckTask, duration=" + r28, false, 4, null);
        return;
    L139:
        return;
    L72:
        th = move-exception;
        long r29 = SystemClock.uptimeMillis() - r27;
        if (com.ss.android.agilelogger.a.a() == false) goto L76;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EntityConsistencyCheckTask, duration=" + r29, false, 4, null);
    L76:
        throw th;
    L77:
        th = move-exception;
        long r30 = SystemClock.uptimeMillis() - r25;
        if (com.ss.android.agilelogger.a.a() == false) goto L81;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=SlowEntityIndexInitTask, duration=" + r30, false, 4, null);
    L81:
        throw th;
    L82:
        th = move-exception;
        long r31 = SystemClock.uptimeMillis() - r23;
        if (com.ss.android.agilelogger.a.a() == false) goto L86;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=EntityManager, duration=" + r31, false, 4, null);
    L86:
        throw th;
    L87:
        th = move-exception;
        long r32 = SystemClock.uptimeMillis() - r21;
        if (com.ss.android.agilelogger.a.a() == false) goto L91;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=MemoryManagerWrapper, duration=" + r32, false, 4, null);
    L91:
        throw th;
    L92:
        th = move-exception;
        long r33 = SystemClock.uptimeMillis() - r19;
        if (com.ss.android.agilelogger.a.a() == false) goto L96;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=IslandRouter, duration=" + r33, false, 4, null);
    L96:
        throw th;
    L97:
        th = move-exception;
        long r34 = SystemClock.uptimeMillis() - r12;
        if (com.ss.android.agilelogger.a.a() == false) goto L101;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=DataAgingManager, duration=" + r34, false, 4, null);
    L101:
        throw th;
    L102:
        th = move-exception;
        long r35 = SystemClock.uptimeMillis() - r7;
        if (com.ss.android.agilelogger.a.a() == false) goto L106;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=AtomicCapability, duration=" + r35, false, 4, null);
    L106:
        throw th;
    L107:
        th = move-exception;
        long r36 = SystemClock.uptimeMillis() - r4;
        if (com.ss.android.agilelogger.a.a() == false) goto L111;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=StoreManager, duration=" + r36, false, 4, null);
    L111:
        throw th;
    L112:
        th = move-exception;
        long r37 = SystemClock.uptimeMillis() - r3;
        if (com.ss.android.agilelogger.a.a() == false) goto L116;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=StrictModeMonitor, duration=" + r37, false, 4, null);
    L116:
        throw th;
    }

    private static final void d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        f9869a.b(r3);
    }

    public static /* synthetic */ void lambda$dE6u1oZV5vTK9jH1uCaxyD7rSQ4(Context r0) {
        d(r0);
    }

    public static /* synthetic */ void lambda$x4Sz3mI9KxUMbpx1EI9FCDJN5NY() {
        a();
    }

    public final void a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "base");
        String r4 = an.f13171a.a(r2);
        TaskConfig.Builder r5 = new TaskConfig.Builder(r2, Intrinsics.areEqual(r4, r2.getPackageName()), r4).isDebug(AppContext.INSTANCE.isAdminMode()).setTimeOut(60000);
        ThreadPoolExecutor r6 = ThreadPoolContainer.Companion.getInstance().getThreadPoolExecutor();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.util.concurrent.ThreadPoolExecutor");
        InitScheduler.config(r5.setExecutorService(r6).build());
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$f$x4Sz3mI9KxUMbpx1EI9FCDJN5NY.INSTANCE);
    }

    public final void a(Context r20, Application r21) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r21, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r4, "app");
        boolean r5 = com.obric.aiagent.product.b.f5974a.b().a("obric_feature_keep_alive_high_level");
        RunLog.INSTANCE.debug("PluginLaunch", "keepAliveHighLevel is " + r5);
        if (r5 == true) goto L5;
        MemoryForegroundService.syncShouldRun((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    L5:
        RunLog.INSTANCE.info("PluginLaunch", "buildInfo: " + AppContext.INSTANCE.getBuildInfo() + " channel: " + AppContext.INSTANCE.getChannel(), true);
        if (Intrinsics.areEqual(AppContext.INSTANCE.getChannel(), "auto_test") == false) goto L8;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$f$dE6u1oZV5vTK9jH1uCaxyD7rSQ4(r0));
    L8:
        NpthInit.clearNpthCrashFileIfTooLarge();
        if (r5 == false) goto L11;
        int r7 = 1;
    L12:
        com.obric.memorydata.utils.a.f13146a.a(r4, r7);
        com.obric.aiagent.flow.applog.a.f5912a.a(r0, (com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(new a(), com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin"), r7, 60000);
        com.obric.memorydata.middleware.api.app.f r6 = e.f9867a.a();
        long r8 = SystemClock.uptimeMillis();
        f r9 = f9869a;     // Catch: Throwable -> L78
        r9.a(r0);     // Catch: Throwable -> L78
        long r11 = SystemClock.uptimeMillis() - r8;
        if (com.ss.android.agilelogger.a.a() == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=initScheduler, duration=" + r11, false, 4, null);
    L18:
        long r10 = SystemClock.uptimeMillis();
        r6.a(InitPeriod.APP_ATTACHBASE2SUPER);     // Catch: Throwable -> L72
        long r12 = SystemClock.uptimeMillis() - r10;
        if (com.ss.android.agilelogger.a.a() == false) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_ATTACHBASE2SUPER, duration=" + r12, false, 4, null);
    L24:
        long r13 = SystemClock.uptimeMillis();
        r6.a(InitPeriod.APP_SUPER2ATTACHBASEEND);     // Catch: Throwable -> L66
        long r14 = SystemClock.uptimeMillis() - r13;
        if (com.ss.android.agilelogger.a.a() == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_SUPER2ATTACHBASEEND, duration=" + r14, false, 4, null);
    L30:
        long r15 = SystemClock.uptimeMillis();
        r6.a(InitPeriod.APP_ONCREATE2SUPER);     // Catch: Throwable -> L60
        long r16 = SystemClock.uptimeMillis() - r15;
        if (com.ss.android.agilelogger.a.a() == false) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_ONCREATE2SUPER, duration=" + r16, false, 4, null);
    L36:
        long r17 = SystemClock.uptimeMillis();
        r6.a(InitPeriod.APP_SUPER2ONCREATEEND);     // Catch: Throwable -> L54
        long r18 = SystemClock.uptimeMillis() - r17;
        if (com.ss.android.agilelogger.a.a() == false) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_SUPER2ONCREATEEND, duration=" + r18, false, 4, null);
    L42:
        long r19 = SystemClock.uptimeMillis();
        r9.c(r0);     // Catch: Throwable -> L49
        long r22 = SystemClock.uptimeMillis() - r19;
        if (com.ss.android.agilelogger.a.a() == false) goto L47;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=alwaysInit, duration=" + r22, false, 4, null);
    L47:
        RunLog.INSTANCE.debug("PluginLaunch", "plugin pkg = " + AppContext.INSTANCE.getPluginPkgName() + ", host pkg = " + AppContext.INSTANCE.getHostPkgName());
        return;
    L49:
        th = move-exception;
        long r23 = SystemClock.uptimeMillis() - r19;
        if (com.ss.android.agilelogger.a.a() == false) goto L96;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=alwaysInit, duration=" + r23, false, 4, null);
        throw th;
    L96:
        throw th;
    L41:
        Log.i("PluginLaunch", "init tag=APP_SUPER2ONCREATEEND, duration=" + r18);
    L54:
        th = move-exception;
        long r24 = SystemClock.uptimeMillis() - r17;
        if (com.ss.android.agilelogger.a.a() == false) goto L58;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_SUPER2ONCREATEEND, duration=" + r24, false, 4, null);
    L59:
        throw th;
    L58:
        Log.i("PluginLaunch", "init tag=APP_SUPER2ONCREATEEND, duration=" + r24);
        goto L59
    L35:
        Log.i("PluginLaunch", "init tag=APP_ONCREATE2SUPER, duration=" + r16);
    L60:
        th = move-exception;
        long r25 = SystemClock.uptimeMillis() - r15;
        if (com.ss.android.agilelogger.a.a() == false) goto L64;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_ONCREATE2SUPER, duration=" + r25, false, 4, null);
    L65:
        throw th;
    L64:
        Log.i("PluginLaunch", "init tag=APP_ONCREATE2SUPER, duration=" + r25);
        goto L65
    L29:
        Log.i("PluginLaunch", "init tag=APP_SUPER2ATTACHBASEEND, duration=" + r14);
    L66:
        th = move-exception;
        long r26 = SystemClock.uptimeMillis() - r13;
        if (com.ss.android.agilelogger.a.a() == false) goto L70;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_SUPER2ATTACHBASEEND, duration=" + r26, false, 4, null);
    L71:
        throw th;
    L70:
        Log.i("PluginLaunch", "init tag=APP_SUPER2ATTACHBASEEND, duration=" + r26);
        goto L71
    L23:
        Log.i("PluginLaunch", "init tag=APP_ATTACHBASE2SUPER, duration=" + r12);
    L72:
        th = move-exception;
        long r27 = SystemClock.uptimeMillis() - r10;
        if (com.ss.android.agilelogger.a.a() == false) goto L76;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=APP_ATTACHBASE2SUPER, duration=" + r27, false, 4, null);
    L77:
        throw th;
    L76:
        Log.i("PluginLaunch", "init tag=APP_ATTACHBASE2SUPER, duration=" + r27);
        goto L77
    L17:
        Log.i("PluginLaunch", "init tag=initScheduler, duration=" + r11);
    L78:
        th = move-exception;
        long r28 = SystemClock.uptimeMillis() - r8;
        if (com.ss.android.agilelogger.a.a() == false) goto L82;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginLaunch", "init tag=initScheduler, duration=" + r28, false, 4, null);
    L83:
        throw th;
    L82:
        Log.i("PluginLaunch", "init tag=initScheduler, duration=" + r28);
        goto L83
    L11:
        r7 = 33;
        goto L12
    }
}
