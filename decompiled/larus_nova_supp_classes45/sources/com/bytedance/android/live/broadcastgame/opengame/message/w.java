package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w implements com.bytedance.android.live.broadcastgame.v {
    public final com.bytedance.android.live.broadcastgame.api.openplatform.a a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof w) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((w) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.live.broadcastgame.api.openplatform.a r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "GameIntroCardMessage(cardInfo=" + this.a + ")";
    }

    public w(com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cardInfo");
        this.a = r2;
    }
}
