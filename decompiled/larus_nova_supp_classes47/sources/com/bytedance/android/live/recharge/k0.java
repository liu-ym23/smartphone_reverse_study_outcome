package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public k0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExchangeInfo r4 = (ExchangeInfo) r3;
        int r0 = r4.getExchangeBalance();
        int r1 = r0 % 10;
        if (r1 <= 0) goto L5;
        r4.setExchangeBalance(r0 - r1);
    L5:
        this.a.l.a(r4);
        this.a.G.onNext(r4);
    }
}
