package com.tencent.open.utils;

import android.util.Base64;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class e {
    private static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r7) {
        if (r7 != null) goto L4;
        return BuildConfig.FLAVOR;
    L4:
        if (r7.length == 0) goto L14;
        char[] r0 = new char[r7.length * 2];
        int r1 = 0;
    L7:
        if (r1 >= r7.length) goto L10;
        byte r2 = r7[r1];
        int r3 = r1 * 2;
        char[] r5 = a;
        r0[r3 + 1] = r5[r2 & 15];
        r0[r3] = r5[((byte) (r2 >>> 4)) & 15];
        r1 = r1 + 1;
        goto L7
    L10:
        return new String(r0);
    L14:
        return BuildConfig.FLAVOR;
    }

    public static byte[] a(String r2) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L4
        r0.update(r2.getBytes());     // Catch: Exception -> L4
        return r0.digest();
    L4:
        e = move-exception;
        SLog.e("DESUtils", "encryptSha", e);
        return null;
    }

    public static String a(String r2, String r3, byte[] r4) {
        IvParameterSpec r0 = new IvParameterSpec(r4);     // Catch: Exception -> L4
        SecretKeySpec r5 = new SecretKeySpec(r3.getBytes(), "AES");     // Catch: Exception -> L4
        Cipher r6 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L4
        r6.init(1, r5, r0);     // Catch: Exception -> L4
        return Base64.encodeToString(r6.doFinal(r2.getBytes()), 0);
    L4:
        e = move-exception;
        SLog.e("DESUtils", "encryptAES", e);
        return null;
    }
}
