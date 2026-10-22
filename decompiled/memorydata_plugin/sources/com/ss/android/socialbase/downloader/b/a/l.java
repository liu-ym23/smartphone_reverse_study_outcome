package com.ss.android.socialbase.downloader.b.a;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class l extends com.ss.android.socialbase.downloader.b.a {
    public l() {
    }

    public static boolean a(DownloadInfo r6) {
        if (b(r6) == true) goto L28;
        return false;
    L28:
        y r2 = com.ss.android.socialbase.downloader.downloader.b.Q();     // Catch: Throwable -> L17
        boolean r3 = r2.a();     // Catch: Throwable -> L17
        if (r3 == false) goto L30;
    L14:
        if (r3 == false) goto L16;
    L15:
        r6.setInterceptFlag(1);
    L22:
        return r3;
    L16:
        r6.setInterceptFlag(0);
        goto L22
    L30:
    L12:
        th = th;
    L32:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r3 == false) goto L16;
    L23:
        th = move-exception;
        if (r3 == false) goto L26;
        r6.setInterceptFlag(1);
    L27:
        throw th;
    L26:
        r6.setInterceptFlag(0);
        goto L27
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.ss.android.socialbase.downloader.depend.b.class) == false) goto L14;
        r3 = ((com.ss.android.socialbase.downloader.depend.b) ZeusTransformUtils.preCheckCast(r2, com.ss.android.socialbase.downloader.depend.b.class, "com.obric.memorydata.plugin")).a(r6);     // Catch: Throwable -> L12
    L17:
        th = th;
        r3 = false;
        goto L32
    }

    private static boolean b(DownloadInfo r1) {
        if (r1.isFastDownload() == false) goto L5;
    L9:
        return false;
    L5:
        if (com.ss.android.socialbase.downloader.downloader.b.Q() == null) goto L9;
        if (r1.isIgnoreInterceptor() == true) goto L9;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(i r2) {
        if (b(r2.c) == true) goto L7;
        return null;
    L7:
        return super.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadMimeTypeInterceptModule", this.c, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.c.getMimeType()) == false) goto L8;
    L12:
        r6.a();
        return;
    L8:
        if (a(this.c) == false) goto L12;
        throw new BaseException(1083, "download global intercept mimeType");
    }
}
