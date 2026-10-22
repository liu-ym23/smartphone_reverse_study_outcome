package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f1142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f1143b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f1144c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1145d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f1146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f1147f;

    static {
        f1142a = "amigo";
        f1143b = "funtouch";
    }

    public static String a() {
        return m("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + m("ro.gn.sv.version");
    }

    public static String c() {
        if (q() == true) goto L5;
        return "";
    L5:
        return "coloros_" + m("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String d() {
        Method r10 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L6
        r10.setAccessible(true);     // Catch: Throwable -> L6
        Object r11 = r10.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L6
        if ((r11 instanceof String) == false) goto L11;
        return (String) r11;
    L11:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String e() {
        String r10 = g();
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("emotionui") == true) goto L7;
        return "";
    L7:
        return r10 + "_" + Build.DISPLAY;
    }

    public static String f() {
        if (r() == true) goto L5;
        return "";
    L5:
        return "eui_" + m("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String g() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return m("ro.build.version.emui");
    L7:
        return d();
    }

    public static String h() {
        String r10 = Build.DISPLAY;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L9;
        return r10;
    L9:
        return "";
    }

    public static String i() {
        return m("ro.vivo.os.build.display.id") + "_" + m("ro.vivo.product.version");
    }

    public static String j() {
        if (v() == true) goto L5;
        return "";
    L5:
        return "miui_" + m("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String k() {
        if (v() == false) goto L7;
        return j();
    L7:
        if (s() == false) goto L11;
        return h();
    L11:
        if (q() == true) goto L13;
        String r10 = e();
        if (TextUtils.isEmpty(r10) == true) goto L18;
        return r10;
    L18:
        if (t() == false) goto L22;
        return i();
    L22:
        if (p() == false) goto L26;
        return b();
    L26:
        if (o() == true) goto L28;
        String r11 = f();
        if (TextUtils.isEmpty(r11) == true) goto L32;
        return r11;
    L32:
        f1145d = true;
        return Build.DISPLAY;
    L28:
        return a();
    L13:
        return c();
    }

    public static String l() {
        if (f1145d == true) goto L5;
    L8:
        String r10 = k();
        f1146e = r10;
        return r10;
    L5:
        if (TextUtils.isEmpty(f1146e) == true) goto L8;
        return f1146e;
    }

    private static String m(String r10) {
        String r11 = n(r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = "";
        BufferedReader r13 = null;
        Process r14 = Runtime.getRuntime().exec("getprop " + r10);     // Catch: Throwable -> L13
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14.getInputStream()), 1024);     // Catch: Throwable -> L13
        r12 = r15.readLine();     // Catch: Throwable -> L10
        r14.destroy();     // Catch: Throwable -> L10
        x3.d.b(r15);
        return r12;
    L10:
        r13 = r15;
    L11:
        x3.d.b(r13);
        return r12;
    }

    private static String n(String r10) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (f1147f != null) goto L5;
        f1147f = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L7
    L5:
        return (String) f1147f.invoke(null, new Object[]{r10});
    }

    public static boolean o() {
        String r10 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (r11.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r11.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean p() {
        String r10 = Build.DISPLAY;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(f1142a) == false) goto L7;
        return true;
    }

    public static boolean q() {
        String r10 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        return r10.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean r() {
        return !TextUtils.isEmpty(m("ro.letv.release.version"));
    }

    public static boolean s() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean t() {
        String r10 = m("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(f1143b) == false) goto L7;
        return true;
    }

    public static boolean u() {
        String r10 = Build.BRAND;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L8:
        String r11 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.toLowerCase().startsWith("hua") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r10.toLowerCase().startsWith("hua") == true) goto L12;
    L19:
        return false;
    }

    public static boolean v() {
        Class.forName("miui.os.Build");     // Catch: Exception -> L4
        f1144c = true;     // Catch: Exception -> L4
        return true;
    L5:
        return f1144c;
    }
}
