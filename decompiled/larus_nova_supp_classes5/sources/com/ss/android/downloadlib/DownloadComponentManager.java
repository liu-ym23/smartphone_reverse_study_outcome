package com.ss.android.downloadlib;

import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadComponentManager {
    private ExecutorService cpuExecutor;
    private ScheduledExecutorService customScheduledExecutor;
    private ScheduledExecutorService downloadRetainScheduledExecutor;
    private ExecutorService installFinishCheckCPUExecutor;
    private ExecutorService ioExecutor;
    private ScheduledExecutorService scheduledExecutor;

    public static class SingleTonHolder {
        private static DownloadComponentManager INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new DownloadComponentManager(null);
        }

        public static /* synthetic */ DownloadComponentManager access$100() {
            return INSTANCE;
        }
    }

    public void clearAllData() {
        submitCPUTask(new 1(this));
    }

    public ExecutorService getCPUExecutor() {
        if (this.cpuExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.cpuExecutor != null) goto L9;
        this.cpuExecutor = new PThreadPoolExecutor(2, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-CPUThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.cpuExecutor;
    }

    public ScheduledExecutorService getCustomScheduledExecutor() {
        if (this.customScheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.customScheduledExecutor != null) goto L9;
        this.customScheduledExecutor = new PThreadScheduledThreadPoolExecutor(0, new DefaultThreadFactory(TTDownloader.class.getName().concat("-CustomScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.customScheduledExecutor;
    }

    public ScheduledExecutorService getDownloadRetainScheduledExecutor() {
        if (this.downloadRetainScheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.downloadRetainScheduledExecutor != null) goto L9;
        this.downloadRetainScheduledExecutor = new PThreadScheduledThreadPoolExecutor(2, new DefaultThreadFactory(TTDownloader.class.getName().concat("DownloadRetainScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.downloadRetainScheduledExecutor;
    }

    public ExecutorService getIOExecutor() {
        if (this.ioExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.ioExecutor != null) goto L9;
        this.ioExecutor = new PThreadPoolExecutor(5, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-IOThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.ioExecutor;
    }

    public ExecutorService getInstallFinishCheckCPUExecutor() {
        if (this.installFinishCheckCPUExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.installFinishCheckCPUExecutor != null) goto L9;
        this.installFinishCheckCPUExecutor = new PThreadPoolExecutor(5, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-InstallFinishCheckCPUThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.installFinishCheckCPUExecutor;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        if (this.scheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.scheduledExecutor != null) goto L9;
        this.scheduledExecutor = new PThreadScheduledThreadPoolExecutor(0, new DefaultThreadFactory(TTDownloader.class.getName().concat("-ScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.scheduledExecutor;
    }

    public static DownloadComponentManager getInstance() {
        return SingleTonHolder.access$100();
    }

    public void clearApkAndData() {
        TTDownloaderMonitor.inst().monitorDataError(false, "using CLEAR function");
        clearAllData();
        IDownloadCache r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        if ((r0 instanceof DefaultDownloadCache) == true) goto L5;
        return;
    L5:
        ISqlDownloadCache r1 = ((DefaultDownloadCache) r0).getSqlDownloadCache();
        if ((r1 instanceof SqlDownloadCache) == true) goto L8;
        return;
    L8:
        r1.clearData();
        ModelManager.getInstance().getAllNativeModels().clear();
    }

    public void destroyComponents() {
        AppDownloader.getInstance().unRegisterDownloadReceiver();
        Downloader.getInstance(GlobalInfo.getContext()).destoryDownloader();
    }

    private DownloadComponentManager() {
    }

    public /* synthetic */ DownloadComponentManager(1 r1) {
        this();
    }

    public void setCPUExecutor(ExecutorService r1) {
        this.cpuExecutor = r1;
    }

    public void setIOExecutor(ExecutorService r1) {
        this.ioExecutor = r1;
    }

    public void setScheduledExecutor(ScheduledExecutorService r1) {
        this.scheduledExecutor = r1;
    }

    public void submitCPUTask(Runnable r2) {
        submitCPUTask(r2, false);
    }

    public void submitIOTask(Runnable r2) {
        submitIOTask(r2, false);
    }

    public void submitInstallFinishCheckCPUTask(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        getInstallFinishCheckCPUExecutor().execute(r2);
    }

    public void submitCPUTask(Runnable r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 == true) goto L6;
    L8:
        getCPUExecutor().execute(r1);
        return;
    L6:
        if (ToolUtils.isMainThread() == true) goto L8;
        r1.run();
    }

    public void submitCustomScheduledTask(Runnable r3, long r4) {
        getCustomScheduledExecutor().schedule(r3, r4, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void submitDownloadRetainScheduledTask(Runnable r3, long r4) {
        getDownloadRetainScheduledExecutor().schedule(r3, r4, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void submitIOTask(Runnable r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 == true) goto L6;
    L8:
        getIOExecutor().execute(r1);
        return;
    L6:
        if (ToolUtils.isMainThread() == true) goto L8;
        r1.run();
    }

    public void submitScheduledTask(Runnable r3, long r4) {
        getScheduledExecutor().schedule(r3, r4, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
