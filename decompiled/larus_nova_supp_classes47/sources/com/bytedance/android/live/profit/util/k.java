package com.bytedance.android.live.profit.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static h a(Function0 r2, Function0 r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = ProfitUtilsKt$createFrescoPlayOnceControllerListener$1.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = ProfitUtilsKt$createFrescoPlayOnceControllerListener$2.INSTANCE;
    L9:
        if ((r5 & 4) == 0) goto L11;
        boolean r0 = true;
    L13:
        if ((r5 & 8) == 0) goto L15;
        r4 = false;
    L15:
        Intrinsics.checkNotNullParameter(r2, "onStart");
        Intrinsics.checkNotNullParameter(r3, "onEnd");
        return new h(r2, r3, r4, r0);
    L11:
        r0 = false;
        goto L13
    }
}
