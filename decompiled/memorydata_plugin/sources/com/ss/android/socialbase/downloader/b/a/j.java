package com.ss.android.socialbase.downloader.b.a;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class j extends com.ss.android.socialbase.downloader.b.a {
    private BaseException g;

    public j() {
    }

    static /* synthetic */ i a(j r0) {
        return r0.f;
    }

    static /* synthetic */ BaseException a(j r0, BaseException r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ DownloadInfo b(j r0) {
        return r0.c;
    }

    static /* synthetic */ DownloadInfo c(j r0) {
        return r0.c;
    }

    static /* synthetic */ i d(j r0) {
        return r0.f;
    }

    private boolean d() {
        if (j_() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f.f == RunStatus.RUN_STATUS_INTERCEPT) goto L14;
        if (this.f.f == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L14;
        if (this.f.f == RunStatus.RUN_STATUS_END_RIGHT_NOW) goto L14;
        if (this.f.f == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) goto L14;
        return false;
    }

    static /* synthetic */ DownloadInfo e(j r0) {
        return r0.c;
    }

    private void e() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "checkCompleted", "Run");
    L5:
        this.g = null;
        if (this.c.isChunked() == false) goto L8;
        this.c.setTotalBytes(this.c.getCurBytes());
    L8:
        this.c.setFirstDownload(false);
        if (this.c.isIgnoreDataVerify() == true) goto L17;
        if (this.c.getCurBytes() == this.c.getTotalBytes()) goto L17;
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "checkCompleted", "Error curBytes != totalBytes");
    L15:
        BaseException r0 = new BaseException(1027, "current bytes is not equals to total bytes");
    L22:
        this.g = r0;
    L33:
        if (this.g != null) goto L36;
        return;
    L36:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L38;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "checkCompleted", "Download fail and reset" + this.g);
    L38:
        this.c.reset();
        this.f15249a.a(this.c);
        this.f15249a.l(this.c.getId());
        com.ss.android.socialbase.downloader.utils.g.c(this.c);
        throw this.g;
    L17:
        if (this.c.getCurBytes() > 0) goto L24;
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L21;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "checkCompleted", "Error curBytes <=0");
    L21:
        r0 = new BaseException(1026, "curBytes <= 0");
        goto L22
    L24:
        if (this.c.isIgnoreDataVerify() == false) goto L26;
    L31:
        com.ss.android.socialbase.downloader.utils.c.a(this.c, this.f15250b.getMonitorDepend(), new AnonymousClass1(this));
        goto L33
    L26:
        if (this.c.getTotalBytes() > 0) goto L31;
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L30;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "checkCompleted", "Error totalBytes <=0");
    L30:
        r0 = new BaseException(1044, "TotalBytes <= 0");
        goto L22
    }

    static /* synthetic */ DownloadInfo f(j r0) {
        return r0.c;
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r4) {
        com.ss.android.socialbase.downloader.b.f r5 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCompleteModule", this.c, "proceed", "Run");
    L6:
        if (d() == false) goto L8;
        return;
    L8:
        e();
    }
}
