package ita;

import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j {
    public static volatile h a;
    public static final i b = null;

    static {
        b = n.w();
    }

    public static void a(String r1) {
        b(r1, null);
    }

    public static void d(String r0) {
        e(r0);
    }

    public static void e(String r2) {
        h r0 = a;
        if (r0 == null) goto L5;
        r0.i(r2, null);
    L5:
        b.l(r2, new Object[0]);
    }

    public static void f(String r2) {
        h r0 = a;
        if (r0 == null) goto L5;
        r0.v(r2, null);
    L5:
        b.t(r2, new Object[0]);
    }

    public static void b(String r1, Throwable r2) {
        h r0 = a;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
    L5:
        b.j(r1, new Object[0]);
    }

    public static void c(String r2, Throwable r3) {
        h r0 = a;
        if (r0 == null) goto L5;
        r0.e(r2, r3);
    L5:
        b.q(r2, r3, new Object[0]);
    }

    public static void g(String r1, Throwable r2) {
        h r0 = a;
        if (r0 == null) goto L5;
        r0.w(r1, r2);
    L5:
        b.i(r1, new Object[0]);
    }
}
