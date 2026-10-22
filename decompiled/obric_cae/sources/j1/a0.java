package j1;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements k.a<List<r1.t.b>, androidx.work.u> {
    @Override // k.a
    public final androidx.work.u apply(List<r1.t.b> r8) {
        List<r1.t.b> r10 = r8;
        if (r10 != null) goto L5;
    L7:
        return null;
    L5:
        if (r10.size() <= 0) goto L7;
        return r10.get(0).a();
    }
}
