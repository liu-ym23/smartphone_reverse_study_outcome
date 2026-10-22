package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LiveCouponPresenter a;
    public final /* synthetic */ String b;

    public j(LiveCouponPresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        LiveCouponPresenter.c0(this.a, null, false);
        LiveCouponPresenter.d0(this.a, "ttlive_live_coupon_apply", 1, new String[]{"room_id", String.valueOf(this.a.b), "meta_id", String.valueOf(this.b)});
    }
}
