package pe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class j1 implements e1, m, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10021b = null;
    private volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a<T> extends h<T> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final j1 f10022s;

        public a(ae.d<? super T> r8, j1 r10) {
            super(1, r8);
            this.f10022s = r10;
        }

        @Override // pe.h
        public final Throwable o(j1 r8) {
            Object r10 = this.f10022s.t();
            if ((r10 instanceof c) == false) goto L8;
            Throwable r11 = ((c) r10).d();
            if (r11 == null) goto L8;
            return r11;
        L8:
            if ((r10 instanceof o) == false) goto L12;
            return ((o) r10).f10052a;
        L12:
            return r8.k();
        }

        @Override // pe.h
        public final String x() {
            return "AwaitContinuation";
        }
    }

    public static final class b extends i1 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final j1 f10023o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final c f10024p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final l f10025q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Object f10026r;

        public b(j1 r8, c r10, l r11, Object r12) {
            this.f10023o = r8;
            this.f10024p = r10;
            this.f10025q = r11;
            this.f10026r = r12;
        }

        @Override // ge.l
        public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
            m(r8);
            return xd.j.f13877a;
        }

        @Override // pe.q
        public final void m(Throwable r8) {
            AtomicReferenceFieldUpdater r10 = j1.f10020a;
            j1 r11 = this.f10023o;
            r11.getClass();
            l r12 = j1.N(this.f10025q);
            c r13 = this.f10024p;
            Object r14 = this.f10026r;
            if (r12 != null) goto L5;
        L7:
            r11.e(r11.o(r13, r14));
            return;
        L5:
            if (r11.V(r13, r12, r14) == false) goto L7;
        }
    }

    public static final class c implements z0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f10027b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f10028m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f10029n = null;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1 f10030a;

        static {
            f10027b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");
            f10028m = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");
            f10029n = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        }

        public c(m1 r8, Throwable r10) {
            this.f10030a = r8;
            this._isCompleting = 0;
            this._rootCause = r10;
        }

        @Override // pe.z0
        public final boolean a() {
            if (d() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public final void b(Throwable r8) {
            Throwable r10 = d();
            if (r10 != null) goto L6;
            f10028m.set(this, r8);
            return;
        L6:
            if (r8 != r10) goto L8;
            return;
        L8:
            AtomicReferenceFieldUpdater r11 = f10029n;
            Object r12 = r11.get(this);
            if (r12 != null) goto L12;
            r11.set(this, r8);
            return;
        L12:
            if ((r12 instanceof Throwable) == false) goto L17;
            if (r8 != r12) goto L15;
            return;
        L15:
            ArrayList r13 = new ArrayList(4);
            r13.add(r12);
            r13.add(r8);
            r11.set(this, r13);
            return;
        L17:
            if ((r12 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r12).add(r8);
            return;
        L21:
            throw new IllegalStateException(("State is " + r12).toString());
        }

        @Override // pe.z0
        public final m1 c() {
            return this.f10030a;
        }

        public final Throwable d() {
            return (Throwable) f10028m.get(this);
        }

        public final boolean e() {
            if (d() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean f() {
            if (f10027b.get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final ArrayList g(Throwable r8) {
            AtomicReferenceFieldUpdater r10 = f10029n;
            Object r11 = r10.get(this);
            if (r11 != null) goto L6;
            ArrayList r12 = new ArrayList(4);
        L11:
            Throwable r13 = d();
            if (r13 == null) goto L14;
            r12.add(0, r13);
        L14:
            if (r8 != null) goto L16;
        L18:
            r10.set(this, k1.f10037e);
            return r12;
        L16:
            if (he.i.a(r8, r13) == true) goto L18;
            r12.add(r8);
            goto L18
        L6:
            if ((r11 instanceof Throwable) == false) goto L9;
            ArrayList r14 = new ArrayList(4);
            r14.add(r11);
            r12 = r14;
            goto L11
        L9:
            if ((r11 instanceof ArrayList) == false) goto L21;
            r12 = (ArrayList) r11;
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r11).toString());
        }

        public final String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + f10029n.get(this) + ", list=" + this.f10030a + ']';
        }
    }

    public static final class d extends ue.l.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j1 f10031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f10032e;

        public d(ue.l r8, j1 r10, Object r11) {
            this.f10031d = r10;
            this.f10032e = r11;
            super(r8);
        }

        @Override // ue.b
        public final b9.a c(Object r8) {
            ue.l r10 = (ue.l) r8;
            if (this.f10031d.t() != this.f10032e) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L9;
            return null;
        L9:
            return ue.k.f12608a;
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        f10020a = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_state");
        f10021b = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_parentHandle");
    }

    public j1(boolean r8) {
        if (r8 == false) goto L5;
        r0 r10 = k1.f10039g;
    L6:
        this._state = r10;
        return;
    L5:
        r10 = k1.f10038f;
        goto L6
    }

    public static l N(ue.l r8) {
    L3:
        if (r8.l() == false) goto L5;
        r8 = r8.k();
    L5:
        r8 = r8.j();
        if (r8.l() == true) goto L5;
        if ((r8 instanceof l) == true) goto L10;
        if ((r8 instanceof m1) == false) goto L5;
        return null;
    L10:
        return (l) r8;
    }

    public static String T(Object r8) {
        if ((r8 instanceof c) == false) goto L11;
        c r10 = (c) r8;
        if (r10.e() == false) goto L8;
        return "Cancelling";
    L8:
        if (r10.f() == false) goto L14;
        return "Completing";
    L14:
        return "Active";
    L11:
        if ((r8 instanceof z0) == false) goto L17;
        if (((z0) r8).a() == true) goto L14;
        return "New";
    L17:
        if ((r8 instanceof o) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    @Override // ae.f
    public final <R> R B(R r8, ge.p<? super R, ? super ae.f.b, ? extends R> r10) {
        return (R) ae.f.b.a.a(this, r8, r10);
    }

    @Override // ae.f
    public final ae.f C(ae.f r8) {
        return ae.f.b.a.d(this, r8);
    }

    @Override // pe.p1
    public final CancellationException E() {
        Object r8 = t();
        CancellationException r10 = null;
        if ((r8 instanceof c) == false) goto L6;
        Throwable r11 = ((c) r8).d();
    L12:
        if ((r11 instanceof CancellationException) == false) goto L14;
        r10 = (CancellationException) r11;
    L14:
        if (r10 == null) goto L16;
        return r10;
    L16:
        return new f1("Parent job is ".concat(T(r8)), r11, this);
    L6:
        if ((r8 instanceof o) == false) goto L9;
        r11 = ((o) r8).f10052a;
        goto L12
    L9:
        if ((r8 instanceof z0) == true) goto L18;
        r11 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r8).toString());
    }

    public boolean F() {
        return this instanceof pe.c;
    }

    @Override // pe.e1
    public final boolean G() {
        return !(t() instanceof z0);
    }

    @Override // pe.e1
    public final void H(CancellationException r8) {
        if (r8 != null) goto L4;
        r8 = new f1(j(), null, this);
    L4:
        g(r8);
    }

    @Override // pe.m
    public final void I(j1 r8) {
        g(r8);
    }

    @Override // pe.e1
    public final o0 J(boolean r8, boolean r10, ge.l<? super Throwable, xd.j> r11) {
        Throwable r12 = null;
        if (r8 == false) goto L11;
        if ((r11 instanceof g1) == false) goto L7;
        i1 r13 = (g1) r11;
    L8:
        if (r13 != null) goto L17;
        r13 = new c1(r11);
    L17:
        r13.f10018n = this;
    L18:
        Object r14 = t();
        if ((r14 instanceof r0) == true) goto L20;
        if ((r14 instanceof z0) == false) goto L79;
        m1 r15 = ((z0) r14).c();
        if (r15 == null) goto L45;
        o0 r16 = n1.f10050a;
        if (r8 == false) goto L71;
        if ((r14 instanceof c) == false) goto L71;
        monitor-enter(r14);
        Throwable r17 = ((c) r14).d();     // Catch: Throwable -> L68
        if (r17 == null) goto L58;
        if ((r11 instanceof l) == false) goto L65;
        if (((c) r14).f() == false) goto L58;
    L65:
        xd.j r18 = xd.j.f13877a;     // Catch: Throwable -> L68
        monitor-exit(r14);
    L72:
        if (r17 != null) goto L73;
        if (b(r14, r15, r13) == false) goto L18;
        return r13;
    L73:
        if (r10 == false) goto L75;
        r11.invoke(r17);
    L75:
        return r16;
    L58:
        if (b(r14, r15, r13) == true) goto L61;
        monitor-exit(r14);
        goto L18
    L61:
        if (r17 == null) goto L62;
        r16 = r13;
        goto L65
    L62:
        monitor-exit(r14);
        return r13;
    L68:
        th = move-exception;
        throw th;
    L71:
        r17 = null;
        goto L72
    L45:
        he.i.d(r14, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        R((i1) r14);
        goto L18
    L79:
        if (r10 == false) goto L88;
        if ((r14 instanceof o) == false) goto L83;
        o r19 = (o) r14;
    L84:
        if (r19 == null) goto L86;
        r12 = r19.f10052a;
    L86:
        r11.invoke(r12);
        goto L88
    L83:
        r19 = null;
    L88:
        return n1.f10050a;
    L20:
        r0 r20 = (r0) r14;
        if (r20.f10058a == true) goto L22;
        m1 r21 = new m1();
        Object r22 = r21;
        if (r20.f10058a == true) goto L35;
        r22 = new y0(r21);
    L35:
        AtomicReferenceFieldUpdater r23 = f10020a;
        if (r23.compareAndSet(this, r20, r22) == true) goto L18;
        if (r23.get(this) == r20) goto L35;
    L22:
        AtomicReferenceFieldUpdater r24 = f10020a;
    L24:
        if (r24.compareAndSet(this, r14, r13) == true) goto L25;
        if (r24.get(this) == r14) goto L24;
        boolean r25 = false;
    L29:
        if (r25 == false) goto L18;
        return r13;
    L25:
        r25 = true;
        goto L29
    L7:
        r13 = null;
        goto L8
    L11:
        if ((r11 instanceof i1) == false) goto L13;
        r13 = (i1) r11;
    L14:
        if (r13 != null) goto L17;
        r13 = new d1(r11);
        goto L17
    L13:
        r13 = null;
        goto L14
    }

    public final Object L(Object r8) {
    L2:
        Object r10 = U(t(), r8);
        if (r10 == k1.f10033a) goto L4;
        if (r10 == k1.f10035c) goto L2;
        return r10;
    L4:
        String r11 = "Job " + this + " is already complete or completing, but is being completed with " + r8;
        Throwable r12 = null;
        if ((r8 instanceof o) == false) goto L7;
        o r13 = (o) r8;
    L8:
        if (r13 == null) goto L11;
        r12 = r13.f10052a;
    L11:
        throw new IllegalStateException(r11, r12);
    L7:
        r13 = null;
        goto L8
    }

    public String M() {
        return getClass().getSimpleName();
    }

    public final void O(m1 r8, Throwable r10) {
        Object r11 = r8.i();
        he.i.d(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        ue.l r12 = (ue.l) r11;
        d1.c r13 = null;
    L4:
        if (he.i.a(r12, r8) == true) goto L15;
        if ((r12 instanceof g1) == false) goto L14;
        i1 r14 = (i1) r12;
        r14.m(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r13 == null) goto L13;
        defpackage.c.o(r13, th);
        goto L14
    L13:
        r13 = new d1.c("Exception in completion handler " + r14 + " for " + this, th);
        xd.j r15 = xd.j.f13877a;
    L14:
        r12 = r12.j();
        goto L4
    L15:
        if (r13 == null) goto L17;
        w(r13);
    L17:
        h(r10);
    }

    public void P(Object r8) {
    }

    public void Q() {
    }

    public final void R(i1 r8) {
        m1 r10 = new m1();
        r8.getClass();
        ue.l.f12610b.lazySet(r10, r8);
        AtomicReferenceFieldUpdater r11 = ue.l.f12609a;
        r11.lazySet(r10, r8);
    L4:
        if (r8.i() != r8) goto L14;
    L7:
        if (r11.compareAndSet(r8, r8, r10) == true) goto L8;
        if (r11.get(r8) == r8) goto L7;
        boolean r12 = false;
    L12:
        if (r12 == false) goto L4;
        r10.h(r8);
        goto L14
    L8:
        r12 = true;
    L14:
        ue.l r13 = r8.j();
    L15:
        AtomicReferenceFieldUpdater r14 = f10020a;
        if (r14.compareAndSet(this, r8, r13) == true) goto L20;
        if (r14.get(this) == r8) goto L15;
        return;
    }

    public final int S(Object r8) {
        boolean r10 = r8 instanceof r0;
        AtomicReferenceFieldUpdater r11 = f10020a;
        boolean r12 = false;
        if (r10 == false) goto L18;
        if (((r0) r8).f10058a == false) goto L7;
        return 0;
    L7:
        r0 r13 = k1.f10039g;
    L9:
        if (r11.compareAndSet(this, r8, r13) == true) goto L10;
        if (r11.get(this) == r8) goto L9;
    L13:
        if (r12 == true) goto L15;
        return -1;
    L15:
        Q();
        return 1;
    L10:
        r12 = true;
        goto L13
    L18:
        if ((r8 instanceof y0) == false) goto L29;
        m1 r14 = ((y0) r8).f10090a;
    L21:
        if (r11.compareAndSet(this, r8, r14) == true) goto L22;
        if (r11.get(this) == r8) goto L21;
    L25:
        if (r12 == true) goto L27;
        return -1;
    L27:
        Q();
        return 1;
    L22:
        r12 = true;
        goto L25
    L29:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, java.lang.Throwable] */
    public final Object U(Object r10, Object r11) {
        if ((r10 instanceof z0) == false) goto L5;
        boolean r8 = true;
        boolean r12 = false;
        if ((r10 instanceof r0) == true) goto L11;
        if ((r10 instanceof i1) == true) goto L11;
    L31:
        z0 r13 = (z0) r10;
        m1 r14 = s(r13);
        if (r14 == null) goto L97;
        l r15 = null;
        if ((r13 instanceof c) == false) goto L37;
        c r16 = (c) r13;
    L38:
        if (r16 != null) goto L40;
        r16 = new c(r14, null);
    L40:
        he.o r17 = new he.o();
        monitor-enter(r16);
    L86:
        th = move-exception;
        throw th;
    L43:
        if (r16.f() == false) goto L45;
        b9.a r18 = k1.f10033a;     // Catch: Throwable -> L86
    L55:
        monitor-exit(r16);
        return r18;
    L45:
        c.f10027b.set(r16, 1);     // Catch: Throwable -> L86
        if (r16 == r13) goto L57;
        AtomicReferenceFieldUpdater r19 = f10020a;     // Catch: Throwable -> L86
    L49:
        if (r19.compareAndSet(this, r13, r16) == true) goto L50;
        if (r19.get(this) == r13) goto L49;
    L53:
        if (r12 == true) goto L57;
        r18 = k1.f10035c;     // Catch: Throwable -> L86
        goto L55
    L50:
        r12 = true;
    L57:
        boolean r20 = r16.e();     // Catch: Throwable -> L86
        if ((r11 instanceof o) == false) goto L60;
        o r21 = (o) r11;     // Catch: Throwable -> L86
    L61:
        if (r21 == null) goto L63;
        r16.b(r21.f10052a);     // Catch: Throwable -> L86
    L63:
        Throwable r22 = r16.d();     // Catch: Throwable -> L86
        if (Boolean.valueOf(true ^ r20).booleanValue() == false) goto L66;
        ?? r23 = r22;
    L67:
        r17.f8064a = r23;     // Catch: Throwable -> L86
        xd.j r24 = xd.j.f13877a;     // Catch: Throwable -> L86
        monitor-exit(r16);
        if (r23 == 0) goto L72;
        O(r14, r23);
    L72:
        if ((r13 instanceof l) == false) goto L74;
        l r25 = (l) r13;
    L75:
        if (r25 != null) goto L79;
        m1 r26 = r13.c();
        if (r26 == null) goto L80;
        r15 = N(r26);
    L80:
        if (r15 == null) goto L85;
        if (V(r16, r15, r11) == false) goto L85;
        return k1.f10034b;
    L85:
        return o(r16, r11);
    L79:
        r15 = r25;
        goto L80
    L74:
        r25 = null;
        goto L75
    L66:
        r23 = 0;
        goto L67
    L60:
        r21 = null;
        goto L61
    L37:
        r16 = null;
        goto L38
    L97:
        return k1.f10035c;
    L11:
        if ((r10 instanceof l) == true) goto L31;
        if ((r11 instanceof o) == true) goto L31;
        z0 r27 = (z0) r10;
        b9.a r28 = k1.f10033a;
        if ((r11 instanceof z0) == false) goto L17;
        Object r29 = new a1((z0) r11);
    L18:
        AtomicReferenceFieldUpdater r30 = f10020a;
        if (r30.compareAndSet(this, r27, r29) == true) goto L20;
        if (r30.get(this) == r27) goto L18;
        boolean r31 = false;
    L24:
        if (r31 == true) goto L26;
        r8 = false;
    L27:
        if (r8 == false) goto L30;
        return r11;
    L30:
        return k1.f10035c;
    L26:
        P(r11);
        m(r27, r11);
        goto L27
    L20:
        r31 = true;
        goto L24
    L17:
        r29 = r11;
        goto L18
    L5:
        return k1.f10033a;
    }

    public final boolean V(c r8, l r10, Object r11) {
    L2:
        b r12 = new b(this, r8, r10, r11);
        if (e1.a.b(r10.f10040o, false, r12, 1) != n1.f10050a) goto L4;
        r10 = N(r10);
        if (r10 != null) goto L2;
        return false;
    L4:
        return true;
    }

    @Override // pe.e1
    public boolean a() {
        Object r8 = t();
        if ((r8 instanceof z0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z0) r8).a() == false) goto L7;
        return true;
    }

    public final boolean b(Object r8, m1 r10, i1 r11) {
        d r12 = new d(r11, this, r8);
    L3:
        ue.l r13 = r10.k();
        ue.l.f12610b.lazySet(r11, r13);
        AtomicReferenceFieldUpdater r14 = ue.l.f12609a;
        r14.lazySet(r11, r10);
        r12.f12613c = r10;
    L5:
        if (r14.compareAndSet(r13, r10, r12) == true) goto L6;
        if (r14.get(r13) == r10) goto L5;
        boolean r15 = false;
    L11:
        if (r15 == true) goto L14;
        char r16 = 0;
    L17:
        if (r16 == 1) goto L21;
        if (r16 != 2) goto L3;
        return false;
    L21:
        return true;
    L14:
        if (r12.a(r13) != null) goto L16;
        r16 = 1;
        goto L17
    L16:
        r16 = 2;
        goto L17
    L6:
        r15 = true;
        goto L11
    }

    public void e(Object r8) {
    }

    public void f(Object r8) {
        e(r8);
    }

    public final boolean g(Object r10) {
        Object r8 = k1.f10033a;
        if (r() == false) goto L19;
    L4:
        Object r11 = t();
        if ((r11 instanceof z0) == false) goto L14;
        if ((r11 instanceof c) == true) goto L9;
    L11:
        r8 = U(r11, new o(false, n(r10)));
        if (r8 == k1.f10035c) goto L4;
    L16:
        if (r8 != k1.f10034b) goto L19;
        return true;
    L9:
        if (((c) r11).f() == false) goto L11;
    L14:
        r8 = k1.f10033a;
    L19:
        if (r8 != k1.f10033a) goto L79;
        Throwable r12 = null;
        Throwable r13 = null;
    L21:
        Object r14 = t();
        if ((r14 instanceof c) == true) goto L23;
        if ((r14 instanceof z0) == false) goto L76;
        if (r13 != null) goto L52;
        r13 = n(r10);
    L52:
        z0 r15 = (z0) r14;
        if (r15.a() == true) goto L54;
        Object r16 = U(r14, new o(false, r13));
        if (r16 == k1.f10033a) goto L75;
        if (r16 == k1.f10035c) goto L21;
        r8 = r16;
        goto L79
    L75:
        throw new IllegalStateException(("Cannot happen in " + r14).toString());
    L54:
        m1 r17 = s(r15);
        if (r17 == null) goto L65;
        c r18 = new c(r17, r13);
    L58:
        AtomicReferenceFieldUpdater r19 = f10020a;
        if (r19.compareAndSet(this, r15, r18) == true) goto L60;
        if (r19.get(this) == r15) goto L58;
        boolean r20 = false;
    L64:
        if (r20 == false) goto L65;
        O(r17, r13);
        boolean r21 = true;
    L67:
        if (r21 == false) goto L21;
    L68:
        b9.a r110 = k1.f10033a;
    L77:
        r8 = r110;
        goto L79
    L60:
        r20 = true;
    L65:
        r21 = false;
        goto L67
    L76:
        r110 = k1.f10036d;
        goto L77
    L23:
        monitor-enter(r14);
    L45:
        th = move-exception;
        throw th;
    L25:
        if (c.f10029n.get((c) r14) != k1.f10037e) goto L27;
        boolean r22 = true;
    L28:
        if (r22 == false) goto L32;
        r110 = k1.f10036d;     // Catch: Throwable -> L45
        monitor-exit(r14);
        goto L77
    L32:
        boolean r23 = ((c) r14).e();     // Catch: Throwable -> L45
        if (r10 != null) goto L35;
        if (r23 == false) goto L35;
    L38:
        Throwable r111 = ((c) r14).d();     // Catch: Throwable -> L45
        if ((!r23) == false) goto L42;
        r12 = r111;
    L42:
        monitor-exit(r14);
        if (r12 == null) goto L68;
        O(((c) r14).f10030a, r12);
    L35:
        if (r13 != null) goto L37;
        r13 = n(r10);     // Catch: Throwable -> L45
    L37:
        ((c) r14).b(r13);     // Catch: Throwable -> L45
        goto L38
    L27:
        r22 = false;
    L79:
        if (r8 == k1.f10033a) goto L89;
        if (r8 == k1.f10034b) goto L89;
        if (r8 == k1.f10036d) goto L108;
        e(r8);
        goto L89
    L108:
        return false;
    L89:
        return true;
    }

    @Override // ae.f.b
    public final ae.f.c<?> getKey() {
        return e1.b.f10008a;
    }

    @Override // pe.e1
    public final e1 getParent() {
        k r8 = (k) f10021b.get(this);
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getParent();
    }

    public final boolean h(Throwable r8) {
        if (F() == false) goto L5;
        return true;
    L5:
        boolean r10 = r8 instanceof CancellationException;
        k r11 = (k) f10021b.get(this);
        if (r11 != null) goto L8;
    L16:
        return r10;
    L8:
        if (r11 == n1.f10050a) goto L16;
        if (r11.b(r8) == true) goto L17;
        if (r10 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    @Override // ae.f
    public final ae.f h0(ae.f.c<?> r8) {
        return ae.f.b.a.c(this, r8);
    }

    @Override // pe.e1
    public final o0 i(ge.l<? super Throwable, xd.j> r8) {
        return J(false, true, r8);
    }

    public String j() {
        return "Job was cancelled";
    }

    @Override // pe.e1
    public final CancellationException k() {
        Object r8 = t();
        CancellationException r10 = null;
        if ((r8 instanceof c) == false) goto L17;
        Throwable r11 = ((c) r8).d();
        if (r11 == null) goto L15;
        String r12 = getClass().getSimpleName().concat(" is cancelling");
        if ((r11 instanceof CancellationException) == false) goto L9;
        r10 = (CancellationException) r11;
    L9:
        if (r10 == null) goto L11;
        return r10;
    L11:
        if (r12 != null) goto L30;
        r12 = j();
    L30:
        return new f1(r12, r11, this);
    L15:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L17:
        if ((r8 instanceof z0) == true) goto L28;
        if ((r8 instanceof o) == false) goto L26;
        Throwable r13 = ((o) r8).f10052a;
        if ((r13 instanceof CancellationException) == false) goto L23;
        r10 = (CancellationException) r13;
    L23:
        if (r10 == null) goto L32;
        return r10;
    L32:
        return new f1(j(), r13, this);
    L26:
        return new f1(getClass().getSimpleName().concat(" has completed normally"), null, this);
    L28:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public boolean l(Throwable r8) {
        if ((r8 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (g(r8) == true) goto L8;
    L10:
        return false;
    L8:
        if (q() == false) goto L10;
        return true;
    }

    public final void m(z0 r8, Object r10) {
        AtomicReferenceFieldUpdater r11 = f10021b;
        k r12 = (k) r11.get(this);
        if (r12 == null) goto L5;
        r12.e();
        r11.set(this, n1.f10050a);
    L5:
        d1.c r13 = null;
        if ((r10 instanceof o) == false) goto L8;
        o r14 = (o) r10;
    L9:
        if (r14 == null) goto L11;
        Throwable r15 = r14.f10052a;
    L13:
        if ((r8 instanceof i1) == true) goto L36;
        m1 r16 = r8.c();
        if (r16 == null) goto L46;
        Object r17 = r16.i();
        he.i.d(r17, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        ue.l r18 = (ue.l) r17;
    L22:
        if (he.i.a(r18, r16) == true) goto L33;
        if ((r18 instanceof i1) == false) goto L32;
        i1 r19 = (i1) r18;
        r19.m(r15);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r13 == null) goto L31;
        defpackage.c.o(r13, th);
        goto L32
    L31:
        r13 = new d1.c("Exception in completion handler " + r19 + " for " + this, th);
        xd.j r20 = xd.j.f13877a;
    L32:
        r18 = r18.j();
        goto L22
    L33:
        if (r13 == null) goto L47;
        w(r13);
        return;
    L47:
        return;
    L46:
        return;
    L36:
        ((i1) r8).m(r15);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        w(new d1.c("Exception in completion handler " + r8 + " for " + this, th));
        return;
    L11:
        r15 = null;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    public final Throwable n(Object r8) {
        if (r8 != null) goto L4;
        boolean r10 = true;
    L5:
        if (r10 == false) goto L9;
        Throwable r11 = (Throwable) r8;
        if (r11 == null) goto L12;
        return r11;
    L12:
        return new f1(j(), null, this);
    L9:
        he.i.d(r8, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((p1) r8).E();
    L4:
        r10 = r8 instanceof Throwable;
        goto L5
    }

    public final Object o(c r8, Object r10) {
        Throwable r11 = null;
        if ((r10 instanceof o) == false) goto L5;
        o r12 = (o) r10;
    L6:
        if (r12 == null) goto L8;
        r11 = r12.f10052a;
    L8:
        monitor-enter(r8);
        r8.e();     // Catch: Throwable -> L54
        ArrayList r13 = r8.g(r11);     // Catch: Throwable -> L54
        Throwable r14 = p(r8, r13);     // Catch: Throwable -> L54
        if (r14 != null) goto L12;
    L26:
        monitor-exit(r8);
        if (r14 == null) goto L33;
        if (r14 == r11) goto L33;
        r10 = new o(false, r14);
    L33:
        if (r14 != null) goto L35;
    L43:
        P(r10);
        AtomicReferenceFieldUpdater r15 = f10020a;
        if ((r10 instanceof z0) == false) goto L46;
        Object r16 = new a1((z0) r10);
    L48:
        if (r15.compareAndSet(this, r8, r16) == true) goto L52;
        if (r15.get(this) == r8) goto L48;
    L52:
        m(r8, r10);
        return r10;
    L46:
        r16 = r10;
        goto L48
    L35:
        if (h(r14) == false) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L43;
        he.i.d(r10, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        o.f10051b.compareAndSet((o) r10, 0, 1);
        goto L43
    L37:
        if (u(r14) == true) goto L40;
        r17 = false;
        goto L41
    L12:
        if (r13.size() <= 1) goto L26;
        Set r18 = Collections.newSetFromMap(new IdentityHashMap(r13.size()));     // Catch: Throwable -> L54
        Iterator r19 = r13.iterator();     // Catch: Throwable -> L54
    L16:
        if (r19.hasNext() == false) goto L26;
        Throwable r20 = (Throwable) r19.next();     // Catch: Throwable -> L54
        if (r20 == r14) goto L16;
        if (r20 == r14) goto L16;
        if ((r20 instanceof CancellationException) == true) goto L16;
        if (r18.add(r20) == false) goto L16;
        defpackage.c.o(r14, r20);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }

    public final Throwable p(c r8, ArrayList r10) {
        Object r11 = null;
        if (r10.isEmpty() == true) goto L5;
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((!(((Throwable) r13) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r14 = (Throwable) r13;
        if (r14 == null) goto L19;
        return r14;
    L19:
        Throwable r15 = (Throwable) r10.get(0);
        if ((r15 instanceof v1) == false) goto L35;
        Iterator r16 = r10.iterator();
    L23:
        if (r16.hasNext() == false) goto L32;
        Object r17 = r16.next();
        Throwable r18 = (Throwable) r17;
        if (r18 != r15) goto L27;
    L29:
        boolean r19 = false;
    L30:
        if (r19 == false) goto L23;
        r11 = r17;
        goto L32
    L27:
        if ((r18 instanceof v1) == false) goto L29;
        r19 = true;
    L32:
        Throwable r20 = (Throwable) r11;
        if (r20 == null) goto L35;
        return r20;
    L35:
        return r15;
    L15:
        r13 = null;
        goto L16
    L5:
        if (r8.e() == true) goto L7;
        return null;
    L7:
        return new f1(j(), null, this);
    }

    public boolean q() {
        return true;
    }

    @Override // ae.f
    public final <E extends ae.f.b> E q0(ae.f.c<E> r8) {
        return (E) ae.f.b.a.b(this, r8);
    }

    public boolean r() {
        return false;
    }

    public final m1 s(z0 r8) {
        m1 r10 = r8.c();
        if (r10 == null) goto L5;
        return r10;
    L5:
        if ((r8 instanceof r0) == false) goto L8;
        return new m1();
    L8:
        if ((r8 instanceof i1) == false) goto L11;
        R((i1) r8);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r8).toString());
    }

    @Override // pe.e1
    public final boolean start() {
    L2:
        int r8 = S(t());
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    public final Object t() {
    L2:
        Object r8 = f10020a.get(this);
        if ((r8 instanceof ue.q) == false) goto L4;
        ((ue.q) r8).a(this);
        goto L2
    L4:
        return r8;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(M() + '{' + T(t()) + '}');
        r8.append('@');
        r8.append(d0.c(this));
        return r8.toString();
    }

    public boolean u(Throwable r8) {
        return false;
    }

    public void w(d1.c r8) {
        throw r8;
    }

    @Override // pe.e1
    public final k x(j1 r8) {
        o0 r10 = e1.a.b(this, true, new l(r8), 2);
        he.i.d(r10, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (k) r10;
    }

    public final void y(e1 r8) {
        n1 r10 = n1.f10050a;
        AtomicReferenceFieldUpdater r11 = f10021b;
        if (r8 != null) goto L6;
        r11.set(this, r10);
        return;
    L6:
        r8.start();
        k r12 = r8.x(this);
        r11.set(this, r12);
        if (G() == false) goto L10;
        r12.e();
        r11.set(this, r10);
        return;
    }
}
