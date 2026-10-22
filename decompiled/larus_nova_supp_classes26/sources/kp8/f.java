package kp8;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new d());
        b = LazyKt.lazy(new e());
    }

    public static Pair a(int r0, int r1, int r2) {
        int r3 = (r2 * r0) / r1;
        int r4 = (r0 * 4) / 3;
        if (r3 <= r4) goto L5;
    L4:
        r3 = r4;
    L9:
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r3));
    L5:
        r4 = (r0 * 3) / 4;
        if (r3 >= r4) goto L9;
        goto L4
    }
}
