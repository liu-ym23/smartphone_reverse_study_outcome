package sa0;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import pa0.e;
import pa0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        e r3 = (e) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return this.a.a((k) r3);
    }
}
