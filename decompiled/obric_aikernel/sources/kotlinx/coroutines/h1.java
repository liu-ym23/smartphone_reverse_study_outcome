package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h1 extends f1 {
    public h1() {
    }

    protected abstract Thread o0();

    protected void p0(long r10, g1.c r11) {
        p0.f10623l.z0(r10, r11);
    }

    protected final void q0() {
        Thread r10 = o0();
        if (Thread.currentThread() == r10) goto L6;
        c.a();
        LockSupport.unpark(r10);
        return;
    }
}
