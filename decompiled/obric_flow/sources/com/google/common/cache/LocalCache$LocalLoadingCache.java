package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
class LocalCache$LocalLoadingCache<K, V> extends LocalCache$LocalManualCache<K, V> implements k {
    private static final long serialVersionUID = 1;

    public LocalCache$LocalLoadingCache(f r5, h r10) {
        r10.getClass();
        super(new q0(r5, r10), null);
    }

    @Override // com.google.common.cache.k, java.util.function.Function
    public final V apply(K r5) {
        return getUnchecked(r5);
    }

    @Override // com.google.common.cache.k
    public V get(K r5) throws ExecutionException {
        q0 r10 = this.localCache;
        h r11 = r10.f8758r;
        r5.getClass();
        int r12 = r10.e(r5);
        return (V) r10.i(r12).get(r5, r12, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.cache.k
    public ImmutableMap<K, V> getAll(Iterable<? extends K> r10) throws ExecutionException {
        q0 r11 = this.localCache;
        h r5 = r11.f8758r;
        b r12 = r11.f8757q;
        LinkedHashMap r13 = new LinkedHashMap();
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator<? extends K> r15 = r10.iterator();
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r15.hasNext() == false) goto L34;
        K r18 = r15.next();
        Object r19 = r11.get(r18);
        if (r13.containsKey(r18) == true) goto L4;
        r13.put(r18, r19);
        if (r19 == null) goto L9;
        r16 = r16 + 1;
        goto L4
    L9:
        r17 = r17 + 1;
        r14.add(r18);
        goto L4
    L34:
    L19:
        th = move-exception;
        r12.a(r16);
        r12.b(r17);
        throw th;
    L12:
        if (r14.isEmpty() == false) goto L32;
    L27:
        ImmutableMap<K, V> r20 = ImmutableMap.copyOf(r13);     // Catch: Throwable -> L19
        r12.a(r16);
        r12.b(r17);
        return r20;
    L32:
        Map r110 = r11.g(Collections.unmodifiableSet(r14), r5);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        Iterator r21 = r14.iterator();     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
    L15:
        if (r21.hasNext() == false) goto L27;
        Object r22 = r21.next();     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        Object r23 = r110.get(r22);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        if (r23 == null) goto L21;
        r13.put(r22, r23);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        goto L15
    L21:
        String r24 = String.valueOf(r22);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        StringBuilder r25 = new StringBuilder(r24.length() + 37);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        r25.append("loadAll failed to return a value for ");     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        r25.append(r24);     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
        throw new CacheLoader$InvalidCacheLoadException(r25.toString());     // Catch: Throwable -> L19 CacheLoader$UnsupportedLoadingOperationException -> L23
    L23:
        Iterator r111 = r14.iterator();     // Catch: Throwable -> L19
    L25:
        if (r111.hasNext() == false) goto L27;
        Object r26 = r111.next();     // Catch: Throwable -> L19
        r17 = r17 - 1;     // Catch: Throwable -> L19
        r26.getClass();     // Catch: Throwable -> L19
        int r27 = r11.e(r26);     // Catch: Throwable -> L19
        r13.put(r26, r11.i(r27).get(r26, r27, r5));     // Catch: Throwable -> L19
        goto L25
    }

    @Override // com.google.common.cache.k
    public V getUnchecked(K r5) {
        return get(r5);
    L4:
        e = move-exception;
        throw new UncheckedExecutionException(e.getCause());
    }

    @Override // com.google.common.cache.k
    public void refresh(K r5) {
        q0 r10 = this.localCache;
        r10.getClass();
        r5.getClass();
        int r11 = r10.e(r5);
        r10.i(r11).refresh(r5, r11, r10.f8758r, false);
    }

    @Override // com.google.common.cache.LocalCache$LocalManualCache
    public Object writeReplace() {
        return new LocalCache$LoadingSerializationProxy(this.localCache);
    }
}
