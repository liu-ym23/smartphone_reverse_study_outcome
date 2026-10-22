package jc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final <V extends l, T extends a> V a(b<T> r1, Class<V> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        k r3 = r1.a;
        if (r3 != null) goto L7;
        return null;
    L7:
        return (V) r3.a(r2);
    }
}
