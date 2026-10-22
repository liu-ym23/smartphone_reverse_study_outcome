package n4a;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t0 {
    public static n0 a() {
        return (n0) new WeakReference(new n0()).get();
    }

    public static void b(Context r0, n0 r1, String r2, int r3, int r4, String r5) {
        r1.a = p.c(r0, r2);
        r1.d = r3;
        r1.b = r4;
        r1.c = r5;
    }

    public static byte[] c(h0 r4, String r5) {
        byte[] r1 = new byte[0];
        InputStream r2 = null;
        h0.e r6 = r4.a(r5);     // Catch: Throwable -> L37
        if (r6 != null) goto L65;
        if (r6 != null) goto L73;
    L36:
        return r1;
    L73:
        r6.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L65:
        InputStream r7 = r6.a[0];     // Catch: Throwable -> L29
        if (r7 != null) goto L83;
        if (r7 == null) goto L87;
        r7.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L87:
        r6.close();     // Catch: Throwable -> L14
    L16:
        return r1;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L83:
        r1 = new byte[r7.available()];     // Catch: Throwable -> L27
        r7.read(r1);     // Catch: Throwable -> L27
        r7.close();     // Catch: Throwable -> L20
    L75:
        r6.close();     // Catch: Throwable -> L24
    L26:
        return r1;
    L24:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = th;
        r2 = r7;
    L77:
        r.f(th, "sui", "rdS");     // Catch: Throwable -> L51
        if (r2 != null) goto L81;
    L45:
        if (r6 != null) goto L71;
    L50:
        return r1;
    L71:
        r6.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L81:
        r2.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L51:
        th = move-exception;
        if (r2 != null) goto L67;
    L57:
        if (r6 == null) goto L89;
        r6.close();     // Catch: Throwable -> L60
        throw th;
    L60:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L89:
        throw th;
    L67:
        r2.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
    L29:
        th = th;
    L37:
        th = th;
        r6 = null;
        goto L77
    }
}
