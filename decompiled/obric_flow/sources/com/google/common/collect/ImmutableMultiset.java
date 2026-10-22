package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements z7 {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ImmutableList f8829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ImmutableSet f8830c;

    public static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final z7 delegate;
        private final List<y7> entries;

        public ElementSet(List<y7> r5, z7 r10) {
            this.entries = r5;
            this.delegate = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.delegate.contains(r5);
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        public E get(int r5) {
            return (E) this.entries.get(r5).getElement();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    public final class EntrySet extends IndexedImmutableSet<y7> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        public EntrySet(ImmutableMultiset r5, h4 r10) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if ((r5 instanceof y7) == false) goto L11;
            y7 r10 = (y7) r5;
            if (r10.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r10.getElement()) != r10.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ y7 get(int r5) {
            return get(r5);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.IndexedImmutableSet
        public y7 get(int r5) {
            return this.this$0.getEntry(r5);
        }
    }

    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> r5) {
            this.multiset = r5;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(z7 r5) {
            int r10 = r5.entrySet().size();
            this.elements = new Object[r10];
            this.counts = new int[r10];
            Iterator<E> r11 = r5.entrySet().iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            y7 r13 = (y7) r11.next();
            this.elements[r12] = r13.getElement();
            this.counts[r12] = r13.getCount();
            r12 = r12 + 1;
            goto L4
        }

        public Object readResolve() {
            LinkedHashMultiset r5 = LinkedHashMultiset.create(this.elements.length);
            int r10 = 0;
        L3:
            Object[] r11 = this.elements;
            if (r10 >= r11.length) goto L7;
            r5.add(r11[r10], this.counts[r10]);
            r10 = r10 + 1;
            goto L3
        L7:
            return ImmutableMultiset.copyOf(r5);
        }
    }

    public ImmutableMultiset() {
    }

    public static ImmutableMultiset b(Object... r5) {
        LinkedHashMultiset r10 = LinkedHashMultiset.create();
        Collections.addAll(r10, r5);
        return copyFromEntries(r10.entrySet());
    }

    public static <E> i4 builder() {
        return new i4();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends y7> r5) {
        if (r5.isEmpty() == false) goto L7;
        return of();
    L7:
        return RegularImmutableMultiset.create(r5);
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r5) {
        return b(r5);
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) RegularImmutableMultiset.EMPTY;
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return n1.a(Function.identity(), new g4(0));
    }

    @Override // com.google.common.collect.z7
    @Deprecated
    public final int add(E r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r5 = this.f8829b;
        if (r5 != null) goto L6;
        ImmutableList<E> r10 = super.asList();
        this.f8829b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (count(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        ga r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        y7 r12 = (y7) r11.next();
        Arrays.fill(r5, r10, r12.getCount() + r10, r12.getElement());
        r10 = r10 + r12.getCount();
        goto L4
    L6:
        return r10;
    }

    public abstract /* synthetic */ int count(Object r5);

    public abstract ImmutableSet<E> elementSet();

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.z7
    public boolean equals(Object r5) {
        return p7.z(this, r5);
    }

    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    public abstract y7 getEntry(int r5);

    @Override // java.util.Collection, com.google.common.collect.z7
    public int hashCode() {
        return p7.J(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.z7
    @Deprecated
    public final int remove(Object r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.z7
    @Deprecated
    public final int setCount(E r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r5) {
        if ((r5 instanceof ImmutableMultiset) == false) goto L8;
        ImmutableMultiset<E> r10 = (ImmutableMultiset) r5;
        if (r10.isPartialView() == true) goto L8;
        return r10;
    L8:
        if ((r5 instanceof z7) == false) goto L10;
        z7 r11 = (z7) r5;
    L12:
        return copyFromEntries(r11.entrySet());
    L10:
        r11 = LinkedHashMultiset.create(r5);
        goto L12
    }

    public static <E> ImmutableMultiset<E> of(E r5) {
        return b(new Object[]{r5});
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> r5, ToIntFunction<? super T> r10) {
        return n1.a(r5, r10);
    }

    @Override // com.google.common.collect.z7
    public ImmutableSet<y7> entrySet() {
        ImmutableSet<y7> r5 = this.f8830c;
        if (r5 == null) goto L5;
    L9:
        return r5;
    L5:
        if (isEmpty() == false) goto L7;
        r5 = ImmutableSet.of();
    L8:
        this.f8830c = r5;
        goto L9
    L7:
        r5 = new EntrySet(this, null);
        goto L8
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return new h4(entrySet().iterator());
    }

    @Override // com.google.common.collect.z7
    @Deprecated
    public final boolean setCount(E r5, int r10, int r11) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E r5, E r10) {
        return b(new Object[]{r5, r10});
    }

    public static <E> ImmutableMultiset<E> of(E r5, E r10, E r11) {
        return b(new Object[]{r5, r10, r11});
    }

    public static <E> ImmutableMultiset<E> of(E r5, E r10, E r11, E r12) {
        return b(new Object[]{r5, r10, r11, r12});
    }

    public static <E> ImmutableMultiset<E> of(E r5, E r10, E r11, E r12, E r13) {
        return b(new Object[]{r5, r10, r11, r12, r13});
    }

    public static <E> ImmutableMultiset<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E... r15) {
        i4 r16 = new i4();
        r16.B0(r5);
        r16.B0(r10);
        r16.B0(r11);
        r16.B0(r12);
        r16.B0(r13);
        r16.B0(r14);
        int r17 = r15.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L6;
        r16.g(r15[r18]);
        r18 = r18 + 1;
        goto L3
    L6:
        return copyOf(r16.f9023b);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r5) {
        LinkedHashMultiset r10 = LinkedHashMultiset.create();
        p7.j(r10, r5);
        return copyFromEntries(r10.entrySet());
    }
}
