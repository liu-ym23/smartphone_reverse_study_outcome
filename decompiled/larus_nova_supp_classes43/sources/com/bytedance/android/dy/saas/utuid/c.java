package com.bytedance.android.dy.saas.utuid;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String d(String r1) {
        return c("SHA-1", r1);
    }

    public static String a(String r10, String r11) {
        SecretKeySpec r1 = new SecretKeySpec(r11.getBytes(Charset.forName("UTF8")), "AES");
        byte[] r12 = Base64.decode(r10, 2);
        Cipher r13 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        r13.init(2, r1);
        return new String(r13.doFinal(r12), Charset.forName("UTF8"));
    }

    public static String b(String r10, String r11) {
        SecretKeySpec r1 = new SecretKeySpec(r11.getBytes(Charset.forName("UTF8")), "AES");
        byte[] r12 = r10.getBytes(Charset.forName("UTF8"));
        Cipher r13 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        r13.init(1, r1);
        return Base64.encodeToString(r13.doFinal(r12), 2);
    }

    public static String c(String r10, String r11) {
        MessageDigest r12 = MessageDigest.getInstance(r10);
        Charset r0 = Charsets.UTF_8;
        if (r11 == null) goto L10;
        byte[] r13 = r12.digest(r11.getBytes(r0));
        StringBuilder r14 = new StringBuilder(r13.length * 2);
        int r1 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r1) goto L8;
        byte r16 = r13[r15];
        r14.append("0123456789ABCDEF".charAt((r16 >> 4) & 15));
        r14.append("0123456789ABCDEF".charAt(r16 & 15));
        r15 = r15 + 1;
        goto L5
    L8:
        return r14.toString();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
