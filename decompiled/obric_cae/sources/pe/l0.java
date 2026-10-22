package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class l0<T> extends ue.t<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10041o = null;
    private volatile int _decision;

    static {
        f10041o = AtomicIntegerFieldUpdater.newUpdater(l0.class, "_decision");
    }

    @Override // ue.t, pe.j1
    public final void e(Object r8) {
        f(r8);
    }

    @Override // ue.t, pe.j1
    public final void f(Object r8) {
    L2:
        AtomicIntegerFieldUpdater r10 = f10041o;
        int r11 = r10.get(this);
        boolean r12 = false;
        if (r11 != 0) goto L4;
        if (r10.compareAndSet(this, 0, 2) == false) goto L2;
        r12 = true;
    L11:
        if (r12 == false) goto L13;
        return;
    L13:
        ue.h.a(l6.a.b0(this.f12625n), l6.a.G0(r8), null);
        return;
    L4:
        if (r11 == 1) goto L11;
        throw new IllegalStateException("Already resumed".toString());
    }
}
