package com.bytedance.android.live.core.utils;

import android.os.Build;
import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m1 {
    public static boolean a() {
        String r1 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r2) == true) goto L17;
        if (r2.toLowerCase().startsWith("oneplus") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r1.toLowerCase().contains("oneplus") == true) goto L12;
    L19:
        return false;
    }

    public static boolean b() {
        String r1 = Build.BRAND;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r2) == true) goto L17;
        if (r2.toLowerCase().startsWith("oppo") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r1.toLowerCase().startsWith("oppo") == true) goto L12;
    L19:
        return false;
    }

    public static boolean c() {
        String r1 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r2) == true) goto L17;
        if (r2.toLowerCase().startsWith("realme") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r1.toLowerCase().contains("realme") == true) goto L12;
    L19:
        return false;
    }
}
