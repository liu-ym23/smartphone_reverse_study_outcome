package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        qo0.a.b("AnchorCouponContextService", "get coupon entrance info fail, error: ", r4);
        this.a.invoke(r4);
    }
}
