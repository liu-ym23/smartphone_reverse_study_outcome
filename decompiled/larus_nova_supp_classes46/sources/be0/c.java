package be0;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final Map<Integer, a> a;

    public c() {
        this.a = new LinkedHashMap();
    }

    public final a a(int r3) {
        Map<Integer, a> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        a r2 = (a) r1.get(Integer.valueOf(r3));
        if (r2 == null) goto L5;
    L24:
        return r2;
    L5:
        if (r3 != 1) goto L7;
        r2 = new b();
    L23:
        this.a.put(Integer.valueOf(r3), r2);
        goto L24
    L7:
        if (r3 != 2) goto L9;
        r2 = new e();
        goto L23
    L9:
        if (r3 != 3) goto L11;
        r2 = new g();
        goto L23
    L11:
        if (r3 != 4) goto L13;
        r2 = new f();
        goto L23
    L13:
        if (r3 != 5) goto L15;
        r2 = new e();
        goto L23
    L15:
        if (r3 == 100) goto L17;
        r2 = new e();
        goto L23
    L17:
        r2 = new d();
        goto L23
    }
}
