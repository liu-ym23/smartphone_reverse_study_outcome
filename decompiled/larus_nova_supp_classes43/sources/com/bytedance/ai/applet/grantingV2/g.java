package com.bytedance.ai.applet.grantingV2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final boolean c(String r1) {
        if (Intrinsics.areEqual(r1, "pending") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "revoked") == true) goto L8;
        return false;
    }

    public static final b a(String r1, String r10) {
        if (c(r1) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r10, "expired") == true) goto L8;
        return null;
    L8:
        String r11 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_dyAuth_Card_desc_expired_cn");
        if (r11 != null) goto L12;
        r11 = "已过期，暂无法操作";
    L12:
        return new b(r11, false);
    }

    public static final boolean b(u2.f r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "item");
        if (c(r1.c()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10, "expired") == false) goto L7;
        return true;
    }
}
