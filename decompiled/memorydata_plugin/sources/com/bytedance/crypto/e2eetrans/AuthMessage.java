package com.bytedance.crypto.e2eetrans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AuthMessage {
    private static final int MAGIC = 313393153;
    public static final int MAX_CERT_CHAIN_SIZE = 4;
    public static final int MAX_CERT_LEN = 2048;
    public static final int MAX_SERIALIZED_LEN = 8385;
    public static final int MAX_SESSION_ID_LEN = 128;
    public static final int NONCE_LEN = 32;
    private static final int VERSION = 3;
    public List<X509Certificate> certChain;
    public byte[] randomNonce;
    public String sessionId;

    public AuthMessage() {
    }

    public static AuthMessage deserialize(byte[] r9) {
        if (r9 == null) goto L43;
        if (r9.length < 5) goto L43;
        AuthMessage r0 = new AuthMessage();     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r2 = 0;
        if (readInt(r9, 0) != MAGIC) goto L33;
        int r4 = r9[4] & 255;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        if (r4 != 3) goto L31;
        int r1 = readLength(r9, 5, 128);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        ensureAvailable(r9, 9, r1);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r3 = r1 + 9;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        String r5 = new String(Arrays.copyOfRange(r9, 9, r3), StandardCharsets.UTF_8);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        r0.sessionId = r5;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        if (r5.isEmpty() == true) goto L29;
        int r6 = readLength(r9, r3, 32);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r7 = r3 + 4;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        if (r6 != 32) goto L27;
        ensureAvailable(r9, r7, r6);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r8 = r6 + r7;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        r0.randomNonce = Arrays.copyOfRange(r9, r7, r8);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        ensureAvailable(r9, r8, 4);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r10 = readInt(r9, r8);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r11 = r8 + 4;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        if (r10 <= 0) goto L25;
        if (r10 > 4) goto L25;
        r0.certChain = new ArrayList(r10);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        CertificateFactory r12 = CertificateFactory.getInstance("X.509");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L17:
        if (r2 >= r10) goto L20;
        int r13 = readLength(r9, r11, 2048);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r14 = r11 + 4;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        ensureAvailable(r9, r14, r13);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        int r15 = r13 + r14;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        r0.certChain.add((X509Certificate) ZeusTransformUtils.preCheckCast(r12.generateCertificate(new ByteArrayInputStream(Arrays.copyOfRange(r9, r14, r15))), X509Certificate.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        r2 = r2 + 1;     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
        r11 = r15;
        goto L17
    L20:
        if (r11 != r9.length) goto L23;
        return r0;
    L23:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Unexpected trailing auth message data");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L25:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid cert chain size");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L27:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid random nonce length");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L29:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "sessionId is empty");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L31:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Unsupported auth message version: " + r4);     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L33:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid auth message magic");     // Catch: Exception -> L34 CertificateException -> L37 CryptoException -> L40
    L40:
        e = move-exception;
        throw e;
    L37:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Parse cert failed", e);
    L34:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Deserialize auth message failed", e);
    L43:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Auth message too short");
    }

    private static void ensureAvailable(byte[] r1, int r2, int r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L10;
        if (r2 > r1.length) goto L10;
        if ((r1.length - r2) < r3) goto L10;
        return;
    L10:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Auth message truncated");
    }

    private static int readInt(byte[] r2, int r3) {
        int r0 = (((r2[r3] & 255) << 24) | ((r2[r3 + 1] & 255) << 16)) | ((r2[r3 + 2] & 255) << 8);
        return (r2[r3 + 3] & 255) | r0;
    }

    private static int readLength(byte[] r2, int r3, int r4) {
        ensureAvailable(r2, r3, 4);
        int r5 = readInt(r2, r3);
        if (r5 <= 0) goto L7;
        if (r5 > r4) goto L7;
        return r5;
    L7:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid field length: " + r5);
    }

    private static void writeByte(ByteArrayOutputStream r0, int r1) {
        r0.write(r1 & 255);
    }

    private static void writeBytesWithLen(ByteArrayOutputStream r2, byte[] r3) {
        writeInt(r2, r3.length);
        r2.write(r3, 0, r3.length);
    }

    private static void writeInt(ByteArrayOutputStream r1, int r2) {
        r1.write((r2 >> 24) & 255);
        r1.write((r2 >> 16) & 255);
        r1.write((r2 >> 8) & 255);
        r1.write(r2 & 255);
    }

    public byte[] serialize() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L8 CertificateEncodingException -> L11
        writeInt(r0, MAGIC);     // Catch: Exception -> L8 CertificateEncodingException -> L11
        writeByte(r0, 3);     // Catch: Exception -> L8 CertificateEncodingException -> L11
        writeBytesWithLen(r0, this.sessionId.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L8 CertificateEncodingException -> L11
        writeBytesWithLen(r0, this.randomNonce);     // Catch: Exception -> L8 CertificateEncodingException -> L11
        writeInt(r0, this.certChain.size());     // Catch: Exception -> L8 CertificateEncodingException -> L11
        Iterator<X509Certificate> r4 = this.certChain.iterator();     // Catch: Exception -> L8 CertificateEncodingException -> L11
    L4:
        if (r4.hasNext() == false) goto L6;
        writeBytesWithLen(r0, ((X509Certificate) ZeusTransformUtils.preCheckCast(r4.next(), X509Certificate.class, "com.obric.memorydata.plugin")).getEncoded());     // Catch: Exception -> L8 CertificateEncodingException -> L11
        goto L4
    L6:
        return r0.toByteArray();
    L11:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Serialize cert failed", e);
    L8:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Serialize auth message failed", e);
    }
}
