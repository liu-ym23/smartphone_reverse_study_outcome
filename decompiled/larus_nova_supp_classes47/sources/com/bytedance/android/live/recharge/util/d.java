package com.bytedance.android.live.recharge.util;

import android.content.Context;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.live.kmp.core.KmpEnv;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        a r0 = a.i;
        r0.getClass();
        return ((Boolean) a.b.getValue(r0, a.a[0])).booleanValue();
    }

    static {
    }

    public static boolean b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.b() == true) goto L6;
        return false;
    L6:
        if (com.bytedance.android.live.incentive.exchange.j.a() == true) goto L8;
        return false;
    L8:
        int r1 = ((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getGiftPanelType();
        if (PadConfigUtils.a() == false) goto L12;
        return false;
    L12:
        if (r4.getResources().getConfiguration().orientation != 2) goto L14;
        return false;
    L14:
        if (r1 == 1) goto L16;
        return false;
    L16:
        return com.bytedance.android.live.incentive.exchange.j.b();
    }

    public static void c(boolean r4) {
        a r0 = a.i;
        r0.getClass();
        a.b.setValue(r0, a.a[0], Boolean.valueOf(r4));
    }

    public static boolean d(ExchangeInfo r2) {
        if (r2 != null) goto L10;
        IRechargeService r3 = (IRechargeService) k.f(IRechargeService.class);
        if (r3 == null) goto L8;
        zv0.f r4 = r3.rechargeCenter();
        if (r4 == null) goto L8;
        r2 = r4.getExchangeInfo();
    L8:
        r2 = null;
    L10:
        if (r2 == null) goto L14;
        boolean r1 = true;
        if (r2.isFirstExchange() != true) goto L14;
    L15:
        if (r1 == true) goto L18;
        return false;
    L18:
        return com.bytedance.android.live.incentive.exchange.j.b();
    L14:
        r1 = false;
        goto L15
    }
}
