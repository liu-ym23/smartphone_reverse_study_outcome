package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.pool.FactoryPools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class j<R> implements DecodeJob.a<R>, FactoryPools.b {
    private static final c e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    DataSource f794b;
    GlideException c;
    n<?> d;
    private final com.bumptech.glide.util.pool.b f;
    private final n.a g;
    private final Pools.Pool<j<?>> h;
    private final c i;
    private final k j;
    private final com.bumptech.glide.load.engine.b.a k;
    private final com.bumptech.glide.load.engine.b.a l;
    private final com.bumptech.glide.load.engine.b.a m;
    private final com.bumptech.glide.load.engine.b.a n;
    private final AtomicInteger o;
    private com.bumptech.glide.load.c p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private s<?> u;
    private boolean v;
    private boolean w;
    private DecodeJob<R> x;
    private volatile boolean y;
    private boolean z;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.g f796b;

        a(j r3, com.bumptech.glide.request.g r4) {
            com.bumptech.glide.request.g r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            this.f795a = r3;
            this.f796b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.f796b.h();
            monitor-enter(r0);
            j r1 = this.f795a;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.f795a.f793a.b(this.f796b) == false) goto L9;
            this.f795a.b(this.f796b);     // Catch: Throwable -> L13
        L9:
            this.f795a.e();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.g f798b;

        b(j r3, com.bumptech.glide.request.g r4) {
            com.bumptech.glide.request.g r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            this.f797a = r3;
            this.f798b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.f798b.h();
            monitor-enter(r0);
            j r1 = this.f797a;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.f797a.f793a.b(this.f798b) == false) goto L9;
            this.f797a.d.g();     // Catch: Throwable -> L13
            this.f797a.a(this.f798b);     // Catch: Throwable -> L13
            this.f797a.c(this.f798b);     // Catch: Throwable -> L13
        L9:
            this.f797a.e();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static class c {
        c() {
        }

        public <R> n<R> a(s<R> r8, boolean r9, com.bumptech.glide.load.c r10, n.a r11) {
            return new n((s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.memorydata.plugin"), r9, true, (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"), (n.a) ZeusTransformUtils.wrapperContextForParams(r11, n.a.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.request.g f799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f800b;

        d(com.bumptech.glide.request.g r3, Executor r4) {
            com.bumptech.glide.request.g r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.f799a = r5;
            this.f800b = r6;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
            d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
            return this.f799a.equals(r4.f799a);
        L6:
            return false;
        }

        public int hashCode() {
            return this.f799a.hashCode();
        }
    }

    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d> f801a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> r3) {
            this.f801a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        private static d c(com.bumptech.glide.request.g r2) {
            return new d((com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin"), com.bumptech.glide.util.d.b());
        }

        void a(com.bumptech.glide.request.g r3) {
            com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            this.f801a.remove(c(r4));
        }

        void a(com.bumptech.glide.request.g r3, Executor r4) {
            com.bumptech.glide.request.g r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.f801a.add(new d(r5, r6));
        }

        boolean a() {
            return this.f801a.isEmpty();
        }

        int b() {
            return this.f801a.size();
        }

        boolean b(com.bumptech.glide.request.g r3) {
            com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            return this.f801a.contains(c(r4));
        }

        void c() {
            this.f801a.clear();
        }

        e d() {
            return new e(new ArrayList(this.f801a));
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f801a.iterator();
        }
    }

    static {
        e = new c();
    }

    j(com.bumptech.glide.load.engine.b.a r12, com.bumptech.glide.load.engine.b.a r13, com.bumptech.glide.load.engine.b.a r14, com.bumptech.glide.load.engine.b.a r15, k r16, n.a r17, Pools.Pool<j<?>> r18) {
        this(r12, r13, r14, r15, (k) ZeusTransformUtils.wrapperContextForParams(r16, k.class, "com.obric.memorydata.plugin"), (n.a) ZeusTransformUtils.wrapperContextForParams(r17, n.a.class, "com.obric.memorydata.plugin"), (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r18, Pools.Pool.class, "com.obric.memorydata.plugin"), e);
    }

    j(com.bumptech.glide.load.engine.b.a r3, com.bumptech.glide.load.engine.b.a r4, com.bumptech.glide.load.engine.b.a r5, com.bumptech.glide.load.engine.b.a r6, k r7, n.a r8, Pools.Pool<j<?>> r9, c r10) {
        k r11 = (k) ZeusTransformUtils.wrapperContextForParams(r7, k.class, "com.obric.memorydata.plugin");
        n.a r12 = (n.a) ZeusTransformUtils.wrapperContextForParams(r8, n.a.class, "com.obric.memorydata.plugin");
        Pools.Pool<j<?>> r13 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r9, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.f793a = new e();
        this.f = com.bumptech.glide.util.pool.b.a();
        this.o = new AtomicInteger();
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.j = r11;
        this.g = r12;
        this.h = r13;
        this.i = r10;
    }

    private com.bumptech.glide.load.engine.b.a g() {
        if (this.r == false) goto L6;
        return this.m;
    L6:
        if (this.s == false) goto L9;
        return this.n;
    L9:
        return this.l;
    }

    private boolean h() {
        if (this.w == false) goto L5;
    L10:
        return true;
    L5:
        if (this.v == true) goto L10;
        if (this.y == true) goto L10;
        return false;
    }

    private synchronized void i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.p == null) goto L9;
        this.f793a.c();     // Catch: Throwable -> L10
        this.p = null;     // Catch: Throwable -> L10
        this.d = null;     // Catch: Throwable -> L10
        this.u = null;     // Catch: Throwable -> L10
        this.w = false;     // Catch: Throwable -> L10
        this.y = false;     // Catch: Throwable -> L10
        this.v = false;     // Catch: Throwable -> L10
        this.z = false;     // Catch: Throwable -> L10
        this.x.a(false);     // Catch: Throwable -> L10
        this.x = null;     // Catch: Throwable -> L10
        this.c = null;     // Catch: Throwable -> L10
        this.f794b = null;     // Catch: Throwable -> L10
        this.h.release(this);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    }

    synchronized j<R> a(com.bumptech.glide.load.c r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        monitor-enter(this);
        this.p = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.q = r4;     // Catch: Throwable -> L6
        this.r = r5;     // Catch: Throwable -> L6
        this.s = r6;     // Catch: Throwable -> L6
        this.t = r7;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void a(int r3) {
        monitor-enter(this);
        com.bumptech.glide.util.j.a(h(), "Not yet complete!");     // Catch: Throwable -> L10
        if (this.o.getAndAdd(r3) != 0) goto L8;
        n<?> r4 = this.d;     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r4.g();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> r1) {
        g().execute(r1);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(GlideException r1) {
        monitor-enter(this);
        this.c = r1;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        f();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(s<R> r3, DataSource r4, boolean r5) {
        s<?> r6 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        this.u = r6;     // Catch: Throwable -> L8
        this.f794b = r4;     // Catch: Throwable -> L8
        this.z = r5;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        c();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void a(com.bumptech.glide.request.g r3) {
        com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
        r4.a(this.d, this.f794b, this.z);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw new CallbackException(th);
    }

    synchronized void a(com.bumptech.glide.request.g r3, Executor r4) {
        monitor-enter(this);
        com.bumptech.glide.request.g r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        this.f.b();     // Catch: Throwable -> L17
        this.f793a.a(r5, r6);     // Catch: Throwable -> L17
        boolean r1 = true;
        if (this.v == false) goto L8;
        a(1);     // Catch: Throwable -> L17
        Runnable r0 = new b(this, r5);     // Catch: Throwable -> L17
    L6:
        r6.execute(r0);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L8:
        if (this.w == false) goto L11;
        a(1);     // Catch: Throwable -> L17
        r0 = new a(this, r5);     // Catch: Throwable -> L17
        goto L6
    L11:
        if (this.y == false) goto L14;
        r1 = false;
    L14:
        com.bumptech.glide.util.j.a(r1, "Cannot add callbacks to a cancelled EngineJob");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    boolean a() {
        return this.t;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.b
    public com.bumptech.glide.util.pool.b a_() {
        return this.f;
    }

    void b() {
        if (h() == false) goto L5;
        return;
    L5:
        this.y = true;
        this.x.b();
        this.j.a(this, this.p);
    }

    public synchronized void b(DecodeJob<R> r2) {
        monitor-enter(this);
        this.x = r2;     // Catch: Throwable -> L10
        if (r2.a() == false) goto L6;
        com.bumptech.glide.load.engine.b.a r0 = this.k;     // Catch: Throwable -> L10
    L7:
        r0.execute(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = g();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void b(com.bumptech.glide.request.g r3) {
        com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
        r4.a(this.c);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw new CallbackException(th);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void c() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L24
        if (this.y == false) goto L9;
        this.u.f();     // Catch: Throwable -> L24
        i();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.f793a.a() == true) goto L23;
        if (this.v == true) goto L21;
        this.d = this.i.a(this.u, this.q, this.p, this.g);     // Catch: Throwable -> L24
        this.v = true;     // Catch: Throwable -> L24
        e r1 = this.f793a.d();     // Catch: Throwable -> L24
        a(r1.b() + 1);     // Catch: Throwable -> L24
        com.bumptech.glide.load.c r0 = this.p;     // Catch: Throwable -> L24
        n<?> r2 = this.d;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.j.a(this, r0, r2);
        Iterator<d> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin");
        r4.f800b.execute(new b(this, r4.f799a));
        goto L16
    L18:
        e();
        return;
    L21:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    synchronized void c(com.bumptech.glide.request.g r3) {
        monitor-enter(this);
        com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        this.f.b();     // Catch: Throwable -> L18
        this.f793a.a(r4);     // Catch: Throwable -> L18
        if (this.f793a.a() == false) goto L16;
        b();     // Catch: Throwable -> L18
        if (this.v == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L16;
        if (this.o.get() != 0) goto L16;
        i();     // Catch: Throwable -> L18
        goto L16
    L8:
        if (this.w == true) goto L11;
        r5 = false;
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    void e() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L15
        com.bumptech.glide.util.j.a(h(), "Not yet complete!");     // Catch: Throwable -> L15
        int r0 = this.o.decrementAndGet();     // Catch: Throwable -> L15
        if (r0 < 0) goto L6;
        boolean r1 = true;
    L7:
        com.bumptech.glide.util.j.a(r1, "Can't decrement below 0");     // Catch: Throwable -> L15
        if (r0 != 0) goto L10;
        n<?> r2 = this.d;     // Catch: Throwable -> L15
        i();     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r2 == null) goto L20;
        r2.h();
        return;
    L20:
        return;
    L10:
        r2 = null;
        goto L11
    L6:
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    void f() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L24
        if (this.y == false) goto L9;
        i();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.f793a.a() == true) goto L23;
        if (this.w == true) goto L21;
        this.w = true;     // Catch: Throwable -> L24
        com.bumptech.glide.load.c r1 = this.p;     // Catch: Throwable -> L24
        e r2 = this.f793a.d();     // Catch: Throwable -> L24
        a(r2.b() + 1);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.j.a(this, r1, null);
        Iterator<d> r0 = r2.iterator();
    L16:
        if (r0.hasNext() == false) goto L18;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.memorydata.plugin");
        r3.f800b.execute(new a(this, r3.f799a));
        goto L16
    L18:
        e();
        return;
    L21:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }
}
