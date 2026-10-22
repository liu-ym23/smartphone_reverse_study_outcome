package qa;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f10514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f10515b = null;

    static {
        f10515b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    }

    public static String a(int[] r13) {
        StringBuilder r8 = new StringBuilder();
        int r10 = 0;
    L4:
        if (r10 >= r13.length) goto L22;
        int r11 = r13[r10];
        int r12 = 0;
        int r14 = 1;
    L7:
        if (r12 >= 15) goto L9;
        r14 = (r14 << 2) | 1;
        r12 = r12 + 1;
        goto L7
    L9:
        int r15 = ((r11 & r14) << 1) | (((r14 << 1) & r11) >>> 1);
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r16 >= r10) goto L13;
        r17 = (r17 >> 1) | Integer.MIN_VALUE;
        r16 = r16 + 1;
        goto L11
    L13:
        int r18 = (r15 << r10) | ((r15 & r17) >>> (32 - r10));
        char[] r19 = new char[4];
        int r20 = 0;
    L14:
        if (r20 >= 4) goto L20;
        char r21 = (char) ((r18 >>> (r20 * 8)) & 255);
        r19[(4 - r20) - 1] = r21;
        String r22 = " ";
        int r110 = 0;
    L17:
        if (r110 >= 32) goto L19;
        r22 = r22 + (((Integer.MIN_VALUE >>> r110) & r21) >>> (31 - r110));
        r110 = r110 + 1;
        goto L17
    L19:
        r20 = r20 + 1;
        goto L14
    L20:
        r8.append(new String(r19));
        r10 = r10 + 1;
        goto L4
    L22:
        return r8.toString();
    }

    public static byte[] b(byte[] r10) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f10514a != null) goto L5;
        f10514a = t4.n("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L11
    L5:
        IvParameterSpec r8 = new IvParameterSpec(f10514a);     // Catch: Exception -> L11
        int[] r11 = new int[8];     // Catch: Exception -> L11
        int r12 = 0;
    L7:
        if (r12 >= 8) goto L9;
        byte[] r13 = l4.e(f10515b[r12]);     // Catch: Exception -> L11
        r11[r12] = (((r13[1] & 255) << 16) | ((r13[3] & 255) | ((r13[2] & 255) << 8))) | ((r13[0] & 255) << 24);     // Catch: Exception -> L11
        r12 = r12 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        SecretKeySpec r14 = new SecretKeySpec(a(r11).getBytes("UTF-8"), t4.n("EQUVT"));     // Catch: Exception -> L11
        Cipher r15 = Cipher.getInstance(t4.n("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L11
        r15.init(1, r14, r8);     // Catch: Exception -> L11
        return r15.doFinal(r10);
    }

    public static String c() {
        SecureRandom r8 = new SecureRandom();
        KeyGenerator r10 = KeyGenerator.getInstance(t4.n("EQUVT"));     // Catch: Throwable -> L5
        r10.init(128, r8);     // Catch: Throwable -> L5
        return defpackage.c.i(r10.generateKey().getEncoded());
    L5:
        return null;
    }
}
