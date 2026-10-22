package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y {
    public static byte[] a;
    public static byte[] b;

    public static int a(Context r2, String r3, int r4) {
        return r2.getSharedPreferences("open_common", 0).getInt(r3, r4);
    L5:
        th = move-exception;
        r.f(th, "csp", "giv");
        return r4;
    }

    public static SharedPreferences.Editor b(Context r1, String r2) {
        if (r1 == null) goto L14;
    L8:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "ge");
        return null;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        return r1.getSharedPreferences(r2, 0).edit();
    L15:
        return null;
    L14:
        return null;
    }

    public static void e(SharedPreferences.Editor r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.apply();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "cm");
    }

    public static void f(SharedPreferences.Editor r0, String r1, int r2) {
        r0.putInt(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.f(th, "csp", "putPrefsInt");
    }

    public static void g(SharedPreferences.Editor r1, String r2, String r3) {
        if (r1 == null) goto L15;
    L10:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "ps");
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r1.putString(r2, r3);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public static void h(SharedPreferences.Editor r0, String r1, boolean r2) {
        r0.putBoolean(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.f(th, "csp", "setPrefsStr");
    }

    public static boolean i(Context r2, String r3, boolean r4) {
        return r2.getSharedPreferences("open_common", 0).getBoolean(r3, r4);
    L5:
        th = move-exception;
        r.f(th, "csp", "gbv");
        return r4;
    }

    public static byte[] j(Context r2) {
        if (r2 == null) goto L4;
        byte[] r0 = a;
        if (r0 != null) goto L8;
    L10:
        byte[] r3 = v4.g(r2).getBytes();
        a = r3;
        return r3;
    L8:
        if (r0.length <= 0) goto L10;
        return r0;
    L4:
        return new byte[0];
    }

    public static String k(Context r2, String r3, String r4) {
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getSharedPreferences(r3, 0).getString(r4, NameKeys.UnloadStrategy_No_Strategy);
    L9:
        th = move-exception;
        r.f(th, "csp", "gsv");
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static String c(Context r6, String r7, String r8) {
        if (r6 != null) goto L27;
        return NameKeys.UnloadStrategy_No_Strategy;
    L27:
        String r9 = r6.getSharedPreferences(r7, 0).getString(r8, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L24
        String[] r10 = f5.a;     // Catch: Throwable -> L24
        if ((r9.length() % 2) == 0) goto L9;
        r9 = "0".concat(r9);     // Catch: Throwable -> L24
    L9:
        int r11 = r9.length() / 2;     // Catch: Throwable -> L24
        byte[] r2 = new byte[r11];     // Catch: Throwable -> L24
        int r3 = 0;
    L10:
        if (r3 >= r11) goto L25;
        int r4 = r3 * 2;     // Catch: Throwable -> L24
        r2[r3] = (byte) CastIntegerProtector.parseInt(r9.substring(r4, r4 + 2), 16);     // Catch: Throwable -> L24
        r3 = r3 + 1;
        goto L10
    L25:
        byte[] r12 = j(r6);     // Catch: Exception -> L21 Throwable -> L24
        byte[] r13 = b;     // Catch: Exception -> L21 Throwable -> L24
        if (r13 != null) goto L16;
    L18:
        r13 = Arrays.copyOfRange(j(r6), 0, j(r6).length / 2);     // Catch: Exception -> L21 Throwable -> L24
        b = r13;     // Catch: Exception -> L21 Throwable -> L24
    L19:
        byte[] r14 = y4.c(r12, r2, r13);     // Catch: Exception -> L21 Throwable -> L24
    L22:
        return f5.d(r14);
        goto L29
    L16:
        if (r13.length <= 0) goto L18;
    L21:
        r14 = new byte[0];     // Catch: Throwable -> L24
    L29:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static void d(Context r4, String r5, String r6, String r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L22;
        return;
    L22:
        SharedPreferences.Editor r8 = r4.getSharedPreferences(r5, 0).edit();     // Catch: Throwable -> L21
        byte[] r9 = f5.j(r7);     // Catch: Throwable -> L21
        byte[] r1 = j(r4);     // Catch: Throwable -> L18
        byte[] r2 = b;     // Catch: Throwable -> L18
        if (r2 != null) goto L13;
    L15:
        r2 = Arrays.copyOfRange(j(r4), 0, j(r4).length / 2);     // Catch: Throwable -> L18
        b = r2;     // Catch: Throwable -> L18
    L16:
        byte[] r10 = y4.f(r1, r9, r2);     // Catch: Throwable -> L18
    L19:
        r8.putString(r6, f5.s(r10));     // Catch: Throwable -> L21
        e(r8);     // Catch: Throwable -> L21
        return;
        goto L29
    L13:
        if (r2.length <= 0) goto L15;
    L18:
        r10 = new byte[0];     // Catch: Throwable -> L21
    }
}
