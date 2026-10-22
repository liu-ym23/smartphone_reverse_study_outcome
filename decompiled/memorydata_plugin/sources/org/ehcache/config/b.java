package org.ehcache.config;

import java.util.Collection;

/* JADX INFO: loaded from: classes7.dex */
public interface b<K, V> {
    Collection<org.ehcache.spi.service.d<?, ?>> a();

    Class<K> b();

    Class<V> c();

    e<? super K, ? super V> d();

    ClassLoader e();

    org.ehcache.a.a<? super K, ? super V> f();

    i g();

    default f<K, V, ?> h() {
        throw new UnsupportedOperationException();
    }
}
