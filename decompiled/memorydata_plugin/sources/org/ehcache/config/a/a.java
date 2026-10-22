package org.ehcache.config.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.UnaryOperator;
import org.ehcache.config.f;
import org.ehcache.config.i;

/* JADX INFO: loaded from: classes7.dex */
public class a<K, V> implements f<K, V, a<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<org.ehcache.spi.service.d<?, ?>> f17995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private org.ehcache.a.a<? super K, ? super V> f17996b;
    private ClassLoader c;
    private org.ehcache.config.e<? super K, ? super V> d;
    private i e;
    private final Class<K> f;
    private final Class<V> g;

    private a(Class<K> r3, Class<V> r4, i r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
        this.f17995a = new HashSet();
        this.c = null;
        this.f = r3;
        this.g = r4;
        this.e = r6;
    }

    private a(a<K, V> r3) {
        HashSet r0 = new HashSet();
        this.f17995a = r0;
        this.c = null;
        this.f = r3.f;
        this.g = r3.g;
        this.f17996b = r3.f17996b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        r0.addAll(r3.f17995a);
    }

    public static <K, V> a<K, V> a(Class<K> r3, Class<V> r4, org.ehcache.config.a<? extends i> r5) {
        return new a(r3, r4, (i) ZeusTransformUtils.preCheckCast(((org.ehcache.config.a) ZeusTransformUtils.wrapperContextForParams(r5, org.ehcache.config.a.class, "com.obric.memorydata.plugin")).a(), i.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> a<K, V> a(Class<K> r2, Class<V> r3, i r4) {
        return new a(r2, r3, (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> a<K, V> a(org.ehcache.config.b<K, V> r4) {
        org.ehcache.config.b r5 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = a(r5.b(), r5.c(), r5.g()).a(r5.d()).a(r5.f());
        ClassLoader r2 = r5.e();
        if (r2 == null) goto L5;
        r0 = r0.b(r2);
    L5:
        Iterator<org.ehcache.spi.service.d<?, ?>> r6 = r5.a().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r0 = r0.b((org.ehcache.spi.service.d) ZeusTransformUtils.preCheckCast(r6.next(), org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        return r0;
    }

    private static /* synthetic */ boolean a(org.ehcache.spi.service.d r2, org.ehcache.spi.service.d r3) {
        org.ehcache.spi.service.d r4 = (org.ehcache.spi.service.d) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.service.d<?, ?> r5 = (org.ehcache.spi.service.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin");
        if (r5.a(r4) == true) goto L5;
    L8:
        return true;
    L5:
        if (r4.a(r5) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: lambda$SEMRwYj7JGXH8fEIJiTGBDBYz-U, reason: not valid java name */
    public static /* synthetic */ boolean m3192lambda$SEMRwYj7JGXH8fEIJiTGBDBYzU(org.ehcache.spi.service.d r0, org.ehcache.spi.service.d r1) {
        return a(r0, r1);
    }

    @Override // org.ehcache.config.f, org.ehcache.config.a
    public /* synthetic */ Object a() {
        return b();
    }

    public a<K, V> a(org.ehcache.a.a<? super K, ? super V> r3) {
        org.ehcache.a.a<? super K, ? super V> r4 = (org.ehcache.a.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.a.a.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Null expiry");
        a<K, V> r0 = new a(this);
        r0.f17996b = r4;
        return r0;
    }

    public a<K, V> a(org.ehcache.config.e<? super K, ? super V> r3) {
        org.ehcache.config.e<? super K, ? super V> r4 = (org.ehcache.config.e) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.e.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = new a(this);
        r0.d = r4;
        return r0;
    }

    @Override // org.ehcache.config.f
    public /* synthetic */ f a(ClassLoader r1) {
        return b(r1);
    }

    @Override // org.ehcache.config.f
    public /* synthetic */ f a(UnaryOperator r3) {
        return b((UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r3, UnaryOperator.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.ehcache.config.f
    public /* synthetic */ f a(org.ehcache.spi.service.d r3) {
        return b((org.ehcache.spi.service.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin"));
    }

    public a<K, V> b(ClassLoader r3) {
        a<K, V> r0 = new a(this);
        r0.c = (ClassLoader) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), ClassLoader.class, "com.obric.memorydata.plugin");
        return r0;
    }

    public a<K, V> b(UnaryOperator<i> r3) {
        UnaryOperator r4 = (UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r3, UnaryOperator.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = new a(this);
        r0.e = (i) ZeusTransformUtils.preCheckCast(r4.apply(this.e), i.class, "com.obric.memorydata.plugin");
        return r0;
    }

    public a<K, V> b(org.ehcache.spi.service.d<?, ?> r3) {
        final org.ehcache.spi.service.d<?, ?> r4 = (org.ehcache.spi.service.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = new a(this);
        r0.f17995a.removeIf(new $$Lambda$a$SEMRwYj7JGXH8fEIJiTGBDBYzU(r4));
        r0.f17995a.add(r4);
        return r0;
    }

    @Override // org.ehcache.config.f
    public org.ehcache.config.b<K, V> b() {
        Class<K> r1 = this.f;
        Class<V> r2 = this.g;
        org.ehcache.config.e<? super K, ? super V> r3 = this.d;
        ClassLoader r4 = this.c;
        org.ehcache.a.a<? super K, ? super V> r5 = this.f17996b;
        i r6 = this.e;
        Collection<org.ehcache.spi.service.d<?, ?>> r9 = this.f17995a;
        return new org.ehcache.impl.config.b(r1, r2, r3, r4, r5, r6, (org.ehcache.spi.service.d[]) ZeusTransformUtils.preCheckCast(r9.toArray(new org.ehcache.spi.service.d[r9.size()]), org.ehcache.spi.service.d[].class, "com.obric.memorydata.plugin"));
    }
}
