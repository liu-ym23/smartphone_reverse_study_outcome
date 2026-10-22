package ka;

import ha.c0;
import ha.d0;

/* JADX INFO: loaded from: classes.dex */
public final class s implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f9085b;

    public s(Class r8, c0 r10) {
        this.f9084a = r8;
        this.f9085b = r10;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        if (r10.getRawType() == this.f9084a) goto L7;
        return null;
    L7:
        return this.f9085b;
    }

    public final String toString() {
        return "Factory[type=" + this.f9084a.getName() + ",adapter=" + this.f9085b + "]";
    }
}
