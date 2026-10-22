package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadCache {
    DownloadInfo OnDownloadTaskCancel(int r1, long r2);

    DownloadInfo OnDownloadTaskCompleted(int r1, long r2);

    DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5);

    DownloadInfo OnDownloadTaskError(int r1, long r2);

    DownloadInfo OnDownloadTaskIntercept(int r1);

    DownloadInfo OnDownloadTaskPause(int r1, long r2);

    DownloadInfo OnDownloadTaskPrepare(int r1);

    DownloadInfo OnDownloadTaskProgress(int r1, long r2);

    DownloadInfo OnDownloadTaskRetry(int r1);

    boolean cacheExist(int r1);

    void clearData();

    void clearMemoryCacheData(double r1);

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    DownloadInfo getDownloadInfo(int r1);

    List<DownloadInfo> getDownloadInfoList(String r1);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1);

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2);

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r1);

    Map<Long, Segment> getSegmentMap(int r1);

    List<Segment> getSegments(int r1);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1);

    void init(boolean r1);

    void initImmediately();

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int r1);

    boolean removeDownloadInfo(int r1);

    boolean removeDownloadTaskData(int r1);

    void removeSegments(int r1);

    void syncDownloadInfo(DownloadInfo r1);

    void syncDownloadInfoFromOtherCache(int r1);

    boolean updateDownloadInfo(DownloadInfo r1);

    boolean updateSegments(int r1, Map<Long, Segment> r2);
}
