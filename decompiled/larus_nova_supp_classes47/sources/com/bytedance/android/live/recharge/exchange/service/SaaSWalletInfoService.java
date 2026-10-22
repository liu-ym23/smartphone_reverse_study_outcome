package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.exchange.repo.SaaSDiamondExchangeRepo;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SaaSWalletInfoService implements com.bytedance.android.scope.o, zv0.i {
    public final CompositeDisposable a;
    public final Lazy b;
    public com.bytedance.android.live.recharge.exchange.model.h c;
    public final yz0.k d;

    public static final class a {
    }

    static {
    }

    @Override // zv0.i
    public final boolean h1() {
        if (vh6.c.b(wh6.a.class).getAppId() != 247160) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        com.bytedance.android.live.recharge.exchange.model.h r1 = this.c;
        if (r1 != null) goto L10;
    L12:
        return false;
    L10:
        if (r1.a != true) goto L12;
        return true;
    L14:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void onStart() {
        if (((Boolean) lw0.b.f.getValue(null, lw0.b.a[4])).booleanValue() == true) goto L5;
        return;
    L5:
        if (vh6.c.b(wh6.a.class).getAppId() != 247160) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L12;
        ALogger.w("XiguaWalletInfoService", "user not login, skip xigua wallet info.");
        return;
    L12:
        String r1 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        RxUtilKt.c(((SaaSDiamondExchangeRepo) this.b.getValue()).fetchXiguaExchangeInfo(r1).subscribe(new p(this), q.a), this.a);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void onStop() {
        this.a.clear();
    }

    public SaaSWalletInfoService(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.d = r2;
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(SaaSWalletInfoService$saaSWalletInfoRepo$2.INSTANCE);
    }
}
