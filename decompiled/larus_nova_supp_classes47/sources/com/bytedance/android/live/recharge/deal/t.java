package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements i {
    public final List<u> a;
    public final List<d> b;
    public final List<Long> c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final IOneKeyPay i;
    public final long j;
    public final boolean k;
    public final IPrePayCashierInfo l;
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> m;
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> n;
    public final int o;
    public final long p;
    public final String q;
    public final com.bytedance.android.live.recharge.model.diamond.b r;
    public final List<IChargeDeal> s;
    public final com.bytedance.android.live.recharge.model.diamond.a t;

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<Long> a() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean b() {
        return this.g;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<u> c() {
        return this.a;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long d() {
        return this.d;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final int e() {
        return this.o;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IOneKeyPay f() {
        return this.i;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String g() {
        return this.h;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final com.bytedance.android.live.recharge.model.diamond.b getBizExtra() {
        return this.r;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> getPanelExtraInfo() {
        return this.n;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean h() {
        return this.e;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String i() {
        return this.q;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean isOneStep() {
        return this.f;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> j() {
        return this.m;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<d> k() {
        return this.b;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long l() {
        return this.j;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean m() {
        return this.k;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IPrePayCashierInfo n() {
        return this.l;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long o() {
        return this.p;
    }

    public t(List<? extends IChargeDeal> r6, com.bytedance.android.live.recharge.model.diamond.a r7) {
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r7, "extra");
        this.s = r6;
        this.t = r7;
        List<? extends IChargeDeal> r8 = r6;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        u r1 = com.bytedance.android.live.recharge.deal.dto.a.c((IChargeDeal) r10.next());
        r1.a(this);
        r9.add(r1);
        goto L4
    L6:
        this.a = r9;
        List<com.bytedance.android.live.recharge.platform.business.model.diamond.e> r12 = this.t.f();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        d r0 = com.bytedance.android.live.recharge.deal.dto.a.b((com.bytedance.android.live.recharge.platform.business.model.diamond.e) r14.next());
        r0.a(this);
        r13.add(r0);
        goto L8
    L10:
        this.b = r13;
        this.c = this.t.g();
        this.d = this.t.h();
        KmpEnv r15 = KmpEnv.a;
        boolean r16 = true;
        if (KmpEnv.b() == false) goto L14;
        boolean r17 = com.bytedance.android.live.incentive.exchange.j.a();
    L17:
        this.e = r17;
        IPrePayCashierInfo r18 = this.t.e();
        if (r18 != null) goto L20;
    L22:
        boolean r19 = false;
    L23:
        this.f = r19;
        com.bytedance.android.live.recharge.model.diamond.b r2 = null;
        if (KmpEnv.b() == false) goto L40;
        if (com.bytedance.android.live.incentive.exchange.j.a() == false) goto L42;
        if (r19 == true) goto L42;
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r20 = this.t.getPanelExtraInfo();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r22 = r20.entrySet().iterator();
    L30:
        if (r22.hasNext() == false) goto L35;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r4 = r22.next();
        if (com.bytedance.android.live.recharge.platform.business.model.diamond.j.a(r4.getValue()) == false) goto L30;
        r3.put(r4.getKey(), r4.getValue());
        goto L30
    L35:
        if (r3.isEmpty() == false) goto L37;
    L41:
        boolean r23 = true;
    L43:
        this.g = r23;
        this.h = this.t.c();
        this.i = this.t.l();
        this.j = this.t.m();
        this.k = this.t.o();
        this.l = this.t.e();
        IPrePayCashierInfo r24 = this.t.e();
        if (r24 == null) goto L46;
        r24.getBatchQueryInfo();
    L46:
        this.m = this.t.i();
        this.n = this.t.getPanelExtraInfo();
        this.o = this.t.k();
        this.p = this.t.d();
        String r25 = this.t.j();
        if (r25 != null) goto L49;
        r25 = "";
    L49:
        this.q = r25;
        com.bytedance.android.live.recharge.model.diamond.b.a r26 = com.bytedance.android.live.recharge.model.diamond.b.Companion;
        String r5 = this.t.getBizExtra();
        r26.getClass();
        if (r5 != null) goto L52;
    L55:
        if (r16 == false) goto L57;
        com.bytedance.android.live.recharge.model.diamond.b r27 = (com.bytedance.android.live.recharge.model.diamond.b) vh7.f.c(com.bytedance.android.live.recharge.model.diamond.b.class);
    L64:
        this.r = r27;
        return;
    L57:
        r27 = (com.bytedance.android.live.recharge.model.diamond.b) GsonProtectorUtils.fromJson(l97.a.a, r5, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.model.diamond.b.class)));
        KProperty[] r28 = com.bytedance.android.live.recharge.model.diamond.c.a;
        Intrinsics.checkNotNullParameter(r27, "$this$rawJson");
        vh7.i r29 = com.bytedance.android.live.recharge.model.diamond.c.b;
        KProperty r30 = com.bytedance.android.live.recharge.model.diamond.c.a[0];
        if ((r27 instanceof FlexModelBase) == false) goto L61;
        r2 = r27;
    L61:
        FlexModelBase r32 = (FlexModelBase) r2;
        if (r32 == null) goto L64;
        r32.set(r29.a, r5);
        goto L64
    L52:
        if (r5.length() == 0) goto L55;
        r16 = false;
        goto L55
    L37:
        if (((Boolean) com.bytedance.android.live.recharge.utils.t.o.getValue(null, com.bytedance.android.live.recharge.utils.t.a[13])).booleanValue() == true) goto L41;
    L42:
        r23 = false;
        goto L43
    L40:
        if (this.t.b() != true) goto L42;
    L20:
        if (r18.getOneStepPay() != 1) goto L22;
        r19 = true;
        goto L23
    L14:
        if (this.t.a() != true) goto L16;
        r17 = true;
        goto L17
    L16:
        r17 = false;
        goto L17
    }
}
