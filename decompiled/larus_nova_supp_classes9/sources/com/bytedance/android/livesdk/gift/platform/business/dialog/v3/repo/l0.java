package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeInfoChange;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ n0 a;

    public l0(n0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        this.a.d.a(new RechargeInfoChange());
        BehaviorSubject<oc6.m0> r6 = this.a.b;
        oc6.m0 r0 = new oc6.m0();
        this.a.getClass();
        IRechargeService r1 = jc1.k.f(IRechargeService.class);
        if (r1 == null) goto L7;
        zv0.f r2 = r1.rechargeCenter();
        if (r2 == null) goto L7;
        long r3 = r2.getAvailableDiamonds();
    L8:
        r0.b(r3);
        Unit r7 = Unit.INSTANCE;
        r6.onNext(r0);
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
