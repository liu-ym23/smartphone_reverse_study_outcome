package org.ehcache.core.spi.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.ehcache.spi.service.c;
import org.ehcache.spi.service.e;

/* JADX INFO: loaded from: classes7.dex */
public interface c<T extends org.ehcache.spi.service.c> {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    T a(e<T, ?> r1);

    default boolean a() {
        return false;
    }

    default int b() {
        return 1;
    }

    Class<? extends T> c();
}
