package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
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

    public static String base64DecodeToString(String r10) {
        return new String(Base64.decode(r10.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    private static String bytes2Hex(byte[] r10) {
        if (r10 != null) goto L11;
        return null;
    L11:
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L10
        int r12 = r10.length;     // Catch: Throwable -> L10
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r11.append(String.format("%02x", new Object[]{Byte.valueOf(r10[r13])}));     // Catch: Throwable -> L10
        r13 = r13 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r11.toString();
    L10:
        return null;
    }

    public static String decryptAES(byte[] r10, String r11) {
        byte[] r12 = Base64.decode(r10, 0);     // Catch: Exception -> L5
        Cipher r13 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L5
        r13.init(2, new SecretKeySpec(r11.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec(iv.getBytes()));     // Catch: Exception -> L5
        return new String(r13.doFinal(r12)).trim();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String encrypt(String r10, String r11) {
        byte[] r12 = r10.getBytes();
    L8:
        return null;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        r11 = "SHA-256";
    L6:
        MessageDigest r13 = MessageDigest.getInstance(r11);     // Catch: Throwable -> L8
        r13.update(r12);     // Catch: Throwable -> L8
        return bytes2Hex(r13.digest());
    }

    public static byte[] encryptAES(String r10, String r11) {
        Cipher r12 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L7
        int r13 = r12.getBlockSize();     // Catch: Exception -> L7
        byte[] r14 = r10.getBytes();     // Catch: Exception -> L7
        int r15 = r14.length;     // Catch: Exception -> L7
        if ((r15 % r13) == 0) goto L5;
        r15 = r15 + (r13 - (r15 % r13));     // Catch: Exception -> L7
    L5:
        byte[] r16 = new byte[r15];     // Catch: Exception -> L7
        System.arraycopy(r14, 0, r16, 0, r14.length);     // Catch: Exception -> L7
        r12.init(1, new SecretKeySpec(r11.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec(iv.getBytes()));     // Catch: Exception -> L7
        return Base64.encode(r12.doFinal(r16), 0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String encryptBySHA256(String r10) {
        return encrypt(r10, "SHA-256");
    }

    public static String getBytedanceString() {
        if (TextUtils.isEmpty(key) == false) goto L6;
        key = base64DecodeToString("Ynl0ZWRhbmNl");
    L6:
        return key;
    }

    private static Key toKey(byte[] r10) {
        DESKeySpec r11 = new DESKeySpec(r10);
        return SecretKeyFactory.getInstance("DES").generateSecret(r11);
    }
}
