package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t3 {
    public static final List<Integer> a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Vote.values().length];
            r0[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = CollectionsKt.listOf(new Integer[]{0, 1, 5, 10, 20});
    }

    public static final String a(l5 r2, Vote r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L5;
        int r4 = -1;
    L6:
        if (r4 == (-1)) goto L16;
        if (r4 == 1) goto L18;
        if (r4 != 2) goto L13;
        return r2.k;
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return r2.j;
    L16:
        return r2.i;
    L5:
        r4 = a.a[r3.ordinal()];
        goto L6
    }
}
