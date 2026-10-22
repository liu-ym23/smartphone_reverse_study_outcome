package com.bytedance.android.live.recharge.core;

import com.bytedance.android.live.recharge.deal.o;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.platform.service.RechargeConfigService;
import com.bytedance.android.live.recharge.platform.service.h;
import com.bytedance.android.live.recharge.platform.service.m;
import com.bytedance.android.live.recharge.platform.service.y;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final IAutoExchangeService a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$autoExchangeService");
        return (IAutoExchangeService) r1.a(Reflection.getOrCreateKotlinClass(IAutoExchangeService.class));
    }

    public static final com.bytedance.android.live.wallet.d b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cjService");
        return r1.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.wallet.d.class));
    }

    public static final o c(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dealRepository");
        return (o) r1.f(Reflection.getOrCreateKotlinClass(o.class));
    }

    public static final h d(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dealService");
        return (h) r1.f(Reflection.getOrCreateKotlinClass(h.class));
    }

    public static final y e(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$envService");
        return (y) r1.f(Reflection.getOrCreateKotlinClass(y.class));
    }

    public static final ow0.a f(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$firstChargeService");
        return (ow0.a) r1.f(Reflection.getOrCreateKotlinClass(ow0.a.class));
    }

    public static final com.bytedance.android.live.recharge.nopassword.b g(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$noPasswordService");
        return (com.bytedance.android.live.recharge.nopassword.b) r1.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.nopassword.b.class));
    }

    public static final m h(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$oneStepService");
        return (m) r1.f(Reflection.getOrCreateKotlinClass(m.class));
    }

    public static final com.bytedance.android.live.recharge.order.a i(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$orderService");
        return (com.bytedance.android.live.recharge.order.a) r1.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.order.a.class));
    }

    public static final yv0.a j(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$preOrderService");
        return (yv0.a) r1.f(Reflection.getOrCreateKotlinClass(yv0.a.class));
    }

    public static final RechargeConfigService k(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$rechargeConfigService");
        return (RechargeConfigService) r1.f(Reflection.getOrCreateKotlinClass(RechargeConfigService.class));
    }
}
