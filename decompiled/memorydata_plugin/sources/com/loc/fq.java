package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public final class fq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f5586b = null;

    static {
        f5585a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f5586b = new byte[128];
        int r1 = 0;
    L3:
        if (r1 >= 128) goto L5;
        f5586b[r1] = -1;
        r1 = r1 + 1;
        goto L3
    L5:
        int r0 = 65;
    L7:
        if (r0 > 90) goto L9;
        f5586b[r0] = (byte) (r0 - 65);
        r0 = r0 + 1;
        goto L7
    L9:
        int r2 = 97;
    L11:
        if (r2 > 122) goto L13;
        f5586b[r2] = (byte) ((r2 - 97) + 26);
        r2 = r2 + 1;
        goto L11
    L13:
        int r3 = 48;
    L15:
        if (r3 > 57) goto L17;
        f5586b[r3] = (byte) ((r3 - 48) + 52);
        r3 = r3 + 1;
        goto L15
    L17:
        byte[] r4 = f5586b;
        r4[43] = 62;
        r4[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static String a(String r0) {
        return fx.a(b(r0));
    }

    public static byte[] a(byte[] r4) {
        KeyGenerator r0 = KeyGenerator.getInstance(fx.c("EQUVT"));
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.init(256);
        byte[] r1 = r0.generateKey().getEncoded();
        PublicKey r2 = fx.d();
        if (r2 != null) goto L8;
        return null;
    L8:
        byte[] r3 = a(r1, r2);
        byte[] r5 = a(r1, r4);
        byte[] r6 = new byte[r3.length + r5.length];
        System.arraycopy(r3, 0, r6, 0, r3.length);
        System.arraycopy(r5, 0, r6, r3.length, r5.length);
        return r6;
    }

    static byte[] a(byte[] r2, Key r3) {
        Key r4 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        Cipher r0 = Cipher.getInstance(fx.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        r0.init(1, r4);
        return r0.doFinal(r2);
    }

    private static byte[] a(byte[] r1, byte[] r2) {
        return c(r1, r2, fx.c());
    L4:
        th = move-exception;
        n.a(th, "er", "asEn");
        return null;
    }

    public static byte[] a(byte[] r2, byte[] r3, byte[] r4) {
        IvParameterSpec r0 = new IvParameterSpec(r4);
        SecretKeySpec r5 = new SecretKeySpec(r2, fx.c("EQUVT"));
        Cipher r6 = Cipher.getInstance(fx.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r6.init(2, r5, r0);
        return r6.doFinal(r3);
    }

    public static String b(byte[] r2) {
        return d(r2);
    L4:
        th = move-exception;
        n.a(th, "er", "e64");
        return null;
    }

    public static byte[] b(String r8) {
        int r0 = 0;
        if (r8 == null) goto L5;
        byte[] r9 = fx.a(r8);
        int r1 = r9.length;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1);
    L7:
        if (r0 >= r1) goto L50;
    L8:
        int r4 = r0 + 1;
        byte r3 = f5586b[r9[r0]];
        if (r4 >= r1) goto L13;
        if (r3 != (-1)) goto L13;
        r0 = r4;
    L13:
        if (r3 == (-1)) goto L50;
    L14:
        int r6 = r4 + 1;
        byte r5 = f5586b[r9[r4]];
        if (r6 >= r1) goto L19;
        if (r5 != (-1)) goto L19;
        r4 = r6;
    L19:
        if (r5 == (-1)) goto L50;
        r2.write((r3 << 2) | ((r5 & 48) >>> 4));
    L21:
        if (r6 == r1) goto L23;
        int r7 = r6 + 1;
        byte r10 = r9[r6];
        if (r10 == 61) goto L27;
        byte r11 = f5586b[r10];
        if (r7 >= r1) goto L33;
        if (r11 != (-1)) goto L33;
        r6 = r7;
    L33:
        if (r11 == (-1)) goto L50;
        r2.write(((r5 & 15) << 4) | ((r11 & 60) >>> 2));
    L35:
        if (r7 == r1) goto L37;
        int r12 = r7 + 1;
        byte r13 = r9[r7];
        if (r13 == 61) goto L41;
        byte r14 = f5586b[r13];
        if (r12 >= r1) goto L47;
        if (r14 != (-1)) goto L47;
        r7 = r12;
    L47:
        if (r14 == (-1)) goto L50;
        r2.write(r14 | ((r11 & 3) << 6));
        r0 = r12;
        goto L7
    L41:
        return r2.toByteArray();
    L37:
        return r2.toByteArray();
    L27:
        return r2.toByteArray();
    L23:
        return r2.toByteArray();
    L50:
        return r2.toByteArray();
    L5:
        return new byte[0];
    }

    public static byte[] b(byte[] r0, byte[] r1, byte[] r2) {
        return c(r0, r1, r2);
    }

    public static String c(byte[] r0) {
        return d(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static byte[] c(byte[] r2, byte[] r3, byte[] r4) {
        IvParameterSpec r0 = new IvParameterSpec(r4);
        SecretKeySpec r5 = new SecretKeySpec(r2, fx.c("EQUVT"));
        Cipher r6 = Cipher.getInstance(fx.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r6.init(1, r5, r0);     // Catch: InvalidAlgorithmParameterException -> L5
    L8:
        return r6.doFinal(r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static String d(byte[] r8) {
        StringBuffer r0 = new StringBuffer();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        int r3 = r2 + 1;
        int r4 = r8[r2] & 255;
        if (r3 == r1) goto L6;
        int r5 = r3 + 1;
        int r6 = r8[r3] & 255;
        if (r5 == r1) goto L10;
        int r7 = r5 + 1;
        int r9 = r8[r5] & 255;
        char[] r10 = f5585a;
        r0.append(r10[r4 >>> 2]);
        r0.append(r10[((r4 & 3) << 4) | ((r6 & 240) >>> 4)]);
        r0.append(r10[((r6 & 15) << 2) | ((r9 & 192) >>> 6)]);
        r0.append(r10[r9 & 63]);
        r2 = r7;
        goto L3
    L10:
        char[] r11 = f5585a;
        r0.append(r11[r4 >>> 2]);
        r0.append(r11[((r4 & 3) << 4) | ((r6 & 240) >>> 4)]);
        r0.append(r11[(r6 & 15) << 2]);
        String r12 = "=";
    L7:
        r0.append(r12);
        goto L13
    L6:
        char[] r13 = f5585a;
        r0.append(r13[r4 >>> 2]);
        r0.append(r13[(r4 & 3) << 4]);
        r12 = "==";
    L13:
        return r0.toString();
    }
}
