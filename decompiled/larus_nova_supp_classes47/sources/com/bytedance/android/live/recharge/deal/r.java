package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements i {
    public static final r b = null;
    public final /* synthetic */ t a;

    static {
        b = new r();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<Long> a() {
        return this.a.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean b() {
        return this.a.g;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<u> c() {
        return this.a.a;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long d() {
        return this.a.d;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final int e() {
        return this.a.o;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IOneKeyPay f() {
        return this.a.i;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String g() {
        return this.a.h;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final com.bytedance.android.live.recharge.model.diamond.b getBizExtra() {
        return this.a.r;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> getPanelExtraInfo() {
        return this.a.n;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean h() {
        return this.a.e;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String i() {
        return this.a.q;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean isOneStep() {
        return this.a.f;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> j() {
        return this.a.m;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<d> k() {
        return this.a.b;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long l() {
        return this.a.j;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean m() {
        return this.a.k;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IPrePayCashierInfo n() {
        return this.a.l;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long o() {
        return this.a.p;
    }

    public r() {
        this.a = new t(CollectionsKt.emptyList(), new com.bytedance.android.live.recharge.model.diamond.a());
    }
}
