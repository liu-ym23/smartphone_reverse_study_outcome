package cb;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class j extends bb.a {
    public j() {
    }

    private void n() {
        int r10 = this.f544h.getId();
        boolean r11 = this.f542c.A0();
        DownloadInfo r12 = this.f542c.a(r10);
        if (r12 != null) goto L9;
        if (r11 == true) goto L6;
    L7:
        r12 = ((com.ss.android.socialbase.downloader.impls.b) this.f542c).r().a(r10);
        goto L9
    L6:
        if (com.ss.android.socialbase.downloader.utils.c.v(com.ss.android.socialbase.downloader.utils.c.s(), com.ss.android.socialbase.downloader.utils.c.r(), com.ss.android.socialbase.downloader.utils.c.o(), this.f544h.getMimeType(), this.f544h.getMonitorScene()) == true) goto L7;
    L9:
        if (lb.a.a() == false) goto L11;
        lb.a.g("DownloadLoadCacheModule", this.f544h.getId(), "doLoadCache", "Find Cache:" + r11 + "CacheDownloadInfo" + r12);
    L11:
        boolean r13 = true;
        if (r12 != null) goto L14;
    L35:
        this.f544h.reset();
        if (lb.a.a() == false) goto L38;
        lb.a.g("DownloadLoadCacheModule", this.f544h.getId(), "doLoadCache", "Download reset");
    L38:
        if (r13 == false) goto L41;
        this.f542c.b(this.f544h);
    L41:
        if (lb.a.a() == false) goto L44;
        lb.a.g("DownloadLoadCacheModule", this.f544h.getId(), "doLoadCache", "After load:" + this.f544h);
        return;
    L44:
        return;
    L14:
        if (r12.isNewTask() == true) goto L35;
        if (r12.isForce() == true) goto L35;
        if (this.f544h.getStartOffset() != r12.getStartOffset()) goto L35;
        if (this.f544h.getEndOffset() != r12.getEndOffset()) goto L35;
        this.f544h.copyFromCacheData(r12, true);
        DownloadInfo r14 = this.f544h;
        if (r12 == r14) goto L25;
        boolean r15 = true;
    L27:
        if (r14.getSavePath().equals(r12.getSavePath()) == false) goto L32;
        if (r12.isDownloaded() == false) goto L32;
        this.f547k.f687l = r12.getName();
        this.f547k.f686k = r12.getSavePath();
    L34:
        r13 = r15;
    L32:
        if (com.ss.android.socialbase.downloader.downloader.a.t(r12) == r10) goto L34;
        this.f542c.j(r10);
        goto L38
    L25:
        r15 = false;
        goto L27
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
        lb.a.g("DownloadLoadCacheModule", this.f544h.getId(), "proceed", "Run");
    L5:
        n();
        if (m() == false) goto L8;
        return;
    L8:
        r10.b();
    }
}
