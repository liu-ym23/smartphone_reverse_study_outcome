package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z implements x9.b {
    public z() {
    }

    public final void logV3(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "extra");
        j0.l().sendLog(r3, r4, new Object[0]);
    }

    public final void t(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "map");
        Map r5 = MapsKt.toMutableMap(r4);
        r5.put("no_prefix", GamePromoteDataContext.GAME_TYPE_MOBILE);
        j0.l().e(r3, r5, new Object[0]);
    }
}
