package com.ss.android.socialbase.downloader.downloader;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class u implements b.a {
    public u() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b.a
    public n a() {
        return new com.ss.android.socialbase.downloader.impls.i();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b.a
    public s a(b.a.InterfaceC0826a r2) {
        b.a.InterfaceC0826a r1 = (b.a.InterfaceC0826a) ZeusTransformUtils.wrapperContextForParams(r2, b.a.InterfaceC0826a.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.c.f r3 = new com.ss.android.socialbase.downloader.c.f();
        r3.a(r1);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b.a
    public l b() {
        return new com.ss.android.socialbase.downloader.impls.j();
    }
}
