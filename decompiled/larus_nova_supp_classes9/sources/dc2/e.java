package dc2;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        c.a r3 = (c.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}
