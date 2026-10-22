package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import com.bytedance.android.live.broadcastgame.opengame.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends b7.a {
    public c() {
    }

    public final boolean onFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        int r0 = q.a;
        q.e("ToolbarInteractPlayControlBehavior", new Object[]{"show rev link lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
        return super.onFallback(r4, r5);
    }
}
