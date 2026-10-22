package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.util.pool.FactoryPools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob<R> implements com.bumptech.glide.load.engine.e.a, FactoryPools.b, Comparable<DecodeJob<?>>, Runnable {
    private DataSource A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile com.bumptech.glide.load.engine.e C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<R> f697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f698b;
    private final com.bumptech.glide.util.pool.b c;
    private final d d;
    private final Pools.Pool<DecodeJob<?>> e;
    private final c<?> f;
    private final e g;
    private com.bumptech.glide.e h;
    private com.bumptech.glide.load.c i;
    private Priority j;
    private l k;
    private int l;
    private int m;
    private h n;
    private com.bumptech.glide.load.e o;
    private a<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.c x;
    private com.bumptech.glide.load.c y;
    private Object z;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f699a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f700b = null;
        static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[EncodeStrategy.values().length];
            c = r0;
            r0[EncodeStrategy.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L28:
            c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            int[] r2 = new int[Stage.values().length];
            f700b = r2;
            r2[Stage.RESOURCE_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            f700b[Stage.DATA_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L46:
            f700b[Stage.SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L32:
            f700b[Stage.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L38:
            f700b[Stage.INITIALIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r3 = new int[RunReason.values().length];
            f699a = r3;
            r3[RunReason.INITIALIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L42:
            f699a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L30:
            f699a[RunReason.DECODE_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private static final enum RunReason extends Enum<RunReason> {
        private static final /* synthetic */ RunReason[] $VALUES = null;
        public static final RunReason DECODE_DATA = null;
        public static final RunReason INITIALIZE = null;
        public static final RunReason SWITCH_TO_SOURCE_SERVICE = null;

        private static /* synthetic */ RunReason[] $values() {
            return new RunReason[]{INITIALIZE, SWITCH_TO_SOURCE_SERVICE, DECODE_DATA};
        }

        static {
            INITIALIZE = new RunReason("INITIALIZE", 0);
            SWITCH_TO_SOURCE_SERVICE = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            DECODE_DATA = new RunReason("DECODE_DATA", 2);
            $VALUES = $values();
        }

        private RunReason(String r1, int r2) {
            super(r1, r2);
        }

        public static RunReason valueOf(String r2) {
            return (RunReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(RunReason.class, r2), RunReason.class, "com.obric.memorydata.plugin");
        }

        public static RunReason[] values() {
            return (RunReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RunReason[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final Stage DATA_CACHE = null;
        public static final Stage ENCODE = null;
        public static final Stage FINISHED = null;
        public static final Stage INITIALIZE = null;
        public static final Stage RESOURCE_CACHE = null;
        public static final Stage SOURCE = null;

        private static /* synthetic */ Stage[] $values() {
            return new Stage[]{INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, FINISHED};
        }

        static {
            INITIALIZE = new Stage("INITIALIZE", 0);
            RESOURCE_CACHE = new Stage("RESOURCE_CACHE", 1);
            DATA_CACHE = new Stage("DATA_CACHE", 2);
            SOURCE = new Stage("SOURCE", 3);
            ENCODE = new Stage("ENCODE", 4);
            FINISHED = new Stage("FINISHED", 5);
            $VALUES = $values();
        }

        private Stage(String r1, int r2) {
            super(r1, r2);
        }

        public static Stage valueOf(String r2) {
            return (Stage) ZeusTransformUtils.preCheckCast(Enum.valueOf(Stage.class, r2), Stage.class, "com.obric.memorydata.plugin");
        }

        public static Stage[] values() {
            return (Stage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Stage[].class, "com.obric.memorydata.plugin");
        }
    }

    interface a<R> {
        void a(DecodeJob<?> r1);

        void a(GlideException r1);

        void a(s<R> r1, DataSource r2, boolean r3);
    }

    private final class b<Z> implements g.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DecodeJob f701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DataSource f702b;

        b(DecodeJob r1, DataSource r2) {
            this.f701a = r1;
            this.f702b = r2;
        }

        @Override // com.bumptech.glide.load.engine.g.a
        public s<Z> a(s<Z> r3) {
            s<Z> r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
            return this.f701a.a(this.f702b, r4);
        }
    }

    private static class c<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.c f703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.g<Z> f704b;
        private r<Z> c;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.c r3, com.bumptech.glide.load.g<X> r4, r<X> r5) {
            com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.g<Z> r7 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.memorydata.plugin");
            this.f703a = r6;
            this.f704b = r7;
            this.c = r5;
        }

        void a(d r5, com.bumptech.glide.load.e r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.util.pool.a.a("DecodeJob.encode");
            r7.a().a(this.f703a, new com.bumptech.glide.load.engine.d(this.f704b, this.c, r6));     // Catch: Throwable -> L6
            this.c.a();
            com.bumptech.glide.util.pool.a.a();
            return;
        L6:
            th = move-exception;
            this.c.a();
            com.bumptech.glide.util.pool.a.a();
            throw th;
        }

        boolean a() {
            if (this.c == null) goto L5;
            return true;
        L5:
            return false;
        }

        void b() {
            this.f703a = null;
            this.f704b = null;
            this.c = null;
        }
    }

    interface d {
        com.bumptech.glide.load.engine.a.a a();
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f706b;
        private boolean c;

        e() {
        }

        private boolean b(boolean r2) {
            if (this.c == true) goto L8;
            if (r2 == true) goto L8;
            if (this.f706b == true) goto L8;
        L10:
            return false;
        L8:
            if (this.f705a == false) goto L10;
            return true;
        }

        synchronized boolean a() {
            monitor-enter(this);
            this.f706b = true;     // Catch: Throwable -> L7
            boolean r0 = b(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean a(boolean r2) {
            monitor-enter(this);
            this.f705a = true;     // Catch: Throwable -> L7
            boolean r3 = b(r2);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean b() {
            monitor-enter(this);
            this.c = true;     // Catch: Throwable -> L7
            boolean r0 = b(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void c() {
            monitor-enter(this);
            this.f706b = false;     // Catch: Throwable -> L7
            this.f705a = false;     // Catch: Throwable -> L7
            this.c = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    DecodeJob(d r3, Pools.Pool<DecodeJob<?>> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Pools.Pool<DecodeJob<?>> r6 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r4, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.f697a = new f();
        this.f698b = new ArrayList();
        this.c = com.bumptech.glide.util.pool.b.a();
        this.f = new c();
        this.g = new e();
        this.d = r5;
        this.e = r6;
    }

    private com.bumptech.glide.load.e a(DataSource r5) {
        com.bumptech.glide.load.e r0 = this.o;
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return r0;
    L6:
        if (r5 != DataSource.RESOURCE_DISK_CACHE) goto L8;
    L11:
        boolean r6 = true;
    L12:
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0.b(com.bumptech.glide.load.resource.bitmap.j.e), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L15;
    L18:
        com.bumptech.glide.load.e r2 = new com.bumptech.glide.load.e();
        r2.a(this.o);
        r2.a(com.bumptech.glide.load.resource.bitmap.j.e, Boolean.valueOf(r6));
        return r2;
    L15:
        if (r1.booleanValue() == false) goto L17;
        if (r6 == false) goto L18;
    L17:
        return r0;
    L8:
        if (this.f697a.m() == true) goto L11;
        r6 = false;
        goto L12
    }

    private Stage a(Stage r3) {
        int r0 = AnonymousClass1.f700b[r3.ordinal()];
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L20;
        if (r0 == 4) goto L20;
        if (r0 != 5) goto L18;
        if (this.n.a() == false) goto L16;
        return Stage.RESOURCE_CACHE;
    L16:
        return a(Stage.RESOURCE_CACHE);
    L18:
        throw new IllegalArgumentException("Unrecognized stage: " + r3);
    L20:
        return Stage.FINISHED;
    L22:
        if (this.u == false) goto L25;
        return Stage.FINISHED;
    L25:
        return Stage.SOURCE;
    L27:
        if (this.n.b() == false) goto L30;
        return Stage.DATA_CACHE;
    L30:
        return a(Stage.DATA_CACHE);
    }

    private <Data> s<R> a(com.bumptech.glide.load.data.d<?> r4, Data r5, DataSource r6) {
        com.bumptech.glide.load.data.d r7 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        r7.b();
        return null;
    L14:
        long r0 = com.bumptech.glide.util.f.a();     // Catch: Throwable -> L11
        s<R> r8 = a(r5, r6);     // Catch: Throwable -> L11
        if (Log.isLoggable("DecodeJob", 2) == false) goto L9;
        a("Decoded result " + r8, r0);     // Catch: Throwable -> L11
    L9:
        r7.b();
        return r8;
    L11:
        th = move-exception;
        r7.b();
        throw th;
    }

    private <Data> s<R> a(Data r3, DataSource r4) {
        return a(r3, r4, this.f697a.b(r3.getClass()));
    }

    private <Data, ResourceType> s<R> a(Data r7, DataSource r8, q<Data, ResourceType, R> r9) {
        com.bumptech.glide.load.e r2 = a(r8);
        com.bumptech.glide.load.data.e<Data> r10 = this.h.d().b(r7);
        s<R> r6 = r9.a(r10, r2, this.l, this.m, new b(this, r8));     // Catch: Throwable -> L6
        r10.b();
        return r6;
    L6:
        th = move-exception;
        r10.b();
        throw th;
    }

    private void a(RunReason r1) {
        this.s = r1;
        this.p.a(this);
    }

    private void a(s<R> r3, DataSource r4, boolean r5) {
        s<R> r6 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        m();
        this.p.a(r6, r4, r5);
    }

    private void a(String r2, long r3) {
        a(r2, r3, null);
    }

    private void a(String r2, long r3, String r5) {
        StringBuilder r1 = new StringBuilder().append(r2).append(" in ").append(com.bumptech.glide.util.f.a(r3)).append(", load key: ").append(this.k);
        if (r5 == null) goto L5;
        String r4 = ", " + r5;
    L6:
        Log.v("DecodeJob", r1.append(r4).append(", thread: ").append(Thread.currentThread().getName()).toString());
        return;
    L5:
        r4 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(s<R> r3, DataSource r4, boolean r5) {
        s<R> r6 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.pool.a.a("DecodeJob.notifyEncodeAndRelease");
    L22:
        th = move-exception;
        com.bumptech.glide.util.pool.a.a();
        throw th;
    L4:
        if (ZeusTransformUtils.instanceOf(r6, o.class) == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r6, o.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L22
    L6:
        r r0 = 0;
        if (this.f.a() == false) goto L9;
        r6 = r.a(r6);     // Catch: Throwable -> L22
        r0 = r6;
    L9:
        a(r6, r4, r5);     // Catch: Throwable -> L22
        this.r = Stage.ENCODE;     // Catch: Throwable -> L22
    L18:
        th = move-exception;
        if (r0 == 0) goto L21;
        r0.a();     // Catch: Throwable -> L22
    L21:
        throw th;     // Catch: Throwable -> L22
    L11:
        if (this.f.a() == false) goto L13;
        this.f.a(this.d, this.o);     // Catch: Throwable -> L18
    L13:
        if (r0 == 0) goto L15;
        r0.a();     // Catch: Throwable -> L22
    L15:
        e();     // Catch: Throwable -> L22
        com.bumptech.glide.util.pool.a.a();
    }

    private void e() {
        if (this.g.a() == false) goto L6;
        g();
        return;
    }

    private void f() {
        if (this.g.b() == false) goto L6;
        g();
        return;
    }

    private void g() {
        this.g.c();
        this.f.b();
        this.f697a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.f698b.clear();
        this.e.release(this);
    }

    private int h() {
        return this.j.ordinal();
    }

    private void i() {
        int r0 = AnonymousClass1.f699a[this.s.ordinal()];
        if (r0 != 1) goto L5;
        this.r = a(Stage.INITIALIZE);
        this.C = j();
    L12:
        k();
        return;
    L5:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L10;
        n();
        return;
    L10:
        throw new IllegalStateException("Unrecognized run reason: " + this.s);
    }

    private com.bumptech.glide.load.engine.e j() {
        int r0 = AnonymousClass1.f700b[this.r.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    L15:
        return new w(this.f697a, this);
    L17:
        return new com.bumptech.glide.load.engine.b(this.f697a, this);
    L19:
        return new t(this.f697a, this);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.util.f.a();
        boolean r0 = false;
    L4:
        if (this.E == true) goto L14;
        if (this.C == null) goto L14;
        r0 = this.C.a();
        if (r0 == true) goto L14;
        this.r = a(this.r);
        this.C = j();
        if (this.r != Stage.SOURCE) goto L4;
        a(RunReason.SWITCH_TO_SOURCE_SERVICE);
        return;
    L14:
        if (this.r != Stage.FINISHED) goto L16;
    L17:
        if (r0 == true) goto L26;
        l();
        return;
    L26:
        return;
    L16:
        if (this.E == true) goto L17;
    }

    private void l() {
        m();
        GlideException r0 = new GlideException("Failed to load resource", new ArrayList(this.f698b));
        this.p.a(r0);
        f();
    }

    private void m() {
        this.c.b();
        if (this.D == true) goto L5;
        this.D = true;
        return;
    L5:
        if (this.f698b.isEmpty() == false) goto L7;
        Throwable r2 = null;
    L9:
        throw new IllegalStateException("Already notified", r2);
    L7:
        List<Throwable> r3 = this.f698b;
        r2 = (Throwable) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), Throwable.class, "com.obric.memorydata.plugin");
        goto L9
    }

    private void n() {
        if (Log.isLoggable("DecodeJob", 2) == false) goto L5;
        a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
    L5:
        s<R> r0 = null;
        r0 = a(this.B, this.z, this.A);     // Catch: GlideException -> L8
    L10:
        if (r0 == null) goto L12;
        b(r0, this.A, this.F);
        return;
    L12:
        k();
        return;
    L8:
        e = move-exception;
        e.setLoggingDetails(this.y, this.A);
        this.f698b.add(e);
        goto L10
    }

    public int a(DecodeJob<?> r3) {
        int r0 = h() - r3.h();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.q - r3.q;
    }

    DecodeJob<R> a(com.bumptech.glide.e r19, Object r20, l r21, com.bumptech.glide.load.c r22, int r23, int r24, Class<?> r25, Class<R> r26, Priority r27, h r28, Map<Class<?>, com.bumptech.glide.load.h<?>> r29, boolean r30, boolean r31, boolean r32, com.bumptech.glide.load.e r33, a<R> r34, int r35) {
        com.bumptech.glide.e r1 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r19, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r15 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map<Class<?>, com.bumptech.glide.load.h<?>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.memorydata.plugin");
        a<R> r2 = (a) ZeusTransformUtils.wrapperContextForParams(r34, a.class, "com.obric.memorydata.plugin");
        this.f697a.a(r1, r20, r15, r23, r24, r28, r25, r26, r27, r33, r14, r30, r31, this.d);
        this.h = r1;
        this.i = r15;
        this.j = r27;
        this.k = r21;
        this.l = r23;
        this.m = r24;
        this.n = r28;
        this.u = r32;
        this.o = r33;
        this.p = r2;
        this.q = r35;
        this.s = RunReason.INITIALIZE;
        this.v = r20;
        return this;
    }

    <Z> s<Z> a(DataSource r12, s<Z> r13) {
        s<Z> r14 = (s) ZeusTransformUtils.wrapperContextForParams(r13, s.class, "com.obric.memorydata.plugin");
        Class<?> r8 = r14.d().getClass();
        com.bumptech.glide.load.g<Z> r1 = null;
        if (r12 == DataSource.RESOURCE_DISK_CACHE) goto L5;
        com.bumptech.glide.load.h<Z> r0 = this.f697a.c(r8);
        com.bumptech.glide.load.h<Z> r7 = r0;
        s<Z> r2 = r0.a(this.h, r14, this.l, this.m);
    L7:
        if (r14.equals(r2) == true) goto L10;
        r14.f();
    L10:
        if (this.f697a.a(r2) == false) goto L12;
        r1 = this.f697a.b(r2);
        EncodeStrategy r15 = r1.a(this.o);
    L13:
        com.bumptech.glide.load.g r10 = r1;
        if (this.n.a(!this.f697a.a(this.x), r12, r15) == false) goto L27;
        if (r10 == null) goto L26;
        int r16 = AnonymousClass1.c[r15.ordinal()];
        if (r16 != 1) goto L19;
        com.bumptech.glide.load.c r17 = new com.bumptech.glide.load.engine.c(this.x, this.i);
    L24:
        r r3 = r.a(r2);
        this.f.a(r17, r10, r3);
        return r3;
    L19:
        if (r16 != 2) goto L22;
        r17 = new u(this.f697a.i(), this.x, this.i, this.l, this.m, r7, r8, this.o);
        goto L24
    L22:
        throw new IllegalArgumentException("Unknown strategy: " + r15);
    L26:
        throw new Registry.NoResultEncoderAvailableException(r2.d().getClass());
    L27:
        return r2;
    L12:
        r15 = EncodeStrategy.NONE;
        goto L13
    L5:
        r2 = r14;
        r7 = null;
        goto L7
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c r3, Exception r4, com.bumptech.glide.load.data.d<?> r5, DataSource r6) {
        com.bumptech.glide.load.c r7 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.data.d r8 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        r8.b();
        GlideException r0 = new GlideException("Fetching data failed", r4);
        r0.setLoggingDetails(r7, r6, r8.a());
        this.f698b.add(r0);
        if (Thread.currentThread() == this.w) goto L5;
        a(RunReason.SWITCH_TO_SOURCE_SERVICE);
        return;
    L5:
        k();
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c r3, Object r4, com.bumptech.glide.load.data.d<?> r5, DataSource r6, com.bumptech.glide.load.c r7) {
        com.bumptech.glide.load.c r8 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.data.d<?> r9 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r10 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.x = r8;
        this.z = r4;
        this.B = r9;
        this.A = r6;
        this.y = r10;
        boolean r11 = false;
        if (r8 == this.f697a.o().get(0)) goto L5;
        r11 = true;
    L5:
        this.F = r11;
        if (Thread.currentThread() == this.w) goto L8;
        a(RunReason.DECODE_DATA);
        return;
    L8:
        com.bumptech.glide.util.pool.a.a("DecodeJob.decodeFromRetrievedData");
        n();     // Catch: Throwable -> L12
        com.bumptech.glide.util.pool.a.a();
        return;
    L12:
        th = move-exception;
        com.bumptech.glide.util.pool.a.a();
        throw th;
    }

    void a(boolean r2) {
        if (this.g.a(r2) == false) goto L6;
        g();
        return;
    }

    boolean a() {
        Stage r1 = a(Stage.INITIALIZE);
        if (r1 != Stage.RESOURCE_CACHE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Stage.DATA_CACHE) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.b
    public com.bumptech.glide.util.pool.b a_() {
        return this.c;
    }

    public void b() {
        this.E = true;
        com.bumptech.glide.load.engine.e r1 = this.C;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c() {
        a(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(DecodeJob<?> r3) {
        return a((DecodeJob) ZeusTransformUtils.preCheckCast(r3, DecodeJob.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.pool.a.a("DecodeJob#run(reason=%s, model=%s)", this.s, this.v);
        com.bumptech.glide.load.data.d<?> r1 = this.B;
    L29:
        th = move-exception;
        if (r1 == null) goto L32;
        r1.b();
    L32:
        com.bumptech.glide.util.pool.a.a();
        throw th;
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L29
    L15:
        th = move-exception;
        if (Log.isLoggable("DecodeJob", 3) == false) goto L21;
        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r, th);     // Catch: Throwable -> L29
    L21:
        if (this.r == Stage.ENCODE) goto L24;
        this.f698b.add(th);     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
    L24:
        if (this.E == true) goto L26;
        throw th;     // Catch: Throwable -> L29
    L26:
        throw th;     // Catch: Throwable -> L29
    L4:
        if (this.E == false) goto L10;
        l();     // Catch: Throwable -> L15 CallbackException -> L27
        if (r1 == null) goto L8;
        r1.b();
    L8:
        com.bumptech.glide.util.pool.a.a();
        return;
    L10:
        i();     // Catch: Throwable -> L15 CallbackException -> L27
        if (r1 == null) goto L13;
        r1.b();
    L13:
        com.bumptech.glide.util.pool.a.a();
    }
}
