package ar1;

import am2.a0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends a<a0> {
    public a0 c;

    public b() {
    }

    @Override // ar1.a
    public final void setData(a0 r1) {
        a0 r2 = r1;
        this.c = r2;
        if (r2 == null) goto L6;
        putAll(r2.a());
        return;
    }

    @Override // ar1.a
    public final void u(Map r1, a0 r2) {
        a0 r3 = r2;
        super.u(r1, r3);
        r1.putAll(r3.a());
    }
}
