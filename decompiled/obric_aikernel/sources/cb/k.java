package cb;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.z;

/* JADX INFO: loaded from: classes2.dex */
public class k extends bb.a {
    public k() {
    }

    public static boolean n(DownloadInfo r10) {
        if (o(r10) == true) goto L30;
        return false;
    L30:
        z r11 = com.ss.android.socialbase.downloader.downloader.a.v();     // Catch: Throwable -> L17
        boolean r12 = r11.a();     // Catch: Throwable -> L17
        if (r12 == false) goto L32;
    L14:
        if (r12 == false) goto L16;
    L15:
        r10.setInterceptFlag(1);
    L22:
        return r12;
    L16:
        r10.setInterceptFlag(0);
        goto L22
    L32:
    L12:
        th = th;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r12 == false) goto L16;
    L23:
        th = move-exception;
        if (r12 == false) goto L26;
        r10.setInterceptFlag(1);
    L27:
        throw th;
    L26:
        r10.setInterceptFlag(0);
        goto L27
    L9:
        if ((r11 instanceof ib.b) == false) goto L14;
        r12 = ((ib.b) r11).b(r10);     // Catch: Throwable -> L12
    L17:
        th = th;
        r12 = false;
        goto L28
    }

    private static boolean o(DownloadInfo r10) {
        if (r10.isFastDownload() == false) goto L5;
    L9:
        return false;
    L5:
        if (com.ss.android.socialbase.downloader.downloader.a.v() == null) goto L9;
        if (r10.isIgnoreInterceptor() == true) goto L9;
        return true;
    }

    @Override // bb.a, bb.e
    public bb.e e(h r10) {
        if (o(r10.f678c) == true) goto L7;
        return null;
    L7:
        return super.e(r10);
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadMimeTypeInterceptModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.f544h.getMimeType()) == false) goto L8;
    L12:
        r10.b();
        return;
    L8:
        if (n(this.f544h) == false) goto L12;
        throw new BaseException(1083, "download global intercept mimeType");
    }
}
