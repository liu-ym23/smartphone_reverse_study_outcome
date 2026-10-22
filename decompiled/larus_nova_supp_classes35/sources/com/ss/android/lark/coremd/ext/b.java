package com.ss.android.lark.coremd.ext;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Object a(Object r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "first");
        Intrinsics.checkNotNullParameter(r5, "second");
        int r1 = 0;
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r4;
    L9:
        if ((r4 instanceof a) == false) goto L12;
        ((a) r4).a.addAll(ArraysKt.filterNotNull(r5));
        return r4;
    L12:
        a r2 = new a(r4);
        int r6 = r5.length;
    L13:
        if (r1 >= r6) goto L20;
        Object r3 = r5[r1];
        if ((r3 instanceof a) == false) goto L17;
        r2.a.addAll(((a) r3).a);
    L19:
        r1 = r1 + 1;
        goto L13
    L17:
        if (r3 == null) goto L19;
        r2.a.add(r3);
        goto L19
    L20:
        return r2;
    L5:
        r0 = false;
        goto L6
    }
}
