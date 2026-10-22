package com.obric.cae.libs.utils;

import android.util.Base64;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    public static String decrypt(String r8, String r9, String r10, boolean r11) {
        if (r9 != null) goto L5;
    L25:
        return "";
    L5:
        if (r9.isEmpty() == true) goto L25;
        Matcher r1 = PatternProtector.compile(Pattern.quote("=" + r8 + " EN=") + "([A-Za-z0-9+/=]+)").matcher(r9);
        if (r1.find() == true) goto L26;
        return "";
    L26:
        byte[] r0 = Base64.decode(r1.group(1), 2);     // Catch: Exception -> L22
        if (r11 == true) goto L15;
        MessageDigest r12 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        byte[] r13 = r10.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r12.update(r13, 0, r13.length);     // Catch: Exception -> L22
        SecretKeySpec r14 = new SecretKeySpec(r12.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
    L20:
        Cipher r15 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r15.init(2, r14);     // Catch: Exception -> L22
        return new String(r15.doFinal(r0), StandardCharsets.UTF_8);
    L15:
        if (r0.length < 16) goto L18;
        byte[] r16 = new byte[16];     // Catch: Exception -> L22
        System.arraycopy(r0, 0, r16, 0, 16);     // Catch: Exception -> L22
        int r6 = r0.length - 16;     // Catch: Exception -> L22
        byte[] r7 = new byte[r6];     // Catch: Exception -> L22
        System.arraycopy(r0, 16, r7, 0, r6);     // Catch: Exception -> L22
        MessageDigest r2 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        r2.update(r16);     // Catch: Exception -> L22
        byte[] r17 = r10.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r2.update(r17, 0, r17.length);     // Catch: Exception -> L22
        r14 = new SecretKeySpec(r2.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r0 = r7;
        goto L20
    L18:
        throw new Exception("Invalid encrypted data: too short to contain salt.");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        LogUtil.e("EncryptUtil-" + r8, "Error decrypting data: ".concat(r9), e);
        return r9;
    }

    public static String encrypt(String r6, String r7, String r8, boolean r9) {
        if (r7 != null) goto L5;
        return "";
    L5:
        if (r7.isEmpty() == true) goto L25;
        if (r9 == true) goto L23;
        byte[] r3 = null;
    L10:
        MessageDigest r2 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L18
        if (r3 == null) goto L13;
        r2.update(r3);     // Catch: Exception -> L18
    L13:
        byte[] r10 = r8.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L18
        r2.update(r10, 0, r10.length);     // Catch: Exception -> L18
        SecretKeySpec r4 = new SecretKeySpec(r2.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L18
        Cipher r11 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L18
        r11.init(1, r4);     // Catch: Exception -> L18
        byte[] r12 = r11.doFinal(r7.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L18
        if (r9 == false) goto L16;
        byte[] r13 = new byte[r3.length + r12.length];     // Catch: Exception -> L18
        System.arraycopy(r3, 0, r13, 0, r3.length);     // Catch: Exception -> L18
        System.arraycopy(r12, 0, r13, r3.length, r12.length);     // Catch: Exception -> L18
        r12 = r13;
    L16:
        return "=" + r6 + " EN=" + Base64.encodeToString(r12, 2);
    L18:
        e = move-exception;
        LogUtil.e("EncryptUtil-" + r6, "Error encrypting data: ".concat(r7), e);
        return r7;
    L23:
        r3 = new byte[16];     // Catch: Exception -> L18
        new SecureRandom().nextBytes(r3);     // Catch: Exception -> L18
        goto L10
    L25:
        return "";
    }
}
