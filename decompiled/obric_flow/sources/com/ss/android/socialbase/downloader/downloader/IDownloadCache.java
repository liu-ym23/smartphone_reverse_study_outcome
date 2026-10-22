package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadCache {
    DownloadInfo a(int r5);

    DownloadInfo a(int r5, long r10);

    DownloadInfo a(int r5, long r10, String r11, String r12);

    List a(String r5);

    List a(String r5, String r10);

    void a();

    boolean a(int r5, Map r10);

    boolean a(DownloadInfo r5);

    DownloadInfo b(int r5, long r10);

    List b(String r5);

    void b(DownloadInfo r5);

    boolean b(int r5);

    DownloadInfo c(int r5, long r10);

    List c(String r5);

    void c(int r5);

    boolean c();

    DownloadInfo d(int r5, long r10);

    List d();

    List d(String r5);

    boolean d(int r5);

    DownloadInfo e(int r5);

    boolean e();

    DownloadInfo h(int r5);

    DownloadInfo j(int r5);

    DownloadInfo k(int r5);

    List o(int r5);

    void q(int r5);

    Map r(int r5);
}
