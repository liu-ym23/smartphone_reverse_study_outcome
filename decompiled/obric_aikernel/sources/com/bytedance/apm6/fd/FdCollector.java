package com.bytedance.apm6.fd;

import android.os.Process;
import c4.d;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IFdCheck;
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

    static /* synthetic */ AsyncTask access$000(FdCollector r10) {
        return r10.delayTask;
    }

    static /* synthetic */ AsyncTask access$002(FdCollector r10, AsyncTask r11) {
        r10.delayTask = r11;
        return r11;
    }

    static /* synthetic */ boolean access$102(FdCollector r10, boolean r11) {
        r10.isReady = r11;
        return r11;
    }

    static /* synthetic */ void access$200(FdCollector r10) {
        r10.start();
    }

    static /* synthetic */ void access$300(FdCollector r10) {
        r10.collect();
    }

    private void collect() {
        if (this.config != null) goto L5;
        return;
    L5:
        ActivityLifecycleService r10 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        boolean r11 = false;
        if (r10 == null) goto L8;
        r11 = r10.isForeground();
    L8:
        int r12 = getFdCount();
        if (r12 > 0) goto L11;
    L14:
        IFdCheck r13 = getFdChecker();
        if (r13 != null) goto L17;
        return;
    L17:
        Monitor.record(new FdEvent(r12, r13.getFdList(), r11));
        return;
    L11:
        if (r12 >= this.config.getFdCountThreshold()) goto L14;
        Monitor.record(new FdEvent(r12, null, r11));
    }

    private IFdCheck getFdChecker() {
        if (this.fdChecker != null) goto L6;
        this.fdChecker = (IFdCheck) d.a(IFdCheck.class);
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
        FdConfig r10 = this.config;     // Catch: Throwable -> L17
        if (r10 == null) goto L15;
        if (r10.isSampled() == false) goto L15;
        if (this.isStarted == true) goto L15;
        this.isStarted = true;     // Catch: Throwable -> L17
        AsyncTaskManager r11 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);     // Catch: Throwable -> L17
        final long r12 = 0;
        final long r13 = this.config.getCollectIntervalMs();     // Catch: Throwable -> L17
        r11.sendTask(new AnonymousClass2(this, r12, r13));     // Catch: Throwable -> L17
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
        IFdConfigService r10 = (IFdConfigService) ServiceManager.getService(IFdConfigService.class);
        if (r10 == null) goto L8;
        updateConfig(r10.getConfig());
    L8:
        final long r11 = DEFAULT_DELAY_CHECK_MS;
        this.delayTask = new AnonymousClass1(this, r11);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.delayTask);
    }

    public synchronized void updateConfig(FdConfig r10) {
        monitor-enter(this);
        if (r10 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.config = r10;     // Catch: Throwable -> L12
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "updateConfig:" + r10);     // Catch: Throwable -> L12
    L9:
        start();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
