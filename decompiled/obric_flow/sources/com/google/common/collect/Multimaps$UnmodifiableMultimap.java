package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$UnmodifiableMultimap<K, V> extends x2 implements Serializable {
    private static final long serialVersionUID = 0;
    final q7 delegate;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient z7 keys;
    transient Map<K, Collection<V>> map;
    transient Collection<V> values;

    public Multimaps$UnmodifiableMultimap(q7 r5) {
        r5.getClass();
        this.delegate = r5;
    }

    @Override // com.google.common.collect.q7
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> r5 = this.map;
        if (r5 != null) goto L6;
        Map<K, Collection<V>> r10 = Collections.unmodifiableMap(new k7(this.delegate.asMap(), new f7(new j8(2))));
        this.map = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.q7
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r5 = this.entries;
        if (r5 != null) goto L10;
        Collection r10 = this.delegate.entries();
        if ((r10 instanceof Set) == false) goto L8;
        Collection<Map.Entry<K, V>> r11 = new n7(Collections.unmodifiableSet((Set) r10));
    L7:
        r5 = r11;
        this.entries = r5;
        goto L10
    L8:
        r11 = new m7(Collections.unmodifiableCollection(r10));
    L10:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        q7 r10 = this.delegate;
        r5.getClass();
        r10.forEach(r5);
    }

    public Collection<V> get(K r5) {
        return p7.a(this.delegate.get(r5));
    }

    @Override // com.google.common.collect.q7
    public Set<K> keySet() {
        Set<K> r5 = this.keySet;
        if (r5 != null) goto L6;
        Set<K> r10 = Collections.unmodifiableSet(this.delegate.keySet());
        this.keySet = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public z7 keys() {
        z7 r5 = this.keys;
        if (r5 != null) goto L11;
        r5 = this.delegate.keys();
        if ((r5 instanceof Multisets$UnmodifiableMultiset) == false) goto L7;
    L10:
        this.keys = r5;
        goto L11
    L7:
        if ((r5 instanceof ImmutableMultiset) == true) goto L10;
        r5.getClass();
        r5 = new Multisets$UnmodifiableMultiset(r5);
    L11:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    public boolean remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    public Collection<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    public Collection<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    public Collection<V> values() {
        Collection<V> r5 = this.values;
        if (r5 != null) goto L6;
        Collection<V> r10 = Collections.unmodifiableCollection(this.delegate.values());
        this.values = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.x2, com.google.common.collect.z2
    public q7 delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(q7 r5) {
        throw new UnsupportedOperationException();
    }
}
