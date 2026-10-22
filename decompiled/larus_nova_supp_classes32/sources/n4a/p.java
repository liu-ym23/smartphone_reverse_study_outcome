package n4a;

import android.content.Context;
import android.os.Looper;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public static long a;
    public static final Vector<e5> b = null;

    static {
        b = new Vector();
    }

    public static void a(e5 r3) {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        if (r3 != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        Vector<e5> r1 = b;     // Catch: Throwable -> L14
        if (r1.contains(r3) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        r1.add(r3);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    public static boolean b(String[] r5, String r6) {
        if (r6 != null) goto L21;
    L20:
        return false;
    L21:
        int r1 = r5.length;     // Catch: Throwable -> L18
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L20;
        String r3 = r5[r2];     // Catch: Throwable -> L18
        r6 = r6.trim();     // Catch: Throwable -> L18
        if (r6.startsWith("at ") == false) goto L17;
        if (r6.contains(r3 + ".") == false) goto L17;
        if (r6.endsWith(")") == false) goto L17;
        if (r6.contains("uncaughtException") == true) goto L17;
        return true;
    L17:
        r2 = r2 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static String c(Context r1, String r2) {
        return r1.getFilesDir().getAbsolutePath() + "/a/" + r2;
    }
}
