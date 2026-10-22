package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 extends w {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f10091m = 0;

    static {
        new y1();
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        if (((b2) r8.q0(b2.f9998b)) == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // pe.w
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
