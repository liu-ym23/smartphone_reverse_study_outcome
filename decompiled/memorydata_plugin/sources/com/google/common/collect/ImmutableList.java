package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        ReverseImmutableList(ImmutableList<E> r1) {
            this.forwardList = r1;
        }

        private int reverseIndex(int r1) {
            return (size() - 1) - r1;
        }

        private int reversePosition(int r1) {
            return size() - r1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.forwardList.contains(r1);
        }

        @Override // java.util.List
        public E get(int r2) {
            com.google.common.base.n.a(r2, size());
            return this.forwardList.get(reverseIndex(r2));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object r2) {
            int r3 = this.forwardList.lastIndexOf(r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r3);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object r2) {
            int r3 = this.forwardList.indexOf(r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
            return super.listIterator(r1);
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r2, int r3) {
            com.google.common.base.n.a(r2, r3, size());
            return this.forwardList.subList(reversePosition(r3), reversePosition(r2)).reverse();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] r1) {
            this.elements = r1;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;
        final /* synthetic */ ImmutableList this$0;

        SubList(ImmutableList r1, int r2, int r3) {
            this.this$0 = r1;
            this.offset = r2;
            this.length = r3;
        }

        @Override // java.util.List
        public E get(int r2) {
            com.google.common.base.n.a(r2, this.length);
            return this.this$0.get(r2 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
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

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
            return super.listIterator(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r2, int r3) {
            com.google.common.base.n.a(r2, r3, this.length);
            ImmutableList r0 = this.this$0;
            int r1 = this.offset;
            return r0.subList(r2 + r1, r3 + r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }
    }

    public static final class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f4444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4445b;
        private boolean c;

        public a() {
            this(4);
        }

        a(int r1) {
            this.f4444a = new Object[r1];
            this.f4445b = 0;
        }

        private void a(int r4) {
            Object[] r0 = this.f4444a;
            if (r0.length >= r4) goto L7;
            this.f4444a = Arrays.copyOf(r0, a(r0.length, r4));
        L5:
            this.c = false;
            return;
        L7:
            if (this.c == false) goto L10;
            this.f4444a = Arrays.copyOf(r0, r0.length);
            goto L5
        }

        private void a(Object[] r4, int r5) {
            a(this.f4445b + r5);
            System.arraycopy(r4, 0, this.f4444a, this.f4445b, r5);
            this.f4445b += r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object r1) {
            return b(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Iterator r3) {
            return b((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object[] r1) {
            return b(r1);
        }

        a<E> a(a<E> r2) {
            com.google.common.base.n.a(r2);
            a(r2.f4444a, r2.f4445b);
            return this;
        }

        public ImmutableList<E> a() {
            this.c = true;
            return ImmutableList.asImmutableList(this.f4444a, this.f4445b);
        }

        public a<E> b(E r4) {
            com.google.common.base.n.a(r4);
            a(this.f4445b + 1);
            Object[] r0 = this.f4444a;
            int r1 = this.f4445b;
            this.f4445b = r1 + 1;
            r0[r1] = r4;
            return this;
        }

        public a<E> b(Iterator<? extends E> r3) {
            super.a((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<E> b(E... r2) {
            ap.a(r2);
            a(r2, r2.length);
            return this;
        }
    }

    ImmutableList() {
    }

    static <E> ImmutableList<E> asImmutableList(Object[] r1) {
        return asImmutableList(r1, r1.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] r1, int r2) {
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L11;
        if (r2 >= r1.length) goto L9;
        r1 = Arrays.copyOf(r1, r2);
    L9:
        return new RegularImmutableList(r1);
    L11:
        return of(Objects.requireNonNull(r1[0]));
    L13:
        return of();
    }

    public static <E> a<E> builder() {
        return new a();
    }

    public static <E> a<E> builderWithExpectedSize(int r1) {
        o.a(r1, "expectedSize");
        return new a(r1);
    }

    private static <E> ImmutableList<E> construct(Object... r0) {
        return asImmutableList(ap.a(r0));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L6;
        return copyOf((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
    L6:
        return copyOf(r3.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ImmutableCollection.class) == false) goto L9;
        ImmutableList<E> r4 = ((ImmutableCollection) ZeusTransformUtils.preCheckCast(r3, ImmutableCollection.class, "com.obric.memorydata.plugin")).asList();
        if (r4.isPartialView() == true) goto L7;
        return r4;
    L7:
        return asImmutableList(r4.toArray());
    L9:
        return construct(r3.toArray());
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> r2) {
        Iterator<? extends E> r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r3.hasNext() == false) goto L5;
        E r0 = r3.next();
        if (r3.hasNext() == true) goto L11;
        return of(r0);
    L11:
        return new a().b(r0).b(r3).a();
    L5:
        return of();
    }

    public static <E> ImmutableList<E> copyOf(E[] r2) {
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return construct((Object[]) ZeusTransformUtils.preCheckCast(r2.clone(), Object[].class, "com.obric.memorydata.plugin"));
    L9:
        return of(r2[0]);
    L11:
        return of();
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E r1) {
        return new SingletonImmutableList(r1);
    }

    public static <E> ImmutableList<E> of(E r2, E r3) {
        return construct(new Object[]{r2, r3});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4) {
        return construct(new Object[]{r2, r3, r4});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5) {
        return construct(new Object[]{r2, r3, r4, r5});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6) {
        return construct(new Object[]{r2, r3, r4, r5, r6});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10, E r11) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10, E r11, E r12) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E r5, E r6, E r7, E r8, E r9, E r10, E r11, E r12, E r13, E r14, E r15, E r16, E... r17) {
        if (r17.length > 2147483635) goto L5;
        boolean r1 = true;
    L6:
        com.google.common.base.n.a(r1, "the total number of elements must fit in an int");
        Object[] r2 = new Object[r17.length + 12];
        r2[0] = r5;
        r2[1] = r6;
        r2[2] = r7;
        r2[3] = r8;
        r2[4] = r9;
        r2[5] = r10;
        r2[6] = r11;
        r2[7] = r12;
        r2[8] = r13;
        r2[9] = r14;
        r2[10] = r15;
        r2[11] = r16;
        System.arraycopy(r17, 0, r2, 12, r17.length);
        return construct(r2);
    L5:
        r1 = false;
        goto L6
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> r2) {
        Comparable[] r3 = (Comparable[]) ZeusTransformUtils.preCheckCast(aj.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), new Comparable[0]), Comparable[].class, "com.obric.memorydata.plugin");
        ap.a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"));
        Arrays.sort(r3);
        return asImmutableList(r3);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> r2, Iterable<? extends E> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        Object[] r6 = aj.c(r5);
        ap.a(r6);
        Arrays.sort(r6, r4);
        return asImmutableList(r6);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return n.a();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int r1, E r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int r1, Collection<? extends E> r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r5, int r6) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r5[r6 + r1] = get(r1);
        r1 = r1 + 1;
        goto L3
    L6:
        return r6 + r0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        return Lists.a(this, r1);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r4) {
        Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.accept(get(r1));
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = size();
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = ~(~((r1 * 31) + get(r2).hashCode()));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        return Lists.b(this, r1);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<E> iterator() {
        return listIterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        return Lists.c(this, r1);
    }

    @Override // java.util.List
    public bk<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public bk<E> listIterator(final int r3) {
        final int r1 = size();
        return new AnonymousClass1(this, r1, r3);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
        return listIterator(r1);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> r2) {
        UnaryOperator r1 = (UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, UnaryOperator.class, "com.obric.memorydata.plugin");
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
    public final E set(int r1, E r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> r2) {
        Comparator r1 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return p.a(size(), 1296, new $$Lambda$7YnsrrCw3tmMIJLzmvpisJV8X0(this));
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r3, int r4) {
        com.google.common.base.n.a(r3, r4, size());
        int r0 = r4 - r3;
        if (r0 != size()) goto L5;
        return this;
    L5:
        if (r0 != 0) goto L9;
        return of();
    L9:
        if (r0 != 1) goto L13;
        return of(get(r3));
    L13:
        return subListUnchecked(r3, r4);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
        return subList(r1, r2);
    }

    ImmutableList<E> subListUnchecked(int r2, int r3) {
        return new SubList(this, r2, r3 - r2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
