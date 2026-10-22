package com.obric.miniapp.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MenuPopupLayoutUtilsKt {
    public static final int a(c6 r3) {
        return RangesKt.coerceAtLeast(r3.c - r3.a, 0) * RangesKt.coerceAtLeast(r3.d - r3.b, 0);
    }

    public static final List<l4> b(List<l4> r19) {
        Intrinsics.checkNotNullParameter(r19, "snapshots");
        List<l4> r1 = r19;
        Iterator r2 = SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r1), new o4()), MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2.INSTANCE).iterator();
        if (r2.hasNext() == true) goto L5;
        Object r3 = null;
    L14:
        c6 r4 = (c6) r3;
        if (r4 != null) goto L18;
        return r19;
    L18:
        if (r4.a == 0) goto L20;
    L22:
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r5 = r1.iterator();
    L24:
        if (r5.hasNext() == false) goto L42;
        l4 r6 = (l4) r5.next();
        int r7 = r4.a;
        int r8 = r4.b;
        int r9 = r6.a - r7;
        int r10 = r6.b - r8;
        Integer r11 = r6.g;
        if (r11 == null) goto L28;
        Integer r15 = Integer.valueOf(r11.intValue() - r7);
    L29:
        Integer r12 = r6.h;
        if (r12 == null) goto L32;
        Integer r16 = Integer.valueOf(r12.intValue() - r8);
    L33:
        Integer r13 = r6.i;
        if (r13 == null) goto L36;
        Integer r17 = Integer.valueOf(r13.intValue() - r7);
    L37:
        Integer r14 = r6.j;
        if (r14 == null) goto L40;
        Integer r18 = Integer.valueOf(r14.intValue() - r8);
    L41:
        r0.add(new l4(r9, r10, r6.c, r6.d, r6.e, r6.f, r15, r16, r17, r18));
        goto L24
    L40:
        r18 = null;
        goto L41
    L36:
        r17 = null;
        goto L37
    L32:
        r16 = null;
        goto L33
    L28:
        r15 = null;
        goto L29
    L42:
        return r0;
    L20:
        if (r4.b != 0) goto L22;
        return r19;
    L5:
        r3 = r2.next();
        if (r2.hasNext() == false) goto L14;
        int r20 = a((c6) r3);
    L9:
        Object r21 = r2.next();
        int r22 = a((c6) r21);
        if (r20 >= r22) goto L13;
        r3 = r21;
        r20 = r22;
    L13:
        if (r2.hasNext() == true) goto L9;
        goto L14
    }

    public static final c6 d(l4 r7) {
        Integer r0 = r7.g;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r2 = r1;
        Integer r3 = r7.h;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        int r5 = r4;
        Integer r6 = r7.i;
        int r8 = Integer.MIN_VALUE;
        if (r6 == null) goto L13;
        int r9 = r6.intValue();
    L14:
        int r10 = Math.max(r9, r7.a + r7.c);
        Integer r11 = r7.j;
        if (r11 == null) goto L17;
        r8 = r11.intValue();
    L17:
        int r12 = Math.max(r8, r7.b + r7.d);
        if (r10 <= r2) goto L23;
        if (r12 > r5) goto L22;
        return null;
    L22:
        return new c6(r2, r5, r10, r12, r7.e);
    L23:
        return null;
    L13:
        r9 = Integer.MIN_VALUE;
        goto L14
    L9:
        r4 = r7.b;
        goto L10
    L5:
        r1 = r7.a;
        goto L6
    }

    public static final c6 e(List<c6> r8) {
        Iterator<T> r0 = r8.iterator();
        if (r0.hasNext() == false) goto L58;
        int r1 = ((c6) r0.next()).a;
    L5:
        int r3 = r1;
    L7:
        if (r0.hasNext() == false) goto L11;
        r1 = ((c6) r0.next()).a;
        if (r3 <= r1) goto L7;
    L11:
        Iterator<T> r2 = r8.iterator();
        if (r2.hasNext() == false) goto L56;
        int r4 = ((c6) r2.next()).b;
    L14:
        int r5 = r4;
    L16:
        if (r2.hasNext() == false) goto L20;
        r4 = ((c6) r2.next()).b;
        if (r5 <= r4) goto L16;
    L20:
        Iterator<T> r6 = r8.iterator();
        if (r6.hasNext() == false) goto L54;
        int r7 = ((c6) r6.next()).c;
    L23:
        int r9 = r7;
    L25:
        if (r6.hasNext() == false) goto L29;
        r7 = ((c6) r6.next()).c;
        if (r9 >= r7) goto L25;
    L29:
        Iterator<T> r10 = r8.iterator();
        if (r10.hasNext() == false) goto L52;
        int r11 = ((c6) r10.next()).d;
    L32:
        int r12 = r11;
    L34:
        if (r10.hasNext() == false) goto L38;
        r11 = ((c6) r10.next()).d;
        if (r12 >= r11) goto L34;
    L38:
        Iterator<T> r13 = r8.iterator();
        if (r13.hasNext() == false) goto L50;
        int r14 = ((c6) r13.next()).e;
    L41:
        int r15 = r14;
    L43:
        if (r13.hasNext() == false) goto L48;
        r14 = ((c6) r13.next()).e;
        if (r15 <= r14) goto L43;
    L48:
        return new c6(r3, r5, r9, r12, r15);
    L50:
        throw new NoSuchElementException();
    L52:
        throw new NoSuchElementException();
    L54:
        throw new NoSuchElementException();
    L56:
        throw new NoSuchElementException();
    L58:
        throw new NoSuchElementException();
    }

    public static final k4 c(List<l4> r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "snapshots");
        List<l4> r11 = r8;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r11.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        c6 r2 = d((l4) r1.next());
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L11;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        Object r14 = r13.next();
        if (((l4) r14).f == false) goto L14;
        r12.add(r14);
        goto L14
    L18:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        c6 r17 = d((l4) r16.next());
        if (r17 == null) goto L20;
        r15.add(r17);
        goto L20
    L24:
        Object r3 = null;
        if ((!r15.isEmpty()) == true) goto L28;
        r15 = null;
    L28:
        if (r15 == null) goto L30;
        c6 r18 = e(r15);
    L31:
        if (r18 != null) goto L33;
        c6 r19 = e(r0);
    L34:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r0.iterator();
    L36:
        if (r5.hasNext() == false) goto L49;
        Object r6 = r5.next();
        c6 r7 = (c6) r6;
        if (r7.a <= r19.a) goto L40;
    L46:
        boolean r20 = false;
    L47:
        if (r20 == false) goto L36;
        r4.add(r6);
        goto L36
    L40:
        if (r7.b > r19.b) goto L46;
        if (r7.c < r19.c) goto L46;
        if (r7.d < r19.d) goto L46;
        r20 = true;
        goto L47
    L49:
        Iterator r21 = r4.iterator();
        if (r21.hasNext() == false) goto L61;
        r3 = r21.next();
        if (r21.hasNext() == false) goto L61;
        int r22 = a((c6) r3);
    L56:
        Object r23 = r21.next();
        int r24 = a((c6) r23);
        if (r22 <= r24) goto L60;
        r3 = r23;
        r22 = r24;
    L60:
        if (r21.hasNext() == true) goto L56;
    L61:
        c6 r25 = (c6) r3;
        if (r25 == null) goto L65;
        r19 = r25;
    L65:
        if (r18 == null) goto L67;
        int r26 = a(r18);
    L68:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r4.iterator();
    L70:
        if (r28.hasNext() == false) goto L79;
        Object r29 = r28.next();
        c6 r30 = (c6) r29;
        if (r26 > 0) goto L74;
    L76:
        boolean r31 = false;
    L77:
        if (r31 == false) goto L70;
        r27.add(r29);
        goto L70
    L74:
        if (a(r30) > (r26 * 3)) goto L76;
        r31 = true;
        goto L77
    L79:
        c6 r110 = (c6) CollectionsKt.minWithOrNull(r27, ComparisonsKt.compareBy(new Function1[]{new m4(), new n4()}));
        if (r18 != null) goto L83;
    L89:
        r18 = r19;
    L91:
        int r111 = r18.a;
        return new k4(r111, r18.b, RangesKt.coerceAtLeast(r18.c - r111, 0), RangesKt.coerceAtLeast(r18.d - r18.b, 0));
    L83:
        if (a(r18) == 0) goto L89;
        if (r110 == null) goto L87;
        r18 = r110;
        goto L91
    L87:
        if (a(r19) <= (a(r18) * 3)) goto L89;
    L67:
        r26 = 0;
        goto L68
    L33:
        r19 = r18;
        goto L34
    L30:
        r18 = null;
        goto L31
    L11:
        return new k4(0, 0, RangesKt.coerceAtLeast(r9, 0), RangesKt.coerceAtLeast(r10, 0));
    }
}
