package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0 {
    public static final boolean a(k0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$isLocked");
        if (r5.getLockStatus() != k0.LOCKED_GRAY) goto L5;
    L8:
        return true;
    L5:
        if (r5.getLockStatus() == k0.LOCKED_NORMAL) goto L8;
        return false;
    }
}
