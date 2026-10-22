package com.ss.android.lark.chat.cot.detail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(List r9, j r10) {
        Intrinsics.checkNotNullParameter(r9, "items");
        Intrinsics.checkNotNullParameter(r10, "expandStore");
        List r0 = r9;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        if (((k) r1.next()).b != CotDetailBlockType.GROUP) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L9;
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
        return r9;
    L19:
        ArrayList r11 = new ArrayList();
        Iterator r3 = r0.iterator();
    L21:
        if (r3.hasNext() == false) goto L47;
        k r5 = (k) r3.next();
        u r6 = r5.c();
        s r7 = null;
        if (r6 == null) goto L25;
        String r8 = r6.c;
    L26:
        CotDetailBlockType r12 = r5.b;
        CotDetailBlockType r13 = CotDetailBlockType.GROUP;
        if (r12 != r13) goto L41;
        boolean r14 = r10.b(r5.a);
        b r15 = r5.g;
        if ((r15 instanceof s) == false) goto L31;
        s r16 = (s) r15;
    L33:
        if (r5.b != r13) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L38;
        r7 = r16;
    L38:
        if (r7 != null) goto L40;
        r7 = new s(0, 3);
    L40:
        r5 = k.a(r5, new s(r7.a, r14));
    L45:
        if (r5 == null) goto L21;
        r11.add(r5);
        goto L21
    L35:
        r17 = false;
        goto L36
    L31:
        r16 = null;
        goto L33
    L41:
        if (r8 == null) goto L45;
        if (r10.b(r8) == true) goto L45;
        r5 = null;
        goto L45
    L25:
        r8 = null;
        goto L26
    L47:
        return r11;
    L13:
        r4 = false;
    L16:
        r2 = true;
        goto L17
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }
}
