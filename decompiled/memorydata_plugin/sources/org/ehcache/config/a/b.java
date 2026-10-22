package org.ehcache.config.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.ehcache.b;
import org.ehcache.config.g;
import org.ehcache.core.f;

/* JADX INFO: loaded from: classes7.dex */
public class b<T extends org.ehcache.b> implements org.ehcache.config.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<?> f17997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<org.ehcache.spi.service.c> f17998b;

    private b() {
        this.f17997a = d.b();
        this.f17998b = Collections.emptySet();
    }

    private b(b<T> r3, g<?> r4) {
        this.f17997a = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        this.f17998b = r3.f17998b;
    }

    public static c<org.ehcache.c> a(File r1) {
        return new org.ehcache.impl.config.a.a(r1);
    }

    public static b<org.ehcache.b> c() {
        return new b();
    }

    @Override // org.ehcache.config.a
    public /* synthetic */ Object a() {
        return b();
    }

    T a(Collection<org.ehcache.spi.service.c> r3, org.ehcache.config.d r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return (T) a(new f((org.ehcache.config.d) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.config.d.class, "com.obric.memorydata.plugin"), r5));
    }

    T a(f r1) {
        return r1;
    }

    public T a(boolean r5) {
        T r4 = (T) a(this.f17998b, (org.ehcache.config.d) ZeusTransformUtils.preCheckCast(this.f17997a.a(), org.ehcache.config.d.class, "com.obric.memorydata.plugin"));
        if (r5 == false) goto L5;
        r4.a();
    L5:
        return r4;
    }

    public <N extends T> b<N> a(c<N> r3) {
        return ((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).a(this);
    }

    public b<T> a(org.ehcache.spi.service.e<?, ?> r3) {
        org.ehcache.spi.service.e<?, ?> r4 = (org.ehcache.spi.service.e) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.spi.service.e.class, "com.obric.memorydata.plugin");
        return new b(this, this.f17997a.a(r4));
    }

    public T b() {
        return (T) a(false);
    }
}
