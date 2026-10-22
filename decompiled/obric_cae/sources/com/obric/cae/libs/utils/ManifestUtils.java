package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r8, Class<?> r10) {
        ServiceInfo r11 = r8.getPackageManager().getServiceInfo(new ComponentName(r8, r10), 0);     // Catch: Throwable -> L13
        int r12 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: NoSuchFieldException -> L7 Throwable -> L13 Throwable -> L13
    L8:
        if ((r11.flags & r12) == 0) goto L18;
        return true;
    L18:
        return false;
    L7:
        r12 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        return false;
    }
}
