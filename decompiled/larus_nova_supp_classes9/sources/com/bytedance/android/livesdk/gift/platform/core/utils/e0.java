package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(null, "url");
        Intrinsics.checkNotNullParameter(null, "sendGiftType");
        Entrance r0 = Entrance.Recharge;
        FetchFrom r1 = FetchFrom.RechargePanel;
        com.bytedance.android.live.recharge.core.d r2 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r2, "$this$dealService");
        r2.f(Reflection.getOrCreateKotlinClass(zv0.c.class)).y0(new com.bytedance.android.live.recharge.deal.m(0, r0, r1)).doOnEvent(new d0(r6)).subscribe();
    }
}
