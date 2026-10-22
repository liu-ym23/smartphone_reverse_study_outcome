package x4;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f13580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f13581c = null;

    static {
        f13581c = "0123456789ABCDEF".toCharArray();
    }

    public static String a(byte[] r8) {
        char[] r10 = new char[r8.length * 2];
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L7;
        int r12 = r8[r11] & 255;
        int r13 = r11 * 2;
        char[] r14 = f13581c;
        r10[r13] = r14[r12 >>> 4];
        r10[r13 + 1] = r14[r12 & 15];
        r11 = r11 + 1;
        goto L4
    L7:
        return new String(r10);
    }

    public static boolean b(String r8) {
        boolean r10 = false;
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r8) == true) goto L18;
        if ("Null".equalsIgnoreCase(r8) == true) goto L18;
        int r11 = 0;
    L10:
        if (r11 >= r8.length()) goto L15;
        if (r8.charAt(r11) != '0') goto L17;
        r11 = r11 + 1;
    L17:
        return !r10;
    L15:
        r10 = true;
        goto L17
    }

    public static void c(Closeable r8) {
        if (r8 == null) goto L10;
        r8.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void d(JSONObject r8, JSONObject r10) {
        if (r10 != null) goto L19;
        return;
    L19:
        monitor-enter(d5.l.class);     // Catch: JSONException -> L15
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L12
    L8:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();     // Catch: Throwable -> L12
        r8.put(r12, r10.opt(r12));     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(d5.l.class);     // Catch: Throwable -> L12
    L22:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: JSONException -> L15
    L15:
        int r13 = r.f13543a;
    }

    public static boolean e(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
    L6:
        if (r8 != null) goto L8;
    L10:
        return false;
    L8:
        if (r8.equals(r10) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        goto L6
    }

    public static boolean f(Context r8) {
        if (f13580b != null) goto L45;
        if (r8 == null) goto L43;
        String r10 = f13579a;
        if (TextUtils.isEmpty(r10) == false) goto L41;
        r10 = Application.getProcessName();
        if (TextUtils.isEmpty(r10) == true) goto L11;
        f13579a = r10;
        goto L41
    L11:
        String r11 = null;
        Method r12 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L48
        r12.setAccessible(true);     // Catch: Throwable -> L48
        Object r13 = r12.invoke(null, new Object[0]);     // Catch: Throwable -> L48
        if ((r13 instanceof String) == false) goto L16;
        String r14 = (String) r13;     // Catch: Throwable -> L48
    L18:
        if (TextUtils.isEmpty(r14) == true) goto L55;
        f13579a = r14;
        r10 = r14;
        goto L41
    L55:
        int r15 = Process.myPid();     // Catch: Exception -> L27
        Iterator<ActivityManager.RunningAppProcessInfo> r16 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L27
    L22:
        if (r16.hasNext() == false) goto L51;
        ActivityManager.RunningAppProcessInfo r17 = r16.next();     // Catch: Exception -> L27
        if (r17.pid != r15) goto L22;
        f13579a = r17.processName;     // Catch: Exception -> L27
    L51:
        BufferedReader r18 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L37
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L47
    L32:
        int r20 = r18.read();     // Catch: Throwable -> L47
        if (r20 <= 0) goto L35;
        r19.append((char) r20);     // Catch: Throwable -> L47
        goto L32
    L35:
        r11 = r19.toString();     // Catch: Throwable -> L47
    L49:
        r18.close();     // Catch: Exception -> L46
    L40:
        f13579a = r11;
        int r21 = r.f13543a;
        r10 = f13579a;
    L38:
        if (r18 == null) goto L40;
    L37:
        r18 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
    L16:
        r14 = null;
    L41:
        f13580b = Boolean.valueOf(TextUtils.equals(r10, r8.getPackageName()));
        goto L45
    L43:
        throw new NullPointerException("context is null");
    L45:
        return f13580b.booleanValue();
    }

    public static boolean g(String r8) {
        if (r8 == null) goto L5;
        int r10 = r8.length();
    L7:
        if (r10 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r10 > 128) goto L31;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L29;
        char r12 = r8.charAt(r11);
        if (r12 < '0') goto L18;
        if (r12 > '9') goto L18;
    L27:
        r11 = r11 + 1;
    L18:
        if (r12 < 'a') goto L22;
        if (r12 <= 'f') goto L27;
    L22:
        if (r12 < 'A') goto L26;
        if (r12 <= 'F') goto L27;
    L26:
        if (r12 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r10 = 0;
        goto L7
    }

    public static void h(JSONObject r8, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == true) goto L6;
        r8.put(r10, r11);
        return;
    }

    public static void i(SharedPreferences r8, String[] r10) {
        SharedPreferences.Editor r11 = r8.edit();
        int r12 = r10.length;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 >= r12) goto L8;
        String r15 = r10[r13];
        if (r8.contains(r15) == false) goto L7;
        r11.remove(r15);
        r14 = true;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 == false) goto L14;
        r11.apply();
        return;
    }
}
