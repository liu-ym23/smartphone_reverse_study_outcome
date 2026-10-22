package pe;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends a<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Thread f9999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s0 f10000o;

    public c(ae.f r8, Thread r10, s0 r11) {
        super(r8, true);
        this.f9999n = r10;
        this.f10000o = r11;
    }

    @Override // pe.j1
    public final void e(Object r8) {
        Thread r10 = Thread.currentThread();
        Thread r11 = this.f9999n;
        if (he.i.a(r10, r11) == true) goto L6;
        LockSupport.unpark(r11);
        return;
    }
}
