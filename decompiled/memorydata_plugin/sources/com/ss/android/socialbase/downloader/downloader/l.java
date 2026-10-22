package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface l {
    int a(String r1, String r2);

    List<DownloadInfo> a(String r1);

    void a();

    void a(int r1, int r2);

    void a(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5);

    void a(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5, boolean r6);

    void a(int r1, long r2, int r4);

    void a(int r1, aa r2);

    void a(int r1, boolean r2);

    void a(int r1, boolean r2, boolean r3);

    void a(ak r1);

    void a(DownloadTask r1);

    void a(List<String> r1);

    boolean a(int r1);

    boolean a(DownloadInfo r1);

    DownloadInfo b(String r1, String r2);

    List<DownloadInfo> b(String r1);

    void b(int r1);

    void b(int r1, int r2, IDownloadListener r3, ListenerType r4, boolean r5);

    void b(int r1, boolean r2);

    void b(DownloadInfo r1);

    void b(DownloadTask r1);

    void b(List<String> r1);

    boolean b();

    List<DownloadInfo> c();

    List<DownloadInfo> c(String r1);

    List<DownloadInfo> c(String r1, String r2);

    void c(int r1);

    void c(int r1, boolean r2);

    boolean c(DownloadInfo r1);

    long d(int r1);

    List<DownloadInfo> d(String r1);

    boolean d();

    int e(int r1);

    List<DownloadInfo> e(String r1);

    void e();

    boolean f();

    boolean f(int r1);

    DownloadInfo g(int r1);

    void h(int r1);

    int i(int r1);

    boolean j(int r1);

    boolean k(int r1);

    void l(int r1);

    aa m(int r1);

    ah n(int r1);

    com.ss.android.socialbase.downloader.depend.t o(int r1);

    void startService();
}
