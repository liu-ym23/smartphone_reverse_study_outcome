package v64;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import f06.d;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static String a(Context r4, String r5) {
        Cursor r2 = null;
        byte[] r0 = c(r5.substring(0, 24));     // Catch: Throwable -> L19
        byte[] r6 = c(r5.substring(24));     // Catch: Throwable -> L19
        Cursor r7 = e(r4.getContentResolver(), Uri.parse("content://com.huawei.hwid.pps.apiprovider/oaid_scp/get"));     // Catch: Throwable -> L19
        if (r7 != null) goto L31;
    L16:
        if (r7 != null) goto L29;
    L18:
        return null;
    L29:
        r7.close();     // Catch: Exception -> L25
        goto L18
    L31:
    L14:
        Throwable th = th;
        r2 = r7;
    L21:
        if (r2 == null) goto L37;
        r2.close();     // Catch: Exception -> L26
        throw th;
    L38:
        throw th;
    L37:
        throw th;
    L6:
        if (r7.moveToNext() == false) goto L16;
        int r1 = r7.getColumnIndex("op_wk");     // Catch: Throwable -> L14
        if (r1 < 0) goto L16;
        String r3 = r7.getString(r1);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r3) == true) goto L16;
        SecretKeySpec r8 = new SecretKeySpec(c(r3), "AES");     // Catch: Throwable -> L14
        GCMParameterSpec r9 = new GCMParameterSpec(128, r0);     // Catch: Throwable -> L14
        Cipher r10 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L14
        r10.init(2, r8, r9);     // Catch: Throwable -> L14
        String r12 = new String(r10.doFinal(r6), "UTF-8");     // Catch: Throwable -> L14
        r7.close();     // Catch: Exception -> L24
    L13:
        return r12;
    L19:
        th = move-exception;
        th = th;
        goto L21
    }

    public static byte[] c(String r7) {
        int r1 = 0;
        if (TextUtils.isEmpty(r7) == true) goto L5;
        int r0 = r7.length();
        byte[] r2 = new byte[r0 / 2];
    L7:
        if (r1 >= r0) goto L9;
        r2[r1 / 2] = (byte) ((Character.digit(r7.charAt(r1), 16) << 4) + Character.digit(r7.charAt(r1 + 1), 16));
        r1 = r1 + 2;
        goto L7
    L9:
        return r2;
    L5:
        return new byte[0];
    }

    public static c b(Context r8) {
        c r2 = new c();
        if (r8 != null) goto L5;
        return r2;
    L5:
        long r3 = SystemClock.elapsedRealtime();
        String r5 = f(r8.getContentResolver(), "oaid_limit_state");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = Settings.Global.getString(r8.getContentResolver(), "oaid_limit_state");     // Catch: Exception -> L25
    L9:
        boolean r1 = "true".equalsIgnoreCase(r5);     // Catch: Exception -> L25
        if (r1 == false) goto L14;
        r2.a = "00000000-0000-0000-0000-000000000000";     // Catch: Exception -> L25
        r2.b = r1;     // Catch: Exception -> L25
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L25
        return r2;
    L14:
        String r6 = f(r8.getContentResolver(), "oaid");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r6) == false) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == false) goto L23;
        r2.a = r6;     // Catch: Exception -> L25
        r2.b = r1;     // Catch: Exception -> L25
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L25
        r2.e = "secure";     // Catch: Exception -> L25
        return r2;
    L23:
        r2.a = Settings.Global.getString(r8.getContentResolver(), "oaid");     // Catch: Exception -> L25
        r2.b = r1;     // Catch: Exception -> L25
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L25
        r2.e = "global";     // Catch: Exception -> L25
        return r2;
    L17:
        if ("00000000-0000-0000-0000-000000000000".equals(r6) == true) goto L19;
        r7 = true;
    L25:
        e = move-exception;
        r2.c = "honor error: " + e;
        r2.d = SystemClock.elapsedRealtime() - r3;
        return r2;
    }

    public static c d(Context r8) {
        c r2 = new c();
        if (r8 != null) goto L6;
        r2.c = "context is null";
        return r2;
    L6:
        long r3 = SystemClock.elapsedRealtime();
        String r5 = Settings.Global.getString(r8.getContentResolver(), "pps_oaid_c");     // Catch: Exception -> L24
        r2.b = Boolean.parseBoolean(Settings.Global.getString(r8.getContentResolver(), "pps_track_limit"));     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r5) == false) goto L19;
        String r9 = Settings.Global.getString(r8.getContentResolver(), "pps_oaid");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r9) == false) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L26;
        r2.a = r9;     // Catch: Exception -> L24
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L24
        r2.e = "pps_oaid";     // Catch: Exception -> L24
        return r2;
    L26:
        return r2;
    L12:
        if ("00000000-0000-0000-0000-000000000000".equals(r9) == true) goto L14;
        r1 = true;
        goto L15
    L19:
        if (r5.length() < 24) goto L22;
        r2.a = a(r8, r5);     // Catch: Exception -> L24
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L24
        r2.e = "pps_oaid_c";     // Catch: Exception -> L24
        return r2;
    L22:
        r2.c = "oaid too short";     // Catch: Exception -> L24
        r2.e = "pps_oaid_c";     // Catch: Exception -> L24
        r2.d = SystemClock.elapsedRealtime() - r3;     // Catch: Exception -> L24
        return r2;
    L24:
        e = move-exception;
        r2.c = "huawei error:" + e;
        r2.d = SystemClock.elapsedRealtime() - r3;
        goto L26
    }

    public static Cursor e(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        f06.b r10 = new f06.b();
        d r14 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r14.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r14.b;
    L6:
        Cursor r15 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public static String f(ContentResolver r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r12, r13};
        f06.b r10 = new f06.b();
        d r14 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r10);
        if (r14.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r10, false);
        return (String) r14.b;
    L6:
        String r15 = Settings.Secure.getString(r12, r13);
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r15, r10, true);
        return r15;
    }
}
