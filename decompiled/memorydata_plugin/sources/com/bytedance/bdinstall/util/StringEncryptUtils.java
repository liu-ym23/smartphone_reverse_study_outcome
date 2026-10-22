package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class StringEncryptUtils {
    private static final String SHA_256 = "SHA-256";
    private static final String iv = "NIfb&95GUY86Gfgh";
    private static String key;

    public StringEncryptUtils() {
    }

    public static String base64DecodeToString(String r2) {
        return new String(Base64.decode(r2.getBytes(RpcUtils.CHARSET_UTF8), 2));
    L4:
        return "";
    }

    private static String bytes2Hex(byte[] r8) {
        if (r8 != null) goto L11;
        return null;
    L11:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r2 = r8.length;     // Catch: Throwable -> L10
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r1.append(String.format("%02x", new Object[]{Byte.valueOf(r8[r4])}));     // Catch: Throwable -> L10
        r4 = r4 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1.toString();
    L10:
        return null;
    }

    public static String decryptAES(byte[] r3, String r4) {
        byte[] r5 = Base64.decode(r3, 0);     // Catch: Exception -> L5
        Cipher r0 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L5
        r0.init(2, new SecretKeySpec(r4.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec(iv.getBytes()));     // Catch: Exception -> L5
        return new String(r0.doFinal(r5)).trim();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String encrypt(String r2, String r3) {
        byte[] r4 = r2.getBytes();
    L8:
        return null;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = "SHA-256";
    L6:
        MessageDigest r5 = MessageDigest.getInstance(r3);     // Catch: Throwable -> L8
        r5.update(r4);     // Catch: Throwable -> L8
        return bytes2Hex(r5.digest());
    }

    public static byte[] encryptAES(String r4, String r5) {
        Cipher r0 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L7
        int r1 = r0.getBlockSize();     // Catch: Exception -> L7
        byte[] r6 = r4.getBytes();     // Catch: Exception -> L7
        int r2 = r6.length;     // Catch: Exception -> L7
        if ((r2 % r1) == 0) goto L5;
        r2 = r2 + (r1 - (r2 % r1));     // Catch: Exception -> L7
    L5:
        byte[] r3 = new byte[r2];     // Catch: Exception -> L7
        System.arraycopy(r6, 0, r3, 0, r6.length);     // Catch: Exception -> L7
        r0.init(1, new SecretKeySpec(r5.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec(iv.getBytes()));     // Catch: Exception -> L7
        return Base64.encode(r0.doFinal(r3), 0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String encryptBySHA256(String r1) {
        return encrypt(r1, "SHA-256");
    }

    public static String getBytedanceString() {
        if (TextUtils.isEmpty(key) == false) goto L6;
        key = base64DecodeToString("Ynl0ZWRhbmNl");
    L6:
        return key;
    }

    private static Key toKey(byte[] r1) {
        DESKeySpec r0 = new DESKeySpec(r1);
        return SecretKeyFactory.getInstance("DES").generateSecret(r0);
    }
}
