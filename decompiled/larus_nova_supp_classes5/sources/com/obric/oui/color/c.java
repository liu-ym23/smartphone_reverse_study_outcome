package com.obric.oui.color;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final a[] a(b[] r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ArrayList r1 = new ArrayList(r8.length);
        int r2 = r8.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        b r5 = r8[r4];
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r1.add(new a(r5.a, r5.b));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r9 = r1.toArray(new a[0]);
        if (r9 == null) goto L10;
        return (a[]) r9;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final b[] b(a[] r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ArrayList r0 = new ArrayList(r7.length);
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        a r4 = r7[r3];
        r4.getClass();
        r0.add(new b(r4.a, r4.b));
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r8 = r0.toArray(new b[0]);
        if (r8 == null) goto L10;
        return (b[]) r8;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
