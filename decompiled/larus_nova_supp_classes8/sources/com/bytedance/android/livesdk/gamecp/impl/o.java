package com.bytedance.android.livesdk.gamecp.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements dw.j {
    public o() {
    }

    public final void openMiniGamePlayGame(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "startParmaMap");
    }

    public final void preloadMiniGamePlayGame(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
    }
}
