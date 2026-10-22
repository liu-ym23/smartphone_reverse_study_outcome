package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import java.util.ArrayList;
import kma.a;
import kma.b;
import kma.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static final c a(e r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        ColorStateList r3 = r20.a;
        b r2 = r20.b;
        if (r2 != null) goto L5;
        a r6 = null;
    L6:
        com.obric.oui.color.b[] r4 = r20.c;
        if (r4 != null) goto L9;
        com.obric.oui.color.a[] r7 = null;
    L10:
        d r5 = r20.d;
        if (r5 != null) goto L13;
        kma.c r8 = null;
    L14:
        j0 r9 = r20.e;
        if (r9 != null) goto L17;
        i0 r10 = null;
    L18:
        b r11 = r20.f;
        if (r11 != null) goto L21;
        a r12 = null;
    L22:
        com.obric.oui.blur.b r13 = r20.g;
        if (r13 != null) goto L25;
        com.obric.oui.blur.a r1 = null;
    L26:
        Float r14 = r20.h;
        com.obric.oui.shadow.b[] r15 = r20.i;
        if (r15 != null) goto L29;
        com.obric.oui.shadow.a[] r16 = null;
    L30:
        com.obric.oui.fluid.b r0 = r20.j;
        if (r0 != null) goto L33;
        com.obric.oui.fluid.a r17 = null;
    L35:
        return new c(r3, r6, r7, r8, r10, r12, r1, r14, r16, r17);
    L33:
        r17 = com.obric.oui.fluid.c.a(r0);
        goto L35
    L29:
        r16 = c(r15);
        goto L30
    L25:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r1 = new com.obric.oui.blur.a(r13.a, r13.b, r13.c, r13.d, r13.e);
        goto L26
    L21:
        Intrinsics.checkNotNullParameter(r11, "<this>");
        int r18 = a.b;
        Intrinsics.checkNotNullParameter(r11, "core");
        r12 = new a(r11);
        goto L22
    L17:
        r10 = k0.a(r9);
        goto L18
    L13:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r19 = kma.c.b;
        Intrinsics.checkNotNullParameter(r5, "core");
        r8 = new kma.c(r5);
        goto L14
    L9:
        r7 = com.obric.oui.color.c.a(r4);
        goto L10
    L5:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r21 = a.b;
        Intrinsics.checkNotNullParameter(r2, "core");
        r6 = new a(r2);
        goto L6
    }

    public static final c[] b(e[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(a(r5[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r6 = r0.toArray(new c[0]);
        if (r6 == null) goto L10;
        return (c[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final com.obric.oui.shadow.a[] c(com.obric.oui.shadow.b[] r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        ArrayList r1 = new ArrayList(r14.length);
        int r2 = r14.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        com.obric.oui.shadow.b r5 = r14[r4];
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r1.add(new com.obric.oui.shadow.a(r5.a, r5.b, r5.c, r5.d, r5.e, r5.f));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r15 = r1.toArray(new com.obric.oui.shadow.a[0]);
        if (r15 == null) goto L10;
        return (com.obric.oui.shadow.a[]) r15;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
