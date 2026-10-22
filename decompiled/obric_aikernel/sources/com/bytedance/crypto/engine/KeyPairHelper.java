package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyPairHelper {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int TAG_OCTET_STRING = 4;
    private static final int TAG_SEQUENCE = 48;

    public static class SequenceParser {
        private final byte[] data;
        private int offset;

        public SequenceParser(byte[] r10) {
            if (r10[0] != 48) goto L10;
            this.data = r10;
            int r11 = 1;
            this.offset = 1;
            int r12 = KeyPairHelper.access$000(r10, 1);
            int r13 = this.offset;
            if (r12 <= 127) goto L7;
            r11 = 1 + (r12 / 128);
        L7:
            this.offset = r13 + r11;
            return;
        L10:
            throw new IOException("Expected SEQUENCE tag (0x30)");
        }

        public boolean hasNext() {
            if (this.offset >= this.data.length) goto L5;
            return true;
        L5:
            return false;
        }

        public byte[] nextElement() {
            if (hasNext() == false) goto L11;
            byte[] r10 = this.data;
            int r11 = this.offset;
            byte r12 = r10[r11];
            int r13 = KeyPairHelper.access$000(r10, r11 + 1);
            if (r13 <= 127) goto L7;
            int r14 = (r13 / 128) + 1;
        L8:
            int r15 = (r14 + 1) + r13;
            byte[] r16 = this.data;
            int r17 = this.offset;
            byte[] r18 = Arrays.copyOfRange(r16, r17, r17 + r15);
            this.offset += r15;
            return r18;
        L7:
            r14 = 1;
            goto L8
        L11:
            throw new IOException("No more elements in sequence");
        }
    }

    public KeyPairHelper() {
    }

    public static /* synthetic */ int access$000(byte[] r10, int r11) {
        return decodeLength(r10, r11);
    }

    private static int decodeLength(byte[] r10, int r11) {
        int r12 = r10[r11] & 255;
        if (r12 > 127) goto L5;
        return r12;
    L5:
        int r13 = r12 & 127;
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r13) goto L8;
        r15 = (r15 << 8) | (r10[(r11 + 1) + r14] & 255);
        r14 = r14 + 1;
        goto L6
    L8:
        return r15;
    }

    public static void deleteBDKey(Context r10, String r11) {
        LogUtils.i("KeyPairHelper", "deleteKey succeed, alias:" + r11 + " ret:" + FrameworkSecurityCompat.deleteKey(r10, r11, new Bundle()));
    }

    public static void deleteKey(String r10) {
        KeyStore r11 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Throwable -> L4
        r11.load(null);     // Catch: Throwable -> L4
        r11.deleteEntry(r10);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        LogUtils.e("KeyPairHelper", "deleteKey failed", e);
    }

    public static void generateECDSABDKeyPair(Context r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r12.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r12.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY());
        int r13 = FrameworkSecurityCompat.generateKeyPair(r10, r11, r12);
        if (r13 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L6;
        return;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key manager generate key pair failed, ret:" + r13);
    }

    public static KeyPair generateECDSAKeyPair(String r10, String r11) {
        KeyPairGenerator r12 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, ANDROID_KEYSTORE);     // Catch: Throwable -> L7
        r12.initialize(new KeyGenParameterSpec.Builder(r10, 68).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{CryptoConst.ALGORITHM_SHA256}).setAttestationChallenge(r11.getBytes()).setKeySize(256).build());     // Catch: Throwable -> L7
        KeyPair r13 = r12.generateKeyPair();     // Catch: Throwable -> L7
        if (r13 == null) goto L6;
        return r13;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key pair is null");     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        throw new CloudTransException("generate ecdsa keypair failed, error:" + e.getMessage());
    }

    public static Certificate[] getBDCertificateChain(Context r10, String r11, String r12) {
        Bundle r13 = new Bundle();
        r13.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r12);
        FrameworkSecurityCompat.KmResult r14 = FrameworkSecurityCompat.keyAttestation(r10, r11, r13);
        if (r14.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L13;
        List<Certificate> r15 = r14.getCertChain();
        if (r15 == null) goto L11;
        if (r15.isEmpty() == true) goto L11;
        return (Certificate[]) r15.toArray(new Certificate[0]);
    L11:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");
    L13:
        throw new CloudTransException("load cert chain failed, error: key manager attest key failed, ret:" + r14.getResultCode());
    }

    public static Certificate[] getCertificateChain(String r10) {
        KeyStore r11 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Exception -> L10
        r11.load(null);     // Catch: Exception -> L10
        Certificate[] r12 = r11.getCertificateChain(r10);     // Catch: Exception -> L10
        if (r12 == null) goto L9;
        if (r12.length == 0) goto L9;
        LogUtils.i("challenge", "challenge:" + new String(getChallengeFromAttestation((X509Certificate) r12[0])));     // Catch: Exception -> L10
        return r12;
    L9:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        throw new CloudTransException("load cert failed, error:" + e.getMessage());
    }

    public static byte[] getChallengeFromAttestation(X509Certificate r10) {
        byte[] r11 = r10.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r11 == null) goto L19;
        SequenceParser r12 = new SequenceParser(removeOuterOctetString(r11));
        int r13 = 0;
    L6:
        if (r12.hasNext() == false) goto L17;
        byte[] r14 = r12.nextElement();
        if (r13 == 4) goto L10;
        r13 = r13 + 1;
        goto L6
    L10:
        if (r14[0] != 4) goto L14;
        return parseOctetString(r14);
    L14:
        throw new IOException("Unexpected ASN.1 tag at index 4: " + r14[0]);
    L17:
        throw new IOException("Challenge not found at index 4");
    L19:
        throw new RuntimeException("No Attestation Extension found");
    }

    public static KeyPair loadKeyPair(String r10) {
        KeyStore r11 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Throwable -> L4
        r11.load(null);     // Catch: Throwable -> L4
        return new KeyPair(r11.getCertificate(r10).getPublicKey(), (PrivateKey) r11.getKey(r10, null));
    L4:
        e = move-exception;
        throw new CloudTransException("load key pair failed, error:" + e.getMessage());
    }

    private static byte[] parseOctetString(byte[] r10) {
        if (r10[0] != 4) goto L10;
        int r11 = decodeLength(r10, 1);
        int r12 = 2;
        if (r11 <= 127) goto L8;
        r12 = 2 + (r11 / 128);
    L8:
        return Arrays.copyOfRange(r10, r12, r11 + r12);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }

    private static byte[] removeOuterOctetString(byte[] r10) {
        if (r10[0] != 4) goto L10;
        int r11 = decodeLength(r10, 1);
        int r12 = 2;
        if (r11 <= 127) goto L8;
        r12 = 2 + (r11 / 128);
    L8:
        return Arrays.copyOfRange(r10, r12, r11 + r12);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }
}
