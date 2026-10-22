package com.larksuite.framework.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ApkUtil {
    private static final String FORMAT_VERSION_WITH_ALCHEMY = "%s-omega%s";
    private static final String META_DATA_KEY_ALCHEMY_VERSION_CODE = "ALCHEMY_VERSION_CODE";
    private static final String META_DATA_KEY_UPDATE_VERSION_CODE = "UPDATE_VERSION_CODE";
    private static final String TAG = "ApkUtil";
    private static int sUpdateVersionCode = -1;
    private static int sVersionCode = -1;
    private static String sVersionName;

    public ApkUtil() {
    }

    public static String getAppAlchemyVersionName(Context r4) {
        String r0 = getAppVersionName(r4);
        int r5 = r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128).metaData.getInt(META_DATA_KEY_ALCHEMY_VERSION_CODE, -1);     // Catch: Exception -> L7
        if (r5 < 0) goto L12;
        return String.format(FORMAT_VERSION_WITH_ALCHEMY, new Object[]{r0, Integer.valueOf(r5)});
    L12:
        return r0;
    L7:
        e = move-exception;
        Log.w(TAG, "get alchemy version error", e);
        return r0;
    }

    public static int getAppVersionCode(Context r1) {
        int r2 = sVersionCode;
        if (r2 == (-1)) goto L11;
        return r2;
    L11:
        sVersionCode = 8020000;     // Catch: Exception -> L8
        return 8020000;
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static String getAppVersionName(Context r4) {
        String r0 = "";
        String r1 = sVersionName;
        if (r1 == null) goto L18;
        return r1;
    L18:
    L15:
        e = e;
    L16:
        Log.w(TAG, "get version name exception", e);
        return r0;
    L6:
        if (TextUtils.isEmpty("8.2.0-alpha1") == true) goto L9;
        sVersionName = "8.2.0-alpha1";     // Catch: Exception -> L15
        return "8.2.0-alpha1";
    L9:
        String r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 128).versionName;     // Catch: Exception -> L15
        sVersionName = r5;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r5) == false) goto L21;
        return "";
    L21:
        return r5;
    L13:
        e = move-exception;
        r0 = r5;
        e = e;
        goto L16
    }

    public static int getUpdateVersionCode(Context r5) {
        int r1 = sUpdateVersionCode;
        if (r1 == (-1)) goto L13;
        return r1;
    L13:
        int r2 = getAppVersionCode(r5);     // Catch: Exception -> L10
        int r3 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData.getInt(META_DATA_KEY_UPDATE_VERSION_CODE, r2);     // Catch: Exception -> L10
        if (r3 != r2) goto L8;
        Log.e(TAG, "getUpdateVersionCode failed, will use version code as fallback value.");     // Catch: Exception -> L10
    L8:
        sUpdateVersionCode = r3;     // Catch: Exception -> L10
        return r3;
    L10:
        e = move-exception;
        Log.e(TAG, e);
        return getAppVersionCode(r5);
    }

    public static Drawable getApkIcon(String r1, Context r2) {
        PackageManager r3 = r2.getPackageManager();
        PackageInfo r0 = r3.getPackageArchiveInfo(r1, 0);
        if (r0 == null) goto L9;
        ApplicationInfo r4 = r0.applicationInfo;
        if (r4 == null) goto L11;
        r4.sourceDir = r1;
        r4.publicSourceDir = r1;
        return r4.loadIcon(r3);
    L11:
        return null;
    L9:
        return null;
    }

    public static String getApkPackageName(Context r1, String r2) {
        PackageInfo r3 = r1.getPackageManager().getPackageArchiveInfo(r2, 1);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.applicationInfo.packageName;
    }
}
