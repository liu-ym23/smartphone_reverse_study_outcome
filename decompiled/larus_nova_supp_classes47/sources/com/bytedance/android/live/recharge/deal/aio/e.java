package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.v;
import com.bytedance.android.scope.o;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import ix0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o, com.bytedance.android.live.recharge.deal.aio.d {
    public final com.bytedance.android.live.recharge.deal.o a;
    public final ix0.a b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ long a;
        public final /* synthetic */ f b;

        public b(long r1, f r3) {
            this.a = r1;
            this.b = r3;
        }

        public final Object apply(Object r6) {
            i r7 = (i) r6;
            Intrinsics.checkNotNullParameter(r7, "dealSet");
            long r0 = this.a;
            Boolean r2 = this.b.s2();
            if (r2 == null) goto L5;
            boolean r3 = r2.booleanValue();
        L6:
            Boolean r4 = this.b.j4();
            if (r4 == null) goto L9;
            boolean r5 = r4.booleanValue();
        L10:
            Intrinsics.checkNotNullParameter(r7, "$this$createCustomDeal");
            com.bytedance.android.live.recharge.deal.d r1 = com.bytedance.android.live.recharge.deal.e.a(r7.k(), r0, r3, r5);
            if (r1 == null) goto L13;
            r1.a(r7);
        L14:
            if (r1 == null) goto L17;
            return r1;
        L17:
            throw new IllegalArgumentException("no matching custom deal tiers for price " + this.a);
        L13:
            r1 = null;
            goto L14
        L9:
            r5 = false;
            goto L10
        L5:
            r3 = true;
            goto L6
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.recharge.deal.d r4 = (com.bytedance.android.live.recharge.deal.d) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return (com.bytedance.android.live.recharge.deal.aio.b) g.b(this.a.b, r4, AioRechargeDealServiceImpl$createCustomDeal$2$1.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            jy0.b.a("Recharge/AioRechargeDealService", "createCustomDeal subscribed on thread " + ThreadMethodProxy.currentThread().getName());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.deal.aio.e$e, reason: collision with other inner class name */
    public static final class C0061e implements Action {
        public static final C0061e a = null;

        static {
            a = new C0061e();
        }

        public C0061e() {
        }

        public final void run() {
            jy0.b.a("Recharge/AioRechargeDealService", "createCustomDeal unsubscribed on thread " + ThreadMethodProxy.currentThread().getName());
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.d
    public final Observable<com.bytedance.android.live.recharge.deal.aio.b> createCustomDeal(f r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        jy0.b.a("Recharge/AioRechargeDealService", "createCustomDeal called on thread " + ThreadMethodProxy.currentThread().getName());
        Single r6 = v.a(this.a).map(new b(r5.getCustomPrice(), r5));
        Intrinsics.checkNotNullParameter(r6, "$this$pinObjects");
        return Observable.defer(new ix0.f(r6)).map(new c(this)).doOnSubscribe(d.a).doOnDispose(C0061e.a);
    }

    public e(com.bytedance.android.live.recharge.deal.o r2, ix0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dealRepository");
        Intrinsics.checkNotNullParameter(r3, "tokenManager");
        this.a = r2;
        this.b = r3;
    }
}
