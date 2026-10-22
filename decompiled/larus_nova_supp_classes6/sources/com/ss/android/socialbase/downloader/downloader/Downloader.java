package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Downloader extends BaseDownloader {
    private static final String TAG = "Downloader";
    private static volatile Downloader instance;
    private static volatile boolean mSetContext;

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IReserveWifiStatusListener getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    private Downloader() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void enableLruCache() {
        super.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void initDownloadCacheImmediately() {
        super.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resetSleepDownloadingTaskState() {
        super.resetSleepDownloadingTaskState();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resumeAllEnqueueTask() {
        super.resumeAllEnqueueTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void sleepDownloadingTask() {
        super.sleepDownloadingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadSpInfo() {
        super.updateDownloadSpInfo();
    }

    public Downloader(DownloaderBuilder r2) {
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).initComponent(r2);
    }

    private static void checkContext(Context r6) {
        if (mSetContext == false) goto L6;
        return;
    L6:
        monitor-enter(Downloader.class);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (mSetContext == false) goto L26;
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L26:
        if (r6 == null) goto L14;
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(r6.getApplicationContext());     // Catch: Throwable -> L17
        mSetContext = true;     // Catch: Throwable -> L17
    L25:
    L19:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L14:
        if (Logger.debug() == false) goto L25;
        Logger.globalDebug(TAG, "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        Logger.globalError(TAG, "checkContext", "Error:" + th);     // Catch: Throwable -> L21
        goto L19
    }

    public static Downloader getInstance(Context r2) {
        if (instance == null) goto L5;
    L14:
        checkContext(r2);
        return instance;
    L5:
        monitor-enter(Downloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(r2);     // Catch: Throwable -> L11
        instance = new Downloader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void init(DownloaderBuilder r1) {
        initOrCover(r1, false);
    }

    public static void loadService(IDownloadServiceLoader r0) {
        DownloadServiceManager.loadService(r0);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int r1) {
        return super.canResume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1) {
        super.cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r3) {
        return super.clearAllDownloadCache(r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDirectory(IDirectoryCleanerListener r1) {
        super.clearDirectory(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1) {
        super.clearDownloadData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearMemoryCacheData(double r1) {
        super.clearMemoryCacheData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int r3) {
        return super.getCurBytes(r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        return super.getDownloadFileUriProvider(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int r1) {
        return super.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String r1) {
        return super.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByFileExtension(String r1) {
        return super.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByMonitorScene(List r1) {
        return super.getDownloadInfosByMonitorScene(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosBySavePath(String r1) {
        return super.getDownloadInfosBySavePath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        return super.getDownloadNotificationEventListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String r1) {
        return super.getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ Map getInstalledTimeStampBySavePath(String r1) {
        return super.getInstalledTimeStampBySavePath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int r1) {
        return super.getStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String r1) {
        return super.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String r1) {
        return super.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        return super.isDownloadSuccessAndFileNotExist(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int r1) {
        return super.isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int r1) {
        super.pause(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAllEnqueueTask(List r1) {
        super.pauseAllEnqueueTask(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1) {
        super.registerDownloadCacheSyncListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1) {
        super.registerDownloaderProcessConnectedListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int r1) {
        super.removeTaskMainListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int r1) {
        super.removeTaskNotificationListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int r1) {
        super.removeTaskSubListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int r1) {
        super.restart(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List r1) {
        super.restartAllFailedDownloadTasks(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List r1) {
        super.restartAllPauseReserveOnWifiDownloadTasks(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int r1) {
        super.resume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String r1) {
        super.setDefaultSavePath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String r1) {
        super.setDefaultSaveTempPath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadDBListener(IDownloadDBListener r1) {
        super.setDownloadDBListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r1) {
        super.setDownloadMemoryInfoListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryListener(IMemoryListener r1) {
        super.setDownloadMemoryListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMonitorListener(IDownloadMonitorListener r1) {
        super.setDownloadMonitorListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r1) {
        super.setDownloadMonitorTeaListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNetworkHandler(IDownloadNetworkHandler r1) {
        super.setDownloadNetworkHandler(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r1) {
        super.setDownloadPluginDegradeListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadStatusListener(IDownloadStatusListener r1) {
        super.setDownloadStatusListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadThreadCheckListener(IDownloadThreadCheckListener r1) {
        super.setDownloadThreadCheckListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int r1) {
        super.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadMonitor(IMainThreadMonitor r1) {
        super.setMainThreadMonitor(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setNotificationClickCallback(INotificationClickCallback r1) {
        super.setNotificationClickCallback(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(IReserveWifiStatusListener r1) {
        super.setReserveWifiStatusListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void stopThrottle(String[] r1) {
        super.stopThrottle(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1) {
        super.unRegisterDownloadCacheSyncListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1) {
        super.unRegisterDownloaderProcessConnectedListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadInfo(DownloadInfo r1) {
        super.updateDownloadInfo(r1);
    }

    public static synchronized void initOrCover(DownloaderBuilder r3, boolean r4) {
        monitor-enter(Downloader.class);
        if (r3 != null) goto L22;
        monitor-exit(Downloader.class);
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (instance != null) goto L12;
        instance = r3.build();     // Catch: Throwable -> L19
        monitor-exit(Downloader.class);
        return;
    L12:
        IDownloadComponentManagerService r1 = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);     // Catch: Throwable -> L19
        if (r1.isInit() == true) goto L15;
        r1.initComponent(r3);     // Catch: Throwable -> L19
    L17:
        monitor-exit(Downloader.class);
        return;
    L15:
        if (r4 == false) goto L17;
        r1.coverComponent(r3);     // Catch: Throwable -> L19
        goto L17
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addMainThreadListener(int r1, IDownloadListener r2) {
        super.addMainThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addNotificationListener(int r1, IDownloadListener r2) {
        super.addNotificationListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addSubThreadListener(int r1, IDownloadListener r2) {
        super.addSubThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1, boolean r2) {
        super.cancel(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r1, Set r2) {
        return super.clearAllDownloadCache(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDBSuccessedDownloadInfo(String r1, String r2) {
        super.clearDBSuccessedDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1, boolean r2) {
        super.clearDownloadData(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String r1, String r2) {
        return super.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String r1, String r2) {
        return super.getDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int r1, IDownloadListener r2) {
        super.removeMainThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeNotificationListener(int r1, IDownloadListener r2) {
        super.removeNotificationListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int r1, IDownloadListener r2) {
        super.removeSubThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventListener r2) {
        super.setDownloadNotificationEventListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadListener(int r1, IDownloadListener r2) {
        super.setMainThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setNotificationListener(int r1, IDownloadListener r2) {
        super.setNotificationListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setSubThreadListener(int r1, IDownloadListener r2) {
        super.setSubThreadListener(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2) {
        super.setThrottleNetSpeed(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void startThrottle(String[] r1, long r2) {
        super.startThrottle(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadListener(int r1, IDownloadListener r2, boolean r3) {
        super.setMainThreadListener(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2, int r4) {
        super.setThrottleNetSpeed(r1, r2, r4);
    }
}
