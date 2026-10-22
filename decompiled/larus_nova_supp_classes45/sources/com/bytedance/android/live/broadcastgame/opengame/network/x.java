package com.bytedance.android.live.broadcastgame.opengame.network;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements com.bytedance.android.live.broadcastgame.api.openplatform.c {
    public static final x a = null;

    public x() {
    }

    static {
        a = new x();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.c
    public final <T> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cls");
        Lazy r0 = LiveOpenGameClient.d;
        return (T) LiveOpenGameClient.a.a().a(r2);
    }
}
