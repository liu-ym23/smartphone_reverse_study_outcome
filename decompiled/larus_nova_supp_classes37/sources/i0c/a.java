package i0c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a<S, E, C, R> {
    public final h0c.e<S, E, C, R> a;
    public S b;

    public a(h0c.e<S, E, C, R> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateMap");
        this.a = r2;
    }
}
