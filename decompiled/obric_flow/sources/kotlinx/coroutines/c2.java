package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 extends m1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ int _state$volatile;
    public final Thread e;
    public t0 f;

    static {
        g = AtomicIntegerFieldUpdater.newUpdater(c2.class, "_state$volatile");
    }

    public c2() {
        this.e = Thread.currentThread();
    }

    public static void l(int r5) {
        throw new IllegalStateException(("Illegal state " + r5).toString());
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        return true;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
    L2:
        AtomicIntegerFieldUpdater r10 = g;
        int r11 = r10.get(this);
        if (r11 != 0) goto L5;
        if (r10.compareAndSet(this, r11, 2) == false) goto L2;
        this.e.interrupt();
        r10.set(this, 3);
        return;
    L5:
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L19;
        if (r11 == 3) goto L20;
        l(r11);
        throw null;
    L20:
        return;
    L19:
        return;
    }

    public final void k() {
    L2:
        AtomicIntegerFieldUpdater r5 = g;
        int r10 = r5.get(this);
        if (r10 != 0) goto L5;
        if (r5.compareAndSet(this, r10, 1) == false) goto L2;
        t0 r11 = this.f;
        if (r11 == null) goto L25;
        r11.dispose();
        return;
    L25:
        return;
    L5:
        if (r10 == 2) goto L2;
        if (r10 != 3) goto L10;
        Thread.interrupted();
        return;
    L10:
        l(r10);
        throw null;
    }
}
