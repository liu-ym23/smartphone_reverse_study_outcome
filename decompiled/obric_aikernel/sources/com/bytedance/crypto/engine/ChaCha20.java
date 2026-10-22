package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoConst;
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

/* JADX INFO: loaded from: classes.dex */
public class ChaCha20 {
    public static final String TAG = "ChaCha20";

    public ChaCha20() {
    }

    public static int decryptStream(SecretKey r10, byte[] r11, InputStream r12, OutputStream r13) {
        return decryptStreamFull(r10, CryptoConst.ALGORITHM_CHACHA20, r11, r12, r13);
    }

    private static int decryptStreamBlock(SecretKey r10, String r11, byte[] r12, int r13, int r14, InputStream r15, OutputStream r16) {
        if (r13 <= 1048576) goto L7;
        String r17 = TAG;
        StringBuilder r18 = new StringBuilder();
        r18.append("blockSize: ");
        r18.append(r13);
        r18.append(" exceeds the maximum:");
        r18.append(1048576);
    L5:
        LogUtils.e(r17, r18.toString());
        return -2;
    L7:
        if (r14 > 0) goto L9;
        r17 = TAG;
        r18 = new StringBuilder();
        r18.append("input data length: ");
        r18.append(r14);
        goto L5
    L9:
        int r19 = r13 + 16;
        byte[] r20 = new byte[r19];     // Catch: Exception -> L16
        byte[] r21 = new byte[r13];     // Catch: Exception -> L16
        Cipher r22 = Cipher.getInstance(r11);     // Catch: Exception -> L16
        r22.init(2, r10, new IvParameterSpec(r12));     // Catch: Exception -> L16
    L11:
        if (r14 <= 0) goto L23;
        int r23 = r15.read(r20, 0, Math.min(r19, r14));     // Catch: Exception -> L16
        if (r23 <= 0) goto L24;
        int r24 = r22.doFinal(r20, 0, r23, r21);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r24);     // Catch: Exception -> L16
        r16.write(r21, 0, r24);     // Catch: Exception -> L16
        r14 = r14 - r23;
        goto L11
    L24:
        return 0;
    L23:
        return 0;
    L16:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockDynamic(SecretKey r10, String r11, byte[] r12, byte[] r13, int r14, InputStream r15, OutputStream r16) {
        if (r14 <= 1048576) goto L6;
        LogUtils.e(TAG, "blockSize: " + r14 + " exceeds the maximum:1048576");
        return -2;
    L6:
        byte[] r17 = new byte[4];
        String r18 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r18, "key:" + CryptoUtils.byteArrayToHexString(r10.getEncoded()));     // Catch: Exception -> L28
        LogUtils.d(r18, "iv:" + CryptoUtils.byteArrayToHexString(r12));     // Catch: Exception -> L28
        LogUtils.d(r18, "aad:" + new String(r13, StandardCharsets.UTF_8));     // Catch: Exception -> L28
    L9:
        if (r15.read(r17) == (-1)) goto L26;
        int r19 = CryptoUtils.byteArrayToInt(r17);     // Catch: Exception -> L28
        String r20 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r20, "readLen:" + r19);     // Catch: Exception -> L28
        if (r19 <= 0) goto L24;
        if (r19 > (r14 + 16)) goto L24;
        byte[] r21 = new byte[r19];     // Catch: Exception -> L28
        if (r15.read(r21) == (-1)) goto L23;
        Cipher r22 = Cipher.getInstance(r11);     // Catch: Exception -> L28
        r22.init(2, r10, new IvParameterSpec(r12));     // Catch: Exception -> L28
        if (r13 == null) goto L22;
        if (r13.length <= 0) goto L22;
        r22.updateAAD(r13);     // Catch: Exception -> L28
    L22:
        r16.write(r22.doFinal(r21));     // Catch: Exception -> L28
        goto L9
    L23:
        return -8;
    L24:
        LogUtils.e(r20, "read buffer len error, len:" + r19);     // Catch: Exception -> L28
        return -8;
    L26:
        r16.flush();     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r10 = r20;
        if (r19 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r10 > 0) goto L10;
        LogUtils.e(TAG, "input data length: " + r10);
        return -2;
    L10:
        int r11 = r19 + 16;
        int r12 = 0;
        byte[] r13 = new byte[r11];     // Catch: Exception -> L22
        byte[] r14 = new byte[r19];     // Catch: Exception -> L22
        Cipher r15 = Cipher.getInstance(r17);     // Catch: Exception -> L22
        r15.init(2, r16, new IvParameterSpec(r18));     // Catch: Exception -> L22
    L13:
        if (r10 <= 0) goto L28;
        int r110 = r22.read(r13, 0, (int) Math.min(r11, r10));     // Catch: Exception -> L22
        if (r110 <= 0) goto L28;
        int r111 = r15.doFinal(r13, 0, r110, r14);     // Catch: Exception -> L22
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r111);     // Catch: Exception -> L22
        r23.write(r14, 0, r111);     // Catch: Exception -> L22
        r10 = r10 - ((long) r110);
    L28:
        LogUtils.i(TAG, "ChaCha20 decrypt stream success, remaining: " + r10);     // Catch: Exception -> L20
    L25:
        return r12;
    L20:
        e = e;
    L24:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
    L22:
        e = e;
        r12 = -4;
        goto L24
    }

    public static byte[] decryptStreamBytes(SecretKey r10, String r11, byte[] r12, byte[] r13) {
        String r14 = TAG;     // Catch: Exception -> L9
        LogUtils.d(r14, "dataCipher len:" + r13.length);     // Catch: Exception -> L9
        LogUtils.d(r14, "dataCipher:" + CryptoUtils.byteArrayToHexString(r13));     // Catch: Exception -> L9
        LogUtils.d(r14, "ivBytes:" + CryptoUtils.byteArrayToHexString(r12));     // Catch: Exception -> L9
        Cipher r15 = Cipher.getInstance(r11);     // Catch: Exception -> L9
        r15.init(2, r10, new IvParameterSpec(r12));     // Catch: Exception -> L9
        int r16 = CryptoUtils.byteArrayToInt(Arrays.copyOfRange(r13, 0, 4));     // Catch: Exception -> L9
        if (r16 == (r13.length - 4)) goto L8;
        LogUtils.e(r14, "ChaCha20 decrypt init failed, dataCipher len:" + r13.length + " dataLen:" + r16);     // Catch: Exception -> L9
        return null;
    L8:
        return r15.doFinal(Arrays.copyOfRange(r13, 4, r13.length));
    L9:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream bytes failed, error:" + e.getMessage());
        return null;
    }

    public static int decryptStreamDynamic(SecretKey r10, String r11, byte[] r12, byte[] r13, int r14, InputStream r15, OutputStream r16) {
        if (CryptoConst.ALGORITHM_CHACHA20_POLY1305.equals(r11) == false) goto L7;
        return decryptStreamBlockDynamic(r10, r11, r12, r13, r14, r15, r16);
    L7:
        return decryptStreamFull(r10, r11, r12, r15, r16);
    }

    private static int decryptStreamFull(SecretKey r10, String r11, byte[] r12, InputStream r13, OutputStream r14) {
        int r15 = -4;
        LogUtils.i(TAG, "inputStream len:" + r13.available());     // Catch: Exception -> L26
        Cipher r16 = Cipher.getInstance(r11);     // Catch: Exception -> L26
        r16.init(2, r10, new IvParameterSpec(r12));     // Catch: Exception -> L26
        CipherOutputStream r17 = new CipherOutputStream(r14, r16);     // Catch: Exception -> L23
        byte[] r18 = new byte[4096];     // Catch: Throwable -> L17
        boolean r19 = false;
    L8:
        int r20 = r13.read(r18);     // Catch: Throwable -> L17
        if (r20 <= 0) goto L11;
        r17.write(r18, 0, r20);     // Catch: Throwable -> L17
        r19 = true;
        goto L8
    L11:
        if (r19 == false) goto L29;
        r17.flush();     // Catch: Throwable -> L17
    L29:
        r17.close();     // Catch: Exception -> L15
        return 0;
    L15:
        e = e;
        r15 = 0;
    L24:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r15;
    L17:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L23
    L23:
        e = e;
    L26:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int decryptStreamWithPoly1305(SecretKey r10, byte[] r11, int r12, int r13, InputStream r14, OutputStream r15) {
        return decryptStreamBlock(r10, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r11, r12, r13, r14, r15);
    }

    public static int decryptStreamWithPoly1305(SecretKey r10, byte[] r11, int r12, long r13, InputStream r14, OutputStream r15) {
        return decryptStreamBlockLong(r10, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r11, r12, r13, r14, r15);
    }

    public static int encryptStream(SecretKey r10, byte[] r11, InputStream r12, OutputStream r13) {
        return encryptStreamFull(r10, CryptoConst.ALGORITHM_CHACHA20, r11, r12, r13);
    }

    private static int encryptStreamBlock(SecretKey r10, String r11, byte[] r12, int r13, int r14, InputStream r15, OutputStream r16) {
        if (r13 <= 1048576) goto L7;
        String r17 = TAG;
        StringBuilder r18 = new StringBuilder();
        r18.append("blockSize: ");
        r18.append(r13);
        r18.append(" exceeds the maximum:");
        r18.append(1048576);
    L5:
        LogUtils.e(r17, r18.toString());
        return -2;
    L7:
        if (r14 > 0) goto L19;
        r17 = TAG;
        r18 = new StringBuilder();
        r18.append("input data length: ");
        r18.append(r14);
        goto L5
    L19:
        byte[] r19 = new byte[r13];     // Catch: Exception -> L16
        byte[] r20 = new byte[r13 + 16];     // Catch: Exception -> L16
    L11:
        if (r14 <= 0) goto L23;
        int r21 = r15.read(r19, 0, Math.min(r13, r14));     // Catch: Exception -> L16
        if (r21 <= 0) goto L24;
        Cipher r22 = Cipher.getInstance(r11);     // Catch: Exception -> L16
        r22.init(1, r10, new IvParameterSpec(r12));     // Catch: Exception -> L16
        int r23 = r22.doFinal(r19, 0, r21, r20);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r23);     // Catch: Exception -> L16
        r16.write(r20, 0, r23);     // Catch: Exception -> L16
        r14 = r14 - r21;
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

    private static int encryptStreamBlockDynamic(SecretKey r10, String r11, byte[] r12, byte[] r13, int r14, InputStream r15, OutputStream r16) {
        if (r14 <= 1048576) goto L23;
        LogUtils.e(TAG, "blockSize: " + r14 + " exceeds the maximum:1048576");
        return -2;
    L23:
        byte[] r17 = new byte[r14];     // Catch: Exception -> L20
    L7:
        int r18 = r15.read(r17);     // Catch: Exception -> L20
        if (r18 == (-1)) goto L9;
        Cipher r19 = Cipher.getInstance(r11);     // Catch: Exception -> L20
        r19.init(1, r10, new IvParameterSpec(r12));     // Catch: Exception -> L20
        if (r13 != null) goto L14;
    L16:
        if (r18 == r14) goto L17;
        byte[] r20 = r19.doFinal(r17, 0, r18);     // Catch: Exception -> L20
        r16.write(CryptoUtils.intToBytes(r20.length));     // Catch: Exception -> L20
        r16.write(r20);     // Catch: Exception -> L20
        goto L7
    L17:
        byte[] r21 = r19.doFinal(r17);     // Catch: Exception -> L20
        r16.write(CryptoUtils.intToBytes(r21.length));     // Catch: Exception -> L20
        r16.write(r21);     // Catch: Exception -> L20
        goto L7
    L14:
        if (r13.length <= 0) goto L16;
        r19.updateAAD(r13);     // Catch: Exception -> L20
        goto L16
    L9:
        r16.flush();     // Catch: Exception -> L20
        return 0;
    L20:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream dynamic failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r10 = r20;
        if (r19 <= 1048576) goto L6;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L6:
        long r11 = 0;
        if (r10 > 0) goto L10;
        LogUtils.e(TAG, "input data length: " + r10);
        return -2;
    L10:
        int r12 = 0;
        byte[] r13 = new byte[r19];     // Catch: Exception -> L19
        byte[] r14 = new byte[r19 + 16];     // Catch: Exception -> L19
    L13:
        if (r10 <= r11) goto L18;
        int r15 = r22.read(r13, r12, (int) Math.min(r19, r10));     // Catch: Exception -> L19
        if (r15 <= 0) goto L18;
        Cipher r110 = Cipher.getInstance(r17);     // Catch: Exception -> L19
        r110.init(1, r16, new IvParameterSpec(r18));     // Catch: Exception -> L19
        int r111 = r110.doFinal(r13, r12, r15, r14);     // Catch: Exception -> L19
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r111);     // Catch: Exception -> L19
        r23.write(r14, r12, r111);     // Catch: Exception -> L19
        r10 = r10 - ((long) r15);
        r12 = 0;
        r11 = 0;
    L18:
        return 0;
    L19:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamDynamic(SecretKey r10, String r11, byte[] r12, byte[] r13, int r14, InputStream r15, OutputStream r16) {
        if (CryptoConst.ALGORITHM_CHACHA20_POLY1305.equals(r11) == false) goto L7;
        return encryptStreamBlockDynamic(r10, r11, r12, r13, r14, r15, r16);
    L7:
        return encryptStreamFull(r10, r11, r12, r15, r16);
    }

    private static int encryptStreamFull(SecretKey r10, String r11, byte[] r12, InputStream r13, OutputStream r14) {
        int r15 = -4;
        LogUtils.d(TAG, "inputStream len:" + r13.available());     // Catch: Exception -> L26
        Cipher r16 = Cipher.getInstance(r11);     // Catch: Exception -> L26
        r16.init(1, r10, new IvParameterSpec(r12));     // Catch: Exception -> L26
        CipherOutputStream r17 = new CipherOutputStream(r14, r16);     // Catch: Exception -> L23
        byte[] r18 = new byte[4096];     // Catch: Throwable -> L17
        boolean r19 = false;
    L8:
        int r20 = r13.read(r18);     // Catch: Throwable -> L17
        if (r20 <= 0) goto L11;
        r17.write(r18, 0, r20);     // Catch: Throwable -> L17
        r19 = true;
        goto L8
    L11:
        if (r19 == false) goto L29;
        r17.flush();     // Catch: Throwable -> L17
    L29:
        r17.close();     // Catch: Exception -> L15
        return 0;
    L15:
        e = e;
        r15 = 0;
    L24:
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return r15;
    L17:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L23
    L23:
        e = e;
    L26:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamWithPoly1305(SecretKey r10, byte[] r11, int r12, int r13, InputStream r14, OutputStream r15) {
        return encryptStreamBlock(r10, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r11, r12, r13, r14, r15);
    }

    public static int encryptStreamWithPoly1305(SecretKey r10, byte[] r11, int r12, long r13, InputStream r14, OutputStream r15) {
        return encryptStreamBlockLong(r10, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r11, r12, r13, r14, r15);
    }

    public static byte[] xcryptBytes(int r10, String r11, byte[] r12, byte[] r13, byte[] r14) {
        byte[] r15 = new byte[0];
        SecretKeySpec r16 = new SecretKeySpec(r12, r11);     // Catch: Exception -> L5
        Cipher r17 = Cipher.getInstance(r11);     // Catch: Exception -> L5
        r17.init(r10, r16, new IvParameterSpec(r13));     // Catch: Exception -> L5
        return r17.doFinal(r14);
    L5:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 xcrypt bytes failed, mode:" + r10 + " error:" + e.getMessage());
        return r15;
    }
}
