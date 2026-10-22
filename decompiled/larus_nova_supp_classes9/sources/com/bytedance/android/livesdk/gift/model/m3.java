package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m3 {
    public static final boolean a(l3 r4, l3 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$equal");
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l3) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r4.getName(), r5.getName()) == true) goto L11;
    L15:
        return false;
    L11:
        if (r4.getFullSend() != r5.getFullSend()) goto L15;
        if (Intrinsics.areEqual(r4.getSeriesGiftList(), r5.getSeriesGiftList()) == false) goto L15;
        return true;
    }
}
