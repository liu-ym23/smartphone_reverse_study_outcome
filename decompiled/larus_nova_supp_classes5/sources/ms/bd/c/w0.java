package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class w0 {
    public static volatile String a;
    public static final String b = null;
    public static final String c = null;

    static {
        b = (String) p2.a(16777217, 0, 0, "b306cc", new byte[]{50, 36, 77, 81, 73, 100, 113, 29, 115, 114, 118, 53, 2});
        c = (String) p2.a(16777217, 0, 0, "8bcf51", new byte[]{104, 101, 2, 0, 75});
    }

    public static String a() {
        if (a == null) goto L7;
        return a;
    L7:
        monitor-enter(w0.class);
    L38:
        th = move-exception;
        throw th;
    L9:
        if (a == null) goto L14;
        String r0 = a;     // Catch: Throwable -> L38
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return r0;
    L14:
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        a = b;     // Catch: Throwable -> L38
        String r1 = a;     // Catch: Throwable -> L38
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return r1;
    L18:
        v0 r2 = null;
        v0 r3 = new v0();     // Catch: Throwable -> L26 Exception -> L41
        r3.c(EGL14.EGL_NO_SURFACE);     // Catch: Throwable -> L23 Exception -> L25
        a = GLES20.glGetString(7936) + ((String) p2.a(16777217, 0, 0, "fd58ac", new byte[]{107})) + GLES20.glGetString(7937) + ((String) p2.a(16777217, 0, 0, "e3ea61", new byte[]{104})) + GLES20.glGetString(7938);     // Catch: Throwable -> L23 Exception -> L25
        r3.b();     // Catch: Throwable -> L38
    L31:
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return a;
    L25:
        r2 = r3;
    L23:
        th = th;
    L35:
        if (r3 == null) goto L37;
        r3.b();     // Catch: Throwable -> L38
    L37:
        throw th;     // Catch: Throwable -> L38
    L26:
        th = th;
        r3 = r2;
    L28:
        a = c;     // Catch: Throwable -> L26
        if (r2 == null) goto L31;
        r2.b();     // Catch: Throwable -> L38
        goto L31
    }
}
