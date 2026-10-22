package qa;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class x3 {
    public static int a(Context r8, int r10, String r11) {
        return r8.getSharedPreferences("pref", 0).getInt(r11, r10);
    L5:
        th = move-exception;
        t3.g("SpUtil", "getPrefsInt", th);
        return r10;
    }

    public static long b(Context r8, String r10, String r11, long r12) {
        return r8.getSharedPreferences(r10, 0).getLong(r11, r12);
    L5:
        th = move-exception;
        t3.g("SpUtil", "getPrefsLong", th);
        return r12;
    }

    public static SharedPreferences.Editor c(Context r8, String r10) {
        return r8.getSharedPreferences(r10, 0).edit();
    }

    public static String d(Context r8, String r10, String r11, String r12) {
        return r8.getSharedPreferences(r10, 0).getString(r11, r12);
    L5:
        th = move-exception;
        t3.g("SpUtil", "getPrefsInt", th);
        return r12;
    }

    public static void e(SharedPreferences.Editor r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.apply();
    }

    public static void f(SharedPreferences.Editor r8, String r10, int r11) {
        r8.putInt(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("SpUtil", "setPrefsInt", th);
    }

    public static void g(SharedPreferences.Editor r8, String r10, long r11) {
        r8.putLong(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("SpUtil", "setPrefsLong", th);
    }

    public static void h(SharedPreferences.Editor r8, String r10, String r11) {
        r8.putString(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("SpUtil", "setPrefsStr", th);
    }

    public static void i(SharedPreferences.Editor r8, String r10, boolean r11) {
        r8.putBoolean(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("SpUtil", "updatePrefsBoolean", th);
    }

    public static boolean j(Context r8, String r10, boolean r11) {
        return r8.getSharedPreferences("pref", 0).getBoolean(r10, r11);
    L5:
        th = move-exception;
        t3.g("SpUtil", "getPrefsBoolean", th);
        return r11;
    }
}
