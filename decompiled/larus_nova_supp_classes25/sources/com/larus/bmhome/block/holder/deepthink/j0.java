package com.larus.bmhome.block.holder.deepthink;

import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 {
    public static final jc8.d a(jc8.k r6, jc8.a r7) {
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        if (r6 == null) goto L38;
        tb8.a r8 = (tb8.a) r6.a(tb8.a.class);
        if (r8 == null) goto L38;
        boolean r0 = r8.e;
        fh8.d r9 = r8.f;
        boolean r1 = false;
        if (r9 == null) goto L10;
        boolean r10 = r9.b();
    L11:
        boolean r2 = r7.m();
        boolean r11 = r7.n();
        if (r10 == false) goto L16;
        if (r0 == false) goto L16;
        r1 = true;
    L16:
        if (r2 == false) goto L25;
        if (r11 == false) goto L25;
        int r3 = c7.b(16);
        int r4 = c7.b(12);
        int r5 = c7.b(16);
        if (r1 == false) goto L21;
        int r12 = 40;
    L23:
        return new jc8.d(r3, r4, r5, c7.b(r12));
    L21:
        r12 = 14;
    L25:
        if (r2 == true) goto L27;
        if (r11 == false) goto L36;
        int r13 = c7.b(16);
        int r14 = c7.b(6);
        int r15 = c7.b(16);
        if (r1 == false) goto L32;
        int r16 = 40;
    L34:
        return new jc8.d(r13, r14, r15, c7.b(r16));
    L32:
        r16 = 14;
        goto L34
    L36:
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(6));
    L27:
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(6));
    L10:
        r10 = false;
    L38:
        return jc8.e.d(r7);
    }
}
