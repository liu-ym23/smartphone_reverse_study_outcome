package com.larksuite.framework.utils;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DevEnvUtil {
    private DevEnvUtil() {
    }

    public static boolean isDebugMode(Context r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isDevelopPackage(Context r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.getPackageName().endsWith(".debug");
    }
}
