package yd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e extends defpackage.c {
    public static final List r0(Object[] r8) {
        he.i.f(r8, "<this>");
        List r10 = Arrays.asList(r8);
        he.i.e(r10, "asList(this)");
        return r10;
    }

    public static final void s0(Object[] r8, Object[] r10, int r11, int r12, int r13) {
        he.i.f(r8, "<this>");
        he.i.f(r10, "destination");
        System.arraycopy(r8, r12, r10, r11, r13 - r12);
    }

    public static final <T> T t0(T[] r8, int r10) {
        if (r10 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r10 > (r8.length - 1)) goto L6;
        return r8[r10];
    }

    public static String u0(Object[] r8) {
        StringBuilder r10 = new StringBuilder();
        r10.append("");
        int r11 = r8.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L8;
        Object r14 = r8[r12];
        r13 = r13 + 1;
        if (r13 <= 1) goto L7;
        r10.append(", ");
    L7:
        defpackage.c.q(r10, r14, null);
        r12 = r12 + 1;
        goto L3
    L8:
        r10.append("");
        String r15 = r10.toString();
        he.i.e(r15, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r15;
    }

    public static final void v0(HashSet r8, Object[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r8.add(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    public static final <T> List<T> w0(T[] r8) {
        he.i.f(r8, "<this>");
        int r10 = r8.length;
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L11;
        return new ArrayList(new c(r8));
    L11:
        return l6.a.k0(r8[0]);
    L9:
        return k.f14119a;
    }
}
