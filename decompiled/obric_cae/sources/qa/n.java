package qa;

import android.content.Context;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f10840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Vector<s4> f10841b = null;

    static {
        f10841b = new Vector();
    }

    public static boolean a(String r8, String[] r10) {
        if (r8 != null) goto L21;
    L20:
        return false;
    L21:
        int r11 = r10.length;     // Catch: Throwable -> L18
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L20;
        String r13 = r10[r12];     // Catch: Throwable -> L18
        r8 = r8.trim();     // Catch: Throwable -> L18
        if (r8.startsWith("at ") == false) goto L17;
        if (r8.contains(r13 + ".") == false) goto L17;
        if (r8.endsWith(")") == false) goto L17;
        if (r8.contains("uncaughtException") == true) goto L17;
        return true;
    L17:
        r12 = r12 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static String b(Context r8, String r10) {
        return r8.getFilesDir().getAbsolutePath() + "/a/" + r10;
    }
}
