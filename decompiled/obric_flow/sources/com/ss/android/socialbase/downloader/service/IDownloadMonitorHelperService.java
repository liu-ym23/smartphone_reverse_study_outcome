package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadMonitorHelperService {

    public static class DefaultDownloadMonitorHelperService implements IDownloadMonitorHelperService {
        public DefaultDownloadMonitorHelperService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public final void a(IDownloadMonitorDepend r5, DownloadInfo r10, BaseException r11) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public final void a(DownloadTask r5) {
        }
    }

    void a(IDownloadMonitorDepend r5, DownloadInfo r10, BaseException r11);

    void a(DownloadTask r5);
}
