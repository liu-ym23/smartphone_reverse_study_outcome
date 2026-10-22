package ae;

import ge.p;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.c<?> f345a;

    public a(f.c<?> r8) {
        this.f345a = r8;
    }

    @Override // ae.f
    public final <R> R B(R r8, p<? super R, ? super f.b, ? extends R> r10) {
        i.f(r10, "operation");
        return r10.invoke(r8, this);
    }

    @Override // ae.f
    public final f C(f r8) {
        i.f(r8, "context");
        return f.a.a(this, r8);
    }

    @Override // ae.f.b
    public final f.c<?> getKey() {
        return this.f345a;
    }

    @Override // ae.f
    public f h0(f.c<?> r8) {
        return f.b.a.c(this, r8);
    }

    @Override // ae.f
    public <E extends f.b> E q0(f.c<E> r8) {
        return (E) f.b.a.b(this, r8);
    }
}
