package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface h {
    DownloadInfo a(int r1, long r2);

    DownloadInfo a(int r1, long r2, String r4, String r5);

    List<DownloadInfo> a();

    List<DownloadInfo> a(String r1);

    List<DownloadInfo> a(String r1, String r2);

    void a(double r1);

    boolean a(int r1, Map<Long, com.ss.android.socialbase.downloader.segment.i> r2);

    boolean a(DownloadInfo r1);

    DownloadInfo b(int r1);

    DownloadInfo b(int r1, long r2);

    List<DownloadInfo> b(String r1);

    void b();

    void b(DownloadInfo r1);

    DownloadInfo c(int r1, long r2);

    List<DownloadInfo> c(String r1);

    boolean c();

    boolean c(int r1);

    DownloadInfo d(int r1, long r2);

    List<DownloadInfo> d(String r1);

    boolean d();

    boolean d(int r1);

    DownloadInfo e(int r1);

    DownloadInfo f(int r1);

    DownloadInfo g(int r1);

    void g();

    DownloadInfo h(int r1);

    void i(int r1);

    Map<Long, com.ss.android.socialbase.downloader.segment.i> k(int r1);

    void l(int r1);

    List<com.ss.android.socialbase.downloader.segment.i> m(int r1);
}
