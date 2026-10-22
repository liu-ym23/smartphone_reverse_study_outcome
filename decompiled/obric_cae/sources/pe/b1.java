package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge.l<Throwable, xd.j> f9997a;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(ge.l<? super Throwable, xd.j> r8) {
        this.f9997a = r8;
    }

    @Override // pe.f
    public final void a(Throwable r8) {
        this.f9997a.invoke(r8);
    }

    @Override // ge.l
    public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
        a(r8);
        return xd.j.f13877a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.f9997a.getClass().getSimpleName() + '@' + d0.c(this) + ']';
    }
}
