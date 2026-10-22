package com.bytedance.crypto.utils;

import android.os.Build;
import android.util.Log;
import com.bytedance.crypto.bridge.ILogBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LogUtils {
    private static final String DEFAULT_TAG = "unknown";
    private static final int LEGACY_MAX_TAG_LENGTH = 23;
    private static final String LEGACY_TAG_PREFIX = "csdk-";
    private static final boolean LOG_DEBUG = false;
    private static final String SDK_VERSION = "2.4.3";
    private static final String TAG_PREFIX = "cryptosdk-2.4.3-";
    private static ILogBridge mLogBridge;

    static {
        LOG_DEBUG = CryptoConfig.isDebug();
    }

    public LogUtils() {
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L8;
        String r3 = formatTag(r1);
        Log.i(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L9;
        r0.i(r3, r2);
        return;
    L9:
        return;
    }

    public static void d(String r0, String r1, Throwable r2) {
        if (LOG_DEBUG == false) goto L8;
        String r3 = formatTag(r0);
        Log.i(r3, r1);
        ILogBridge r4 = mLogBridge;
        if (r4 == null) goto L9;
        r4.i(r3, r1);
        return;
    L9:
        return;
    }

    public static void e(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.e(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.e(r3, r2);
        return;
    }

    public static void e(String r0, String r1, Throwable r2) {
        String r3 = formatTag(r0);
        Log.e(r3, r1, r2);
        ILogBridge r4 = mLogBridge;
        if (r4 == null) goto L6;
        r4.e(r3, r1);
        return;
    }

    private static String formatTag(String r1) {
        return formatTagForSdk(r1, Build.VERSION.SDK_INT);
    }

    public static String formatTagForSdk(String r1, int r2) {
        String r3 = normalizeTag(r1);
        if (r2 >= 26) goto L5;
        String r4 = LEGACY_TAG_PREFIX + r3;
        if (r4.length() > 23) goto L10;
        return r4;
    L10:
        return r4.substring(0, 23);
    L5:
        return TAG_PREFIX + r3;
    }

    public static void i(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.i(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.i(r3, r2);
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        String r3 = formatTag(r0);
        Log.i(r3, r1);
        ILogBridge r4 = mLogBridge;
        if (r4 == null) goto L6;
        r4.i(r3, r1);
        return;
    }

    public static void init(ILogBridge r2) {
        mLogBridge = (ILogBridge) ZeusTransformUtils.wrapperContextForParams(r2, ILogBridge.class, "com.obric.memorydata.plugin");
    }

    private static boolean isBlank(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.trim().isEmpty() == true) goto L7;
        return false;
    }

    private static String normalizeTag(String r1) {
        if (isBlank(r1) == false) goto L6;
        return "unknown";
    L6:
        return r1.trim();
    }

    public static void w(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.w(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.w(r3, r2);
        return;
    }
}
