package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.ehcache.StateTransitionException;
import org.ehcache.Status;

/* JADX INFO: loaded from: classes7.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<InternalStatus.a> f18050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Thread f18051b;
    private final org.slf4j.c c;
    private final CopyOnWriteArrayList<org.ehcache.core.spi.a> d;
    private final CopyOnWriteArrayList<org.ehcache.core.b.g> e;

    /* JADX INFO: renamed from: org.ehcache.core.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18052a = null;

        static {
            int[] r0 = new int[InternalStatus.values().length];
            f18052a = r0;
            r0[InternalStatus.AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f18052a[InternalStatus.UNINITIALIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f18052a[InternalStatus.MAINTENANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f18053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InternalStatus.a f18054b;
        private final Thread c;
        private final String d;

        public a(i r1, InternalStatus.a r2, Thread r3, String r4) {
            this.f18053a = r1;
            this.f18054b = r2;
            this.c = r3;
            this.d = r4;
        }

        public StateTransitionException a(Throwable r3) {
            if (this.f18054b.f() == false) goto L8;
            if (r3 != null) goto L7;
            return null;
        L7:
            throw new AssertionError("Throwable cannot be thrown if Transition is done.", r3);
        L8:
            this.f18054b.c();
            if (r3 != null) goto L11;
            return null;
        L11:
            i.c(this.f18053a).error("{} failed.", this.d);
            if (ZeusTransformUtils.instanceOf(r3, StateTransitionException.class) == false) goto L16;
            return (StateTransitionException) ZeusTransformUtils.preCheckCast(r3, StateTransitionException.class, "com.obric.memorydata.plugin");
        L16:
            return new StateTransitionException(r3);
        }

        public void a() {
            int r1 = AnonymousClass1.f18052a[this.f18054b.e().ordinal()];     // Catch: Exception -> L21
            if (r1 != 1) goto L6;
            i.a(this.f18053a);     // Catch: Exception -> L21
        L14:
            this.f18054b.b();     // Catch: Exception -> L21
            i.a(this.f18053a, this.f18054b.d().toPublicStatus(), this.f18054b.e().toPublicStatus());     // Catch: Throwable -> L18
            i.a(this.f18053a, this.c);
            i.c(this.f18053a).debug("{} successful.", this.d);
            return;
        L18:
            th = move-exception;
            i.a(this.f18053a, this.c);
            i.c(this.f18053a).debug("{} successful.", this.d);
            throw th;
        L6:
            if (r1 != 2) goto L8;
            i.a(this.f18053a, null);     // Catch: Exception -> L21
            i.b(this.f18053a);     // Catch: Exception -> L21
            goto L14
        L8:
            if (r1 != 3) goto L11;
            i.a(this.f18053a, this.c);     // Catch: Exception -> L21
            goto L14
        L11:
            throw new IllegalArgumentException("Didn't expect that enum value: " + this.f18054b.e());     // Catch: Exception -> L21
        L21:
            e = move-exception;
            this.f18054b.c();
            throw new StateTransitionException(e);
        }
    }

    i(org.slf4j.c r3) {
        org.slf4j.c r4 = (org.slf4j.c) ZeusTransformUtils.wrapperContextForParams(r3, org.slf4j.c.class, "com.obric.memorydata.plugin");
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f18050a = new AtomicReference(InternalStatus.initial());
        this.c = r4;
    }

    static /* synthetic */ Thread a(i r0, Thread r1) {
        r0.f18051b = r1;
        return r1;
    }

    private void a(Status r4, Status r5) {
        Iterator<org.ehcache.core.b.g> r3 = this.e.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((org.ehcache.core.b.g) ZeusTransformUtils.preCheckCast(r3.next(), org.ehcache.core.b.g.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L4
    }

    static /* synthetic */ void a(i r0) {
        r0.g();
    }

    static /* synthetic */ void a(i r0, Status r1, Status r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void b(i r0) {
        r0.h();
    }

    static /* synthetic */ org.slf4j.c c(i r0) {
        return r0.c;
    }

    private void f() {
        if (a() != Status.UNINITIALIZED) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can't modify hooks when not in " + Status.UNINITIALIZED);
    }

    private void g() {
        ArrayDeque r0 = new ArrayDeque();
        Iterator<org.ehcache.core.spi.a> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        org.ehcache.core.spi.a r2 = (org.ehcache.core.spi.a) ZeusTransformUtils.preCheckCast(r1.next(), org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin");
        r2.b();     // Catch: Exception -> L8
        r0.add(r2);     // Catch: Exception -> L8
    L8:
        e = move-exception;
    L10:
        if (r0.isEmpty() == true) goto L15;
        ((org.ehcache.core.spi.a) ZeusTransformUtils.preCheckCast(r0.pop(), org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        this.c.error("Failed to close() while shutting down because of .init() having thrown", e);
        goto L10
    L15:
        throw e;
    }

    private void h() {
        ArrayDeque r0 = new ArrayDeque();
        Iterator<org.ehcache.core.spi.a> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addFirst((org.ehcache.core.spi.a) ZeusTransformUtils.preCheckCast(r1.next(), org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Exception r2 = null;
    L8:
        if (r0.isEmpty() == true) goto L15;
        ((org.ehcache.core.spi.a) ZeusTransformUtils.preCheckCast(r0.pop(), org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        if (r2 == null) goto L13;
        this.c.error("A LifeCyclable has thrown already while closing down", e);
        goto L8
    L13:
        r2 = e;
        goto L8
    L15:
        if (r2 != null) goto L17;
        return;
    L17:
        throw r2;
    }

    Status a() {
        return ((InternalStatus.a) ZeusTransformUtils.preCheckCast(this.f18050a.get(), InternalStatus.a.class, "com.obric.memorydata.plugin")).a().toPublicStatus();
    }

    void a(org.ehcache.core.spi.a r3) {
        org.ehcache.core.spi.a r4 = (org.ehcache.core.spi.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin");
        f();
        this.d.add(r4);
    }

    boolean b() {
        return !((InternalStatus.a) ZeusTransformUtils.preCheckCast(this.f18050a.get(), InternalStatus.a.class, "com.obric.memorydata.plugin")).f();
    }

    void c() {
        Status r0 = a();
        if (r0 != Status.MAINTENANCE) goto L10;
        if (Thread.currentThread() == this.f18051b) goto L10;
        throw new IllegalStateException("State is " + r0 + ", yet you don't own it!");
    L10:
        if (r0 == Status.UNINITIALIZED) goto L13;
        return;
    L13:
        throw new IllegalStateException("State is " + r0);
    }

    a d() {
        this.c.trace("Initializing");
    L3:
        AtomicReference<InternalStatus.a> r0 = this.f18050a;
        InternalStatus.a r1 = (InternalStatus.a) ZeusTransformUtils.preCheckCast(r0.get(), InternalStatus.a.class, "com.obric.memorydata.plugin");
        InternalStatus.a r2 = r1.a().init();
        if (r0.compareAndSet(r1, r2) == false) goto L3;
        return new a(this, r2, null, "Initialize");
    }

    a e() {
        this.c.trace("Closing");
        if (this.f18051b == null) goto L9;
        if (Thread.currentThread() == this.f18051b) goto L9;
        throw new IllegalStateException("You don't own this MAINTENANCE lease");
    L9:
        AtomicReference<InternalStatus.a> r0 = this.f18050a;
        InternalStatus.a r1 = (InternalStatus.a) ZeusTransformUtils.preCheckCast(r0.get(), InternalStatus.a.class, "com.obric.memorydata.plugin");
        InternalStatus.a r2 = r1.a().close();
        if (r0.compareAndSet(r1, r2) == false) goto L9;
        return new a(this, r2, null, "Close");
    }
}
