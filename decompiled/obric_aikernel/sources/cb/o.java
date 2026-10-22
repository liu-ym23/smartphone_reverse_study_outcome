package cb;

import com.ss.android.socialbase.downloader.constants.RunStatus;

/* JADX INFO: loaded from: classes2.dex */
public class o extends bb.a {
    public o() {
    }

    @Override // bb.a, bb.e
    public bb.e e(h r10) {
        if (r10.f678c.isFastDownload() == false) goto L5;
        return null;
    L5:
        if (r10.f677b.F() != null) goto L7;
        return null;
    L7:
        if (r10.f678c.isIgnoreInterceptor() == false) goto L10;
        return null;
    L10:
        return super.e(r10);
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L13;
        lb.a.g("DownloadTaskInterceptModule", this.f544h.getId(), "proceed", "Run");
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r10.b();
        return;
    L6:
        if (this.f543g.F().a() == false) goto L11;
        h r11 = this.f547k;     // Catch: Throwable -> L9
        r11.f681f = RunStatus.RUN_STATUS_INTERCEPT;     // Catch: Throwable -> L9
    }
}
