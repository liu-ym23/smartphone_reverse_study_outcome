package com.bytedance.android.live.recharge.balance;

import android.util.Pair;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.x;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements g.a {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final Observable<com.bytedance.android.live.recharge.l> c(Observable<com.bytedance.android.live.recharge.l> r5) {
        Intrinsics.checkNotNullParameter(r5, "upstream");
        return RxUtilKt.h(RxCompatKt.b(r5, new com.bytedance.android.live.core.utils.rxutils.l(3, 3000)));
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r2, "request");
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void a(f r3, com.bytedance.android.live.recharge.l r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "walletInfo");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "walletInfo");
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void b(uz0.c r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$buildNetworkRequest");
        Intrinsics.checkNotNullParameter(r4, "request");
        x.a(r3, true);
        r3.a(new zw0.d());
        Pair r5 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(r4));
        String r0 = (String) r5.first;
        String r6 = (String) r5.second;
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r3.a.put(r0, r6);
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void e(f r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "throwable");
    }
}
