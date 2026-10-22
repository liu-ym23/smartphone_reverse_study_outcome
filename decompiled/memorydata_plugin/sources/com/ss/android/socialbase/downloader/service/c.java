package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.i f15645a;

    public c() {
    }

    private int b(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (com.ss.android.socialbase.downloader.d.b.a(r3) == false) goto L10;
        r3 = com.ss.android.socialbase.downloader.d.b.b(r3);
    L10:
        String r1 = com.ss.android.socialbase.downloader.utils.g.a(r2 + "_" + r3);
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return 0;
    L14:
        return r1.hashCode();
    }

    @Override // com.ss.android.socialbase.downloader.service.n
    public int a(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        String r0 = r3.getTaskKey();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = r3.getUrl();
    L9:
        return a(r0, r3.getSavePath());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int a(String r2, String r3) {
        com.ss.android.socialbase.downloader.downloader.i r0 = this.f15645a;
        if (r0 == null) goto L7;
        return r0.a(r2, r3);
    L7:
        return b(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.n
    public void a(com.ss.android.socialbase.downloader.downloader.i r3) {
        this.f15645a = (com.ss.android.socialbase.downloader.downloader.i) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.downloader.i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.service.n
    public boolean a() {
        if (this.f15645a != null) goto L5;
        return true;
    L5:
        return false;
    }
}
