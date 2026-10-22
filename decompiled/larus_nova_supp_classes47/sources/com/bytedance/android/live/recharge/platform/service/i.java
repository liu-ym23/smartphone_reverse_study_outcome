package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements com.bytedance.android.live.recharge.deal.p {
    public final IChargeDeal a;

    @Override // com.bytedance.android.live.recharge.deal.p
    public final IChargeDeal a() {
        return this.a;
    }

    public i(ExtraResponse r1) {
        this.a = ((com.bytedance.android.live.recharge.model.diamond.a) r1.extra).n();
    }
}
