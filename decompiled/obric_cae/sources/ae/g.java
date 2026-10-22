package ae;

import ge.p;
import he.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements f, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f354a = null;

    static {
        f354a = new g();
    }

    @Override // ae.f
    public final <R> R B(R r8, p<? super R, ? super f.b, ? extends R> r10) {
        i.f(r10, "operation");
        return r8;
    }

    @Override // ae.f
    public final f C(f r8) {
        i.f(r8, "context");
        return r8;
    }

    @Override // ae.f
    public final f h0(f.c<?> r8) {
        i.f(r8, "key");
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // ae.f
    public final <E extends f.b> E q0(f.c<E> r8) {
        i.f(r8, "key");
        return null;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
