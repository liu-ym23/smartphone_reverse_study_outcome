package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class n implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f15543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f15544b;

    public interface a {
        void a(DownloadInfo r1, long r2, boolean r4, int r5);
    }

    private n() {
        this.f15544b = (u) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(u.class), u.class, "com.obric.memorydata.plugin");
    }

    public static n a() {
        if (f15543a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15543a != null) goto L9;
        f15543a = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f15543a;
    }

    @Override // com.ss.android.socialbase.downloader.service.u
    public void a(DownloadInfo r1) {
        this.f15544b.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.u
    public void b() {
        this.f15544b.b();
    }

    @Override // com.ss.android.socialbase.downloader.service.u
    public void c() {
        this.f15544b.c();
    }
}
