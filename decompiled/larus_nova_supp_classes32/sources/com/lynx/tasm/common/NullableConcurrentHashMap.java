package com.lynx.tasm.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
    public static final Object a = null;

    public class a implements Set<Map.Entry<K, V>> {
        public final /* synthetic */ Set a;

        /* JADX INFO: renamed from: com.lynx.tasm.common.NullableConcurrentHashMap$a$a, reason: collision with other inner class name */
        public class C0058a implements Iterator<Map.Entry<K, V>> {
            public final /* synthetic */ Iterator a;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return new com.lynx.tasm.common.a((Map.Entry) this.a.next());
            }

            public C0058a(Iterator r1) {
                this.a = r1;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            this.a.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new C0058a(this.a.iterator());
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return this.a.size();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            Object[] r0 = this.a.toArray();
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L9;
            if (r0[r1] != NullableConcurrentHashMap.access$000()) goto L8;
            r0[r1] = null;
        L8:
            r1 = r1 + 1;
            goto L4
        L9:
            return r0;
        }

        public a(Set r1) {
            this.a = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object r2) {
            Set r0 = this.a;
            return r0.add((Map.Entry) r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> r2) {
            return this.a.addAll(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object r2) {
            Set r0 = this.a;
            if (r2 != null) goto L6;
            r2 = NullableConcurrentHashMap.access$000();
        L6:
            return r0.contains(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> r2) {
            return this.a.containsAll(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object r2) {
            return this.a.remove(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> r2) {
            return this.a.retainAll(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> r2) {
            return this.a.retainAll(r2);
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] r2) {
            return (T[]) this.a.toArray(r2);
        }
    }

    static {
        a = new Object();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new a(super.entrySet());
    }

    public NullableConcurrentHashMap() {
    }

    public static /* synthetic */ Object access$000() {
        return a;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        Object r0 = a;
        if (r2 != null) goto L5;
        r2 = r0;
    L5:
        V r3 = (V) super.get(r2);
        if (r3 != r0) goto L9;
        return null;
    L9:
        return r3;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L6
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        Object r0 = a;
        if (r2 != null) goto L5;
        r2 = (K) r0;
    L5:
        if (r3 != null) goto L7;
        r3 = (V) r0;
    L7:
        V r4 = (V) super.put(r2, r3);
        if (r4 != r0) goto L11;
        return null;
    L11:
        return r4;
    }
}
