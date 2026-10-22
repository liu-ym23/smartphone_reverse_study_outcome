package com.google.common.collect;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g8 implements Comparator {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public g8() {
    }

    public static g8 allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static g8 arbitrary() {
        return f8.f8977a;
    }

    public static <T> g8 explicit(List<T> r5) {
        return new ExplicitOrdering(r5);
    }

    public static <T> g8 from(Comparator<T> r5) {
        if ((r5 instanceof g8) == false) goto L6;
        return (g8) r5;
    L6:
        return new ComparatorOrdering(r5);
    }

    public static <C extends Comparable> g8 natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static g8 usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<Object> r5, Object r10) {
        return Collections.binarySearch(r5, r10, this);
    }

    public <U> g8 compound(Comparator<? super U> r5) {
        r5.getClass();
        return new CompoundOrdering(this, r5);
    }

    public <E> List<E> greatestOf(Iterable<E> r5, int r10) {
        return reverse().leastOf(r5, r10);
    }

    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> r5) {
        return ImmutableList.sortedCopyOf(this, r5);
    }

    public boolean isOrdered(Iterable<Object> r5) {
        Iterator<Object> r10 = r5.iterator();
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
    L6:
        if (r10.hasNext() == false) goto L16;
        Object r12 = r10.next();
        if (compare(r11, r12) > 0) goto L9;
        r11 = r12;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<Object> r5) {
        Iterator<Object> r10 = r5.iterator();
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
    L6:
        if (r10.hasNext() == false) goto L16;
        Object r12 = r10.next();
        if (compare(r11, r12) >= 0) goto L9;
        r11 = r12;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public <E> List<E> leastOf(Iterable<E> r10, int r11) {
        if ((r10 instanceof Collection) == false) goto L12;
        Collection r5 = (Collection) r10;
        if (r5.size() > (((long) r11) * 2)) goto L12;
        Object[] r12 = r5.toArray();
        Arrays.sort(r12, this);
        if (r12.length <= r11) goto L10;
        r12 = Arrays.copyOf(r12, r11);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r12));
    L12:
        return leastOf(r10.iterator(), r11);
    }

    public <S> g8 lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E> E max(Iterator<E> r5) {
        E r10 = r5.next();
    L4:
        if (r5.hasNext() == false) goto L6;
        E r11 = r10;
        r10 = (E) max(r11, r5.next());
        goto L4
    L6:
        return r10;
    }

    public <E> E min(Iterator<E> r5) {
        E r10 = r5.next();
    L4:
        if (r5.hasNext() == false) goto L6;
        E r11 = r10;
        r10 = (E) min(r11, r5.next());
        goto L4
    L6:
        return r10;
    }

    public <S> g8 nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S> g8 nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2> g8 onKeys() {
        return onResultOf(Maps$EntryFunction.KEY);
    }

    public <F> g8 onResultOf(com.google.common.base.q r5) {
        return new ByFunctionOrdering(r5, this);
    }

    public <S> g8 reverse() {
        return new ReverseOrdering(this);
    }

    public <E> List<E> sortedCopy(Iterable<E> r5) {
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r10 = (Collection) r5;
    L6:
        Object[] r11 = r10.toArray();
        Arrays.sort(r11, this);
        return p7.U(Arrays.asList(r11));
    L5:
        r10 = p7.V(r5.iterator());
        goto L6
    }

    public static <T> g8 explicit(T r5, T... r10) {
        return explicit(new Lists$OnePlusArrayList(r5, r10));
    }

    public <E> List<E> greatestOf(Iterator<E> r5, int r10) {
        return reverse().leastOf(r5, r10);
    }

    public static <T> g8 compound(Iterable<? extends Comparator<? super T>> r5) {
        return new CompoundOrdering(r5);
    }

    @Deprecated
    public static <T> g8 from(g8 r5) {
        r5.getClass();
        return r5;
    }

    public <E> E max(Iterable<E> r5) {
        return (E) max(r5.iterator());
    }

    public <E> E min(Iterable<E> r5) {
        return (E) min(r5.iterator());
    }

    public <E> E max(E r5, E r10) {
        if (compare(r5, r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    public <E> E min(E r5, E r10) {
        if (compare(r5, r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E max(E r5, E r10, E r11, E... r12) {
        E r13 = (E) max(max(r5, r10), r11);
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        E r16 = r13;
        r13 = (E) max(r16, r12[r15]);
        r15 = r15 + 1;
        goto L3
    L5:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E min(E r5, E r10, E r11, E... r12) {
        E r13 = (E) min(min(r5, r10), r11);
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        E r16 = r13;
        r13 = (E) min(r16, r12[r15]);
        r15 = r15 + 1;
        goto L3
    L5:
        return r13;
    }

    public <E> List<E> leastOf(Iterator<E> r14, int r15) {
        r14.getClass();
        p7.q(r15, "k");
        if (r15 == 0) goto L59;
        if (r14.hasNext() == false) goto L59;
        if (r15 < 1073741823) goto L14;
        ArrayList r16 = p7.V(r14);
        Collections.sort(r16, this);
        if (r16.size() <= r15) goto L12;
        r16.subList(r15, r16.size()).clear();
    L12:
        r16.trimToSize();
        return Collections.unmodifiableList(r16);
    L14:
        com.bytedance.crash.upload.t r5 = new com.bytedance.crash.upload.t(this, r15);
    L15:
        boolean r13 = r14.hasNext();
        int r10 = 0;
        g8 r11 = (g8) r5.d;
        Object[] r12 = (Object[]) r5.e;
        int r17 = r5.f4160b;
        if (r13 == false) goto L53;
        E r18 = r14.next();
        if (r17 == 0) goto L15;
        int r19 = r5.f4161c;
        if (r19 == 0) goto L22;
        if (r19 < r17) goto L24;
        if (r11.compare(r18, r5.f) >= 0) goto L15;
        int r20 = r5.f4161c;
        int r21 = r20 + 1;
        r5.f4161c = r21;
        r12[r20] = r18;
        int r110 = r17 * 2;
        if (r21 != r110) goto L15;
        int r111 = r110 - 1;
        int r22 = com.lynx.tasm.utils.g.k(r111, RoundingMode.CEILING) * 3;
        int r23 = 0;
        int r24 = 0;
    L32:
        if (r10 >= r111) goto L47;
        int r25 = ((r10 + r111) + 1) >>> 1;
        Object r26 = r12[r25];
        r12[r25] = r12[r111];
        int r27 = r10;
        int r112 = r27;
    L34:
        if (r27 >= r111) goto L39;
        if (r11.compare(r12[r27], r26) >= 0) goto L38;
        Object r113 = r12[r112];
        r12[r112] = r12[r27];
        r12[r27] = r113;
        r112 = r112 + 1;
    L38:
        r27 = r27 + 1;
        goto L34
    L39:
        r12[r111] = r12[r112];
        r12[r112] = r26;
        if (r112 <= r17) goto L42;
        r111 = r112 - 1;
    L44:
        r23 = r23 + 1;
        if (r23 < r22) goto L32;
        Arrays.sort(r12, r10, r111 + 1, r11);
        goto L47
    L42:
        if (r112 >= r17) goto L47;
        r10 = Math.max(r112, r10 + 1);
        r24 = r112;
    L47:
        r5.f4161c = r17;
        r5.f = r12[r24];
    L48:
        r24 = r24 + 1;
        if (r24 >= r17) goto L15;
        if (r11.compare(r12[r24], r5.f) <= 0) goto L48;
        r5.f = r12[r24];
        goto L48
    L24:
        r5.f4161c = r19 + 1;
        r12[r19] = r18;
        if (r11.compare(r18, r5.f) <= 0) goto L15;
        r5.f = r18;
        goto L15
    L22:
        r12[0] = r18;
        r5.f = r18;
        r5.f4161c = 1;
        goto L15
    L53:
        Arrays.sort(r12, 0, r5.f4161c, r11);
        if (r5.f4161c <= r17) goto L57;
        Arrays.fill(r12, r17, r12.length, null);
        r5.f4161c = r17;
        r5.f = r12[r17 - 1];
    L57:
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(r12, r5.f4161c)));
    L59:
        return Collections.emptyList();
    }
}
