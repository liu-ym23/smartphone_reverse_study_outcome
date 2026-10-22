package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.ehcache.event.EventFiring;
import org.ehcache.event.EventOrdering;
import org.ehcache.event.EventType;

/* JADX INFO: loaded from: classes7.dex */
class g<K, V> implements org.ehcache.config.c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.ehcache.config.b<K, V> f18048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<org.ehcache.spi.service.d<?, ?>> f18049b;
    private volatile org.ehcache.config.i c;
    private final List<b> d;

    g(org.ehcache.config.b<K, V> r3) {
        org.ehcache.config.b<K, V> r4 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        this.f18049b = new ArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f18048a = r4;
        this.c = r4.g();
    }

    private /* synthetic */ org.ehcache.config.i a(org.ehcache.config.i r3) {
        org.ehcache.config.i r4 = (org.ehcache.config.i) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.i.class, "com.obric.memorydata.plugin");
        return this.c;
    }

    private <T> void a(CacheConfigurationProperty r4, T r5, T r6) {
        if (r5 != null) goto L4;
    L5:
        if (r6 == null) goto L10;
    L6:
        Iterator<b> r3 = this.d.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(new a(r4, r5, r6));
        goto L8
    L12:
        return;
    L10:
        return;
    L4:
        if (r5.equals(r6) == false) goto L6;
        goto L5
    }

    /* JADX INFO: renamed from: lambda$XtnYx_F__9V-g50Q1O-sfLKgbTg, reason: not valid java name */
    public static /* synthetic */ org.ehcache.config.i m3194lambda$XtnYx_F__9Vg50Q1OsfLKgbTg(g r0, org.ehcache.config.i r1) {
        return r0.a(r1);
    }

    @Override // org.ehcache.config.b
    public Collection<org.ehcache.spi.service.d<?, ?>> a() {
        ArrayList r0 = new ArrayList(this.f18048a.a());
        r0.addAll(this.f18049b);
        return Collections.unmodifiableCollection(r0);
    }

    @Override // org.ehcache.config.c
    public synchronized void a(org.ehcache.event.a<? super K, ? super V> r3, EventOrdering r4, EventFiring r5, Set<EventType> r6) {
        monitor-enter(this);
        org.ehcache.core.b.f r0 = new org.ehcache.core.b.f((org.ehcache.event.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.event.a.class, "com.obric.memorydata.plugin"), r5, r4, EnumSet.copyOf((Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L6
        a(CacheConfigurationProperty.ADD_LISTENER, r0, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean a(List<b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return this.d.addAll(r4);
    }

    @Override // org.ehcache.config.b
    public Class<K> b() {
        return this.f18048a.b();
    }

    @Override // org.ehcache.config.b
    public Class<V> c() {
        return this.f18048a.c();
    }

    @Override // org.ehcache.config.b
    public org.ehcache.config.e<? super K, ? super V> d() {
        return this.f18048a.d();
    }

    @Override // org.ehcache.config.b
    public ClassLoader e() {
        return this.f18048a.e();
    }

    @Override // org.ehcache.config.b
    public org.ehcache.a.a<? super K, ? super V> f() {
        return this.f18048a.f();
    }

    @Override // org.ehcache.config.b
    public org.ehcache.config.i g() {
        return this.c;
    }

    @Override // org.ehcache.config.b
    public org.ehcache.config.f<K, V, ?> h() {
        org.ehcache.config.f<K, V, ?> r0 = this.f18048a.h();
        Iterator<org.ehcache.spi.service.d<?, ?>> r1 = this.f18049b.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = r0.a((org.ehcache.spi.service.d) ZeusTransformUtils.preCheckCast(r1.next(), org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return r0.a(new $$Lambda$g$XtnYx_F__9Vg50Q1OsfLKgbTg(this));
    }
}
