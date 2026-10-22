package org.ehcache.config;

import java.util.function.UnaryOperator;
import org.ehcache.config.f;

/* JADX INFO: loaded from: classes7.dex */
public interface f<K, V, B extends f<K, V, ?>> extends a<b<K, V>> {
    @Override // org.ehcache.config.a
    /* synthetic */ default Object a() {
        return b();
    }

    B a(ClassLoader r1);

    B a(UnaryOperator<i> r1);

    B a(org.ehcache.spi.service.d<?, ?> r1);

    b<K, V> b();
}
