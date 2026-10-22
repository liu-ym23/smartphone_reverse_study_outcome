package ue;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pe.f0;
import pe.i0;
import pe.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends pe.w implements i0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12600r = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final pe.w f12601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f12602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ i0 f12603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m<Runnable> f12604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f12605q;
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f12606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f12607b;

        public a(i r8, Runnable r10) {
            this.f12607b = r8;
            this.f12606a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r8 = 0;
        L16:
            this.f12606a.run();     // Catch: Throwable -> L5
        L7:
            i r10 = this.f12607b;
            Runnable r11 = r10.t0();
            if (r11 == null) goto L9;
            this.f12606a = r11;
            r8 = r8 + 1;
            if (r8 < 16) goto L16;
            pe.w r12 = r10.f12601m;
            if (r12.s0() == false) goto L16;
            r12.r0(r10, this);
            return;
        L9:
            return;
        L5:
            th = move-exception;
            pe.y.a(ae.g.f354a, th);
            goto L7
        }
    }

    static {
        f12600r = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(ve.l r8, int r10) {
        this.f12601m = r8;
        this.f12602n = r10;
        if ((r8 instanceof i0) == false) goto L5;
        i0 r11 = (i0) r8;
    L6:
        if (r11 != null) goto L8;
        r11 = f0.f10009a;
    L8:
        this.f12603o = r11;
        this.f12604p = new m();
        this.f12605q = new Object();
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // pe.i0
    public final o0 V(long r8, Runnable r10, ae.f r11) {
        return this.f12603o.V(r8, r10, r11);
    }

    @Override // pe.i0
    public final void r(pe.h r8) {
        this.f12603o.r(r8);
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        this.f12604p.a(r10);
        AtomicIntegerFieldUpdater r11 = f12600r;
        if (r11.get(this) >= this.f12602n) goto L21;
        Object r12 = this.f12605q;
        monitor-enter(r12);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r11.get(this) < this.f12602n) goto L10;
        monitor-exit(r12);
        boolean r13 = false;
    L13:
        if (r13 == false) goto L24;
        Runnable r14 = t0();
        if (r14 == null) goto L26;
        a r15 = new a(this, r14);
        this.f12601m.r0(this, r15);
        return;
    L26:
        return;
    L24:
        return;
    L10:
        r11.incrementAndGet(this);     // Catch: Throwable -> L18
        monitor-exit(r12);
        r13 = true;
        goto L13
    }

    public final Runnable t0() {
    L2:
        Runnable r8 = this.f12604p.d();
        if (r8 != null) goto L17;
        Object r10 = this.f12605q;
        monitor-enter(r10);
        AtomicIntegerFieldUpdater r11 = f12600r;     // Catch: Throwable -> L14
        r11.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.f12604p.c() == 0) goto L8;
        r11.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r10);
        goto L2
    L8:
        monitor-exit(r10);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r8;
    }
}
