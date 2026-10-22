package com.tencent.open.web.security;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class JniInterface {
    public static boolean isJniOk;

    public JniInterface() {
    }

    public static native boolean BackSpaceChar(boolean r0, int r1);

    public static native boolean clearAllPWD();

    public static native String d1(String r0);

    public static native String d2(String r0);

    public static native String getPWDKeyToMD5(String r0);

    public static native boolean insetTextToArray(int r0, String r1, int r2);

    public static void loadSo() {
        if (isJniOk == false) goto L17;
        return;
    L17:
        Context r5 = g.a();     // Catch: Throwable -> L13
        if (r5 != null) goto L8;
        SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        if (new PolarisFileWrapper(r5.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists() == false) goto L10;
        System.load(r5.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
        isJniOk = true;     // Catch: Throwable -> L13
        StringBuilder r0 = new StringBuilder("-->load lib success:");     // Catch: Throwable -> L13
        r0.append(AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
        SLog.i("openSDK_LOG.JniInterface", r0.toString());     // Catch: Throwable -> L13
        goto L16
    L10:
        SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
    }
}
