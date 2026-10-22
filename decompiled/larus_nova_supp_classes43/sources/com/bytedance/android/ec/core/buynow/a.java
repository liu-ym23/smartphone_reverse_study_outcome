package com.bytedance.android.ec.core.buynow;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a() {
        if (BuyNowPerformanceOpt.a != null) goto L6;
        BuyNowPerformanceOpt.a = Boolean.TRUE;
    L6:
        if (BuyNowPerformanceOpt.q() == false) goto L9;
        qh.a.a();
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_buy_now_template_preload");
        BuyNowPerformanceOpt.r(BuyNowBizCode.BUY);
        BuyNowPerformanceOpt.r(BuyNowBizCode.YATA_SKUBUY);
    L9:
        if (BuyNowPerformanceOpt.q() == false) goto L11;
        int r0 = com.bytedance.android.ec.core.opt.a.a;
    L11:
        Map r1 = BuyNowPerformanceOpt.g();
        if (r1 == null) goto L14;
        Object r10 = r1.get("buy_now_preconnect_url");
    L16:
        if (Intrinsics.areEqual(r10, 1) == true) goto L18;
        return;
    L18:
        if (BuyNowPerformanceOpt.k() == false) goto L20;
        String r11 = "https://ec5-core.ecombdapi.com/";
    L29:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L23
        TTNetInit.preconnectUrl(r11);     // Catch: Throwable -> L23
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L32;
        ECExceptionMonitor.e(r14);
        return;
    L32:
        return;
    L23:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L20:
        r11 = "https://ec.ecombdapi.com/";
        goto L29
    L14:
        r10 = null;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
