package com.bytedance.android.live.recharge.deal;

import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public static final Single<i> a(o r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$getOrFetchDealSet");
        a r0 = r5.o0();
        if (r0 == null) goto L7;
        int r1 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single<i> r2 = Single.just(r0.b);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return r5.c(new m(0, Entrance.Recharge, FetchFrom.RechargePanel));
    }
}
