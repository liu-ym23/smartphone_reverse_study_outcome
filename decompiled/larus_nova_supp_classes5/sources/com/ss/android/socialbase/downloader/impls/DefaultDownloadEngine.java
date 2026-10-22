package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DefaultDownloadEngine extends AbsDownloadEngine {
    private static final String TAG = "DefaultDownloadEngine";
    private static DownloadThreadPool downloadThreadPool;

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public List<Integer> getAllAliveDownloadIds() {
        return downloadThreadPool.getAllAliveDownloadIds();
    }

    public DefaultDownloadEngine() {
        downloadThreadPool = new DownloadThreadPool();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public DownloadRunnable doCancel(int r2) {
        return downloadThreadPool.cancel(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public Future doDownload(DownloadTask r2) {
        return doDownload(r2, false);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean isDownloading(int r3) {
        if (downloadThreadPool.containsTask(r3) == true) goto L5;
        return false;
    L5:
        DownloadInfo r4 = getDownloadInfo(r3);
        if (r4 != null) goto L9;
        return false;
    L9:
        if (DownloadStatus.isDownloading(r4.getStatus()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void removeDownloadRunnable(DownloadRunnable r2) {
        downloadThreadPool.removeUnAliveDownloadRunnable(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public Future doDownload(DownloadTask r5, boolean r6) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Logger.debugScene(r5.getDownloadInfo()) == false) goto L8;
        Logger.taskDebug(TAG, r5.getDownloadInfo(), "doDownload", "start doDownload for task");
    L8:
        DownloadTimingInfo r0 = r5.getTimingInfo();
        r0.doDownloadTime = System.currentTimeMillis();
        return downloadThreadPool.execute(new DownloadRunnable(r5, this.mainHandler), r6);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void doPause(int r2, boolean r3) {
        downloadThreadPool.pause(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int r2, long r3, int r5) {
        downloadThreadPool.setThrottleNetSpeed(r2, r3, r5);
    }
}
