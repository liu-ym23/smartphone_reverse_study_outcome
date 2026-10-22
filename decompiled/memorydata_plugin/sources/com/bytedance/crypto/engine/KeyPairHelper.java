package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class KeyPairHelper {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int TAG_OCTET_STRING = 4;
    private static final int TAG_SEQUENCE = 48;

    public static class SequenceParser {
        private final byte[] data;
        private int offset;

        public SequenceParser(byte[] r4) {
            if (r4[0] != 48) goto L10;
            this.data = r4;
            int r0 = 1;
            this.offset = 1;
            int r5 = KeyPairHelper.access$000(r4, 1);
            int r1 = this.offset;
            if (r5 <= 127) goto L7;
            r0 = 1 + (r5 / 128);
        L7:
            this.offset = r1 + r0;
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
            byte[] r0 = this.data;
            int r1 = this.offset;
            byte r2 = r0[r1];
            int r3 = KeyPairHelper.access$000(r0, r1 + 1);
            if (r3 <= 127) goto L7;
            int r4 = (r3 / 128) + 1;
        L8:
            int r5 = (r4 + 1) + r3;
            byte[] r6 = this.data;
            int r7 = this.offset;
            byte[] r8 = Arrays.copyOfRange(r6, r7, r7 + r5);
            this.offset += r5;
            return r8;
        L7:
            r4 = 1;
            goto L8
        L11:
            throw new IOException("No more elements in sequence");
        }
    }

    public KeyPairHelper() {
    }

    public static /* synthetic */ int access$000(byte[] r0, int r1) {
        return decodeLength(r0, r1);
    }

    private static int decodeLength(byte[] r4, int r5) {
        int r0 = r4[r5] & 255;
        if (r0 > 127) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r3 = (r3 << 8) | (r4[(r5 + 1) + r2] & 255);
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    public static void deleteBDKey(Context r2, String r3) {
        LogUtils.i("KeyPairHelper", "deleteKey succeed, alias:" + r3 + " ret:" + FrameworkSecurityCompat.deleteKey((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, new Bundle()));
    }

    public static void deleteKey(String r2) {
        KeyStore r0 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Throwable -> L4
        r0.load(null);     // Catch: Throwable -> L4
        r0.deleteEntry(r2);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        LogUtils.e("KeyPairHelper", "deleteKey failed", e);
    }

    public static void generateECDSABDKeyPair(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY());
        int r7 = FrameworkSecurityCompat.generateKeyPair(r6, r5, r0);
        if (r7 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L6;
        return;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key manager generate key pair failed, ret:" + r7);
    }

    public static KeyPair generateECDSAKeyPair(String r3, String r4) {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, ANDROID_KEYSTORE);     // Catch: Throwable -> L7
        r0.initialize(new KeyGenParameterSpec.Builder(r3, 68).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{CryptoConst.ALGORITHM_SHA256}).setAttestationChallenge(r4.getBytes()).setKeySize(256).build());     // Catch: Throwable -> L7
        KeyPair r5 = r0.generateKeyPair();     // Catch: Throwable -> L7
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key pair is null");     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        throw new CloudTransException("generate ecdsa keypair failed, error:" + e.getMessage());
    }

    public static Certificate[] getBDCertificateChain(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r5);
        FrameworkSecurityCompat.KmResult r7 = FrameworkSecurityCompat.keyAttestation(r6, r4, r0);
        if (r7.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L13;
        List<Certificate> r8 = r7.getCertChain();
        if (r8 == null) goto L11;
        if (r8.isEmpty() == true) goto L11;
        return (Certificate[]) ZeusTransformUtils.preCheckCast(r8.toArray(new Certificate[0]), Certificate[].class, "com.obric.memorydata.plugin");
    L11:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");
    L13:
        throw new CloudTransException("load cert chain failed, error: key manager attest key failed, ret:" + r7.getResultCode());
    }

    public static Certificate[] getCertificateChain(String r4) {
        KeyStore r0 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Exception -> L10
        r0.load(null);     // Catch: Exception -> L10
        Certificate[] r5 = r0.getCertificateChain(r4);     // Catch: Exception -> L10
        if (r5 == null) goto L9;
        if (r5.length == 0) goto L9;
        LogUtils.i("challenge", "challenge:" + new String(getChallengeFromAttestation((X509Certificate) ZeusTransformUtils.preCheckCast(r5[0], X509Certificate.class, "com.obric.memorydata.plugin"))));     // Catch: Exception -> L10
        return r5;
    L9:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        throw new CloudTransException("load cert failed, error:" + e.getMessage());
    }

    public static byte[] getChallengeFromAttestation(X509Certificate r4) {
        byte[] r5 = r4.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r5 == null) goto L19;
        SequenceParser r0 = new SequenceParser(removeOuterOctetString(r5));
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L17;
        byte[] r2 = r0.nextElement();
        if (r1 == 4) goto L10;
        r1 = r1 + 1;
        goto L6
    L10:
        if (r2[0] != 4) goto L14;
        return parseOctetString(r2);
    L14:
        throw new IOException("Unexpected ASN.1 tag at index 4: " + r2[0]);
    L17:
        throw new IOException("Challenge not found at index 4");
    L19:
        throw new RuntimeException("No Attestation Extension found");
    }

    public static KeyPair loadKeyPair(String r4) {
        KeyStore r0 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Throwable -> L4
        r0.load(null);     // Catch: Throwable -> L4
        return new KeyPair(r0.getCertificate(r4).getPublicKey(), (PrivateKey) ZeusTransformUtils.preCheckCast(r0.getKey(r4, null), PrivateKey.class, "com.obric.memorydata.plugin"));
    L4:
        e = move-exception;
        throw new CloudTransException("load key pair failed, error:" + e.getMessage());
    }

    private static byte[] parseOctetString(byte[] r3) {
        if (r3[0] != 4) goto L10;
        int r0 = decodeLength(r3, 1);
        int r1 = 2;
        if (r0 <= 127) goto L8;
        r1 = 2 + (r0 / 128);
    L8:
        return Arrays.copyOfRange(r3, r1, r0 + r1);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }

    private static byte[] removeOuterOctetString(byte[] r3) {
        if (r3[0] != 4) goto L10;
        int r0 = decodeLength(r3, 1);
        int r1 = 2;
        if (r0 <= 127) goto L8;
        r1 = 2 + (r0 / 128);
    L8:
        return Arrays.copyOfRange(r3, r1, r0 + r1);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }
}
