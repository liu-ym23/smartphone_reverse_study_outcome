package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r3, Class<?> r4) {
        ServiceInfo r5 = r3.getPackageManager().getServiceInfo(new ComponentName(r3, r4), 0);     // Catch: Throwable -> L13
        int r6 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: NoSuchFieldException -> L7 Throwable -> L13 Throwable -> L13
    L8:
        if ((r5.flags & r6) == 0) goto L18;
        return true;
    L18:
        return false;
    L7:
        r6 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        return false;
    }
}
