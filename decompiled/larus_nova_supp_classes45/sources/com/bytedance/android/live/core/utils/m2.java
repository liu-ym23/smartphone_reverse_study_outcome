package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m2 {
    public static final String b(boolean r0) {
        if (r0 == false) goto L4;
        return GamePromoteDataContext.GAME_TYPE_MOBILE;
    L4:
        return "0";
    }

    public static final boolean a(Object r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$isAnyOf");
        Intrinsics.checkNotNullParameter(r5, "args");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (Intrinsics.areEqual(r5[r2], r4) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }
}
