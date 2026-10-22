package te;

import ge.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ae.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f12389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ae.f f12390b;

    public c(ae.f r8, Throwable r10) {
        this.f12389a = r10;
        this.f12390b = r8;
    }

    @Override // ae.f
    public final <R> R B(R r8, p<? super R, ? super ae.f.b, ? extends R> r10) {
        return (R) this.f12390b.B(r8, r10);
    }

    @Override // ae.f
    public final ae.f C(ae.f r8) {
        return this.f12390b.C(r8);
    }

    @Override // ae.f
    public final ae.f h0(ae.f.c<?> r8) {
        return this.f12390b.h0(r8);
    }

    @Override // ae.f
    public final <E extends ae.f.b> E q0(ae.f.c<E> r8) {
        return (E) this.f12390b.q0(r8);
    }
}
