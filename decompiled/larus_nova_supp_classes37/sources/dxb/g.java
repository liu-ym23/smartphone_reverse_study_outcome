package dxb;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g extends a {
    public final cxb.a b;

    @Override // dxb.a
    public final Map<String, Object> c() {
        cxb.a r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonParams();
    }

    public g(String r1, ntb.o.b r2, cxb.a r3) {
        super(r1, r2);
        this.b = r3;
    }
}
