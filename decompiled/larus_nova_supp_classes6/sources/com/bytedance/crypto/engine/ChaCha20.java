package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ChaCha20 {
    public static final String TAG = "ChaCha20";

    public ChaCha20() {
    }

    public static int decryptStream(SecretKey r1, byte[] r2, InputStream r3, OutputStream r4) {
        return decryptStreamFull(r1, "ChaCha20", r2, r3, r4);
    }

    private static int decryptStreamBlock(SecretKey r6, String r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        if (r9 <= 1048576) goto L7;
        String r13 = TAG;
        StringBuilder r14 = new StringBuilder("blockSize: ");
        r14.append(r9);
        r14.append(" exceeds the maximum:1048576");
    L5:
        LogUtils.e(r13, r14.toString());
        return -2;
    L7:
        if (r10 > 0) goto L9;
        r13 = TAG;
        r14 = new StringBuilder("input data length: ");
        r14.append(r10);
        goto L5
    L9:
        int r0 = r9 + 16;
        byte[] r1 = new byte[r0];     // Catch: Exception -> L17
        byte[] r15 = new byte[r9];     // Catch: Exception -> L17
        Cipher r16 = Cipher.getInstance(r7);     // Catch: Exception -> L17
        r16.init(2, r6, new IvParameterSpec(r8));     // Catch: Exception -> L17
    L12:
        if (r10 <= 0) goto L24;
        int r17 = r11.read(r1, 0, Math.min(r0, r10));     // Catch: Exception -> L17
        if (r17 <= 0) goto L25;
        int r2 = r16.doFinal(r1, 0, r17, r15);     // Catch: Exception -> L17
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r2);     // Catch: Exception -> L17
        r12.write(r15, 0, r2);     // Catch: Exception -> L17
        r10 = r10 - r17;
        goto L12
    L25:
        return 0;
    L24:
        return 0;
    L17:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockDynamic(SecretKey r6, String r7, byte[] r8, byte[] r9, int r10, InputStream r11, OutputStream r12) {
        if (r10 <= 1048576) goto L6;
        LogUtils.e(TAG, "blockSize: " + r10 + " exceeds the maximum:1048576");
        return -2;
    L6:
        byte[] r3 = new byte[4];
        String r4 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r4, "key:" + CryptoUtils.byteArrayToHexString(r6.getEncoded()));     // Catch: Exception -> L28
        LogUtils.d(r4, "iv:" + CryptoUtils.byteArrayToHexString(r8));     // Catch: Exception -> L28
        LogUtils.d(r4, "aad:".concat(new String(r9, StandardCharsets.UTF_8)));     // Catch: Exception -> L28
    L9:
        if (r11.read(r3) == (-1)) goto L26;
        int r0 = CryptoUtils.byteArrayToInt(r3);     // Catch: Exception -> L28
        String r2 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r2, "readLen:" + r0);     // Catch: Exception -> L28
        if (r0 <= 0) goto L24;
        if (r0 > (r10 + 16)) goto L24;
        byte[] r1 = new byte[r0];     // Catch: Exception -> L28
        if (r11.read(r1) == (-1)) goto L23;
        Cipher r5 = Cipher.getInstance(r7);     // Catch: Exception -> L28
        r5.init(2, r6, new IvParameterSpec(r8));     // Catch: Exception -> L28
        if (r9 == null) goto L22;
        if (r9.length <= 0) goto L22;
        r5.updateAAD(r9);     // Catch: Exception -> L28
    L22:
        r12.write(r5.doFinal(r1));     // Catch: Exception -> L28
        goto L9
    L23:
        return -8;
    L24:
        LogUtils.e(r2, "read buffer len error, len:" + r0);     // Catch: Exception -> L28
        return -8;
    L26:
        r12.flush();     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r1 = r20;
        if (r19 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r1 > 0) goto L10;
        LogUtils.e(TAG, "input data length: " + r1);
        return -2;
    L10:
        int r3 = r19 + 16;
        int r4 = -4;
        byte[] r7 = new byte[r3];     // Catch: Exception -> L22
        byte[] r0 = new byte[r19];     // Catch: Exception -> L22
        Cipher r8 = Cipher.getInstance(r17);     // Catch: Exception -> L22
        r8.init(2, r16, new IvParameterSpec(r18));     // Catch: Exception -> L22
    L13:
        if (r1 <= 0) goto L25;
        int r11 = r22.read(r7, 0, (int) Math.min(r3, r1));     // Catch: Exception -> L22
        if (r11 <= 0) goto L25;
        int r12 = r8.doFinal(r7, 0, r11, r0);     // Catch: Exception -> L22
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r12);     // Catch: Exception -> L22
        r23.write(r0, 0, r12);     // Catch: Exception -> L22
        r1 = r1 - ((long) r11);
    L25:
        LogUtils.i(TAG, "ChaCha20 decrypt stream success, remaining: " + r1);     // Catch: Exception -> L20
        return 0;
    L20:
        e = e;
        r4 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r4;
    L22:
        e = e;
        goto L23
    }

    public static byte[] decryptStreamBytes(SecretKey r7, String r8, byte[] r9, byte[] r10) {
        String r5 = TAG;     // Catch: Exception -> L9
        LogUtils.d(r5, "dataCipher len:" + r10.length);     // Catch: Exception -> L9
        LogUtils.d(r5, "dataCipher:" + CryptoUtils.byteArrayToHexString(r10));     // Catch: Exception -> L9
        LogUtils.d(r5, "ivBytes:" + CryptoUtils.byteArrayToHexString(r9));     // Catch: Exception -> L9
        Cipher r11 = Cipher.getInstance(r8);     // Catch: Exception -> L9
        r11.init(2, r7, new IvParameterSpec(r9));     // Catch: Exception -> L9
        int r12 = CryptoUtils.byteArrayToInt(Arrays.copyOfRange(r10, 0, 4));     // Catch: Exception -> L9
        if (r12 == (r10.length - 4)) goto L8;
        LogUtils.e(r5, "ChaCha20 decrypt init failed, dataCipher len:" + r10.length + " dataLen:" + r12);     // Catch: Exception -> L9
        return null;
    L8:
        return r11.doFinal(Arrays.copyOfRange(r10, 4, r10.length));
    L9:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream bytes failed, error:" + e.getMessage());
        return null;
    }

    public static int decryptStreamDynamic(SecretKey r1, String r2, byte[] r3, byte[] r4, int r5, InputStream r6, OutputStream r7) {
        if ("ChaCha20-Poly1305".equals(r2) == false) goto L7;
        return decryptStreamBlockDynamic(r1, r2, r3, r4, r5, r6, r7);
    L7:
        return decryptStreamFull(r1, r2, r3, r6, r7);
    }

    private static int decryptStreamFull(SecretKey r4, String r5, byte[] r6, InputStream r7, OutputStream r8) {
        int r1 = -4;
        LogUtils.i(TAG, "inputStream len:" + r7.available());     // Catch: Exception -> L25
        Cipher r9 = Cipher.getInstance(r5);     // Catch: Exception -> L25
        r9.init(2, r4, new IvParameterSpec(r6));     // Catch: Exception -> L25
        CipherOutputStream r10 = new CipherOutputStream(r8, r9);     // Catch: Exception -> L22
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L16
        boolean r12 = false;
    L7:
        int r0 = r7.read(r11);     // Catch: Throwable -> L16
        if (r0 <= 0) goto L10;
        r10.write(r11, 0, r0);     // Catch: Throwable -> L16
        r12 = true;
        goto L7
    L10:
        if (r12 == false) goto L34;
        r10.flush();     // Catch: Throwable -> L16
    L34:
        r10.close();     // Catch: Exception -> L14
        return 0;
    L14:
        e = e;
        r1 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r1;
    L16:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
    L22:
        e = e;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int decryptStreamWithPoly1305(SecretKey r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        return decryptStreamBlock(r7, "ChaCha20-Poly1305", r8, r9, r10, r11, r12);
    }

    public static int decryptStreamWithPoly1305(SecretKey r8, byte[] r9, int r10, long r11, InputStream r13, OutputStream r14) {
        return decryptStreamBlockLong(r8, "ChaCha20-Poly1305", r9, r10, r11, r13, r14);
    }

    public static int encryptStream(SecretKey r1, byte[] r2, InputStream r3, OutputStream r4) {
        return encryptStreamFull(r1, "ChaCha20", r2, r3, r4);
    }

    private static int encryptStreamBlock(SecretKey r8, String r9, byte[] r10, int r11, int r12, InputStream r13, OutputStream r14) {
        if (r11 <= 1048576) goto L7;
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder("blockSize: ");
        r16.append(r11);
        r16.append(" exceeds the maximum:1048576");
    L5:
        LogUtils.e(r15, r16.toString());
        return -2;
    L7:
        if (r12 > 0) goto L19;
        r15 = TAG;
        r16 = new StringBuilder("input data length: ");
        r16.append(r12);
        goto L5
    L19:
        byte[] r0 = new byte[r11];     // Catch: Exception -> L16
        byte[] r1 = new byte[r11 + 16];     // Catch: Exception -> L16
    L11:
        if (r12 <= 0) goto L23;
        int r3 = r13.read(r0, 0, Math.min(r11, r12));     // Catch: Exception -> L16
        if (r3 <= 0) goto L24;
        Cipher r4 = Cipher.getInstance(r9);     // Catch: Exception -> L16
        r4.init(1, r8, new IvParameterSpec(r10));     // Catch: Exception -> L16
        int r5 = r4.doFinal(r0, 0, r3, r1);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r5);     // Catch: Exception -> L16
        r14.write(r1, 0, r5);     // Catch: Exception -> L16
        r12 = r12 - r3;
        goto L11
    L24:
        return 0;
    L23:
        return 0;
    L16:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockDynamic(SecretKey r6, String r7, byte[] r8, byte[] r9, int r10, InputStream r11, OutputStream r12) {
        if (r10 <= 1048576) goto L23;
        LogUtils.e(TAG, "blockSize: " + r10 + " exceeds the maximum:1048576");
        return -2;
    L23:
        byte[] r0 = new byte[r10];     // Catch: Exception -> L20
    L7:
        int r1 = r11.read(r0);     // Catch: Exception -> L20
        if (r1 == (-1)) goto L9;
        Cipher r2 = Cipher.getInstance(r7);     // Catch: Exception -> L20
        r2.init(1, r6, new IvParameterSpec(r8));     // Catch: Exception -> L20
        if (r9 != null) goto L14;
    L16:
        if (r1 == r10) goto L17;
        byte[] r3 = r2.doFinal(r0, 0, r1);     // Catch: Exception -> L20
        r12.write(CryptoUtils.intToBytes(r3.length));     // Catch: Exception -> L20
        r12.write(r3);     // Catch: Exception -> L20
        goto L7
    L17:
        byte[] r4 = r2.doFinal(r0);     // Catch: Exception -> L20
        r12.write(CryptoUtils.intToBytes(r4.length));     // Catch: Exception -> L20
        r12.write(r4);     // Catch: Exception -> L20
        goto L7
    L14:
        if (r9.length <= 0) goto L16;
        r2.updateAAD(r9);     // Catch: Exception -> L20
        goto L16
    L9:
        r12.flush();     // Catch: Exception -> L20
        return 0;
    L20:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream dynamic failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r1 = r20;
        if (r19 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r1 > 0) goto L20;
        LogUtils.e(TAG, "input data length: " + r1);
        return -2;
    L20:
        byte[] r3 = new byte[r19];     // Catch: Exception -> L17
        byte[] r4 = new byte[r19 + 16];     // Catch: Exception -> L17
    L12:
        if (r1 <= 0) goto L24;
        int r9 = r22.read(r3, 0, (int) Math.min(r19, r1));     // Catch: Exception -> L17
        if (r9 <= 0) goto L25;
        Cipher r10 = Cipher.getInstance(r17);     // Catch: Exception -> L17
        r10.init(1, r16, new IvParameterSpec(r18));     // Catch: Exception -> L17
        int r11 = r10.doFinal(r3, 0, r9, r4);     // Catch: Exception -> L17
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r11);     // Catch: Exception -> L17
        r23.write(r4, 0, r11);     // Catch: Exception -> L17
        r1 = r1 - ((long) r9);
        goto L12
    L25:
        return 0;
    L24:
        return 0;
    L17:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamDynamic(SecretKey r1, String r2, byte[] r3, byte[] r4, int r5, InputStream r6, OutputStream r7) {
        if ("ChaCha20-Poly1305".equals(r2) == false) goto L7;
        return encryptStreamBlockDynamic(r1, r2, r3, r4, r5, r6, r7);
    L7:
        return encryptStreamFull(r1, r2, r3, r6, r7);
    }

    private static int encryptStreamFull(SecretKey r4, String r5, byte[] r6, InputStream r7, OutputStream r8) {
        int r1 = -4;
        LogUtils.d(TAG, "inputStream len:" + r7.available());     // Catch: Exception -> L25
        Cipher r9 = Cipher.getInstance(r5);     // Catch: Exception -> L25
        r9.init(1, r4, new IvParameterSpec(r6));     // Catch: Exception -> L25
        CipherOutputStream r10 = new CipherOutputStream(r8, r9);     // Catch: Exception -> L22
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L16
        boolean r0 = false;
    L7:
        int r2 = r7.read(r11);     // Catch: Throwable -> L16
        if (r2 <= 0) goto L10;
        r10.write(r11, 0, r2);     // Catch: Throwable -> L16
        r0 = true;
        goto L7
    L10:
        if (r0 == false) goto L34;
        r10.flush();     // Catch: Throwable -> L16
    L34:
        r10.close();     // Catch: Exception -> L14
        return 0;
    L14:
        e = e;
        r1 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return r1;
    L16:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
    L22:
        e = e;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamWithPoly1305(SecretKey r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        return encryptStreamBlock(r7, "ChaCha20-Poly1305", r8, r9, r10, r11, r12);
    }

    public static int encryptStreamWithPoly1305(SecretKey r8, byte[] r9, int r10, long r11, InputStream r13, OutputStream r14) {
        return encryptStreamBlockLong(r8, "ChaCha20-Poly1305", r9, r10, r11, r13, r14);
    }

    public static byte[] xcryptBytes(int r2, String r3, byte[] r4, byte[] r5, byte[] r6) {
        byte[] r0 = new byte[0];
        SecretKeySpec r1 = new SecretKeySpec(r4, r3);     // Catch: Exception -> L5
        Cipher r7 = Cipher.getInstance(r3);     // Catch: Exception -> L5
        r7.init(r2, r1, new IvParameterSpec(r5));     // Catch: Exception -> L5
        return r7.doFinal(r6);
    L5:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 xcrypt bytes failed, mode:" + r2 + " error:" + e.getMessage());
        return r0;
    }
}
