package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    static {
    }

    public static int a(l2 r9) {
        Intrinsics.checkNotNullParameter(r9, "prop");
        h1 r0 = r9.getGift();
        long r1 = r0.getPrimaryEffectId();
        if (r0.getId() != 0) goto L5;
        return 0;
    L5:
        boolean r3 = true;
        if (GiftManagerKt.l(r9.getGift().getId()) != null) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        return 1;
    L12:
        if (j0.a(r0) == true) goto L15;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L21;
        return 2;
    L21:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r1) == true) goto L24;
        return 3;
    L24:
        return 0;
    L15:
        if (((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r0.getPrimaryEffectId()) == null) goto L17;
    L8:
        r10 = false;
        goto L9
    }
}
