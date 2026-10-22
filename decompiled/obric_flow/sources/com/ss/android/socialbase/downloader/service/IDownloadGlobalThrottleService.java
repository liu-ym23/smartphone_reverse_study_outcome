package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadGlobalThrottleService {

    public static class DefaultDownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
        public DefaultDownloadGlobalThrottleService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public final void a(DownloadTask r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public final void b(DownloadTask r5) {
        }
    }

    void a(DownloadTask r5);

    void b(DownloadTask r5);
}
