package com.bytedance.crypto.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";
    private static final HashMap<String, String> assistantAppMap = null;

    static {
        assistantAppMap = new AnonymousClass1();
    }

    public CommonUtils() {
    }

    public static boolean containsAssistantApp(String r1) {
        return assistantAppMap.containsKey(r1);
    }

    public static String getAssistantAppPkgName(String r1) {
        return assistantAppMap.get(r1);
    }

    public static List<byte[]> getContextSignature(Context r5) {
        if (r5 != null) goto L31;
        LogUtils.e(TAG, "Context is null");
        return null;
    L31:
        PackageManager r1 = r5.getPackageManager();     // Catch: Exception -> L28
        if (r1 != null) goto L10;
        LogUtils.e(TAG, "getPackageManager failed");     // Catch: Exception -> L28
        return null;
    L10:
        PackageInfo r6 = r1.getPackageInfo(r5.getPackageName(), 134217728);     // Catch: Exception -> L28
        if (r6 == null) goto L26;
        SigningInfo r7 = r6.signingInfo;     // Catch: Exception -> L28
        if (r7 == null) goto L26;
        Signature[] r8 = r7.getApkContentsSigners();     // Catch: Exception -> L28
        if (r8 != null) goto L18;
    L24:
        LogUtils.e(TAG, "getApkContentsSigners failed");     // Catch: Exception -> L28
        return null;
    L18:
        if (r8.length == 0) goto L24;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L28
        int r3 = r8.length;     // Catch: Exception -> L28
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L23;
        r2.add(r8[r4].toByteArray());     // Catch: Exception -> L28
        r4 = r4 + 1;     // Catch: Exception -> L28
        goto L21
    L23:
        return r2;
    L26:
        LogUtils.e(TAG, "getPackageInfo failed");     // Catch: Exception -> L28
        return null;
    L28:
        e = move-exception;
        LogUtils.d(TAG, "getContextSignature failed, exception: " + e.getMessage());
        return null;
    }
}
