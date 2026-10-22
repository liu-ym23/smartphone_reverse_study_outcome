package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends g1 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10001p = null;
    private volatile int _invoked;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ge.l<Throwable, xd.j> f10002o;

    static {
        f10001p = AtomicIntegerFieldUpdater.newUpdater(c1.class, "_invoked");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c1(ge.l<? super Throwable, xd.j> r8) {
        this.f10002o = r8;
    }

    @Override // ge.l
    public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
        m(r8);
        return xd.j.f13877a;
    }

    @Override // pe.q
    public final void m(Throwable r8) {
        if (f10001p.compareAndSet(this, 0, 1) == false) goto L6;
        this.f10002o.invoke(r8);
        return;
    }
}
