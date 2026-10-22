package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final boolean b(i r1) {
        if (r1 == null) goto L8;
        IOneKeyPay r2 = r1.f();
        if (r2 == null) goto L8;
        if (r2.getSupportOneKeyPay() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static d a(i r1, long r2, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        r4 = false;
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$createCustomDeal");
        d r3 = e.a(r1.k(), r2, r4, false);
        if (r3 == null) goto L8;
        r3.a(r1);
        return r3;
    L8:
        return null;
    }
}
