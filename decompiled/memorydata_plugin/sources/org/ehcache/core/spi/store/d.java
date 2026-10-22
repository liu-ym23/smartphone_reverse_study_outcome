package org.ehcache.core.spi.store;

import java.util.Collection;

/* JADX INFO: loaded from: classes7.dex */
public interface d<K, V> extends Store<K, V> {

    @org.ehcache.spi.service.b
    public interface a extends Store.c {
        int a(Collection<org.ehcache.spi.service.d<?, ?>> r1);
    }
}
