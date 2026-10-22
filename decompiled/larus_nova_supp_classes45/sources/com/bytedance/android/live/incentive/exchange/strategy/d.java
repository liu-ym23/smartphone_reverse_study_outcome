package com.bytedance.android.live.incentive.exchange.strategy;

import android.content.Context;
import com.bytedance.android.live.incentive.exchange.SaasOldExchangeDialogHelper;
import com.bytedance.android.live.incentive.exchange.l;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.core.f;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.platform.service.z;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import zv0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements c {
    public static final d a = null;

    public d() {
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void b(c.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    static {
        a = new d();
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean a() {
        IAutoExchangeService r0 = f.a(RechargeServices.b());
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.w0() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean f() {
        IAutoExchangeService r0 = f.a(RechargeServices.b());
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d1() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean d(long r2) {
        IAutoExchangeService r0 = f.a(RechargeServices.b());
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.z1(r2) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void g(l r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Context r2 = r11.getContext();
        ExchangeType r3 = r11.getType();
        long r5 = r11.c;
        e r8 = r11.d;
        k r0 = r11.e;
        Map r12 = r11.f;
        if (r12 != null) goto L5;
        r12 = new LinkedHashMap();
    L5:
        Map r7 = r12;
        if (SaasOldExchangeDialogHelper.c == false) goto L8;
        SaasOldExchangeDialogHelper.a(r2, r3, r5, r8, r0);
        return;
    L8:
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r1 = z.a();
        if (r1 == null) goto L13;
        r1.fo(r2, r3, r0, r5, r7, r8);
        return;
    }
}
