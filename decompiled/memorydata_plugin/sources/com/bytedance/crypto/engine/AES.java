package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class AES {
    public static final String TAG = "AES";

    public AES() {
    }

    public static byte[] gcmXcrypt(int r5, byte[] r6, byte[] r7, byte[] r8, byte[] r9) {
        String r0 = TAG;
        LogUtils.i(r0, "gcmXcrypt enter, mode: " + r5);
        StringBuilder r1 = new StringBuilder().append("gcmXcrypt enter, aadLen: ");
        if (r7 != null) goto L5;
        int r3 = 0;
    L6:
        LogUtils.i(r0, r1.append(r3).toString());
        byte[] r2 = new byte[0];
        SecretKeySpec r4 = new SecretKeySpec(r6, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L14
        Cipher r10 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L14
        r10.init(r5, r4, new GCMParameterSpec(128, r8));     // Catch: Exception -> L14
        if (r7 != null) goto L10;
    L12:
        r2 = r10.doFinal(r9);     // Catch: Exception -> L14
        LogUtils.i(r0, "gcmXcrypt success, mode: " + r5 + ", outputLen: " + r2.length);     // Catch: Exception -> L14
        return r2;
    L10:
        if (r7.length <= 0) goto L12;
        r10.updateAAD(r7);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        LogUtils.e(TAG, "AES-GCM xcrypt failed, mode:" + r5 + " error:" + e.getMessage());
        return r2;
    L5:
        r3 = r7.length;
        goto L6
    }
}
