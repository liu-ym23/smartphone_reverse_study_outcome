package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadMonitorHelperService implements IDownloadMonitorHelperService {
    public DownloadMonitorHelperService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public final void a(DownloadTask r5) {
        DownloadMonitorHelper.a(r5, null, 0);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public final void a(IDownloadMonitorDepend r5, DownloadInfo r10, BaseException r11) {
        DownloadMonitorHelper.a(r5, r10, r11, 0);
    }
}
