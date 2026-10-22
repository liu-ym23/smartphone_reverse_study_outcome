package onb;

import android.app.Application;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public final g a;
    public final long b;
    public final long c;
    public final l d;

    public static class a {
        public boolean a;
        public Application b;
        public String c;
        public d d;
        public d e;
        public nnb.d f;
        public String g;

        public a() {
        }
    }

    public k(a r6) {
        d r0 = r6.d;
        if (r0 == null) goto L11;
        Application r2 = r6.b;
        if (r2 == null) goto L9;
        this.b = 6000;
        this.c = 20000;
        nnb.c.C0302c r1 = new nnb.c.C0302c();
        r1.b = r2;
        r1.a = r6.a;
        r1.c = r6.c;
        r1.d = r6.f;
        r1.e = r6.g;
        d r7 = r6.e;
        this.d = new l();
        this.a = new g(new nnb.c(r1), new n(), r0, r7);
        return;
    L9:
        throw new NullPointerException("jsclient build npe");
    L11:
        throw new NullPointerException("jsclient build npe");
    }
}
