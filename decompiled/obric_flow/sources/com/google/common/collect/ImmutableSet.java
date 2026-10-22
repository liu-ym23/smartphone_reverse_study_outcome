package com.google.common.collect;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;
    static final int SPLITERATOR_CHARACTERISTICS = 1297;

    public static abstract class CachingAsList<E> extends ImmutableSet<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient ImmutableList f8838b;

        public CachingAsList() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public ImmutableList<E> asList() {
            ImmutableList<E> r5 = this.f8838b;
            if (r5 != null) goto L6;
            ImmutableList<E> r10 = createAsList();
            this.f8838b = r10;
            return r10;
        L6:
            return r5;
        }

        public ImmutableList<E> createAsList() {
            return new RegularImmutableAsList(this, toArray());
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    public static abstract class Indexed<E> extends CachingAsList<E> {
        public Indexed() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r5, int r10) {
            return asList().copyIntoArray(r5, r10);
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList
        public ImmutableList<E> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r5) {
            r5.getClass();
            int r10 = size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            r5.accept(get(r11));
            r11 = r11 + 1;
            goto L3
        }

        public abstract E get(int r5);

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return p7.N(size(), ImmutableSet.SPLITERATOR_CHARACTERISTICS, new w1(this, 1), null);
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public ga iterator() {
            return asList().iterator();
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] r5) {
            this.elements = r5;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public ImmutableSet() {
    }

    public static ImmutableSet b(int r5, int r10, Object... r11) {
        if (r5 == 0) goto L13;
        int r12 = 0;
        if (r5 == 1) goto L11;
        r4 r13 = new q4(r10);
    L6:
        if (r12 >= r5) goto L9;
        Object r14 = r11[r12];
        r14.getClass();
        r13 = r13.a(r14);
        r12 = r12 + 1;
        goto L6
    L9:
        return r13.e().c();
    L11:
        return of(r11[0]);
    L13:
        return of();
    }

    public static <E> n4 builder() {
        return new n4(0);
    }

    public static <E> n4 builderWithExpectedSize(int r5) {
        p7.q(r5, "expectedSize");
        return new n4(r5);
    }

    public static ImmutableSet c(int r5, Object... r10) {
        RoundingMode r11 = RoundingMode.CEILING;
        if (r5 < 0) goto L17;
        int r12 = (int) Math.sqrt(r5);
        switch(com.google.common.math.c.f9305a[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        int r13 = (r12 * r12) + r12;
    L9:
        r12 = r12 + ((~(~(r13 - r5))) >>> 31);
        goto L14
    L10:
        r13 = r12 * r12;
        goto L9
    L7:
        throw new AssertionError();
    L12:
        if ((r12 * r12) == r5) goto L14;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L14:
        return b(r5, Math.max(4, r12), r10);
    L17:
        StringBuilder r14 = new StringBuilder(28);
        r14.append("x (");
        r14.append(r5);
        r14.append(") must be >= 0");
        throw new IllegalArgumentException(r14.toString());
    }

    public static int chooseTableSize(int r5) {
        int r10 = Math.max(r5, 2);
        boolean r11 = true;
        if (r10 >= 751619276) goto L10;
        int r12 = Integer.highestOneBit(r10 - 1) << 1;
    L6:
        if ((((double) r12) * 0.7d) >= r10) goto L8;
        r12 = r12 << 1;
        goto L6
    L8:
        return r12;
    L10:
        if (r10 < 1073741824) goto L13;
        r11 = false;
    L13:
        com.google.common.base.b0.g("collection too large", r11);
        return 1073741824;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r5) {
        if ((r5 instanceof ImmutableSet) == false) goto L10;
        if ((r5 instanceof SortedSet) == true) goto L10;
        ImmutableSet<E> r10 = (ImmutableSet) r5;
        if (r10.isPartialView() == true) goto L13;
        return r10;
    L13:
        Object[] r11 = r5.toArray();
        if ((r5 instanceof Set) == false) goto L18;
        return b(r11.length, r11.length, r11);
    L18:
        return c(r11.length, r11);
    L10:
        if ((r5 instanceof EnumSet) == false) goto L13;
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf((EnumSet) r5));
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return n1.f9085b;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImmutableSet) == false) goto L16;
        if (isHashCodeFast() == false) goto L16;
        if (((ImmutableSet) r5).isHashCodeFast() == false) goto L16;
        if (hashCode() == r5.hashCode()) goto L16;
        return false;
    L16:
        return p7.A(this, r5);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return p7.J(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract ga iterator();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E r5) {
        return new SingletonImmutableSet(r5);
    }

    public static <E> ImmutableSet<E> of(E r5, E r10) {
        return b(2, 2, new Object[]{r5, r10});
    }

    public static <E> ImmutableSet<E> of(E r5, E r10, E r11) {
        return b(3, 3, new Object[]{r5, r10, r11});
    }

    public static <E> ImmutableSet<E> of(E r5, E r10, E r11, E r12) {
        return b(4, 4, new Object[]{r5, r10, r11, r12});
    }

    public static <E> ImmutableSet<E> of(E r5, E r10, E r11, E r12, E r13) {
        return b(5, 5, new Object[]{r5, r10, r11, r12, r13});
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E... r15) {
        if (r15.length > 2147483641) goto L5;
        boolean r16 = true;
    L6:
        com.google.common.base.b0.g("the total number of elements must fit in an int", r16);
        int r17 = r15.length + 6;
        Object[] r18 = new Object[r17];
        r18[0] = r5;
        r18[1] = r10;
        r18[2] = r11;
        r18[3] = r12;
        r18[4] = r13;
        r18[5] = r14;
        System.arraycopy(r15, 0, r18, 6, r15.length);
        return b(r17, r17, r18);
    L5:
        r16 = false;
        goto L6
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r5) {
        if ((r5 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r5);
    L6:
        return copyOf(r5.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r5) {
        if (r5.hasNext() == false) goto L5;
        E r10 = r5.next();
        if (r5.hasNext() == false) goto L9;
        n4 r11 = new n4(0);
        r11.B0(r10);
        r11.h(r5);
        return r11.C0();
    L9:
        return of(r10);
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(E[] r5) {
        int r10 = r5.length;
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L9;
        return c(r5.length, (Object[]) r5.clone());
    L9:
        return of(r5[0]);
    L11:
        return of();
    }
}
