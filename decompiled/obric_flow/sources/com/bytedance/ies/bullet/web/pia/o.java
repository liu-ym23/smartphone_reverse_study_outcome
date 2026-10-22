package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f6244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.kit.resourceloader.d f6245c;

    public o(q r5, com.bytedance.ies.bullet.kit.resourceloader.d r10) {
        this.f6244b = r5;
        this.f6245c = r10;
    }

    @Override // fh.c
    public final void release() {
        ConcurrentHashMap r5 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r10 = com.bytedance.ies.bullet.kit.resourceloader.g.a(this.f6244b.f6247a);
        r10.getClass();
        com.bytedance.ies.bullet.kit.resourceloader.d r11 = this.f6245c;
        Intrinsics.checkNotNullParameter(r11, "task");
        LinkedHashMap r12 = r10.g;
        com.bytedance.ies.bullet.kit.resourceloader.pipeline.a r13 = (com.bytedance.ies.bullet.kit.resourceloader.pipeline.a) r12.get(r11);
        if (r13 == null) goto L7;
        r13.e = true;
        IXResourceLoader r14 = r13.g;
        if (r14 == null) goto L7;
        r14.cancelLoad();
    L7:
        r12.remove(r11);
    }
}
