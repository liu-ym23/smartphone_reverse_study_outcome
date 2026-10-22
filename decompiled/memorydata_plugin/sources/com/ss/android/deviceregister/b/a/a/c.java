package com.ss.android.deviceregister.b.a.a;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15176a;

    public static String a() {
        if (TextUtils.isEmpty(f15176a) == false) goto L6;
        f15176a = a("Ynl0ZWRhbmNl");
    L6:
        return f15176a;
    }

    public static String a(String r2) {
        return new String(Base64.decode(r2.getBytes(RpcUtils.CHARSET_UTF8), 2));
    L4:
        return "";
    }

    public static String a(byte[] r3, String r4) {
        byte[] r5 = Base64.decode(r3, 0);
        SecureRandom r0 = new SecureRandom();
        Key r6 = b(r4.getBytes());
        Cipher r1 = Cipher.getInstance("DES");
        r1.init(2, r6, r0);
        return new String(r1.doFinal(r5), RpcUtils.CHARSET_UTF8);
    }

    public static boolean a(String[] r3) {
        if (r3 != null) goto L5;
    L16:
        return false;
    L5:
        if (r3.length != 2) goto L16;
        if (TextUtils.isEmpty(r3[0]) == true) goto L16;
        if (r3[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r3[1]) == true) goto L16;
        if (r3[1].length() != 16) goto L16;
        return true;
    }

    public static byte[] a(String r3, String r4) {
        SecureRandom r0 = new SecureRandom();
        Key r5 = b(r4.getBytes());
        Cipher r1 = Cipher.getInstance("DES");
        r1.init(1, r5, r0);
        return Base64.encode(r1.doFinal(r3.getBytes(RpcUtils.CHARSET_UTF8)), 0);
    }

    public static byte[] a(byte[] r6) {
        GZIPInputStream r0 = null;
        if (r6 != null) goto L5;
    L38:
        return null;
    L5:
        if (r6.length <= 0) goto L38;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ByteArrayInputStream r2 = new ByteArrayInputStream(r6);     // Catch: Throwable -> L24 IOException -> L31
        GZIPInputStream r7 = new GZIPInputStream(r2);     // Catch: Throwable -> L22 IOException -> L43
        goto L32
    L59:
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L19 IOException -> L21
    L12:
        int r4 = r7.read(r3);     // Catch: Throwable -> L19 IOException -> L21
        if (r4 < 0) goto L47;
        r1.write(r3, 0, r4);     // Catch: Throwable -> L19 IOException -> L21
    L47:
        r7.close();     // Catch: IOException -> L39
    L51:
        r2.close();     // Catch: IOException -> L40
    L37:
        return r1.toByteArray();
    L21:
        r0 = r7;
    L19:
        Throwable th = th;
    L26:
        if (r7 != null) goto L53;
    L28:
        if (r2 == null) goto L62;
        r2.close();     // Catch: IOException -> L42
        throw th;
    L63:
        throw th;
    L62:
        throw th;
    L53:
        r7.close();     // Catch: IOException -> L41
    L22:
        th = move-exception;
        th = th;
        r7 = null;
    L32:
        if (r0 != null) goto L45;
    L34:
        if (r2 == null) goto L37;
    L45:
        r0.close();     // Catch: IOException -> L44
        goto L34
    L31:
        r2 = null;
    L24:
        th = move-exception;
        r2 = null;
        th = th;
        r7 = null;
        goto L26
    }

    public static byte[] a(byte[] r3, String r4, String r5) {
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L4
        r0.init(2, new SecretKeySpec(b(r4), CryptoConst.ALGORITHM_AES), new IvParameterSpec(b(r5)));     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static Key b(byte[] r1) {
        DESKeySpec r0 = new DESKeySpec(r1);
        return SecretKeyFactory.getInstance("DES").generateSecret(r0);
    }

    private static byte[] b(String r4) {
        int r0 = r4.length();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = (byte) r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String[] b() {
        KeyGenerator r1 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L8
        r1.init(128, r2);     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r2.nextBytes(r3);     // Catch: Throwable -> L8
        String[] r0 = {c(r1.generateKey().getEncoded()), c(r3)};     // Catch: Throwable -> L8
        if (a(r0) == false) goto L6;
        return r0;
    L6:
        return null;
    L11:
        return null;
    }

    private static String c(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }
}
