package org.ehcache.spi.loaderwriter;

/* JADX INFO: loaded from: classes7.dex */
public interface b<R> extends org.ehcache.spi.service.d<c, R> {
    @Override // org.ehcache.spi.service.d
    default Class<c> b() {
        return c.class;
    }
}
