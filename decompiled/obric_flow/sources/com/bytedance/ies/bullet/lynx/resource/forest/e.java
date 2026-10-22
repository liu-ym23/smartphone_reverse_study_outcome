package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import fo.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements i, com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rc.f f5759a;

    public e(rc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        this.f5759a = r5;
    }

    @Override // fo.i
    public final void a(final fo.e r11, final fo.d r12) {
        Intrinsics.checkNotNullParameter(r11, "requestParams");
        final fo.f r5 = new fo.f();
        zm.c r10 = com.bytedance.ies.bullet.forest.f.f5397a;
        rc.f r13 = this.f5759a;
        String r14 = u8.a.e(this, r13);
        wc.g r15 = new wc.g("");
        r15.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r13.getAllDependency());
        Scene r16 = Scene.f4350j;
        String r17 = u8.a.p(this, r13);
        Function1<w, Unit> r18 = new ForestLynxRequestProvider$request$2(r5, r12, r11);
        com.bytedance.ies.bullet.forest.f.e(r11.f16961a, r14, r16, r17, r15, null, r18, 193);
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
