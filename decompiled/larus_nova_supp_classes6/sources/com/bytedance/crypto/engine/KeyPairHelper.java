package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.obric.sva.sdk.data.ISmModel;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class KeyPairHelper {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int TAG_OCTET_STRING = 4;
    private static final int TAG_SEQUENCE = 48;

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
        LogUtils.i("KeyPairHelper", "deleteKey succeed, alias:" + r3 + " ret:" + FrameworkSecurityCompat.deleteKey(r2, r3, new Bundle()));
    }

    public static void deleteKey(String r2) {
        KeyStore r0 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        r0.load(null);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        r0.deleteEntry(r2);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        return;
    L8:
        e = move-exception;
        LogUtils.e("KeyPairHelper", "deleteKey failed", e);
    }

    public static void generateECDSABDKeyPair(Context r4, String r5) {
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), ISmModel.VERSION_0100);
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY());
        int r6 = FrameworkSecurityCompat.generateKeyPair(r4, r5, r0);
        if (r6 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L6;
        return;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key manager generate key pair failed, ret:" + r6);
    }

    public static KeyPair generateECDSAKeyPair(String r3, String r4) {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance("EC", ANDROID_KEYSTORE);     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        r0.initialize(new KeyGenParameterSpec.Builder(r3, 68).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).setAttestationChallenge(r4.getBytes()).setKeySize(ISmModel.VERSION_0100).build());     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        KeyPair r5 = r0.generateKeyPair();     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key pair is null");     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
    L7:
        e = move-exception;
        throw new CloudTransException("generate ecdsa keypair failed, error:" + e.getMessage());
    }

    public static Certificate[] getBDCertificateChain(Context r2, String r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r4);
        FrameworkSecurityCompat.KmResult r5 = FrameworkSecurityCompat.keyAttestation(r2, r3, r0);
        if (r5.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L13;
        List<Certificate> r6 = r5.getCertChain();
        if (r6 == null) goto L11;
        if (r6.isEmpty() == true) goto L11;
        return (Certificate[]) r6.toArray(new Certificate[0]);
    L11:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");
    L13:
        throw new CloudTransException("load cert chain failed, error: key manager attest key failed, ret:" + r5.getResultCode());
    }

    public static Certificate[] getCertificateChain(String r4) {
        KeyStore r1 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Exception -> L11
        r1.load(null);     // Catch: Exception -> L11
        Certificate[] r5 = r1.getCertificateChain(r4);     // Catch: Exception -> L11
        if (r5 == null) goto L10;
        if (r5.length == 0) goto L10;
        LogUtils.i("challenge", "challenge:".concat(new String(getChallengeFromAttestation((X509Certificate) r5[0]))));     // Catch: Exception -> L11
        return r5;
    L10:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");     // Catch: Exception -> L11
    L11:
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

    public static KeyPair loadKeyPair(String r3) {
        KeyStore r0 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: UnrecoverableKeyException -> L4 Throwable -> L6 IOException -> L8 KeyStoreException -> L10 CertificateException -> L12
        r0.load(null);     // Catch: UnrecoverableKeyException -> L4 Throwable -> L6 IOException -> L8 KeyStoreException -> L10 CertificateException -> L12
        return new KeyPair(r0.getCertificate(r3).getPublicKey(), (PrivateKey) r0.getKey(r3, null));
    L6:
        e = move-exception;
        throw new CloudTransException("load key pair failed, error:" + e.getMessage());
    }

    private static byte[] parseOctetString(byte[] r3) {
        if (r3[0] != 4) goto L10;
        int r0 = decodeLength(r3, 1);
        int r2 = 2;
        if (r0 <= 127) goto L8;
        r2 = 2 + (r0 / 128);
    L8:
        return Arrays.copyOfRange(r3, r2, r0 + r2);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }

    private static byte[] removeOuterOctetString(byte[] r3) {
        if (r3[0] != 4) goto L10;
        int r0 = decodeLength(r3, 1);
        int r2 = 2;
        if (r0 <= 127) goto L8;
        r2 = 2 + (r0 / 128);
    L8:
        return Arrays.copyOfRange(r3, r2, r0 + r2);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }
}
