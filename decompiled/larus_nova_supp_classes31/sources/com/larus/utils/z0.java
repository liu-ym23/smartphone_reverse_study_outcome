package com.larus.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z0 {
    public static final long c(boolean r2) {
        if (r2 == false) goto L4;
        return 1;
    L4:
        return 0;
    }

    public static final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Application r0 = AppHost.a.getApplication();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L26;
        PackageInfo r4 = r0.getPackageManager().getPackageInfo(r3, 0);     // Catch: Exception -> L20
        if (r4 == null) goto L24;
        ApplicationInfo r5 = r4.applicationInfo;     // Catch: Exception -> L20
        if (r5 == null) goto L12;
        Boolean r6 = Boolean.valueOf(r5.enabled);     // Catch: Exception -> L20
    L13:
        if (r6 == null) goto L16;
        boolean r7 = r6.booleanValue();     // Catch: Exception -> L20
    L17:
        if (r7 == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        r7 = false;
        goto L17
    L12:
        r6 = null;
        goto L13
    L24:
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public static Bitmap.Config b(Bitmap.Config r2) {
        Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(r0, "defaultConfig");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return r0;
    }
}
