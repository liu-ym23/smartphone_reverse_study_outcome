package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends m1 implements o {
    public final q e;

    public p(q r5) {
        this.e = r5;
    }

    @Override // kotlinx.coroutines.o
    public final boolean a(Throwable r5) {
        return h().A(r5);
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        return true;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
        r1 r10 = h();
        ((r1) this.e).w(r10);
    }
}
