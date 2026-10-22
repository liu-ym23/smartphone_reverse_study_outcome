package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.recharge.core.RechargeServices;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final com.bytedance.android.live.recharge.panel.context.c a() {
        com.bytedance.android.live.recharge.core.d r0 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r0, "$this$panelContextManager");
        return ((com.bytedance.android.live.recharge.panel.context.e) r0.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.panel.context.e.class))).i();
    }
}
