package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static sb.b f7982k;

    public c() {
        f7982k = new sb.b();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean C(int r10) {
        if (f7982k.d(r10) == true) goto L5;
        return false;
    L5:
        DownloadInfo r11 = s(r10);
        if (r11 != null) goto L9;
        return false;
    L9:
        if (ab.d.b(r11.getStatus()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void K(bb.c r10) {
        f7982k.j(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected bb.c k(int r10) {
        return f7982k.b(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void l(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (lb.a.a() == false) goto L7;
        lb.a.g("DefaultDownloadEngine", r10.x(), "doDownload", "start doDownload for task");
    L7:
        com.ss.android.socialbase.downloader.model.f r11 = r10.M();
        r11.f8184d = System.currentTimeMillis();
        f7982k.e(new bb.c(r10, this.f7936j));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void m(int r10, boolean r11) {
        f7982k.k(r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void n(int r10) {
        f7982k.h(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void o(int r10, long r11, int r12) {
        f7982k.l(r10, r11, r12);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> q() {
        return f7982k.f();
    }
}
