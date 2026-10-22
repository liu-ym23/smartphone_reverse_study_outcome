package qa;

import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f10794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f10795b = null;

    static {
        f10794a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f10795b = new byte[128];
        int r8 = 0;
    L3:
        if (r8 >= 128) goto L5;
        f10795b[r8] = -1;
        r8 = r8 + 1;
        goto L3
    L5:
        int r10 = 65;
    L7:
        if (r10 > 90) goto L9;
        f10795b[r10] = (byte) (r10 - 65);
        r10 = r10 + 1;
        goto L7
    L9:
        int r11 = 97;
    L11:
        if (r11 > 122) goto L13;
        f10795b[r11] = (byte) ((r11 - 97) + 26);
        r11 = r11 + 1;
        goto L11
    L13:
        int r12 = 48;
    L15:
        if (r12 > 57) goto L17;
        f10795b[r12] = (byte) ((r12 - 48) + 52);
        r12 = r12 + 1;
        goto L15
    L17:
        byte[] r13 = f10795b;
        r13[43] = 62;
        r13[47] = 63;
    }

    public static byte[] a(byte[] r8) {
        KeyGenerator r10 = KeyGenerator.getInstance(t4.n("EQUVT"));
        byte[] r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        r10.init(256);
        byte[] r12 = r10.generateKey().getEncoded();
        PublicKey r13 = t4.p();
        if (r13 != null) goto L8;
        return null;
    L8:
        byte[] r14 = b(r12, r13);
        r11 = f(r12, r8, t4.o());     // Catch: Throwable -> L11
    L13:
        byte[] r15 = new byte[r14.length + r11.length];
        System.arraycopy(r14, 0, r15, 0, r14.length);
        System.arraycopy(r11, 0, r15, r14.length, r11.length);
        return r15;
    L11:
        th = move-exception;
        l.a("er", "asEn", th);
        goto L13
    }

    public static byte[] b(byte[] r8, PublicKey r10) {
        Cipher r11 = Cipher.getInstance(t4.n("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        r11.init(1, r10);
        return r11.doFinal(r8);
    }

    public static byte[] c(byte[] r8, byte[] r10, byte[] r11) {
        IvParameterSpec r12 = new IvParameterSpec(r11);
        SecretKeySpec r13 = new SecretKeySpec(r8, t4.n("EQUVT"));
        Cipher r14 = Cipher.getInstance(t4.n("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r14.init(2, r13, r12);
        return r14.doFinal(r10);
    }

    public static String d(byte[] r8) {
        return g(r8);
    L4:
        th = move-exception;
        l.a("er", "e64", th);
        return null;
    }

    public static byte[] e(String r10) {
        int r8 = 0;
        if (r10 == null) goto L5;
        byte[] r11 = t4.i(r10);
        int r12 = r11.length;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(r12);
    L7:
        if (r8 >= r12) goto L50;
    L8:
        byte[] r14 = f10795b;
        int r15 = r8 + 1;
        byte r16 = r14[r11[r8]];
        if (r15 >= r12) goto L13;
        if (r16 != (-1)) goto L13;
        r8 = r15;
    L13:
        if (r16 == (-1)) goto L50;
    L14:
        int r17 = r15 + 1;
        byte r18 = r14[r11[r15]];
        if (r17 >= r12) goto L19;
        if (r18 != (-1)) goto L19;
        r15 = r17;
    L19:
        if (r18 == (-1)) goto L50;
        r13.write((r16 << 2) | ((r18 & BWDLDataStructure.DataLinkParamStructure.NFC) >>> 4));
    L21:
        if (r17 == r12) goto L23;
        int r19 = r17 + 1;
        byte r20 = r11[r17];
        if (r20 == 61) goto L27;
        byte r21 = r14[r20];
        if (r19 >= r12) goto L33;
        if (r21 != (-1)) goto L33;
        r17 = r19;
    L33:
        if (r21 == (-1)) goto L50;
        r13.write(((r18 & 15) << 4) | ((r21 & 60) >>> 2));
    L35:
        if (r19 == r12) goto L37;
        int r22 = r19 + 1;
        byte r23 = r11[r19];
        if (r23 == 61) goto L41;
        byte r24 = r14[r23];
        if (r22 >= r12) goto L47;
        if (r24 != (-1)) goto L47;
        r19 = r22;
    L47:
        if (r24 == (-1)) goto L50;
        r13.write(r24 | ((r21 & 3) << 6));
        r8 = r22;
        goto L7
    L41:
        return r13.toByteArray();
    L37:
        return r13.toByteArray();
    L27:
        return r13.toByteArray();
    L23:
        return r13.toByteArray();
    L50:
        return r13.toByteArray();
    L5:
        return new byte[0];
    }

    public static byte[] f(byte[] r8, byte[] r10, byte[] r11) {
        IvParameterSpec r12 = new IvParameterSpec(r11);
        SecretKeySpec r13 = new SecretKeySpec(r8, t4.n("EQUVT"));
        Cipher r14 = Cipher.getInstance(t4.n("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r14.init(1, r13, r12);     // Catch: InvalidAlgorithmParameterException -> L5
    L8:
        return r14.doFinal(r10);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String g(byte[] r8) {
        StringBuffer r10 = new StringBuffer();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        int r13 = r12 + 1;
        int r14 = r8[r12] & 255;
        char[] r15 = f10794a;
        if (r13 == r11) goto L6;
        int r16 = r13 + 1;
        int r17 = r8[r13] & 255;
        if (r16 == r11) goto L10;
        int r18 = r16 + 1;
        int r19 = r8[r16] & 255;
        r10.append(r15[r14 >>> 2]);
        r10.append(r15[((r14 & 3) << 4) | ((r17 & 240) >>> 4)]);
        r10.append(r15[((r17 & 15) << 2) | ((r19 & 192) >>> 6)]);
        r10.append(r15[r19 & 63]);
        r12 = r18;
        goto L3
    L10:
        r10.append(r15[r14 >>> 2]);
        r10.append(r15[((r14 & 3) << 4) | ((r17 & 240) >>> 4)]);
        r10.append(r15[(r17 & 15) << 2]);
        String r20 = "=";
    L7:
        r10.append(r20);
        goto L13
    L6:
        r10.append(r15[r14 >>> 2]);
        r10.append(r15[(r14 & 3) << 4]);
        r20 = "==";
    L13:
        return r10.toString();
    }
}
