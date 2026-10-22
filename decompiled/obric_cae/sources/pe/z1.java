package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class z1<T> extends ue.t<T> {
    private volatile boolean threadLocalIsSet;

    public final void X() {
        this.threadLocalIsSet = true;
        throw null;
    }

    @Override // ue.t, pe.j1
    public final void f(Object r8) {
        if (this.threadLocalIsSet == true) goto L18;
        Object r10 = l6.a.G0(r8);
        ae.d<T> r11 = this.f12625n;
        ae.f r12 = r11.getContext();
        Object r13 = ue.w.b(r12, null);
        if (r13 == ue.w.f12627a) goto L7;
        z1 r14 = v.b(r11, r12);
    L19:
        this.f12625n.resumeWith(r10);     // Catch: Throwable -> L13
        xd.j r15 = xd.j.f13877a;     // Catch: Throwable -> L13
        if (r14 != null) goto L12;
        ue.w.a(r12, r13);
        return;
    L12:
        throw null;
    L13:
        th = move-exception;
        if (r14 == null) goto L16;
        throw null;
    L16:
        ue.w.a(r12, r13);
        throw th;
    L7:
        r14 = null;
        goto L19
    L18:
        throw null;
    }
}
