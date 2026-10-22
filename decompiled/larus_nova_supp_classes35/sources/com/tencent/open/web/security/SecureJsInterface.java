package com.tencent.open.web.security;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SecureJsInterface extends com.tencent.open.b.b {
    public static boolean isPWDEdit;
    private String a;

    public boolean customCallback() {
        return true;
    }

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        JniInterface.clearAllPWD();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
        throw new RuntimeException(e);
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        String r0 = JniInterface.getPWDKeyToMD5(null);     // Catch: Exception -> L6
        SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + r0);
        return r0;
    L6:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
        throw new RuntimeException(e);
    }

    public SecureJsInterface() {
    }

    public void curPosFromJS(String r4) {
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + r4);
        int r5 = CastIntegerProtector.parseInt(r4);     // Catch: NumberFormatException -> L5
    L7:
        if (r5 < 0) goto L16;
        boolean r0 = a.b;
        if (r0 == true) goto L11;
        String r1 = a.a;
        this.a = r1;
        JniInterface.insetTextToArray(r5, r1, r1.length());
        SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.a);
        return;
    L11:
        if (Boolean.valueOf(JniInterface.BackSpaceChar(r0, r5)).booleanValue() == false) goto L19;
        a.b = false;
        return;
    L19:
        return;
    L16:
        throw new RuntimeException("position is illegal.");
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
        r5 = -1;
        goto L7
    }

    public void isPasswordEdit(String r4) {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + r4);
        int r5 = CastIntegerProtector.parseInt(r4);     // Catch: Exception -> L5
    L8:
        if (r5 == 0) goto L13;
        if (r5 == 1) goto L13;
        throw new RuntimeException("is pswd edit flag is illegal.");
    L13:
        if (r5 != 0) goto L15;
        isPWDEdit = false;
        return;
    L15:
        if (r5 != 1) goto L21;
        isPWDEdit = true;
        return;
    L21:
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
        r5 = -1;
        goto L8
    }
}
