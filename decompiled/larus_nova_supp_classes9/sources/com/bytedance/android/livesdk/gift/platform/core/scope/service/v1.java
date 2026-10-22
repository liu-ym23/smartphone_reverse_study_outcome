package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class v1 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ReceiverType.values().length];
        a = r0;
        r0[ReceiverType.Anchor.ordinal()] = 1;
        r0[ReceiverType.Guest.ordinal()] = 2;
        r0[ReceiverType.Audience.ordinal()] = 3;
        r0[ReceiverType.OtherAnchor.ordinal()] = 4;
        int[] r1 = new int[CardType.values().length];
        b = r1;
        r1[CardType.DIY.ordinal()] = 1;
        r1[CardType.Buff.ordinal()] = 2;
    }
}
