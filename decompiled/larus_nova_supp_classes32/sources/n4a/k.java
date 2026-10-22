package n4a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static byte[] a;
    public static final String[] b = null;

    static {
        b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    }

    public static String a(int[] r13) {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= r13.length) goto L22;
        int r3 = r13[r2];
        int r5 = 0;
        int r6 = 1;
    L7:
        if (r5 >= 15) goto L9;
        r6 = (r6 << 2) | 1;
        r5 = r5 + 1;
        goto L7
    L9:
        int r4 = ((r3 & r6) << 1) | (((r6 << 1) & r3) >>> 1);
        int r7 = 0;
        int r8 = 0;
    L11:
        if (r7 >= r2) goto L13;
        r8 = (r8 >> 1) | Integer.MIN_VALUE;
        r7 = r7 + 1;
        goto L11
    L13:
        int r9 = (r4 << r2) | ((r4 & r8) >>> (32 - r2));
        char[] r10 = new char[4];
        int r11 = 0;
    L14:
        if (r11 >= 4) goto L20;
        char r12 = (char) ((r9 >>> (r11 * 8)) & 255);
        r10[(4 - r11) - 1] = r12;
        String r14 = " ";
        int r15 = 0;
    L17:
        if (r15 >= 32) goto L19;
        r14 = r14 + (((Integer.MIN_VALUE >>> r15) & r12) >>> (31 - r15));
        r15 = r15 + 1;
        goto L17
    L19:
        r11 = r11 + 1;
        goto L14
    L20:
        r0.append(new String(r10));
        r2 = r2 + 1;
        goto L4
    L22:
        return r0.toString();
    }

    public static byte[] b(byte[] r9) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (a != null) goto L5;
        a = f5.o("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L11
    L5:
        IvParameterSpec r0 = new IvParameterSpec(a);     // Catch: Exception -> L11
        int[] r2 = new int[8];     // Catch: Exception -> L11
        int r4 = 0;
    L6:
        String[] r5 = b;     // Catch: Exception -> L11
        if (r4 >= r5.length) goto L9;
        byte[] r6 = y4.e(r5[r4]);     // Catch: Exception -> L11
        int r7 = ((r6[3] & 255) | ((r6[2] & 255) << 8)) | ((r6[1] & 255) << 16);     // Catch: Exception -> L11
        r2[r4] = ((r6[0] & 255) << 24) | r7;     // Catch: Exception -> L11
        r4 = r4 + 1;     // Catch: Exception -> L11
        goto L6
    L9:
        SecretKeySpec r3 = new SecretKeySpec(a(r2).getBytes("UTF-8"), f5.o("EQUVT"));     // Catch: Exception -> L11
        Cipher r1 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L11
        r1.init(1, r3, r0);     // Catch: Exception -> L11
        return r1.doFinal(r9);
    }
}
