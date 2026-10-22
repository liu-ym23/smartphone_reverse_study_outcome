package com.bytedance.android.livesdk.commerce.coupon;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends com.bytedance.android.livesdk.user.h<IBaseUser> {
    public final /* synthetic */ LiveCouponPresenter a;

    public h(LiveCouponPresenter r1) {
        this.a = r1;
    }

    public final void onNext(Object r2) {
        Intrinsics.checkNotNullParameter((IBaseUser) r2, "t");
        this.a.e0();
    }
}
