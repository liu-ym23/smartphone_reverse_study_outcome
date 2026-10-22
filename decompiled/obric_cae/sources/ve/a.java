package ve;

import he.o;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import pe.d0;
import ue.s;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12847r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12848s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12849t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final b9.a f12850u = null;
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12852b;
    private volatile long controlState;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f12853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f12854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f12855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f12856p;
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final s<C0184a> f12857q;

    /* JADX INFO: renamed from: ve.a$a, reason: collision with other inner class name */
    public final class C0184a extends Thread {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f12858s = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f12859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<g> f12860b;
        private volatile int indexInArray;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public b f12861m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f12862n;
        private volatile Object nextParkedWorker;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f12863o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12864p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f12865q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ a f12866r;
        private volatile int workerCtl;

        static {
            f12858s = AtomicIntegerFieldUpdater.newUpdater(C0184a.class, "workerCtl");
        }

        public C0184a() {
            throw null;
        }

        public C0184a(a r8, int r10) {
            this.f12866r = r8;
            setDaemon(true);
            this.f12859a = new m();
            this.f12860b = new o();
            this.f12861m = b.f12870n;
            this.nextParkedWorker = a.f12850u;
            this.f12864p = ie.c.f8327a.a();
            f(r10);
        }

        public final g a(boolean r11) {
            boolean r8 = false;
            if (this.f12861m == b.f12867a) goto L14;
            a r10 = this.f12866r;
            AtomicLongFieldUpdater r12 = a.f12848s;
        L6:
            long r13 = r12.get(r10);
            if (((int) ((9223367638808264704L & r13) >> 42)) == 0) goto L8;
            if (a.f12848s.compareAndSet(r10, r13, r13 - 4398046511104L) == false) goto L6;
            boolean r14 = true;
        L12:
            if (r14 == false) goto L15;
            this.f12861m = b.f12867a;
            goto L14
        L15:
            boolean r15 = false;
        L16:
            a r16 = this.f12866r;
            g r17 = null;
            m r18 = this.f12859a;
            if (r15 == false) goto L40;
            if (r11 == true) goto L20;
            g r19 = e();
            if (r19 == null) goto L39;
            return r19;
        L39:
            return i(3);
        L20:
            if (d(r16.f12851a * 2) != 0) goto L22;
            r8 = true;
        L22:
            if (r8 == false) goto L26;
            g r110 = e();
            if (r110 == null) goto L26;
            return r110;
        L26:
            r18.getClass();
            g r111 = (g) m.f12891b.getAndSet(r18, null);
            if (r111 != null) goto L29;
            r111 = r18.b();
        L29:
            if (r111 != null) goto L87;
            if (r8 == true) goto L39;
            g r112 = e();
            if (r112 == null) goto L39;
            return r112;
        L87:
            return r111;
        L40:
            r18.getClass();
        L41:
            AtomicReferenceFieldUpdater r113 = m.f12891b;
            g r20 = (g) r113.get(r18);
            if (r20 == null) goto L57;
            if (r20.f12879b.b() != 1) goto L47;
            boolean r21 = true;
        L48:
            if (r21 != true) goto L57;
        L50:
            if (r113.compareAndSet(r18, r20, null) == true) goto L51;
            if (r113.get(r18) == r20) goto L50;
            boolean r114 = false;
        L55:
            if (r114 == false) goto L41;
            r17 = r20;
        L65:
            if (r17 != null) goto L90;
            g r22 = r16.f12856p.d();
            if (r22 == null) goto L69;
            return r22;
        L69:
            return i(1);
        L90:
            return r17;
        L51:
            r114 = true;
            goto L55
        L47:
            r21 = false;
        L57:
            int r115 = m.f12893d.get(r18);
            int r23 = m.f12892c.get(r18);
        L58:
            if (r115 == r23) goto L65;
            if (m.f12894e.get(r18) == 0) goto L65;
            r23 = r23 - 1;
            g r24 = r18.c(r23, true);
            if (r24 == null) goto L58;
            r17 = r24;
            goto L65
        L8:
            r14 = false;
        L14:
            r15 = true;
            goto L16
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int r8) {
            int r10 = this.f12864p;
            int r11 = r10 ^ (r10 << 13);
            int r12 = r11 ^ (r11 >> 17);
            int r13 = r12 ^ (r12 << 5);
            this.f12864p = r13;
            int r14 = r8 - 1;
            if ((r14 & r8) != 0) goto L7;
            return r14 & r13;
        L7:
            return (Integer.MAX_VALUE & r13) % r8;
        }

        public final g e() {
            int r8 = d(2);
            a r10 = this.f12866r;
            if (r8 != 0) goto L10;
            g r11 = r10.f12855o.d();
            if (r11 == null) goto L7;
            return r11;
        L7:
            d r12 = r10.f12856p;
        L9:
            return r12.d();
        L10:
            g r13 = r10.f12856p.d();
            if (r13 == null) goto L13;
            return r13;
        L13:
            r12 = r10.f12855o;
            goto L9
        }

        public final void f(int r8) {
            StringBuilder r10 = new StringBuilder();
            r10.append(this.f12866r.f12854n);
            r10.append("-worker-");
            if (r8 != 0) goto L5;
            String r11 = "TERMINATED";
        L6:
            r10.append(r11);
            setName(r10.toString());
            this.indexInArray = r8;
            return;
        L5:
            r11 = String.valueOf(r8);
            goto L6
        }

        public final void g(Object r8) {
            this.nextParkedWorker = r8;
        }

        public final boolean h(b r8) {
            b r10 = this.f12861m;
            if (r10 != b.f12867a) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L8;
            a.f12848s.addAndGet(this.f12866r, 4398046511104L);
        L8:
            if (r10 == r8) goto L10;
            this.f12861m = r8;
        L10:
            return r11;
        L5:
            r11 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1, types: [T, java.lang.Object, ve.g] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v5, types: [ve.g] */
        /* JADX WARN: Type inference failed for: r9v9, types: [ve.g] */
        public final g i(int r21) {
            AtomicLongFieldUpdater r8 = a.f12848s;
            a r10 = this.f12866r;
            int r11 = (int) (r8.get(r10) & 2097151);
            Object r12 = null;
            if (r11 >= 2) goto L5;
            return null;
        L5:
            int r13 = d(r11);
            int r14 = 0;
            long r15 = Long.MAX_VALUE;
        L6:
            if (r14 >= r11) goto L70;
            int r16 = r13 + 1;
            if (r16 <= r11) goto L10;
            r16 = 1;
        L10:
            C0184a r17 = r10.f12857q.b(r16);
            if (r17 == null) goto L67;
            if (r17 == this) goto L67;
            m r18 = r17.f12859a;
            if (r21 != 3) goto L16;
            T r19 = r18.b();
        L29:
            o<g> r110 = this.f12860b;
            if (r19 == 0) goto L32;
            r110.f8064a = r19;
            int r111 = r16;
        L57:
            long r20 = -1;
            long r22 = -1;
        L59:
            if (r22 == r20) goto L60;
            if (r22 <= 0) goto L68;
            r15 = Math.min(r15, r22);
        L68:
            r14 = r14 + 1;
            r13 = r111;
            r12 = null;
            goto L6
        L60:
            g r23 = r110.f8064a;
            r110.f8064a = null;
            return r23;
        L32:
            AtomicReferenceFieldUpdater r24 = m.f12891b;
            ?? r112 = (g) r24.get(r18);
            if (r112 == 0) goto L44;
            if (r112.f12879b.b() != 1) goto L38;
            boolean r25 = true;
        L39:
            if (r25 == false) goto L41;
            int r26 = 1;
        L43:
            if ((r26 & r21) == 0) goto L44;
            k.f12887f.getClass();
            r111 = r16;
            long r27 = System.nanoTime() - r112.f12878a;
            long r28 = k.f12883b;
            if (r27 < r28) goto L48;
        L50:
            if (r24.compareAndSet(r18, r112, null) == true) goto L51;
            if (r24.get(r18) == r112) goto L50;
            boolean r29 = false;
        L55:
            if (r29 == true) goto L56;
            r16 = r111;
            goto L32
        L56:
            r110.f8064a = r112;
            goto L57
        L51:
            r29 = true;
            goto L55
        L48:
            r22 = r28 - r27;
        L45:
            r20 = -1;
            goto L59
        L41:
            r26 = 2;
            goto L43
        L38:
            r25 = false;
        L44:
            r22 = -2;
            r111 = r16;
            goto L45
        L16:
            r18.getClass();
            int r30 = m.f12893d.get(r18);
            int r31 = m.f12892c.get(r18);
            if (r21 != 1) goto L19;
            boolean r32 = true;
        L20:
            if (r30 == r31) goto L28;
            if (r32 == true) goto L23;
        L25:
            int r113 = r30 + 1;
            r19 = r18.c(r30, r32);
            if (r19 != 0) goto L29;
            r30 = r113;
            goto L20
        L23:
            if (m.f12894e.get(r18) != 0) goto L25;
        L28:
            r19 = r12;
            goto L29
        L19:
            r32 = false;
        L67:
            r111 = r16;
            goto L68
        L70:
            if (r15 != Long.MAX_VALUE) goto L73;
            r15 = 0;
        L73:
            this.f12863o = r15;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
        L3:
            boolean r8 = false;
            boolean r10 = false;
        L4:
            a r11 = this.f12866r;
            r11.getClass();
            if (a.f12849t.get(r11) == 0) goto L7;
            boolean r12 = true;
        L8:
            if (r12 == true) goto L99;
            b r13 = this.f12861m;
            b r14 = b.f12871o;
            if (r13 == r14) goto L99;
            g r15 = a(this.f12865q);
            if (r15 != null) goto L13;
            this.f12865q = r8;
            if (this.f12863o != 0) goto L36;
            Object r16 = this.nextParkedWorker;
            b9.a r17 = a.f12850u;
            if (r16 == r17) goto L42;
            boolean r18 = true;
        L44:
            if (r18 == true) goto L51;
            a r19 = this.f12866r;
            r19.getClass();
            if (this.nextParkedWorker != r17) goto L98;
        L48:
            AtomicLongFieldUpdater r110 = a.f12847r;
            long r111 = r110.get(r19);
            int r20 = this.indexInArray;
            this.nextParkedWorker = r19.f12857q.b((int) (r111 & 2097151));
            if (r110.compareAndSet(r19, r111, ((2097152 + r111) & (-2097152)) | ((long) r20)) == false) goto L48;
        L98:
            r8 = r8;
            r10 = r10;
            goto L4
        L51:
            f12858s.set(this, -1);
        L53:
            if (this.nextParkedWorker == a.f12850u) goto L55;
            boolean r21 = true;
        L56:
            if (r21 == false) goto L98;
            AtomicIntegerFieldUpdater r22 = f12858s;
            if (r22.get(this) != (-1)) goto L98;
            a r23 = this.f12866r;
            r23.getClass();
            AtomicIntegerFieldUpdater r24 = a.f12849t;
            if (r24.get(r23) == 0) goto L62;
            boolean r25 = true;
        L63:
            if (r25 == true) goto L98;
            b r26 = this.f12861m;
            b r112 = b.f12871o;
            if (r26 == r112) goto L98;
            h(b.f12869m);
            Thread.interrupted();
            if (this.f12862n != 0) goto L71;
            this.f12862n = System.nanoTime() + this.f12866r.f12853m;
        L71:
            LockSupport.parkNanos(this.f12866r.f12853m);
            if ((System.nanoTime() - this.f12862n) < 0) goto L97;
            this.f12862n = 0;
            a r27 = this.f12866r;
            s<C0184a> r28 = r27.f12857q;
            monitor-enter(r28);
            if (r24.get(r27) == 0) goto L78;
            boolean r29 = true;
        L79:
            if (r29 == true) goto L86;
            AtomicLongFieldUpdater r30 = a.f12848s;     // Catch: Throwable -> L94
            if (((int) (r30.get(r27) & 2097151)) <= r27.f12851a) goto L86;
            if (r22.compareAndSet(this, -1, 1) == false) goto L86;
            int r31 = this.indexInArray;     // Catch: Throwable -> L94
            f(0);     // Catch: Throwable -> L94
            r27.k(this, r31, 0);     // Catch: Throwable -> L94
            int r32 = (int) (r30.getAndDecrement(r27) & 2097151);     // Catch: Throwable -> L94
            if (r32 == r31) goto L91;
            C0184a r113 = r27.f12857q.b(r32);     // Catch: Throwable -> L94
            he.i.c(r113);     // Catch: Throwable -> L94
            C0184a r114 = r113;     // Catch: Throwable -> L94
            r27.f12857q.c(r31, r114);     // Catch: Throwable -> L94
            r114.f(r31);     // Catch: Throwable -> L94
            r27.k(r114, r32, r31);     // Catch: Throwable -> L94
        L91:
            r27.f12857q.c(r32, null);     // Catch: Throwable -> L94
            xd.j r33 = xd.j.f13877a;     // Catch: Throwable -> L94
            monitor-exit(r28);
            this.f12861m = r112;
            r8 = false;
        L86:
            monitor-exit(r28);
            goto L97
        L78:
            r29 = false;
        L94:
            th = move-exception;
            throw th;
        L97:
            r8 = false;
            goto L53
        L62:
            r25 = r8;
            goto L63
        L55:
            r21 = r8;
            goto L56
        L42:
            r18 = r8;
            goto L44
        L36:
            if (r10 == true) goto L38;
            r10 = true;
            goto L4
        L38:
            h(b.f12869m);
            Thread.interrupted();
            LockSupport.parkNanos(this.f12863o);
            this.f12863o = 0;
            goto L3
        L13:
            this.f12863o = 0;
            int r34 = r15.f12879b.b();
            this.f12862n = 0;
            if (this.f12861m != b.f12869m) goto L16;
            this.f12861m = b.f12868b;
        L16:
            a r35 = this.f12866r;
            if (r34 != 0) goto L20;
        L28:
            r35.getClass();
            a.n(r15);
            if (r34 == 0) goto L3;
            a.f12848s.addAndGet(r35, -2097152);
            if (this.f12861m == r14) goto L3;
            this.f12861m = b.f12870n;
            goto L3
        L20:
            if (h(b.f12868b) == false) goto L28;
            if (r35.v() == true) goto L28;
            if (r35.r(a.f12848s.get(r35)) == true) goto L28;
            r35.v();
        L99:
            h(b.f12871o);
            return;
        L7:
            r12 = r8;
            goto L8
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12867a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12868b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f12869m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f12870n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f12871o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ b[] f12872p = null;

        static {
            b r8 = new b("CPU_ACQUIRED", 0);
            f12867a = r8;
            b r10 = new b("BLOCKING", 1);
            f12868b = r10;
            b r11 = new b("PARKING", 2);
            f12869m = r11;
            b r12 = new b("DORMANT", 3);
            f12870n = r12;
            b r13 = new b("TERMINATED", 4);
            f12871o = r13;
            f12872p = new b[]{r8, r10, r11, r12, r13};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f12872p.clone();
        }
    }

    static {
        f12847r = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
        f12848s = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
        f12849t = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
        f12850u = new b9.a("NOT_IN_STACK", 4);
    }

    public a(long r8, int r10, int r11, String r12) {
        this.f12851a = r10;
        this.f12852b = r11;
        this.f12853m = r8;
        this.f12854n = r12;
        boolean r13 = true;
        if (r10 < 1) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L31;
        if (r11 < r10) goto L9;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L29;
        if (r11 > 2097150) goto L15;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L27;
        if (r8 > 0) goto L21;
        r13 = false;
    L21:
        if (r13 == false) goto L25;
        this.f12855o = new d();
        this.f12856p = new d();
        this.f12857q = new s((r10 + 1) * 2);
        this.controlState = ((long) r10) << 42;
        this._isTerminated = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r8 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(android.aimedia.a.c("Max pool size ", r11, " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r16 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r11 + " should be greater than or equals to core pool size " + r10).toString());
    L9:
        r15 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(android.aimedia.a.c("Core pool size ", r10, " should be at least 1").toString());
    L5:
        r14 = false;
        goto L6
    }

    public static void n(g r8) {
        r8.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Thread r10 = Thread.currentThread();
        r10.getUncaughtExceptionHandler().uncaughtException(r10, th);
    }

    public final int a() {
        s<C0184a> r8 = this.f12857q;
        monitor-enter(r8);
    L44:
        th = move-exception;
        throw th;
    L5:
        boolean r10 = false;
        if (f12849t.get(this) == 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L13;
        monitor-exit(r8);
        return -1;
    L13:
        AtomicLongFieldUpdater r12 = f12848s;     // Catch: Throwable -> L44
        long r13 = r12.get(this);     // Catch: Throwable -> L44
        int r14 = (int) (r13 & 2097151);     // Catch: Throwable -> L44
        int r15 = r14 - ((int) ((r13 & 4398044413952L) >> 21));     // Catch: Throwable -> L44
        if (r15 >= 0) goto L17;
        r15 = 0;
    L17:
        if (r15 < this.f12851a) goto L21;
        monitor-exit(r8);
        return 0;
    L21:
        if (r14 < this.f12852b) goto L24;
        monitor-exit(r8);
        return 0;
    L24:
        int r16 = ((int) (r12.get(this) & 2097151)) + 1;     // Catch: Throwable -> L44
        if (r16 > 0) goto L27;
    L29:
        boolean r17 = false;
    L30:
        if (r17 == false) goto L43;
        C0184a r18 = new C0184a(this, r16);     // Catch: Throwable -> L44
        this.f12857q.c(r16, r18);     // Catch: Throwable -> L44
        if (r16 != ((int) (2097151 & r12.incrementAndGet(this)))) goto L35;
        r10 = true;
    L35:
        if (r10 == false) goto L41;
        int r19 = r15 + 1;
        monitor-exit(r8);
        r18.start();
        return r19;
    L41:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L44
    L43:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L44
    L27:
        if (this.f12857q.b(r16) != null) goto L29;
        r17 = true;
        goto L30
    L8:
        r11 = false;
        goto L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f12849t.compareAndSet(this, 0, 1) == false) goto L65;
        Thread r8 = Thread.currentThread();
        if ((r8 instanceof C0184a) == false) goto L8;
        C0184a r10 = (C0184a) r8;
    L9:
        if (r10 != null) goto L11;
    L13:
        r10 = null;
    L14:
        s<C0184a> r11 = this.f12857q;
        monitor-enter(r11);
        int r12 = (int) (f12848s.get(this) & 2097151);
        monitor-exit(r11);
        if (1 > r12) goto L36;
        int r13 = 1;
    L21:
        C0184a r14 = this.f12857q.b(r13);
        he.i.c(r14);
        C0184a r15 = r14;
        if (r15 != r10) goto L24;
    L34:
        if (r13 == r12) goto L36;
        r13 = r13 + 1;
    L24:
        if (r15.isAlive() == false) goto L26;
        LockSupport.unpark(r15);
        r15.join(10000);
        goto L24
    L26:
        m r16 = r15.f12859a;
        d r17 = this.f12856p;
        r16.getClass();
        g r18 = (g) m.f12891b.getAndSet(r16, null);
        if (r18 == null) goto L29;
        r17.a(r18);
    L29:
        g r19 = r16.b();
        if (r19 != null) goto L32;
        boolean r20 = false;
    L33:
        if (r20 == true) goto L29;
    L32:
        r17.a(r19);
        r20 = true;
    L36:
        this.f12856p.b();
        this.f12855o.b();
    L37:
        if (r10 == null) goto L40;
        g r21 = r10.a(true);
        if (r21 == null) goto L40;
    L48:
        n(r21);
    L40:
        r21 = this.f12855o.d();
        if (r21 != null) goto L48;
        r21 = this.f12856p.d();
        if (r21 != null) goto L48;
        if (r10 == null) goto L46;
        r10.h(b.f12871o);
    L46:
        f12847r.set(this, 0);
        f12848s.set(this, 0);
        return;
    L49:
        th = move-exception;
        throw th;
    L11:
        if (he.i.a(r10.f12866r, this) == false) goto L13;
    L8:
        r10 = null;
        goto L9
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        i(r8, k.f12888g, false);
    }

    public final void i(Runnable r10, h r11, boolean r12) {
        k.f12887f.getClass();
        long r8 = System.nanoTime();
        if ((r10 instanceof g) == false) goto L5;
        g r13 = (g) r10;
        r13.f12878a = r8;
        r13.f12879b = r11;
    L6:
        boolean r14 = false;
        if (r13.f12879b.b() != 1) goto L9;
        boolean r15 = true;
    L10:
        AtomicLongFieldUpdater r16 = f12848s;
        if (r15 == false) goto L13;
        long r17 = r16.addAndGet(this, 2097152);
    L14:
        Thread r18 = Thread.currentThread();
        if ((r18 instanceof C0184a) == false) goto L17;
        C0184a r19 = (C0184a) r18;
    L18:
        if (r19 != null) goto L20;
    L22:
        r19 = null;
    L23:
        if (r19 != null) goto L26;
    L40:
        if (r13 != null) goto L42;
    L53:
        if (r12 == false) goto L56;
        if (r19 == null) goto L56;
        r14 = true;
    L56:
        if (r15 == false) goto L66;
        if (r14 == false) goto L60;
        return;
    L60:
        if (v() == false) goto L63;
        return;
    L63:
        if (r(r17) == true) goto L79;
        v();
        return;
    L79:
        return;
    L66:
        if (r14 == false) goto L69;
        return;
    L69:
        if (v() == false) goto L72;
        return;
    L72:
        if (r(r16.get(this)) == true) goto L81;
        v();
        return;
    L81:
        return;
    L42:
        if (r13.f12879b.b() != 1) goto L44;
        boolean r20 = true;
    L45:
        if (r20 == false) goto L47;
        d r21 = this.f12856p;
    L49:
        if (r21.a(r13) == true) goto L53;
        throw new RejectedExecutionException(android.aimedia.a.i(new StringBuilder(), this.f12854n, " was terminated"));
    L47:
        r21 = this.f12855o;
        goto L49
    L44:
        r20 = false;
        goto L45
    L26:
        if (r19.f12861m == b.f12871o) goto L40;
        if (r13.f12879b.b() == 0) goto L31;
    L33:
        r19.f12865q = true;
        m r22 = r19.f12859a;
        if (r12 == false) goto L36;
        r13 = r22.a(r13);
        goto L40
    L36:
        r22.getClass();
        g r110 = (g) m.f12891b.getAndSet(r22, r13);
        if (r110 != null) goto L39;
        r13 = null;
        goto L40
    L39:
        r13 = r22.a(r110);
        goto L40
    L31:
        if (r19.f12861m != b.f12868b) goto L33;
    L20:
        if (he.i.a(r19.f12866r, this) == false) goto L22;
    L17:
        r19 = null;
        goto L18
    L13:
        r17 = 0;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r13 = new j(r10, r8, r11);
        goto L6
    }

    public final void k(C0184a r10, int r11, int r12) {
    L2:
        long r8 = f12847r.get(this);
        int r13 = (int) (2097151 & r8);
        long r14 = (2097152 + r8) & (-2097152);
        if (r13 != r11) goto L15;
        if (r12 != 0) goto L14;
        C0184a r15 = r10;
    L6:
        Object r16 = r15.c();
        if (r16 == f12850u) goto L8;
        if (r16 == null) goto L10;
        r15 = (C0184a) r16;
        int r17 = r15.b();
        if (r17 == 0) goto L6;
        r13 = r17;
        goto L15
    L10:
        r13 = 0;
        goto L15
    L8:
        r13 = -1;
        goto L15
    L14:
        r13 = r12;
    L15:
        if (r13 < 0) goto L2;
        if (f12847r.compareAndSet(this, r8, ((long) r13) | r14) == false) goto L2;
    }

    public final boolean r(long r8) {
        int r10 = ((int) (2097151 & r8)) - ((int) ((r8 & 4398044413952L) >> 21));
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        int r11 = this.f12851a;
        if (r10 >= r11) goto L13;
        int r12 = a();
        if (r12 != 1) goto L11;
        if (r11 <= 1) goto L11;
        a();
    L11:
        if (r12 <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final String toString() {
        ArrayList r8 = new ArrayList();
        s<C0184a> r10 = this.f12857q;
        int r11 = r10.a();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 1;
    L3:
        if (r17 >= r11) goto L29;
        C0184a r18 = r10.b(r17);
        if (r18 == null) goto L28;
        m r19 = r18.f12859a;
        r19.getClass();
        Object r110 = m.f12891b.get(r19);
        int r111 = m.f12892c.get(r19) - m.f12893d.get(r19);
        if (r110 == null) goto L10;
        r111 = r111 + 1;
    L10:
        int r112 = r18.f12861m.ordinal();
        if (r112 == 0) goto L26;
        if (r112 != 1) goto L14;
        r13 = r13 + 1;
        StringBuilder r113 = new StringBuilder();
        r113.append(r111);
        char r114 = 'b';
    L27:
        r113.append(r114);
        r8.add(r113.toString());
        goto L28
    L14:
        if (r112 != 2) goto L16;
        r14 = r14 + 1;
        goto L28
    L16:
        if (r112 != 3) goto L18;
        r15 = r15 + 1;
        if (r111 <= 0) goto L28;
        r113 = new StringBuilder();
        r113.append(r111);
        r114 = 'd';
        goto L27
    L18:
        if (r112 != 4) goto L28;
        r16 = r16 + 1;
        goto L28
    L26:
        r12 = r12 + 1;
        r113 = new StringBuilder();
        r113.append(r111);
        r114 = 'c';
    L28:
        r17 = r17 + 1;
        goto L3
    L29:
        long r20 = f12848s.get(this);
        StringBuilder r21 = new StringBuilder();
        r21.append(this.f12854n);
        r21.append('@');
        r21.append(d0.c(this));
        r21.append("[Pool Size {core = ");
        int r22 = this.f12851a;
        r21.append(r22);
        r21.append(", max = ");
        defpackage.b.q(r21, this.f12852b, "}, Worker States {CPU = ", r12, ", blocking = ");
        defpackage.b.q(r21, r13, ", parked = ", r14, ", dormant = ");
        defpackage.b.q(r21, r15, ", terminated = ", r16, "}, running workers queues = ");
        r21.append(r8);
        r21.append(", global CPU queue size = ");
        r21.append(this.f12855o.c());
        r21.append(", global blocking queue size = ");
        r21.append(this.f12856p.c());
        r21.append(", Control State {created workers= ");
        r21.append((int) (2097151 & r20));
        r21.append(", blocking tasks = ");
        r21.append((int) ((4398044413952L & r20) >> 21));
        r21.append(", CPUs acquired = ");
        r21.append(r22 - ((int) ((r20 & 9223367638808264704L) >> 42)));
        r21.append("}]");
        return r21.toString();
    }

    public final boolean v() {
    L2:
        AtomicLongFieldUpdater r8 = f12847r;
        long r10 = r8.get(this);
        C0184a r11 = this.f12857q.b((int) (2097151 & r10));
        if (r11 == null) goto L4;
        long r12 = (2097152 + r10) & (-2097152);
        C0184a r13 = r11;
    L6:
        Object r14 = r13.c();
        b9.a r15 = f12850u;
        if (r14 == r15) goto L8;
        if (r14 == null) goto L10;
        r13 = (C0184a) r14;
        int r16 = r13.b();
        if (r16 == 0) goto L6;
    L13:
        if (r16 < 0) goto L2;
        if (r8.compareAndSet(this, r10, r12 | ((long) r16)) == false) goto L2;
        r11.g(r15);
    L17:
        if (r11 == null) goto L18;
        if (C0184a.f12858s.compareAndSet(r11, -1, 0) == false) goto L2;
        LockSupport.unpark(r11);
        return true;
    L18:
        return false;
    L10:
        r16 = 0;
        goto L13
    L8:
        r16 = -1;
        goto L13
    L4:
        r11 = null;
        goto L17
    }
}
