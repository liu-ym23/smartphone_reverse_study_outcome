package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadIdGeneratorService extends IDownloadIdGenerator {

    public static class DefaultDownloadIdGeneratorService implements IDownloadIdGeneratorService {
        public DefaultDownloadIdGeneratorService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public final int a(DownloadInfo r5) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public final int a(String r5, String r10) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public final boolean a() {
            return true;
        }
    }

    int a(DownloadInfo r5);

    boolean a();
}
