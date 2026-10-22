package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class InstallPmsUtils {
    public InstallPmsUtils() {
    }

    private static boolean checkPermission(Context r10, String r11) {
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return true;
    L12:
        if (r10.checkSelfPermission(r11) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean checkReadPhoneStatePermission(Context r10) {
        return checkPermission(r10, "android.permission.READ_PHONE_STATE");
    }
}
