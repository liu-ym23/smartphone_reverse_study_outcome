package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.core.spi.store.Store;

/* JADX INFO: loaded from: classes7.dex */
public class d<K, V> extends e<K, V> {
    private final org.ehcache.spi.loaderwriter.a<? super K, V> q;

    public d(org.ehcache.config.b<K, V> r10, Store<K, V> r11, org.ehcache.spi.resilience.b<K, V> r12, org.ehcache.core.b.a<K, V> r13, org.slf4j.c r14, org.ehcache.spi.loaderwriter.a<? super K, V> r15) {
        org.ehcache.config.b r16 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r10, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        Store r4 = (Store) ZeusTransformUtils.wrapperContextForParams(r11, Store.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.resilience.b r5 = (org.ehcache.spi.resilience.b) ZeusTransformUtils.wrapperContextForParams(r12, org.ehcache.spi.resilience.b.class, "com.obric.memorydata.plugin");
        org.ehcache.core.b.a r6 = (org.ehcache.core.b.a) ZeusTransformUtils.wrapperContextForParams(r13, org.ehcache.core.b.a.class, "com.obric.memorydata.plugin");
        org.slf4j.c r7 = (org.slf4j.c) ZeusTransformUtils.wrapperContextForParams(r14, org.slf4j.c.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.loaderwriter.a<? super K, V> r17 = (org.ehcache.spi.loaderwriter.a) ZeusTransformUtils.wrapperContextForParams(r15, org.ehcache.spi.loaderwriter.a.class, "com.obric.memorydata.plugin");
        super(new g(r16), r4, r5, r6, r7, new i(r7));
        this.q = r17;
    }

    @Override // org.ehcache.core.e
    public Store.PutStatus b(K r1, V r2) {
        return this.c.a(r1, r2);
    }

    @Override // org.ehcache.core.e
    public Store.d<V> b(K r1) {
        return this.c.a(r1);
    }

    @Override // org.ehcache.core.e
    public Store.RemoveStatus c(K r1, V r2) {
        return this.c.b(r1, r2);
    }
}
