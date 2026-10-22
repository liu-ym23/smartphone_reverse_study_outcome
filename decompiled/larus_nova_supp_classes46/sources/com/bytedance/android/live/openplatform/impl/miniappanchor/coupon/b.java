package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorCouponContextService a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;

    public b(AnchorCouponContextService r1, int r2, Function1 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void accept(Object r4) {
        e r5 = (e) r4;
        if (((com.bytedance.android.live.openplatform.api.model.coupon.a) r5.data).c() != 0) goto L5;
        int r0 = qo0.a.a;
        qo0.a.c("AnchorCouponContextService", "get coupon entrance info success, data: " + ((com.bytedance.android.live.openplatform.api.model.coupon.a) r5.data));
        this.a.a.put(Integer.valueOf(this.b), (com.bytedance.android.live.openplatform.api.model.coupon.a) r5.data);
        this.c.invoke(r5.data);
        return;
    L5:
        qo0.a.b("AnchorCouponContextService", "get coupon entrance info fail, data is null", null);
        this.d.invoke(new Throwable("entrance info is null"));
    }
}
