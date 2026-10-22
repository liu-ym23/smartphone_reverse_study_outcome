package com.bytedance.apm6.hub;

import c4.d;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.safety.EnhancedLogger;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import t4.e;
import t4.j;
import t4.k;
import u.f;

/* JADX INFO: loaded from: classes.dex */
public class Apm {
    private static final String LOG_TAG = "APM-Hub";
    private static volatile boolean inited = false;

    static {
    }

    public Apm() {
    }

    static /* synthetic */ void access$000(ApmAdapter r10) {
        initWithOtherThread(r10);
    }

    public static synchronized void init(ApmAdapter r10) {
        monitor-enter(Apm.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L9;
        monitor-exit(Apm.class);
        return;
    L9:
        inited = true;     // Catch: Throwable -> L12
        initWithMainThread(r10);     // Catch: Throwable -> L12
        initWithOtherThread(r10);     // Catch: Throwable -> L12
        monitor-exit(Apm.class);
    }

    private static void initWeedOut() {
        WeedOutManager.getInstance().register(new AnonymousClass25());
    }

    public static synchronized Runnable initWithAsync(final ApmAdapter r10) {
        monitor-enter(Apm.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        monitor-exit(Apm.class);
        return null;
    L10:
        inited = true;     // Catch: Throwable -> L13
        initWithMainThread(r10);     // Catch: Throwable -> L13
        Runnable r11 = new AnonymousClass1(r10);     // Catch: Throwable -> L13
        monitor-exit(Apm.class);
        return r11;
    }

    private static void initWithMainThread(ApmAdapter r10) {
        ApmContext.setApmContextAdapter(r10);
        ApmContext.setStartId(System.currentTimeMillis());
        ApmContext.setInitTimeStamp(System.currentTimeMillis());
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(LOG_TAG, "APM init start in process " + r10.getProcessName());
    L5:
        Logger.setLoggerImpl(new EnhancedLogger());
        ServiceManager.registerService(ActivityLifecycleService.class, new ActivityLifeManager());
    }

    private static void initWithOtherThread(final ApmAdapter r10) {
        ServiceManager.registerService(IHttpService.class, new AnonymousClass2(r10));
        ServiceManager.registerService(SlardarHandlerConfigService.class, new AnonymousClass3(r10));
        ServiceManager.registerService(CommonEventConfigService.class, new AnonymousClass4(r10));
        ServiceManager.registerService(CpuConfigService.class, new AnonymousClass5(r10));
        ServiceManager.registerService(f.class, new AnonymousClass6(r10));
        ServiceManager.registerService(FrequencyMonitorConfigService.class, new AnonymousClass7(r10));
        ServiceManager.registerService(ActivityLifecycleService.class, new AnonymousClass8());
        ServiceManager.registerService(e.class, new AnonymousClass9(r10));
        ServiceManager.registerService(EncryptService.class, new AnonymousClass10(r10));
        ServiceManager.registerService(IPerfFilterManager.class, new AnonymousClass11());
        ServiceManager.registerService(j.class, new AnonymousClass12());
        ServiceManager.registerService(k.class, new AnonymousClass13());
        new ActivityLifeManager();
        ServiceManager.registerService(MemoryConfigService.class, new AnonymousClass14(r10));
        ServiceManager.registerService(JavaAllocConfigService.class, new AnonymousClass15(r10));
        ServiceManager.registerService(IMapsCollectService.class, new AnonymousClass16(r10));
        ServiceManager.registerService(IDeviceInfoService.class, new AnonymousClass17(r10));
        ServiceManager.registerService(DiskConfigService.class, new AnonymousClass18());
        ServiceManager.registerService(ICpuDataService.class, new AnonymousClass19());
        ServiceManager.registerService(SlardarResponseService.class, new AnonymousClass20(r10));
        ServiceManager.registerService(IFdConfigService.class, new AnonymousClass21());
        d.c(IActivityLifeManager.class, new AnonymousClass22());
        d.c(IMonitorLogManager.class, new AnonymousClass23());
        ConfigManager.getInstance().init();
        AsyncTaskManager r11 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);
        final long r12 = r10.getInternalComponentInitDelayMills();
        r11.sendTask(new AnonymousClass24(r12));
        initWeedOut();
    }

    public static void pause() {
        SlardarHandler.getInstance().pause();
        CpuCollectManager.getInstance().pause();
        MemoryCollector.getInstance().pause();
    }

    public static void resume() {
        SlardarHandler.getInstance().resume();
        CpuCollectManager.getInstance().resume();
        MemoryCollector.getInstance().resume();
    }
}
