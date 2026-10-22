package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import org.ehcache.CachePersistenceException;
import org.ehcache.config.ResourceType;
import org.ehcache.core.spi.ServiceLocator;
import org.ehcache.core.spi.store.Store;
import org.ehcache.spi.serialization.UnsupportedTypeException;

/* JADX INFO: loaded from: classes7.dex */
public class f implements org.ehcache.c, org.ehcache.core.spi.store.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.slf4j.c f18027b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ServiceLocator f18028a;
    private final org.ehcache.core.a.b c;
    private final ClassLoader d;
    private final boolean e;
    private final ConcurrentMap<String, a> f;
    private final CopyOnWriteArrayList<org.ehcache.core.b.e> g;
    private final i h;
    private final String i;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f18044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f18045b;
        private volatile h<?, ?> c;
        private volatile boolean d;

        a(Class<?> r2, Class<?> r3) {
            this.d = false;
            this.f18044a = r2;
            this.f18045b = r3;
        }

        static /* synthetic */ Class a(a r0) {
            return r0.f18044a;
        }

        static /* synthetic */ Class b(a r0) {
            return r0.f18045b;
        }

        private static <K, V> h<K, V> b(h<?, ?> r2) {
            return (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        }

        <K, V> h<K, V> a(Class<K> r3, Class<V> r4) {
            if (this.d == true) goto L24;
            monitor-enter(this);
            boolean r0 = false;
        L33:
        L15:
            th = move-exception;
            throw th;
        L17:
            th = move-exception;
            if (r0 == false) goto L20;
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L20:
            throw th;     // Catch: Throwable -> L15
        L7:
            if (this.d == true) goto L11;
            wait();     // Catch: InterruptedException -> L10 Throwable -> L17
        L10:
            r0 = true;
            goto L33
        L11:
            if (r0 == false) goto L13;
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(this);     // Catch: Throwable -> L15
        L24:
            if (this.f18044a != r3) goto L30;
            if (this.f18045b != r4) goto L30;
            return b(this.c);
        L30:
            throw new IllegalArgumentException();
        }

        public synchronized void a(h<?, ?> r3) {
            monitor-enter(this);
            this.c = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            this.d = true;     // Catch: Throwable -> L6
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        f18027b = org.slf4j.d.a(f.class);
    }

    public f(org.ehcache.config.d r3, Collection<org.ehcache.spi.service.c> r4) {
        this((org.ehcache.config.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.d.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"), true);
    }

    public f(org.ehcache.config.d r3, Collection<org.ehcache.spi.service.c> r4, boolean r5) {
        org.ehcache.config.d r6 = (org.ehcache.config.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.d.class, "com.obric.memorydata.plugin");
        final Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        this(r6, new $$Lambda$f$_jGh2sZVd9PHToElA2iyFMdTv7E(r7), r5);
    }

    public f(org.ehcache.config.d r3, UnaryOperator<ServiceLocator.a> r4, boolean r5) {
        org.ehcache.config.d r6 = (org.ehcache.config.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.config.d.class, "com.obric.memorydata.plugin");
        UnaryOperator<ServiceLocator.a> r7 = (UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, UnaryOperator.class, "com.obric.memorydata.plugin");
        this.f = new ConcurrentHashMap();
        this.g = new CopyOnWriteArrayList();
        this.h = new i(f18027b);
        String r0 = getClass().getSimpleName();
        if (r0.isEmpty() == false) goto L5;
        r0 = getClass().getName();
    L5:
        this.i = r0;
        this.c = new org.ehcache.core.a.b(r6);
        if (r6.c() == null) goto L8;
        ClassLoader r8 = r6.c();
    L9:
        this.d = r8;
        this.e = r5;
        b();
        this.f18028a = a(r7);
        return;
    L8:
        r8 = org.ehcache.core.f.a.a();
        goto L9
    }

    private static /* synthetic */ Boolean a(org.ehcache.config.b r2) {
        boolean r0 = true;
        if (((org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.config.b.class, "com.obric.memorydata.plugin")).g().a().size() > 1) goto L7;
        r0 = false;
    L7:
        return Boolean.valueOf(r0);
    }

    private <K, V> org.ehcache.a<K, V> a(String r8, org.ehcache.config.b<K, V> r9, boolean r10) {
        org.ehcache.config.b<K, V> r11 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r9, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        this.h.c();
        f18027b.debug("Creating Cache '{}' in {}.", r8, this.i);
        org.ehcache.config.b<K, V> r0 = b(r8, r11);
        Class<K> r2 = r0.b();
        Class<V> r3 = r0.c();
        a r4 = new a(r2, r3);
        if (this.f.putIfAbsent(r8, r4) != null) goto L35;
        RuntimeException r5 = null;
        h<K, V> r1 = a(r8, r0, r2, r3);     // Catch: Throwable -> L13 RuntimeException -> L16
        r1.b();     // Catch: RuntimeException -> L11 Throwable -> L13
        if (r10 == false) goto L9;
        this.c.a(r8, r1.a());     // Catch: RuntimeException -> L11 Throwable -> L13
    L36:
    L19:
        if (r5 != null) goto L33;
    L29:
        th = move-exception;
        r4.a(r1);
        throw th;
    L21:
        if (this.h.b() == true) goto L27;
        Iterator<org.ehcache.core.b.e> r12 = this.g.iterator();     // Catch: Throwable -> L29
    L24:
        if (r12.hasNext() == false) goto L27;
        ((org.ehcache.core.b.e) ZeusTransformUtils.preCheckCast(r12.next(), org.ehcache.core.b.e.class, "com.obric.memorydata.plugin")).a(r8, r1);     // Catch: Throwable -> L29
    L27:
        r4.a(r1);
        f18027b.info("Cache '{}' created in {}.", r8, this.i);
        return r1;
    L33:
        throw new IllegalStateException("Cache '" + r8 + "' creation in " + this.i + " failed.", r5);
    L9:
        this.c.a(r8, r11, r1.a());     // Catch: RuntimeException -> L11 Throwable -> L13
    L11:
        e = e;
    L18:
        this.f.remove(r8);
        r4.a(null);
        r5 = e;
    L13:
        th = move-exception;
        this.f.remove(r8);
        r4.a(null);
        throw th;
    L16:
        e = e;
        r1 = null;
        goto L18
    L35:
        throw new IllegalArgumentException("Cache '" + r8 + "' already exists");
    }

    private static /* synthetic */ ServiceLocator.a a(Collection r2, ServiceLocator.a r3) {
        return r3.a((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    private ServiceLocator a(UnaryOperator<ServiceLocator.a> r4) {
        ServiceLocator.a r5 = (ServiceLocator.a) ZeusTransformUtils.preCheckCast(((UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, UnaryOperator.class, "com.obric.memorydata.plugin")).apply(ServiceLocator.a().a(Store.c.class).a(org.ehcache.spi.loaderwriter.c.class).a(org.ehcache.spi.loaderwriter.d.class).a(org.ehcache.core.b.b.class).a(org.ehcache.core.b.d.class).a(org.ehcache.spi.resilience.c.class)), ServiceLocator.a.class, "com.obric.memorydata.plugin");
        if (r5.b(org.ehcache.core.spi.a.a.class) == true) goto L5;
        r5 = r5.a(new c(this));
    L5:
        Iterator<org.ehcache.spi.service.e<?, ?>> r3 = this.c.b().iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r5 = r5.a((org.ehcache.spi.service.e) ZeusTransformUtils.preCheckCast(r3.next(), org.ehcache.spi.service.e.class, "com.obric.memorydata.plugin"));
        goto L7
    L10:
        return r5.b();
    }

    private org.ehcache.spi.b.a a(ResourceType<?> r4) {
        ResourceType<?> r5 = (ResourceType) ZeusTransformUtils.wrapperContextForParams(r4, ResourceType.class, "com.obric.memorydata.plugin");
        Iterator r3 = this.f18028a.b(org.ehcache.spi.b.a.class).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        org.ehcache.spi.b.a r0 = (org.ehcache.spi.b.a) ZeusTransformUtils.preCheckCast(r3.next(), org.ehcache.spi.b.a.class, "com.obric.memorydata.plugin");
        if (r0.a(r5) == false) goto L4;
        return r0;
    L9:
        throw new IllegalStateException("No service found for persistable resource: " + r5);
    }

    private void a(String r5, boolean r6) {
        this.h.c();
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f.remove(r5), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L18;
        h<?, ?> r1 = r0.a(a.a(r0), a.b(r0));
        if (r1 == null) goto L15;
        if (r6 == false) goto L9;
        this.c.a(r5);
    L9:
        if (this.h.b() == true) goto L14;
        Iterator<org.ehcache.core.b.e> r7 = this.g.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((org.ehcache.core.b.e) ZeusTransformUtils.preCheckCast(r7.next(), org.ehcache.core.b.e.class, "com.obric.memorydata.plugin")).b(r5, r1);
    L14:
        r1.close();
        a(r5, r1);
    L15:
        f18027b.info("Cache '{}' removed from {}.", r5, this.i);
        return;
    }

    private <K, V> org.ehcache.config.b<K, V> b(String r4, org.ehcache.config.b<K, V> r5) {
        org.ehcache.config.b<K, V> r6 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r5, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        if (r6.e() != null) goto L8;
        if (this.d == null) goto L8;
        r6 = r6.h().a(this.d).b();
    L8:
        if (((org.ehcache.spi.loaderwriter.b) ZeusTransformUtils.preCheckCast(org.ehcache.core.spi.a.d.b(org.ehcache.spi.loaderwriter.b.class, r6.a()), org.ehcache.spi.loaderwriter.b.class, "com.obric.memorydata.plugin")) != null) goto L16;
        org.ehcache.spi.loaderwriter.c r0 = (org.ehcache.spi.loaderwriter.c) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.spi.loaderwriter.c.class), org.ehcache.spi.loaderwriter.c.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.loaderwriter.b<?> r1 = r0.a(r4);
        if (r1 == null) goto L13;
        r6 = r6.h().a(r1).b();
    L13:
        if (r0.b(r4) == true) goto L15;
        return r6;
    L15:
        return r6.h().a(new AnonymousClass8(this)).b();
    L16:
        return r6;
    }

    private void b() {
        HashSet r0 = new HashSet();
        Iterator<org.ehcache.spi.service.e<?, ?>> r4 = this.c.b().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        org.ehcache.spi.service.e r1 = (org.ehcache.spi.service.e) ZeusTransformUtils.preCheckCast(r4.next(), org.ehcache.spi.service.e.class, "com.obric.memorydata.plugin");
        if (r0.add(r1.a()) == true) goto L4;
        throw new IllegalStateException("Duplicate creation configuration for service " + r1.a());
    }

    public static /* synthetic */ ServiceLocator.a lambda$_jGh2sZVd9PHToElA2iyFMdTv7E(Collection r0, ServiceLocator.a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Boolean lambda$y5iJXvktMOfvnrRRBhVTDSj9y6s(org.ehcache.config.b r0) {
        return a(r0);
    }

    @Override // org.ehcache.b
    public <K, V> org.ehcache.a<K, V> a(String r3, org.ehcache.config.b<K, V> r4) {
        return a(r3, (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.config.b.class, "com.obric.memorydata.plugin"), true);
    }

    <K, V> h<K, V> a(final String r16, org.ehcache.config.b<K, V> r17, Class<K> r18, Class<V> r19) {
        org.ehcache.config.b<K, V> r11 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r17, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        ArrayList r12 = new ArrayList(r11.a());
        ArrayList r0 = new ArrayList();
        Iterator<org.ehcache.spi.service.d<?, ?>> r1 = r12.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        org.ehcache.spi.service.d<?, ?> r2 = (org.ehcache.spi.service.d) ZeusTransformUtils.preCheckCast(r1.next(), org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin");
        if (this.f18028a.a(r2) == true) goto L4;
        r0.add(r2);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L36;
        ArrayList r13 = new ArrayList();
        final org.ehcache.spi.loaderwriter.c r3 = (org.ehcache.spi.loaderwriter.c) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.spi.loaderwriter.c.class), org.ehcache.spi.loaderwriter.c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        final org.ehcache.spi.loaderwriter.a<? super K, V> r4 = r3.a(r16, r11);
        if (r4 == null) goto L15;
        r13.add(new AnonymousClass1(this, r3, r16, r4));
    L15:
        org.ehcache.spi.loaderwriter.a<? super K, V> r14 = r4;
    L17:
        Store<K, V> r5 = a(r16, r11, r18, r19, r12, r13, r14);
        final org.ehcache.core.b.b r6 = (org.ehcache.core.b.b) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.core.b.b.class), org.ehcache.core.b.b.class, "com.obric.memorydata.plugin");
        final org.ehcache.core.b.a r15 = r6.a(r5, (org.ehcache.spi.service.d[]) ZeusTransformUtils.preCheckCast(r12.toArray(new org.ehcache.spi.service.d[r12.size()]), org.ehcache.spi.service.d[].class, "com.obric.memorydata.plugin"));
        r13.add(new AnonymousClass2(this, r6, r15));
        r15.a(r5.b());
        org.ehcache.spi.resilience.c r7 = (org.ehcache.spi.resilience.c) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.spi.resilience.c.class), org.ehcache.spi.resilience.c.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L20;
        org.ehcache.core.d.a r8 = new org.ehcache.core.d.a(r5);
        org.ehcache.spi.resilience.b<K, V> r9 = r7.a(r16, r11, r8);
    L21:
        d r10 = new d(r11, r5, r9, r15, org.slf4j.d.a(d.class + "-" + r16), r14);
        final org.ehcache.core.b.d r20 = (org.ehcache.core.b.d) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.core.b.d.class), org.ehcache.core.b.d.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L30;
        Iterator r21 = org.ehcache.core.spi.a.d.a(org.ehcache.core.b.c.class, r11.a()).iterator();
    L25:
        if (r21.hasNext() == false) goto L29;
        org.ehcache.core.b.c r22 = (org.ehcache.core.b.c) ZeusTransformUtils.preCheckCast(r21.next(), org.ehcache.core.b.c.class, "com.obric.memorydata.plugin");
        final org.ehcache.event.a<? super K, ? super V> r23 = r20.a(r16, r22);
        if (r23 == null) goto L25;
        r10.a().a(r23, r22.c(), r22.a(), r22.d());
        r13.add(new AnonymousClass3(this, r20, r23));
        goto L25
    L29:
        r15.a(r10);
    L30:
        Iterator<org.ehcache.core.spi.a> r24 = r13.iterator();
    L32:
        if (r24.hasNext() == false) goto L34;
        r10.a((org.ehcache.core.spi.a) ZeusTransformUtils.preCheckCast(r24.next(), org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin"));
        goto L32
    L34:
        return r10;
    L20:
        r8 = new org.ehcache.core.d.a(r5);
        r9 = r7.a(r16, r11, r8, r14);
        goto L21
    L16:
        r14 = null;
        goto L17
    L36:
        throw new IllegalStateException("Cannot find service(s) that can handle following configuration(s) : " + r0);
    }

    public <K, V> Store<K, V> a(String r17, org.ehcache.config.b<K, V> r18, Class<K> r19, Class<V> r20, Collection<org.ehcache.spi.service.d<?, ?>> r21, List<org.ehcache.core.spi.a> r22, org.ehcache.spi.loaderwriter.a<? super K, V> r23) {
        final org.ehcache.config.b<?, ?> r6 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r18, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r21, Collection.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.loaderwriter.a r11 = (org.ehcache.spi.loaderwriter.a) ZeusTransformUtils.wrapperContextForParams(r23, org.ehcache.spi.loaderwriter.a.class, "com.obric.memorydata.plugin");
        Set<ResourceType<?>> r15 = r6.g().a();
        Iterator<ResourceType<?>> r0 = r15.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ResourceType<?> r5 = (ResourceType) ZeusTransformUtils.preCheckCast(r0.next(), ResourceType.class, "com.obric.memorydata.plugin");
        if (r5.isPersistable() == false) goto L4;
        final org.ehcache.spi.b.a r7 = a(r5);
        final org.ehcache.spi.b.a.InterfaceC0896a<?> r8 = r7.a(r17, r6);     // Catch: CachePersistenceException -> L10
        r13.add(r8);     // Catch: CachePersistenceException -> L10
        r14.add(new AnonymousClass4(this, r7, r8));     // Catch: CachePersistenceException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to handle persistence", e);
    L13:
        final org.ehcache.spi.serialization.a r9 = (org.ehcache.spi.serialization.a) ZeusTransformUtils.preCheckCast(this.f18028a.a(org.ehcache.spi.serialization.a.class), org.ehcache.spi.serialization.a.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.service.d<?, ?>[] r12 = (org.ehcache.spi.service.d[]) ZeusTransformUtils.preCheckCast(r13.toArray(new org.ehcache.spi.service.d[r13.size()]), org.ehcache.spi.service.d[].class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L50;
        org.ehcache.spi.serialization.b r10 = null;
        org.ehcache.spi.serialization.b r16 = null;
    L41:
        Collection<org.ehcache.spi.service.d<?, ?>> r1 = r6.a();
        org.ehcache.core.e.a r2 = new org.ehcache.core.e.a(r6, ((Integer) ZeusTransformUtils.preCheckCast(org.ehcache.core.spi.a.d.c(org.ehcache.core.a.a.a.class, r1).map($$Lambda$QzFsVDJdL8XZzQHVBVGxFfIbX4.INSTANCE).orElse(1), Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Boolean) ZeusTransformUtils.preCheckCast(org.ehcache.core.spi.a.d.c(org.ehcache.core.a.a.b.class, r1).map($$Lambda$26NyJr9yZx3_GuO9oKG2uQLAI34.INSTANCE).orElseGet(new $$Lambda$f$y5iJXvktMOfvnrRRBhVTDSj9y6s(r6)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r10, r16, r11, this.e);
        Store.c r3 = org.ehcache.core.e.b.a(this.f18028a, r13);
        if (r3 != null) goto L44;
        r3 = org.ehcache.core.e.b.a(this.f18028a, r15, r13);
    L44:
        final Store<K, V> r4 = r3.a(r2, r12);
        final AtomicReference r24 = new AtomicReference(r3);
        r14.add(new AnonymousClass7(this, r24, r4));
        return r4;
    L50:
        final org.ehcache.spi.serialization.b r25 = r9.a(r19, r6.e(), r12);     // Catch: UnsupportedTypeException -> L17
        r14.add(new AnonymousClass5(this, r9, r25));     // Catch: UnsupportedTypeException -> L17
        org.ehcache.spi.serialization.b r26 = r25;
    L46:
        final org.ehcache.spi.serialization.b r27 = r9.b(r20, r6.e(), r12);     // Catch: UnsupportedTypeException -> L29
        r14.add(new AnonymousClass6(this, r9, r27));     // Catch: UnsupportedTypeException -> L29
        r16 = r27;
    L39:
        r10 = r26;
    L29:
        e = move-exception;
        Iterator<ResourceType<?>> r28 = r15.iterator();
    L32:
        if (r28.hasNext() == false) goto L38;
        if (((ResourceType) ZeusTransformUtils.preCheckCast(r28.next(), ResourceType.class, "com.obric.memorydata.plugin")).requiresSerialization() == false) goto L32;
        throw new RuntimeException(e);
    L38:
        f18027b.debug("Could not create serializers for {}", r17, e);
        r16 = null;
    L17:
        e = move-exception;
        Iterator<ResourceType<?>> r29 = r15.iterator();
    L20:
        if (r29.hasNext() == false) goto L26;
        if (((ResourceType) ZeusTransformUtils.preCheckCast(r29.next(), ResourceType.class, "com.obric.memorydata.plugin")).requiresSerialization() == false) goto L20;
        throw new RuntimeException(e);
    L26:
        f18027b.debug("Could not create serializers for {}", r17, e);
        r26 = null;
        goto L46
    }

    @Override // org.ehcache.b
    public void a() {
        i.a r1 = this.h.d();
        this.f18028a.b();     // Catch: Throwable -> L27 Exception -> L29
        ArrayDeque r3 = new ArrayDeque();     // Catch: Throwable -> L27 Exception -> L29
        Iterator<Map.Entry<String, org.ehcache.config.b<?, ?>>> r5 = this.c.a().entrySet().iterator();     // Catch: RuntimeException -> L13 Throwable -> L27 Exception -> L29
    L7:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L13 Throwable -> L27 Exception -> L29
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L13 Throwable -> L27 Exception -> L29
        a(r7, (org.ehcache.config.b) ZeusTransformUtils.preCheckCast(r6.getValue(), org.ehcache.config.b.class, "com.obric.memorydata.plugin"), false);     // Catch: RuntimeException -> L13 Throwable -> L27 Exception -> L29
        r3.push(r7);     // Catch: RuntimeException -> L13 Throwable -> L27 Exception -> L29
        goto L7
    L10:
        r1.a();     // Catch: Throwable -> L27 Exception -> L29
        r1.a(null);
        return;
    L13:
        e = move-exception;
    L15:
        if (r3.isEmpty() == true) goto L34;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.pop(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27 Exception -> L29
        a(r8, false);     // Catch: Exception -> L19 Throwable -> L27
    L19:
        e = move-exception;
        f18027b.error("Cache '{}' could not be removed after initialization failure due to ", r8, e);     // Catch: Throwable -> L27 Exception -> L29
        goto L15
    L34:
        this.f18028a.c();     // Catch: Exception -> L24 Throwable -> L27
    L26:
        throw e;     // Catch: Throwable -> L27 Exception -> L29
    L24:
        e = move-exception;
        f18027b.error("Stopping services after initialization failure failed due to ", e);     // Catch: Throwable -> L27 Exception -> L29
    L29:
        e = move-exception;
        throw r1.a(e);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r1.a(null);
        throw th;
    }

    @Override // org.ehcache.b
    public void a(String r2) {
        Objects.requireNonNull(r2, "Alias cannot be null");
        a(r2, true);
    }

    public void a(String r6, h<?, ?> r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        Iterator<ResourceType<?>> r0 = r8.a().g().a().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ResourceType<?> r2 = (ResourceType) ZeusTransformUtils.preCheckCast(r0.next(), ResourceType.class, "com.obric.memorydata.plugin");
        if (r2.isPersistable() == false) goto L4;
        if (r8.a().g().a(r2).a() == true) goto L4;
        a(r2).a(r6);     // Catch: CachePersistenceException -> L12
    L12:
        e = move-exception;
        f18027b.warn("Unable to clear persistence space for cache {}", r6, e);
        goto L4
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i.a r0 = this.h.e();
        Iterator<String> r2 = this.f.keySet().iterator();     // Catch: Throwable -> L26 Exception -> L33
        Exception r3 = null;
    L43:
    L24:
        e = e;
    L35:
        if (r3 == null) goto L38;
        e = r3;
    L38:
        if (e != null) goto L42;
    L39:
        r0.a(null);
        return;
    L42:
        throw r0.a(e);
    L22:
        th = th;
    L28:
        if (r3 != null) goto L30;
        r0.a(null);
        throw th;
    L30:
        throw r0.a(r3);
    L6:
        if (r2.hasNext() == false) goto L15;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22 Exception -> L24
        a(r4, false);     // Catch: Exception -> L11 Throwable -> L22
    L11:
        e = move-exception;
        if (r3 == null) goto L13;
        f18027b.error("Cache '{}' could not be removed due to ", r4, e);     // Catch: Throwable -> L22 Exception -> L24
        goto L43
    L13:
        r3 = e;
        goto L43
    L15:
        this.f18028a.c();     // Catch: Throwable -> L22 Exception -> L24
        if (r3 != null) goto L18;
        r0.a();     // Catch: Throwable -> L22 Exception -> L24
    L18:
        if (r3 == null) goto L39;
        throw r0.a(r3);
    L33:
        e = e;
        r3 = null;
    L26:
        th = th;
        r3 = null;
        goto L28
    }
}
