package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultimap<K, V> extends g0 implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map f;
    public transient int g;

    public AbstractMapBasedMultimap(Map<K, Collection<V>> r5) {
        com.google.common.base.b0.i(r5.isEmpty());
        this.f = r5;
    }

    public static /* synthetic */ Map access$000(AbstractMapBasedMultimap r5) {
        return r5.f;
    }

    public static Iterator access$100(Collection r5) {
        if ((r5 instanceof List) == false) goto L6;
        return ((List) r5).listIterator();
    L6:
        return r5.iterator();
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap r5) {
        int r10 = r5.g;
        r5.g = r10 + 1;
        return r10;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap r5) {
        int r10 = r5.g;
        r5.g = r10 - 1;
        return r10;
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap r5, int r10) {
        int r11 = r5.g + r10;
        r5.g = r11;
        return r11;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap r5, int r10) {
        int r11 = r5.g - r10;
        r5.g = r11;
        return r11;
    }

    public static void access$300(AbstractMapBasedMultimap r5, Object r10) {
        Map r11 = r5.f;
        r11.getClass();
        Object r12 = r11.remove(r10);     // Catch: Throwable -> L5
    L6:
        Collection r13 = (Collection) r12;
        if (r13 == null) goto L12;
        int r14 = r13.size();
        r13.clear();
        r5.g -= r14;
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public Map<K, Collection<V>> backingMap() {
        return this.f;
    }

    @Override // com.google.common.collect.q7
    public void clear() {
        Iterator<V> r5 = this.f.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((Collection) r5.next()).clear();
        goto L4
    L6:
        this.f.clear();
        this.g = 0;
    }

    @Override // com.google.common.collect.q7
    public boolean containsKey(Object r5) {
        return this.f.containsKey(r5);
    }

    @Override // com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return new n(this, this.f);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(K r5) {
        return createCollection();
    }

    public Collection<Map.Entry<K, V>> createEntries() {
        if ((this instanceof s8) == false) goto L7;
        return new f0(this);
    L7:
        return new e0(this);
    }

    @Override // com.google.common.collect.g0
    public Set<K> createKeySet() {
        return new o(this, this.f);
    }

    @Override // com.google.common.collect.g0
    public z7 createKeys() {
        return new v7(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map r5 = this.f;
        if ((r5 instanceof NavigableMap) == false) goto L7;
        return new p(this, (NavigableMap) this.f);
    L7:
        if ((r5 instanceof SortedMap) == false) goto L11;
        return new s(this, (SortedMap) this.f);
    L11:
        return new n(this, this.f);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map r5 = this.f;
        if ((r5 instanceof NavigableMap) == false) goto L7;
        return new q(this, (NavigableMap) this.f);
    L7:
        if ((r5 instanceof SortedMap) == false) goto L11;
        return new t(this, (SortedMap) this.f);
    L11:
        return new o(this, this.f);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.g0
    public Collection<V> createValues() {
        return new q6(this, 1);
    }

    @Override // com.google.common.collect.q7
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r5 = this.f8983a;
        if (r5 != null) goto L6;
        Collection<Map.Entry<K, V>> r10 = createEntries();
        this.f8983a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.g0
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new k(this, 0);
    }

    @Override // com.google.common.collect.g0
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p7.D(this.f.entrySet().spliterator(), new h(0), 64, size());
    }

    @Override // com.google.common.collect.q7
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        this.f.forEach(new h3(r5, 1));
    }

    @Override // com.google.common.collect.q7
    public Collection<V> get(K r5) {
        Collection<V> r10 = (Collection) this.f.get(r5);
        if (r10 != null) goto L6;
        r10 = createCollection(r5);
    L6:
        return wrapCollection(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        Collection r11 = (Collection) this.f.get(r5);
        if (r11 != null) goto L11;
        Collection<V> r12 = createCollection(r5);
        if (r12.add(r10) == false) goto L9;
        this.g++;
        this.f.put(r5, r12);
        return true;
    L9:
        throw new AssertionError("New Collection violated the Collection spec");
    L11:
        if (r11.add(r10) == false) goto L14;
        this.g++;
        return true;
    L14:
        return false;
    }

    @Override // com.google.common.collect.q7
    public Collection<V> removeAll(Object r5) {
        Collection r10 = (Collection) this.f.remove(r5);
        if (r10 == null) goto L5;
        Collection r11 = createCollection();
        r11.addAll(r10);
        this.g -= r10.size();
        r10.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(r11);
    L5:
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.q7
    public Collection<V> replaceValues(K r5, Iterable<? extends V> r10) {
        Iterator<? extends V> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L5;
        Collection<V> r12 = (Collection) this.f.get(r5);
        if (r12 != null) goto L9;
        r12 = createCollection(r5);
        this.f.put(r5, r12);
    L9:
        Collection r13 = createCollection();
        r13.addAll(r12);
        this.g -= r12.size();
        r12.clear();
    L11:
        if (r11.hasNext() == false) goto L16;
        if (r12.add(r11.next()) == false) goto L11;
        this.g++;
        goto L11
    L16:
        return (Collection<V>) unmodifiableCollectionSubclass(r13);
    L5:
        return removeAll(r5);
    }

    public final void setMap(Map<K, Collection<V>> r5) {
        this.f = r5;
        this.g = 0;
        Iterator<Collection<V>> r10 = r5.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Collection<V> r11 = r10.next();
        com.google.common.base.b0.i(!r11.isEmpty());
        this.g = r11.size() + this.g;
        goto L4
    }

    @Override // com.google.common.collect.q7
    public int size() {
        return this.g;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r5) {
        return Collections.unmodifiableCollection(r5);
    }

    @Override // com.google.common.collect.g0
    public Iterator<V> valueIterator() {
        return new k(this, 1);
    }

    @Override // com.google.common.collect.g0
    public Spliterator<V> valueSpliterator() {
        return p7.D(this.f.values().spliterator(), new h(1), 64, size());
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public Collection<V> values() {
        return (Collection<V>) super.values();
    }

    public Collection<V> wrapCollection(K r5, Collection<V> r10) {
        return new u(this, r5, r10, null);
    }

    public final List<V> wrapList(K r5, List<V> r10, u r11) {
        if ((r10 instanceof RandomAccess) == false) goto L6;
        return new r(this, r5, r10, r11);
    L6:
        return new w(this, r5, r10, r11);
    }
}
