package com.loc;

import com.bytedance.rpc.internal.RpcUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f5608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f5609b;
    private static int[] c;

    static {
        f5609b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
        c = null;
    }

    private static int a(int r3, int r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L6;
        r1 = (r1 >> 1) | Integer.MIN_VALUE;
        r0 = r0 + 1;
        goto L3
    L6:
        return (r3 << r4) | ((r3 & r1) >>> (32 - r4));
    }

    public static String a() {
        SecureRandom r0 = new SecureRandom();
        KeyGenerator r1 = KeyGenerator.getInstance(fx.c("EQUVT"));     // Catch: Throwable -> L5
        r1.init(128, r0);     // Catch: Throwable -> L5
        return e.a(r1.generateKey().getEncoded());
    L5:
        return null;
    }

    private static String a(int r9) {
        char[] r1 = new char[4];
        int r3 = 0;
    L3:
        if (r3 >= 4) goto L10;
        int r4 = (4 - r3) - 1;
        r1[r4] = (char) ((r9 >>> (r3 * 8)) & 255);
        char r5 = r1[r4];
        String r6 = " ";
        int r7 = 0;
    L6:
        if (r7 >= 32) goto L8;
        r6 = r6 + (((Integer.MIN_VALUE >>> r7) & r5) >>> (31 - r7));
        r7 = r7 + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L3
    L10:
        return new String(r1);
    }

    public static String a(String r0) {
        return ft.a(r0);
    }

    private static String a(int[] r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3 == null) goto L9;
        int r1 = 0;
    L6:
        if (r1 >= r3.length) goto L9;
        r0.append(a(a(b(r3[r1]), r1)));
        r1 = r1 + 1;
    L9:
        return r0.toString();
    }

    private static byte[] a(byte[] r4) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f5608a != null) goto L5;
        f5608a = fx.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L7
    L5:
        IvParameterSpec r0 = new IvParameterSpec(f5608a);     // Catch: Exception -> L7
        SecretKeySpec r2 = new SecretKeySpec(a(b()).getBytes(RpcUtils.CHARSET_UTF8), fx.c("EQUVT"));     // Catch: Exception -> L7
        Cipher r1 = Cipher.getInstance(fx.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L7
        r1.init(1, r2, r0);     // Catch: Exception -> L7
        return r1.doFinal(r4);
    }

    private static int b(int r4) {
        int r1 = 0;
        int r2 = 1;
    L4:
        if (r1 >= 15) goto L7;
        r2 = (r2 << 2) | 1;
        r1 = r1 + 1;
        goto L4
    L7:
        return ((r4 & r2) << 1) | (((r2 << 1) & r4) >>> 1);
    }

    public static String b(String r1) {
        return e.a(a(r1.getBytes(RpcUtils.CHARSET_UTF8)));
    L4:
        return null;
    }

    private static int[] b() {
        int[] r0 = c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int[] r1 = new int[8];
        int r3 = 0;
    L6:
        String[] r4 = f5609b;
        if (r3 >= r4.length) goto L9;
        byte[] r5 = fq.b(r4[r3]);
        r1[r3] = ((r5[0] & 255) << 24) | (((r5[3] & 255) | ((r5[2] & 255) << 8)) | ((r5[1] & 255) << 16));
        r3 = r3 + 1;
        goto L6
    L9:
        return r1;
    }
}
