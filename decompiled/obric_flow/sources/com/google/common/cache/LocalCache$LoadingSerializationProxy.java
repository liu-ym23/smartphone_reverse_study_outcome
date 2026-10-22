package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
final class LocalCache$LoadingSerializationProxy<K, V> extends LocalCache$ManualSerializationProxy<K, V> implements k, Serializable {
    private static final long serialVersionUID = 1;
    transient k autoDelegate;

    public LocalCache$LoadingSerializationProxy(q0 r5) {
        super(r5);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        f r10 = recreateCacheBuilder();
        h r11 = this.loader;
        r10.a();
        this.autoDelegate = new LocalCache$LocalLoadingCache(r10, r11);
    }

    private Object readResolve() {
        return this.autoDelegate;
    }

    @Override // com.google.common.cache.k, java.util.function.Function
    public final V apply(K r5) {
        return (V) this.autoDelegate.apply(r5);
    }

    @Override // com.google.common.cache.k
    public V get(K r5) throws ExecutionException {
        return (V) this.autoDelegate.get(r5);
    }

    @Override // com.google.common.cache.k
    public ImmutableMap<K, V> getAll(Iterable<? extends K> r5) throws ExecutionException {
        return this.autoDelegate.getAll(r5);
    }

    @Override // com.google.common.cache.k
    public V getUnchecked(K r5) {
        return (V) this.autoDelegate.getUnchecked(r5);
    }

    @Override // com.google.common.cache.k
    public void refresh(K r5) {
        this.autoDelegate.refresh(r5);
    }
}
