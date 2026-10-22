package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ LiveCouponPresenter a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ String c;

    public i(LiveCouponPresenter r1, Function0 r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        LiveCouponPresenter.c0(this.a, (c) r7, true);
        this.b.invoke();
        LiveCouponPresenter.d0(this.a, "ttlive_live_coupon_apply", 0, new String[]{"room_id", String.valueOf(this.a.b), "meta_id", String.valueOf(this.c)});
    }
}
