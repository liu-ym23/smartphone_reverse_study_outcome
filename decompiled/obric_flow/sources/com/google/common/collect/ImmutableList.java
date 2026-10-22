package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableList f8819b;

        public ReverseImmutableList(ImmutableList<E> r5) {
            this.f8819b = r5;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.f8819b.contains(r5);
        }

        @Override // java.util.List
        public E get(int r5) {
            com.google.common.base.b0.l(r5, size());
            return this.f8819b.get((size() - 1) - r5);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object r5) {
            int r10 = this.f8819b.lastIndexOf(r5);
            if (r10 >= 0) goto L7;
            return -1;
        L7:
            return (size() - 1) - r10;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f8819b.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object r5) {
            int r10 = this.f8819b.indexOf(r5);
            if (r10 >= 0) goto L7;
            return -1;
        L7:
            return (size() - 1) - r10;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f8819b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f8819b.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r5, int r10) {
            return subList(r5, r10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r5) {
            return super.listIterator(r5);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r5, int r10) {
            com.google.common.base.b0.p(r5, r10, size());
            int r11 = size() - r10;
            int r12 = size() - r5;
            return this.f8819b.subList(r11, r12).reverse();
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] r5) {
            this.elements = r5;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;
        final /* synthetic */ ImmutableList this$0;

        public SubList(ImmutableList r5, int r10, int r11) {
            this.this$0 = r5;
            this.offset = r10;
            this.length = r11;
        }

        @Override // java.util.List
        public E get(int r5) {
            com.google.common.base.b0.l(r5, this.length);
            return this.this$0.get(r5 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r5, int r10) {
            return subList(r5, r10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r5) {
            return super.listIterator(r5);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r5, int r10) {
            com.google.common.base.b0.p(r5, r10, this.length);
            ImmutableList r11 = this.this$0;
            int r12 = this.offset;
            return r11.subList(r5 + r12, r10 + r12);
        }
    }

    public ImmutableList() {
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r5) {
        return asImmutableList(r5, r5.length);
    }

    public static <E> u3 builder() {
        return new u3(4);
    }

    public static <E> u3 builderWithExpectedSize(int r5) {
        p7.q(r5, "expectedSize");
        return new u3(r5);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> r5) {
        if ((r5 instanceof ImmutableCollection) == false) goto L8;
        ImmutableList<E> r10 = ((ImmutableCollection) r5).asList();
        if (r10.isPartialView() == true) goto L7;
        return r10;
    L7:
        return asImmutableList(r10.toArray());
    L8:
        Object[] r11 = r5.toArray();
        p7.o(r11.length, r11);
        return asImmutableList(r11);
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream r5) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> r5) {
        Comparable[] r10 = new Comparable[0];
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r5;
    L6:
        Comparable[] r12 = (Comparable[]) r11.toArray(r10);
        p7.o(r12.length, r12);
        Arrays.sort(r12);
        return asImmutableList(r12);
    L5:
        r11 = p7.V(r5.iterator());
        goto L6
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return n1.f9084a;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int r5, E r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int r5, Collection<? extends E> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r5[r10 + r12] = get(r12);
        r12 = r12 + 1;
        goto L3
    L6:
        return r10 + r11;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof List) == false) goto L36;
        List r11 = (List) r10;
        int r5 = size();
        if (r5 != r11.size()) goto L36;
        if ((r11 instanceof RandomAccess) == false) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r5) goto L38;
        if (com.google.common.base.b0.w(get(r12), r11.get(r12)) == false) goto L36;
        r12 = r12 + 1;
        goto L14
    L38:
        return true;
    L19:
        Iterator<E> r13 = iterator();
        Iterator<E> r14 = r11.iterator();
    L21:
        if (r13.hasNext() == false) goto L29;
        if (r14.hasNext() == false) goto L36;
        if (com.google.common.base.b0.w(r13.next(), r14.next()) == true) goto L21;
    L29:
        return !r14.hasNext();
    L36:
        return false;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        com.google.common.base.b0.m(r5);
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5.accept(get(r11));
        r11 = r11 + 1;
        goto L3
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int r5 = size();
        int r10 = 1;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        int r12 = get(r11).hashCode();
        r10 = ~(~(r12 + (r10 * 31)));
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // java.util.List
    public int indexOf(Object r5) {
        if (r5 == null) goto L14;
        int r10 = size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L15;
        if (r5.equals(get(r11)) == true) goto L11;
        r11 = r11 + 1;
        goto L6
    L11:
        return r11;
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r5) {
        if (r5 == null) goto L14;
        int r10 = size() - 1;
    L6:
        if (r10 < 0) goto L15;
        if (r5.equals(get(r10)) == true) goto L11;
        r10 = r10 - 1;
        goto L6
    L11:
        return r10;
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> r5) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        if (size() > 1) goto L6;
        return this;
    L6:
        return new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int r5, E r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return p7.N(size(), 1296, new w1(this, 5), null);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int r5, int r10) {
        return subList(r5, r10);
    }

    public ImmutableList<E> subListUnchecked(int r5, int r10) {
        return new SubList(this, r5, r10 - r5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r5, int r10) {
        if (r10 == 0) goto L13;
        if (r10 != 1) goto L6;
        Object r11 = r5[0];
        Objects.requireNonNull(r11);
        return of(r11);
    L6:
        if (r10 >= r5.length) goto L9;
        r5 = Arrays.copyOf(r5, r10);
    L9:
        return new RegularImmutableList(r5);
    L13:
        return of();
    }

    public static <E> ImmutableList<E> of(E r5) {
        return new SingletonImmutableList(r5);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r5) {
        return listIterator(r5);
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r5, int r10) {
        com.google.common.base.b0.p(r5, r10, size());
        int r11 = r10 - r5;
        if (r11 != size()) goto L5;
        return this;
    L5:
        if (r11 != 0) goto L9;
        return of();
    L9:
        if (r11 != 1) goto L13;
        return of(get(r5));
    L13:
        return subListUnchecked(r5, r10);
    }

    public static <E> ImmutableList<E> of(E r5, E r10) {
        Object[] r11 = {r5, r10};
        p7.o(2, r11);
        return asImmutableList(r11);
    }

    @Override // java.util.List
    public ha listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ha listIterator(int r5) {
        return new x0(this, size(), r5);
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11) {
        Object[] r12 = {r5, r10, r11};
        p7.o(3, r12);
        return asImmutableList(r12);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> r5) {
        if (r5.hasNext() == false) goto L5;
        E r10 = r5.next();
        if (r5.hasNext() == false) goto L9;
        u3 r11 = new u3(4);
        r11.B0(r10);
        r11.h(r5);
        return r11.D0();
    L9:
        return of(r10);
    L5:
        return of();
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12) {
        Object[] r13 = {r5, r10, r11, r12};
        p7.o(4, r13);
        return asImmutableList(r13);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> r5, Iterable<? extends E> r10) {
        r5.getClass();
        if ((r10 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r10;
    L6:
        Object[] r12 = r11.toArray();
        p7.o(r12.length, r12);
        Arrays.sort(r12, r5);
        return asImmutableList(r12);
    L5:
        r11 = p7.V(r10.iterator());
        goto L6
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13) {
        Object[] r14 = {r5, r10, r11, r12, r13};
        p7.o(5, r14);
        return asImmutableList(r14);
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14) {
        Object[] r15 = {r5, r10, r11, r12, r13, r14};
        p7.o(6, r15);
        return asImmutableList(r15);
    }

    public static <E> ImmutableList<E> copyOf(E[] r5) {
        int r10 = r5.length;
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L9;
        Object[] r11 = (Object[]) r5.clone();
        p7.o(r11.length, r11);
        return asImmutableList(r11);
    L9:
        return of(r5[0]);
    L11:
        return of();
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E r15) {
        Object[] r16 = {r5, r10, r11, r12, r13, r14, r15};
        p7.o(7, r16);
        return asImmutableList(r16);
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E r15, E r16) {
        Object[] r17 = {r5, r10, r11, r12, r13, r14, r15, r16};
        p7.o(8, r17);
        return asImmutableList(r17);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> r5) {
        r5.getClass();
        if ((r5 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r5);
    L6:
        return copyOf(r5.iterator());
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17) {
        Object[] r18 = {r5, r10, r11, r12, r13, r14, r15, r16, r17};
        p7.o(9, r18);
        return asImmutableList(r18);
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18) {
        Object[] r19 = {r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        p7.o(10, r19);
        return asImmutableList(r19);
    }

    public static <E> ImmutableList<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18, E r19) {
        Object[] r20 = {r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        p7.o(11, r20);
        return asImmutableList(r20);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18, E r19, E r110, E r111, E... r112) {
        if (r112.length > 2147483635) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.g("the total number of elements must fit in an int", r5);
        int r20 = r112.length + 12;
        Object[] r21 = new Object[r20];
        r21[0] = r10;
        r21[1] = r11;
        r21[2] = r12;
        r21[3] = r13;
        r21[4] = r14;
        r21[5] = r15;
        r21[6] = r16;
        r21[7] = r17;
        r21[8] = r18;
        r21[9] = r19;
        r21[10] = r110;
        r21[11] = r111;
        System.arraycopy(r112, 0, r21, 12, r112.length);
        p7.o(r20, r21);
        return asImmutableList(r21);
    L5:
        r5 = false;
        goto L6
    }
}
