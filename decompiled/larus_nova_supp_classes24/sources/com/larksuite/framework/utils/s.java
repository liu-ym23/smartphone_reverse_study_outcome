package com.larksuite.framework.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s {
    public static String a(byte[] r4) {
        StringBuffer r0 = new StringBuffer();
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L11
        r1.reset();     // Catch: NoSuchAlgorithmException -> L11
        r1.update(r4);     // Catch: NoSuchAlgorithmException -> L11
        byte[] r5 = r1.digest();     // Catch: NoSuchAlgorithmException -> L11
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L14;
        if (Integer.toHexString(r5[r2] & 255).length() != 1) goto L9;
        r0.append("0");     // Catch: NoSuchAlgorithmException -> L11
        r0.append(Integer.toHexString(r5[r2] & 255));     // Catch: NoSuchAlgorithmException -> L11
    L10:
        r2 = r2 + 1;
        goto L4
    L9:
        r0.append(Integer.toHexString(r5[r2] & 255));     // Catch: NoSuchAlgorithmException -> L11
    L14:
        return r0.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String b(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r1.update(r3.getBytes("UTF-8"));     // Catch: Exception -> L10
        return a(r1.digest());
    }

    public static String c(String r3) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r0.update(r3.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L8
        String r1 = new BigInteger(1, r0.digest()).toString(16);     // Catch: Exception -> L8
    L4:
        if (r1.length() >= 32) goto L7;
        r1 = "0" + r1;     // Catch: Exception -> L8
        goto L4
    L7:
        return r1;
    L8:
        return r3;
    }
}
