package n4a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i4 {
    public static int a(Context r2, String r3, int r4) {
        return r2.getSharedPreferences("pref", 0).getInt(r3, r4);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsInt");
        return r4;
    }

    public static long b(Context r1, String r2, String r3, long r4) {
        return r1.getSharedPreferences(r2, 0).getLong(r3, r4);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsLong");
        return r4;
    }

    public static SharedPreferences.Editor c(Context r1, String r2) {
        return r1.getSharedPreferences(r2, 0).edit();
    }

    public static String d(Context r1, String r2, String r3, String r4) {
        return r1.getSharedPreferences(r2, 0).getString(r3, r4);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsInt");
        return r4;
    }

    public static void e(SharedPreferences.Editor r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.apply();
    }

    public static void f(SharedPreferences.Editor r0, String r1, int r2) {
        r0.putInt(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsInt");
    }

    public static void g(SharedPreferences.Editor r0, String r1, long r2) {
        r0.putLong(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsLong");
    }

    public static void h(SharedPreferences.Editor r0, String r1, String r2) {
        r0.putString(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsStr");
    }

    public static void i(SharedPreferences.Editor r0, String r1, boolean r2) {
        r0.putBoolean(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "updatePrefsBoolean");
    }

    public static boolean j(Context r2, String r3, boolean r4) {
        return r2.getSharedPreferences("pref", 0).getBoolean(r3, r4);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsBoolean");
        return r4;
    }
}
