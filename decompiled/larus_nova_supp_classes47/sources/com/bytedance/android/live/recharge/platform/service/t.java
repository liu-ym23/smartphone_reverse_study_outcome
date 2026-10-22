package com.bytedance.android.live.recharge.platform.service;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.core.RechargeServices;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ v a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ w2 c;
    public final /* synthetic */ Context d;

    public t(v r1, Ref.LongRef r2, w2 r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r20) {
        if ((r20 instanceof ExtraResponse) == false) goto L36;
        Extra r1 = ((ExtraResponse) r20).extra;
        if (r1 == null) goto L35;
        Iterator<T> r2 = ((com.bytedance.android.live.recharge.model.diamond.a) r1).f().iterator();
    L7:
        boolean r4 = true;
        Context r5 = null;
        if (r2.hasNext() == false) goto L17;
        T r3 = r2.next();
        com.bytedance.android.live.recharge.platform.business.model.diamond.e r6 = (com.bytedance.android.live.recharge.platform.business.model.diamond.e) r3;
        long r7 = r6.getMinPrice();
        long r9 = this.b.element;
        if (r7 <= r9) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L7;
    L18:
        com.bytedance.android.live.recharge.platform.business.model.diamond.e r10 = (com.bytedance.android.live.recharge.platform.business.model.diamond.e) r3;
        if (r10 == null) goto L21;
        com.bytedance.android.live.recharge.deal.d r12 = com.bytedance.android.live.recharge.deal.d.j(com.bytedance.android.live.recharge.deal.dto.a.b(r10), this.b.element, false, 1021);
    L22:
        if (r12 == null) goto L36;
        com.bytedance.android.live.recharge.order.j r13 = new com.bytedance.android.live.recharge.order.j();
        r13.c("pay_cancel_recover");
        String r14 = this.c.b;
        if (r14.length() == 0) goto L27;
        r4 = false;
    L27:
        if (r4 == false) goto L29;
        r14 = "ctnpay";
    L29:
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.g.b(r13, com.bytedance.android.live.recharge.order.j.i[6], r14);
        com.bytedance.android.live.recharge.order.k r15 = new com.bytedance.android.live.recharge.order.k(r13, null, false, 0, false, false, 0, 0, null, null, null, 8190);
        y r16 = com.bytedance.android.live.recharge.core.f.e(RechargeServices.b());
        Context r17 = this.d;
        if ((r17 instanceof Activity) == false) goto L33;
        r5 = r17;
    L33:
        r16.j((Activity) r5);
        com.bytedance.android.live.recharge.order.a.C0066a.a(com.bytedance.android.live.recharge.core.f.i(RechargeServices.b()), r12, r15);
        goto L36
    L21:
        r12 = null;
        goto L22
    L12:
        if (r9 > r6.getMaxPrice()) goto L14;
        r8 = true;
        goto L15
    L17:
        r3 = null;
        goto L18
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.model.diamond.DealSetExtra");
    L36:
        this.a.a = false;
    }
}
