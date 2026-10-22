package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0<T> extends ve.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10042m;

    public m0(int r8) {
        this.f10042m = r8;
    }

    public void b(Object r8, CancellationException r10) {
    }

    public abstract ae.d<T> d();

    public Throwable e(Object r8) {
        if ((r8 instanceof o) == false) goto L5;
        o r10 = (o) r8;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.f10052a;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object r8) {
        return r8;
    }

    public final void g(Throwable r8, Throwable r10) {
        if (r8 != null) goto L5;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8 == null) goto L8;
        if (r10 == null) goto L8;
        defpackage.c.o(r8, r10);
    L8:
        if (r8 != null) goto L10;
        r8 = r10;
    L10:
        he.i.c(r8);
        y.a(d().getContext(), new c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r8));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        ve.h r8 = this.f12879b;
        ae.d<T> r10 = d();     // Catch: Throwable -> L37
        he.i.d(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L37
        ue.g r11 = (ue.g) r10;     // Catch: Throwable -> L37
        ae.d<T> r12 = r11.f12595o;     // Catch: Throwable -> L37
        Object r13 = r11.f12597q;     // Catch: Throwable -> L37
        ae.f r14 = r12.getContext();     // Catch: Throwable -> L37
        Object r15 = ue.w.b(r14, r13);     // Catch: Throwable -> L37
        if (r15 == ue.w.f12627a) goto L7;
        z1 r16 = v.b(r12, r14);     // Catch: Throwable -> L37
    L54:
        ae.f r17 = r12.getContext();     // Catch: Throwable -> L23
        Object r18 = h();     // Catch: Throwable -> L23
        Throwable r19 = e(r18);     // Catch: Throwable -> L23
        if (r19 != null) goto L18;
        int r20 = this.f10042m;     // Catch: Throwable -> L23
        boolean r110 = true;
        if (r20 != 1) goto L13;
    L16:
        if (r110 == false) goto L18;
        e1 r21 = (e1) r17.q0(e1.b.f10008a);     // Catch: Throwable -> L23
    L19:
        if (r21 != null) goto L21;
    L25:
        if (r19 == null) goto L27;
        Object r22 = defpackage.c.D(r19);     // Catch: Throwable -> L23
    L28:
        r12.resumeWith(r22);     // Catch: Throwable -> L23
        xd.j r23 = xd.j.f13877a;     // Catch: Throwable -> L23
        if (r16 != null) goto L36;
        ue.w.a(r14, r15);     // Catch: Throwable -> L37
        r8.a();     // Catch: Throwable -> L33
        Object r24 = xd.j.f13877a;     // Catch: Throwable -> L33
    L35:
        g(null, xd.e.a(r24));
        return;
    L33:
        th = move-exception;
        r24 = defpackage.c.D(th);
        goto L35
    L36:
        throw null;     // Catch: Throwable -> L37
    L27:
        r22 = f(r18);     // Catch: Throwable -> L23
        goto L28
    L21:
        if (r21.a() == true) goto L25;
        CancellationException r25 = r21.k();     // Catch: Throwable -> L23
        b(r18, r25);     // Catch: Throwable -> L23
        r22 = defpackage.c.D(r25);     // Catch: Throwable -> L23
        goto L28
    L13:
        if (r20 == 2) goto L16;
        r110 = false;
    L18:
        r21 = null;
    L23:
        th = move-exception;
        if (r16 == null) goto L41;
        throw null;     // Catch: Throwable -> L37
    L41:
        ue.w.a(r14, r15);     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L7:
        r16 = null;
    L37:
        th = move-exception;
        r8.a();     // Catch: Throwable -> L45
        Object r26 = xd.j.f13877a;     // Catch: Throwable -> L45
    L47:
        g(th, xd.e.a(r26));
        return;
    L45:
        th = move-exception;
        r26 = defpackage.c.D(th);
        goto L47
    }
}
