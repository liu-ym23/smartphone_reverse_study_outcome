package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f19029c;

    public x0(long r5, Runnable r10) {
        super(r5);
        this.f19029c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19029c.run();
    }

    @Override // kotlinx.coroutines.y0
    public final String toString() {
        return super.toString() + this.f19029c;
    }
}
