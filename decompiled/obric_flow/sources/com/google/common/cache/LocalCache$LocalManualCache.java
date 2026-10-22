package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.x3;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
class LocalCache$LocalManualCache<K, V> implements c, Serializable {
    private static final long serialVersionUID = 1;
    final q0 localCache;

    public /* synthetic */ LocalCache$LocalManualCache(q0 r5, n r10) {
        this(r5);
    }

    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        return this.localCache;
    }

    @Override // com.google.common.cache.c
    public void cleanUp() {
        LocalCache$Segment[] r5 = this.localCache.f8747c;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cleanUp();
        r11 = r11 + 1;
        goto L3
    }

    @Override // com.google.common.cache.c
    public V get(K r5, Callable<? extends V> r10) throws ExecutionException {
        r10.getClass();
        q0 r11 = this.localCache;
        z r12 = new z(r10);
        r11.getClass();
        r5.getClass();
        int r13 = r11.e(r5);
        return (V) r11.i(r13).get(r5, r13, r12);
    }

    @Override // com.google.common.cache.c
    public ImmutableMap<K, V> getAllPresent(Iterable<?> r10) {
        q0 r5 = this.localCache;
        r5.getClass();
        x3 r11 = ImmutableMap.builder();
        Iterator<?> r12 = r10.iterator();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r15 = r12.next();
        Object r16 = r5.get(r15);
        if (r16 == null) goto L7;
        r11.g(r15, r16);
        r13 = r13 + 1;
        goto L4
    L7:
        r14 = r14 + 1;
        goto L4
    L9:
        b r17 = r5.f8757q;
        r17.a(r13);
        r17.b(r14);
        return r11.c();
    }

    @Override // com.google.common.cache.c
    public V getIfPresent(Object r5) {
        q0 r10 = this.localCache;
        r10.getClass();
        r5.getClass();
        int r11 = r10.e(r5);
        V r12 = (V) r10.i(r11).get(r5, r11);
        b r13 = r10.f8757q;
        if (r12 != null) goto L5;
        r13.b(1);
    L6:
        return r12;
    L5:
        r13.a(1);
        goto L6
    }

    @Override // com.google.common.cache.c
    public void invalidate(Object r5) {
        r5.getClass();
        this.localCache.remove(r5);
    }

    @Override // com.google.common.cache.c
    public void invalidateAll(Iterable<?> r5) {
        q0 r10 = this.localCache;
        r10.getClass();
        Iterator<?> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.remove(r11.next());
        goto L4
    }

    @Override // com.google.common.cache.c
    public void put(K r5, V r10) {
        this.localCache.put(r5, r10);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> r5) {
        this.localCache.putAll(r5);
    }

    @Override // com.google.common.cache.c
    public long size() {
        LocalCache$Segment[] r5 = this.localCache.f8747c;
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + ((long) r5[r11].count);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // com.google.common.cache.c
    public i stats() {
        a r5 = new a();
        r5.g(this.localCache.f8757q);
        LocalCache$Segment[] r10 = this.localCache.f8747c;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r5.g(r10[r12].statsCounter);
        r12 = r12 + 1;
        goto L3
    L6:
        return r5.f();
    }

    public Object writeReplace() {
        return new LocalCache$ManualSerializationProxy(this.localCache);
    }

    public LocalCache$LocalManualCache(f r5) {
        this(new q0(r5, null));
    }

    public LocalCache$LocalManualCache(q0 r5) {
        this.localCache = r5;
    }

    @Override // com.google.common.cache.c
    public void invalidateAll() {
        this.localCache.clear();
    }
}
