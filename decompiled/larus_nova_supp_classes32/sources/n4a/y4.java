package n4a;

import com.lynx.tasm.event.LynxTouchEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y4 {
    public static final char[] a = null;
    public static final byte[] b = null;

    static {
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = new byte[LynxTouchEvent.kPseudoStateFocusTransition];
        int r1 = 0;
    L3:
        if (r1 >= 128) goto L5;
        b[r1] = -1;
        r1 = r1 + 1;
        goto L3
    L5:
        int r0 = 65;
    L7:
        if (r0 > 90) goto L9;
        b[r0] = (byte) (r0 - 65);
        r0 = r0 + 1;
        goto L7
    L9:
        int r2 = 97;
    L11:
        if (r2 > 122) goto L13;
        b[r2] = (byte) ((r2 - 97) + 26);
        r2 = r2 + 1;
        goto L11
    L13:
        int r3 = 48;
    L15:
        if (r3 > 57) goto L17;
        b[r3] = (byte) ((r3 - 48) + 52);
        r3 = r3 + 1;
        goto L15
    L17:
        byte[] r4 = b;
        r4[43] = 62;
        r4[47] = 63;
    }

    public static byte[] b(byte[] r2, Key r3) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher r0 = Cipher.getInstance(f5.o("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        r0.init(1, r3);
        return r0.doFinal(r2);
    }

    public static byte[] c(byte[] r2, byte[] r3, byte[] r4) throws Exception {
        IvParameterSpec r0 = new IvParameterSpec(r4);
        SecretKeySpec r5 = new SecretKeySpec(r2, f5.o("EQUVT"));
        Cipher r6 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r6.init(2, r5, r0);
        return r6.doFinal(r3);
    }

    public static String d(byte[] r2) {
        return g(r2);
    L4:
        th = move-exception;
        n.a(th, "er", "e64");
        return null;
    }

    public static byte[] e(String r9) {
        int r0 = 0;
        if (r9 == null) goto L5;
        byte[] r10 = f5.j(r9);
        int r1 = r10.length;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1);
    L7:
        if (r0 >= r1) goto L50;
    L8:
        byte[] r3 = b;
        int r4 = r0 + 1;
        byte r5 = r3[r10[r0]];
        if (r4 >= r1) goto L13;
        if (r5 != (-1)) goto L13;
        r0 = r4;
    L13:
        if (r5 == (-1)) goto L50;
    L14:
        int r6 = r4 + 1;
        byte r7 = r3[r10[r4]];
        if (r6 >= r1) goto L19;
        if (r7 != (-1)) goto L19;
        r4 = r6;
    L19:
        if (r7 == (-1)) goto L50;
        r2.write((r5 << 2) | ((r7 & 48) >>> 4));
    L21:
        if (r6 == r1) goto L23;
        int r8 = r6 + 1;
        byte r11 = r10[r6];
        if (r11 == 61) goto L27;
        byte r12 = r3[r11];
        if (r8 >= r1) goto L33;
        if (r12 != (-1)) goto L33;
        r6 = r8;
    L33:
        if (r12 == (-1)) goto L50;
        r2.write(((r7 & 15) << 4) | ((r12 & 60) >>> 2));
    L35:
        if (r8 == r1) goto L37;
        int r13 = r8 + 1;
        byte r14 = r10[r8];
        if (r14 == 61) goto L41;
        byte r15 = r3[r14];
        if (r13 >= r1) goto L47;
        if (r15 != (-1)) goto L47;
        r8 = r13;
    L47:
        if (r15 == (-1)) goto L50;
        r2.write(r15 | ((r12 & 3) << 6));
        r0 = r13;
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

    public static byte[] f(byte[] r2, byte[] r3, byte[] r4) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec r0 = new IvParameterSpec(r4);
        SecretKeySpec r5 = new SecretKeySpec(r2, f5.o("EQUVT"));
        Cipher r6 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r6.init(1, r5, r0);     // Catch: InvalidAlgorithmParameterException -> L5
    L8:
        return r6.doFinal(r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String g(byte[] r8) {
        StringBuffer r0 = new StringBuffer();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        int r3 = r2 + 1;
        int r4 = r8[r2] & 255;
        char[] r5 = a;
        if (r3 == r1) goto L6;
        int r6 = r3 + 1;
        int r7 = r8[r3] & 255;
        if (r6 == r1) goto L10;
        int r9 = r6 + 1;
        int r10 = r8[r6] & 255;
        r0.append(r5[r4 >>> 2]);
        r0.append(r5[((r4 & 3) << 4) | ((r7 & 240) >>> 4)]);
        r0.append(r5[((r7 & 15) << 2) | ((r10 & 192) >>> 6)]);
        r0.append(r5[r10 & 63]);
        r2 = r9;
        goto L3
    L10:
        r0.append(r5[r4 >>> 2]);
        r0.append(r5[((r4 & 3) << 4) | ((r7 & 240) >>> 4)]);
        r0.append(r5[(r7 & 15) << 2]);
        String r11 = "=";
    L7:
        r0.append(r11);
        goto L13
    L6:
        r0.append(r5[r4 >>> 2]);
        r0.append(r5[(r4 & 3) << 4]);
        r11 = "==";
    L13:
        return r0.toString();
    }

    public static byte[] a(byte[] r4) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator r0 = KeyGenerator.getInstance(f5.o("EQUVT"));
        byte[] r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.init(256);
        byte[] r2 = r0.generateKey().getEncoded();
        PublicKey r3 = f5.q();
        if (r3 != null) goto L8;
        return null;
    L8:
        byte[] r5 = b(r2, r3);
        r1 = f(r2, r4, f5.p());     // Catch: Throwable -> L11
    L13:
        byte[] r6 = new byte[r5.length + r1.length];
        System.arraycopy(r5, 0, r6, 0, r5.length);
        System.arraycopy(r1, 0, r6, r5.length, r1.length);
        return r6;
    L11:
        th = move-exception;
        n.a(th, "er", "asEn");
        goto L13
    }
}
