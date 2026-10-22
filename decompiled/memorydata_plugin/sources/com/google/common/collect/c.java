package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
abstract class c<K, V> implements am<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient an<K> keys;
    private transient Collection<V> values;

    class a extends Multimaps.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4674a;

        a(c r1) {
            this.f4674a = r1;
        }

        @Override // com.google.common.collect.Multimaps.b
        am<K, V> a() {
            return this.f4674a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.f4674a.entryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return this.f4674a.entrySpliterator();
        }
    }

    class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        b(c r1) {
            super(r1);
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

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    class C0202c extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4675a;

        C0202c(c r1) {
            this.f4675a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4675a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.f4675a.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.f4675a.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4675a.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return this.f4675a.valueSpliterator();
        }
    }

    c() {
    }

    @Override // com.google.common.collect.am
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> r0 = this.asMap;
        if (r0 != null) goto L6;
        Map<K, Collection<V>> r1 = createAsMap();
        this.asMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.am
    public boolean containsEntry(Object r2, Object r3) {
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(asMap().get(r2), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.am
    public boolean containsValue(Object r4) {
        Iterator<Collection<V>> r3 = asMap().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin")).contains(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    abstract Map<K, Collection<V>> createAsMap();

    abstract Collection<Map.Entry<K, V>> createEntries();

    abstract Set<K> createKeySet();

    abstract an<K> createKeys();

    abstract Collection<V> createValues();

    @Override // com.google.common.collect.am
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r0 = this.entries;
        if (r0 != null) goto L6;
        Collection<Map.Entry<K, V>> r1 = createEntries();
        this.entries = r1;
        return r1;
    L6:
        return r0;
    }

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entryIterator(), size(), ZeusTransformUtils.instanceOf(this, aw.class) ? 1 : 0);
    }

    @Override // com.google.common.collect.am
    public boolean equals(Object r1) {
        return Multimaps.a(this, r1);
    }

    @Override // com.google.common.collect.am
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.am
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.am
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        Set<K> r1 = createKeySet();
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.am
    public an<K> keys() {
        an<K> r0 = this.keys;
        if (r0 != null) goto L6;
        an<K> r1 = createKeys();
        this.keys = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.am
    public boolean put(K r1, V r2) {
        return get(r1).add(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am
    public boolean putAll(am<? extends K, ? extends V> r5) {
        Iterator<Map.Entry<K, V>> r6 = ((am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.memorydata.plugin")).entries().iterator();
        boolean r0 = false;
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 | put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.collect.am
    public boolean putAll(K r5, Iterable<? extends V> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L11;
        Collection<? extends V> r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L10;
        if (get(r5).addAll(r8) == false) goto L10;
        return true;
    L10:
        return false;
    L11:
        Iterator r9 = r7.iterator();
        if (r9.hasNext() == false) goto L17;
        if (Iterators.a(get(r5), r9) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.google.common.collect.am
    public boolean remove(Object r2, Object r3) {
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(asMap().get(r2), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.remove(r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public Collection<V> replaceValues(K r3, Iterable<? extends V> r4) {
        Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        Collection<V> r0 = removeAll(r3);
        putAll(r3, r5);
        return r0;
    }

    public String toString() {
        return asMap().toString();
    }

    Iterator<V> valueIterator() {
        return Maps.b(entries().iterator());
    }

    Spliterator<V> valueSpliterator() {
        return Spliterators.spliterator(valueIterator(), size(), 0);
    }

    @Override // com.google.common.collect.am
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }
}
