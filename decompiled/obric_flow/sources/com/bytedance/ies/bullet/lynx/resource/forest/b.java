package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import com.bytedance.forest.model.Scene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ln.b, com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5754b;

    public b(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "downloadEngine");
        this.f5753a = r5;
        this.f5754b = r10;
    }

    @Override // ln.b
    public final void a(String r11, zm.c r12) {
        Intrinsics.checkNotNullParameter(r11, "url");
        if (r11.length() != 0) goto L5;
        return;
    L5:
        String r5 = "ForestDynamicComponentProvider start to load ".concat(r11);
        Intrinsics.checkNotNullParameter(r5, "msg");
        dc.b.f16633a.c("[ResourceLoader] " + r5);
        String r10 = Uri.parse(r11).getQueryParameter("forest_sync_load");
        if (r10 != null) goto L8;
        r10 = "0";
    L8:
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5397a;
        Scene r14 = Scene.f4347c;
        ForestDynamicComponentProvider$loadResource$1 r15 = new ForestDynamicComponentProvider$loadResource$1(r10, r12, this, r11);
        com.bytedance.ies.bullet.forest.f.e(r11, this.f5753a, r14, this.f5754b, null, null, r15, 225);
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
