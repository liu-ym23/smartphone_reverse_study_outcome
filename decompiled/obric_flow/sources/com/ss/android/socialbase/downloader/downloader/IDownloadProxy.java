package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadProxy {
    DownloadInfo a(int r5);

    void a();

    void a(int r5, int r10, AbsDownloadListener r11, ListenerType r12);

    void a(int r5, int r10, IDownloadListener r11, ListenerType r12);

    void a(int r5, boolean r10);

    void a(DownloadTask r5);

    void a(ArrayList r5);

    boolean a(DownloadInfo r5);

    void b();

    void b(int r5, int r10);

    void b(int r5, boolean r10);

    void b(DownloadInfo r5);

    void b(ArrayList r5);

    boolean b(int r5);

    void c();

    void c(int r5);

    boolean d();

    boolean d(int r5);

    void e(int r5);

    boolean f(int r5);

    void g(int r5);

    int i(int r5);
}
