package com.bytedance.android.live.incentive.exchange.strategy;

import android.content.Context;
import com.bytedance.android.live.incentive.exchange.i;
import com.bytedance.android.live.incentive.exchange.l;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.platform.service.z;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pa0.e;
import pa0.o;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements c {
    public c.a a;

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean f() {
        ExchangeInfo r0 = ((e) o.b.b).a();
        if (((Boolean) lw0.b.d.getValue(null, lw0.b.a[2])).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (j.c() == true) goto L9;
        if (r0.getHideCashExchange() == true) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean a() {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) lw0.a.e.getValue(null, lw0.a.a[3])).booleanValue() == true) goto L7;
        return true;
    }

    public b() {
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void b(c.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean d(long r11) {
        boolean r2 = false;
        if (f() == true) goto L6;
        jy0.b.d("Incentive/DouyinLiteIncomeExchangeStrategy", "exchange is not possible because feature is disabled");
        return false;
    L6:
        ExchangeInfo r0 = ((e) o.b.b).a();
        if (i.a() == false) goto L22;
        c.a r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L11:
        Long r3 = r1.a.c(com.bytedance.android.live.incentive.balance.b.C0199b.a);
        if (r3 == null) goto L14;
        long r7 = r3.longValue();
    L16:
        if ((r7 / 10) < r11) goto L18;
        r2 = true;
    L18:
        if (r2 == true) goto L20;
        jy0.b.d("Incentive/DouyinLiteIncomeExchangeStrategy", "exchange is not possible because asset is not enough: fen = " + r7 + ", diamond = " + r11);
    L20:
        return r2;
    L14:
        r7 = 0;
        goto L16
    L22:
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L37;
        if (r0.getHideCombineExchange() == true) goto L37;
        if ((((long) (r0.getExchangeBalance() + r0.getGoldBalance())) / 10) >= r11) goto L28;
        return false;
    L28:
        if (f() == true) goto L30;
    L32:
        boolean r12 = false;
    L33:
        if (r12 == false) goto L48;
        return true;
    L48:
        return false;
    L30:
        if (((Boolean) lw0.a.e.getValue(null, lw0.a.a[3])).booleanValue() == true) goto L32;
        r12 = true;
    L37:
        if (r0.getExchangeDiamond() >= r11) goto L39;
        return false;
    L39:
        if (f() == true) goto L41;
    L43:
        boolean r13 = false;
    L44:
        if (r13 == false) goto L50;
        return true;
    L50:
        return false;
    L41:
        if (((Boolean) lw0.a.e.getValue(null, lw0.a.a[3])).booleanValue() == true) goto L43;
        r13 = true;
        goto L44
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void g(l r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Context r2 = r11.getContext();
        ExchangeType r3 = r11.getType();
        long r5 = r11.c;
        zv0.e r8 = r11.d;
        k r4 = r11.e;
        Map r12 = r11.f;
        if (r12 != null) goto L5;
        r12 = new LinkedHashMap();
    L5:
        Map r7 = r12;
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r1 = z.a();
        if (r1 == null) goto L9;
        r1.fo(r2, r3, r4, r5, r7, r8);
        return;
    }
}
