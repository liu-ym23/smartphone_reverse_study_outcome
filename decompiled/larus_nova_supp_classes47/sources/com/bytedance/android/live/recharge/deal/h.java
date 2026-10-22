package com.bytedance.android.live.recharge.deal;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements com.bytedance.android.scope.o, o {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.recharge.deal.a r0 = l.a;
            m r1 = this.a;
            com.bytedance.android.live.recharge.deal.a r2 = new com.bytedance.android.live.recharge.deal.a(r1, (i) r3);
            Intrinsics.checkNotNullParameter(r2, "dealSet");
            if (c.a(r2) == false) goto L5;
            jy0.b.a("Recharge/DealSetMemoryCache", "cache write");
            l.a = r2;
            return;
        L5:
            jy0.b.a("Recharge/DealSetMemoryCache", "clear cache");
            l.a = null;
        }
    }

    public h() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.deal.o
    public final com.bytedance.android.live.recharge.deal.a o0() {
        com.bytedance.android.live.recharge.deal.a r0 = l.a;
        com.bytedance.android.live.recharge.deal.a r1 = l.a;
        if (r1 != null) goto L5;
        jy0.b.a("Recharge/DealSetMemoryCache", "cache miss");
    L6:
        return r1;
    L5:
        jy0.b.a("Recharge/DealSetMemoryCache", "cache hit");
        goto L6
    }

    @Override // com.bytedance.android.live.recharge.deal.o
    public final Single<i> c(final m r3) {
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        List<DealSetApiDataSource.b> r1 = DealSetApiDataSource.a;
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        jy0.b.a("Recharge/DealSetApiDataSource", "requestDealSet, " + DealSetApiDataSource.c(r3));
        return DealSetApiDataSource.e(new DealSetApiDataSource$requestDealSet$1(r3)).doOnSuccess(new a(r3));
    }
}
