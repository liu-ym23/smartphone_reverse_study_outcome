package com.ss.android.socialbase.downloader.b.a;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c extends com.ss.android.socialbase.downloader.b.a {
    public c() {
    }

    public static void b(i r2) {
        if (r2.l.equals(r2.c.getName()) == false) goto L5;
        RunStatus r0 = RunStatus.RUN_STATUS_END_RIGHT_NOW;
    L6:
        r2.f = r0;
        r2.c.setCacheExistsInDownloading(true);
        return;
    L5:
        r0 = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        goto L6
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
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckFileExistModule", this.c, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.f.l) == true) goto L15;
        if (this.c.isExpiredRedownload() == false) goto L11;
        i r0 = this.f;
        r0.j = com.ss.android.socialbase.downloader.utils.g.a(this.c, this.c.isExpiredHttpCheck());
    L11:
        if (this.f.j == true) goto L15;
    L12:
        b(this.f);
        return;
    L15:
        if (this.c.isExpiredRedownload() == true) goto L20;
        if (this.c.isDownloaded() == false) goto L20;
        i r7 = this.f;
        r7.l = this.c.getName();
        i r8 = this.f;
        r8.k = this.c.getSavePath();
    L20:
        if (this.c.getChunkCount() <= 1) goto L22;
        this.c.reset();
        com.ss.android.socialbase.downloader.utils.g.c(this.c);
        this.f15249a.a(this.c);
    L22:
        r6.a();
    }
}
