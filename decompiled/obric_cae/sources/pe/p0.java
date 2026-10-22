package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f10055a;

    public p0(o0 r8) {
        this.f10055a = r8;
    }

    @Override // pe.f
    public final void a(Throwable r8) {
        this.f10055a.e();
    }

    @Override // ge.l
    public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
        a(r8);
        return xd.j.f13877a;
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.f10055a + ']';
    }
}
