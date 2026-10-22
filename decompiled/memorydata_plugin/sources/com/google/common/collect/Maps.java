package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Predicates;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class Maps {

    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.k<A, B> bimap;

        BiMapConverter(com.google.common.collect.k<A, B> r3) {
            this.bimap = (com.google.common.collect.k) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((com.google.common.collect.k) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.collect.k.class, "com.obric.memorydata.plugin")), com.google.common.collect.k.class, "com.obric.memorydata.plugin");
        }

        private static <X, Y> Y convert(com.google.common.collect.k<X, Y> r2, X r3) {
            Y r4 = (Y) ((com.google.common.collect.k) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.collect.k.class, "com.obric.memorydata.plugin")).get(r3);
            if (r4 == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.a(r0, "No non-null mapping present for input: %s", r3);
            return r4;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r1) {
            return (A) convert(this.bimap.inverse(), r1);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r1) {
            return (B) convert(this.bimap, r1);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, BiMapConverter.class) == false) goto L6;
            BiMapConverter r4 = (BiMapConverter) ZeusTransformUtils.preCheckCast(r3, BiMapConverter.class, "com.obric.memorydata.plugin");
            return this.bimap.equals(r4.bimap);
        L6:
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    private static abstract enum EntryFunction extends Enum<EntryFunction> implements com.google.common.base.g<Map.Entry<?, ?>, Object> {
        private static final /* synthetic */ EntryFunction[] $VALUES = null;
        public static final EntryFunction KEY = null;
        public static final EntryFunction VALUE = null;

        private static /* synthetic */ EntryFunction[] $values() {
            return new EntryFunction[]{KEY, VALUE};
        }

        static {
            final String r1 = "KEY";
            final int r2 = 0;
            KEY = new AnonymousClass1(r1, r2);
            final String r3 = "VALUE";
            final int r4 = 1;
            VALUE = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private EntryFunction(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ EntryFunction(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static EntryFunction valueOf(String r2) {
            return (EntryFunction) ZeusTransformUtils.preCheckCast(Enum.valueOf(EntryFunction.class, r2), EntryFunction.class, "com.obric.memorydata.plugin");
        }

        public static EntryFunction[] values() {
            return (EntryFunction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EntryFunction[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class UnmodifiableBiMap<K, V> extends y<K, V> implements com.google.common.collect.k<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.k<? extends K, ? extends V> delegate;
        com.google.common.collect.k<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        transient Set<V> values;

        UnmodifiableBiMap(com.google.common.collect.k<? extends K, ? extends V> r3, com.google.common.collect.k<V, K> r4) {
            com.google.common.collect.k<? extends K, ? extends V> r5 = (com.google.common.collect.k) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.collect.k.class, "com.obric.memorydata.plugin");
            com.google.common.collect.k<V, K> r6 = (com.google.common.collect.k) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.collect.k.class, "com.obric.memorydata.plugin");
            this.unmodifiableMap = Collections.unmodifiableMap(r5);
            this.delegate = r5;
            this.inverse = r6;
        }

        @Override // java.util.Map
        public V compute(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K r1, Function<? super K, ? extends V> r2) {
            Function r0 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfPresent(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.ac
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.k
        public V forcePut(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k
        public com.google.common.collect.k<V, K> inverse() {
            com.google.common.collect.k<V, K> r0 = this.inverse;
            if (r0 != null) goto L6;
            UnmodifiableBiMap r1 = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.Map
        public V merge(K r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V putIfAbsent(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean remove(Object r1, Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V replace(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean replace(K r1, V r2, V r3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r1 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, java.util.Map, com.google.common.collect.k
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // com.google.common.collect.y, java.util.Map, com.google.common.collect.k
        public Set<V> values() {
            Set<V> r0 = this.values;
            if (r0 != null) goto L6;
            Set<V> r1 = Collections.unmodifiableSet(this.delegate.values());
            this.values = r1;
            return r1;
        L6:
            return r0;
        }
    }

    static class UnmodifiableNavigableMap<K, V> extends af<K, V> implements Serializable, NavigableMap<K, V> {
        private final NavigableMap<K, ? extends V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r3) {
            this.delegate = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r3, UnmodifiableNavigableMap<K, V> r4) {
            this.delegate = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
            this.descendingMap = r4;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r1) {
            return Maps.d(this.delegate.ceilingEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return this.delegate.ceilingKey(r1);
        }

        @Override // java.util.Map
        public V compute(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K r1, Function<? super K, ? extends V> r2) {
            Function r0 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfPresent(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.af, com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.af, com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.af, com.google.common.collect.y, com.google.common.collect.ac
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.a(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> r0 = this.descendingMap;
            if (r0 != null) goto L6;
            UnmodifiableNavigableMap<K, V> r1 = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
            this.descendingMap = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.d(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r1) {
            return Maps.d(this.delegate.floorEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return this.delegate.floorKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r1, boolean r2) {
            return Maps.a(this.delegate.headMap(r1, r2));
        }

        @Override // com.google.common.collect.af, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r1) {
            return Maps.d(this.delegate.higherEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return this.delegate.higherKey(r1);
        }

        @Override // com.google.common.collect.y, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.d(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r1) {
            return Maps.d(this.delegate.lowerEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return this.delegate.lowerKey(r1);
        }

        @Override // java.util.Map
        public V merge(K r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.a(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V putIfAbsent(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean remove(Object r1, Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V replace(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean replace(K r1, V r2, V r3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r1 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r1, boolean r2, K r3, boolean r4) {
            return Maps.a(this.delegate.subMap(r1, r2, r3, r4));
        }

        @Override // com.google.common.collect.af, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r1, boolean r2) {
            return Maps.a(this.delegate.tailMap(r1, r2));
        }

        @Override // com.google.common.collect.af, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }
    }

    static abstract class a<K, V> extends y<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Comparator<? super K> f4548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f4549b;
        private transient NavigableSet<K> c;

        /* JADX INFO: renamed from: com.google.common.collect.Maps$a$a, reason: collision with other inner class name */
        class C0196a extends b<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f4550a;

            C0196a(a r1) {
                this.f4550a = r1;
            }

            @Override // com.google.common.collect.Maps.b
            Map<K, V> a() {
                return this.f4550a;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return this.f4550a.b();
            }
        }

        a() {
        }

        private static <T> Ordering<T> a(Comparator<T> r2) {
            return Ordering.from((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin")).reverse();
        }

        abstract NavigableMap<K, V> a();

        abstract Iterator<Map.Entry<K, V>> b();

        Set<Map.Entry<K, V>> c() {
            return new C0196a(this);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r1) {
            return a().floorEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return a().floorKey(r1);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> r0 = this.f4548a;
            if (r0 != null) goto L9;
            Comparator<? super K> r1 = a().comparator();
            if (r1 != null) goto L7;
            r1 = Ordering.natural();
        L7:
            Ordering r2 = a(r1);
            this.f4548a = r2;
            return r2;
        L9:
            return r0;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.ac
        public final Map<K, V> delegate() {
            return a();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return a().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return a();
        }

        @Override // com.google.common.collect.y, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r0 = this.f4549b;
            if (r0 != null) goto L6;
            Set<Map.Entry<K, V>> r1 = c();
            this.f4549b = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return a().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return a().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r1) {
            return a().ceilingEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return a().ceilingKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r1, boolean r2) {
            return a().tailMap(r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r1) {
            return a().lowerEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return a().lowerKey(r1);
        }

        @Override // com.google.common.collect.y, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return a().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return a().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r1) {
            return a().higherEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return a().higherKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> r0 = this.c;
            if (r0 != null) goto L6;
            f r1 = new f(this);
            this.c = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return a().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return a().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r1, boolean r2, K r3, boolean r4) {
            return a().subMap(r3, r4, r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r1, boolean r2) {
            return a().headMap(r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }

        @Override // com.google.common.collect.ac
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.y, java.util.Map, com.google.common.collect.k
        public Collection<V> values() {
            return new l(this);
        }
    }

    static abstract class b<K, V> extends Sets.b<Map.Entry<K, V>> {
        b() {
        }

        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L11;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            Object r2 = Maps.a(a(), r0);
            if (com.google.common.base.k.a(r2, r5.getValue()) == false) goto L12;
            if (r2 == null) goto L8;
        L9:
            return true;
        L8:
            if (a().containsKey(r0) == true) goto L9;
            return false;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (contains(r3) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L10;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return a().keySet().remove(r4.getKey());
        L10:
            return false;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            return super.removeAll((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Collection.class, "com.obric.memorydata.plugin"));
        L6:
            return Sets.a(this, r5.iterator());
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            return super.retainAll((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), Collection.class, "com.obric.memorydata.plugin"));
        L5:
            HashSet r0 = Sets.a(r6.size());
            Iterator r7 = r6.iterator();
        L7:
            if (r7.hasNext() == false) goto L14;
            Object r2 = r7.next();
            if (contains(r2) == false) goto L7;
            if (ZeusTransformUtils.instanceOf(r2, Map.Entry.class) == false) goto L7;
            r0.add(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey());
            goto L7
        L14:
            return a().keySet().retainAll(r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    @FunctionalInterface
    public interface c<K, V1, V2> {
        V2 a(K r1, V1 r2);
    }

    static abstract class d<K, V> extends AbstractMap<K, V> {
        d() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.h(entryIterator());
        }

        abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new AnonymousClass1(this);
        }

        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 65);
        }

        void forEachEntry(Consumer<? super Map.Entry<K, V>> r3) {
            Consumer<? super Map.Entry<K, V>> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            entryIterator().forEachRemaining(r4);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    static class e<K, V> extends Sets.b<K> {
        final Map<K, V> d;

        e(Map<K, V> r3) {
            this.d = (Map) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        }

        private static /* synthetic */ void a(Consumer r1, Object r2, Object r3) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r1, Consumer.class, "com.obric.memorydata.plugin")).accept(r2);
        }

        public static /* synthetic */ void lambda$hco98teuDjQcWqfi1btCfOKAf90(Consumer r0, Object r1, Object r2) {
            a(r0, r1, r2);
        }

        Map<K, V> c() {
            return this.d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return c().containsKey(r1);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.d.forEach(new $$Lambda$Maps$e$hco98teuDjQcWqfi1btCfOKAf90(r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(c().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            if (contains(r2) == false) goto L6;
            c().remove(r2);
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().size();
        }
    }

    static class f<K, V> extends g<K, V> implements NavigableSet<K> {
        f(NavigableMap<K, V> r3) {
            super((NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin"));
        }

        NavigableMap<K, V> a() {
            return (NavigableMap) ZeusTransformUtils.preCheckCast(this.d, NavigableMap.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Maps.g
        /* synthetic */ SortedMap b() {
            return a();
        }

        @Override // com.google.common.collect.Maps.g, com.google.common.collect.Maps.e
        /* synthetic */ Map c() {
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
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K r1) {
            return a().floorKey(r1);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K r1, boolean r2) {
            return a().headMap(r1, r2).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K r2) {
            return headSet(r2, false);
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
            return (K) Maps.b(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.b(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K r1, boolean r2, K r3, boolean r4) {
            return a().subMap(r1, r2, r3, r4).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K r3, K r4) {
            return subSet(r3, true, r4, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K r1, boolean r2) {
            return a().tailMap(r1, r2).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.g, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K r2) {
            return tailSet(r2, true);
        }
    }

    static class g<K, V> extends e<K, V> implements SortedSet<K> {
        g(SortedMap<K, V> r3) {
            super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"));
        }

        SortedMap<K, V> b() {
            return (SortedMap) ZeusTransformUtils.preCheckCast(super.c(), SortedMap.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Maps.e
        /* synthetic */ Map c() {
            return b();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K r2) {
            return new g(b().headMap(r2));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K r2, K r3) {
            return new g(b().subMap(r2, r3));
        }

        public SortedSet<K> tailSet(K r2) {
            return new g(b().tailMap(r2));
        }
    }

    static class h<K, V1, V2> extends d<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V1> f4552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<? super K, ? super V1, V2> f4553b;

        h(Map<K, V1> r3, c<? super K, ? super V1, V2> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            this.f4552a = (Map) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Map.class, "com.obric.memorydata.plugin");
            this.f4553b = (c) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), c.class, "com.obric.memorydata.plugin");
        }

        private /* synthetic */ void a(BiConsumer r3, Object r4, Object r5) {
            ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r4, this.f4553b.a(r4, r5));
        }

        public static /* synthetic */ void lambda$6yxV80cWMXsxOQ8R7jofC7fzhOE(h r0, BiConsumer r1, Object r2, Object r3) {
            r0.a(r1, r2, r3);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f4552a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.f4552a.containsKey(r1);
        }

        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.a(this.f4552a.entrySet().iterator(), Maps.a(this.f4553b));
        }

        @Override // com.google.common.collect.Maps.d
        Spliterator<Map.Entry<K, V2>> entrySpliterator() {
            return p.a(this.f4552a.entrySet().spliterator(), Maps.a(this.f4553b));
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V2> r3) {
            final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.f4552a.forEach(new $$Lambda$Maps$h$6yxV80cWMXsxOQ8R7jofC7fzhOE(this, r4));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object r2) {
            return getOrDefault(r2, null);
        }

        @Override // java.util.Map
        public V2 getOrDefault(Object r3, V2 r4) {
            V1 r0 = this.f4552a.get(r3);
            if (r0 != null) goto L9;
            if (this.f4552a.containsKey(r3) == true) goto L9;
            return r4;
        L9:
            return this.f4553b.a(r3, (Object) ao.a(r0));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f4552a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object r2) {
            if (this.f4552a.containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.f4553b.a(r2, (Object) ao.a(this.f4552a.remove(r2)));
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4552a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new l(this);
        }
    }

    static class i<K, V1, V2> extends h<K, V1, V2> implements SortedMap<K, V2> {
        i(SortedMap<K, V1> r3, c<? super K, ? super V1, V2> r4) {
            super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"));
        }

        public SortedMap<K, V1> a() {
            return (SortedMap) ZeusTransformUtils.preCheckCast(this.f4552a, SortedMap.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return a().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K r2) {
            return Maps.a(a().headMap(r2), this.f4553b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return a().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K r2, K r3) {
            return Maps.a(a().subMap(r2, r3), this.f4553b);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K r2) {
            return Maps.a(a().tailMap(r2), this.f4553b);
        }
    }

    static class j<K, V> extends v<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<Map.Entry<K, V>> f4554a;

        j(Collection<Map.Entry<K, V>> r3) {
            this.f4554a = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f4554a;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.c(this.f4554a.iterator());
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }
    }

    static class k<K, V> extends j<K, V> implements Set<Map.Entry<K, V>> {
        k(Set<Map.Entry<K, V>> r3) {
            super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object r1) {
            return Sets.a(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.a(this);
        }
    }

    static class l<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<K, V> f4555b;

        l(Map<K, V> r3) {
            this.f4555b = (Map) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        }

        private static /* synthetic */ void a(Consumer r1, Object r2, Object r3) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r1, Consumer.class, "com.obric.memorydata.plugin")).accept(r3);
        }

        /* JADX INFO: renamed from: lambda$2O9v2wWF-5PWxHlp1fI3TjBIYFM, reason: not valid java name */
        public static /* synthetic */ void m128lambda$2O9v2wWF5PWxHlp1fI3TjBIYFM(Consumer r0, Object r1, Object r2) {
            a(r0, r1, r2);
        }

        final Map<K, V> a() {
            return this.f4555b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return a().containsValue(r1);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.f4555b.forEach(new $$Lambda$Maps$l$2O9v2wWF5PWxHlp1fI3TjBIYFM(r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.b(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r5) {
            return super.remove(r5);
        L4:
            Iterator<Map.Entry<K, V>> r0 = a().entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L11;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (com.google.common.base.k.a(r5, r1.getValue()) == false) goto L6;
            a().remove(r1.getKey());
            return true;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            return super.removeAll((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r7), Collection.class, "com.obric.memorydata.plugin"));
        L5:
            HashSet r0 = Sets.a();
            Iterator<Map.Entry<K, V>> r2 = a().entrySet().iterator();
        L7:
            if (r2.hasNext() == false) goto L12;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r7.contains(r3.getValue()) == false) goto L7;
            r0.add(r3.getKey());
            goto L7
        L12:
            return a().keySet().removeAll(r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            return super.retainAll((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r7), Collection.class, "com.obric.memorydata.plugin"));
        L5:
            HashSet r0 = Sets.a();
            Iterator<Map.Entry<K, V>> r2 = a().entrySet().iterator();
        L7:
            if (r2.hasNext() == false) goto L12;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r7.contains(r3.getValue()) == false) goto L7;
            r0.add(r3.getKey());
            goto L7
        L12:
            return a().keySet().retainAll(r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static abstract class m<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f4556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set<K> f4557b;
        private transient Collection<V> c;

        m() {
        }

        abstract Set<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r0 = this.f4556a;
            if (r0 != null) goto L6;
            Set<Map.Entry<K, V>> r1 = a();
            this.f4556a = r1;
            return r1;
        L6:
            return r0;
        }

        Set<K> h() {
            return new e(this);
        }

        Collection<V> i() {
            return new l(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> r0 = this.f4557b;
            if (r0 != null) goto L6;
            Set<K> r1 = h();
            this.f4557b = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> r0 = this.c;
            if (r0 != null) goto L6;
            Collection<V> r1 = i();
            this.c = r1;
            return r1;
        L6:
            return r0;
        }
    }

    static <K> com.google.common.base.g<Map.Entry<K, ?>, K> a() {
        return EntryFunction.KEY;
    }

    static <K, V1, V2> com.google.common.base.g<Map.Entry<K, V1>, Map.Entry<K, V2>> a(c<? super K, ? super V1, V2> r2) {
        final c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        return new AnonymousClass3(r3);
    }

    static <K> com.google.common.base.o<Map.Entry<K, ?>> a(com.google.common.base.o<? super K> r2) {
        return Predicates.a((com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.o.class, "com.obric.memorydata.plugin"), a());
    }

    static <E> ImmutableMap<E, Integer> a(Collection<E> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        ImmutableMap.a r0 = new ImmutableMap.a(r5.size());
        Iterator<E> r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        int r3 = r1 + 1;
        r0.b(r6.next(), Integer.valueOf(r1));
        r1 = r3;
        goto L4
    L7:
        return r0.e();
    }

    static <K, V1, V2> c<K, V1, V2> a(com.google.common.base.g<? super V1, V2> r2) {
        final com.google.common.base.g r3 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        return new AnonymousClass8(r3);
    }

    static <V> V a(Map<?, V> r2, Object r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return (V) r4.get(r3);
    L5:
        return null;
    }

    static String a(Map<?, ?> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = q.a(r7.size()).append('{');
        Iterator r8 = r7.entrySet().iterator();
        boolean r2 = true;
    L4:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L8;
        r0.append(", ");
    L8:
        r2 = false;
        r0.append(r3.getKey()).append('=').append(r3.getValue());
        goto L4
    L10:
        return r0.append('}').toString();
    }

    public static <K, V> HashMap<K, V> a(int r1) {
        return new HashMap(b(r1));
    }

    static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> r2) {
        final Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }

    static <K, V> Iterator<Map.Entry<K, V>> a(Set<K> r2, com.google.common.base.g<? super K, V> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        final com.google.common.base.g r5 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        final Iterator r6 = r4.iterator();
        return new AnonymousClass5(r6, r5);
    }

    static <V2, K, V1> Map.Entry<K, V2> a(c<? super K, ? super V1, V2> r2, Map.Entry<K, V1> r3) {
        final c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        final Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new AnonymousClass2(r5, r4);
    }

    public static <K, V> Map.Entry<K, V> a(K r1, V r2) {
        return new ImmutableEntry(r1, r2);
    }

    static <K, V> Map.Entry<K, V> a(Map.Entry<? extends K, ? extends V> r2) {
        final Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        return new AnonymousClass6(r3);
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> r2, com.google.common.base.g<? super V1, V2> r3) {
        return a((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), a((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin")));
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> r2, c<? super K, ? super V1, V2> r3) {
        return new h((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> NavigableMap<K, V> a(NavigableMap<K, ? extends V> r2) {
        NavigableMap<K, V> r3 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r2, NavigableMap.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        if (ZeusTransformUtils.instanceOf(r3, UnmodifiableNavigableMap.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableNavigableMap(r3);
    }

    static <K, V> Set<Map.Entry<K, V>> a(Set<Map.Entry<K, V>> r2) {
        return new k(Collections.unmodifiableSet((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin")));
    }

    public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> r2, com.google.common.base.g<? super V1, V2> r3) {
        return a((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), a((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin")));
    }

    public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> r2, c<? super K, ? super V1, V2> r3) {
        return new i((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void a(Map<K, V> r3, Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.put(r0.getKey(), r0.getValue());
        goto L4
    }

    static <K, V> boolean a(Collection<Map.Entry<K, V>> r2, Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L7;
        return false;
    L7:
        return r4.contains(a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")));
    }

    static int b(int r4) {
        if (r4 >= 3) goto L7;
        o.a(r4, "expectedSize");
        return r4 + 1;
    L7:
        if (r4 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) Math.ceil(((double) r4) / 0.75d);
    }

    static <V> com.google.common.base.g<Map.Entry<?, V>, V> b() {
        return EntryFunction.VALUE;
    }

    static <V> com.google.common.base.o<Map.Entry<?, V>> b(com.google.common.base.o<? super V> r2) {
        return Predicates.a((com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.o.class, "com.obric.memorydata.plugin"), b());
    }

    static <K> K b(Map.Entry<K, ?> r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        return (K) r3.getKey();
    }

    static <K, V> Iterator<V> b(Iterator<Map.Entry<K, V>> r2) {
        final Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return new AnonymousClass4(r3);
    }

    static <K, V> boolean b(Collection<Map.Entry<K, V>> r2, Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L7;
        return false;
    L7:
        return r4.remove(a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")));
    }

    static boolean b(Map<?, ?> r2, Object r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return r4.containsKey(r3);
    L5:
        return false;
    }

    static <K, V> bj<Map.Entry<K, V>> c(Iterator<Map.Entry<K, V>> r2) {
        final Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return new AnonymousClass7(r3);
    }

    static <V> V c(Map.Entry<?, V> r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        return (V) r3.getValue();
    }

    static <V> V c(Map<?, V> r2, Object r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return (V) r4.remove(r3);
    L5:
        return null;
    }

    public static <K, V> HashMap<K, V> c() {
        return new HashMap();
    }

    public static <K, V> LinkedHashMap<K, V> c(int r1) {
        return new LinkedHashMap(b(r1));
    }

    public static <K, V> LinkedHashMap<K, V> d() {
        return new LinkedHashMap();
    }

    static /* synthetic */ Map.Entry d(Map.Entry r2) {
        return e((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    static boolean d(Map<?, ?> r2, Object r3) {
        return Iterators.a(a(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator()), r3);
    }

    public static <K, V> IdentityHashMap<K, V> e() {
        return new IdentityHashMap();
    }

    private static <K, V> Map.Entry<K, V> e(Map.Entry<K, ? extends V> r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        return a(r3);
    }

    static boolean e(Map<?, ?> r2, Object r3) {
        return Iterators.a(b(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator()), r3);
    }

    static boolean f(Map<?, ?> r2, Object r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r4 != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == false) goto L10;
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        return r4.entrySet().equals(r5.entrySet());
    L10:
        return false;
    }
}
