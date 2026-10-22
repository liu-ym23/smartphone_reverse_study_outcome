package com.bytedance.ies.bullet.lynx.resource;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends fo.c implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rc.f f5727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.bullet.lynx.resource.forest.g f5728b;

    public e(rc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "_token");
        this.f5727a = r5;
        this.f5728b = new com.bytedance.ies.bullet.lynx.resource.forest.g(r5);
    }

    @Override // fo.c
    public final void a(String r5, final fo.b r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        rc.f r11 = this.f5727a;
        if (u8.a.t(this, r11) == false) goto L6;
        this.f5728b.a(r5, r10);
        return;
    L6:
        ConcurrentHashMap r12 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r13 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r11.getBid());
        wc.g r14 = new wc.g("");
        Intrinsics.checkNotNullParameter("template", "<set-?>");
        r14.f22840i = "template";
        r14.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r11.getAllDependency());
        Unit r15 = Unit.INSTANCE;
        r13.a(r5, r14, new DefaultTemplateProvider$loadTemplate$2(r10), new DefaultTemplateProvider$loadTemplate$3(r10));
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
