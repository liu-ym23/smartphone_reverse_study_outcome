package com.bytedance.android.live.recharge.deal.dto;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.core.d;
import com.bytedance.android.live.recharge.deal.aio.b;
import com.bytedance.android.live.recharge.deal.aio.c;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import ix0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AioDealSetConvertersKt {
    public static final ix0.a a = null;

    static {
        d r0 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r0, "$this$tokenManager");
        a = (ix0.a) r0.f(Reflection.getOrCreateKotlinClass(ix0.a.class));
    }

    public static final c a(i r8) {
        Intrinsics.checkNotNullParameter(r8, "dealSet");
        c r0 = new c();
        List<u> r1 = r8.c();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        u r4 = (u) r3.next();
        b r5 = (b) g.b(a, r4, AioDealSetConvertersKt$createAioDealSet$1$1$1.INSTANCE);
        r5.a7(r4.b);
        r5.O8((int) r4.c);
        r5.setDiamondCount(r4.d);
        r5.v1(r4.i);
        r5.J5(r4.j);
        r5.C1(r4.e);
        r5.setDescription(r4.f);
        r5.x6(r4.l);
        r2.add(r5);
        goto L4
    L6:
        r0.e(r2);
        List<com.bytedance.android.live.recharge.deal.d> r6 = r8.k();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r9 = r6.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        com.bytedance.android.live.recharge.deal.d r10 = (com.bytedance.android.live.recharge.deal.d) r9.next();
        com.bytedance.android.live.recharge.deal.aio.a r12 = new com.bytedance.android.live.recharge.deal.aio.a();
        r12.a(r10.b);
        r12.c(r10.g);
        r12.b(r10.h);
        r7.add(r12);
        goto L8
    L10:
        r0.d(r7);
        r0.f(r8.d());
        r0.c(r8.b());
        boolean r13 = true;
        if (r8.e() == 1) goto L14;
        r13 = false;
    L14:
        r0.g(r13);
        r0.a(r8.h());
        r0.k(Long.valueOf(r8.l()));
        List<Long> r14 = r8.a();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        r15.add(Integer.valueOf((int) ((Number) r16.next()).longValue()));
        goto L16
    L18:
        r0.j(r15);
        r0.h(r8.getPanelExtraInfo());
        r0.i(r8.n());
        com.bytedance.android.live.recharge.model.diamond.b r17 = r8.getBizExtra();
        KProperty[] r18 = com.bytedance.android.live.recharge.model.diamond.c.a;
        Intrinsics.checkNotNullParameter(r17, "$this$rawJson");
        vh7.i r19 = com.bytedance.android.live.recharge.model.diamond.c.b;
        KProperty r20 = com.bytedance.android.live.recharge.model.diamond.c.a[0];
        Object r22 = null;
        if ((r17 instanceof FlexModelBase) == true) goto L21;
        r17 = null;
    L21:
        FlexModelBase r23 = (FlexModelBase) r17;
        if (r23 == null) goto L24;
        r22 = r23.get(r19.a);
    L24:
        r0.b((String) r22);
        return r0;
    }
}
