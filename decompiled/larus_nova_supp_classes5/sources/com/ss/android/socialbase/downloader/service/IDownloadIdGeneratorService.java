package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadIdGeneratorService extends IDownloadIdGenerator {
    int generate(DownloadInfo r1);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    boolean isDefaultIdGenerator();

    void setDownloadIdGenerator(IDownloadIdGenerator r1);
}
