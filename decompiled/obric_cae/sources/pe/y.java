package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final void a(ae.f r8, Throwable r10) {
        x r11 = (x) r8.q0(x.a.f10084a);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r11.e0(r8, r10);     // Catch: Throwable -> L8
        return;
    L6:
        l6.a.U(r8, r10);
        return;
    L8:
        th = move-exception;
        if (r10 == th) goto L12;
        RuntimeException r12 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        defpackage.c.o(r12, r10);
        r10 = r12;
    L12:
        l6.a.U(r8, r10);
    }
}
