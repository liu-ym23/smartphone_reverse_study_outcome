package sa0;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import pa0.e;
import pa0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((e) r2, "it");
        c r3 = this.a;
        e r0 = (e) r3.b.a().b;
        if (r0 == null) goto L7;
        return r3.a((k) r0);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.incentive.balance.income.UserIncomeInfoDy");
    }
}
