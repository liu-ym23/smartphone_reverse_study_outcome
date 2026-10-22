package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t0 extends u0 implements i0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10066q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10067r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10068s = null;
    private volatile Object _delayed;
    private volatile int _isCompleted;
    private volatile Object _queue;

    public final class a extends c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final g<xd.j> f10069m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ t0 f10070n;

        public a(t0 r8, long r10, h r11) {
            this.f10070n = r8;
            super(r10);
            this.f10069m = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xd.j r8 = xd.j.f13877a;
            this.f10069m.c(this.f10070n, r8);
        }

        @Override // pe.t0.c
        public final String toString() {
            return super.toString() + this.f10069m;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Runnable f10071m;

        public b(Runnable r8, long r10) {
            super(r10);
            this.f10071m = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10071m.run();
        }

        @Override // pe.t0.c
        public final String toString() {
            return super.toString() + this.f10071m;
        }
    }

    public static abstract class c implements Runnable, Comparable<c>, o0, ue.y {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10073b;

        public c(long r8) {
            this.f10072a = r8;
            this.f10073b = -1;
        }

        @Override // ue.y
        public final void a(d r8) {
            if (this._heap == v0.f10077a) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L10;
            this._heap = r8;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r10 = false;
            goto L6
        }

        public final int c(long r10, d r11, t0 r12) {
            monitor-enter(this);
        L40:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != v0.f10077a) goto L8;
            monitor-exit(this);
            return 2;
        L8:
            monitor-enter(r11);     // Catch: Throwable -> L40
            Object[] r8 = r11.f12635a;     // Catch: Throwable -> L12
            if (r8 == null) goto L14;
            Object r13 = r8[0];     // Catch: Throwable -> L12
        L15:
            c r14 = (c) r13;     // Catch: Throwable -> L12
            if (t0.z0(r12) == false) goto L22;
            monitor-exit(r11);     // Catch: Throwable -> L40
            monitor-exit(this);
            return 1;
        L22:
            if (r14 == null) goto L30;
            long r15 = r14.f10072a;     // Catch: Throwable -> L12
            if ((r15 - r10) >= 0) goto L29;
            r10 = r15;
        L29:
            if ((r10 - r11.f10074c) > 0) goto L30;
        L31:
            long r16 = this.f10072a;     // Catch: Throwable -> L12
            long r17 = r11.f10074c;     // Catch: Throwable -> L12
            if ((r16 - r17) >= 0) goto L34;
            this.f10072a = r17;     // Catch: Throwable -> L12
        L34:
            r11.a(this);     // Catch: Throwable -> L12
            monitor-exit(r11);     // Catch: Throwable -> L40
            monitor-exit(this);
            return 0;
        L30:
            r11.f10074c = r10;     // Catch: Throwable -> L12
            goto L31
        L14:
            r13 = null;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L40
        }

        @Override // java.lang.Comparable
        public final int compareTo(c r8) {
            long r10 = this.f10072a - r8.f10072a;
            if (r10 <= 0) goto L5;
            return 1;
        L5:
            if (r10 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        @Override // pe.o0
        public final void e() {
            monitor-enter(this);
            Object r8 = this._heap;     // Catch: Throwable -> L27
            b9.a r10 = v0.f10077a;     // Catch: Throwable -> L27
            if (r8 != r10) goto L7;
            monitor-exit(this);
            return;
        L7:
            ue.x r11 = null;
            if ((r8 instanceof d) == false) goto L10;
            d r12 = (d) r8;     // Catch: Throwable -> L27
        L11:
            if (r12 == null) goto L24;
            monitor-enter(r12);     // Catch: Throwable -> L27
            Object r13 = this._heap;     // Catch: Throwable -> L21
            if ((r13 instanceof ue.x) == false) goto L16;
            r11 = (ue.x) r13;     // Catch: Throwable -> L21
        L16:
            if (r11 == null) goto L19;
            r12.c(this.f10073b);     // Catch: Throwable -> L21
        L19:
            monitor-exit(r12);     // Catch: Throwable -> L27
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L24:
            this._heap = r10;     // Catch: Throwable -> L27
            xd.j r14 = xd.j.f13877a;     // Catch: Throwable -> L27
            monitor-exit(this);
            return;
        L10:
            r12 = null;
        L27:
            th = move-exception;
            throw th;
        }

        @Override // ue.y
        public final void setIndex(int r8) {
            this.f10073b = r8;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f10072a + ']';
        }
    }

    public static final class d extends ue.x<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f10074c;

        public d(long r8) {
            this.f10074c = r8;
        }
    }

    static {
        f10066q = AtomicReferenceFieldUpdater.newUpdater(t0.class, Object.class, "_queue");
        f10067r = AtomicReferenceFieldUpdater.newUpdater(t0.class, Object.class, "_delayed");
        f10068s = AtomicIntegerFieldUpdater.newUpdater(t0.class, "_isCompleted");
    }

    public t0() {
        this._isCompleted = 0;
    }

    public static final boolean z0(t0 r8) {
        r8.getClass();
        if (f10068s.get(r8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void A0(Runnable r8) {
        if (B0(r8) == false) goto L7;
        Thread r10 = x0();
        if (Thread.currentThread() == r10) goto L9;
        LockSupport.unpark(r10);
        return;
    L9:
        return;
    L7:
        e0.f10005t.A0(r8);
    }

    public final boolean B0(Runnable r8) {
    L2:
        AtomicReferenceFieldUpdater r10 = f10066q;
        Object r11 = r10.get(this);
        boolean r12 = false;
        if (f10068s.get(this) == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L7;
        if (r11 == null) goto L10;
        if ((r11 instanceof ue.n) == true) goto L18;
        if (r11 == v0.f10078b) goto L35;
        ue.n r14 = new ue.n(8, true);
        r14.a((Runnable) r11);
        r14.a(r8);
    L38:
        if (r10.compareAndSet(this, r11, r14) == true) goto L39;
        if (r10.get(this) == r11) goto L38;
    L42:
        if (r12 == false) goto L2;
        return true;
    L39:
        r12 = true;
        goto L42
    L35:
        return false;
    L18:
        ue.n r15 = (ue.n) r11;
        int r16 = r15.a(r8);
        if (r16 == 0) goto L32;
        if (r16 != 1) goto L22;
        ue.n r17 = r15.c();
    L27:
        if (r10.compareAndSet(this, r11, r17) == true) goto L2;
        if (r10.get(this) == r11) goto L27;
    L22:
        if (r16 != 2) goto L2;
        return false;
    L32:
        return true;
    L10:
        if (r10.compareAndSet(this, null, r8) == true) goto L11;
        if (r10.get(this) == null) goto L10;
    L14:
        if (r12 == false) goto L2;
        return true;
    L11:
        r12 = true;
        goto L14
    L7:
        return false;
    L5:
        r13 = false;
        goto L6
    }

    public final boolean C0() {
        yd.d<m0<?>> r8 = this.f10063o;
        if (r8 == null) goto L5;
        boolean r10 = r8.isEmpty();
    L7:
        if (r10 == true) goto L9;
        return false;
    L9:
        d r11 = (d) f10067r.get(this);
        if (r11 != null) goto L12;
    L17:
        Object r12 = f10066q.get(this);
        if (r12 != null) goto L21;
        return true;
    L21:
        if ((r12 instanceof ue.n) == false) goto L26;
        long r13 = ue.n.f12616f.get((ue.n) r12);
        if (((int) ((1073741823 & r13) >> 0)) != ((int) ((r13 & 1152921503533105152L) >> 30))) goto L29;
        return true;
    L29:
        return false;
    L26:
        if (r12 != v0.f10078b) goto L29;
        return true;
    L12:
        if (r11.b() != 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == true) goto L17;
        return false;
    L14:
        r14 = false;
        goto L15
    L5:
        r10 = true;
        goto L7
    }

    public final void D0(long r8, c r10) {
        boolean r11 = true;
        if (f10068s.get(this) == 0) goto L5;
        boolean r12 = true;
    L6:
        AtomicReferenceFieldUpdater r13 = f10067r;
        Object r14 = null;
        if (r12 == false) goto L9;
        int r15 = 1;
    L19:
        if (r15 == 0) goto L27;
        if (r15 != 1) goto L22;
        y0(r8, r10);
        return;
    L22:
        if (r15 != 2) goto L25;
        return;
    L25:
        throw new IllegalStateException("unexpected result".toString());
    L27:
        d r16 = (d) r13.get(this);
        if (r16 == null) goto L38;
        monitor-enter(r16);
        Object[] r17 = r16.f12635a;     // Catch: Throwable -> L35
        if (r17 == null) goto L33;
        r14 = r17[0];     // Catch: Throwable -> L35
    L33:
        monitor-exit(r16);
        r14 = (c) r14;
    L35:
        th = move-exception;
        throw th;
    L38:
        if (r14 == r10) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L52;
        Thread r18 = x0();
        if (Thread.currentThread() == r18) goto L53;
        LockSupport.unpark(r18);
        return;
    L53:
        return;
    L52:
        return;
    L9:
        d r19 = (d) r13.get(this);
        if (r19 != null) goto L18;
        d r20 = new d(r8);
    L13:
        if (r13.compareAndSet(this, null, r20) == true) goto L17;
        if (r13.get(this) == null) goto L13;
    L17:
        Object r21 = r13.get(this);
        he.i.c(r21);
        r19 = (d) r21;
    L18:
        r15 = r10.c(r8, r19, this);
        goto L19
    L5:
        r12 = false;
        goto L6
    }

    public o0 V(long r8, Runnable r10, ae.f r11) {
        return i0.a.a(r8, r10, r11);
    }

    @Override // pe.i0
    public final void r(h r8) {
        b9.a r10 = v0.f10077a;
        long r11 = System.nanoTime();
        a r12 = new a(this, 30000000000L + r11, r8);
        D0(r11, r12);
        r8.s(new p0(r12));
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        A0(r10);
    }

    @Override // pe.s0
    public void shutdown() {
        ThreadLocal<s0> r8 = u1.f10076a;
        u1.f10076a.set(null);
        f10068s.set(this, 1);
    L3:
        AtomicReferenceFieldUpdater r10 = f10066q;
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if ((r11 instanceof ue.n) == true) goto L16;
        if (r11 == v0.f10078b) goto L29;
        ue.n r12 = new ue.n(8, true);
        r12.a((Runnable) r11);
    L22:
        if (r10.compareAndSet(this, r11, r12) == true) goto L23;
        if (r10.get(this) == r11) goto L22;
        boolean r13 = false;
    L27:
        if (r13 == false) goto L3;
    L23:
        r13 = true;
    L29:
        if (v0() <= 0) goto L29;
        long r14 = System.nanoTime();
    L31:
        d r15 = (d) f10067r.get(this);
        if (r15 == null) goto L47;
        monitor-enter(r15);
    L44:
        th = move-exception;
        throw th;
    L35:
        if (r15.b() <= 0) goto L38;
        c r16 = r15.c(0);     // Catch: Throwable -> L44
    L39:
        monitor-exit(r15);
        c r17 = r16;
        if (r17 == null) goto L70;
        y0(r14, r17);
        goto L31
    L70:
        return;
    L38:
        r16 = null;
        goto L39
    L47:
        return;
    L16:
        ((ue.n) r11).b();
        goto L29
    L5:
        b9.a r18 = v0.f10078b;
    L7:
        if (r10.compareAndSet(this, null, r18) == true) goto L8;
        if (r10.get(this) == null) goto L7;
        boolean r19 = false;
    L12:
        if (r19 == false) goto L3;
    L8:
        r19 = true;
        goto L12
    }

    @Override // pe.s0
    public final long v0() {
        if (w0() == false) goto L5;
        return 0;
    L5:
        d r8 = (d) f10067r.get(this);
        Object r10 = null;
        boolean r11 = true;
        if (r8 == null) goto L40;
        if (r8.b() != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L40;
        long r13 = System.nanoTime();
    L13:
        monitor-enter(r8);
        Object[] r14 = r8.f12635a;     // Catch: Throwable -> L37
        if (r14 == null) goto L18;
        Object r15 = r14[0];     // Catch: Throwable -> L37
    L19:
        if (r15 != null) goto L22;
        monitor-exit(r8);
        c r16 = null;
    L35:
        if (r16 != null) goto L13;
    L22:
        c r17 = (c) r15;     // Catch: Throwable -> L37
        if ((r13 - r17.f10072a) < 0) goto L25;
        boolean r18 = true;
    L26:
        if (r18 == false) goto L28;
        boolean r19 = B0(r17);     // Catch: Throwable -> L37
    L29:
        if (r19 == false) goto L32;
        r16 = r8.c(0);     // Catch: Throwable -> L37
    L33:
        monitor-exit(r8);
        goto L35
    L32:
        r16 = null;
        goto L33
    L28:
        r19 = false;
        goto L29
    L25:
        r18 = false;
        goto L26
    L18:
        r15 = null;
    L37:
        th = move-exception;
        throw th;
    L10:
        r12 = false;
    L40:
        AtomicReferenceFieldUpdater r20 = f10066q;
        Object r21 = r20.get(this);
        if (r21 == null) goto L57;
        if ((r21 instanceof ue.n) == true) goto L45;
        if (r21 == v0.f10078b) goto L57;
    L59:
        if (r20.compareAndSet(this, r21, null) == true) goto L60;
        if (r20.get(this) == r21) goto L59;
        boolean r22 = false;
    L64:
        if (r22 == false) goto L40;
        Runnable r23 = (Runnable) r21;
    L66:
        if (r23 == null) goto L69;
        r23.run();
        return 0;
    L69:
        yd.d<m0<?>> r24 = this.f10063o;
        if (r24 != null) goto L73;
    L74:
        long r25 = Long.MAX_VALUE;
    L77:
        if (r25 == 0) goto L134;
        Object r26 = f10066q.get(this);
        if (r26 != null) goto L82;
    L92:
        d r110 = (d) f10067r.get(this);
        if (r110 == null) goto L110;
        monitor-enter(r110);
        Object[] r27 = r110.f12635a;     // Catch: Throwable -> L106
        if (r27 == null) goto L98;
        r10 = r27[0];     // Catch: Throwable -> L106
    L98:
        monitor-exit(r110);
        c r28 = (c) r10;
        if (r28 == null) goto L110;
        long r29 = r28.f10072a - System.nanoTime();
        if (r29 >= 0) goto L133;
        return 0;
    L133:
        return r29;
    L106:
        th = move-exception;
        throw th;
    L110:
        return Long.MAX_VALUE;
    L82:
        if ((r26 instanceof ue.n) == false) goto L90;
        long r30 = ue.n.f12616f.get((ue.n) r26);
        if (((int) ((1073741823 & r30) >> 0)) == ((int) ((r30 & 1152921503533105152L) >> 30))) goto L87;
        r11 = false;
    L87:
        if (r11 == true) goto L92;
        return 0;
    L90:
        if (r26 == v0.f10078b) goto L110;
        return 0;
    L134:
        return 0;
    L73:
        if (r24.isEmpty() == true) goto L74;
        r25 = 0;
        goto L77
    L60:
        r22 = true;
        goto L64
    L45:
        ue.n r31 = (ue.n) r21;
        Object r32 = r31.d();
        if (r32 != ue.n.f12617g) goto L47;
        ue.n r33 = r31.c();
    L50:
        if (r20.compareAndSet(this, r21, r33) == true) goto L40;
        if (r20.get(this) == r21) goto L50;
    L47:
        r23 = (Runnable) r32;
    L57:
        r23 = null;
        goto L66
    }
}
