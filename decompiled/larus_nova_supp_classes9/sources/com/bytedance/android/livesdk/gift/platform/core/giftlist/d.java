package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        String r4 = "[GIFT_LIST]".concat(r2);
        if (r3 != null) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        jy0.b.c(r4, r3, null, 4);
    }
}
