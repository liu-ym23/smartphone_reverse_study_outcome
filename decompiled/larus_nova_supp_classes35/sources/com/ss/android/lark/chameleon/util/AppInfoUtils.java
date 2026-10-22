package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AppInfoUtils {
    private static final String TAG = "InfoProviderUtils";
    private static final String UA_MOBILE = "Mobile";
    private static final String UA_NETWORK = "okhttp";
    private static final String UA_NETWORK_VERSION = "3.2";
    private static final String UA_PLATFORM = "platform";
    private static final String UA_PLATFORM_ANDROID = "android";
    private static PackageInfo sInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VERSION_TYPE {
        public static final String VERSION_ALPHA = "alpha";
        public static final String VERSION_BETA = "beta";
        public static final String VERSION_RELEASE = "release";
    }

    public AppInfoUtils() {
    }

    public static String getUaAppName(Context r0) {
        return "Lark";
    }

    private static PackageInfo getPackageInfo(Context r2) {
        if (sInfo != null) goto L9;
        sInfo = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Log.w(TAG, th.toString());
    L9:
        return sInfo;
    }

    public static String getPackageName(Context r0) {
        PackageInfo r1 = getPackageInfo(r0);
        if (r1 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r1.packageName;
    }

    public static int getVersionCode(Context r0) {
        PackageInfo r1 = getPackageInfo(r0);
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.versionCode;
    }

    public static String getVersionName(Context r0) {
        PackageInfo r1 = getPackageInfo(r0);
        if (r1 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r1.versionName;
    }

    public static boolean isApkInDebug(Context r1) {
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }
}
