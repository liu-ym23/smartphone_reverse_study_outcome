package com.bytedance.apm6.disk;

import com.bytedance.apm.d.f;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DiskCollector {
    private static final String KEY_DISK_CHECK_TIME = "check_disk_last_time";
    private static final String KEY_SP = "monitor_config";
    private static DiskCollector instance;
    private AsyncTask asyncTask;
    private DiskConfig config;
    private volatile boolean isAlreadyCollected;
    private volatile boolean isInited;

    static {
        instance = new DiskCollector();
    }

    public DiskCollector() {
    }

    static /* synthetic */ DiskConfig access$000(DiskCollector r0) {
        return r0.config;
    }

    static /* synthetic */ AsyncTask access$100(DiskCollector r0) {
        return r0.asyncTask;
    }

    private synchronized void collect() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlreadyCollected == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        DiskConfig r0 = this.config;     // Catch: Throwable -> L22
        if (r0 != null) goto L10;
    L20:
        monitor-exit(this);
        return;
    L10:
        if (r0.isSample() == false) goto L20;
        if (ApmContext.isMainProcess() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.isAlreadyCollected = true;     // Catch: Throwable -> L22
        this.asyncTask = new AnonymousClass1(this);     // Catch: Throwable -> L22
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    public static DiskCollector getInstance() {
        return instance;
    }

    public void init() {
        if (this.isInited == false) goto L5;
        return;
    L5:
        this.isInited = true;
        DiskConfigService r0 = (DiskConfigService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(DiskConfigService.class), DiskConfigService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        updateConfig(r0.getConfig());
        return;
    }

    public void setDiskCheckListener(f r2) {
        f r1 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        DiskStatistics.getInstance().setListener(r1);
    }

    public synchronized void updateConfig(DiskConfig r4) {
        monitor-enter(this);
        if (r4 != null) goto L26;
        monitor-exit(this);
        return;
    L26:
        this.config = r4;     // Catch: Throwable -> L23
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.d(Constants.TAG, "updateConfig:" + r4);     // Catch: Throwable -> L23
    L10:
        if (this.isInited == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        ActivityLifecycleService r5 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r5 != null) goto L16;
    L21:
        monitor-exit(this);
        return;
    L16:
        if (r5.isForeground() == true) goto L21;
        collect();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
