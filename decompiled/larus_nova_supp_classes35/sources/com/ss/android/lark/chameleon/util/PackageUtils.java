package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public PackageUtils() {
    }

    public static String getAppVersionName(Context r4) {
        String r0 = BuildConfig.FLAVOR;
        if (r4 == null) goto L17;
        String r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionName;     // Catch: Exception -> L13
        if (r5 != null) goto L18;
    L12:
        return BuildConfig.FLAVOR;
    L18:
        if (r5.length() <= 0) goto L12;
        r0 = r5;
    L10:
        Exception e = e;
    L15:
        Log.e("VersionInfo", "Exception", e);
        return r5;
    L13:
        e = move-exception;
        e = e;
        r5 = BuildConfig.FLAVOR;
    L17:
        return r0;
    }
}
