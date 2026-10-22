package org.ehcache.spi.serialization;

import org.ehcache.spi.service.c;
import org.ehcache.spi.service.d;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends c {
    <T> b<T> a(Class<T> r1, ClassLoader r2, d<?, ?>... r3);

    void a(b<?> r1);

    <T> b<T> b(Class<T> r1, ClassLoader r2, d<?, ?>... r3);
}
