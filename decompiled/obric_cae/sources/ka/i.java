package ka;

import ha.c0;
import ha.d0;

/* JADX INFO: loaded from: classes.dex */
public final class i implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f9007a;

    public i(j r8) {
        this.f9007a = r8;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        if (r10.getRawType() == Number.class) goto L7;
        return null;
    L7:
        return this.f9007a;
    }
}
