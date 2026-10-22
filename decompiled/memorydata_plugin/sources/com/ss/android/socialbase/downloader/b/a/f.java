package com.ss.android.socialbase.downloader.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f extends com.ss.android.socialbase.downloader.b.a {
    public f() {
    }

    private void d() {
        long r0 = com.ss.android.socialbase.downloader.utils.c.b(this.c);
        long r2 = this.c.getCurBytes();
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckTaskCanResumedModule", this.c, "checkTaskCanResume", "Offset:" + r0 + " curBytes: " + r2);
    L5:
        this.c.setCurBytes(r0);
        if (r0 <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        if (this.f.j == true) goto L17;
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckTaskCanResumedModule", this.c, "checkTaskCanResume", "deleteAllDownloadFiles");
    L15:
        this.f15249a.l(this.c.getId());
        com.ss.android.socialbase.downloader.utils.g.c(this.c);
    L17:
        if (this.d.b("clean_installed_apk") <= 0) goto L20;
        this.c.setInstalledTimeStamp(0);
        this.c.setHasDoInstallation(false);
        return;
    L20:
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(i r2) {
        if (r2.c.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckTaskCanResumedModule", this.c, "proceed", "Run");
    L5:
        d();
        r6.a();
    }
}
