package com.gyf.barlibrary;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static String a(String r8, String r9) {
        Class r1 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{r8, r9}), String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return r9;
    }

    public static boolean a() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean b() {
        String r0 = c();
        if (r0.isEmpty() == false) goto L11;
        return false;
    L11:
        if (Integer.valueOf(r0.substring(1)).intValue() >= 6) goto L9;
        return false;
    L9:
        return true;
    L15:
        return false;
    }

    public static String c() {
        if (a() == true) goto L5;
        return "";
    L5:
        return a("ro.miui.ui.version.name", "");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static String e() {
        if (d() == true) goto L5;
        return "";
    L5:
        return a("ro.build.version.emui", "");
    }

    public static boolean f() {
        String r0 = e();
        if ("EmotionUI 3".equals(r0) == false) goto L5;
        return true;
    L5:
        if (r0.contains("EmotionUI_3.1") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean g() {
        if (e().contains("EmotionUI_3.0") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean h() {
        if (g() == false) goto L5;
    L8:
        return true;
    L5:
        if (f() == true) goto L8;
        return false;
    }

    public static boolean i() {
        return l().toLowerCase().contains("flyme");
    }

    public static boolean j() {
        String r0 = k();
        if (r0.isEmpty() == true) goto L17;
        if (r0.toLowerCase().contains("os") == false) goto L8;
        String r1 = r0.substring(9, 10);     // Catch: NumberFormatException -> L14
    L7:
        if (Integer.valueOf(r1).intValue() < 4) goto L18;
        return true;
    L18:
        return false;
    L8:
        r1 = r0.substring(6, 7);     // Catch: NumberFormatException -> L14
    L19:
        return false;
    L17:
        return false;
    }

    public static String k() {
        if (i() == true) goto L5;
        return "";
    L5:
        return a("ro.build.display.id", "");
    }

    private static String l() {
        return a("ro.build.display.id", "");
    }
}
