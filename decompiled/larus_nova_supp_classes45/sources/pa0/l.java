package pa0;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class l implements com.bytedance.android.live.incentive.balance.c {
    public static WeakReference<Pair<com.bytedance.android.live.incentive.balance.e, Observable<e>>> a;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            e r4 = (e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            Long r5 = this.a.d(r4);
            if (r5 == null) goto L5;
            long r0 = r5.longValue();
        L7:
            return Long.valueOf(r0);
        L5:
            r0 = -1;
            goto L7
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            if (r6.longValue() < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public l() {
    }

    public abstract Long d(e r1);

    static {
        a = new WeakReference(null);
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final Long b() {
        return d((e) o.b.b);
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final Observable<Long> c(com.bytedance.android.live.incentive.balance.e r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Pair<com.bytedance.android.live.incentive.balance.e, Observable<e>> r0 = a.get();
        if (r0 != null) goto L5;
    L7:
        jy0.b.d("Incentive/UserIncomeProvider", "updateExchangeInfo, reason = " + r3.a);
        Observable r1 = o.c.b();
        a = new WeakReference(TuplesKt.to(r3, r1));
        Observable r4 = r1;
    L9:
        return r4.map(new b(this)).filter(c.a);
    L5:
        if (((com.bytedance.android.live.incentive.balance.e) r0.getFirst()) != r3) goto L7;
        r4 = (Observable) r0.getSecond();
        goto L9
    }
}
