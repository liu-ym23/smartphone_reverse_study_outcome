package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.content.Context;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0<T1, T2> implements ttc.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;
    public final /* synthetic */ String g;
    public final /* synthetic */ long h;

    public d0(Context r3) {
        this.a = r3;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = 0;
    }

    public final void accept(Object r23, Object r24) {
        com.bytedance.android.live.recharge.deal.p r1 = (com.bytedance.android.live.recharge.deal.p) r23;
        Throwable r2 = (Throwable) r24;
        if (r1 != null) goto L5;
    L14:
        int r3 = e0.a;
        Context r4 = this.a;
        String r5 = this.b;
        long r9 = this.c;
        long r11 = this.d;
        long r13 = this.e;
        long r7 = this.f;
        String r15 = this.g;
        long r14 = this.h;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r15, "sendGiftType");
        x2 r6 = new x2("gift", BuildConfig.FLAVOR, r9, r11, r13, r7, r15, r14, false);
        xs2.b.a().post(r6);
        return;
    L5:
        if (r1.a() == null) goto L14;
        int r8 = e0.a;
        Context r10 = this.a;
        String r16 = this.b;
        long r17 = this.c;
        long r18 = this.d;
        long r19 = this.e;
        long r110 = this.f;
        String r111 = this.g;
        long r112 = this.h;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r111, "sendGiftType");
        HashMap r20 = new HashMap();
        yz0.k r21 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        r20.put("previous_gift_id", String.valueOf(r17));
        r20.put("previous_gift_money", String.valueOf(r18));
        r20.put("previous_pay_money", String.valueOf(r19));
        r20.put("money_diff", String.valueOf(r110));
        r20.put("previous_gift_type", r111);
        r20.put("diamond", String.valueOf(r112));
        r20.put("charge_reason", "gift");
        Boolean r25 = null;
        boolean r26 = true;
        if (((Number) com.bytedance.android.livesdk.gift.platform.core.g.i.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[6])).intValue() == 1) goto L10;
        r26 = false;
    L10:
        r20.put("dark_mode", String.valueOf(r26));
        if (r21 == null) goto L13;
        r25 = Boolean.valueOf(r21.isPortraitInteraction());
    L13:
        r20.put("is_protrait", String.valueOf(r25));
        String r27 = com.bytedance.android.live.revenue.common.u.b(r16, r20);
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r10, r27);
    }
}
