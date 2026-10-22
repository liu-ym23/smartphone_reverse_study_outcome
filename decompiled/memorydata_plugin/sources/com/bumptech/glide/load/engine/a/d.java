package com.bumptech.glide.load.engine.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.a.a.InterfaceC0065a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f722b;

    public interface a {
        File a();
    }

    public d(a r3, long r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f721a = r4;
        this.f722b = r5;
    }

    @Override // com.bumptech.glide.load.engine.a.a.InterfaceC0065a
    public com.bumptech.glide.load.engine.a.a a() {
        File r0 = this.f722b.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isDirectory() == true) goto L12;
        if (r0.mkdirs() == true) goto L12;
        return null;
    L12:
        return e.a(r0, this.f721a);
    }
}
