package n4a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d1 extends h1 {
    public final String b;

    public d1(String r1, e1 r2) {
        super(r2);
        this.b = r1;
    }

    @Override // n4a.h1
    public final boolean c() {
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.b);     // Catch: Throwable -> L8
        if (r2.exists() == false) goto L10;
        int r0 = r2.list().length;     // Catch: Throwable -> L8
    L12:
        if (r0 >= 30) goto L14;
        return false;
    L14:
        return true;
    L10:
        r0 = 0;
    L8:
        th = move-exception;
        r.f(th, "fus", "gfn");
        goto L10
    }
}
