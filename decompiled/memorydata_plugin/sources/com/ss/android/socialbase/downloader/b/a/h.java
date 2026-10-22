package com.ss.android.socialbase.downloader.b.a;

import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class h extends com.ss.android.socialbase.downloader.b.a {
    public h() {
    }

    public static void a(DownloadInfo r1) {
        if (r1.isFastDownload() == false) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.network.b.g() == false) goto L8;
        return;
    L8:
        if (r1.isOnlyWifi() == false) goto L15;
        com.ss.android.socialbase.downloader.network.b.f();
        if (com.ss.android.socialbase.downloader.network.b.h() == false) goto L15;
        throw new DownloadOnlyWifiException();
    L15:
        if (r1.isDownloadFromReserveWifi() == true) goto L17;
        return;
    L17:
        if (r1.isPauseReserveOnWifi() == false) goto L25;
        com.ss.android.socialbase.downloader.network.b.f();
        if (com.ss.android.socialbase.downloader.network.b.h() == true) goto L22;
        return;
    L22:
        throw new DownloadPauseReserveWifiException();
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
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckWifiTaskValidModule", this.c, "proceed", "Run");
    L5:
        a(this.c);
        r6.a();
    }
}
