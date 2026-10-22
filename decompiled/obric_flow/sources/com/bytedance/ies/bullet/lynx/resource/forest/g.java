package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Scene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends fo.c implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rc.f f5761a;

    public g(rc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        this.f5761a = r5;
    }

    @Override // fo.c
    public final void a(String r10, final fo.b r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        zm.c r5 = com.bytedance.ies.bullet.forest.f.f5397a;
        rc.f r12 = this.f5761a;
        String r13 = u8.a.e(this, r12);
        wc.g r14 = new wc.g("");
        Intrinsics.checkNotNullParameter("template", "<set-?>");
        r14.f22840i = "template";
        r14.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r12.getAllDependency());
        com.bytedance.ies.bullet.forest.f.e(r10, r13, Scene.f4345a, u8.a.p(this, r12), r14, null, new ForestTemplateProvider$loadTemplate$2(r11), 193);
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
