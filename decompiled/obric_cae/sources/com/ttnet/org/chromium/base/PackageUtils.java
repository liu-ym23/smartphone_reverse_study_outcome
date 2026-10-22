package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
public class PackageUtils {
    private PackageUtils() {
    }

    public static int getPackageVersion(Context r8, String r10) {
        PackageInfo r11 = r8.getPackageManager().getPackageInfo(r10, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r11 == null) goto L11;
        return r11.versionCode;
    L11:
        return -1;
    L12:
        return -1;
    }

    public static boolean isPackageInstalled(Context r8, String r10) {
        r8.getPackageManager().getPackageInfo(r10, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }
}
