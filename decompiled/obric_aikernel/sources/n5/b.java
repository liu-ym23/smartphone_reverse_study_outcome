package n5;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11253a;

    static {
        f11253a = Log.isLoggable("watson_assist", 3);
    }

    public static void a(String r10) {
        b("watson_assist", r10);
    }

    public static void b(String r10, String r11) {
        if (f11253a == false) goto L6;
        Log.d(r10, r11);
        return;
    }

    public static void c(String r10) {
        d("watson_assist", r10);
    }

    public static void d(String r10, String r11) {
        Log.e(r10, r11);
    }

    public static void e(String r10) {
        f("watson_assist", r10);
    }

    public static void f(String r10, String r11) {
        Log.i(r10, r11);
    }

    public static void g(String r10) {
        h("watson_assist", r10);
    }

    public static void h(String r10, String r11) {
        Log.w(r10, r11);
    }
}
