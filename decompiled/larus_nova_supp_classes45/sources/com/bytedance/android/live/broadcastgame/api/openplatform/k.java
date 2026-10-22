package com.bytedance.android.live.broadcastgame.api.openplatform;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isLynxDebugSchema");
        return StringsKt.contains$default(r4, "remote_debug_livegame", false, 2, null);
    }
}
