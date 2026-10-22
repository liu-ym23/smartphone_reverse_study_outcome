package org.ehcache.spi.resilience;

/* JADX INFO: loaded from: classes7.dex */
public interface c extends org.ehcache.spi.service.c {
    <K, V> b<K, V> a(String r1, org.ehcache.config.b<K, V> r2, a<K> r3);

    <K, V> b<K, V> a(String r1, org.ehcache.config.b<K, V> r2, a<K> r3, org.ehcache.spi.loaderwriter.a<? super K, V> r4);
}
