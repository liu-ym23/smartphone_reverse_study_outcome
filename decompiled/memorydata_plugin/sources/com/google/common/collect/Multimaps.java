package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class Multimaps {

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.r<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> r3, com.google.common.base.r<? extends List<V>> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            com.google.common.base.r r6 = (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin");
            super(r5);
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.r.class, "com.obric.memorydata.plugin");
        }

        private void readObject(ObjectInputStream r4) {
            r4.defaultReadObject();
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(r4.readObject(), com.google.common.base.r.class, "com.obric.memorydata.plugin");
            setMap((Map) ZeusTransformUtils.preCheckCast(r4.readObject(), Map.class, "com.obric.memorydata.plugin"));
        }

        private void writeObject(ObjectOutputStream r2) {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return (List) ZeusTransformUtils.preCheckCast(this.factory.get(), List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }
    }

    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.r<? extends Collection<V>> factory;

        CustomMultimap(Map<K, Collection<V>> r3, com.google.common.base.r<? extends Collection<V>> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            com.google.common.base.r r6 = (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin");
            super(r5);
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.r.class, "com.obric.memorydata.plugin");
        }

        private void readObject(ObjectInputStream r4) {
            r4.defaultReadObject();
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(r4.readObject(), com.google.common.base.r.class, "com.obric.memorydata.plugin");
            setMap((Map) ZeusTransformUtils.preCheckCast(r4.readObject(), Map.class, "com.obric.memorydata.plugin"));
        }

        private void writeObject(ObjectOutputStream r2) {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return (Collection) ZeusTransformUtils.preCheckCast(this.factory.get(), Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, NavigableSet.class) == false) goto L7;
            return Sets.a((NavigableSet) ZeusTransformUtils.preCheckCast(r1, NavigableSet.class, "com.obric.memorydata.plugin"));
        L7:
            if (ZeusTransformUtils.instanceOf(r1, SortedSet.class) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) ZeusTransformUtils.preCheckCast(r1, SortedSet.class, "com.obric.memorydata.plugin"));
        L11:
            if (ZeusTransformUtils.instanceOf(r1, Set.class) == false) goto L15;
            return Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin"));
        L15:
            if (ZeusTransformUtils.instanceOf(r1, List.class) == false) goto L19;
            return Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
        L19:
            return Collections.unmodifiableCollection(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> wrapCollection(K r5, Collection<V> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, List.class) == false) goto L7;
            return wrapList(r5, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), null);
        L7:
            if (ZeusTransformUtils.instanceOf(r7, NavigableSet.class) == false) goto L11;
            return new AbstractMapBasedMultimap.k(this, r5, (NavigableSet) ZeusTransformUtils.preCheckCast(r7, NavigableSet.class, "com.obric.memorydata.plugin"), null);
        L11:
            if (ZeusTransformUtils.instanceOf(r7, SortedSet.class) == false) goto L15;
            return new AbstractMapBasedMultimap.m(this, r5, (SortedSet) ZeusTransformUtils.preCheckCast(r7, SortedSet.class, "com.obric.memorydata.plugin"), null);
        L15:
            if (ZeusTransformUtils.instanceOf(r7, Set.class) == false) goto L19;
            return new AbstractMapBasedMultimap.l(this, r5, (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin"));
        L19:
            return new AbstractMapBasedMultimap.i(this, r5, r7, null);
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.r<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> r3, com.google.common.base.r<? extends Set<V>> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            com.google.common.base.r r6 = (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin");
            super(r5);
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.r.class, "com.obric.memorydata.plugin");
        }

        private void readObject(ObjectInputStream r4) {
            r4.defaultReadObject();
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(r4.readObject(), com.google.common.base.r.class, "com.obric.memorydata.plugin");
            setMap((Map) ZeusTransformUtils.preCheckCast(r4.readObject(), Map.class, "com.obric.memorydata.plugin"));
        }

        private void writeObject(ObjectOutputStream r2) {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return (Set) ZeusTransformUtils.preCheckCast(this.factory.get(), Set.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, NavigableSet.class) == false) goto L7;
            return Sets.a((NavigableSet) ZeusTransformUtils.preCheckCast(r1, NavigableSet.class, "com.obric.memorydata.plugin"));
        L7:
            if (ZeusTransformUtils.instanceOf(r1, SortedSet.class) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) ZeusTransformUtils.preCheckCast(r1, SortedSet.class, "com.obric.memorydata.plugin"));
        L11:
            return Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> wrapCollection(K r5, Collection<V> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, NavigableSet.class) == false) goto L7;
            return new AbstractMapBasedMultimap.k(this, r5, (NavigableSet) ZeusTransformUtils.preCheckCast(r7, NavigableSet.class, "com.obric.memorydata.plugin"), null);
        L7:
            if (ZeusTransformUtils.instanceOf(r7, SortedSet.class) == false) goto L11;
            return new AbstractMapBasedMultimap.m(this, r5, (SortedSet) ZeusTransformUtils.preCheckCast(r7, SortedSet.class, "com.obric.memorydata.plugin"), null);
        L11:
            return new AbstractMapBasedMultimap.l(this, r5, (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.r<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;

        CustomSortedSetMultimap(Map<K, Collection<V>> r3, com.google.common.base.r<? extends SortedSet<V>> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            com.google.common.base.r r6 = (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin");
            super(r5);
            this.factory = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.r.class, "com.obric.memorydata.plugin");
            this.valueComparator = ((SortedSet) ZeusTransformUtils.preCheckCast(r6.get(), SortedSet.class, "com.obric.memorydata.plugin")).comparator();
        }

        private void readObject(ObjectInputStream r4) {
            r4.defaultReadObject();
            com.google.common.base.r<? extends SortedSet<V>> r0 = (com.google.common.base.r) ZeusTransformUtils.preCheckCast(r4.readObject(), com.google.common.base.r.class, "com.obric.memorydata.plugin");
            this.factory = r0;
            this.valueComparator = ((SortedSet) ZeusTransformUtils.preCheckCast(r0.get(), SortedSet.class, "com.obric.memorydata.plugin")).comparator();
            setMap((Map) ZeusTransformUtils.preCheckCast(r4.readObject(), Map.class, "com.obric.memorydata.plugin"));
        }

        private void writeObject(ObjectOutputStream r2) {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Set createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return (SortedSet) ZeusTransformUtils.preCheckCast(this.factory.get(), SortedSet.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.bc
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }
    }

    private static class MapMultimap<K, V> extends com.google.common.collect.c<K, V> implements aw<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        MapMultimap(Map<K, V> r3) {
            this.map = (Map) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.am
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean containsEntry(Object r1, Object r2) {
            return this.map.entrySet().contains(Maps.a(r1, r2));
        }

        @Override // com.google.common.collect.am
        public boolean containsKey(Object r1) {
            return this.map.containsKey(r1);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean containsValue(Object r1) {
            return this.map.containsValue(r1);
        }

        @Override // com.google.common.collect.c
        Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.c
        Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.c
        Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.c
        an<K> createKeys() {
            return new c(this);
        }

        @Override // com.google.common.collect.c
        Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.c
        Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> get(final K r2) {
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean put(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean putAll(am<? extends K, ? extends V> r2) {
            am r1 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean putAll(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am
        public boolean remove(Object r1, Object r2) {
            return this.map.entrySet().remove(Maps.a(r1, r2));
        }

        @Override // com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> removeAll(Object r3) {
            HashSet r0 = new HashSet(2);
            if (this.map.containsKey(r3) == true) goto L5;
            return r0;
        L5:
            r0.add(this.map.remove(r3));
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> replaceValues(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.am
        public int size() {
            return this.map.size();
        }
    }

    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ak<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableListMultimap(ak<K, V> r3) {
            super((ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public ak<K, V> delegate() {
            return (ak) ZeusTransformUtils.preCheckCast(super.delegate(), ak.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> get(K r1) {
            return Collections.unmodifiableList(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> removeAll(Object r1) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> replaceValues(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableMultimap<K, V> extends aa<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final am<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient an<K> keys;
        transient Map<K, Collection<V>> map;
        transient Collection<V> values;

        UnmodifiableMultimap(am<K, V> r3) {
            this.delegate = (am) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin")), am.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ Collection lambda$asMap$0(Collection r2) {
            return Multimaps.b((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> r0 = this.map;
            if (r0 != null) goto L6;
            Map<K, Collection<V>> r1 = Collections.unmodifiableMap(Maps.a(this.delegate.asMap(), $$Lambda$Multimaps$UnmodifiableMultimap$9QEIhfGMnkoW74MgqWGNBqGpjM.INSTANCE));
            this.map = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.ac
        public am<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> r0 = this.entries;
            if (r0 != null) goto L6;
            Collection<Map.Entry<K, V>> r1 = Multimaps.a(this.delegate.entries());
            this.entries = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.am
        public void forEach(BiConsumer<? super K, ? super V> r3) {
            BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            this.delegate.forEach((BiConsumer) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), BiConsumer.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Collection<V> get(K r1) {
            return Multimaps.b(this.delegate.get(r1));
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public Set<K> keySet() {
            Set<K> r0 = this.keySet;
            if (r0 != null) goto L6;
            Set<K> r1 = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public an<K> keys() {
            an<K> r0 = this.keys;
            if (r0 != null) goto L6;
            an<K> r1 = Multisets.a(this.delegate.keys());
            this.keys = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public boolean put(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public boolean putAll(am<? extends K, ? extends V> r2) {
            am r1 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public boolean putAll(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public boolean remove(Object r1, Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Collection<V> removeAll(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Collection<V> replaceValues(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.aa, com.google.common.collect.am
        public Collection<V> values() {
            Collection<V> r0 = this.values;
            if (r0 != null) goto L6;
            Collection<V> r1 = Collections.unmodifiableCollection(this.delegate.values());
            this.values = r1;
            return r1;
        L6:
            return r0;
        }
    }

    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements aw<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSetMultimap(aw<K, V> r3) {
            super((aw) ZeusTransformUtils.wrapperContextForParams(r3, aw.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public aw<K, V> delegate() {
            return (aw) ZeusTransformUtils.preCheckCast(super.delegate(), aw.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am
        public Set<Map.Entry<K, V>> entries() {
            return Maps.a(delegate().entries());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> get(K r1) {
            return Collections.unmodifiableSet(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> removeAll(Object r1) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> replaceValues(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements bc<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSortedSetMultimap(bc<K, V> r3) {
            super((bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ aw delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public bc<K, V> delegate() {
            return (bc) ZeusTransformUtils.preCheckCast(super.delegate(), bc.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Set get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> get(K r1) {
            return Collections.unmodifiableSortedSet(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> removeAll(Object r1) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Set replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.aa, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> replaceValues(K r1, Iterable<? extends V> r2) {
            Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.bc
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }
    }

    static final class a<K, V> extends Maps.m<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final am<K, V> f4568a;

        /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        class C0198a extends Maps.b<K, Collection<V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f4569a;

            C0198a(a r1) {
                this.f4569a = r1;
            }

            private /* synthetic */ Collection a(Object r1) {
                return a.a(this.f4569a).get(r1);
            }

            public static /* synthetic */ Collection lambda$N6YuOt99QeFxLbYp0tH1XKBIejQ(C0198a r0, Object r1) {
                return r0.a(r1);
            }

            @Override // com.google.common.collect.Maps.b
            Map<K, Collection<V>> a() {
                return this.f4569a;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.a(a.a(this.f4569a).keySet(), new $$Lambda$Multimaps$a$a$N6YuOt99QeFxLbYp0tH1XKBIejQ(this));
            }

            @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                if (contains(r3) == true) goto L6;
                return false;
            L6:
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin");
                this.f4569a.a(r4.getKey());
                return true;
            }
        }

        a(am<K, V> r3) {
            this.f4568a = (am) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin")), am.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ am a(a r0) {
            return r0.f4568a;
        }

        @Override // com.google.common.collect.Maps.m
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0198a(this);
        }

        void a(Object r1) {
            this.f4568a.keySet().remove(r1);
        }

        public Collection<V> b(Object r2) {
            if (containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.f4568a.get(r2);
        }

        public Collection<V> c(Object r2) {
            if (containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.f4568a.removeAll(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f4568a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.f4568a.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return b(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f4568a.isEmpty();
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f4568a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object remove(Object r1) {
            return c(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4568a.keySet().size();
        }
    }

    static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        b() {
        }

        abstract am<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L6;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return a().containsEntry(r4.getKey(), r4.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L6;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return a().remove(r4.getKey(), r4.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static class c<K, V> extends d<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final am<K, V> f4570a;

        c(am<K, V> r3) {
            this.f4570a = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        }

        private static /* synthetic */ void a(Consumer r2, Map.Entry r3) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey());
        }

        public static /* synthetic */ void lambda$kNAt84epykbMtyGLQOLvhv6r5mw(Consumer r0, Map.Entry r1) {
            a(r0, r1);
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4570a.clear();
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
        public boolean contains(Object r1) {
            return this.f4570a.containsKey(r1);
        }

        @Override // com.google.common.collect.an
        public int count(Object r2) {
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(Maps.a(this.f4570a.asMap(), r2), Collection.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.size();
        }

        @Override // com.google.common.collect.d
        int distinctElements() {
            return this.f4570a.asMap().size();
        }

        @Override // com.google.common.collect.d
        Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.d, com.google.common.collect.an
        public Set<K> elementSet() {
            return this.f4570a.keySet();
        }

        @Override // com.google.common.collect.d
        Iterator<an.a<K>> entryIterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r1 = this.f4570a.asMap().entrySet().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.lang.Iterable, com.google.common.collect.an
        public void forEach(Consumer<? super K> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.f4570a.entries().forEach(new $$Lambda$Multimaps$c$kNAt84epykbMtyGLQOLvhv6r5mw(r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
        public Iterator<K> iterator() {
            return Maps.a(this.f4570a.entries().iterator());
        }

        @Override // com.google.common.collect.d, com.google.common.collect.an
        public int remove(Object r2, int r3) {
            o.a(r3, "occurrences");
            if (r3 == 0) goto L5;
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(Maps.a(this.f4570a.asMap(), r2), Collection.class, "com.obric.memorydata.plugin");
            int r4 = 0;
            if (r1 != null) goto L9;
            return 0;
        L9:
            int r0 = r1.size();
            if (r3 < r0) goto L12;
            r1.clear();
        L15:
            return r0;
        L12:
            Iterator r5 = r1.iterator();
        L13:
            if (r4 >= r3) goto L15;
            r5.next();
            r5.remove();
            r4 = r4 + 1;
            goto L13
        L5:
            return count(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
        public int size() {
            return this.f4570a.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.an
        public Spliterator<K> spliterator() {
            return p.a(this.f4570a.entries().spliterator(), $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw.INSTANCE);
        }
    }

    public static <K, V> ak<K, V> a(Map<K, Collection<V>> r2, com.google.common.base.r<? extends List<V>> r3) {
        return new CustomListMultimap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.r.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Collection a(Collection r2) {
        return d((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    static boolean a(am<?, ?> r2, Object r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
        if (r3 != r4) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, am.class) == false) goto L10;
        am r5 = (am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.memorydata.plugin");
        return r4.asMap().equals(r5.asMap());
    L10:
        return false;
    }

    public static <K, V> aw<K, V> b(Map<K, Collection<V>> r2, com.google.common.base.r<? extends Set<V>> r3) {
        return new CustomSetMultimap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.r.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Collection b(Collection r2) {
        return c((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    private static <V> Collection<V> c(Collection<V> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SortedSet.class) == false) goto L7;
        return Collections.unmodifiableSortedSet((SortedSet) ZeusTransformUtils.preCheckCast(r3, SortedSet.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Set.class) == false) goto L11;
        return Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r3, List.class) == false) goto L15;
        return Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    L15:
        return Collections.unmodifiableCollection(r3);
    }

    private static <K, V> Collection<Map.Entry<K, V>> d(Collection<Map.Entry<K, V>> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Set.class) == false) goto L7;
        return Maps.a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
    L7:
        return new Maps.j(Collections.unmodifiableCollection(r3));
    }
}
