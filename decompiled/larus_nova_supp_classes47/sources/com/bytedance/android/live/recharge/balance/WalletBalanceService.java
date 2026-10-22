package com.bytedance.android.live.recharge.balance;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class WalletBalanceService implements o, d {
    public static final com.bytedance.android.live.recharge.balance.c f = null;
    public final com.bytedance.android.live.revenue.common.reactive.c a;
    public final g b;
    public final com.bytedance.android.live.revenue.common.reactive.c c;
    public final com.bytedance.android.live.revenue.common.reactive.a d;
    public final b e;

    public static final class a {
    }

    public static final class b implements g.a {
        public final /* synthetic */ WalletBalanceService a;

        public b(WalletBalanceService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.balance.g.a
        public final Observable<com.bytedance.android.live.recharge.l> c(Observable<com.bytedance.android.live.recharge.l> r2) {
            Intrinsics.checkNotNullParameter(r2, "upstream");
            Intrinsics.checkNotNullParameter(r2, "upstream");
            return r2;
        }

        @Override // com.bytedance.android.live.recharge.balance.g.a
        public final void d(f r3) {
            Intrinsics.checkNotNullParameter(r3, "request");
            jy0.b.a("Recharge/WalletBalanceService", "update balance begin, request = " + r3);
        }

        @Override // com.bytedance.android.live.recharge.balance.g.a
        public final void a(f r4, com.bytedance.android.live.recharge.l r5) {
            Intrinsics.checkNotNullParameter(r4, "request");
            Intrinsics.checkNotNullParameter(r5, "walletInfo");
            long r1 = r5.getDiamond();
            u0 r6 = u0.f;
            com.bytedance.android.live.recharge.balance.c r0 = new com.bytedance.android.live.recharge.balance.c(r1, r4, t0.b());
            this.a.a.setValue(r0);
            jy0.b.d("Recharge/WalletBalanceService", "update balance complete, request = " + r4 + ", diamond = " + r0.a);
        }

        @Override // com.bytedance.android.live.recharge.balance.g.a
        public final void b(uz0.c r3, f r4) {
            Intrinsics.checkNotNullParameter(r3, "$this$buildNetworkRequest");
            Intrinsics.checkNotNullParameter(r4, "request");
            Intrinsics.checkNotNullParameter(r3, "$this$buildNetworkRequest");
            Intrinsics.checkNotNullParameter(r4, "request");
        }

        @Override // com.bytedance.android.live.recharge.balance.g.a
        public final void e(f r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r4, "throwable");
            jy0.b.e("Recharge/WalletBalanceService", "update balance error, request = " + r3, r4);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ WalletBalanceService a;

        public c(WalletBalanceService r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.recharge.l) r2, "it");
            return (com.bytedance.android.live.recharge.balance.c) this.a.c.b;
        }
    }

    public final void onStop() {
    }

    static {
        f = new com.bytedance.android.live.recharge.balance.c(0, new f("<local>", null), u0.f);
    }

    public final void onStart() {
        g r0 = this.b;
        b r1 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "processor");
        List<g.a> r2 = g.a;
        ((ArrayList) r2).add(r1);
        g r3 = this.b;
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        com.bytedance.android.live.recharge.balance.b r4 = com.bytedance.android.live.recharge.balance.b.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "processor");
        ((ArrayList) r2).add(r4);
        e r5 = e.b;
        Intrinsics.checkNotNullParameter(r5, "processor");
        ((ArrayList) r2).add(r5);
    }

    public WalletBalanceService() {
        com.bytedance.android.live.revenue.common.reactive.c r1 = new com.bytedance.android.live.revenue.common.reactive.c(f);
        this.a = r1;
        this.b = g.b;
        this.c = r1;
        WalletBalanceService$diamondBalance$1 r0 = WalletBalanceService$diamondBalance$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "$this$map");
        Intrinsics.checkNotNullParameter(r0, "mapper");
        this.d = new com.bytedance.android.live.revenue.common.reactive.a(r1, r0);
        this.e = new b(this);
    }

    @Override // com.bytedance.android.live.recharge.balance.d
    public final com.bytedance.android.live.revenue.common.reactive.c U() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.balance.d
    public final com.bytedance.android.live.revenue.common.reactive.a n() {
        return this.d;
    }

    @Override // com.bytedance.android.live.recharge.balance.d
    public final Observable<com.bytedance.android.live.recharge.balance.c> C1(final f r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        l01.d r1 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
        if (r1.isLogin() == false) goto L5;
        IBaseUser r2 = r1.b();
    L6:
        if (r2 != null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.l r5 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.error(new IllegalStateException("user is not logged in"));
    L9:
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r4, "request");
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        final String r3 = "/webcast/wallet/info/";
        final Function0<Observable<ExtraResponse<com.bytedance.android.live.recharge.l, Extra>>> r6 = new WalletInfoApiDataSource$makeRequestObservable$1(r3, r4);
        Observable r7 = Observable.defer(new h(r6));
        int r8 = p.a;
        Observable<com.bytedance.android.live.recharge.l> r9 = r7.subscribeOn(Schedulers.io()).map(new i());
        Iterator r10 = CollectionsKt.toList(g.a).iterator();
    L11:
        if (r10.hasNext() == false) goto L14;
        r9 = ((g.a) r10.next()).c(r9);
        goto L11
    L14:
        return r9.doOnSubscribe(new j(r4)).doOnNext(new k(r4)).doOnError(new l(r4)).map(new c(this));
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.recharge.balance.d
    public final void x1(long r6) {
        com.bytedance.android.live.revenue.common.reactive.c r0 = this.a;
        f r2 = new f("<local>", null);
        u0 r3 = u0.f;
        r0.setValue(new com.bytedance.android.live.recharge.balance.c(r6, r2, t0.b()));
        jy0.b.d("Recharge/WalletBalanceService", "set diamond balance complete, diamond = " + r6);
    }
}
