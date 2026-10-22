package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
    public DownloadRetrySchedulerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskConnected();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskSucceed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int r2) {
        RetrySchedulerImpl.getInstance().doSchedulerRetry(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r1) {
        RetrySchedulerImpl.setRetryScheduleHandler(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int r2) {
        RetrySchedulerImpl.getInstance().tryCancelScheduleRetry(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo r2) {
        RetrySchedulerImpl.getInstance().tryStartScheduleRetry(r2);
    }
}
