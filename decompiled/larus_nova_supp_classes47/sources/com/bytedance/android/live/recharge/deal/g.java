package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final int a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cashAmount");
        if ((r1 instanceof n) == true) goto L5;
        r1 = null;
    L5:
        n r2 = (n) r1;
        if (r2 != null) goto L10;
        return 0;
    L10:
        return r2.f;
    }

    public static final int b(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$goldAmount");
        if ((r1 instanceof n) == true) goto L5;
        r1 = null;
    L5:
        n r2 = (n) r1;
        if (r2 != null) goto L10;
        return 0;
    L10:
        return r2.g;
    }

    public static final com.bytedance.android.live.recharge.platform.business.model.diamond.g c(f r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$panelExtraInfo");
        return r3.c().getPanelExtraInfo().get(Long.valueOf(r3.g()));
    }
}
