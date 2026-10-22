package cb;

/* JADX INFO: loaded from: classes2.dex */
public class f extends bb.a {
    public f() {
    }

    private void n() {
        long r10 = com.ss.android.socialbase.downloader.utils.c.n(this.f544h);
        long r11 = this.f544h.getCurBytes();
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadCheckTaskCanResumedModule", this.f544h.getId(), "checkTaskCanResume", "Offset:" + r10 + " curBytes: " + r11);
    L5:
        this.f544h.setCurBytes(r10);
        if (r10 <= 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L17;
        if (this.f547k.f685j == true) goto L17;
        if (lb.a.a() == false) goto L15;
        lb.a.g("DownloadCheckTaskCanResumedModule", this.f544h.getId(), "checkTaskCanResume", "deleteAllDownloadFiles");
    L15:
        this.f542c.f2(this.f544h.getId());
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);
    L17:
        if (this.f545i.n("clean_installed_apk") <= 0) goto L20;
        this.f544h.setInstalledTimeStamp(0);
        this.f544h.setHasDoInstallation(false);
        return;
    L20:
        return;
    L8:
        r12 = false;
        goto L9
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
        lb.a.g("DownloadCheckTaskCanResumedModule", this.f544h.getId(), "proceed", "Run");
    L5:
        n();
        r10.b();
    }
}
