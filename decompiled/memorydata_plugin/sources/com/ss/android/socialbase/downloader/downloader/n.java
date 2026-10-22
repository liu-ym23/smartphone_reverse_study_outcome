package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public interface n<T extends DownloadService> {
    IBinder a(Intent r1);

    void a(int r1);

    void a(Intent r1, int r2, int r3);

    void a(m r1);

    void a(WeakReference<T> r1);

    void b(DownloadTask r1);

    boolean b();

    void c();

    void c(DownloadTask r1);

    void d();

    void startService();
}
