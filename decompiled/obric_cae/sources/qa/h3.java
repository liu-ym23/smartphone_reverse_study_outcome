package qa;

import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f10504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f10505b = null;

    static {
        f10504a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f10505b = new byte[]{61, 61, 81, 65, 65, 69, 119, 65, 67, BWDLDataStructure.DataLinkParamStructure.NFC, 74, BWDLCommandBuilder.CUSTOMIZED_CMD, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, BWDLCommandBuilder.CUSTOMIZED_CMD, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, BWDLDataStructure.DataLinkParamStructure.NFC, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
        new IvParameterSpec(new byte[]{0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    public static String a(String r8, String r10) {
        if (r10 != null) goto L20;
        return null;
    L20:
        byte[] r11 = r10.getBytes("UTF-8");     // Catch: Throwable -> L15
        MessageDigest r12 = MessageDigest.getInstance(r8);     // Catch: Throwable -> L8
        r12.update(r11);     // Catch: Throwable -> L8
        byte[] r13 = r12.digest();     // Catch: Throwable -> L8
    L10:
        int r14 = r13.length;     // Catch: Throwable -> L15
        StringBuilder r15 = new StringBuilder(r14 * 2);     // Catch: Throwable -> L15
        int r16 = 0;
    L11:
        if (r16 >= r14) goto L13;
        char[] r17 = f10504a;     // Catch: Throwable -> L15
        r15.append(r17[(r13[r16] >> 4) & 15]);     // Catch: Throwable -> L15
        r15.append(r17[r13[r16] & 15]);     // Catch: Throwable -> L15
        r16 = r16 + 1;     // Catch: Throwable -> L15
        goto L11
    L13:
        return r15.toString();
    L8:
        th = move-exception;
        l.a("MD5", "gmb", th);     // Catch: Throwable -> L15
        r13 = null;
    L15:
        th = move-exception;
        t3.g("Encrypt", "encode", th);
        return null;
    }

    public static byte[] b(String r8, byte[] r10) {
        SecretKeySpec r11 = d(r8);     // Catch: Throwable -> L4
        IvParameterSpec r12 = new IvParameterSpec(t4.o());     // Catch: Throwable -> L4
        Cipher r13 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r13.init(1, r11, r12);     // Catch: Throwable -> L4
        return r13.doFinal(r10);
    L4:
        th = move-exception;
        t3.g("Encrypt", "aesEncrypt", th);
        return null;
    }

    public static byte[] c(byte[] r17) {
        byte[] r8 = new StringBuilder(new String(f10505b)).reverse().toString().getBytes();
        int r10 = r8.length;
        r2 r11 = new r2(new byte[(r10 * 3) / 4]);
        int r12 = r11.f10976c;
        int r13 = 6;
        if (r12 == 6) goto L62;
        int r14 = r10 + 0;
        byte[] r15 = r11.f10950a;
        int[] r16 = r2.f10975d;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
    L7:
        if (r18 >= r14) goto L53;
        if (r12 != 0) goto L15;
    L9:
        int r111 = r18 + 4;
        if (r111 > r14) goto L14;
        r19 = r16[r8[r18 + 3] & 255] | (((r16[r8[r18 + 1] & 255] << 12) | (r16[r8[r18] & 255] << 18)) | (r16[r8[r18 + 2] & 255] << r13));
        if (r19 < 0) goto L14;
        r15[r110 + 2] = (byte) r19;
        r15[r110 + 1] = (byte) (r19 >> 8);
        r15[r110] = (byte) (r19 >> 16);
        r110 = r110 + 3;
        r18 = r111;
    L14:
        if (r18 >= r14) goto L53;
    L15:
        int r20 = r18 + 1;
        int r112 = r16[r8[r18] & 255];
        if (r12 == 0) goto L48;
        if (r12 != 1) goto L19;
        if (r112 < 0) goto L46;
    L44:
        r19 = (r19 << 6) | r112;
    L45:
        r12 = r12 + 1;
    L52:
        r18 = r20;
        r13 = 6;
        goto L7
    L46:
        if (r112 == (-1)) goto L52;
    L61:
        r11.f10976c = 6;
        goto L62
    L19:
        if (r12 != 2) goto L21;
        if (r112 >= 0) goto L44;
        if (r112 != (-2)) goto L41;
        r15[r110] = (byte) (r19 >> 4);
        r110 = r110 + 1;
        r12 = 4;
        goto L52
    L41:
        if (r112 == (-1)) goto L52;
    L21:
        if (r12 == 3) goto L31;
        if (r12 == 4) goto L27;
        if (r12 != 5) goto L52;
        if (r112 == (-1)) goto L52;
    L27:
        if (r112 == (-2)) goto L45;
        if (r112 == (-1)) goto L52;
    L31:
        if (r112 < 0) goto L33;
        int r21 = (r19 << 6) | r112;
        r15[r110 + 2] = (byte) r21;
        r15[r110 + 1] = (byte) (r21 >> 8);
        r15[r110] = (byte) (r21 >> 16);
        r110 = r110 + 3;
        r19 = r21;
        r12 = 0;
        goto L52
    L33:
        if (r112 != (-2)) goto L35;
        r15[r110 + 1] = (byte) (r19 >> 2);
        r15[r110] = (byte) (r19 >> 10);
        r110 = r110 + 2;
        r12 = 5;
        goto L52
    L35:
        if (r112 == (-1)) goto L52;
    L48:
        if (r112 < 0) goto L50;
        r12 = r12 + 1;
        r19 = r112;
        goto L52
    L50:
        if (r112 == (-1)) goto L52;
    L53:
        if (r12 == 1) goto L61;
        if (r12 == 2) goto L59;
        if (r12 == 3) goto L58;
        if (r12 == 4) goto L61;
    L60:
        r11.f10976c = r12;
        r11.f10951b = r110;
        boolean r22 = true;
    L63:
        if (r22 == false) goto L71;
        int r23 = r11.f10951b;
        byte[] r24 = r11.f10950a;
        if (r23 == r24.length) goto L68;
        byte[] r25 = new byte[r23];
        System.arraycopy(r24, 0, r25, 0, r23);
        r24 = r25;
    L68:
        PublicKey r26 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(r24));
        Cipher r27 = Cipher.getInstance(t4.n("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        r27.init(1, r26);
        return r27.doFinal(r17);
    L71:
        throw new IllegalArgumentException("bad base-64");
    L58:
        int r28 = r110 + 1;
        r15[r110] = (byte) (r19 >> 10);
        r110 = r28 + 1;
        r15[r28] = (byte) (r19 >> 2);
        goto L60
    L59:
        r15[r110] = (byte) (r19 >> 4);
        r110 = r110 + 1;
    L62:
        r22 = false;
        goto L63
    }

    public static SecretKeySpec d(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        StringBuffer r10 = new StringBuffer(16);
    L5:
        r10.append(r8);
        if (r10.length() >= 16) goto L9;
        r8 = "0";
        goto L5
    L9:
        if (r10.length() <= 16) goto L17;
        r10.setLength(16);
    L17:
        byte[] r11 = r10.toString().getBytes("UTF-8");     // Catch: Throwable -> L13
    L16:
        return new SecretKeySpec(r11, "AES");
    L13:
        th = move-exception;
        t3.g("Encrypt", "createKey", th);
        r11 = null;
        goto L16
    }

    public static byte[] e(String r8, byte[] r10) {
        SecretKeySpec r11 = d(r8);     // Catch: Throwable -> L4
        IvParameterSpec r12 = new IvParameterSpec(t4.o());     // Catch: Throwable -> L4
        Cipher r13 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r13.init(2, r11, r12);     // Catch: Throwable -> L4
        return r13.doFinal(r10);
    L4:
        th = move-exception;
        t3.g("Encrypt", "aesDecrypt", th);
        return null;
    }
}
