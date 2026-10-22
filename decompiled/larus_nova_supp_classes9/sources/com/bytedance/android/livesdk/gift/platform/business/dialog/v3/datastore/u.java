package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import oc6.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends BaseMVIDataStore<u> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] n = null;
    public final CompositeDisposable e;
    public final int f;
    public final BehaviorSubject<m0> g;
    public final BehaviorSubject<m0> h;
    public final ReadOnlyProperty i;
    public final BehaviorSubject<oc6.e> j;
    public final BehaviorSubject<oc6.e> k;
    public final ReadOnlyProperty l;
    public final com.bytedance.android.live.recharge.k m;

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(u.class, "availableDiamond", "getAvailableDiamond()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(u.class, "exchangeInfo", "getExchangeInfo()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final long k() {
        zv0.f r0 = this.m.rechargeCenter();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getAvailableDiamonds();
    }

    public final void onStart() {
        this.m.rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
        RxUtilKt.c(this.m.rechargeCenter().observeExchangeInfo().compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), p.a), this.e);
        RxUtilKt.c(this.m.rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new s(this), t.a), this.e);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L7;
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L8;
        r0.k6();
    L8:
        com.bytedance.android.live.core.utils.rxutils.j.a r1 = com.bytedance.android.live.core.utils.rxutils.j.a;
        RxUtilKt.c(com.bytedance.android.live.core.utils.rxutils.j.c(1, TimeUnit.SECONDS).take(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this)), this.e);
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == false) goto L16;
        int r2 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.recharge.util.d.b(s1.getContext()) == false) goto L17;
        ou0.a r3 = yt0.c.d();
        if (r3 == null) goto L18;
        r3.mn();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().filter(q.a).subscribe(new r(this)), this.e);
        goto L8
    }

    public final void onStop() {
        this.e.clear();
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == false) goto L8;
        ou0.a r0 = yt0.c.d();
        if (r0 == null) goto L9;
        r0.mn();
        return;
    L9:
        return;
    }

    public u(com.bytedance.android.live.recharge.k r4) {
        Intrinsics.checkNotNullParameter(r4, "rechargeService");
        this.m = r4;
        this.e = new CompositeDisposable();
        this.f = 2;
        m0 r0 = new m0();
        r0.b(k());
        Unit r1 = Unit.INSTANCE;
        BehaviorSubject<m0> r2 = BehaviorSubject.createDefault(r0);
        this.g = r2;
        this.h = r2;
        m0 r3 = (m0) r2.getValue();
        if (r3 == null) goto L5;
        long r5 = r3.a();
    L6:
        com.bytedance.android.anya.internal.k r6 = i(Long.valueOf(r5)).a();
        KProperty[] r7 = n;
        this.i = r6.a(r7[0]);
        zv0.f r8 = r4.rechargeCenter();
        if (r8 == null) goto L11;
        ExchangeInfo r9 = r8.getExchangeInfo();
        if (r9 == null) goto L11;
        oc6.e r10 = v.a(r9);
    L12:
        BehaviorSubject<oc6.e> r11 = BehaviorSubject.createDefault(r10);
        this.j = r11;
        this.k = r11;
        this.l = j(r11.getValue()).a().a(r7[1]);
        return;
    L11:
        r10 = new oc6.e();
        goto L12
    L5:
        r5 = 0;
        goto L6
    }
}
