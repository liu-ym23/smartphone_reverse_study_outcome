package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r1 extends b7.a {
    public r1() {
    }

    public final boolean onFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("XplayUtils", new Object[]{"show lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
        return super.onFallback(r4, r5);
    }
}
