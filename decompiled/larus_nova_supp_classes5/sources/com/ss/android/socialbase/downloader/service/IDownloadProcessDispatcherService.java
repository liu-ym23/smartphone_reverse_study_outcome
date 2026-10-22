package com.ss.android.socialbase.downloader.service;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadProcessDispatcherService {
    void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4, boolean r5);

    void addNotificationListener(int r1, IDownloadListener r2);

    boolean canResume(int r1);

    void cancel(int r1, boolean r2);

    void clearDownloadData(int r1);

    void clearDownloadData(int r1, boolean r2);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int r1);

    IDownloadFileUriProvider getDownloadFileUriProvider(int r1);

    int getDownloadId(String r1, String r2);

    DownloadInfo getDownloadInfo(int r1);

    DownloadInfo getDownloadInfo(String r1, String r2);

    List<DownloadInfo> getDownloadInfoList(String r1);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1);

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2);

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r1);

    List<DownloadInfo> getDownloadInfosBySavePath(String r1);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1);

    Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r1);

    INotificationClickCallback getNotificationClickCallback(int r1);

    int getStatus(int r1);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1);

    boolean isDownloading(int r1);

    boolean isHttpServiceInit();

    void pause(int r1);

    void pauseAll();

    void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1);

    void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1);

    void removeDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void removeNotificationListener(int r1, IDownloadListener r2);

    void removeSubThreadListener(int r1, IDownloadListener r2);

    void removeTaskNotificationListener(int r1);

    void removeTaskSubListener(int r1);

    void restart(int r1);

    void restartAllFailedDownloadTasks(List<String> r1);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r1);

    void resume(int r1);

    void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventListener r2);

    void setLogLevel(int r1);

    void setNotificationListener(int r1, IDownloadListener r2);

    void setThrottleNetSpeed(int r1, long r2, int r4);

    void tryDownload(DownloadTask r1);

    void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1);

    void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1);
}
