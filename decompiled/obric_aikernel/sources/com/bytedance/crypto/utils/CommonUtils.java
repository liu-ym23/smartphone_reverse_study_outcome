package com.bytedance.crypto.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";
    private static final HashMap<String, String> assistantAppMap = null;

    static {
        assistantAppMap = new AnonymousClass1();
    }

    public CommonUtils() {
    }

    public static boolean containsAssistantApp(String r10) {
        return assistantAppMap.containsKey(r10);
    }

    public static String getAssistantAppPkgName(String r10) {
        return assistantAppMap.get(r10);
    }

    public static List<byte[]> getContextSignature(Context r10) {
        if (r10 != null) goto L31;
        LogUtils.e(TAG, "Context is null");
        return null;
    L31:
        PackageManager r11 = r10.getPackageManager();     // Catch: Exception -> L28
        if (r11 != null) goto L10;
        LogUtils.e(TAG, "getPackageManager failed");     // Catch: Exception -> L28
        return null;
    L10:
        PackageInfo r12 = r11.getPackageInfo(r10.getPackageName(), 134217728);     // Catch: Exception -> L28
        if (r12 == null) goto L26;
        SigningInfo r13 = r12.signingInfo;     // Catch: Exception -> L28
        if (r13 == null) goto L26;
        Signature[] r14 = r13.getApkContentsSigners();     // Catch: Exception -> L28
        if (r14 != null) goto L18;
    L24:
        LogUtils.e(TAG, "getApkContentsSigners failed");     // Catch: Exception -> L28
        return null;
    L18:
        if (r14.length == 0) goto L24;
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L28
        int r16 = r14.length;     // Catch: Exception -> L28
        int r17 = 0;
    L21:
        if (r17 >= r16) goto L23;
        r15.add(r14[r17].toByteArray());     // Catch: Exception -> L28
        r17 = r17 + 1;     // Catch: Exception -> L28
        goto L21
    L23:
        return r15;
    L26:
        LogUtils.e(TAG, "getPackageInfo failed");     // Catch: Exception -> L28
        return null;
    L28:
        e = move-exception;
        LogUtils.d(TAG, "getContextSignature failed, exception: " + e.getMessage());
        return null;
    }
}
