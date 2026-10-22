package com.ss.android.socialbase.downloader.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b extends com.ss.android.socialbase.downloader.b.a {
    public b() {
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
        com.ss.android.socialbase.downloader.e.a.a("DownloadBandwidthSamplerModule", this.c, "proceed", "Run");
    L5:
        com.ss.android.socialbase.downloader.downloader.b.a(this.f15250b, 3);
        com.ss.android.socialbase.downloader.network.b.a().b();
        r6.a();
        com.ss.android.socialbase.downloader.network.b.a().d();
        com.ss.android.socialbase.downloader.downloader.b.b(this.f15250b, 3);
    }
}
