package com.ss.android.socialbase.downloader.downloader;

import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadServiceHandler<T extends DownloadService> {
    void a();

    void a(IndependentProcessDownloadHandler r5);

    void a(DownloadTask r5);

    IBinder b();

    void b(DownloadTask r5);

    void c();

    void d();
}
