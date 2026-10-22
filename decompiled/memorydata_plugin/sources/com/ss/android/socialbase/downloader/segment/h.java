package com.ss.android.socialbase.downloader.segment;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f15617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f15618b;

    h(e r3, e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        this.f15617a = r5;
        this.f15618b = r6;
    }

    @Override // com.ss.android.socialbase.downloader.segment.e
    public void b(a r2) {
        r2.f15612b = this.f15618b;
        this.f15617a.b(r2);
    }
}
