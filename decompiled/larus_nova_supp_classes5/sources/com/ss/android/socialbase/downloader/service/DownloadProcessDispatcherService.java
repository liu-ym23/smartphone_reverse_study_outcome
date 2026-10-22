package com.ss.android.socialbase.downloader.service;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
    private static final String TAG = "DownloadProcessDispatcherService";

    public DownloadProcessDispatcherService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getAllDownloadInfo() {
        DownloadHelper.checkWorkerThread("getAllDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadCacheSyncSuccess() {
        return DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isHttpServiceInit() {
        return DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pauseAll() {
        DownloadProcessDispatcher.getInstance().pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean canResume(int r2) {
        DownloadHelper.checkWorkerThread("canResume");
        return DownloadProcessDispatcher.getInstance().canResume(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int r3) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(r3, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public long getCurBytes(int r3) {
        DownloadHelper.checkWorkerThread("getCurBytes");
        return DownloadProcessDispatcher.getInstance().getCurBytes(r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        DownloadHelper.checkWorkerThread("getDownloadFileUriProvider");
        return DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(int r2) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        DownloadHelper.checkWorkerThread("getDownloadInfoList");
        return DownloadProcessDispatcher.getInstance().getDownloadInfoList(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFileExtension");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByMonitorScene(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosBySavePath(String r2) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfosBySavePath(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        DownloadHelper.checkWorkerThread("getDownloadNotificationEventListener");
        return DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r2) {
        DownloadHelper.checkWorkerThread("getDownloadingDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r2) {
        return DownloadProcessDispatcher.getInstance().getInstalledTimeStampBySavePath(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public INotificationClickCallback getNotificationClickCallback(int r2) {
        return DownloadProcessDispatcher.getInstance().getNotificationClickCallback(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getStatus(int r2) {
        DownloadHelper.checkWorkerThread("getStatus");
        return DownloadProcessDispatcher.getInstance().getStatus(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        DownloadHelper.checkWorkerThread("getSuccessedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        DownloadHelper.checkWorkerThread("getUnCompletedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r2) {
        DownloadHelper.checkWorkerThread("isDownloadSuccessAndFileNotExist");
        return DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloading(int r2) {
        DownloadHelper.checkWorkerThread("isDownloading");
        return DownloadProcessDispatcher.getInstance().isDownloading(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pause(int r2) {
        DownloadProcessDispatcher.getInstance().pause(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskNotificationListener(int r5) {
        DownloadHelper.checkWorkerThread("removeTaskNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r5, null, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskSubListener(int r5) {
        DownloadHelper.checkWorkerThread("removeTaskSubListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r5, null, ListenerType.SUB, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restart(int r2) {
        DownloadProcessDispatcher.getInstance().restart(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllFailedDownloadTasks(List<String> r2) {
        DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void resume(int r2) {
        DownloadProcessDispatcher.getInstance().resume(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setLogLevel(int r2) {
        DownloadProcessDispatcher.getInstance().setLogLevel(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void tryDownload(DownloadTask r7) {
        if (Logger.alog() == false) goto L8;
        if (r7 == null) goto L8;
        DownloadInfo r0 = r7.getDownloadInfo();
        if (r0 == null) goto L8;
        Logger.taskDebug(TAG, r0, "tryDownload", r0.toDetailString(), true);
        Logger.taskDebug(TAG, r0, "tryDownload", "Setting:" + DownloadSetting.obtain(r0.getId()), true);
    L8:
        DownloadProcessDispatcher.getInstance().tryDownload(r7);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadHelper.checkWorkerThread("addNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r4, r5, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void cancel(int r2, boolean r3) {
        DownloadProcessDispatcher.getInstance().cancel(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int r2, boolean r3) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getDownloadId(String r2, String r3) {
        return DownloadProcessDispatcher.getInstance().getDownloadId(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(String r2, String r3) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFilters");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFilters(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadHelper.checkWorkerThread("removeNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r4, r5, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeSubThreadListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadHelper.checkWorkerThread("removeSubThreadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r4, r5, ListenerType.SUB, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        DownloadHelper.checkWorkerThread("setDownloadNotificationEventListener");
        DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setNotificationListener(int r4, IDownloadListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadHelper.checkWorkerThread("setNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r4, r5, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(r2, r3, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int r2, IDownloadListener r3, ListenerType r4, boolean r5) {
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r2, r3, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeDownloadListener(int r2, IDownloadListener r3, ListenerType r4, boolean r5) {
        DownloadHelper.checkWorkerThread("removeDownloadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r2, r3, r4, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int r8, IDownloadListener r9, ListenerType r10, boolean r11, boolean r12) {
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r8, r9, r10, r11, r12);
    }
}
