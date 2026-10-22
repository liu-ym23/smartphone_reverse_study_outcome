package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 implements ae.f.b, ae.f.c<a2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f9993a = null;

    static {
        f9993a = new a2();
    }

    @Override // ae.f
    public final <R> R B(R r8, ge.p<? super R, ? super ae.f.b, ? extends R> r10) {
        return (R) ae.f.b.a.a(this, r8, r10);
    }

    @Override // ae.f
    public final ae.f C(ae.f r8) {
        he.i.f(r8, "context");
        return ae.f.a.a(this, r8);
    }

    @Override // ae.f.b
    public final ae.f.c<?> getKey() {
        return this;
    }

    @Override // ae.f
    public final ae.f h0(ae.f.c<?> r8) {
        return ae.f.b.a.c(this, r8);
    }

    @Override // ae.f
    public final <E extends ae.f.b> E q0(ae.f.c<E> r8) {
        return (E) ae.f.b.a.b(this, r8);
    }
}
