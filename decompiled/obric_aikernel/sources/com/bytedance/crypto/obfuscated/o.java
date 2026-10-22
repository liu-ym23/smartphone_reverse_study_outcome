package com.bytedance.crypto.obfuscated;

import android.util.Log;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static String a(byte[] r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.append(String.format("%02x", new Object[]{Byte.valueOf(r10[r13])}));
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static byte[] a(int r10, SecretKey r11, byte[] r12, byte[] r13, byte[] r14) {
        Log.i("c", "aesGcmXcrypt enter, mode:" + r10);
        Log.i("c", "aesGcmXcrypt enter, aad:".concat(new String(r12, StandardCharsets.UTF_8)));
        byte[] r15 = new byte[0];
        Cipher r16 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L10
        r16.init(r10, r11, new GCMParameterSpec(128, r13));     // Catch: Exception -> L10
        if (r12 != null) goto L6;
    L8:
        return r16.doFinal(r14);
    L6:
        if (r12.length <= 0) goto L8;
        r16.updateAAD(r12);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("c", "AES-GCM xcrypt failed, mode:" + r10 + " error:" + e.getMessage());
        return r15;
    }

    public static byte[] a(String r10) {
        if ((r10.length() % 2) == 0) goto L7;
        StringBuilder r11 = new StringBuilder("Invalid hex string length:");
        r11.append(r10.length());
    L5:
        Log.e("c", r11.toString());
        return new byte[0];
    L7:
        int r12 = r10.length() / 2;
        byte[] r13 = new byte[r12];
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L14;
        int r15 = r14 * 2;
        r13[r14] = (byte) Integer.parseInt(r10.substring(r15, r15 + 2), 16);     // Catch: Exception -> L12
        r14 = r14 + 1;
    L12:
        e = move-exception;
        r11 = new StringBuilder("Hex string to byte array failed, error:");
        r11.append(e.getMessage());
        goto L5
    L14:
        return r13;
    }
}
