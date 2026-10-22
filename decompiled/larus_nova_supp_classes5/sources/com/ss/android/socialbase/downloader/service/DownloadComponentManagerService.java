package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.cleaner.DirectoryCleaner;
import com.ss.android.socialbase.downloader.db.DownloadBackgroundCleaner;
import com.ss.android.socialbase.downloader.db.DownloadDiskReporter;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.db.SqlDownloadHelper;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadComponentManagerService implements IDownloadComponentManagerService {
    private static final String TAG = "DownloadComponentManagerService";
    private static volatile Future mSleepDownloadTaskFuture;

    public DownloadComponentManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void resetSleepDownloadingTaskState() {
    L6:
        th = move-exception;
        Logger.globalError(TAG, "resetSleepDownloadingTaskState", "Error:" + th);
    L8:
        DownloadHelper.setSleepDownloadingTask(false);
        return;
    L3:
        if (mSleepDownloadTaskFuture == null) goto L8;
        mSleepDownloadTaskFuture.cancel(true);     // Catch: Throwable -> L6
        mSleepDownloadTaskFuture = null;     // Catch: Throwable -> L6
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void resumeAllEnqueueTask() {
        DownloadComponentManager.submitSingleTask(new 4(this));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public Context getAppContext() {
        return DownloadComponentManager.getAppContext();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IDownloadInterceptor getDownloadInterceptor() {
        return DownloadComponentManager.getDownloadInterceptor();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public JSONObject getDownloadSetting() {
        return DownloadComponentManager.getDownloadSetting();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return DownloadComponentManager.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public ITTNetHandler getTTNetHandler() {
        return DownloadComponentManager.getTTNetHandler();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public boolean isInit() {
        return DownloadComponentManager.isInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void sleepDownloadingTask() {
        int r0 = DownloadSetting.obtainGlobal().optInt("downloading_task_anr_sleep_time_s");
        if (r0 > 0) goto L5;
        return;
    L5:
        if (mSleepDownloadTaskFuture != null) goto L10;
        mSleepDownloadTaskFuture = DownloadComponentManager.getIOThreadExecutor().submit(new 2(this, r0));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadSpInfo() {
        IDownloadCache r0 = DownloadComponentManager.getDownloadCache();
        if ((r0 instanceof DefaultDownloadCache) == false) goto L6;
        ((DefaultDownloadCache) r0).updateDownloadSpInfo();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void enableLruCache() {
        DownloadComponentManager.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initDownloadCacheImmediately() {
        DownloadComponentManager.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadInMultiProcess() {
        DownloadComponentManager.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void unRegisterDownloadReceiver() {
        DownloadComponentManager.unRegisterDownloadReceiver();
    }

    public static /* synthetic */ Future access$002(Future r0) {
        mSleepDownloadTaskFuture = r0;
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearDirectory(IDirectoryCleanerListener r2) {
        DirectoryCleaner r0 = new DirectoryCleaner();
        r0.setDirectoryCleanerListener(r2);
        r0.start();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearMemoryCacheData(double r2) {
        DownloadComponentManager.submitIOTask(new 1(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void coverComponent(DownloaderBuilder r1) {
        DownloadComponentManager.coverComponent(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initComponent(DownloaderBuilder r1) {
        DownloadComponentManager.initComponent(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void pauseAllEnqueueTask(List<String> r2) {
        DownloadComponentManager.submitSingleTask(new 3(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setAppContext(Context r1) {
        DownloadComponentManager.setAppContext(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadDBListener(IDownloadDBListener r1) {
        DownloadComponentManager.setDownloadDBListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r1) {
        DownloadComponentManager.setDownloadMemoryInfoListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMemoryListener(IMemoryListener r1) {
        DownloadBackgroundCleaner.setDownloadMemoryListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMonitorListener(IDownloadMonitorListener r1) {
        DownloadComponentManager.setDownloadMonitorListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r1) {
        DownloadDiskReporter.setDownloadMonitorTeaListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadNetworkHandler(IDownloadNetworkHandler r1) {
        DownloadComponentManager.setDownloadNetworkHandler(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r1) {
        PluginDownloadEngine.setDownloadPluginDegradeListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadStatusListener(IDownloadStatusListener r1) {
        DownloadComponentManager.setDownloadStatusListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r1) {
        DownloadComponentManager.setDownloadThreadCheckListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setMainThreadMonitor(IMainThreadMonitor r1) {
        SqlDownloadHelper.setMainThreadMonitor(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setNotificationClickCallback(INotificationClickCallback r1) {
        DownloadComponentManager.setNotificationClickCallback(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setReserveWifiStatusListener(IReserveWifiStatusListener r1) {
        DownloadComponentManager.setReserveWifiStatusListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void stopThrottle(String[] r2) {
        DownloadComponentManager.getTTNetHandler().stopThrottle(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitIOTask(Runnable r1) {
        DownloadComponentManager.submitIOTask(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitSingleTask(Runnable r1) {
        DownloadComponentManager.submitSingleTask(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadInfo(DownloadInfo r2) {
        DownloadHelper.checkWorkerThread("updateDownloadInfo");
        DownloadComponentManager.getDownloadCache().updateDownloadInfo(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public long clearAllDownloadCache(boolean r1, Set<String> r2) {
        return DownloadComponentManager.clearAllDownloadCache(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearDBSuccessedDownloadInfo(String r3, String r4) {
        IDownloadCache r0 = DownloadComponentManager.getDownloadCache();
        if ((r0 instanceof DefaultDownloadCache) == true) goto L5;
        return;
    L5:
        ISqlDownloadCache r1 = ((DefaultDownloadCache) r0).getSqlDownloadCache();
        if ((r1 instanceof SqlDownloadCache) == true) goto L8;
        return;
    L8:
        ((SqlDownloadCache) r1).clearDBSuccessedDownloadInfo(r3, r4);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setAppInfo(String r1, String r2) {
        DownloadHelper.setAppInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void startThrottle(String[] r2, long r3) {
        DownloadComponentManager.getTTNetHandler().startThrottle(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitScheduleTask(Runnable r1, long r2, TimeUnit r4) {
        DownloadComponentManager.submitScheduleTask(r1, r2, r4);
    }
}
