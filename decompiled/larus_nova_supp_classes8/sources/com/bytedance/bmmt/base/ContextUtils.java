package com.bytedance.bmmt.base;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context applicationContext;

    public ContextUtils() {
    }

    public static String getAppPath() {
        return applicationContext.getExternalFilesDir("").toString();
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static String getAppLibPath(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L13;
        return "";
    L13:
        String r3 = ((BaseDexClassLoader) applicationContext.getClassLoader()).findLibrary(r2);     // Catch: Exception -> L10
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L10:
        e = move-exception;
        Logging.e("realx Utils", "getAppLibPath Exception : " + e.getMessage());
        e.getMessage();
        throw e;
    }

    public static void initialize(Context r1) {
        if (r1 == null) goto L6;
        applicationContext = r1;
        return;
    L6:
        throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
    }
}
