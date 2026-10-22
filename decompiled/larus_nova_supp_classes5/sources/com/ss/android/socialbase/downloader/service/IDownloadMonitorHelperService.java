package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadMonitorHelperService {
    void monitorDownloadApp(DownloadInfo r1, String r2, int r3);

    void monitorSend(DownloadTask r1, BaseException r2, int r3);

    void monitorSendWithTaskMonitor(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4);
}
