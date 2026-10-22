package com.ss.bduploader.util;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class CustomVerify {
    public static final int CUSTOM_VERFIY_STATUS_IS_EXCEPTION = -99996;
    public static final int CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION = -99995;
    private static Method getVerifyStatusMethod = null;
    private static boolean hasInited = false;
    private static Method verifyMethod;
    private static Class<?> verifyResultClass;

    static {
        verifyMethod = ZeusTransformUtils.forName("com.ss.bduploader.util.X509Util", "com.obric.memorydata.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L5
        Class<?> r0 = ZeusTransformUtils.forName("com.ss.bduploader.util.AndroidCertVerifyResult", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        verifyResultClass = r0;     // Catch: Exception -> L5
        getVerifyStatusMethod = r0.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L5
        Log.e("custom_verify", "find default verify suc");     // Catch: Exception -> L5
    L7:
        hasInited = true;
        if (verifyMethod != null) goto L10;
        return;
    L10:
        if (verifyResultClass == null) goto L16;
        Log.e("custom_verify", "get verify method or verify result class suc");
        return;
    L16:
        return;
    L5:
        e = move-exception;
        Log.e("custom_verify", "found verify class or method exception:" + e.getMessage());
        Log.e("custom_verify", "find default verify fail");
        goto L7
    }

    public CustomVerify() {
    }

    public static int doVerify(byte[][] r5, String r6, String r7) {
        if (verifyMethod != null) goto L5;
    L14:
        Log.e("custom_verify", "verify method is null ecception");
        return CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION;
    L5:
        if (verifyResultClass == null) goto L14;
        if (getVerifyStatusMethod == null) goto L14;
        Log.e("custom_verify", "host: " + r7 + "  authType: " + r6);     // Catch: Throwable -> L11
        Object r8 = verifyMethod.invoke(null, new Object[]{r5, r6, r7});     // Catch: Throwable -> L11
        Log.e("custom_verify", "get status end");     // Catch: Throwable -> L11
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(getVerifyStatusMethod.invoke(r8, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L11
        Log.e("custom_verify", "verify result status: " + r9);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        th.printStackTrace();
        Log.e("custom_verify", "verify exception stacktrace:" + th.getMessage());
        return CUSTOM_VERFIY_STATUS_IS_EXCEPTION;
    }
}
