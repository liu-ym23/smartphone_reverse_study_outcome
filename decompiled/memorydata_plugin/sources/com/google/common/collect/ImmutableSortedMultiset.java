package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements az<E> {
    transient ImmutableSortedMultiset<E> descendingMultiset;

    private static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(az<E> r6) {
            az r7 = (az) ZeusTransformUtils.wrapperContextForParams(r6, az.class, "com.obric.memorydata.plugin");
            this.comparator = r7.comparator();
            int r0 = r7.entrySet().size();
            this.elements = (E[]) new Object[r0];
            this.counts = new int[r0];
            Iterator<an.a<E>> r8 = r7.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r8.hasNext() == false) goto L6;
            an.a r2 = (an.a) ZeusTransformUtils.preCheckCast(r8.next(), an.a.class, "com.obric.memorydata.plugin");
            ((E[]) this.elements)[r1] = r2.getElement();
            this.counts[r1] = r2.getCount();
            r1 = r1 + 1;
            goto L4
        }

        Object readResolve() {
            int r0 = this.elements.length;
            a r1 = new a(this.comparator);
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L6;
            r1.b(this.elements[r2], this.counts[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return r1.b();
        }
    }

    public static class a<E> extends ImmutableMultiset.a<E> {
        public a(Comparator<? super E> r3) {
            super(TreeMultiset.create((Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object r1) {
            return c(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Iterator r3) {
            return c((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object[] r1) {
            return c(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.a
        public /* synthetic */ ImmutableMultiset.a a(Object r1, int r2) {
            return b(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultiset.a
        public /* synthetic */ ImmutableMultiset a() {
            return b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.a
        public /* synthetic */ ImmutableMultiset.a b(Object r1) {
            return c(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.a
        public /* synthetic */ ImmutableMultiset.a b(Iterator r3) {
            return c((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.a
        public /* synthetic */ ImmutableMultiset.a b(Object[] r1) {
            return c(r1);
        }

        public a<E> b(E r1, int r2) {
            super.a(r1, r2);
            return this;
        }

        public ImmutableSortedMultiset<E> b() {
            return ImmutableSortedMultiset.copyOfSorted((az) ZeusTransformUtils.preCheckCast(this.f4463a, az.class, "com.obric.memorydata.plugin"));
        }

        public a<E> c(E r1) {
            super.b(r1);
            return this;
        }

        public a<E> c(Iterator<? extends E> r3) {
            super.b((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<E> c(E... r1) {
            super.b(r1);
            return this;
        }
    }

    ImmutableSortedMultiset() {
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), r3);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r3, Iterable<? extends E> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ImmutableSortedMultiset.class) == false) goto L12;
        ImmutableSortedMultiset<E> r0 = (ImmutableSortedMultiset) ZeusTransformUtils.preCheckCast(r6, ImmutableSortedMultiset.class, "com.obric.memorydata.plugin");
        if (r5.equals(r0.comparator()) == false) goto L12;
        if (r0.isPartialView() == false) goto L11;
        Collection r7 = r0.entrySet().asList();
    L10:
        return copyOfSortedEntries(r5, r7);
    L11:
        return r0;
    L12:
        ArrayList r8 = Lists.a(r6);
        TreeMultiset r1 = TreeMultiset.create((Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Comparator.class, "com.obric.memorydata.plugin"));
        aj.a(r1, r8);
        r7 = r1.entrySet();
        goto L10
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r2, Iterator<? extends E> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Iterator<? extends E> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return new a(r4).c(r5).b();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), r3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] r1) {
        return copyOf(Ordering.natural(), Arrays.asList(r1));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(az<E> r2) {
        az r3 = (az) ZeusTransformUtils.wrapperContextForParams(r2, az.class, "com.obric.memorydata.plugin");
        return copyOfSortedEntries(r3.comparator(), Lists.a(r3.entrySet()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> r10, Collection<an.a<E>> r11) {
        Comparator r12 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == true) goto L5;
        ImmutableList.a r0 = new ImmutableList.a(r13.size());
        long[] r2 = new long[r13.size() + 1];
        Iterator<E> r3 = r13.iterator();
        int r5 = 0;
    L8:
        if (r3.hasNext() == false) goto L11;
        an.a r6 = (an.a) ZeusTransformUtils.preCheckCast(r3.next(), an.a.class, "com.obric.memorydata.plugin");
        r0.b(r6.getElement());
        int r7 = r5 + 1;
        r2[r7] = r2[r5] + ((long) r6.getCount());
        r5 = r7;
        goto L8
    L11:
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(r0.a(), r12), r2, 0, r13.size());
    L5:
        return emptyMultiset(r12);
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (Ordering.natural().equals(r3) == false) goto L7;
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    L7:
        return new RegularImmutableSortedMultiset(r3);
    }

    static /* synthetic */ int lambda$toImmutableSortedMultiset$0(Object r0) {
        return 1;
    }

    static /* synthetic */ an lambda$toImmutableSortedMultiset$1(Comparator r2) {
        return TreeMultiset.create((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$toImmutableSortedMultiset$2(Function r2, ToIntFunction r3, an r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        ToIntFunction r7 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r3, ToIntFunction.class, "com.obric.memorydata.plugin");
        ((an) ZeusTransformUtils.wrapperContextForParams(r4, an.class, "com.obric.memorydata.plugin")).add(com.google.common.base.n.a(r6.apply(r5)), r7.applyAsInt(r5));
    }

    static /* synthetic */ an lambda$toImmutableSortedMultiset$3(an r2, an r3) {
        an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        r4.addAll((an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin"));
        return r4;
    }

    static /* synthetic */ ImmutableSortedMultiset lambda$toImmutableSortedMultiset$4(Comparator r2, an r3) {
        return copyOfSortedEntries((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), ((an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin")).entrySet());
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r4) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ZeusTransformUtils.preCheckCast(ImmutableSortedSet.of((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin")), RegularImmutableSortedSet.class, "com.obric.memorydata.plugin"), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r5, r6}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r6, r7, r8}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r7, r8, r9, r10}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6, Comparable r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r8, r9, r10, r11, r12}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8, Comparable... r9) {
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r13 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r14 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r15 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        ArrayList r0 = Lists.b(r9.length + 6);
        Collections.addAll(r0, new Comparable[]{r10, r11, r12, r13, r14, r15});
        Collections.addAll(r0, r9);
        return copyOf(Ordering.natural(), r0);
    }

    public static <E> a<E> orderedBy(Comparator<E> r2) {
        return new a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a(Ordering.natural().reverse());
    }

    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> r2) {
        return toImmutableSortedMultiset((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), Function.identity(), $$Lambda$ImmutableSortedMultiset$nT5AzLNkUKBACXbXKwIKbm6qg_w.INSTANCE);
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> r2, Function<? super T, ? extends E> r3, ToIntFunction<? super T> r4) {
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final ToIntFunction r7 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r4, ToIntFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(r7);
        return Collector.of(new $$Lambda$ImmutableSortedMultiset$FPSQY4H6WLVOYJTClwNNaEePCXs(r5), new $$Lambda$ImmutableSortedMultiset$B6j0YK6_sJTE74ZSp3GCwE2Zpy8(r6, r7), $$Lambda$ImmutableSortedMultiset$QRjedbHu0xwk70chYicSS8q_7I.INSTANCE, new $$Lambda$ImmutableSortedMultiset$UT2KQNWGy03aGrzafNUT6NflIck(r5), new Collector.Characteristics[0]);
    }

    @Override // com.google.common.collect.az, com.google.common.collect.ax
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> r0 = this.descendingMultiset;
        if (r0 == null) goto L5;
    L9:
        return r0;
    L5:
        if (isEmpty() == false) goto L7;
        r0 = emptyMultiset(Ordering.from(comparator()).reverse());
    L8:
        this.descendingMultiset = r0;
        goto L9
    L7:
        r0 = new DescendingImmutableSortedMultiset(this);
        goto L8
    }

    public /* bridge */ /* synthetic */ az descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public abstract ImmutableSortedSet<E> elementSet();

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    public abstract ImmutableSortedMultiset<E> headMultiset(E r1, BoundType r2);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ az headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    @Override // com.google.common.collect.az
    @Deprecated
    public final an.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.az
    @Deprecated
    public final an.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.az
    public ImmutableSortedMultiset<E> subMultiset(E r3, BoundType r4, E r5, BoundType r6) {
        if (comparator().compare(r3, r5) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "Expected lowerBound <= upperBound but %s > %s", r3, r5);
        return tailMultiset(r3, r4).headMultiset(r5, r6);
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.az
    public /* bridge */ /* synthetic */ az subMultiset(Object r1, BoundType r2, Object r3, BoundType r4) {
        return subMultiset(r1, r2, r3, r4);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E r1, BoundType r2);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ az tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
