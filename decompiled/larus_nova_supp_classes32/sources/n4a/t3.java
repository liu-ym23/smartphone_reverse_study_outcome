package n4a;

import com.obric.aivoice.core.data.NameKeys;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t3 {
    public static final char[] a = null;
    public static final byte[] b = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        b = new byte[]{61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
        new IvParameterSpec(new byte[]{0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    public static SecretKeySpec d(String r2) {
        if (r2 != null) goto L4;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L4:
        StringBuffer r0 = new StringBuffer(16);
    L5:
        r0.append(r2);
        if (r0.length() >= 16) goto L9;
        r2 = "0";
        goto L5
    L9:
        if (r0.length() <= 16) goto L17;
        r0.setLength(16);
    L17:
        byte[] r3 = r0.toString().getBytes("UTF-8");     // Catch: Throwable -> L13
    L16:
        return new SecretKeySpec(r3, "AES");
    L13:
        th = move-exception;
        c4.g(th, "Encrypt", "createKey");
        r3 = null;
        goto L16
    }

    public static byte[] b(byte[] r16) throws Exception {
        byte[] r0 = new StringBuilder(new String(b)).reverse().toString().getBytes();
        int r1 = a3.a;
        int r2 = r0.length;
        int r3 = (r2 * 3) / 4;
        byte[] r4 = new byte[r3];
        int[] r5 = a3.b.a;
        int r6 = r2 + 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L4:
        if (r7 >= r6) goto L50;
        if (r8 != 0) goto L12;
    L6:
        int r14 = r7 + 4;
        if (r14 > r6) goto L11;
        r9 = (((r5[r0[r7] & 255] << 18) | (r5[r0[r7 + 1] & 255] << 12)) | (r5[r0[r7 + 2] & 255] << 6)) | r5[r0[r7 + 3] & 255];
        if (r9 < 0) goto L11;
        r4[r10 + 2] = (byte) r9;
        r4[r10 + 1] = (byte) (r9 >> 8);
        r4[r10] = (byte) (r9 >> 16);
        r10 = r10 + 3;
        r7 = r14;
    L11:
        if (r7 >= r6) goto L50;
    L12:
        r7 = r7 + 1;
        int r11 = r5[r0[r7] & 255];
        if (r8 == 0) goto L45;
        if (r8 == 1) goto L40;
        if (r8 != 2) goto L18;
        if (r11 >= 0) goto L41;
        if (r11 != (-2)) goto L38;
        r4[r10] = (byte) (r9 >> 4);
        r10 = r10 + 1;
        r8 = 4;
        goto L4
    L38:
        if (r11 == (-1)) goto L4;
    L58:
        boolean r12 = false;
        r10 = 0;
    L59:
        if (r12 == false) goto L66;
        if (r10 == r3) goto L63;
        byte[] r13 = new byte[r10];
        System.arraycopy(r4, 0, r13, 0, r10);
        r4 = r13;
    L63:
        X509EncodedKeySpec r15 = new X509EncodedKeySpec(r4);
        PublicKey r17 = KeyFactory.getInstance("RSA").generatePublic(r15);
        Cipher r18 = Cipher.getInstance(f5.o("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        r18.init(1, r17);
        return r18.doFinal(r16);
    L66:
        throw new IllegalArgumentException("bad base-64");
    L41:
        r9 = (r9 << 6) | r11;
    L42:
        r8 = r8 + 1;
        goto L4
    L18:
        if (r8 != 3) goto L19;
        if (r11 < 0) goto L30;
        r9 = (r9 << 6) | r11;
        r4[r10 + 2] = (byte) r9;
        r4[r10 + 1] = (byte) (r9 >> 8);
        r4[r10] = (byte) (r9 >> 16);
        r10 = r10 + 3;
        r8 = 0;
        goto L4
    L30:
        if (r11 != (-2)) goto L32;
        r4[r10 + 1] = (byte) (r9 >> 2);
        r4[r10] = (byte) (r9 >> 10);
        r10 = r10 + 2;
        r8 = 5;
        goto L4
    L32:
        if (r11 == (-1)) goto L4;
    L19:
        if (r8 == 4) goto L24;
        if (r8 != 5) goto L4;
        if (r11 == (-1)) goto L4;
    L24:
        if (r11 == (-2)) goto L42;
        if (r11 == (-1)) goto L4;
    L40:
        if (r11 >= 0) goto L41;
        if (r11 == (-1)) goto L4;
    L45:
        if (r11 < 0) goto L47;
        r8 = r8 + 1;
        r9 = r11;
        goto L4
    L47:
        if (r11 == (-1)) goto L4;
    L50:
        if (r8 == 1) goto L58;
        if (r8 == 2) goto L56;
        if (r8 == 3) goto L55;
        if (r8 == 4) goto L58;
    L57:
        r12 = true;
        goto L59
    L55:
        int r19 = r10 + 1;
        r4[r10] = (byte) (r9 >> 10);
        r10 = r19 + 1;
        r4[r19] = (byte) (r9 >> 2);
        goto L57
    L56:
        r4[r10] = (byte) (r9 >> 4);
        r10 = r10 + 1;
        goto L57
    }

    public static String a(String r5, String r6) {
        if (r6 != null) goto L20;
        return null;
    L20:
        byte[] r7 = r6.getBytes("UTF-8");     // Catch: Throwable -> L15
        MessageDigest r8 = MessageDigest.getInstance(r5);     // Catch: Throwable -> L8
        r8.update(r7);     // Catch: Throwable -> L8
        byte[] r9 = r8.digest();     // Catch: Throwable -> L8
    L10:
        int r10 = r9.length;     // Catch: Throwable -> L15
        StringBuilder r1 = new StringBuilder(r10 * 2);     // Catch: Throwable -> L15
        int r2 = 0;
    L11:
        if (r2 >= r10) goto L13;
        char[] r3 = a;     // Catch: Throwable -> L15
        r1.append(r3[(r9[r2] >> 4) & 15]);     // Catch: Throwable -> L15
        r1.append(r3[r9[r2] & 15]);     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L11
    L13:
        return r1.toString();
    L8:
        th = move-exception;
        n.a(th, "MD5", "gmb");     // Catch: Throwable -> L15
        r9 = null;
    L15:
        th = move-exception;
        c4.g(th, "Encrypt", "encode");
        return null;
    }

    public static byte[] c(byte[] r3, String r4) {
        SecretKeySpec r5 = d(r4);     // Catch: Throwable -> L4
        IvParameterSpec r1 = new IvParameterSpec(f5.p());     // Catch: Throwable -> L4
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r0.init(1, r5, r1);     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        c4.g(th, "Encrypt", "aesEncrypt");
        return null;
    }

    public static byte[] e(byte[] r3, String r4) {
        SecretKeySpec r5 = d(r4);     // Catch: Throwable -> L4
        IvParameterSpec r1 = new IvParameterSpec(f5.p());     // Catch: Throwable -> L4
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r0.init(2, r5, r1);     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        c4.g(th, "Encrypt", "aesDecrypt");
        return null;
    }
}
