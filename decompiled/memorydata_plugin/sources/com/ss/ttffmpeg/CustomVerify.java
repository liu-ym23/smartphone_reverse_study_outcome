package com.ss.ttffmpeg;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class CustomVerify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15774a = "custom_verify_ffmpeg";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f15775b = null;
    private static boolean c = false;
    private static Class<?> d;
    private static Method e;

    static {
        f15775b = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.X509Util", "com.obric.memorydata.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L5
        Class<?> r0 = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.AndroidCertVerifyResult", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        d = r0;     // Catch: Exception -> L5
        e = r0.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L5
    L7:
        c = true;
        if (f15775b != null) goto L10;
        return;
    L10:
        if (d == null) goto L16;
        Log.e(f15774a, "get verify method or verify result class suc");
        return;
    L16:
        return;
    L5:
        e = move-exception;
        Log.e(f15774a, "found verify class or method exception:" + e.getMessage());
        goto L7
    }

    public CustomVerify() {
    }

    private static final native void _init();

    public static int doVerify(byte[][] r4, String r5, String r6) {
        if (f15775b != null) goto L5;
    L14:
        Log.e(f15774a, "verify method is null ecception");
        return com.ss.bduploader.util.CustomVerify.CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION;
    L5:
        if (d == null) goto L14;
        if (e == null) goto L14;
        Log.e(f15774a, "host: " + r6 + "  authType: " + r5);     // Catch: Throwable -> L11
        Object r7 = f15775b.invoke(null, new Object[]{r4, r5, r6});     // Catch: Throwable -> L11
        Log.e(f15774a, "get status end");     // Catch: Throwable -> L11
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(e.invoke(r7, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L11
        Log.e(f15774a, "verify result status: " + r8);     // Catch: Throwable -> L11
        return r8;
    L11:
        th = move-exception;
        th.printStackTrace();
        Log.e(f15774a, "verify exception stacktrace:" + th.getMessage());
        return com.ss.bduploader.util.CustomVerify.CUSTOM_VERFIY_STATUS_IS_EXCEPTION;
    }
}
