package com.bytedance.android.live.incentive.exchange;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.scope.o;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements o, c, d {
    public final PublishSubject<f> a;
    public final com.bytedance.android.live.incentive.exchange.strategy.c b;
    public final com.bytedance.android.live.incentive.balance.d c;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.incentive.exchange.c
    public final boolean a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.live.incentive.exchange.c
    public final boolean f() {
        boolean r0 = this.b.f();
        jy0.b.a("Incentive/IncomeExchangeService", "isExchangeEnabled: " + r0);
        return r0;
    }

    public final void onStart() {
        this.b.b(new com.bytedance.android.live.incentive.exchange.strategy.c.a(this.c, this.a));
    }

    public h(com.bytedance.android.live.incentive.balance.d r2) {
        Intrinsics.checkNotNullParameter(r2, "balanceRepository");
        this.c = r2;
        this.a = PublishSubject.create();
        if (va0.a.a == false) goto L5;
        com.bytedance.android.live.incentive.exchange.strategy.c r3 = new com.bytedance.android.live.incentive.exchange.strategy.b();
    L6:
        this.b = r3;
        return;
    L5:
        r3 = com.bytedance.android.live.incentive.exchange.strategy.d.a;
        goto L6
    }

    @Override // com.bytedance.android.live.incentive.exchange.d
    public final long c(com.bytedance.android.live.incentive.balance.b r3) {
        Intrinsics.checkNotNullParameter(r3, "currencyType");
        Long r4 = this.c.c(r3);
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.longValue();
    }

    @Override // com.bytedance.android.live.incentive.exchange.c
    public final boolean d(long r4) {
        boolean r0 = this.b.d(r4);
        jy0.b.a("Incentive/IncomeExchangeService", "isExchangePossible: " + r0 + ", targetDiamond = " + r4);
        return r0;
    }

    @Override // com.bytedance.android.live.incentive.exchange.c
    public final void g(l r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        jy0.b.d("Incentive/IncomeExchangeService", "show exchange dialog, request = " + r3);
        this.b.g(r3);
    }

    @Override // com.bytedance.android.live.incentive.exchange.d
    public final void h(f r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        if (r8.b != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        IRechargeService r1 = jc1.k.f(IRechargeService.class);
        Intrinsics.checkNotNull(r1);
        zv0.f r2 = r1.rechargeCenter();
        long r3 = r2.getAvailableDiamonds();
        long r4 = ((long) r8.d) + r3;
        jy0.b.d("Incentive/IncomeExchangeService", "updating local diamond amount: " + r3 + " + " + r8.d + " = " + r4);
        r2.setAvailableDiamonds(r4);
    L8:
        this.a.onNext(r8);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.incentive.exchange.c
    public final void i(com.bytedance.android.live.incentive.balance.e r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.c.d(r2).subscribe();
    }
}
