package com.bytedance.android.live.recharge.panel.dynamic;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import com.bytedance.android.live.recharge.deal.dto.AioDealSetConvertersKt;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.m;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import com.bytedance.android.live.revenue.common.reactive.j;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o, com.bytedance.android.live.recharge.panel.dynamic.a {
    public final CompositeDisposable a;
    public boolean b;
    public final com.bytedance.android.live.recharge.panel.context.f c;
    public final com.bytedance.android.live.recharge.deal.o d;
    public final com.bytedance.android.live.recharge.balance.d e;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            i r3 = (i) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return AioDealSetConvertersKt.a(r3);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            i r3 = (i) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            boolean r0 = LastCustomRechargeRecoder.a;
            return LastCustomRechargeRecoder.c(r3, this.a.c);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            i r4 = (i) r3;
            this.a.c.b.setValue(r4);
            this.a.a(r4, false);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.panel.dynamic.e$e, reason: collision with other inner class name */
    public static final class C0069e<T> implements Consumer {
        public final /* synthetic */ e a;

        public C0069e(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.c.b.setValue(r.b);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.a
    public final com.bytedance.revenue.platform.api.core.rx.a<com.bytedance.android.live.recharge.deal.aio.c> observeDealSet() {
        com.bytedance.android.live.revenue.common.reactive.c r0 = this.c.b;
        if (((i) r0.b) != r.b) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return new com.bytedance.revenue.platform.api.core.rx.b(j.a(r0, r1).map(b.a));
    L5:
        if (this.b == true) goto L7;
        r1 = true;
        goto L9
    }

    public final void onStart() {
        this.e.C1(new com.bytedance.android.live.recharge.balance.f("recharge_panel", null));
        pa0.o.c.b();
        if (Intrinsics.areEqual((i) this.c.b.b, r.b) == false) goto L5;
        jy0.b.d("Recharge/RechargePanelDataUseCase", "cache miss, request deal set");
        requestDealSet();
        return;
    L5:
        this.b = true;
        jy0.b.d("Recharge/RechargePanelDataUseCase", "cache hit");
        RechargePanelDynamicConfig r1 = com.bytedance.android.live.recharge.model.g.a;
        if (r1.j1() == true) goto L8;
    L10:
        a((i) this.c.b.b, true);
        return;
    L8:
        if (r1.p0() == false) goto L10;
        this.d.c(new m(0, Entrance.Recharge, FetchFrom.RechargePanel));
        goto L10
    }

    public final void onStop() {
        this.a.clear();
        this.b = false;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.a
    public final void requestDealSet() {
        com.bytedance.android.live.recharge.model.d r0 = this.c.i;
        com.bytedance.android.live.recharge.deal.o r1 = this.d;
        m r2 = new m(r0.d * ((long) 10), Entrance.Recharge, FetchFrom.RechargePanel);
        cw0.a.a(r2, r0);
        Single<i> r3 = r1.c(r2);
        int r4 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new c(this)).subscribe(new d(this), new C0069e(this)), this.a);
    }

    public final void a(i r9, boolean r10) {
        yv0.a r0 = com.bytedance.android.live.recharge.core.f.j(RechargeServices.b());
        com.bytedance.android.live.recharge.model.d r3 = this.c.i;
        long r4 = ((Number) this.e.n().getValue()).longValue();
        List<u> r12 = r9.c();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r6.add(Long.valueOf(((u) r13.next()).c));
        goto L4
    L6:
        r0.S0(new yv0.b(r3, r4, r6, r10));
    }

    public e(com.bytedance.android.live.recharge.panel.context.f r2, com.bytedance.android.live.recharge.deal.o r3, com.bytedance.android.live.recharge.balance.d r4) {
        Intrinsics.checkNotNullParameter(r2, "panelContext");
        Intrinsics.checkNotNullParameter(r3, "dealRepository");
        Intrinsics.checkNotNullParameter(r4, "walletBalanceService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
    }
}
