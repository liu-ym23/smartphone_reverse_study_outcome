package tw0;

import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.deal.v;
import com.bytedance.android.live.recharge.order.aio.BuyDiamondException;
import com.bytedance.android.live.recharge.order.aio.OrderResultCode;
import com.bytedance.android.live.recharge.platform.service.p;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o, tw0.a, com.bytedance.android.live.recharge.core.c {
    public final CompositeDisposable a;
    public final PublishSubject<g> b;
    public final PublishSubject c;
    public final com.bytedance.android.live.recharge.deal.o d;
    public final com.bytedance.android.live.recharge.order.a e;
    public final ix0.a f;
    public final p g;

    public static final class a {
    }

    /* JADX INFO: renamed from: tw0.b$b, reason: collision with other inner class name */
    public static final class C0319b<T, R> implements Function {
        public final /* synthetic */ g a;

        public C0319b(g r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            com.bytedance.android.live.recharge.deal.i r8 = (com.bytedance.android.live.recharge.deal.i) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            com.bytedance.android.live.recharge.deal.d r9 = com.bytedance.android.live.recharge.deal.j.a(r8, this.a.getCustomPrice(), false, 6);
            if (r9 == null) goto L6;
            return r9;
        L6:
            throw new BuyDiamondException(-1, "no matching custom deal tiers for price " + this.a.getCustomPrice(), null, 4, null);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ g a;

        public c(g r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            com.bytedance.android.live.recharge.deal.i r12 = (com.bytedance.android.live.recharge.deal.i) r10;
            Intrinsics.checkNotNullParameter(r12, "it");
            long r0 = this.a.B8();
            Intrinsics.checkNotNullParameter(r12, "$this$findRegularDealById");
            Iterator<T> r13 = r12.c().iterator();
        L4:
            if (r13.hasNext() == false) goto L11;
            T r2 = r13.next();
            if (((u) r2).b != r0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L4;
        L12:
            u r4 = r2;
            if (r4 == null) goto L16;
            return r4;
        L16:
            throw new BuyDiamondException(-1, "no matching deal with id " + this.a.B8(), null, 4, null);
        L8:
            r3 = false;
            goto L9
        L11:
            r2 = (T) null;
            goto L12
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ g b;

        public d(b r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.recharge.deal.f r5 = (com.bytedance.android.live.recharge.deal.f) r4;
            b r0 = this.a;
            com.bytedance.android.live.recharge.order.k r1 = b.J1(r0, this.b, r5, b.E1(r0));
            com.bytedance.android.live.recharge.core.f.j(RechargeServices.b()).S(r5, r1);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            jy0.b.e("AioRechargeOrderService", "pre order failed", (Throwable) r3);
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.dispose();
    }

    public static final com.bytedance.android.live.recharge.order.k E1(b r14) {
        r14.getClass();
        com.bytedance.android.live.recharge.panel.context.c r15 = com.bytedance.android.live.recharge.panel.g.a();
        com.bytedance.android.live.recharge.order.j r1 = new com.bytedance.android.live.recharge.order.j();
        Boolean r0 = null;
        if (r15 == null) goto L7;
        com.bytedance.android.live.revenue.common.reactive.e<com.bytedance.android.live.recharge.deal.i> r3 = r15.g();
        if (r3 == null) goto L7;
        com.bytedance.android.live.recharge.deal.i r4 = r3.getValue();
    L8:
        boolean r5 = com.bytedance.android.live.recharge.deal.j.b(r4);
        if (r15 == null) goto L14;
        com.bytedance.android.live.recharge.panel.context.a r16 = r15.b();
        if (r16 == null) goto L14;
        r0 = r16.isCombinedPaySelected();
    L14:
        return new com.bytedance.android.live.recharge.order.k(r1, null, r5, 0, true, Intrinsics.areEqual(r0, Boolean.TRUE), 0, 0, null, null, null, 8138);
    L7:
        r4 = null;
        goto L8
    }

    public final Single<com.bytedance.android.live.recharge.deal.f> K1(g r7) {
        if (r7.o() == null) goto L7;
        jy0.b.d("AioRechargeOrderService", "buyDiamond, deal = " + r7.o());
        ix0.a r0 = this.f;
        com.bytedance.android.live.recharge.deal.aio.b r8 = r7.o();
        Intrinsics.checkNotNull(r8);
        return Single.just((com.bytedance.android.live.recharge.deal.f) ix0.g.a(r0, r8));
    L7:
        if (r7.getCustomPrice() <= 0) goto L10;
        jy0.b.d("AioRechargeOrderService", "buyDiamond, customPrice = " + r7.getCustomPrice());
        return v.a(this.d).map(new C0319b(r7));
    L10:
        jy0.b.d("AioRechargeOrderService", "buyDiamond, dealId = " + r7.B8());
        return v.a(this.d).map(new c(r7));
    }

    @Override // tw0.a
    public final Observable<h> buyDiamond(g r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.b.onNext(r5);     // Catch: BuyDiamondException -> L9
        com.bytedance.android.live.recharge.panel.context.c r1 = com.bytedance.android.live.recharge.panel.g.a();     // Catch: BuyDiamondException -> L9
        p r2 = this.g;     // Catch: BuyDiamondException -> L9
        if (r1 == null) goto L6;
        Context r3 = r1.i();     // Catch: BuyDiamondException -> L9
    L7:
        r2.j(r3);     // Catch: BuyDiamondException -> L9
        Single r6 = K1(r5).map(new tw0.e(this, r5));     // Catch: BuyDiamondException -> L9
        ReplaySubject r4 = ReplaySubject.a();     // Catch: BuyDiamondException -> L9
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.subscribe(new tw0.d(this, r4, r1)), this.a);     // Catch: BuyDiamondException -> L9
        return r4;
    L6:
        r3 = null;
    L9:
        e = move-exception;
        jy0.b.f("AioRechargeOrderService", "buyDiamond fail, exception = " + e, null, 4);
        return Observable.just(e.toBuyDiamondResponse());
    }

    @Override // tw0.a
    public final void preOrder(g r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        com.bytedance.revenue.platform.api.core.rx.f.a(K1(r3).subscribe(new d(this, r3), e.a), this.a);
    }

    public static h V1(int r2, String r3) {
        h r0 = new h();
        r0.e(OrderResultCode.Failure);
        r0.b(r2);
        r0.c(r3);
        return r0;
    }

    public b(com.bytedance.android.live.recharge.deal.o r2, com.bytedance.android.live.recharge.order.a r3, ix0.a r4, p r5) {
        Intrinsics.checkNotNullParameter(r2, "dealRepository");
        Intrinsics.checkNotNullParameter(r3, "orderService");
        Intrinsics.checkNotNullParameter(r4, "tokenManager");
        Intrinsics.checkNotNullParameter(r5, "envService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new CompositeDisposable();
        PublishSubject<g> r6 = PublishSubject.create();
        this.b = r6;
        this.c = r6;
    }

    public static final com.bytedance.android.live.recharge.order.k J1(b r2, g r3, com.bytedance.android.live.recharge.deal.f r4, com.bytedance.android.live.recharge.order.k r5) {
        r2.getClass();
        List r6 = CollectionsKt.mutableListOf(new uw0.b[]{new uw0.e(r4)});
        k r0 = r3.b9();
        if (r0 == null) goto L5;
        r6.add(new uw0.d(r0, r4));
    L5:
        l r7 = r3.c5();
        if (r7 == null) goto L8;
        r6.add(new uw0.f(r7));
    L8:
        i r8 = r3.v6();
        if (r8 == null) goto L11;
        r6.add(new uw0.a(r8));
    L11:
        j r9 = r3.Z2();
        if (r9 == null) goto L14;
        r6.add(new uw0.c(r9));
    L14:
        Iterator r10 = r6.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        r5 = ((uw0.b) r10.next()).a(r5);
        goto L16
    L18:
        return r5;
    }
}
