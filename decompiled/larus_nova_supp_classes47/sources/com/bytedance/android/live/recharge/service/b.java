package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.event.v;
import io.reactivex.functions.Consumer;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        if ((r2 instanceof x2) == false) goto L6;
        a.a(this.a, (x2) r2);
        return;
    L6:
        if ((r2 instanceof v) == false) goto L10;
        v r3 = (v) r2;
        this.a.getClass();
        int r4 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "recharge success, fetch wallet info.");
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge");
        return;
    }
}
