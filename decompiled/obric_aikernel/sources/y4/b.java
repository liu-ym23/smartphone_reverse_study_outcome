package y4;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13677a = "ttnet_debug_setting";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13678b = "log_switcher";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f13679c = "x86_support";

    static {
    }

    private static String a(Context r10, String r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getSharedPreferences(f13677a, 0).getString(r11, null);
    }

    public static boolean b(Context r10) {
        return "true".equals(a(r10, f13678b));
    }

    public static boolean c(Context r10) {
        return "true".equals(a(r10, f13679c));
    }
}
