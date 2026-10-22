package com.bytedance.apm6.fd;

import android.os.Process;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IFdCheck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FdCollector {
    private static final long DEFAULT_DELAY_CHECK_MS = 1200000;
    private static FdCollector instance;
    private FdConfig config;
    private AsyncTask delayTask;
    private IFdCheck fdChecker;
    private volatile boolean isInited;
    private volatile boolean isReady;
    private volatile boolean isStarted;

    static {
        instance = new FdCollector();
    }

    public FdCollector() {
        this.isReady = false;
    }

    static /* synthetic */ AsyncTask access$000(FdCollector r0) {
        return r0.delayTask;
    }

    static /* synthetic */ AsyncTask access$002(FdCollector r0, AsyncTask r1) {
        r0.delayTask = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(FdCollector r0, boolean r1) {
        r0.isReady = r1;
        return r1;
    }

    static /* synthetic */ void access$200(FdCollector r0) {
        r0.start();
    }

    static /* synthetic */ void access$300(FdCollector r0) {
        r0.collect();
    }

    private void collect() {
        if (this.config != null) goto L5;
        return;
    L5:
        ActivityLifecycleService r0 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 == null) goto L8;
        r1 = r0.isForeground();
    L8:
        int r2 = getFdCount();
        if (r2 > 0) goto L11;
    L14:
        IFdCheck r6 = getFdChecker();
        if (r6 != null) goto L17;
        return;
    L17:
        Monitor.record(new FdEvent(r2, r6.getFdList(), r1));
        return;
    L11:
        if (r2 >= this.config.getFdCountThreshold()) goto L14;
        Monitor.record(new FdEvent(r2, null, r1));
    }

    private IFdCheck getFdChecker() {
        if (this.fdChecker != null) goto L6;
        this.fdChecker = (IFdCheck) ZeusTransformUtils.preCheckCast(d.a(IFdCheck.class), IFdCheck.class, "com.obric.memorydata.plugin");
    L6:
        return this.fdChecker;
    }

    private int getFdCount() {
        return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
    L5:
        return 0;
    }

    public static FdCollector getInstance() {
        return instance;
    }

    private synchronized void start() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.isReady == false) goto L15;
        FdConfig r0 = this.config;     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        if (r0.isSampled() == false) goto L15;
        if (this.isStarted == true) goto L15;
        this.isStarted = true;     // Catch: Throwable -> L17
        AsyncTaskManager r1 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);     // Catch: Throwable -> L17
        final long r3 = 0;
        final long r5 = this.config.getCollectIntervalMs();     // Catch: Throwable -> L17
        r1.sendTask(new AnonymousClass2(this, r3, r5));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
    }

    public void init() {
        if (this.isInited == false) goto L5;
        return;
    L5:
        this.isInited = true;
        IFdConfigService r0 = (IFdConfigService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IFdConfigService.class), IFdConfigService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        updateConfig(r0.getConfig());
    L8:
        final long r1 = 1200000;
        this.delayTask = new AnonymousClass1(this, r1);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.delayTask);
    }

    public synchronized void updateConfig(FdConfig r4) {
        monitor-enter(this);
        if (r4 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.config = r4;     // Catch: Throwable -> L12
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "updateConfig:" + r4);     // Catch: Throwable -> L12
    L9:
        start();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
