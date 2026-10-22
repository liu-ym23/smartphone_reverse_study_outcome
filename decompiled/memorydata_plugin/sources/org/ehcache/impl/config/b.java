package org.ehcache.impl.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import org.ehcache.config.e;
import org.ehcache.config.f;
import org.ehcache.config.i;

/* JADX INFO: loaded from: classes7.dex */
public class b<K, V> implements org.ehcache.config.b<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<K> f18067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<V> f18068b;
    private final e<? super K, ? super V> c;
    private final Collection<org.ehcache.spi.service.d<?, ?>> d;
    private final ClassLoader e;
    private final org.ehcache.a.a<? super K, ? super V> f;
    private final i g;

    public b(Class<K> r3, Class<V> r4, e<? super K, ? super V> r5, ClassLoader r6, org.ehcache.a.a<? super K, ? super V> r7, i r8, org.ehcache.spi.service.d<?, ?>... r9) {
        e<? super K, ? super V> r10 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        org.ehcache.a.a<? super K, ? super V> r11 = (org.ehcache.a.a) ZeusTransformUtils.wrapperContextForParams(r7, org.ehcache.a.a.class, "com.obric.memorydata.plugin");
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "keyType cannot be null");
        Objects.requireNonNull(r4, "valueType cannot be null");
        Objects.requireNonNull(r12, "resourcePools cannot be null");
        this.f18067a = r3;
        this.f18068b = r4;
        this.c = r10;
        this.e = r6;
        if (r11 == null) goto L5;
        this.f = r11;
    L6:
        this.g = r12;
        this.d = Collections.unmodifiableCollection(Arrays.asList(r9));
        return;
    L5:
        this.f = org.ehcache.a.a.f17994b;
        goto L6
    }

    @Override // org.ehcache.config.b
    public Collection<org.ehcache.spi.service.d<?, ?>> a() {
        return this.d;
    }

    @Override // org.ehcache.config.b
    public Class<K> b() {
        return this.f18067a;
    }

    @Override // org.ehcache.config.b
    public Class<V> c() {
        return this.f18068b;
    }

    @Override // org.ehcache.config.b
    public e<? super K, ? super V> d() {
        return this.c;
    }

    @Override // org.ehcache.config.b
    public ClassLoader e() {
        return this.e;
    }

    @Override // org.ehcache.config.b
    public org.ehcache.a.a<? super K, ? super V> f() {
        return this.f;
    }

    @Override // org.ehcache.config.b
    public i g() {
        return this.g;
    }

    @Override // org.ehcache.config.b
    public /* synthetic */ f h() {
        return i();
    }

    public org.ehcache.config.a.a<K, V> i() {
        return org.ehcache.config.a.a.a(this);
    }
}
