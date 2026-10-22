package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements i {
    public final i a;
    public final List<u> b;
    public final List<d> c;
    public final long d;
    public final long e;
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> f;
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> g;

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<Long> a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final int e() {
        return this.a.e();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IOneKeyPay f() {
        return this.a.f();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String g() {
        return this.a.g();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final com.bytedance.android.live.recharge.model.diamond.b getBizExtra() {
        return this.a.getBizExtra();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String i() {
        return this.a.i();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean isOneStep() {
        return this.a.isOneStep();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean m() {
        return this.a.m();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IPrePayCashierInfo n() {
        return this.a.n();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long o() {
        return this.a.o();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<u> c() {
        return this.b;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long d() {
        return this.d;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> getPanelExtraInfo() {
        return this.g;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> j() {
        return this.f;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<d> k() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long l() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(i r2, List<u> r3, List<d> r4, long r5, long r7, Map<Long, ? extends com.bytedance.android.live.recharge.model.diamond.e> r9, Map<Long, ? extends com.bytedance.android.live.recharge.platform.business.model.diamond.g> r10) {
        Intrinsics.checkNotNullParameter(r2, "original");
        Intrinsics.checkNotNullParameter(r3, "deals");
        Intrinsics.checkNotNullParameter(r4, "customDealTiers");
        Intrinsics.checkNotNullParameter(r9, "diamondExtraInfo");
        Intrinsics.checkNotNullParameter(r10, "panelExtraInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((u) r6.next()).a(this);
        goto L4
    L6:
        Iterator<T> r8 = this.c.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        ((d) r8.next()).a(this);
        goto L8
    }
}
