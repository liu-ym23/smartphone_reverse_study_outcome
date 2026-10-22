package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadEngine {
    void addDownloadListener(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5);

    void addDownloadListener(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5, boolean r6);

    boolean cancel(int r1, boolean r2);

    void clearDownloadData(int r1, boolean r2, boolean r3);

    Future doDownload(DownloadTask r1);

    void doPause(int r1, boolean r2);

    IDownloadFileUriProvider getDownloadFileUriProvider(int r1);

    DownloadInfo getDownloadInfo(int r1);

    List<DownloadInfo> getDownloadInfoList(String r1);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1);

    DownloadTask getDownloadTask(int r1, int r2);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1);

    INotificationClickCallback getNotificationClickCallback(int r1);

    boolean isDownloading(int r1);

    boolean isInDownloadTaskPool(int r1);

    boolean pause(int r1);

    void refreshDownloadTaskMap(int r1, int r2, int r3);

    void removeDownloadListener(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5);

    void removeDownloadRunnable(DownloadRunnable r1);

    void resetDownloadData(int r1, boolean r2);

    boolean restart(int r1);

    void restartAllFailedDownloadTasks(List<String> r1);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r1);

    boolean restartAsyncWaitingTask(int r1);

    boolean resume(int r1);

    void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventListener r2);

    void setThrottleNetSpeed(int r1, long r2, int r4);

    void shutDown();

    void tryDownload(DownloadTask r1);
}
