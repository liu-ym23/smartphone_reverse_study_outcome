package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadGlobalThrottleService {
    void end(DownloadTask r1);

    void setGlobalThrottle(int r1, int r2);

    void setGlobalThrottleTaskPriority(int r1, int r2);

    void start(DownloadTask r1);
}
