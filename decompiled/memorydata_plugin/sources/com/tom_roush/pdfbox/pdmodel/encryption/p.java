package com.tom_roush.pdfbox.pdmodel.encryption;

import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
public final class p extends l {
    public static final Class<?> c = null;
    private static final byte[] d = null;
    private static final String[] e = null;

    static {
        c = o.class;
        d = new byte[]{40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, MessagePack.Code.INT8, 104, 62, -128, 47, 12, -87, -2, 100, 83, 105, 122};
        e = new String[]{CryptoConst.ALGORITHM_SHA256, "SHA-384", "SHA-512"};
    }

    public p() {
    }

    public p(o r1) {
        a(r1);
        a(r1.a());
    }

    private void a(e r8, int r9, boolean r10) {
        Cipher r1 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: GeneralSecurityException -> L23
        r1.init(2, new SecretKeySpec(d(), CryptoConst.ALGORITHM_AES));     // Catch: GeneralSecurityException -> L23
        byte[] r11 = r1.doFinal(r8.r());     // Catch: GeneralSecurityException -> L23
        if (r11[9] == 97) goto L8;
    L11:
        Log.w("PdfBox-Android", "Verification of permissions failed (constant)");     // Catch: GeneralSecurityException -> L23
    L12:
        int r7 = (((r11[2] & 255) << 16) | ((r11[0] & 255) | ((r11[1] & 255) << 8))) | ((r11[3] & 255) << 24);     // Catch: GeneralSecurityException -> L23
        if (r7 == r9) goto L15;
        Log.w("PdfBox-Android", "Verification of permissions failed (" + String.format("%08X", new Object[]{Integer.valueOf(r7)}) + " != " + String.format("%08X", new Object[]{Integer.valueOf(r9)}) + ")");     // Catch: GeneralSecurityException -> L23
    L15:
        if (r10 == true) goto L17;
    L18:
        if (r10 == false) goto L20;
        return;
    L20:
        if (r11[8] == 70) goto L29;
    L21:
        Log.w("PdfBox-Android", "Verification of permissions failed (EncryptMetadata)");     // Catch: GeneralSecurityException -> L23
        return;
    L29:
        return;
    L17:
        if (r11[8] != 84) goto L21;
    L8:
        if (r11[10] != 100) goto L11;
        if (r11[11] == 98) goto L12;
    L23:
        e = move-exception;
        e();
        throw new IOException(e);
    }

    private boolean a(byte[] r6, byte[] r7, int r8) {
        byte[] r9 = c(r6);
        byte[] r1 = new byte[32];
        byte[] r3 = new byte[8];
        System.arraycopy(r7, 0, r1, 0, 32);
        System.arraycopy(r7, 32, r3, 0, 8);
        if (r8 != 5) goto L5;
        byte[] r5 = c(r9, r3, null);
    L7:
        return Arrays.equals(r5, r1);
    L5:
        r5 = a(r9, r3, null);
        goto L7
    }

