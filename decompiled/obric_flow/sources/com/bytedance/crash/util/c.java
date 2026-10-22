package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import com.lynx.tasm.p;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4174a;

    static {
        Pattern.compile("^0-([\\d]+)$");
    }

    public static boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        r5 = p.c("ro.build.version.emui");
    L5:
        String r10 = r5.toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(r5) == true) goto L25;
        if (r10.startsWith("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.startsWith("magicui") == true) goto L11;
    L25:
        String r11 = Build.BRAND;     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r11) == false) goto L17;
    L18:
        String r12 = Build.MANUFACTURER;     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r12) == true) goto L23;
        if (r12.toLowerCase(Locale.getDefault()).startsWith("hua") == false) goto L23;
    L22:
        return true;
    L17:
        if (r11.toLowerCase(Locale.getDefault()).startsWith("hua") == true) goto L22;
    L23:
        return false;
    }

    public static boolean b() {
        if (f4174a == true) goto L9;
        Class.forName("miui.os.Build");     // Catch: Exception -> L7
        com.bytedance.crash.upload.b.f4098j = true;     // Catch: Exception -> L7
        f4174a = true;     // Catch: Exception -> L7
        return true;
    L7:
        f4174a = true;
    L9:
        return com.bytedance.crash.upload.b.f4098j;
    }
}
