package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<com.bumptech.glide.load.c, b> f709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f710b;
    private final Executor c;
    private final ReferenceQueue<n<?>> d;
    private n.a e;
    private volatile boolean f;
    private volatile InterfaceC0064a g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    interface InterfaceC0064a {
        void a();
    }

    static final class b extends WeakReference<n<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.c f714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f715b;
        s<?> c;

        b(com.bumptech.glide.load.c r3, n<?> r4, ReferenceQueue<? super n<?>> r5, boolean r6) {
            com.bumptech.glide.load.c r7 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            super(r4, r5);
            this.f714a = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r7), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            if (r4.b() == false) goto L6;
            if (r6 == false) goto L6;
            s<?> r8 = (s) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4.a()), s.class, "com.obric.memorydata.plugin");
        L7:
            this.c = r8;
            this.f715b = r4.b();
            return;
        L6:
            r8 = null;
            goto L7
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    a(boolean r2) {
        this(r2, Executors.newSingleThreadExecutor(new AnonymousClass1()));
    }

    a(boolean r3, Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        this.f709a = new HashMap();
        this.d = new ReferenceQueue();
        this.f710b = r3;
        this.c = r5;
        r5.execute(new AnonymousClass2(this));
    }

    void a() {
    L3:
        if (this.f == true) goto L9;
        a((b) ZeusTransformUtils.preCheckCast(this.d.remove(), b.class, "com.obric.memorydata.plugin"));     // Catch: InterruptedException -> L8
        InterfaceC0064a r0 = this.g;     // Catch: InterruptedException -> L8
        if (r0 == null) goto L3;
        r0.a();     // Catch: InterruptedException -> L8
    L8:
        Thread.currentThread().interrupt();
        goto L3
    }

    synchronized void a(com.bumptech.glide.load.c r3) {
        monitor-enter(this);
        com.bumptech.glide.load.c r4 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.f709a.remove(r4), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r5 == null) goto L6;
        r5.a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void a(com.bumptech.glide.load.c r4, n<?> r5) {
        monitor-enter(this);
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        b r0 = new b(r6, r5, this.d, this.f710b);     // Catch: Throwable -> L8
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.f709a.put(r6, r0), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r7 == null) goto L6;
        r7.a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void a(b r8) {
        monitor-enter(this);
        this.f709a.remove(r8.f714a);     // Catch: Throwable -> L13
        if (r8.f715b == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (r8.c == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L13
        n<?> r0 = new n(r8.c, true, false, r8.f714a, this.e);
        this.e.a(r8.f714a, r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void a(n.a r3) {
        n.a r4 = (n.a) ZeusTransformUtils.wrapperContextForParams(r3, n.a.class, "com.obric.memorydata.plugin");
        monitor-enter(r4);
        monitor-enter(this);     // Catch: Throwable -> L12
        this.e = r4;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    synchronized n<?> b(com.bumptech.glide.load.c r4) {
        monitor-enter(this);
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        b r6 = (b) ZeusTransformUtils.preCheckCast(this.f709a.get(r5), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r6 == null) goto L6;
        n<?> r0 = (n) ZeusTransformUtils.preCheckCast(r6.get(), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        a(r6);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }
}
