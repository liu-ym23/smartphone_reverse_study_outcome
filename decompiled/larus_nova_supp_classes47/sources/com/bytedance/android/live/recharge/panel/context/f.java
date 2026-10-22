package com.bytedance.android.live.recharge.panel.context;

import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.k;
import com.bytedance.android.live.recharge.deal.l;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.o;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vw0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements c {
    public final CompositeDisposable a;
    public final com.bytedance.android.live.revenue.common.reactive.c b;
    public final com.bytedance.android.live.revenue.common.reactive.c c;
    public long d;
    public final com.bytedance.android.live.revenue.common.reactive.c e;
    public final a f;
    public final PublishSubject<Unit> g;
    public String h;
    public final com.bytedance.android.live.recharge.model.d i;
    public final g j;
    public final com.bytedance.android.live.recharge.trace.session.a k;
    public final Context l;

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final void h() {
        this.h = null;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.model.d a() {
        return this.i;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final a b() {
        return this.f;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final PublishSubject<Unit> c() {
        return this.g;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.c d() {
        return this.e;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final String e() {
        return this.h;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.b<Order> f() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.e g() {
        return this.b;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final CompositeDisposable getCd() {
        return this.a;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.trace.session.a getSession() {
        return this.k;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final Context i() {
        return this.l;
    }

    public f(com.bytedance.android.live.recharge.model.d r12, g r13, com.bytedance.android.live.recharge.trace.session.a r14, Context r15) {
        Intrinsics.checkNotNullParameter(r12, "entranceParams");
        Intrinsics.checkNotNullParameter(r13, "rechargeCommonParams");
        Intrinsics.checkNotNullParameter(r14, "session");
        Intrinsics.checkNotNullParameter(r15, "androidContext");
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.a = new CompositeDisposable();
        Intrinsics.checkNotNullParameter(this, "panelContext");
        com.bytedance.android.live.recharge.deal.a r16 = com.bytedance.android.live.recharge.core.f.c(RechargeServices.b()).o0();
        if (com.bytedance.android.live.recharge.model.g.a.j1() == true) goto L5;
    L64:
        com.bytedance.android.live.recharge.deal.a r17 = l.a;
        jy0.b.a("Recharge/DealSetMemoryCache", "clear cache");
        Object r18 = null;
        l.a = null;
        Object r19 = r.b;
    L65:
        this.b = new com.bytedance.android.live.revenue.common.reactive.c(r19);
        this.c = new com.bytedance.android.live.revenue.common.reactive.c(r18);
        this.d = Long.MAX_VALUE;
        this.e = new com.bytedance.android.live.revenue.common.reactive.c(r18);
        this.f = new a(this);
        int r110 = o.a;
        this.g = PublishSubject.create();
        return;
    L5:
        if (com.bytedance.android.live.recharge.deal.c.a(r16) == false) goto L64;
        Intrinsics.checkNotNullParameter(r12, "$this$isEnableCache");
        if (r12.o.length() != 0) goto L9;
        boolean r111 = true;
    L10:
        if (r111 == false) goto L64;
        int r112 = com.bytedance.android.live.recharge.deal.b.a;
        Intrinsics.checkNotNullParameter(r16, "cachedDealSet");
        Intrinsics.checkNotNullParameter(this, "panelContext");
        i r1 = r16.b;
        long r113 = r12.d * 10;
        if (r113 <= 0) goto L60;
        cy0.e.a.getClass();
        j r114 = cy0.e.a.a;
        m.e.getClass();
        Object r115 = m.b(r114).b(wh6.a.class);
        Intrinsics.checkNotNull(r115);
        if (((com.bytedance.live.kmp.core.c) r115).isPersonalRecommendOn() == true) goto L17;
        String r116 = "推荐";
    L18:
        long r2 = 100;
        if (r113 > 100) goto L22;
    L28:
        u r117 = com.bytedance.android.live.recharge.deal.dto.a.a((int) r2, r116);
        List r3 = CollectionsKt.toMutableList(r1.c());
        Iterator r118 = r3.iterator();
    L30:
        if (r118.hasNext() == false) goto L37;
        Object r119 = r118.next();
        if (((u) r119).c != r117.c) goto L34;
        boolean r120 = true;
    L35:
        if (r120 == false) goto L30;
    L38:
        u r121 = (u) r119;
        if (r121 != null) goto L41;
        r121 = (u) CollectionsKt.first(r3);
    L41:
        r3.remove(r121);
        ListProtector.add(r3, 0, r117);
        int r122 = k.a;
        Long r4 = Long.valueOf(r117.b);
        Long r5 = Long.valueOf(r117.b);
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r123 = r1.getPanelExtraInfo();
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r124 = r123.entrySet().iterator();
    L43:
        if (r124.hasNext() == false) goto L50;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r125 = r124.next();
        if (r125.getKey().longValue() == r121.c) goto L47;
        boolean r126 = true;
    L48:
        if (r126 == false) goto L43;
        r6.put(r125.getKey(), r125.getValue());
        goto L43
    L47:
        r126 = false;
        goto L48
    L50:
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r127 = r1.j();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e>> r128 = r127.entrySet().iterator();
    L52:
        if (r128.hasNext() == false) goto L59;
        Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e> r129 = r128.next();
        if (r129.getKey().longValue() == r121.c) goto L56;
        boolean r130 = true;
    L57:
        if (r130 == false) goto L52;
        r7.put(r129.getKey(), r129.getValue());
        goto L52
    L56:
        r130 = false;
        goto L57
    L59:
        r1 = k.a(r1, r3, r4, r5, r7, r6, 4);
        goto L60
    L34:
        r120 = false;
        goto L35
    L37:
        r119 = null;
        goto L38
    L22:
        if (101 > r113) goto L27;
        r2 = 600;
        if (600 >= r113) goto L28;
    L27:
        long r8 = 100;
        r2 = (((r113 - 1) / r8) + 1) * r8;
        goto L28
    L17:
        r116 = "";
    L60:
        IPrePayCashierInfo r131 = r1.n();
        if (r131 == null) goto L63;
        r131.setRenderDataMap(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
    L63:
        r19 = LastCustomRechargeRecoder.c(r1, this);
        r18 = null;
        goto L65
    L9:
        r111 = false;
        goto L10
    }
}
