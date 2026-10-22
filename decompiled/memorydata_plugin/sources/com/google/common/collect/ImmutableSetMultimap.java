package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements aw<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L6;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return this.multimap.containsEntry(r4.getKey(), r4.getValue());
        L6:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public bj<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }
    }

    public static final class a<K, V> extends ImmutableMultimap.a<K, V> {
        public a() {
        }

        a<K, V> a(ImmutableMultimap.a<K, V> r1) {
            super.b(r1);
            return this;
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
            super.b((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(K r3, Iterable<? extends V> r4) {
            super.b(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(K r1, V r2) {
            super.b(r1, r2);
            return this;
        }

        public a<K, V> a(Map.Entry<? extends K, ? extends V> r3) {
            super.b((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public ImmutableSetMultimap<K, V> a() {
            Collection r0 = this.f4457a.entrySet();
            if (this.f4458b == null) goto L6;
            r0 = Ordering.from(this.f4458b).onKeys().immutableSortedCopy(r0);
        L6:
            return ImmutableSetMultimap.fromMapEntries(r0, this.c);
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        /* synthetic */ ImmutableMultimap.a b(ImmutableMultimap.a r1) {
            return a(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Iterable r3) {
            return a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Object r3, Iterable r4) {
            return a(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Map.Entry r3) {
            return a((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap b() {
            return a();
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        Collection<V> c() {
            return ar.b();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final av.a<ImmutableSetMultimap> f4474a = null;

        static {
            f4474a = av.a(ImmutableSetMultimap.class, "emptySet");
        }
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r3, int r4, Comparator<? super V> r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.emptySet = emptySet(r6);
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(am<? extends K, ? extends V> r2) {
        return copyOf((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin"), null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(am<? extends K, ? extends V> r3, Comparator<? super V> r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        if (r5.isEmpty() == false) goto L8;
        if (r6 != null) goto L8;
        return of();
    L8:
        if (ZeusTransformUtils.instanceOf(r5, ImmutableSetMultimap.class) == false) goto L13;
        ImmutableSetMultimap<K, V> r0 = (ImmutableSetMultimap) ZeusTransformUtils.preCheckCast(r5, ImmutableSetMultimap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        return fromMapEntries(r5.asMap().entrySet(), r6);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        Iterable<? extends Map.Entry<? extends K, ? extends V>> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return new a().a(r3).a();
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return ImmutableSet.of();
    L6:
        return ImmutableSortedSet.emptySet(r3);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends Stream<? extends V>> r3) {
        return n.g((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r6, Comparator<? super V> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Comparator r9 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r7, Comparator.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L5;
        ImmutableMap.a r0 = new ImmutableMap.a(r8.size());
        int r2 = 0;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r4 = r3.getKey();
        ImmutableSet r5 = valueSet(r9, (Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin"));
        if (r5.isEmpty() == true) goto L8;
        r0.b(r4, r5);
        r2 = r2 + r5.size();
        goto L8
    L13:
        return new ImmutableSetMultimap(r0.e(), r2, r9);
    L5:
        return of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a r0 = builder();
        bj r1 = entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a(r2.getValue(), r2.getKey());
        goto L4
    L6:
        ImmutableSetMultimap<V, K> r3 = r0.a();
        r3.inverse = this;
        return r3;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2) {
        a r0 = builder();
        r0.a(r1, r2);
        return r0.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        return r0.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        return r0.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        r0.a(r7, r8);
        return r0.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        r0.a(r7, r8);
        r0.a(r9, r10);
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r13) {
        r13.defaultReadObject();
        Comparator r0 = (Comparator) ZeusTransformUtils.preCheckCast(r13.readObject(), Comparator.class, "com.obric.memorydata.plugin");
        int r1 = r13.readInt();
        if (r1 < 0) goto L25;
        ImmutableMap.a r3 = ImmutableMap.builder();
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r5 >= r1) goto L26;
        Object r7 = r13.readObject();
        int r8 = r13.readInt();
        if (r8 <= 0) goto L17;
        ImmutableSet.a r9 = valuesBuilder(r0);
        int r10 = 0;
    L9:
        if (r10 >= r8) goto L11;
        r9.b(r13.readObject());
        r10 = r10 + 1;
        goto L9
    L11:
        ImmutableSet r11 = r9.c();
        if (r11.size() != r8) goto L15;
        r3.b(r7, r11);
        r6 = r6 + r8;
        r5 = r5 + 1;
        goto L5
    L15:
        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + r7);
    L17:
        throw new InvalidObjectException("Invalid value count " + r8);
    L26:
        ImmutableMultimap.b.f4459a.a(this, r3.e());
        ImmutableMultimap.b.f4460b.a(this, r6);
        b.f4474a.a(this, emptySet(r0));
        return;
    L21:
        e = move-exception;
        throw ((InvalidObjectException) ZeusTransformUtils.preCheckCast(new InvalidObjectException(e.getMessage()).initCause(e), InvalidObjectException.class, "com.obric.memorydata.plugin"));
    L25:
        throw new InvalidObjectException("Invalid key count " + r1);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        return n.f((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> r2, Collection<? extends V> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return ImmutableSet.copyOf(r5);
    L6:
        return ImmutableSortedSet.copyOf(r4, r5);
    }

    private static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return new ImmutableSet.a();
    L6:
        return new ImmutableSortedSet.a(r3);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(valueComparator());
        av.a(this, r2);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entries;
        if (r0 != null) goto L6;
        EntrySet r1 = new EntrySet(this);
        this.entries = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public ImmutableSet<V> get(K r3) {
        return (ImmutableSet) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a((ImmutableSet) ZeusTransformUtils.preCheckCast(this.map.get(r3), ImmutableSet.class, "com.obric.memorydata.plugin"), this.emptySet), ImmutableSet.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Set get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        ImmutableSetMultimap<V, K> r1 = invert();
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public final ImmutableSet<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ ImmutableCollection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public final ImmutableSet<V> replaceValues(K r1, Iterable<? extends V> r2) {
        Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ Set replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    Comparator<? super V> valueComparator() {
        if (ZeusTransformUtils.instanceOf(this.emptySet, ImmutableSortedSet.class) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) ZeusTransformUtils.preCheckCast(this.emptySet, ImmutableSortedSet.class, "com.obric.memorydata.plugin")).comparator();
    }
}
