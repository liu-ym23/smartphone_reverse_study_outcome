package com.ss.android.deviceregister.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f15211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f15212b = null;
    private static final CharSequence c = null;
    private static final f<Boolean> d = null;

    static {
        f15211a = "sony";
        f15212b = "amigo";
        c = "funtouch";
        d = new AnonymousClass1();
    }

    public static String a() {
    L32:
        th = move-exception;
        th.printStackTrace();
    L35:
        return Build.DISPLAY;
    L3:
        if (com.ss.android.common.b.d.b() == false) goto L7;
        return k();
    L7:
        if (com.ss.android.common.b.d.c() == false) goto L11;
        return m();
    L11:
        if (n() == true) goto L13;
        String r0 = l();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return r0;
    L18:
        if (y() == false) goto L22;
        return d();
    L22:
        if (e() == false) goto L26;
        return f();
    L26:
        if (c() == true) goto L28;
        String r1 = g();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r1) == true) goto L35;
        return r1;
    L28:
        return b();
    L13:
        return o();
    }

    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return false;
    }

    public static boolean a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = com.ss.android.common.b.d.a();
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r3.toLowerCase().contains("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r3.toLowerCase().contains("magicui") == true) goto L11;
    L13:
        if (i() == false) goto L15;
        return true;
    L15:
        if (j() == true) goto L20;
        return false;
    L20:
        return true;
    }

    public static String b() {
        return b("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    private static String b(String r7) {
        String r1 = "";
        Process r3 = Runtime.getRuntime().exec("getprop " + r7);     // Catch: Throwable -> L12
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r3.getInputStream()), 1024);     // Catch: Throwable -> L12
        r1 = r4.readLine();     // Catch: Throwable -> L10
        r3.destroy();     // Catch: Throwable -> L10
        r4.close();     // Catch: IOException -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        com.ss.android.common.b.b.d("Exception while closing InputStream", e);
    L10:
        Throwable th = th;
    L32:
        com.ss.android.common.b.b.d("Unable to read sysprop " + r7, th);     // Catch: Throwable -> L21
        if (r4 != null) goto L34;
    L20:
        return r1;
    L34:
        r4.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        com.ss.android.common.b.b.d("Exception while closing InputStream", e);
    L21:
        th = move-exception;
        if (r4 != null) goto L36;
    L27:
        throw th;
    L36:
        r4.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        com.ss.android.common.b.b.d("Exception while closing InputStream", e);
    L12:
        th = move-exception;
        r4 = null;
        th = th;
        goto L32
    }

    public static boolean b(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase();
        if (r1.contains(com.tom_roush.pdfbox.pdmodel.a.d.d.aj) == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean c(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static String d() {
        return SystemPropertiesWithCache.get("ro.vivo.os.build.display.id") + "_" + SystemPropertiesWithCache.get("ro.vivo.product.version");
    }

    public static boolean e() {
        if (h.a(Build.DISPLAY) == false) goto L5;
    L7:
        return false;
    L5:
        if (Build.DISPLAY.toLowerCase().contains(f15212b) == false) goto L7;
        return true;
    }

    public static String f() {
        return Build.DISPLAY + "_" + b("ro.gn.sv.version");
    }

    public static String g() {
        if (h() == true) goto L5;
        return "";
    L5:
        return "eui_" + b("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean h() {
        return !h.a(b("ro.letv.release.version"));
    }

    public static boolean i() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L9;
    L11:
        return false;
    L9:
        if (Build.MANUFACTURER.toLowerCase().startsWith("huawei") == false) goto L11;
        goto L10
    }

    public static boolean j() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("honor") == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L9;
    L11:
        return false;
    L9:
        if (Build.MANUFACTURER.toLowerCase().startsWith("honor") == false) goto L11;
        goto L10
    }

    public static String k() {
        if (com.ss.android.common.b.d.b() == true) goto L5;
        return "";
    L5:
        return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String l() {
        String r0 = com.ss.android.common.b.d.a();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("emotionui") == true) goto L9;
        if (r0.toLowerCase().contains("magicui") == true) goto L9;
        return "";
    L9:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String m() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static boolean n() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase().contains("oppo");
    }

    public static String o() {
        if (n() == true) goto L5;
        return "";
    L5:
        return "coloros_" + b("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static boolean p() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean q() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean r() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == false) goto L5;
        return true;
    L5:
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean s() {
        String r0 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        String r1 = b("ro.build.version.incremental");
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.contains("VIBEUI_V2") == false) goto L11;
        return true;
    L5:
        return r0.contains("VIBEUI_V2");
    }

    public static boolean t() {
        return z().toUpperCase().contains("NUBIA");
    }

    public static boolean u() {
        return z().toUpperCase().contains("ASUS");
    }

    public static boolean v() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean x() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    private static boolean y() {
        return !TextUtils.isEmpty((String) ZeusTransformUtils.preCheckCast(SystemPropertiesWithCache.get("ro.vivo.os.build.display.id"), String.class, "com.obric.memorydata.plugin"));
    L5:
        return false;
    }

    private static String z() {
        if (Build.MANUFACTURER != null) goto L6;
        return "";
    L6:
        return Build.MANUFACTURER.trim();
    }
}
