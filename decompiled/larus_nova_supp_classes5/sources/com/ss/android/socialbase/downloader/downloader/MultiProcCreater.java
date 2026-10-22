package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MultiProcCreater implements DownloadComponentManager.IndependentHolderCreator {
    public MultiProcCreater() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadProxy createProxy() {
        return new IndependentProcessDownloadHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadServiceHandler createServiceHandler() {
        return new IndependentDownloadServiceHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public ISqlDownloadCache createCache(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener r2) {
        SqlDownloadCacheAidlWrapper r0 = new SqlDownloadCacheAidlWrapper();
        r0.setOnMainProcessRebindErrorCallback(r2);
        return r0;
    }
}
