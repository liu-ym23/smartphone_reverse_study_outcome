package dc2;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Predicate {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean test(Object r2) {
        c.a r3 = (c.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.c == null) goto L5;
        return true;
    L5:
        return false;
    }
}
