package org.ehcache.core.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.config.e;
import org.ehcache.config.i;
import org.ehcache.core.spi.store.Store;

/* JADX INFO: loaded from: classes7.dex */
public class a<K, V> implements Store.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<K> f18023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<V> f18024b;
    private final e<? super K, ? super V> c;
    private final ClassLoader d;
    private final org.ehcache.a.a<? super K, ? super V> e;
    private final i f;
    private final org.ehcache.spi.serialization.b<K> g;
    private final org.ehcache.spi.serialization.b<V> h;
    private final int i;
    private final boolean j;
    private final org.ehcache.spi.loaderwriter.a<? super K, V> k;
    private final boolean l;

    public a(Class<K> r3, Class<V> r4, e<? super K, ? super V> r5, ClassLoader r6, org.ehcache.a.a<? super K, ? super V> r7, i r8, int r9, boolean r10, org.ehcache.spi.serialization.b<K> r11, org.ehcache.spi.serialization.b<V> r12, org.ehcache.spi.loaderwriter.a<? super K, V> r13, boolean r14) {
        e<? super K, ? super V> r15 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        org.ehcache.a.a<? super K, ? super V> r16 = (org.ehcache.a.a) ZeusTransformUtils.wrapperContextForParams(r7, org.ehcache.a.a.class, "com.obric.memorydata.plugin");
        i r17 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.serialization.b<K> r18 = (org.ehcache.spi.serialization.b) ZeusTransformUtils.wrapperContextForParams(r11, org.ehcache.spi.serialization.b.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.serialization.b<V> r19 = (org.ehcache.spi.serialization.b) ZeusTransformUtils.wrapperContextForParams(r12, org.ehcache.spi.serialization.b.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.loaderwriter.a<? super K, V> r110 = (org.ehcache.spi.loaderwriter.a) ZeusTransformUtils.wrapperContextForParams(r13, org.ehcache.spi.loaderwriter.a.class, "com.obric.memorydata.plugin");
        this.f18023a = r3;
        this.f18024b = r4;
        this.c = r15;
        this.d = r6;
        this.e = r16;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r9;
        this.j = r10;
        this.k = r110;
        this.l = r14;
    }

    public a(org.ehcache.config.b<K, V> r17, int r18, boolean r19, org.ehcache.spi.serialization.b<K> r20, org.ehcache.spi.serialization.b<V> r21, org.ehcache.spi.loaderwriter.a<? super K, V> r22, boolean r23) {
        org.ehcache.config.b r0 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r17, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.serialization.b r12 = (org.ehcache.spi.serialization.b) ZeusTransformUtils.wrapperContextForParams(r20, org.ehcache.spi.serialization.b.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.serialization.b r13 = (org.ehcache.spi.serialization.b) ZeusTransformUtils.wrapperContextForParams(r21, org.ehcache.spi.serialization.b.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.loaderwriter.a r14 = (org.ehcache.spi.loaderwriter.a) ZeusTransformUtils.wrapperContextForParams(r22, org.ehcache.spi.loaderwriter.a.class, "com.obric.memorydata.plugin");
        this(r0.b(), r0.c(), r0.d(), r0.e(), r0.f(), r0.g(), r18, r19, r12, r13, r14, r23);
    }
}
