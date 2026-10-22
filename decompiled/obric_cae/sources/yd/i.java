package yd;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h {
    public static final <T> T g1(List<? extends T> r8) {
        if (r8.isEmpty() == true) goto L7;
        return r8.get(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static final Object h1(int r8, List r10) {
        if (r8 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r8 > l6.a.O(r10)) goto L6;
        return r10.get(r8);
    }

    public static final void i1(List r8, StringBuilder r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, ge.l r16) {
        he.i.f(r8, "<this>");
        he.i.f(r11, "separator");
        he.i.f(r12, "prefix");
        he.i.f(r13, "postfix");
        he.i.f(r15, "truncated");
        r10.append(r12);
        Iterator r17 = r8.iterator();
        int r18 = 0;
    L4:
        if (r17.hasNext() == false) goto L11;
        Object r19 = r17.next();
        r18 = r18 + 1;
        if (r18 <= 1) goto L8;
        r10.append(r11);
    L8:
        if (r14 < 0) goto L10;
        if (r18 > r14) goto L11;
    L10:
        defpackage.c.q(r10, r19, r16);
    L11:
        if (r14 < 0) goto L14;
        if (r18 <= r14) goto L14;
        r10.append(r15);
    L14:
        r10.append(r13);
    }

    public static String j1(List r8, String r10, ge.l r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r10 = ", ";
    L5:
        String r13 = r10;
        if ((r12 & 2) == 0) goto L8;
        CharSequence r14 = "";
    L10:
        if ((r12 & 4) == 0) goto L12;
        CharSequence r15 = "";
    L14:
        if ((r12 & 8) == 0) goto L16;
        int r16 = -1;
    L17:
        int r17 = r16;
        if ((r12 & 16) == 0) goto L20;
        CharSequence r18 = "...";
    L22:
        if ((r12 & 32) == 0) goto L24;
        ge.l r19 = null;
    L25:
        he.i.f(r8, "<this>");
        he.i.f(r13, "separator");
        he.i.f(r14, "prefix");
        he.i.f(r15, "postfix");
        he.i.f(r18, "truncated");
        StringBuilder r20 = new StringBuilder();
        i1(r8, r20, r13, r14, r15, r17, r18, r19);
        String r21 = r20.toString();
        he.i.e(r21, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r21;
    L24:
        r19 = r11;
        goto L25
    L20:
        r18 = null;
        goto L22
    L16:
        r16 = 0;
        goto L17
    L12:
        r15 = null;
        goto L14
    L8:
        r14 = null;
        goto L10
    }

    public static final void k1(Iterable r8, AbstractCollection r10) {
        he.i.f(r8, "<this>");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(r11.next());
        goto L4
    }

    public static final float[] l1(ArrayList r8) {
        float[] r10 = new float[r8.size()];
        Iterator r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r10[r12] = ((Number) r11.next()).floatValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    public static final int[] m1(ArrayList r8) {
        int[] r10 = new int[r8.size()];
        Iterator r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r10[r12] = ((Number) r11.next()).intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    public static final <T> List<T> n1(Iterable<? extends T> r8) {
        he.i.f(r8, "<this>");
        boolean r10 = r8 instanceof Collection;
        if (r10 == false) goto L16;
        Collection r11 = (Collection) r8;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return new ArrayList(r11);
    L10:
        if ((r8 instanceof List) == false) goto L12;
        Object r13 = ((List) r8).get(0);
    L22:
        return l6.a.k0(r13);
    L12:
        r13 = r8.iterator().next();
        goto L22
    L15:
        return k.f14119a;
    L16:
        if (r10 == false) goto L18;
        ArrayList r14 = new ArrayList((Collection) r8);
    L20:
        return l6.a.v0(r14);
    L18:
        r14 = new ArrayList();
        k1(r8, r14);
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Set o1(AbstractCollection r8) {
        he.i.f(r8, "<this>");
        m r10 = m.f14121a;
        int r11 = r8.size();
        if (r11 != 0) goto L5;
        return r10;
    L5:
        if (r11 == 1) goto L8;
        LinkedHashSet r12 = new LinkedHashSet(l6.a.n0(r8.size()));
        k1(r8, r12);
        return r12;
    L8:
        if ((r8 instanceof List) == false) goto L10;
        Object r13 = ((List) r8).get(0);
    L11:
        Set r14 = Collections.singleton(r13);
        he.i.e(r14, "singleton(element)");
        return r14;
    L10:
        r13 = r8.iterator().next();
        goto L11
    }
}
