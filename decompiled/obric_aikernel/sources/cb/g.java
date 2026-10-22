package cb;

import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class g extends bb.a {
    public g() {
    }

    public static void n(DownloadInfo r10) {
        if (r10.isFastDownload() == false) goto L5;
        return;
    L5:
        if (nb.b.f() == false) goto L8;
        return;
    L8:
        if (r10.isOnlyWifi() == false) goto L15;
        nb.b.k();
        if (nb.b.e() == false) goto L15;
        throw new DownloadOnlyWifiException();
    L15:
        if (r10.isDownloadFromReserveWifi() == true) goto L17;
        return;
    L17:
        if (r10.isPauseReserveOnWifi() == false) goto L25;
        nb.b.k();
        if (nb.b.e() == true) goto L22;
        return;
    L22:
        throw new DownloadPauseReserveWifiException();
    }

    @Override // bb.a, bb.e
    public bb.e e(h r10) {
        if (r10.f678c.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.e(r10);
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadCheckWifiTaskValidModule", this.f544h.getId(), "proceed", "Run");
    L5:
        n(this.f544h);
        r10.b();
    }
}
