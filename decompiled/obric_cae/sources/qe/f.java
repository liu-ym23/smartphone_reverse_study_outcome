package qe;

import android.os.Handler;
import android.os.Looper;
import he.i;
import java.util.concurrent.CancellationException;
import pe.e1;
import pe.l1;
import pe.n0;
import pe.n1;
import pe.o0;
import ue.p;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends g {
    private volatile f _immediate;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f11303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f11304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f11305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f11306p;

    public f(Handler r8) {
        this(r8, null, false);
    }

    @Override // qe.g, pe.i0
    public final o0 V(long r8, final Runnable r10, ae.f r11) {
        if (r8 <= 4611686018427387903L) goto L6;
        r8 = 4611686018427387903L;
    L6:
        if (this.f11303m.postDelayed(r10, r8) == true) goto L8;
        u0(r11, r10);
        return n1.f10050a;
    L8:
        return new c(this, r10);
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof f) == true) goto L5;
    L7:
        return false;
    L5:
        if (((f) r8).f11303m != this.f11303m) goto L7;
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f11303m);
    }

    @Override // pe.i0
    public final void r(pe.h r8) {
        d r10 = new d(r8, this);
        if (this.f11303m.postDelayed(r10, 30000) == false) goto L5;
        r8.s(new e(this, r10));
        return;
    L5:
        u0(r8.getContext(), r10);
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        if (this.f11303m.post(r10) == true) goto L6;
        u0(r8, r10);
        return;
    }

    @Override // pe.w
    public final boolean s0() {
        if (this.f11305o == true) goto L5;
    L8:
        return true;
    L5:
        if (i.a(Looper.myLooper(), this.f11303m.getLooper()) == false) goto L8;
        return false;
    }

    @Override // pe.l1
    public final l1 t0() {
        return this.f11306p;
    }

    @Override // pe.l1, pe.w
    public final String toString() {
        ve.c r8 = n0.f10048a;
        l1 r10 = p.f12623a;
        if (this != r10) goto L20;
        String r11 = "Dispatchers.Main";
    L12:
        if (r11 != null) goto L22;
        String r12 = this.f11304n;
        if (r12 != null) goto L17;
        r12 = this.f11303m.toString();
    L17:
        if (this.f11305o == true) goto L19;
        return r12;
    L19:
        return defpackage.a.e(r12, ".immediate");
    L22:
        return r11;
    L20:
        l1 r13 = r10.t0();     // Catch: UnsupportedOperationException -> L8
    L9:
        if (this != r13) goto L11;
        r11 = "Dispatchers.Main.immediate";
        goto L12
    L11:
        r11 = null;
    L8:
        r13 = null;
        goto L9
    }

    public final void u0(ae.f r8, Runnable r10) {
        CancellationException r11 = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        e1 r12 = (e1) r8.q0(e1.b.f10008a);
        if (r12 == null) goto L5;
        r12.H(r11);
    L5:
        n0.f10049b.r0(r8, r10);
    }

    public f(Handler r8, String r10, boolean r11) {
        this.f11303m = r8;
        this.f11304n = r10;
        this.f11305o = r11;
        if (r11 == false) goto L5;
        f r12 = this;
    L6:
        this._immediate = r12;
        f r13 = this._immediate;
        if (r13 != null) goto L9;
        r13 = new f(r8, r10, true);
        this._immediate = r13;
    L9:
        this.f11306p = r13;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
