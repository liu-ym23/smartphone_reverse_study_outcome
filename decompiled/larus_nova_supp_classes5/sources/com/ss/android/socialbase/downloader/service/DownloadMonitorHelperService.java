package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadMonitorHelperService implements IDownloadMonitorHelperService {
    public DownloadMonitorHelperService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorDownloadApp(DownloadInfo r1, String r2, int r3) {
        DownloadMonitorHelper.monitorDownloadApp(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSend(DownloadTask r1, BaseException r2, int r3) {
        DownloadMonitorHelper.monitorSend(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSendWithTaskMonitor(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4) {
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r1, r2, r3, r4);
    }
}
