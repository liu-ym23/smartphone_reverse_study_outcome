package com.obric.cae.libs.utils;

import android.annotation.SuppressLint;
import android.util.Base64;
import defpackage.b;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    @SuppressLint({"GetInstance"})
    public static String decrypt(String r8, String r10, String r11, boolean r12) {
        if (r10 != null) goto L5;
    L25:
        return "";
    L5:
        if (r10.isEmpty() == true) goto L25;
        Matcher r13 = Pattern.compile(Pattern.quote(b.d("=", r8, " EN=")) + "([A-Za-z0-9+/=]+)").matcher(r10);
        if (r13.find() == true) goto L26;
        return "";
    L26:
        byte[] r14 = Base64.decode(r13.group(1), 2);     // Catch: Exception -> L22
        if (r12 == true) goto L15;
        MessageDigest r15 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        byte[] r16 = r11.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r15.update(r16, 0, r16.length);     // Catch: Exception -> L22
        SecretKeySpec r17 = new SecretKeySpec(r15.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
    L20:
        Cipher r18 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r18.init(2, r17);     // Catch: Exception -> L22
        return new String(r18.doFinal(r14), StandardCharsets.UTF_8);
    L15:
        if (r14.length < 16) goto L18;
        byte[] r19 = new byte[16];     // Catch: Exception -> L22
        System.arraycopy(r14, 0, r19, 0, 16);     // Catch: Exception -> L22
        int r20 = r14.length - 16;     // Catch: Exception -> L22
        byte[] r21 = new byte[r20];     // Catch: Exception -> L22
        System.arraycopy(r14, 16, r21, 0, r20);     // Catch: Exception -> L22
        MessageDigest r22 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        r22.update(r19);     // Catch: Exception -> L22
        byte[] r110 = r11.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r22.update(r110, 0, r110.length);     // Catch: Exception -> L22
        r17 = new SecretKeySpec(r22.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r14 = r21;
        goto L20
    L18:
        throw new Exception("Invalid encrypted data: too short to contain salt.");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        LogUtil.e(b.c("EncryptUtil-", r8), "Error decrypting data: ".concat(r10), e);
        return r10;
    }

    @SuppressLint({"GetInstance"})
    public static String encrypt(String r8, String r10, String r11, boolean r12) {
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.isEmpty() == true) goto L26;
        if (r12 == true) goto L24;
        byte[] r13 = null;
    L12:
        MessageDigest r14 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L9
        if (r13 == null) goto L15;
        r14.update(r13);     // Catch: Exception -> L9
    L15:
        byte[] r15 = r11.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L9
        r14.update(r15, 0, r15.length);     // Catch: Exception -> L9
        SecretKeySpec r16 = new SecretKeySpec(r14.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L9
        Cipher r17 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L9
        r17.init(1, r16);     // Catch: Exception -> L9
        byte[] r18 = r17.doFinal(r10.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L9
        if (r12 == false) goto L18;
        byte[] r19 = new byte[r13.length + r18.length];     // Catch: Exception -> L9
        System.arraycopy(r13, 0, r19, 0, r13.length);     // Catch: Exception -> L9
        System.arraycopy(r18, 0, r19, r13.length, r18.length);     // Catch: Exception -> L9
        r18 = r19;
    L18:
        return "=" + r8 + " EN=" + Base64.encodeToString(r18, 2);
    L9:
        e = move-exception;
        LogUtil.e(b.c("EncryptUtil-", r8), "Error encrypting data: ".concat(r10), e);
        return r10;
    L24:
        r13 = new byte[16];     // Catch: Exception -> L9
        new SecureRandom().nextBytes(r13);     // Catch: Exception -> L9
        goto L12
    L26:
        return "";
    }
}
