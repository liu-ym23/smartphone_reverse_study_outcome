package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final BehaviorSubject<oc6.m0> b;
    public final i12.e c;
    public final uz1.a d;

    public final void onStart() {
        this.a.add(jc1.k.n(IRechargeService.class).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new l0(this), m0.a));
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == true) goto L6;
        this.a.add(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().filter(j0.a).subscribe(new k0(this)));
        return;
    }

    public final void onStop() {
        this.a.clear();
    }

    public n0(DataCenter r2, i12.e r3, uz1.a r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "giftMVIFacade");
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
        oc6.m0 r5 = new oc6.m0();
        IRechargeService r6 = jc1.k.f(IRechargeService.class);
        if (r6 == null) goto L7;
        zv0.f r7 = r6.rechargeCenter();
        if (r7 == null) goto L7;
        long r8 = r7.getAvailableDiamonds();
    L8:
        r5.b(r8);
        Unit r9 = Unit.INSTANCE;
        this.b = BehaviorSubject.createDefault(r5);
        return;
    L7:
        r8 = 0;
        goto L8
    }
}
