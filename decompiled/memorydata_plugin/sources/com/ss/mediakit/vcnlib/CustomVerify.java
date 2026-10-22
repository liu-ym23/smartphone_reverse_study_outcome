package com.ss.mediakit.vcnlib;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class CustomVerify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f15764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15765b = false;
    private static Class<?> c;
    private static Method d;

    static {
        f15764a = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.X509Util", "com.obric.memorydata.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L8
        Class<?> r10 = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.AndroidCertVerifyResult", "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        c = r10;     // Catch: Exception -> L8
        d = r10.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L8
        Log.e("custom_verify", "find ttnet verify suc");     // Catch: Exception -> L6
        boolean r11 = true;
    L11:
        if (r11 == false) goto L26;
    L16:
        f15765b = true;
        if (f15764a != null) goto L19;
        return;
    L19:
        if (c == null) goto L29;
        Log.e("custom_verify", "get verify method or verify result class suc");
        return;
    L29:
        return;
    L26:
        f15764a = ZeusTransformUtils.forName("com.ss.mediakit.vcnlib.X509Util", "com.obric.memorydata.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L14
        Class<?> r1 = ZeusTransformUtils.forName("com.ss.mediakit.vcnlib.AndroidCertVerifyResult", "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        c = r1;     // Catch: Exception -> L14
        d = r1.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L14
        Log.e("custom_verify", "find default verify suc");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e("custom_verify", "found verify class or method exception:" + e.getMessage());
        Log.e("custom_verify", "find default verify fail");
    L6:
        e = e;
        r11 = true;
    L10:
        Log.e("custom_verify", "found verify class or method exception:" + e.getMessage());
        Log.e("custom_verify", "find ttnet verify fail");
    L8:
        e = e;
        r11 = false;
        goto L10
    }

    public CustomVerify() {
    }

    private static final native void _init();

    public static void a() {
        Log.e("custom_verify", "start init native");
        _init();
        Log.e("custom_verify", "end init native");
    }
}
