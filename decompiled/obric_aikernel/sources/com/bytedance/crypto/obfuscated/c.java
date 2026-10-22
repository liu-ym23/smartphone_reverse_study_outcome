package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.keymanager.AttestKeyManager;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f1472a;

    public c() {
    }

    public static c a() {
        if (f1472a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1472a != null) goto L9;
        f1472a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f1472a;
    }

    public int a(Context r10, InputStream r11, OutputStream r12, String r13) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L11;
        if (r12 == null) goto L11;
        if (r13 == null) goto L11;
        if (r13.isEmpty() == true) goto L11;
        return b.a(r10, r11, r12, r13, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L11:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int a(InputStream r17) {
        ConcurrentHashMap<String, Object> r10 = b.f1471a;
        if (r17 != null) goto L5;
        LogUtils.e("ModelDistUtils", "InputStream is null!!");
        return -2;
    L5:
        DataInputStream r11 = new DataInputStream(r17);
        MessageDigest r12 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Exception -> L49
        int r13 = r11.readInt();     // Catch: Exception -> L49
        if (r13 == 329978795) goto L10;
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L49
        r14.append("Model magic number mismatch, excepted: 329978795, actually: ");     // Catch: Exception -> L49
        StringBuilder r15 = r14;
        int r16 = r13;
    L9:
        r15.append(r16);     // Catch: Exception -> L49
        StringBuilder r18 = r15;
    L47:
        LogUtils.e("ModelDistUtils", r18.toString());     // Catch: Exception -> L49
    L51:
        f r19 = null;
    L52:
        if (r19 != null) goto L54;
        LogUtils.e("ModelDistUtils", "Parse model signature info failed!!");
        return -8;
    L54:
        LogUtils.d("ModelDistUtils", "modelSignatureInfo.getModelDigest()" + CryptoUtils.byteArrayToHexString(r19.f1478a));
        X509Certificate r20 = CertUtils.pemStringToX509("-----BEGIN CERTIFICATE-----\nMIIChDCCAgugAwIBAgIUGCf2KtXCv2wJLJDhPWmqC4NogUcwCgYIKoZIzj0EAwMw\nWzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSQwIgYDVQQDExtCeXRlRGFuY2UgU21hcnQgRGV2aWNlIFJvb3QwHhcN\nMjUwMjI3MDQxNzI0WhcNNDUxMjMxMTYwMDAwWjBXMRIwEAYDVQQKEwlCeXRlRGFu\nY2UxHzAdBgNVBAsTFkJ5dGVEYW5jZSBTbWFydCBEZXZpY2UxIDAeBgNVBAMTF0J5\ndGVEYW5jZSBTbWFydCBTSUdOIENBMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE\nqEY1tOqjueVxviuVOIBdV+g2BqMOKTRYmTSx0vC9M2fKGCcJeFE32VqtYPtvyDgB\nmVZbvZYxnwdo6dx0MD6RtKOBsDCBrTAOBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/\nBAUwAwEB/zAdBgNVHQ4EFgQUYCEn27oKiFHtO+Q1xHonw5OL4QEwHwYDVR0jBBgw\nFoAU7K7HzdlIzACUAX0TGkAcXyFk6yQwSgYIKwYBBQUHAQEEPjA8MDoGCCsGAQUF\nBzABhi5odHRwOi8vbmV4dXMtcHJvZHVjdGlvbi5ieXRlZGFuY2UubmV0L3BjYS9v\nY3NwMAoGCCqGSM49BAMDA2cAMGQCMEafgMxo9+h04fWDCdF46K2II1RrOC9BUrRS\n50o7HM4wRjYNXTsF11J2enOaTzixzwIwL9l+Hq3OlSYLvRTOnIRD+DmpeSeTsbaV\nrMdjGbg1eRm2P59lkfFFES1BssyzQ5xd\n-----END CERTIFICATE-----");
        if (r20 != null) goto L59;
        String r21 = "Load the preset server signing certificate failed!!";
    L57:
        LogUtils.e("ModelDistUtils", r21);
        return -11;
    L59:
        if (CertUtils.validateCertChain(r20, r19.f1480c) == true) goto L62;
        r21 = "Certificate verification failed!!";
        goto L57
    L62:
        if (CryptoUtils.verifyECDSASignature(r19.f1480c.get(0).getPublicKey(), r19.f1478a, r19.f1479b, CryptoConst.ALGORITHM_NONEwithECDSA) == true) goto L65;
        LogUtils.e("ModelDistUtils", "Signature verification failed!!");
        return -12;
    L65:
        return 0;
    L10:
        r12.update(CryptoUtils.intToBytes(r13));     // Catch: Exception -> L49
        byte r22 = r11.readByte();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "version: " + r22);     // Catch: Exception -> L49
        r12.update(r22);     // Catch: Exception -> L49
        int r23 = r11.readByte();     // Catch: Exception -> L49
        if (r23 == 12) goto L13;
        StringBuilder r24 = new StringBuilder();     // Catch: Exception -> L49
        r24.append("Invalid iv len: ");     // Catch: Exception -> L49
        r15 = r24;
        r16 = r23;
        goto L9
    L13:
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r23);     // Catch: Exception -> L49
        r12.update(r23);     // Catch: Exception -> L49
        byte[] r25 = new byte[r23];     // Catch: Exception -> L49
        r11.readFully(r25);     // Catch: Exception -> L49
        r12.update(r25);     // Catch: Exception -> L49
        int r26 = r11.readInt();     // Catch: Exception -> L49
        if (r26 > 0) goto L16;
    L46:
        StringBuilder r27 = new StringBuilder();     // Catch: Exception -> L49
        r27.append("Invalid blockSize: ");     // Catch: Exception -> L49
        r15 = r27;
        r16 = r26;
        goto L9
    L16:
        if (r26 > 1048576) goto L46;
        LogUtils.d("ModelDistUtils", "blockSize: " + r26);     // Catch: Exception -> L49
        r12.update(CryptoUtils.intToBytes(r26));     // Catch: Exception -> L49
        int r28 = r11.readInt();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "cipherLen: " + r28);     // Catch: Exception -> L49
        r12.update(CryptoUtils.intToBytes(r28));     // Catch: Exception -> L49
        byte[] r29 = new byte[32768];     // Catch: Exception -> L49
        long r30 = 0;
        long r110 = 0;
    L19:
        long r111 = r28;
        if (r110 >= r111) goto L24;
        int r112 = r28;
        int r31 = r11.read(r29, 0, (int) Math.min(32768, r111 - r110));     // Catch: Exception -> L49
        if (r31 == (-1)) goto L24;
        r12.update(r29, 0, r31);     // Catch: Exception -> L49
        r110 = r110 + ((long) r31);     // Catch: Exception -> L49
        r28 = r112;
    L24:
        long r32 = r11.readLong();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "plainDataLen: " + r32);     // Catch: Exception -> L49
        r12.update(CryptoUtils.longToBytes(r32));     // Catch: Exception -> L49
    L26:
        if (r30 >= r32) goto L30;
        int r113 = r11.read(r29, 0, (int) Math.min(32768, r32 - r30));     // Catch: Exception -> L49
        if (r113 == (-1)) goto L30;
        r12.update(r29, 0, r113);     // Catch: Exception -> L49
        r30 = r30 + ((long) r113);     // Catch: Exception -> L49
    L30:
        byte[] r33 = r12.digest();     // Catch: Exception -> L49
        int r34 = r11.readInt();     // Catch: Exception -> L49
        if (r34 > 0) goto L33;
    L45:
        StringBuilder r35 = new StringBuilder();     // Catch: Exception -> L49
        r35.append("Invalid signatureLen: ");     // Catch: Exception -> L49
        StringBuilder r36 = r35;
    L44:
        r36.append(r34);     // Catch: Exception -> L49
        r18 = r36;
        goto L47
    L33:
        if (r34 > 128) goto L45;
        byte[] r37 = new byte[r34];     // Catch: Exception -> L49
        r11.readFully(r37);     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "signatureLen: " + r34);     // Catch: Exception -> L49
        r34 = r11.readInt();     // Catch: Exception -> L49
        if (r34 <= 0) goto L43;
        if (r34 > 32768) goto L43;
        LogUtils.d("ModelDistUtils", "certificateLen: " + r34);     // Catch: Exception -> L49
        byte[] r38 = new byte[r34];     // Catch: Exception -> L49
        r11.readFully(r38);     // Catch: Exception -> L49
        List<X509Certificate> r39 = CertUtils.convertToX509Certificates(r38);     // Catch: Exception -> L49
        if (r39.size() != 1) goto L51;
        LogUtils.d("ModelDistUtils", "certificates.size(): " + r39.size());     // Catch: Exception -> L49
        r19 = new f(r33, r37, r39);     // Catch: Exception -> L49
    L43:
        StringBuilder r40 = new StringBuilder();     // Catch: Exception -> L49
        r40.append("Invalid certificateLen: ");     // Catch: Exception -> L49
        r36 = r40;
    L49:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        goto L51
    }

    public ModelInitResult a(Context r12, String r13, String r14, Bundle r15) {
        if (r12 != null) goto L5;
    L38:
        LogUtils.e("ModelDistributionManagerImpl", "Input params is invalid.");
        return new ModelInitResult(-2, "");
    L5:
        if (b.a(r13) == false) goto L38;
        if (r15 == null) goto L38;
        boolean r10 = false;
        int r11 = r15.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        FrameworkSecurityCompat.KmResult r16 = FrameworkSecurityCompat.getCertificateChain(r12, r13, new Bundle());
        List<Certificate> r17 = r16.getCertChain();
        if (r16.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L14;
        if (r17 == null) goto L14;
        if (r17.size() != 4) goto L14;
        r10 = true;
    L14:
        if (r10 == false) goto L22;
        if (r11 != 1) goto L19;
        return b.a(r17, true);
    L19:
        if (r11 != 2) goto L22;
        return new ModelInitResult(-13, "");
    L22:
        LogUtils.i("ModelDistributionManagerImpl", "Regenerate the certificate chain.");
        List<Certificate> r18 = null;
        if (b.a(r13) == true) goto L40;
        String r19 = "Invalid input params.";
    L25:
        LogUtils.e("ModelDistUtils", r19);
    L37:
        return b.a(r18, true);
    L40:
        AttestKeyManager r20 = AttestKeyManager.getInstance();     // Catch: Exception -> L34
        r20.deleteAttestKey(r12, r13);     // Catch: Exception -> L34
        Bundle r21 = new Bundle();     // Catch: Exception -> L34
        r21.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Exception -> L34
        r21.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Exception -> L34
        r21.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY());     // Catch: Exception -> L34
        List<Certificate> r22 = r20.getAttestCertChain(r12, r13, r14, true, r21);     // Catch: Exception -> L34
        if (r22 != null) goto L29;
    L32:
        LogUtils.e("ModelDistUtils", "The issued certificate chain is invalid.");     // Catch: Exception -> L34
        goto L37
    L29:
        if (r22.size() != 4) goto L32;
        r18 = r22;
    L34:
        e = move-exception;
        r19 = "generateCertChain failed, exception: " + e.getMessage();
        goto L25
    }
}
