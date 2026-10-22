package com.ss.android.socialbase.downloader.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class o extends com.ss.android.socialbase.downloader.b.a {
    public o() {
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r3) {
        com.ss.android.socialbase.downloader.b.f r4 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        this.c.updateStartDownloadTime();
        this.c.resetRealStartDownloadTime();
        this.c.setCacheExistsInDownloading(false);
        this.e.c();
        r4.a();
    }
}
