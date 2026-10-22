package com.ss.android.lark.officesdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.lark.officesdk.utils.di.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AppInfoUtils {
    public static PackageInfo a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VERSION_TYPE {
        public static final String VERSION_ALPHA = "alpha";
        public static final String VERSION_BETA = "beta";
        public static final String VERSION_RELEASE = "release";
    }

    public static String a(Context r2) {
        if (a == null) goto L13;
    L8:
        PackageInfo r3 = a;
        if (r3 != null) goto L12;
        return "";
    L12:
        return r3.versionName;
    L13:
        a = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        j.f("InfoProviderUtils", th.toString());
        goto L8
    }
}
