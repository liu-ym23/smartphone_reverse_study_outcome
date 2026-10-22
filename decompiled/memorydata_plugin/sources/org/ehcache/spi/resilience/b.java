package org.ehcache.spi.resilience;

/* JADX INFO: loaded from: classes7.dex */
public interface b<K, V> {
    V a(K r1, StoreAccessException r2);

    org.ehcache.a.InterfaceC0893a<K, V> a(StoreAccessException r1);

    void a(K r1, V r2, StoreAccessException r3);

    boolean b(K r1, V r2, StoreAccessException r3);
}
