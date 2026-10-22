package com.bytedance.android.live.broadcastgame.opengame;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends b7.a {
    public d() {
    }

    public final boolean onFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        int r0 = q.a;
        q.e("AudiencePluginManager", new Object[]{"show magic box lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
        return super.onFallback(r4, r5);
    }
}
