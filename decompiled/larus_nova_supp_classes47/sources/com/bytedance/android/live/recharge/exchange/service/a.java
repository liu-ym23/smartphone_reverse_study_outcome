package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.scope.o, IAutoExchangeService {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.exchange.IAutoExchangeService
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use IIncomeExchangeServiceForLive instead")
    public final boolean d1() {
        return vh6.c.b(wh6.a.class).ec();
    }

    @Override // com.bytedance.android.live.recharge.exchange.IAutoExchangeService
    public final boolean w0() {
        if (d1() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) lw0.a.e.getValue(null, lw0.a.a[3])).booleanValue() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.recharge.exchange.IAutoExchangeService
    public final boolean z1(long r9) {
        IRechargeService r0 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        ExchangeInfo r2 = r1.getExchangeInfo();
    L9:
        if (r2 == null) goto L35;
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L25;
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L25;
        if (r2.getHideCombineExchange() == true) goto L25;
        if (d1() == true) goto L19;
        return false;
    L19:
        if ((((long) (r2.getExchangeBalance() + r2.getGoldBalance())) / 10) >= r9) goto L21;
        return false;
    L21:
        if (w0() == false) goto L34;
        return true;
    L34:
        return false;
    L25:
        if (d1() == true) goto L27;
        return false;
    L27:
        if (r2.getExchangeDiamond() >= r9) goto L29;
        return false;
    L29:
        if (w0() == false) goto L38;
        return true;
    L38:
        return false;
    L35:
        return false;
    L7:
        r2 = null;
        goto L9
    }
}
