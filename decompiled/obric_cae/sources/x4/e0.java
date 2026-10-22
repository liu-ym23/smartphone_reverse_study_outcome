package x4;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f13410a;

    public e0(d0 r8) {
        this.f13410a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0 r8 = this.f13410a;
        if (r8.f13397p.compareAndSet(false, true) == false) goto L6;
        r8.b(new c(r8.f13392a, r8.f13396o));
        return;
    }
}
