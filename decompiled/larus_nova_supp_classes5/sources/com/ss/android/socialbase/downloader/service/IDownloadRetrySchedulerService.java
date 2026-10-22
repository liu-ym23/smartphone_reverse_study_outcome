package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadRetrySchedulerService {
    void doSchedulerRetry(int r1);

    void scheduleRetryWhenHasTaskConnected();

    void scheduleRetryWhenHasTaskSucceed();

    void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r1);

    void tryCancelScheduleRetry(int r1);

    void tryStartScheduleRetry(DownloadInfo r1);
}
