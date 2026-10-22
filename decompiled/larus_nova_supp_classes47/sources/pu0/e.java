package pu0;

import android.graphics.RectF;
import com.bytedance.android.live.profit.livepet.container.m;
import com.bytedance.android.live.profit.livepet.container.n;
import com.bytedance.android.live.profit.livepet.utils.CachedEvent;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o, pu0.g {
    public final CachedEvent<Pair<Long, com.bytedance.android.live.profit.livepet.container.a>> a;
    public final PublishSubject<Pair<Boolean, Long>> b;
    public Long c;
    public final com.bytedance.android.live.profit.livepet.container.e d;

    public static final class a<T> implements Predicate {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            Pair r3 = (Pair) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return this.a.contains(r3.getSecond());
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            pu0.a r0 = new pu0.a();
            r0.b(((Number) r5.getSecond()).longValue());
            boolean r6 = ((Boolean) r5.getFirst()).booleanValue();
            int r1 = 1;
            if (r6 == true) goto L7;
            if (r6 == true) goto L10;
            r1 = 2;
            goto L7
        L10:
            throw new NoWhenBranchMatchedException();
        L7:
            r0.a(r1);
            return r0;
        }
    }

    public static final class c<T> implements Predicate {
        public final /* synthetic */ List a;

        public c(List r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            Pair r3 = (Pair) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return this.a.contains(r3.getFirst());
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            pu0.b r0 = new pu0.b();
            r0.b(((Number) r5.getFirst()).longValue());
            e r1 = this.a;
            RectF r6 = m.b((com.bytedance.android.live.profit.livepet.container.a) r5.getSecond());
            r1.getClass();
            r0.a(e.a(r6));
            return r0;
        }
    }

    /* JADX INFO: renamed from: pu0.e$e, reason: collision with other inner class name */
    public static final class C0292e<T, R> implements Function {
        public final /* synthetic */ e a;

        public C0292e(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Map r6 = (Map) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            this.a.getClass();
            pu0.c r0 = new pu0.c();
            LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
            Iterator<T> r7 = r6.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) r7.next();
            r1.put(r2.getKey(), e.a(m.b((com.bytedance.android.live.profit.livepet.container.a) r2.getValue())));
            goto L4
        L6:
            r0.a(r1);
            return r0;
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ e a;

        public f(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.profit.livepet.container.a) r2, "it");
            return m.b(this.a.d.d);
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ e a;

        public g(e r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            RectF r4 = (RectF) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            i r0 = new i();
            this.a.getClass();
            r0.a(e.a(r4));
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // pu0.g
    public final Observable<pu0.c> observeLinkRegion() {
        n r0 = this.d.c;
        Intrinsics.checkNotNullParameter(r0, "parent");
        return Observable.defer(new com.bytedance.android.live.profit.livepet.container.b(r0)).map(new C0292e(this));
    }

    @Override // pu0.g
    public final Observable<i> observePetRegion() {
        com.bytedance.android.live.profit.livepet.container.e r0 = this.d;
        return r0.f.startWith(r0.d).map(new f(this)).distinctUntilChanged().map(new g(this));
    }

    public e(com.bytedance.android.live.profit.livepet.container.e r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        this.d = r2;
        this.a = new CachedEvent("GiftTrayRegion");
        this.b = PublishSubject.create();
    }

    public static h a(RectF r2) {
        h r0 = new h();
        r0.b(r2.left);
        r0.d(r2.top);
        r0.c(r2.right);
        r0.a(r2.bottom);
        return r0;
    }

    @Override // pu0.g
    public final Observable<pu0.a> observeGiftEffectEvent(List<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "giftIds");
        return this.b.filter(new a(r3)).map(b.a);
    }

    @Override // pu0.g
    public final Observable<pu0.b> observeGiftTrayEvent(List<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "giftIds");
        return this.a.a(true).filter(new c(r3)).map(new d(this));
    }
}
