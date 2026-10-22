package qb;

import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i implements t {
    public i() {
    }

    @Override // qb.t
    @Nullable
    public DownloadInfo a(int r10) {
        com.ss.android.socialbase.downloader.utils.c.e("getDownloadInfo");
        return jb.c.i().f(r10);
    }

    @Override // qb.t
    public void b(int r10) {
        jb.c.i().l(r10);
    }

    @Override // qb.t
    public void c(int r10, a0 r11, ListenerType r12, boolean r13) {
        com.ss.android.socialbase.downloader.utils.c.e("addDownloadListener");
        jb.c.i().a(r10, r11, r12, r13);
    }

    @Override // qb.t
    public int n(int r10) {
        com.ss.android.socialbase.downloader.utils.c.e("getStatus");
        return jb.c.i().j(r10);
    }

    @Override // qb.t
    public boolean o(int r10) {
        com.ss.android.socialbase.downloader.utils.c.e("isDownloading");
        return jb.c.i().k(r10);
    }

    @Override // qb.t
    public void p(int r10, boolean r11) {
        jb.c.i().u(r10, r11);
    }

    @Override // qb.t
    public void q(int r10, boolean r11) {
        jb.c.i().b(r10, r11);
    }

    @Override // qb.t
    public void r(List<String> r10) {
        jb.c.i().q(r10);
    }

    @Override // qb.t
    public void s(int r10) {
        jb.c.i().r(r10);
    }

    @Override // qb.t
    public void t(int r10, long r11, int r12) {
        jb.c.i().v(r10, r11, r12);
    }

    @Override // qb.t
    public void u() {
        jb.c.i().m();
    }

    @Override // qb.t
    public void w(List<String> r10) {
        jb.c.i().p(r10);
    }

    @Override // qb.t
    public void y(com.ss.android.socialbase.downloader.model.d r10) {
        if (lb.a.a() == false) goto L8;
        if (r10 == null) goto L8;
        DownloadInfo r11 = r10.y();
        if (r11 == null) goto L8;
        lb.a.g("DownloadProcessDispatcherService", r11.getId(), "tryDownload", r11.toDetailString());
        lb.a.g("DownloadProcessDispatcherService", r11.getId(), "tryDownload", "Setting:" + rb.a.g(r11.getId()));
    L8:
        jb.c.i().w(r10);
    }

    @Override // qb.t
    public void z(int r10) {
        jb.c.i().o(r10);
    }
}
