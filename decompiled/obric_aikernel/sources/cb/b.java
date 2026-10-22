package cb;

/* JADX INFO: loaded from: classes2.dex */
public class b extends bb.a {
    public b() {
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
        lb.a.g("DownloadBandwidthSamplerModule", this.f544h.getId(), "proceed", "Run");
    L5:
        com.ss.android.socialbase.downloader.downloader.a.h0(this.f543g, 3);
        nb.b.d().i();
        r10.b();
        nb.b.d().j();
        com.ss.android.socialbase.downloader.downloader.a.g0(this.f543g, 3);
    }
}
