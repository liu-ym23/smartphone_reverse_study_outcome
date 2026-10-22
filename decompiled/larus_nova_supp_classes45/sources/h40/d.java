package h40;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ a b;
    public final /* synthetic */ long c;

    public d(int r1, a r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r2) {
        Observable r3 = (Observable) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.concatMap(new c(this));
    }
}
