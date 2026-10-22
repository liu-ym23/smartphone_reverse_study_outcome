package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends j<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> r1) {
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
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public bj<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        Keys(ImmutableMultimap r1) {
            this.this$0 = r1;
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // com.google.common.collect.an
        public int count(Object r2) {
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(this.this$0.map.get(r2), Collection.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
        public ImmutableSet<K> elementSet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
        public /* bridge */ /* synthetic */ Set elementSet() {
            return elementSet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        an.a<K> getEntry(int r3) {
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.this$0.map.entrySet().asList().get(r3), Map.Entry.class, "com.obric.memorydata.plugin");
            return Multisets.a(r2.getKey(), ((Collection) ZeusTransformUtils.preCheckCast(r2.getValue(), Collection.class, "com.obric.memorydata.plugin")).size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new KeysSerializedForm(this.this$0);
        }
    }

    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> r1) {
            this.multimap = r1;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        Values(ImmutableMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.multimap.containsValue(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] r4, int r5) {
            bj<? extends ImmutableCollection<V>> r3 = this.multimap.map.values().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r5 = ((ImmutableCollection) ZeusTransformUtils.preCheckCast(r3.next(), ImmutableCollection.class, "com.obric.memorydata.plugin")).copyIntoArray(r4, r5);
            goto L4
        L6:
            return r5;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public bj<V> iterator() {
            return this.multimap.valueIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, Collection<V>> f4457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator<? super K> f4458b;
        Comparator<? super V> c;

        public a() {
            this.f4457a = ar.a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<K, V> b(a<K, V> r5) {
            Iterator<Map.Entry<K, Collection<V>>> r6 = r5.f4457a.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            b(r0.getKey(), (Iterable) ZeusTransformUtils.preCheckCast(r0.getValue(), Iterable.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public a<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> r4) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            b((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public a<K, V> b(K r4, Iterable<? extends V> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L20;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(this.f4457a.get(r4), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r6.iterator();
            if (r0 == null) goto L11;
        L7:
            if (r7.hasNext() == false) goto L9;
            Object r1 = r7.next();
            o.a(r4, r1);
            r0.add(r1);
            goto L7
        L9:
            return this;
        L11:
            if (r7.hasNext() == true) goto L13;
            return this;
        L13:
            Collection<V> r2 = c();
        L15:
            if (r7.hasNext() == false) goto L17;
            Object r3 = r7.next();
            o.a(r4, r3);
            r2.add(r3);
            goto L15
        L17:
            this.f4457a.put(r4, r2);
            return this;
        L20:
            throw new NullPointerException("null key in entry: null=" + aj.a(r6));
        }

        public a<K, V> b(K r4, V r5) {
            o.a(r4, r5);
            Collection<V> r0 = (Collection) ZeusTransformUtils.preCheckCast(this.f4457a.get(r4), Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            Map<K, Collection<V>> r1 = this.f4457a;
            Collection<V> r2 = c();
            r1.put(r4, r2);
            r0 = r2;
        L5:
            r0.add(r5);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a<K, V> b(Map.Entry<? extends K, ? extends V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return b(r4.getKey(), r4.getValue());
        }

        public ImmutableMultimap<K, V> b() {
            Collection r0 = this.f4457a.entrySet();
            Comparator<? super K> r1 = this.f4458b;
            if (r1 == null) goto L6;
            r0 = Ordering.from(r1).onKeys().immutableSortedCopy(r0);
        L6:
            return ImmutableListMultimap.fromMapEntries(r0, this.c);
        }

        Collection<V> c() {
            return new ArrayList();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final av.a<ImmutableMultimap> f4459a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final av.a<ImmutableMultimap> f4460b = null;

        static {
            f4459a = av.a(ImmutableMultimap.class, "map");
            f4460b = av.a(ImmutableMultimap.class, "size");
        }
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r1, int r2) {
        this.map = r1;
        this.size = r2;
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(am<? extends K, ? extends V> r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableMultimap.class) == false) goto L8;
        ImmutableMultimap<K, V> r0 = (ImmutableMultimap) ZeusTransformUtils.preCheckCast(r4, ImmutableMultimap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        return ImmutableListMultimap.copyOf(r4);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        return ImmutableListMultimap.copyOf((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Map.Entry lambda$entrySpliterator$0(Object r0, Object r1) {
        return Maps.a(r0, r1);
    }

    static /* synthetic */ Spliterator lambda$entrySpliterator$1(Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        final Object r0 = r4.getKey();
        return p.a(((Collection) ZeusTransformUtils.preCheckCast(r4.getValue(), Collection.class, "com.obric.memorydata.plugin")).spliterator(), new $$Lambda$ImmutableMultimap$rufzp9pzkqKcNkPAKI3lHrhrWU(r0));
    }

    static /* synthetic */ void lambda$forEach$2(BiConsumer r2, Object r3, Object r4) {
        ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r3, r4);
    }

    static /* synthetic */ void lambda$forEach$3(BiConsumer r2, final Object r3, Collection r4) {
        final BiConsumer r5 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin")).forEach(new $$Lambda$ImmutableMultimap$YwNVRf37fa43ez6DZFyPOpRAkxc(r5, r3));
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1) {
        return ImmutableListMultimap.of(r0, r1);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3) {
        return ImmutableListMultimap.of(r0, r1, r2, r3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.am
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r1, Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.am
    public boolean containsKey(Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean containsValue(Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.c
    ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ an createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.c
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) ZeusTransformUtils.preCheckCast(super.entries(), ImmutableCollection.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.c
    bj<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.c
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p.a(asMap().entrySet().spliterator(), $$Lambda$ImmutableMultimap$FfPiE5qdBmwriOTbl6JPVWe0BHc.INSTANCE, (ZeusTransformUtils.instanceOf(this, aw.class) ? 1 : 0) | 64, size());
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.am
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        asMap().forEach(new $$Lambda$ImmutableMultimap$IPaBBAWTpokbP3tTS250ZD4QGs(r4));
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public abstract ImmutableCollection<V> get(K r1);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) ZeusTransformUtils.preCheckCast(super.keys(), ImmutableMultiset.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ an keys() {
        return keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    @Deprecated
    public final boolean put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    @Deprecated
    public final boolean putAll(am<? extends K, ? extends V> r2) {
        am r1 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    @Deprecated
    public final boolean putAll(K r1, Iterable<? extends V> r2) {
        Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    @Deprecated
    public final boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public ImmutableCollection<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public ImmutableCollection<V> replaceValues(K r1, Iterable<? extends V> r2) {
        Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.am
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c
    bj<V> valueIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) ZeusTransformUtils.preCheckCast(super.values(), ImmutableCollection.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
