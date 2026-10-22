package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ u a;

    public o(u r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        final ExchangeInfo r4 = (ExchangeInfo) r3;
        this.a.j.onNext(v.a(r4));
        this.a.g("observeExchange", new GiftRechargeDataStore$observeExchange$1$1(this, r4));
    }
}