    private byte[] a(com.tom_roush.pdfbox.a.a r3) {
        if (r3 == null) goto L8;
        if (r3.b() < 1) goto L8;
        return ((com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(r3.a(0), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin")).b();
    L8:
        return new byte[0];
    }

    private byte[] a(byte[] r3, int r4, int r5) {
        MessageDigest r0 = c.a();
        byte[] r2 = r0.digest(b(r3));
        if (r4 != 3) goto L5;
    L6:
        int r6 = 0;
    L8:
        if (r6 >= 50) goto L10;
        r0.update(r2, 0, r5);
        r2 = r0.digest();
        r6 = r6 + 1;
    L10:
        byte[] r7 = new byte[r5];
        System.arraycopy(r2, 0, r7, 0, r5);
        return r7;
    L5:
        if (r4 != 4) goto L10;
        goto L6
    }

    private byte[] a(byte[] r5, boolean r6, byte[] r7, byte[] r8, byte[] r9, byte[] r10, int r11) {
        if (r6 == false) goto L11;
        if (r9 == null) goto L10;
        byte[] r12 = new byte[8];
        System.arraycopy(r7, 40, r12, 0, 8);
        if (r11 != 5) goto L8;
        byte[] r4 = c(r5, r12, r8);
    L24:
        Cipher r13 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: GeneralSecurityException -> L19
        r13.init(2, new SecretKeySpec(r4, CryptoConst.ALGORITHM_AES), new IvParameterSpec(new byte[16]));     // Catch: GeneralSecurityException -> L19
        return r13.doFinal(r9);
    L19:
        e = move-exception;
        e();
        throw new IOException(e);
    L8:
        r4 = a(r5, r12, r8);
        goto L24
    L10:
        throw new IOException("/Encrypt/OE entry is missing");
    L11:
        if (r10 == null) goto L23;
        byte[] r14 = new byte[8];
        System.arraycopy(r8, 40, r14, 0, 8);
        if (r11 != 5) goto L15;
        r4 = c(r5, r14, null);
    L16:
        r9 = r10;
        goto L24
    L15:
        r4 = a(r5, r14, null);
        goto L16
    L23:
        throw new IOException("/Encrypt/UE entry is missing");
    }

    private byte[] a(byte[] r1, byte[] r2, int r3, byte[] r4, boolean r5, int r6, int r7) {
        byte[] r0 = b(r1);
        MessageDigest r8 = c.a();
        r8.update(r0);
        r8.update(r2);
        r8.update((byte) r3);
        r8.update((byte) (r3 >>> 8));
        r8.update((byte) (r3 >>> 16));
        r8.update((byte) (r3 >>> 24));
        r8.update(r4);
        if (r7 != 4) goto L6;
        if (r5 == true) goto L6;
        r8.update(new byte[]{-1, -1, -1, -1});
    L6:
        byte[] r9 = r8.digest();
        if (r7 == 3) goto L9;
        if (r7 == 4) goto L9;
    L13:
        byte[] r10 = new byte[r6];
        System.arraycopy(r9, 0, r10, 0, r6);
        return r10;
    L9:
        int r11 = 0;
    L11:
        if (r11 >= 50) goto L13;
        r8.update(r9, 0, r6);
        r9 = r8.digest();
        r11 = r11 + 1;
        goto L11
    }

    private byte[] a(byte[] r3, byte[] r4, byte[] r5) {
        if (r5 != null) goto L6;
        r5 = new byte[0];
    L10:
        byte[] r2 = c(r3);
        return b(d(r2, r4, r5), r2, r5);
    L6:
        if (r5.length < 48) goto L13;
        if (r5.length <= 48) goto L10;
        byte[] r0 = new byte[48];
        System.arraycopy(r5, 0, r0, 0, 48);
        r5 = r0;
        goto L10
    L13:
        throw new IOException("Bad U length");
    }

    private byte[] b(byte[] r4) {
        byte[] r3 = d;
        int r0 = r3.length;
        byte[] r1 = new byte[r0];
        int r2 = Math.min(r4.length, r0);
        System.arraycopy(r4, 0, r1, 0, r2);
        System.arraycopy(r3, 0, r1, r2, r3.length - r2);
        return r1;
    }

    private static byte[] b(byte[] r10, byte[] r11, byte[] r12) {
        byte[] r13 = c.c().digest(r10);     // Catch: GeneralSecurityException -> L29
        byte[] r0 = null;
        int r2 = 0;
    L4:
        if (r2 < 64) goto L14;
        if ((r0[r0.length - 1] & 255) > (r2 - 32)) goto L14;
        if (r13.length <= 32) goto L12;
        byte[] r14 = new byte[32];     // Catch: GeneralSecurityException -> L29
        System.arraycopy(r13, 0, r14, 0, 32);     // Catch: GeneralSecurityException -> L29
        return r14;
    L12:
        return r13;
    L14:
        if (r12 != null) goto L16;
    L18:
        byte[] r5 = new byte[(r11.length + r13.length) * 64];     // Catch: GeneralSecurityException -> L29
    L19:
        int r6 = 0;
        int r7 = 0;
    L20:
        if (r6 >= 64) goto L27;
        System.arraycopy(r11, 0, r5, r7, r11.length);     // Catch: GeneralSecurityException -> L29
        int r8 = r7 + r11.length;     // Catch: GeneralSecurityException -> L29
        System.arraycopy(r13, 0, r5, r8, r13.length);     // Catch: GeneralSecurityException -> L29
        r7 = r8 + r13.length;     // Catch: GeneralSecurityException -> L29
        if (r12 == null) goto L26;
        if (r12.length < 48) goto L26;
        System.arraycopy(r12, 0, r5, r7, 48);     // Catch: GeneralSecurityException -> L29
        r7 = r7 + 48;     // Catch: GeneralSecurityException -> L29
    L26:
        r6 = r6 + 1;     // Catch: GeneralSecurityException -> L29
        goto L20
    L27:
        byte[] r3 = new byte[16];     // Catch: GeneralSecurityException -> L29
        byte[] r9 = new byte[16];     // Catch: GeneralSecurityException -> L29
        System.arraycopy(r13, 0, r3, 0, 16);     // Catch: GeneralSecurityException -> L29
        System.arraycopy(r13, 16, r9, 0, 16);     // Catch: GeneralSecurityException -> L29
        Cipher r15 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: GeneralSecurityException -> L29
        r15.init(1, new SecretKeySpec(r3, CryptoConst.ALGORITHM_AES), new IvParameterSpec(r9));     // Catch: GeneralSecurityException -> L29
        byte[] r16 = r15.doFinal(r5);     // Catch: GeneralSecurityException -> L29
        byte[] r4 = new byte[16];     // Catch: GeneralSecurityException -> L29
        System.arraycopy(r16, 0, r4, 0, 16);     // Catch: GeneralSecurityException -> L29
        r2 = r2 + 1;
        r0 = r16;
        r13 = MessageDigest.getInstance(e[new BigInteger(1, r4).mod(new BigInteger("3")).intValue()]).digest(r16);     // Catch: GeneralSecurityException -> L29
        goto L4
    L16:
        if (r12.length < 48) goto L18;
        r5 = new byte[((r11.length + r13.length) + 48) * 64];     // Catch: GeneralSecurityException -> L29
    L29:
        e = move-exception;
        e();
        throw new IOException(e);
    }

    private boolean c(byte[] r10, byte[] r11, byte[] r12, int r13, byte[] r14, int r15, int r16, boolean r17) {
        byte[] r1 = a(r10, r12, r13, r14, r15, r16, r17);
        if (r15 != 2) goto L7;
        return Arrays.equals(r11, r1);
    L7:
        return Arrays.equals(Arrays.copyOf(r11, 16), Arrays.copyOf(r1, 16));
    }

    private static byte[] c(byte[] r3) {
        if (r3.length > 127) goto L5;
        return r3;
    L5:
        byte[] r0 = new byte[127];
        System.arraycopy(r3, 0, r0, 0, 127);
        return r0;
    }

    private static byte[] c(byte[] r1, byte[] r2, byte[] r3) {
        MessageDigest r0 = c.c();
        r0.update(r1);
        r0.update(r2);
        if (r3 != null) goto L6;
        return r0.digest();
    L6:
        return r0.digest(r3);
    }

    private static byte[] d(byte[] r4, byte[] r5, byte[] r6) {
        byte[] r0 = new byte[(r4.length + r5.length) + r6.length];
        System.arraycopy(r4, 0, r0, 0, r4.length);
        System.arraycopy(r5, 0, r0, r4.length, r5.length);
        System.arraycopy(r6, 0, r0, r4.length + r5.length, r6.length);
        return r0;
    }

    private static void e() {
        if (Cipher.getMaxAllowedKeyLength(CryptoConst.ALGORITHM_AES) == Integer.MAX_VALUE) goto L9;
        Log.w("PdfBox-Android", "JCE unlimited strength jurisdiction policy files are not installed");     // Catch: NoSuchAlgorithmException -> L6
        return;
    L9:
        return;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.encryption.l
    public void a(e r23, com.tom_roush.pdfbox.a.a r24, b r25) {
        if (ZeusTransformUtils.instanceOf(r25, n.class) == false) goto L64;
        if (r23.d() < 4) goto L7;
        b(r23.p());
        a(r23.q());
    L7:
        a(r23.m());
        String r0 = ((n) ZeusTransformUtils.preCheckCast(r25, n.class, "com.obric.memorydata.plugin")).a();
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        int r13 = r23.l();
        int r14 = r23.g();
        if (r23.d() != 1) goto L13;
        int r1 = 5;
    L15:
        if (r23.d() != 4) goto L17;
    L18:
        d r2 = r23.n();
        if (r2 == null) goto L34;
        com.tom_roush.pdfbox.a.i r3 = r2.c();
        if (com.tom_roush.pdfbox.a.i.k.equals(r3) == false) goto L28;
        r1 = 16;
        b(true);
        if (r23.b().m(com.tom_roush.pdfbox.a.i.ew) == false) goto L28;
        int r4 = r23.f() / 8;
        if (r4 >= 16) goto L28;
        Log.w("PdfBox-Android", "Using " + r4 + " bytes key length instead of 16 in AESV2 encryption?!");
        r1 = r4;
    L28:
        if (com.tom_roush.pdfbox.a.i.l.equals(r3) == false) goto L34;
        r1 = 32;
        b(true);
        if (r23.b().m(com.tom_roush.pdfbox.a.i.ew) == false) goto L34;
        int r5 = r23.f() / 8;
        if (r5 >= 32) goto L34;
        Log.w("PdfBox-Android", "Using " + r5 + " bytes key length instead of 32 in AESV3 encryption?!");
        int r9 = r5;
    L35:
        byte[] r10 = a(r24);
        boolean r11 = r23.m();
        byte[] r16 = r23.i();
        byte[] r8 = r23.h();
        Charset r6 = com.tom_roush.pdfbox.util.a.d;
        if (r14 == 6) goto L40;
        if (r14 == 5) goto L40;
        Charset r7 = r6;
        byte[] r17 = null;
        byte[] r18 = null;
    L41:
        if (r14 != 6) goto L43;
        r0 = k.a(r0);
    L43:
        String r12 = r0;
        Charset r20 = r7;
        if (a(r12.getBytes(r7), r16, r8, r13, r10, r14, r9, r11) == false) goto L53;
        a(a.a());
        if (r14 != 6) goto L48;
    L51:
        byte[] r15 = r8;
        byte[] r19 = r12.getBytes(r20);
    L52:
        boolean r26 = r11;
        a(a(r19, r15, r16, r17, r18, r13, r10, r14, r9, r11, true));
        int r21 = 6;
    L56:
        if (r14 != r21) goto L58;
    L59:
        a(r23, r13, r26);
        return;
    L58:
        if (r14 == 5) goto L59;
        return;
    L48:
        if (r14 == 5) goto L51;
        r15 = r8;
        r19 = a(r12.getBytes(r20), r15, r14, r9);
        goto L52
    L53:
        r26 = r11;
        int r22 = r9;
        if (b(r12.getBytes(r20), r16, r8, r13, r10, r14, r9, r26) == false) goto L62;
        a r27 = new a(r13);
        r27.b();
        a(r27);
        a(a(r12.getBytes(r20), r8, r16, r17, r18, r13, r10, r14, r22, r26, false));
        r21 = 6;
        goto L56
    L62:
        throw new InvalidPasswordException("Cannot decrypt PDF, the password is incorrect");
    L40:
        Charset r28 = com.tom_roush.pdfbox.util.a.f;
        r7 = r28;
        r18 = r23.k();
        r17 = r23.j();
    L34:
        r9 = r1;
        goto L35
    L17:
        if (r23.d() != 5) goto L34;
    L13:
        r1 = r23.f() / 8;
        goto L15
    L64:
        throw new IOException("Decryption material is not compatible with the document");
    }

    public boolean a(byte[] r13, byte[] r14, byte[] r15, int r16, byte[] r17, int r18, int r19, boolean r20) {
        if (r18 == 6) goto L8;
        if (r18 == 5) goto L8;
        return b(a(r13, r15, r18, r19), r14, r15, r16, r17, r18, r19, r20);
    L8:
        byte[] r4 = c(r13);
        byte[] r7 = new byte[32];
        byte[] r9 = new byte[8];
        if (r15.length < 40) goto L17;
        System.arraycopy(r15, 0, r7, 0, 32);
        System.arraycopy(r15, 32, r9, 0, 8);
        if (r18 != 5) goto L13;
        byte[] r0 = c(r4, r9, r14);
    L15:
        return Arrays.equals(r0, r7);
    L13:
        r0 = a(r4, r9, r14);
        goto L15
    L17:
        throw new IOException("Owner password is too short");
    }

    public byte[] a(byte[] r7, byte[] r8, int r9, int r10) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r11 = a(r7, r9, r10);
        if (r9 != 2) goto L6;
        a(r11, r8, r0);
    L16:
        return r0.toByteArray();
    L6:
        if (r9 != 3) goto L8;
    L9:
        int r12 = r11.length;
        byte[] r13 = new byte[r12];
        byte[] r1 = new byte[r8.length];
        System.arraycopy(r8, 0, r1, 0, r8.length);
        int r14 = 19;
    L10:
        if (r14 < 0) goto L16;
        System.arraycopy(r11, 0, r13, 0, r11.length);
        int r2 = 0;
    L12:
        if (r2 >= r12) goto L14;
        r13[r2] = (byte) (r13[r2] ^ ((byte) r14));
        r2 = r2 + 1;
        goto L12
    L14:
        r0.reset();
        a(r13, r1, r0);
        r1 = r0.toByteArray();
        r14 = r14 - 1;
        goto L10
    L8:
        if (r9 != 4) goto L16;
        goto L9
    }

    public byte[] a(byte[] r16, byte[] r17, int r18, byte[] r19, int r20, int r21, boolean r22) {
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();
        byte[] r0 = a(r16, r17, null, null, null, r18, r19, r20, r21, r22, true);
        if (r20 != 2) goto L6;
        a(r0, d, r14);
    L18:
        return r14.toByteArray();
    L6:
        if (r20 != 3) goto L8;
    L9:
        MessageDigest r1 = c.a();
        r1.update(d);
        r1.update(r19);
        r14.write(r1.digest());
        int r2 = r0.length;
        byte[] r3 = new byte[r2];
        int r4 = 0;
    L11:
        if (r4 >= 20) goto L16;
        System.arraycopy(r0, 0, r3, 0, r2);
        int r5 = 0;
    L13:
        if (r5 >= r2) goto L15;
        r3[r5] = (byte) (r3[r5] ^ r4);
        r5 = r5 + 1;
        goto L13
    L15:
        InputStream r6 = new ByteArrayInputStream(r14.toByteArray());
        r14.reset();
        a(r3, r6, r14);
        r4 = r4 + 1;
        goto L11
    L16:
        byte[] r7 = new byte[32];
        System.arraycopy(r14.toByteArray(), 0, r7, 0, 16);
        System.arraycopy(d, 0, r7, 16, 16);
        r14.reset();
        r14.write(r7);
        goto L18
    L8:
        if (r20 != 4) goto L18;
        goto L9
    }

    public byte[] a(byte[] r9, byte[] r10, byte[] r11, byte[] r12, byte[] r13, int r14, byte[] r15, int r16, int r17, boolean r18, boolean r19) {
        if (r16 == 6) goto L10;
        if (r16 == 5) goto L10;
        return a(r9, r10, r14, r15, r18, r17, r16);
    L10:
        return a(r9, r19, r10, r11, r12, r13, r16);
    }

    public boolean b(byte[] r2, byte[] r3, byte[] r4, int r5, byte[] r6, int r7, int r8, boolean r9) {
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L18;
        if (r7 == 4) goto L18;
        if (r7 == 5) goto L16;
        if (r7 == 6) goto L16;
        throw new IOException("Unknown Encryption Revision " + r7);
    L16:
        return a(r2, r3, r7);
    L18:
        return c(r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
