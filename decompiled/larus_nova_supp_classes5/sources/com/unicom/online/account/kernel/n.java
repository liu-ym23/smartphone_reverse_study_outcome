package com.unicom.online.account.kernel;

import android.text.TextUtils;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n {
    public static String a() {
        String r0 = UUID.randomUUID().toString().replace("-", "");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r0) == false) goto L6;
    L7:
        return ak.c().substring(0, 32);
    L6:
        if (r0.length() < 32) goto L7;
        return r0;
    L9:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r0, String r1, String r2) {
        return d(r0, r1, r2);
    L4:
        e = move-exception;
        aj.a(e);
        return null;
    }

    public static String b(String r0, String r1, String r2) {
        return c(r0, r1, r2);
    L4:
        e = move-exception;
        aj.a(e);
        return null;
    }

    private static String c(String r4, String r5, String r6) {
        if (r4 != null) goto L27;
        return null;
    L27:
    L22:
        e = move-exception;
        throw new Exception("Encrypt error", e);
    L5:
        if (r4.length() != 0) goto L7;
        return null;
    L7:
        if (r4.trim().length() == 0) goto L29;
        if (r5 == null) goto L21;
        if (r5.length() != 16) goto L19;
        if (r6.length() != 16) goto L17;
        Cipher r1 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L22
        r1.init(1, new SecretKeySpec(r5.getBytes("utf-8"), "AES"), new IvParameterSpec(r6.getBytes("utf-8")));     // Catch: Exception -> L22
        return o.a(r1.doFinal(r4.getBytes("utf-8")));
    L17:
        throw new Exception(" iv encrypt key length error");     // Catch: Exception -> L22
    L19:
        throw new Exception("encrypt key length error");     // Catch: Exception -> L22
    L21:
        throw new Exception("encrypt key is null");     // Catch: Exception -> L22
    L29:
        return null;
    }

    private static String d(String r4, String r5, String r6) {
        if (r4 != null) goto L27;
        return null;
    L27:
    L22:
        e = move-exception;
        throw new Exception("decrypt error", e);
    L5:
        if (r4.length() != 0) goto L7;
        return null;
    L7:
        if (r4.trim().length() == 0) goto L29;
        if (r5 == null) goto L21;
        if (r5.length() != 16) goto L19;
        if (r6.length() != 16) goto L17;
        byte[] r7 = o.b(r4);     // Catch: Exception -> L22
        Cipher r1 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L22
        r1.init(2, new SecretKeySpec(r5.getBytes("utf-8"), "AES"), new IvParameterSpec(r6.getBytes("utf-8")));     // Catch: Exception -> L22
        return new String(r1.doFinal(r7), "utf-8");
    L17:
        throw new Exception(" iv decrypt key length error");     // Catch: Exception -> L22
    L19:
        throw new Exception("decrypt key length error");     // Catch: Exception -> L22
    L21:
        throw new Exception("decrypt key is null");     // Catch: Exception -> L22
    L29:
        return null;
    }
}
