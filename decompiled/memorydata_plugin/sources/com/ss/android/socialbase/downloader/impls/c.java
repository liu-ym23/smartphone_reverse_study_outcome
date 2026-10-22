package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.android.socialbase.downloader.h.b f15488b;

    public c() {
        f15488b = new com.ss.android.socialbase.downloader.h.b();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return f15488b.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public Future a(DownloadTask r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a(r5.getDownloadInfo()) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadEngine", r5.getDownloadInfo(), "doDownload", "start doDownload for task");
    L8:
        com.ss.android.socialbase.downloader.model.e r0 = r5.getTimingInfo();
        r0.d = System.currentTimeMillis();
        return f15488b.a(new com.ss.android.socialbase.downloader.b.c(r5, this.f15459a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int r1, long r2, int r4) {
        f15488b.a(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.b.c r1) {
        f15488b.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int r3) {
        if (f15488b.a(r3) == true) goto L5;
        return false;
    L5:
        DownloadInfo r2 = d(r3);
        if (r2 != null) goto L9;
        return false;
    L9:
        if (DownloadStatus.isDownloading(r2.getStatus()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int r1) {
        f15488b.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public com.ss.android.socialbase.downloader.b.c c(int r1) {
        return f15488b.b(r1);
    }
}
