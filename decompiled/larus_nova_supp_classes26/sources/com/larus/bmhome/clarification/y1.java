package com.larus.bmhome.clarification;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y1 {
    public static final ze8.c a(z1 r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r8 != null) goto L5;
        r8 = r7.l.b;
    L5:
        boolean r2 = false;
        if (r8.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        boolean r9 = !StringsKt.isBlank(r8);
        boolean r4 = !r7.l.a.isEmpty();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.i == false) goto L12;
    L15:
        boolean r10 = true;
    L16:
        boolean r3 = !r1;
        boolean r5 = !r9;
        if (r9 == true) goto L22;
        if (r4 == true) goto L22;
        if (r10 == true) goto L22;
        boolean r6 = false;
    L23:
        if (r9 == true) goto L28;
        if (r4 == true) goto L28;
        if (r10 == true) goto L28;
        r2 = true;
    L28:
        return new ze8.c(r3, r5, r6, r2);
    L22:
        r6 = true;
        goto L23
    L12:
        if ((!r7.l.d.isEmpty()) == true) goto L15;
        r10 = false;
        goto L16
    L8:
        r1 = false;
        goto L9
    }
}
