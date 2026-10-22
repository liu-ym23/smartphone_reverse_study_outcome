package com.bytedance.android.live.base.model.message.guestlink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public static final boolean a(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isGuestBefore");
        if (r1.getUserRoleBefore() != LinkmicGuestLinkUserRoleBefore.LinkmicGuestLinkUserRoleBefore_Guest.getValue()) goto L5;
        return true;
    L5:
        return false;
    }
}
