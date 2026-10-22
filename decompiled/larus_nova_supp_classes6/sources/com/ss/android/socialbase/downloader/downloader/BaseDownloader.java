package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.ListenerType;
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
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class BaseDownloader {
    private static IDownloadGlobalThrottleService globalThrottleService;
    private IDownloadComponentManagerService componentService;
    private IDownloadProcessDispatcherService dispatcherService;
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    static {
        globalThrottleService = (IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class);
    }

    public void destoryDownloader() {
        this.componentService.unRegisterDownloadReceiver();
    }

    public void enableLruCache() {
        this.componentService.enableLruCache();
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return this.dispatcherService.getAllDownloadInfo();
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return this.componentService.getReserveWifiStatusListener();
    }

    public void initDownloadCacheImmediately() {
        this.componentService.initDownloadCacheImmediately();
    }

    public boolean isDownloadCacheSyncSuccess() {
        return this.dispatcherService.isDownloadCacheSyncSuccess();
    }

    public boolean isHttpServiceInit() {
        return this.dispatcherService.isHttpServiceInit();
    }

    public void pauseAll() {
        this.dispatcherService.pauseAll();
    }

    public void resetSleepDownloadingTaskState() {
        this.componentService.resetSleepDownloadingTaskState();
    }

    public void resumeAllEnqueueTask() {
        this.componentService.resumeAllEnqueueTask();
    }

    public void setDownloadInMultiProcess() {
        this.componentService.setDownloadInMultiProcess();
    }

    public void sleepDownloadingTask() {
        this.componentService.sleepDownloadingTask();
    }

    public void updateDownloadSpInfo() {
        this.componentService.updateDownloadSpInfo();
    }

    public BaseDownloader() {
        this.dispatcherService = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
        this.componentService = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);
    }

    private File getGlobalSaveDir(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (DownloadDirUtils.isValidDirectory(r0) == false) goto L8;
        return r0;
    L8:
        return null;
    }

    public static DownloadTask with(Context r0) {
        Downloader.getInstance(r0);
        return new DownloadTask();
    }

    public boolean canResume(int r2) {
        return this.dispatcherService.canResume(r2);
    }

    public void cancel(int r2) {
        cancel(r2, true);
    }

    public long clearAllDownloadCache(boolean r3) {
        return this.componentService.clearAllDownloadCache(r3, null);
    }

    public void clearDirectory(IDirectoryCleanerListener r2) {
        this.componentService.clearDirectory(r2);
    }

    public void clearDownloadData(int r3) {
        this.dispatcherService.clearDownloadData(r3, true);
    }

    public void clearMemoryCacheData(double r2) {
        this.componentService.clearMemoryCacheData(r2);
    }

    public long getCurBytes(int r3) {
        return this.dispatcherService.getCurBytes(r3);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        return this.dispatcherService.getDownloadFileUriProvider(r2);
    }

    public DownloadInfo getDownloadInfo(int r2) {
        return this.dispatcherService.getDownloadInfo(r2);
    }

    public List<DownloadInfo> getDownloadInfoList(String r2) {
        return this.dispatcherService.getDownloadInfoList(r2);
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        return this.dispatcherService.getDownloadInfosByFileExtension(r2);
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        return this.dispatcherService.getDownloadInfosByMonitorScene(r2);
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String r2) {
        return this.dispatcherService.getDownloadInfosBySavePath(r2);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        return this.dispatcherService.getDownloadNotificationEventListener(r2);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r2) {
        return this.dispatcherService.getDownloadingDownloadInfosWithMimeType(r2);
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r2) {
        return this.dispatcherService.getInstalledTimeStampBySavePath(r2);
    }

    public int getStatus(int r2) {
        return this.dispatcherService.getStatus(r2);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        return this.dispatcherService.getSuccessedDownloadInfosWithMimeType(r2);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        return this.dispatcherService.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r2) {
        return this.dispatcherService.isDownloadSuccessAndFileNotExist(r2);
    }

    public boolean isDownloading(int r2) {
        return this.dispatcherService.isDownloading(r2);
    }

    public void pause(int r2) {
        this.dispatcherService.pause(r2);
    }

    public void pauseAllEnqueueTask(List<String> r2) {
        this.componentService.pauseAllEnqueueTask(r2);
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        this.dispatcherService.registerDownloadCacheSyncListener(r2);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        this.dispatcherService.registerDownloaderProcessConnectedListener(r2);
    }

    public void removeTaskMainListener(int r5) {
        this.dispatcherService.removeDownloadListener(r5, null, ListenerType.MAIN, true);
    }

    public void removeTaskNotificationListener(int r5) {
        this.dispatcherService.removeDownloadListener(r5, null, ListenerType.NOTIFICATION, true);
    }

    public void removeTaskSubListener(int r5) {
        this.dispatcherService.removeDownloadListener(r5, null, ListenerType.SUB, true);
    }

    public void restart(int r2) {
        this.dispatcherService.restart(r2);
    }

    public void restartAllFailedDownloadTasks(List<String> r2) {
        this.dispatcherService.restartAllFailedDownloadTasks(r2);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        this.dispatcherService.restartAllPauseReserveOnWifiDownloadTasks(r2);
    }

    public void resume(int r2) {
        this.dispatcherService.resume(r2);
    }

    public void setDefaultSavePath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSavePath = r2;
        return;
    }

    public void setDefaultSaveTempPath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSaveTempPath = r2;
        return;
    }

    public void setDownloadDBListener(IDownloadDBListener r2) {
        this.componentService.setDownloadDBListener(r2);
    }

    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r2) {
        this.componentService.setDownloadMemoryInfoListener(r2);
    }

    public void setDownloadMemoryListener(IMemoryListener r2) {
        this.componentService.setDownloadMemoryListener(r2);
    }

    public void setDownloadMonitorListener(IDownloadMonitorListener r2) {
        this.componentService.setDownloadMonitorListener(r2);
    }

    public void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r2) {
        this.componentService.setDownloadMonitorTeaListener(r2);
    }

    public void setDownloadNetworkHandler(IDownloadNetworkHandler r2) {
        this.componentService.setDownloadNetworkHandler(r2);
    }

    public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r2) {
        this.componentService.setDownloadPluginDegradeListener(r2);
    }

    public void setDownloadStatusListener(IDownloadStatusListener r2) {
        this.componentService.setDownloadStatusListener(r2);
    }

    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r2) {
        this.componentService.setDownloadThreadCheckListener(r2);
    }

    public void setLogLevel(int r2) {
        this.dispatcherService.setLogLevel(r2);
    }

    public void setMainThreadMonitor(IMainThreadMonitor r2) {
        this.componentService.setMainThreadMonitor(r2);
    }

    public void setNotificationClickCallback(INotificationClickCallback r2) {
        this.componentService.setNotificationClickCallback(r2);
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener r2) {
        this.componentService.setReserveWifiStatusListener(r2);
    }

    public void stopThrottle(String[] r2) {
        this.componentService.stopThrottle(r2);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        this.dispatcherService.unRegisterDownloadCacheSyncListener(r2);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        this.dispatcherService.unRegisterDownloaderProcessConnectedListener(r2);
    }

    public void updateDownloadInfo(DownloadInfo r2) {
        this.componentService.updateDownloadInfo(r2);
    }

    public static void setGlobalThrottleTaskPriority(int r1, int r2) {
        globalThrottleService.setGlobalThrottleTaskPriority(r1, r2);
    }

    public void addMainThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.MAIN, false);
    }

    public void addNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.SUB, false);
    }

    public void cancel(int r2, boolean r3) {
        this.dispatcherService.cancel(r2, r3);
    }

    public long clearAllDownloadCache(boolean r2, Set<String> r3) {
        return this.componentService.clearAllDownloadCache(r2, r3);
    }

    public void clearDBSuccessedDownloadInfo(String r2, String r3) {
        this.componentService.clearDBSuccessedDownloadInfo(r2, r3);
    }

    public void clearDownloadData(int r2, boolean r3) {
        this.dispatcherService.clearDownloadData(r2, r3);
    }

    public int getDownloadId(String r2, String r3) {
        return this.dispatcherService.getDownloadId(r2, r3);
    }

    public DownloadInfo getDownloadInfo(String r2, String r3) {
        return this.dispatcherService.getDownloadInfo(r2, r3);
    }

    public void removeMainThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r4, r5, ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r4, r5, ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r4, r5, ListenerType.SUB, false);
    }

    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        this.dispatcherService.setDownloadNotificationEventListener(r2, r3);
    }

    public void setMainThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.MAIN, true);
    }

    public void setNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.NOTIFICATION, true);
    }

    public void setSubThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r4, r5, ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int r2, long r3) {
        setThrottleNetSpeed(r2, r3, 0);
    }

    public void startThrottle(String[] r2, long r3) {
        this.componentService.startThrottle(r2, r3);
    }

    public static void setGlobalThrottleSpeed(Context r0, int r1, int r2) {
        globalThrottleService.setGlobalThrottle(r1, r2);
    }

    public void setMainThreadListener(int r7, IDownloadListener r8, boolean r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r7, r8, ListenerType.MAIN, true, r9);
    }

    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        this.dispatcherService.setThrottleNetSpeed(r2, r3, r5);
    }
}
