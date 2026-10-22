package se;

/* JADX INFO: loaded from: classes2.dex */
public final class n<T> implements d<T> {
    public final xd.j a(ae.d r8) {
        if ((r8 instanceof m) == false) goto L7;
        m r10 = (m) r8;
        int r11 = r10.f12135o;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f12135o = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f12133m;
        be.a r13 = be.a.f3165a;
        int r14 = r10.f12135o;
        if (r14 == 0) goto L23;
        if (r14 != 1) goto L12;
        te.g r15 = r10.f12132b;
        n r16 = r10.f12131a;
        defpackage.c.m0(r12);     // Catch: Throwable -> L21
        r15.releaseIntercepted();
        r16.getClass();
    L15:
        return xd.j.f13877a;
    L21:
        Throwable th = th;
    L28:
        r15.releaseIntercepted();
        throw th;
    L12:
        if (r14 != 2) goto L17;
        defpackage.c.m0(r12);
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        defpackage.c.m0(r12);
        te.g r17 = new te.g(r10.getContext());
        r10.f12131a = this;     // Catch: Throwable -> L26
        r10.f12132b = r17;     // Catch: Throwable -> L26
        r10.f12135o = 1;     // Catch: Throwable -> L26
        throw null;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th = th;
        r15 = r17;
    L7:
        r10 = new m(this, r8);
        goto L8
    }

    @Override // se.d
    public final Object e(T r8, ae.d<? super xd.j> r10) {
        throw null;
    }
}
