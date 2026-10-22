package qnb;

import rnb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static a a;
    public static snb.a b;

    public interface a {
        snb.a a();
    }

    public static snb.a a() {
        if (b != null) goto L9;
        if (a != null) goto L7;
        qnb.a r0 = new qnb.a();
        a = r0;
        b = r0.a();
        c.a = r0.b();
    L7:
        b = a.a();
    L9:
        return b;
    }
}
