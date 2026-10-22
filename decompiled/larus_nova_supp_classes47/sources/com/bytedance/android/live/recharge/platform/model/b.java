package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.ChargeDeal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final ChargeDeal a(long r1, int r3, boolean r4) {
        ChargeDeal r0 = new ChargeDeal();
        r0.setId(r1);
        r0.setPrice(r3);
        r0.setExchangePrice(r3);
        r0.setDiamondCount(r3 / 10);
        r0.setDescribe(s1.B(2131918929));
        r0.setCustomizedDiamond(r4);
        return r0;
    }
}
