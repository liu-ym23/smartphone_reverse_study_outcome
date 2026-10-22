package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    private class a extends Maps.m<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final transient Map<K, Collection<V>> f4370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractMapBasedMultimap f4371b;

        /* JADX INFO: renamed from: com.google.common.collect.AbstractMapBasedMultimap$a$a, reason: collision with other inner class name */
        class C0194a extends Maps.b<K, Collection<V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f4372a;

            C0194a(a r1) {
                this.f4372a = r1;
            }

            @Override // com.google.common.collect.Maps.b
            Map<K, Collection<V>> a() {
                return this.f4372a;
            }

            @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r1) {
                return q.a(this.f4372a.f4370a.entrySet(), r1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b(this.f4372a);
            }

            @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                if (contains(r3) == true) goto L6;
                return false;
            L6:
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin");
                AbstractMapBasedMultimap.access$300(this.f4372a.f4371b, r4.getKey());
                return true;
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, Collection<V>>> spliterator() {
                Spliterator<Map.Entry<K, Collection<V>>> r0 = this.f4372a.f4370a.entrySet().spliterator();
                final a r2 = this.f4372a;
                return p.a(r0, new $$Lambda$sboVTwHJiEmy6C45CllZuZtrDDQ(r2));
            }
        }

        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f4373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection<V> f4374b;
            final /* synthetic */ a c;

            b(a r1) {
                this.c = r1;
                this.f4373a = r1.f4370a.entrySet().iterator();
            }

            public Map.Entry<K, Collection<V>> a() {
                Map.Entry<K, Collection<V>> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4373a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
                this.f4374b = (Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin");
                return this.c.a(r0);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4373a.hasNext();
            }

            @Override // java.util.Iterator
            public /* synthetic */ Object next() {
                return a();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.f4374b == null) goto L5;
                boolean r0 = true;
            L6:
                com.google.common.base.n.b(r0, "no calls to next() since the last call to remove()");
                this.f4373a.remove();
                AbstractMapBasedMultimap.access$220(this.c.f4371b, this.f4374b.size());
                this.f4374b.clear();
                this.f4374b = null;
                return;
            L5:
                r0 = false;
                goto L6
            }
        }

        a(AbstractMapBasedMultimap r3, Map<K, Collection<V>> r4) {
            Map<K, Collection<V>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.f4371b = r3;
            this.f4370a = r5;
        }

        public Collection<V> a(Object r4) {
            Collection<V> r0 = (Collection) ZeusTransformUtils.preCheckCast(Maps.a(this.f4370a, r4), Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L7;
            return null;
        L7:
            return this.f4371b.wrapCollection(r4, r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            return Maps.a(r0, this.f4371b.wrapCollection(r0, (Collection) ZeusTransformUtils.preCheckCast(r5.getValue(), Collection.class, "com.obric.memorydata.plugin")));
        }

        @Override // com.google.common.collect.Maps.m
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0194a(this);
        }

        public Collection<V> b(Object r3) {
            Collection<? extends V> r4 = (Collection) ZeusTransformUtils.preCheckCast(this.f4370a.remove(r3), Collection.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            Collection<V> r0 = this.f4371b.createCollection();
            r0.addAll(r4);
            AbstractMapBasedMultimap.access$220(this.f4371b, r4.size());
            r4.clear();
            return r0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f4370a != AbstractMapBasedMultimap.access$000(this.f4371b)) goto L5;
            this.f4371b.clear();
            return;
        L5:
            Iterators.h(new b(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return Maps.b(this.f4370a, r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
        L7:
            return true;
        L4:
            if (this.f4370a.equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f4370a.hashCode();
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f4371b.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object remove(Object r1) {
            return b(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4370a.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f4370a.toString();
        }
    }

    private abstract class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f4375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f4376b;
        Collection<V> c;
        Iterator<V> d;
        final /* synthetic */ AbstractMapBasedMultimap e;

        b(AbstractMapBasedMultimap r1) {
            this.e = r1;
            this.f4375a = AbstractMapBasedMultimap.access$000(r1).entrySet().iterator();
            this.f4376b = null;
            this.c = null;
            this.d = Iterators.c();
        }

        abstract T a(K r1, V r2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4375a.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.d.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.d.hasNext() == true) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4375a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.f4376b = (K) r0.getKey();
            Collection<V> r1 = (Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin");
            this.c = r1;
            this.d = r1.iterator();
        L6:
            return a(ao.a(this.f4376b), this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            if (((Collection) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.c), Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L5;
            this.f4375a.remove();
        L5:
            AbstractMapBasedMultimap.access$210(this.e);
        }
    }

    private class c extends Maps.e<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractMapBasedMultimap f4377a;

        c(AbstractMapBasedMultimap r3, Map<K, Collection<V>> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.f4377a = r3;
            super(r5);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.h(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return c().keySet().containsAll(r4);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
        L7:
            return true;
        L4:
            if (c().keySet().equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return c().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r0 = c().entrySet().iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(c().remove(r3), Collection.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            int r1 = r4.size();
            r4.clear();
            AbstractMapBasedMultimap.access$220(this.f4377a, r1);
        L6:
            if (r1 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return c().keySet().spliterator();
        }
    }

    class d extends AbstractMapBasedMultimap<K, V>.g implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap c;

        d(AbstractMapBasedMultimap r3, NavigableMap<K, Collection<V>> r4) {
            NavigableMap r5 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r4, NavigableMap.class, "com.obric.memorydata.plugin");
            this.c = r3;
            super(r3, r5);
        }

        Map.Entry<K, Collection<V>> a(Iterator<Map.Entry<K, Collection<V>>> r6) {
            Iterator r7 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r6, Iterator.class, "com.obric.memorydata.plugin");
            if (r7.hasNext() == true) goto L6;
            return null;
        L6:
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Collection<V> r2 = this.c.createCollection();
            r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin"));
            r7.remove();
            return Maps.a(r0.getKey(), this.c.unmodifiableCollectionSubclass(r2));
        }

        public NavigableMap<K, Collection<V>> a(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) ZeusTransformUtils.preCheckCast(super.g(), NavigableMap.class, "com.obric.memorydata.plugin");
        }

        public NavigableMap<K, Collection<V>> c(K r2) {
            return headMap(r2, false);
        }

        public NavigableSet<K> c() {
            return (NavigableSet) ZeusTransformUtils.preCheckCast(super.f(), NavigableSet.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K r2) {
            Map.Entry<K, Collection<V>> r3 = b().ceilingEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return a(r3);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return b().ceilingKey(r1);
        }

        public NavigableMap<K, Collection<V>> d(K r2) {
            return tailMap(r2, true);
        }

        NavigableSet<K> d() {
            return new e(this.c, b());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(this.c, b().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g
        /* synthetic */ SortedSet e() {
            return d();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g
        public /* synthetic */ SortedSet f() {
            return c();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> r0 = b().firstEntry();
            if (r0 != null) goto L6;
            return null;
        L6:
            return a(r0);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K r2) {
            Map.Entry<K, Collection<V>> r3 = b().floorEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return a(r3);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return b().floorKey(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g
        /* synthetic */ SortedMap g() {
            return b();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, com.google.common.collect.Maps.m
        /* synthetic */ Set h() {
            return d();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K r3, boolean r4) {
            return new d(this.c, b().headMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public /* synthetic */ SortedMap headMap(Object r1) {
            return c(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K r2) {
            Map.Entry<K, Collection<V>> r3 = b().higherEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return a(r3);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return b().higherKey(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, com.google.common.collect.AbstractMapBasedMultimap.a, com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Set keySet() {
            return c();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> r0 = b().lastEntry();
            if (r0 != null) goto L6;
            return null;
        L6:
            return a(r0);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K r2) {
            Map.Entry<K, Collection<V>> r3 = b().lowerEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return a(r3);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return b().lowerKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return c();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return a(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K r3, boolean r4, K r5, boolean r6) {
            return new d(this.c, b().subMap(r3, r4, r5, r6));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public /* synthetic */ SortedMap subMap(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K r3, boolean r4) {
            return new d(this.c, b().tailMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.SortedMap, java.util.NavigableMap
        public /* synthetic */ SortedMap tailMap(Object r1) {
            return d(r1);
        }
    }

    class e extends AbstractMapBasedMultimap<K, V>.h implements NavigableSet<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractMapBasedMultimap f4380b;

        e(AbstractMapBasedMultimap r3, NavigableMap<K, Collection<V>> r4) {
            NavigableMap r5 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r4, NavigableMap.class, "com.obric.memorydata.plugin");
            this.f4380b = r3;
            super(r3, r5);
        }

        NavigableMap<K, Collection<V>> a() {
            return (NavigableMap) ZeusTransformUtils.preCheckCast(super.b(), NavigableMap.class, "com.obric.memorydata.plugin");
        }

        public NavigableSet<K> a(K r2) {
            return headSet(r2, false);
        }

        public NavigableSet<K> a(K r3, K r4) {
            return subSet(r3, true, r4, false);
        }

        public NavigableSet<K> b(K r2) {
            return tailSet(r2, true);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h
        /* synthetic */ SortedMap b() {
            return a();
        }

        @Override // java.util.NavigableSet
        public K ceiling(K r1) {
            return a().ceilingKey(r1);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new e(this.f4380b, a().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K r1) {
            return a().floorKey(r1);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K r3, boolean r4) {
            return new e(this.f4380b, a().headMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public /* synthetic */ SortedSet headSet(Object r1) {
            return a(r1);
        }

        @Override // java.util.NavigableSet
        public K higher(K r1) {
            return a().higherKey(r1);
        }

        @Override // java.util.NavigableSet
        public K lower(K r1) {
            return a().lowerKey(r1);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.g(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.g(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K r3, boolean r4, K r5, boolean r6) {
            return new e(this.f4380b, a().subMap(r3, r4, r5, r6));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public /* synthetic */ SortedSet subSet(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K r3, boolean r4) {
            return new e(this.f4380b, a().tailMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedSet, java.util.NavigableSet
        public /* synthetic */ SortedSet tailSet(Object r1) {
            return b(r1);
        }
    }

    private class f extends AbstractMapBasedMultimap<K, V>.j implements RandomAccess {
        f(AbstractMapBasedMultimap r3, K r4, List<V> r5, AbstractMapBasedMultimap<K, V>.i r6) {
            super(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), r6);
        }
    }

    private class g extends AbstractMapBasedMultimap<K, V>.a implements SortedMap<K, Collection<V>> {
        SortedSet<K> d;
        final /* synthetic */ AbstractMapBasedMultimap e;

        g(AbstractMapBasedMultimap r3, SortedMap<K, Collection<V>> r4) {
            SortedMap r5 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r4, SortedMap.class, "com.obric.memorydata.plugin");
            this.e = r3;
            super(r3, r5);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return g().comparator();
        }

        SortedSet<K> e() {
            return new h(this.e, g());
        }

        public SortedSet<K> f() {
            SortedSet<K> r0 = this.d;
            if (r0 != null) goto L6;
            SortedSet<K> r1 = e();
            this.d = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return g().firstKey();
        }

        SortedMap<K, Collection<V>> g() {
            return (SortedMap) ZeusTransformUtils.preCheckCast(this.f4370a, SortedMap.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Maps.m
        /* synthetic */ Set h() {
            return e();
        }

        public SortedMap<K, Collection<V>> headMap(K r3) {
            return new g(this.e, g().headMap(r3));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.a, com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Set keySet() {
            return f();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return g().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K r3, K r4) {
            return new g(this.e, g().subMap(r3, r4));
        }

        public SortedMap<K, Collection<V>> tailMap(K r3) {
            return new g(this.e, g().tailMap(r3));
        }
    }

    private class h extends AbstractMapBasedMultimap<K, V>.c implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap c;

        h(AbstractMapBasedMultimap r3, SortedMap<K, Collection<V>> r4) {
            SortedMap r5 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r4, SortedMap.class, "com.obric.memorydata.plugin");
            this.c = r3;
            super(r3, r5);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) ZeusTransformUtils.preCheckCast(super.c(), SortedMap.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K r3) {
            return new h(this.c, b().headMap(r3));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K r3, K r4) {
            return new h(this.c, b().subMap(r3, r4));
        }

        public SortedSet<K> tailSet(K r3) {
            return new h(this.c, b().tailMap(r3));
        }
    }

    class i extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection<V> f4382b;
        final AbstractMapBasedMultimap<K, V>.i c;
        final Collection<V> d;
        final /* synthetic */ AbstractMapBasedMultimap e;

        class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<V> f4383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection<V> f4384b;
            final /* synthetic */ i c;

            a(i r2) {
                this.c = r2;
                this.f4384b = r2.f4382b;
                this.f4383a = AbstractMapBasedMultimap.access$100(r2.f4382b);
            }

            a(i r3, Iterator<V> r4) {
                Iterator<V> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
                this.c = r3;
                this.f4384b = r3.f4382b;
                this.f4383a = r5;
            }

            void a() {
                this.c.a();
                if (this.c.f4382b != this.f4384b) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            Iterator<V> b() {
                a();
                return this.f4383a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f4383a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.f4383a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f4383a.remove();
                AbstractMapBasedMultimap.access$210(this.c.e);
                this.c.b();
            }
        }

        i(AbstractMapBasedMultimap r3, K r4, Collection<V> r5, AbstractMapBasedMultimap<K, V>.i r6) {
            Collection<V> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            this.e = r3;
            this.f4381a = r4;
            this.f4382b = r7;
            this.c = r6;
            if (r6 != null) goto L5;
            Collection<V> r8 = null;
        L6:
            this.d = r8;
            return;
        L5:
            r8 = r6.e();
            goto L6
        }

        void a() {
            AbstractMapBasedMultimap<K, V>.i r0 = this.c;
            if (r0 == null) goto L10;
            r0.a();
            if (this.c.e() != this.d) goto L8;
            return;
        L8:
            throw new ConcurrentModificationException();
        L10:
            if (this.f4382b.isEmpty() == false) goto L15;
            Collection<V> r1 = (Collection) ZeusTransformUtils.preCheckCast(AbstractMapBasedMultimap.access$000(this.e).get(this.f4381a), Collection.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L16;
            this.f4382b = r1;
            return;
        L16:
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V r3) {
            a();
            boolean r0 = this.f4382b.isEmpty();
            boolean r4 = this.f4382b.add(r3);
            if (r4 == false) goto L7;
            AbstractMapBasedMultimap.access$208(this.e);
            if (r0 == false) goto L7;
            d();
        L7:
            return r4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r4) {
            Collection<? extends V> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            if (r5.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r6 = this.f4382b.addAll(r5);
            if (r6 == false) goto L11;
            int r1 = this.f4382b.size();
            AbstractMapBasedMultimap.access$212(this.e, r1 - r0);
            if (r0 != 0) goto L11;
            d();
        L11:
            return r6;
        }

        void b() {
            AbstractMapBasedMultimap<K, V>.i r0 = this.c;
            if (r0 == null) goto L6;
            r0.b();
            return;
        L6:
            if (this.f4382b.isEmpty() == false) goto L10;
            AbstractMapBasedMultimap.access$000(this.e).remove(this.f4381a);
            return;
        }

        K c() {
            return this.f4381a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int r0 = size();
            if (r0 != 0) goto L5;
            return;
        L5:
            this.f4382b.clear();
            AbstractMapBasedMultimap.access$220(this.e, r0);
            b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            a();
            return this.f4382b.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            a();
            return this.f4382b.containsAll(r4);
        }

        void d() {
            AbstractMapBasedMultimap<K, V>.i r0 = this.c;
            if (r0 == null) goto L5;
            r0.d();
            return;
        L5:
            AbstractMapBasedMultimap.access$000(this.e).put(this.f4381a, this.f4382b);
        }

        Collection<V> e() {
            return this.f4382b;
        }

        @Override // java.util.Collection
        public boolean equals(Object r1) {
            if (r1 != this) goto L5;
            return true;
        L5:
            a();
            return this.f4382b.equals(r1);
        }

        AbstractMapBasedMultimap<K, V>.i f() {
            return this.c;
        }

        @Override // java.util.Collection
        public int hashCode() {
            a();
            return this.f4382b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            a();
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            a();
            boolean r3 = this.f4382b.remove(r2);
            if (r3 == false) goto L5;
            AbstractMapBasedMultimap.access$210(this.e);
            b();
        L5:
            return r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r4) {
            Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            if (r5.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r6 = this.f4382b.removeAll(r5);
            if (r6 == false) goto L9;
            int r1 = this.f4382b.size();
            AbstractMapBasedMultimap.access$212(this.e, r1 - r0);
            b();
        L9:
            return r6;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r4) {
            Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r5);
            int r0 = size();
            boolean r6 = this.f4382b.retainAll(r5);
            if (r6 == false) goto L5;
            int r1 = this.f4382b.size();
            AbstractMapBasedMultimap.access$212(this.e, r1 - r0);
            b();
        L5:
            return r6;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            a();
            return this.f4382b.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            a();
            return this.f4382b.spliterator();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            a();
            return this.f4382b.toString();
        }
    }

    class j extends AbstractMapBasedMultimap<K, V>.i implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap f;

        private class a extends AbstractMapBasedMultimap<K, V>.i.a implements ListIterator<V> {
            final /* synthetic */ j d;

            a(j r1) {
                this.d = r1;
                super(r1);
            }

            public a(j r2, int r3) {
                this.d = r2;
                super(r2, r2.g().listIterator(r3));
            }

            private ListIterator<V> c() {
                return (ListIterator) ZeusTransformUtils.preCheckCast(b(), ListIterator.class, "com.obric.memorydata.plugin");
            }

            @Override // java.util.ListIterator
            public void add(V r3) {
                boolean r0 = this.d.isEmpty();
                c().add(r3);
                AbstractMapBasedMultimap.access$208(this.d.f);
                if (r0 == false) goto L6;
                this.d.d();
                return;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V r1) {
                c().set(r1);
            }
        }

        j(AbstractMapBasedMultimap r3, K r4, List<V> r5, AbstractMapBasedMultimap<K, V>.i r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.f = r3;
            super(r3, r4, r7, r6);
        }

        @Override // java.util.List
        public void add(int r3, V r4) {
            a();
            boolean r0 = e().isEmpty();
            g().add(r3, r4);
            AbstractMapBasedMultimap.access$208(this.f);
            if (r0 == false) goto L6;
            d();
            return;
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends V> r4) {
            Collection<? extends V> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            if (r5.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r6 = g().addAll(r3, r5);
            if (r6 == false) goto L11;
            int r7 = e().size();
            AbstractMapBasedMultimap.access$212(this.f, r7 - r0);
            if (r0 != 0) goto L11;
            d();
        L11:
            return r6;
        }

        List<V> g() {
            return (List) ZeusTransformUtils.preCheckCast(e(), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public V get(int r1) {
            a();
            return g().get(r1);
        }

        @Override // java.util.List
        public int indexOf(Object r1) {
            a();
            return g().indexOf(r1);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r1) {
            a();
            return g().lastIndexOf(r1);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            a();
            return new a(this);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int r2) {
            a();
            return new a(this, r2);
        }

        @Override // java.util.List
        public V remove(int r2) {
            a();
            V r3 = g().remove(r2);
            AbstractMapBasedMultimap.access$210(this.f);
            b();
            return r3;
        }

        @Override // java.util.List
        public V set(int r1, V r2) {
            a();
            return g().set(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMapBasedMultimap] */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.google.common.collect.AbstractMapBasedMultimap$i] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        public List<V> subList(int r4, int r5) {
            a();
            ?? r0 = this.f;
            Object r1 = c();
            List<V> r6 = g().subList(r4, r5);
            AbstractMapBasedMultimap<K, V>.i r7 = f();
            ?? r3 = this;
            if (r7 == null) goto L7;
            r3 = f();
        L7:
            return r0.wrapList(r1, r6, r3);
        }
    }

    class k extends AbstractMapBasedMultimap<K, V>.m implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f;

        k(AbstractMapBasedMultimap r3, K r4, NavigableSet<V> r5, AbstractMapBasedMultimap<K, V>.i r6) {
            NavigableSet r7 = (NavigableSet) ZeusTransformUtils.wrapperContextForParams(r5, NavigableSet.class, "com.obric.memorydata.plugin");
            this.f = r3;
            super(r3, r4, r7, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$i] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        private NavigableSet<V> a(NavigableSet<V> r5) {
            NavigableSet r6 = (NavigableSet) ZeusTransformUtils.wrapperContextForParams(r5, NavigableSet.class, "com.obric.memorydata.plugin");
            AbstractMapBasedMultimap r1 = this.f;
            K r2 = this.f4381a;
            AbstractMapBasedMultimap<K, V>.i r3 = f();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = f();
        L7:
            return new k(r1, r2, r6, r4);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V r1) {
            return g().ceiling(r1);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new i.a(this, g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return a(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V r1) {
            return g().floor(r1);
        }

        NavigableSet<V> g() {
            return (NavigableSet) ZeusTransformUtils.preCheckCast(super.h(), NavigableSet.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.m
        /* synthetic */ SortedSet h() {
            return g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V r2, boolean r3) {
            return a(g().headSet(r2, r3));
        }

        @Override // java.util.NavigableSet
        public V higher(V r1) {
            return g().higher(r1);
        }

        @Override // java.util.NavigableSet
        public V lower(V r1) {
            return g().lower(r1);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.g(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.g(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V r2, boolean r3, V r4, boolean r5) {
            return a(g().subSet(r2, r3, r4, r5));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V r2, boolean r3) {
            return a(g().tailSet(r2, r3));
        }
    }

    class l extends AbstractMapBasedMultimap<K, V>.i implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap f;

        l(AbstractMapBasedMultimap r3, K r4, Set<V> r5) {
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            this.f = r3;
            super(r3, r4, r6, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            if (r6.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r7 = Sets.a((Set) ZeusTransformUtils.preCheckCast(this.f4382b, Set.class, "com.obric.memorydata.plugin"), r6);
            if (r7 == false) goto L9;
            int r1 = this.f4382b.size();
            AbstractMapBasedMultimap.access$212(this.f, r1 - r0);
            b();
        L9:
            return r7;
        }
    }

    class m extends AbstractMapBasedMultimap<K, V>.i implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap g;

        m(AbstractMapBasedMultimap r3, K r4, SortedSet<V> r5, AbstractMapBasedMultimap<K, V>.i r6) {
            SortedSet r7 = (SortedSet) ZeusTransformUtils.wrapperContextForParams(r5, SortedSet.class, "com.obric.memorydata.plugin");
            this.g = r3;
            super(r3, r4, r7, r6);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            a();
            return h().first();
        }

        SortedSet<V> h() {
            return (SortedSet) ZeusTransformUtils.preCheckCast(e(), SortedSet.class, "com.obric.memorydata.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$i] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V r5) {
            a();
            AbstractMapBasedMultimap r1 = this.g;
            Object r2 = c();
            SortedSet<V> r6 = h().headSet(r5);
            AbstractMapBasedMultimap<K, V>.i r3 = f();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = f();
        L7:
            return new m(r1, r2, r6, r4);
        }

        @Override // java.util.SortedSet
        public V last() {
            a();
            return h().last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$i] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V r5, V r6) {
            a();
            AbstractMapBasedMultimap r1 = this.g;
            Object r2 = c();
            SortedSet<V> r7 = h().subSet(r5, r6);
            AbstractMapBasedMultimap<K, V>.i r8 = f();
            ?? r4 = this;
            if (r8 == null) goto L7;
            r4 = f();
        L7:
            return new m(r1, r2, r7, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$i] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V r5) {
            a();
            AbstractMapBasedMultimap r1 = this.g;
            Object r2 = c();
            SortedSet<V> r6 = h().tailSet(r5);
            AbstractMapBasedMultimap<K, V>.i r3 = f();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = f();
        L7:
            return new m(r1, r2, r6, r4);
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> r3) {
        Map<K, Collection<V>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4.isEmpty());
        this.map = r4;
    }

    static /* synthetic */ Map access$000(AbstractMapBasedMultimap r0) {
        return r0.map;
    }

    static /* synthetic */ Iterator access$100(Collection r2) {
        return iteratorOrListIterator((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap r2) {
        int r0 = r2.totalSize;
        r2.totalSize = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap r2) {
        int r0 = r2.totalSize;
        r2.totalSize = r0 - 1;
        return r0;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap r1, int r2) {
        int r0 = r1.totalSize + r2;
        r1.totalSize = r0;
        return r0;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap r1, int r2) {
        int r0 = r1.totalSize - r2;
        r1.totalSize = r0;
        return r0;
    }

    static /* synthetic */ void access$300(AbstractMapBasedMultimap r0, Object r1) {
        r0.removeValuesForKey(r1);
    }

    private Collection<V> getOrCreateCollection(K r4) {
        Collection<V> r0 = (Collection) ZeusTransformUtils.preCheckCast(this.map.get(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Collection<V> r1 = createCollection(r4);
        this.map.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    private static <E> Iterator<E> iteratorOrListIterator(Collection<E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, List.class) == false) goto L6;
        return ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).listIterator();
    L6:
        return r3.iterator();
    }

    static /* synthetic */ Map.Entry lambda$entrySpliterator$0(Object r0, Object r1) {
        return Maps.a(r0, r1);
    }

    static /* synthetic */ Spliterator lambda$entrySpliterator$1(Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        final Object r0 = r4.getKey();
        return p.a(((Collection) ZeusTransformUtils.preCheckCast(r4.getValue(), Collection.class, "com.obric.memorydata.plugin")).spliterator(), new $$Lambda$AbstractMapBasedMultimap$8xNgVvARiYlNYPdP8abucV0k9FU(r0));
    }

    static /* synthetic */ void lambda$forEach$2(BiConsumer r2, Object r3, Object r4) {
        ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r3, r4);
    }

    static /* synthetic */ void lambda$forEach$3(BiConsumer r2, final Object r3, Collection r4) {
        final BiConsumer r5 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin")).forEach(new $$Lambda$AbstractMapBasedMultimap$DRPoACmyfOCrM78_TZAfGkjjjzU(r5, r3));
    }

    private void removeValuesForKey(Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(Maps.c(this.map, r3), Collection.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        int r0 = r4.size();
        r4.clear();
        this.totalSize -= r0;
        return;
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.am
    public void clear() {
        Iterator<Collection<V>> r0 = this.map.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r0.next(), Collection.class, "com.obric.memorydata.plugin")).clear();
        goto L4
    L6:
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.am
    public boolean containsKey(Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        return new a(this, this.map);
    }

    abstract Collection<V> createCollection();

    Collection<V> createCollection(K r1) {
        return createCollection();
    }

    @Override // com.google.common.collect.c
    Collection<Map.Entry<K, V>> createEntries() {
        if (ZeusTransformUtils.instanceOf(this, aw.class) == false) goto L7;
        return new com.google.common.collect.c.b(this);
    L7:
        return new com.google.common.collect.c.a(this);
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        return new c(this, this.map);
    }

    @Override // com.google.common.collect.c
    an<K> createKeys() {
        return new Multimaps.c(this);
    }

    final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        if (ZeusTransformUtils.instanceOf(this.map, NavigableMap.class) == false) goto L7;
        return new d(this, (NavigableMap) ZeusTransformUtils.preCheckCast(this.map, NavigableMap.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(this.map, SortedMap.class) == false) goto L11;
        return new g(this, (SortedMap) ZeusTransformUtils.preCheckCast(this.map, SortedMap.class, "com.obric.memorydata.plugin"));
    L11:
        return new a(this, this.map);
    }

    final Set<K> createMaybeNavigableKeySet() {
        if (ZeusTransformUtils.instanceOf(this.map, NavigableMap.class) == false) goto L7;
        return new e(this, (NavigableMap) ZeusTransformUtils.preCheckCast(this.map, NavigableMap.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(this.map, SortedMap.class) == false) goto L11;
        return new h(this, (SortedMap) ZeusTransformUtils.preCheckCast(this.map, SortedMap.class, "com.obric.memorydata.plugin"));
    L11:
        return new c(this, this.map);
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.c
    Collection<V> createValues() {
        return new com.google.common.collect.c.C0202c(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.c
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p.a(this.map.entrySet().spliterator(), $$Lambda$AbstractMapBasedMultimap$5RWDlwrY9JHwhnjDCRatNidRafw.INSTANCE, 64, size());
    }

    @Override // com.google.common.collect.am
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        this.map.forEach(new $$Lambda$AbstractMapBasedMultimap$zLKsCwf7UNv0WX2k4Y0eFESzUjw(r4));
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public Collection<V> get(K r4) {
        Collection<V> r0 = (Collection) ZeusTransformUtils.preCheckCast(this.map.get(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = createCollection(r4);
    L6:
        return wrapCollection(r4, r0);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean put(K r4, V r5) {
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(this.map.get(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        Collection<V> r1 = createCollection(r4);
        if (r1.add(r5) == false) goto L9;
        this.totalSize++;
        this.map.put(r4, r1);
        return true;
    L9:
        throw new AssertionError("New Collection violated the Collection spec");
    L11:
        if (r0.add(r5) == false) goto L14;
        this.totalSize++;
        return true;
    L14:
        return false;
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public Collection<V> removeAll(Object r4) {
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(this.map.remove(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        Collection r0 = createCollection();
        r0.addAll(r5);
        this.totalSize -= r5.size();
        r5.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(r0);
    L5:
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public Collection<V> replaceValues(K r4, Iterable<? extends V> r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r6.hasNext() == false) goto L5;
        Collection<V> r7 = getOrCreateCollection(r4);
        Collection<V> r0 = createCollection();
        r0.addAll(r7);
        this.totalSize -= r7.size();
        r7.clear();
    L8:
        if (r6.hasNext() == false) goto L13;
        if (r7.add(r6.next()) == false) goto L8;
        this.totalSize++;
        goto L8
    L13:
        return (Collection<V>) unmodifiableCollectionSubclass(r0);
    L5:
        return removeAll(r4);
    }

    final void setMap(Map<K, Collection<V>> r4) {
        Map<K, Collection<V>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.map = r5;
        this.totalSize = 0;
        Iterator<Collection<V>> r6 = r5.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6.next(), Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(!r0.isEmpty());
        this.totalSize += r0.size();
        goto L4
    }

    @Override // com.google.common.collect.am
    public int size() {
        return this.totalSize;
    }

    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r2) {
        return Collections.unmodifiableCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c
    Iterator<V> valueIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.c
    Spliterator<V> valueSpliterator() {
        return p.a(this.map.values().spliterator(), $$Lambda$9JO8iXCWOXiSGG99sM6w2w_Mqp8.INSTANCE, 64, size());
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public Collection<V> values() {
        return super.values();
    }

    Collection<V> wrapCollection(K r3, Collection<V> r4) {
        return new i(this, r3, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"), null);
    }

    final List<V> wrapList(K r3, List<V> r4, AbstractMapBasedMultimap<K, V>.i r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, RandomAccess.class) == false) goto L6;
        return new f(this, r3, r6, r5);
    L6:
        return new j(this, r3, r6, r5);
    }
}
