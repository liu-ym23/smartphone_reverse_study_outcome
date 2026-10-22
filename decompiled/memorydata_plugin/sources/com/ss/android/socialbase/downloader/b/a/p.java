package com.ss.android.socialbase.downloader.b.a;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class p extends com.ss.android.socialbase.downloader.b.a {
    public p() {
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(i r2) {
        if (r2.c.isFastDownload() == false) goto L5;
        return null;
    L5:
        if (r2.f15272b.getInterceptor() != null) goto L7;
        return null;
    L7:
        if (r2.c.isIgnoreInterceptor() == false) goto L10;
        return null;
    L10:
        return super.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a("DownloadTaskInterceptModule", this.c, "proceed", "Run");
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r6.a();
        return;
    L6:
        if (this.f15250b.getInterceptor().a() == false) goto L11;
        i r4 = this.f;     // Catch: Throwable -> L9
        r4.f = RunStatus.RUN_STATUS_INTERCEPT;     // Catch: Throwable -> L9
    }
}
