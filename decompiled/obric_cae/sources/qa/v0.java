package qa;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {
    public static p0 a() {
        return (p0) new WeakReference(new p0()).get();
    }

    public static void b(Context r8, p0 r10, String r11, int r12, int r13, String r14) {
        r10.f10884a = n.b(r8, r11);
        r10.f10887d = r12;
        r10.f10885b = r13;
        r10.f10886c = r14;
    }

    public static byte[] c(e0 r8, String r10) {
        byte[] r11 = new byte[0];
        InputStream r12 = null;
        e0.e r13 = r8.a(r10);     // Catch: Throwable -> L37
        if (r13 != null) goto L65;
        if (r13 != null) goto L73;
    L36:
        return r11;
    L73:
        r13.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L65:
        InputStream r14 = r13.f10362a[0];     // Catch: Throwable -> L29
        if (r14 != null) goto L83;
        if (r14 == null) goto L87;
        r14.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L87:
        r13.close();     // Catch: Throwable -> L14
    L16:
        return r11;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L83:
        r11 = new byte[r14.available()];     // Catch: Throwable -> L27
        r14.read(r11);     // Catch: Throwable -> L27
        r14.close();     // Catch: Throwable -> L20
    L75:
        r13.close();     // Catch: Throwable -> L24
    L26:
        return r11;
    L24:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = th;
        r12 = r14;
    L77:
        q.f("sui", "rdS", th);     // Catch: Throwable -> L51
        if (r12 != null) goto L81;
    L45:
        if (r13 != null) goto L69;
    L50:
        return r11;
    L69:
        r13.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L81:
        r12.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L51:
        th = move-exception;
        if (r12 != null) goto L67;
    L57:
        if (r13 == null) goto L89;
        r13.close();     // Catch: Throwable -> L60
        throw th;
    L60:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L89:
        throw th;
    L67:
        r12.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
    L29:
        th = th;
    L37:
        th = th;
        r13 = null;
        goto L77
    }
}
