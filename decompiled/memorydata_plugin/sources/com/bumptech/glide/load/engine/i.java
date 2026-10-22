package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.pool.FactoryPools;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.bumptech.glide.load.engine.a.h.a, k, n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f781a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f782b;
    private final m c;
    private final com.bumptech.glide.load.engine.a.h d;
    private final b e;
    private final v f;
    private final c g;
    private final a h;
    private final com.bumptech.glide.load.engine.a i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DecodeJob.d f783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Pools.Pool<DecodeJob<?>> f784b;
        private int c;

        a(DecodeJob.d r3) {
            DecodeJob.d r4 = (DecodeJob.d) ZeusTransformUtils.wrapperContextForParams(r3, DecodeJob.d.class, "com.obric.memorydata.plugin");
            this.f784b = FactoryPools.a(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, new AnonymousClass1(this));
            this.f783a = r4;
        }

        <R> DecodeJob<R> a(com.bumptech.glide.e r20, Object r21, l r22, com.bumptech.glide.load.c r23, int r24, int r25, Class<?> r26, Class<R> r27, Priority r28, h r29, Map<Class<?>, com.bumptech.glide.load.h<?>> r30, boolean r31, boolean r32, boolean r33, com.bumptech.glide.load.e r34, DecodeJob.a<R> r35) {
            com.bumptech.glide.e r2 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r20, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r23, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            Map<Class<?>, com.bumptech.glide.load.h<?>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
            DecodeJob.a<R> r17 = (DecodeJob.a) ZeusTransformUtils.wrapperContextForParams(r35, DecodeJob.a.class, "com.obric.memorydata.plugin");
            DecodeJob r3 = (DecodeJob) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a((DecodeJob) ZeusTransformUtils.preCheckCast(this.f784b.acquire(), DecodeJob.class, "com.obric.memorydata.plugin")), DecodeJob.class, "com.obric.memorydata.plugin");
            int r4 = this.c;
            this.c = r4 + 1;
            return r3.a(r2, r21, r22, r5, r24, r25, r26, r27, r28, r29, r1, r31, r32, r33, r34, r17, r4);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.engine.b.a f786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.engine.b.a f787b;
        final com.bumptech.glide.load.engine.b.a c;
        final com.bumptech.glide.load.engine.b.a d;
        final k e;
        final n.a f;
        final Pools.Pool<j<?>> g;

        b(com.bumptech.glide.load.engine.b.a r3, com.bumptech.glide.load.engine.b.a r4, com.bumptech.glide.load.engine.b.a r5, com.bumptech.glide.load.engine.b.a r6, k r7, n.a r8) {
            k r9 = (k) ZeusTransformUtils.wrapperContextForParams(r7, k.class, "com.obric.memorydata.plugin");
            n.a r10 = (n.a) ZeusTransformUtils.wrapperContextForParams(r8, n.a.class, "com.obric.memorydata.plugin");
            this.g = FactoryPools.a(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, new AnonymousClass1(this));
            this.f786a = r3;
            this.f787b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r9;
            this.f = r10;
        }

        <R> j<R> a(com.bumptech.glide.load.c r9, boolean r10, boolean r11, boolean r12, boolean r13) {
            com.bumptech.glide.load.c r3 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            return ((j) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a((j) ZeusTransformUtils.preCheckCast(this.g.acquire(), j.class, "com.obric.memorydata.plugin")), j.class, "com.obric.memorydata.plugin")).a(r3, r10, r11, r12, r13);
        }
    }

    private static class c implements DecodeJob.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.a.InterfaceC0065a f789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.a.a f790b;

        c(com.bumptech.glide.load.engine.a.a.InterfaceC0065a r3) {
            this.f789a = (com.bumptech.glide.load.engine.a.a.InterfaceC0065a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.a.InterfaceC0065a.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.d
        public com.bumptech.glide.load.engine.a.a a() {
            if (this.f790b != null) goto L17;
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L6:
            if (this.f790b != null) goto L9;
            this.f790b = this.f789a.a();     // Catch: Throwable -> L13
        L9:
            if (this.f790b != null) goto L11;
            this.f790b = new com.bumptech.glide.load.engine.a.b();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.f790b;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j<?> f792b;
        private final com.bumptech.glide.request.g c;

        d(i r3, com.bumptech.glide.request.g r4, j<?> r5) {
            com.bumptech.glide.request.g r6 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
            this.f791a = r3;
            this.c = r6;
            this.f792b = r5;
        }

        public void a() {
            i r0 = this.f791a;
            monitor-enter(r0);
            this.f792b.c(this.c);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f781a = Log.isLoggable("Engine", 2);
    }

    i(com.bumptech.glide.load.engine.a.h r12, com.bumptech.glide.load.engine.a.a.InterfaceC0065a r13, com.bumptech.glide.load.engine.b.a r14, com.bumptech.glide.load.engine.b.a r15, com.bumptech.glide.load.engine.b.a r16, com.bumptech.glide.load.engine.b.a r17, p r18, m r19, com.bumptech.glide.load.engine.a r20, b r21, a r22, v r23, boolean r24) {
        com.bumptech.glide.load.engine.a.h r8 = (com.bumptech.glide.load.engine.a.h) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.engine.a.h.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.a.a.InterfaceC0065a r0 = (com.bumptech.glide.load.engine.a.a.InterfaceC0065a) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.load.engine.a.a.InterfaceC0065a.class, "com.obric.memorydata.plugin");
        this.d = r8;
        c r9 = new c(r0);
        this.g = r9;
        if (r20 != null) goto L5;
        com.bumptech.glide.load.engine.a r1 = new com.bumptech.glide.load.engine.a(r24);
    L6:
        this.i = r1;
        r1.a(this);
        if (r19 != null) goto L9;
        m r2 = new m();
    L10:
        this.c = r2;
        if (r18 != null) goto L13;
        p r3 = new p();
    L14:
        this.f782b = r3;
        if (r21 != null) goto L17;
        b r10 = new b(r14, r15, r16, r17, this, this);
    L18:
        this.e = r10;
        if (r22 != null) goto L21;
        a r4 = new a(r9);
    L22:
        this.h = r4;
        if (r23 != null) goto L25;
        v r5 = new v();
    L26:
        this.f = r5;
        r8.a(this);
        return;
    L25:
        r5 = r23;
        goto L26
    L21:
        r4 = r22;
        goto L22
    L17:
        r10 = r21;
        goto L18
    L13:
        r3 = r18;
        goto L14
    L9:
        r2 = r19;
        goto L10
    L5:
        r1 = r20;
        goto L6
    }

    public i(com.bumptech.glide.load.engine.a.h r17, com.bumptech.glide.load.engine.a.a.InterfaceC0065a r18, com.bumptech.glide.load.engine.b.a r19, com.bumptech.glide.load.engine.b.a r20, com.bumptech.glide.load.engine.b.a r21, com.bumptech.glide.load.engine.b.a r22, boolean r23) {
        this((com.bumptech.glide.load.engine.a.h) ZeusTransformUtils.wrapperContextForParams(r17, com.bumptech.glide.load.engine.a.h.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.load.engine.a.a.InterfaceC0065a) ZeusTransformUtils.wrapperContextForParams(r18, com.bumptech.glide.load.engine.a.a.InterfaceC0065a.class, "com.obric.memorydata.plugin"), r19, r20, r21, r22, null, null, null, null, null, null, r23);
    }

    private <R> d a(com.bumptech.glide.e r22, Object r23, com.bumptech.glide.load.c r24, int r25, int r26, Class<?> r27, Class<R> r28, Priority r29, h r30, Map<Class<?>, com.bumptech.glide.load.h<?>> r31, boolean r32, boolean r33, com.bumptech.glide.load.e r34, boolean r35, boolean r36, boolean r37, boolean r38, com.bumptech.glide.request.g r39, Executor r40, l r41, long r42) {
        com.bumptech.glide.e r7 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r8 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r24, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map<Class<?>, com.bumptech.glide.load.h<?>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.g r11 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r39, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r40, Executor.class, "com.obric.memorydata.plugin");
        j<?> r1 = this.f782b.a(r41, r38);
        if (r1 == null) goto L9;
        r1.a(r11, r10);
        if (f781a == false) goto L8;
        a("Added to existing load", r42, r41);
    L8:
        return new d(this, r11, r1);
    L9:
        j<R> r6 = this.e.a(r41, r35, r36, r37, r38);
        DecodeJob<R> r2 = this.h.a(r7, r23, r41, r8, r25, r26, r27, r28, r29, r30, r12, r32, r33, r38, r34, r6);
        this.f782b.a(r41, r6);
        r6.a(r11, r10);
        r6.b(r2);
        if (f781a == false) goto L13;
        a("Started new load", r42, r41);
    L13:
        return new d(this, r11, r6);
    }

    private n<?> a(com.bumptech.glide.load.c r3) {
        com.bumptech.glide.load.c r4 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        n<?> r2 = this.i.b(r4);
        if (r2 == null) goto L5;
        r2.g();
    L5:
        return r2;
    }

    private n<?> a(l r2, boolean r3, long r4) {
        if (r3 == true) goto L5;
        return null;
    L5:
        n<?> r5 = a(r2);
        if (r5 != null) goto L8;
        n<?> r1 = b(r2);
        if (r1 != null) goto L14;
        return null;
    L14:
        if (f781a == false) goto L16;
        a("Loaded resource from cache", r4, r2);
    L16:
        return r1;
    L8:
        if (f781a == false) goto L10;
        a("Loaded resource from active resources", r4, r2);
    L10:
        return r5;
    }

    private static void a(String r2, long r3, com.bumptech.glide.load.c r5) {
        Log.v("Engine", r2 + " in " + com.bumptech.glide.util.f.a(r3) + "ms, key: " + ((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin")));
    }

    private n<?> b(com.bumptech.glide.load.c r3) {
        com.bumptech.glide.load.c r4 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        n<?> r0 = c(r4);
        if (r0 == null) goto L5;
        r0.g();
        this.i.a(r4, r0);
    L5:
        return r0;
    }

    private n<?> c(com.bumptech.glide.load.c r9) {
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        s<?> r3 = this.d.a(r6);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, n.class) == false) goto L9;
        return (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
    L9:
        return new n(r3, true, true, r6, this);
    }

    public <R> d a(com.bumptech.glide.e r25, Object r26, com.bumptech.glide.load.c r27, int r28, int r29, Class<?> r30, Class<R> r31, Priority r32, h r33, Map<Class<?>, com.bumptech.glide.load.h<?>> r34, boolean r35, boolean r36, com.bumptech.glide.load.e r37, boolean r38, boolean r39, boolean r40, boolean r41, com.bumptech.glide.request.g r42, Executor r43) {
        com.bumptech.glide.e r2 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r25, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r0 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r27, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map<Class<?>, com.bumptech.glide.load.h<?>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.g r14 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r42, com.bumptech.glide.request.g.class, "com.obric.memorydata.plugin");
        Executor r20 = (Executor) ZeusTransformUtils.wrapperContextForParams(r43, Executor.class, "com.obric.memorydata.plugin");
        if (f781a == false) goto L5;
        long r3 = com.bumptech.glide.util.f.a();
    L6:
        long r10 = r3;
        l r11 = this.c.a(r26, r0, r28, r29, r12, r30, r31, r37);
        monitor-enter(this);
        n<?> r1 = a(r11, r38, r10);     // Catch: Throwable -> L18
        if (r1 != null) goto L15;
        d r4 = a(r2, r26, r0, r28, r29, r30, r31, r32, r33, r12, r35, r36, r37, r38, r39, r40, r41, r14, r20, r11, r10);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r4;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L18
        r14.a(r1, DataSource.MEMORY_CACHE, false);
        return null;
    L18:
        th = move-exception;
        throw th;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bumptech.glide.load.engine.n.a
    public void a(com.bumptech.glide.load.c r3, n<?> r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.i.a(r5);
        if (r4.b() == false) goto L5;
        this.d.b(r5, r4);
        return;
    L5:
        this.f.a(r4, false);
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void a(j<?> r3, com.bumptech.glide.load.c r4) {
        monitor-enter(this);
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f782b.b(r5, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void a(j<?> r3, com.bumptech.glide.load.c r4, n<?> r5) {
        monitor-enter(this);
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
    L8:
        this.f782b.b(r6, r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (r5.b() == false) goto L8;
        this.i.a(r6, r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void a(s<?> r2) {
        s r1 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L7;
        ((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin")).h();
        return;
    L7:
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.a.h.a
    public void b(s<?> r3) {
        s<?> r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        this.f.a(r4, true);
    }
}
