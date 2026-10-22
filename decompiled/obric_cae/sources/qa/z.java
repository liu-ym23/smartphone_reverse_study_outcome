package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f11245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f11246b;

    public z() {
        String r8 = "HttpsDecisionUtil";
        if (TextUtils.isDigitsOnly("HttpsDecisionUtil") == false) goto L5;
        r8 = "SPUtil";
    L5:
        l6.a.j(r8);
    }

    public static int a(Context r8, int r10, String r11) {
        return r8.getSharedPreferences("open_common", 0).getInt(r11, r10);
    L5:
        th = move-exception;
        q.f("csp", "giv", th);
        return r10;
    }

    public static SharedPreferences.Editor b(Context r8, String r10) {
        if (r8 == null) goto L14;
    L8:
        th = move-exception;
        l.a("sp", "ge", th);
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        return r8.getSharedPreferences(r10, 0).edit();
    L15:
        return null;
    L14:
        return null;
    }

    public static String c(Context r8, String r10, String r11) {
        if (r8 != null) goto L27;
        return "";
    L27:
        String r12 = r8.getSharedPreferences(r10, 0).getString(r11, "");     // Catch: Throwable -> L24
        String[] r13 = t4.f11124a;     // Catch: Throwable -> L24
        if ((r12.length() % 2) == 0) goto L9;
        r12 = "0".concat(r12);     // Catch: Throwable -> L24
    L9:
        int r14 = r12.length() / 2;     // Catch: Throwable -> L24
        byte[] r15 = new byte[r14];     // Catch: Throwable -> L24
        int r16 = 0;
    L10:
        if (r16 >= r14) goto L25;
        int r17 = r16 * 2;     // Catch: Throwable -> L24
        r15[r16] = (byte) Integer.parseInt(r12.substring(r17, r17 + 2), 16);     // Catch: Throwable -> L24
        r16 = r16 + 1;
        goto L10
    L25:
        byte[] r18 = j(r8);     // Catch: Exception -> L21 Throwable -> L24
        byte[] r19 = f11246b;     // Catch: Exception -> L21 Throwable -> L24
        if (r19 != null) goto L16;
    L18:
        r19 = Arrays.copyOfRange(j(r8), 0, j(r8).length / 2);     // Catch: Exception -> L21 Throwable -> L24
        f11246b = r19;     // Catch: Exception -> L21 Throwable -> L24
    L19:
        byte[] r20 = l4.c(r18, r15, r19);     // Catch: Exception -> L21 Throwable -> L24
    L22:
        return t4.c(r20);
        goto L29
    L16:
        if (r19.length <= 0) goto L18;
    L21:
        r20 = new byte[0];     // Catch: Throwable -> L24
    L29:
        return "";
    }

    public static void d(Context r8, String r10, String r11, String r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L22;
        return;
    L22:
        SharedPreferences.Editor r13 = r8.getSharedPreferences(r10, 0).edit();     // Catch: Throwable -> L21
        byte[] r14 = t4.i(r12);     // Catch: Throwable -> L21
        byte[] r15 = j(r8);     // Catch: Throwable -> L18
        byte[] r16 = f11246b;     // Catch: Throwable -> L18
        if (r16 != null) goto L13;
    L15:
        r16 = Arrays.copyOfRange(j(r8), 0, j(r8).length / 2);     // Catch: Throwable -> L18
        f11246b = r16;     // Catch: Throwable -> L18
    L16:
        byte[] r17 = l4.f(r15, r14, r16);     // Catch: Throwable -> L18
    L19:
        r13.putString(r11, t4.r(r17));     // Catch: Throwable -> L21
        e(r13);     // Catch: Throwable -> L21
        return;
        goto L29
    L13:
        if (r16.length <= 0) goto L15;
    L18:
        r17 = new byte[0];     // Catch: Throwable -> L21
    }

    public static void e(SharedPreferences.Editor r8) {
        if (r8 != null) goto L9;
        return;
    L9:
        r8.apply();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        l.a("sp", "cm", th);
    }

    public static void f(SharedPreferences.Editor r8, String r10, int r11) {
        r8.putInt(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        q.f("csp", "putPrefsInt", th);
    }

    public static void g(SharedPreferences.Editor r8, String r10, String r11) {
        if (r8 == null) goto L15;
    L10:
        th = move-exception;
        l.a("sp", "ps", th);
        return;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L17;
        r8.putString(r10, r11);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public static void h(SharedPreferences.Editor r8, String r10, boolean r11) {
        r8.putBoolean(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        q.f("csp", "setPrefsStr", th);
    }

    public static boolean i(Context r8, String r10, boolean r11) {
        return r8.getSharedPreferences("open_common", 0).getBoolean(r10, r11);
    L5:
        th = move-exception;
        q.f("csp", "gbv", th);
        return r11;
    }

    public static byte[] j(Context r8) {
        if (r8 == null) goto L4;
        byte[] r10 = f11245a;
        if (r10 != null) goto L8;
    L10:
        byte[] r11 = h4.g(r8).getBytes();
        f11245a = r11;
        return r11;
    L8:
        if (r10.length <= 0) goto L10;
        return r10;
    L4:
        return new byte[0];
    }

    public static String k(Context r8, String r10, String r11) {
        if (r8 != null) goto L12;
        return null;
    L12:
        return r8.getSharedPreferences(r10, 0).getString(r11, "");
    L9:
        th = move-exception;
        q.f("csp", "gsv", th);
        return "";
    }
}
