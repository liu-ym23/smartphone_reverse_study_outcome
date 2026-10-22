package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ LiveCouponPresenter a;

    public l(LiveCouponPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        LiveCouponPresenter.d0(this.a, "ttlive_live_coupon_getcurrent", 1, new String[]{"room_id", String.valueOf(this.a.b)});
        LiveCouponPresenter.b r8 = (LiveCouponPresenter.b) ((q46.b) this.a).a;
        if (r8 == null) goto L6;
        r8.Z80();
        return;
    }
}
