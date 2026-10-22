package com.bytedance.crypto.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] a(int r5, SecretKey r6, byte[] r7, byte[] r8, byte[] r9) {
        SecretKey r10 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r6, SecretKey.class, "com.obric.memorydata.plugin");
        Log.i("c", "aesGcmXcrypt enter, mode:" + r5);
        Log.i("c", "aesGcmXcrypt enter, aad:".concat(new String(r7, StandardCharsets.UTF_8)));
        byte[] r0 = new byte[0];
        Cipher r2 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L10
        r2.init(r5, r10, new GCMParameterSpec(128, r8));     // Catch: Exception -> L10
        if (r7 != null) goto L6;
    L8:
        return r2.doFinal(r9);
    L6:
        if (r7.length <= 0) goto L8;
        r2.updateAAD(r7);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("c", "AES-GCM xcrypt failed, mode:" + r5 + " error:" + e.getMessage());
        return r0;
    }

    public static byte[] a(String r7) {
        if ((r7.length() % 2) == 0) goto L7;
        StringBuilder r8 = new StringBuilder("Invalid hex string length:").append(r7.length());
    L5:
        Log.e("c", r8.toString());
        return new byte[0];
    L7:
        int r0 = r7.length() / 2;
        byte[] r3 = new byte[r0];
        int r4 = 0;
    L8:
        if (r4 >= r0) goto L14;
        int r5 = r4 * 2;
        r3[r4] = (byte) Integer.parseInt(r7.substring(r5, r5 + 2), 16);     // Catch: Exception -> L12
        r4 = r4 + 1;
    L12:
        e = move-exception;
        r8 = new StringBuilder("Hex string to byte array failed, error:").append(e.getMessage());
        goto L5
    L14:
        return r3;
    }
}
