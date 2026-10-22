package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class AES {
    public static final String TAG = "AES";

    public AES() {
    }

    public static byte[] gcmXcrypt(int r10, byte[] r11, byte[] r12, byte[] r13, byte[] r14) {
        String r15 = TAG;
        LogUtils.i(r15, "gcmXcrypt enter, mode: " + r10);
        StringBuilder r16 = new StringBuilder();
        r16.append("gcmXcrypt enter, aadLen: ");
        if (r12 != null) goto L5;
        int r17 = 0;
    L6:
        r16.append(r17);
        LogUtils.i(r15, r16.toString());
        byte[] r18 = new byte[0];
        SecretKeySpec r19 = new SecretKeySpec(r11, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L14
        Cipher r20 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L14
        r20.init(r10, r19, new GCMParameterSpec(128, r13));     // Catch: Exception -> L14
        if (r12 != null) goto L10;
    L12:
        r18 = r20.doFinal(r14);     // Catch: Exception -> L14
        LogUtils.i(r15, "gcmXcrypt success, mode: " + r10 + ", outputLen: " + r18.length);     // Catch: Exception -> L14
        return r18;
    L10:
        if (r12.length <= 0) goto L12;
        r20.updateAAD(r12);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        LogUtils.e(TAG, "AES-GCM xcrypt failed, mode:" + r10 + " error:" + e.getMessage());
        return r18;
    L5:
        r17 = r12.length;
        goto L6
    }
}
