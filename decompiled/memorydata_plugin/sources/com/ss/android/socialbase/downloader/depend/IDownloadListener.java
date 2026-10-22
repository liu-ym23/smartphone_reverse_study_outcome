package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface IDownloadListener {
    void onCanceled(DownloadInfo r1);

    void onFailed(DownloadInfo r1, BaseException r2);

    void onFirstStart(DownloadInfo r1);

    void onFirstSuccess(DownloadInfo r1);

    void onPause(DownloadInfo r1);

    void onPrepare(DownloadInfo r1);

    void onProgress(DownloadInfo r1);

    void onRetry(DownloadInfo r1, BaseException r2);

    @Deprecated
    void onRetryDelay(DownloadInfo r1, BaseException r2);

    void onStart(DownloadInfo r1);

    void onSuccessed(DownloadInfo r1);
}
