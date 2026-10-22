package ka;

import ha.a0;
import ha.c0;
import ha.d0;
import ha.z;

/* JADX INFO: loaded from: classes.dex */
public final class k implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f9010a;

    public k(z.a r8) {
        this.f9010a = r8;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        if (r10.getRawType() == Object.class) goto L5;
        return null;
    L5:
        return new l(r8, this.f9010a);
    }
}
