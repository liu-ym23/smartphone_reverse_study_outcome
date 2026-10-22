package ue;

import java.util.concurrent.CancellationException;
import pe.e1;
import pe.m0;
import pe.s0;
import pe.u1;
import pe.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b9.a f12598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b9.a f12599b = null;

    static {
        f12598a = new b9.a("UNDEFINED", 4);
        f12599b = new b9.a("REUSABLE_CLAIMED", 4);
    }

    public static final <T> void a(ae.d<? super T> r10, Object r11, ge.l<? super Throwable, xd.j> r12) {
        if ((r10 instanceof g) == false) goto L53;
        g r13 = (g) r10;
        Throwable r8 = xd.e.a(r11);
        boolean r14 = false;
        if (r8 != null) goto L9;
        if (r12 == null) goto L8;
        Object r15 = new pe.p(r11, r12);
    L10:
        ae.d<T> r16 = r13.f12595o;
        r13.getContext();
        pe.w r17 = r13.f12594n;
        if (r17.s0() == false) goto L13;
        r13.f12596p = r15;
        r13.f10042m = 1;
        r17.r0(r13.getContext(), r13);
        return;
    L13:
        s0 r18 = u1.a();
        if (r18.f10061m < 4294967296L) goto L16;
        boolean r19 = true;
    L17:
        if (r19 == false) goto L22;
        r13.f12596p = r15;
        r13.f10042m = 1;
        yd.d<m0<?>> r110 = r18.f10063o;
        if (r110 != null) goto L21;
        r110 = new yd.d();
        r18.f10063o = r110;
    L21:
        r110.addLast(r13);
        return;
    L22:
        r18.u0(true);
        e1 r20 = (e1) r13.getContext().q0(e1.b.f10008a);     // Catch: Throwable -> L28
        if (r20 != null) goto L26;
    L30:
        if (r14 == true) goto L46;
        Object r21 = r13.f12597q;     // Catch: Throwable -> L28
        ae.f r22 = r16.getContext();     // Catch: Throwable -> L28
        Object r23 = w.b(r22, r21);     // Catch: Throwable -> L28
        if (r23 == w.f12627a) goto L35;
        z1 r24 = pe.v.b(r16, r22);     // Catch: Throwable -> L28
    L58:
        r16.resumeWith(r11);     // Catch: Throwable -> L40
        xd.j r111 = xd.j.f13877a;     // Catch: Throwable -> L40
        if (r24 != null) goto L39;
        w.a(r22, r23);     // Catch: Throwable -> L28
        goto L46
    L39:
        throw null;     // Catch: Throwable -> L28
    L40:
        th = move-exception;
        if (r24 == null) goto L43;
        throw null;     // Catch: Throwable -> L28
    L43:
        w.a(r22, r23);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L35:
        r24 = null;
    L46:
        if (r18.w0() == true) goto L46;
    L49:
        r18.t0(true);
        return;
    L26:
        if (r20.a() == true) goto L30;
        CancellationException r25 = r20.k();     // Catch: Throwable -> L28
        r13.b(r15, r25);     // Catch: Throwable -> L28
        r13.resumeWith(defpackage.c.D(r25));     // Catch: Throwable -> L28
        r14 = true;
    L28:
        th = move-exception;
        r13.g(th, null);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        r18.t0(true);
        throw th;
    L16:
        r19 = false;
        goto L17
    L8:
        r15 = r11;
        goto L10
    L9:
        r15 = new pe.o(false, r8);
        goto L10
    L53:
        r10.resumeWith(r11);
    }
}
