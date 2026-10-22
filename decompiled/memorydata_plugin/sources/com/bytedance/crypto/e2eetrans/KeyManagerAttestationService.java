package com.bytedance.crypto.e2eetrans;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KeyManagerAttestationService implements IAttestationService {
    private static final String ATTESTATION_EXTENSION_OID = "1.3.6.1.4.1.46045.1.1.1";
    private static final int CHALLENGE_FIELD_INDEX = 2;
    private static final String DEFAULT_TRUST_ROOT_PUBLIC_KEY_PEM = "-----BEGIN PUBLIC KEY-----\nMHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEEPp+emdYKITT0jN07iNO06KKqpAkWV1S\nnTXFCtPjM67VhigHQOWyewv8gTKpQoOJFZMc/R9Jrmpl9fHToS54wYmIfs82yoQR\nvoHMFLMbZCi7rnl9SdJsAmoqfMB7zqFi\n-----END PUBLIC KEY-----\n";
    private static final int MAX_CHALLENGE_LEN = 256;
    private static final String TAG = "KeyManagerAttestationService";
    private static final int TAG_OCTET_STRING = 4;
    private static final int TAG_SEQUENCE = 48;
    private final Context context;
    private final boolean deleteOnDestroy;
    private boolean destroyed;
    private final String keyAlias;
    private final PublicKey trustRootPublicKey;

    public static final class DerElement {
        public final int contentLength;
        public final int contentOffset;
        public final int nextOffset;
        public final int tag;

        public DerElement(int r1, int r2, int r3, int r4) {
            this.tag = r1;
            this.contentOffset = r2;
            this.contentLength = r3;
            this.nextOffset = r4;
        }
    }

    public static final class LengthInfo {
        public final int length;
        public final int nextOffset;

        public LengthInfo(int r1, int r2) {
            this.length = r1;
            this.nextOffset = r2;
        }
    }

    public KeyManagerAttestationService(Context r3, String r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, true);
    }

    public KeyManagerAttestationService(Context r4, String r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        if (r5 == null) goto L16;
        if (r5.isEmpty() == true) goto L16;
        if (r5.length() > 128) goto L16;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L13;
        r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L13:
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.keyAlias = r5;
        this.trustRootPublicKey = parseDefaultTrustRootPublicKey();
        this.deleteOnDestroy = r6;
        generateSessionKey();
        return;
    L16:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "invalid keyAlias");
    L18:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "context is null");
    }

    private void checkAlive() {
        if (this.destroyed == true) goto L6;
        return;
    L6:
        throw new CryptoException(CryptoException.Code.SESSION_EXPIRED, "attestation service is destroyed");
    }

    private void checkKmResult(FrameworkSecurityCompat.KmResult r3, String r4) {
        FrameworkSecurityCompat.KmResult r2 = (FrameworkSecurityCompat.KmResult) ZeusTransformUtils.wrapperContextForParams(r3, FrameworkSecurityCompat.KmResult.class, "com.obric.memorydata.plugin");
        if ("keyAgreement failed".equals(r4) == false) goto L5;
        CryptoException.Code r5 = CryptoException.Code.HANDSHAKE_FAILED;
    L6:
        if (r2 == null) goto L13;
        int r6 = r2.getResultCode();
        if (r6 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L11;
        return;
    L11:
        throw new CryptoException(r5, r4 + ", ret:" + r6);
    L13:
        throw new CryptoException(r5, r4 + ", result is null");
    L5:
        r5 = CryptoException.Code.CHALLENGE_FAILED;
        goto L6
    }

    private void generateSessionKey() {
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY());
        int r4 = FrameworkSecurityCompat.generateKeyPair(this.context, this.keyAlias, r0);
        if (r4 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L6;
        return;
    L6:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "generate attestation key failed, ret:" + r4);
    }

    private PublicKey parseDefaultTrustRootPublicKey() {
        byte[] r3 = CertUtils.pemStringToEncodedPubKey(DEFAULT_TRUST_ROOT_PUBLIC_KEY_PEM);
        if (r3 == null) goto L12;
        if (r3.length == 0) goto L12;
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(r3));
    L8:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "parse default trust root public key failed", e);
    L12:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "default trust root public key is invalid");
    }

    private static DerElement readDerElement(byte[] r3, int r4) {
        if (r3 == null) goto L13;
        if (r4 < 0) goto L13;
        if (r4 >= r3.length) goto L13;
        int r0 = r3[r4] & 255;
        LengthInfo r5 = readDerLength(r3, r4 + 1);
        int r1 = r5.nextOffset;
        int r6 = r3.length - r1;
        int r7 = r5.length;
        if (r6 < r7) goto L11;
        return new DerElement(r0, r1, r7, r1 + r7);
    L11:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "truncated DER element");
    L13:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "invalid DER offset");
    }

    private static LengthInfo readDerLength(byte[] r4, int r5) {
        if (r5 >= r4.length) goto L22;
        int r0 = r4[r5] & 255;
        if ((r0 & 128) == 0) goto L7;
        int r1 = r0 & 127;
        if (r1 == 0) goto L20;
        if (r1 > 4) goto L20;
        if ((r5 + r1) >= r4.length) goto L20;
        int r2 = 0;
        int r3 = 0;
    L15:
        if (r2 >= r1) goto L18;
        r3 = (r3 << 8) | (r4[(r5 + 1) + r2] & 255);
        r2 = r2 + 1;
        goto L15
    L18:
        return new LengthInfo(r3, (r5 + 1) + r1);
    L20:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "invalid DER length");
    L7:
        return new LengthInfo(r0, r5 + 1);
    L22:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "missing DER length");
    }

    private static byte[] unwrapOctetString(byte[] r4) {
        DerElement r1 = readDerElement(r4, 0);
        if (r1.tag != 4) goto L9;
        if (r1.nextOffset != r4.length) goto L9;
        int r2 = r1.contentLength;
        byte[] r3 = new byte[r2];
        System.arraycopy(r4, r1.contentOffset, r3, 0, r2);
        return r3;
    L9:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "invalid extension OCTET STRING wrapper");
    }

    private boolean validateChainWithPinnedRootKey(List<X509Certificate> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L17:
    L15:
        e = move-exception;
        throw e;
    L12:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "validate cert chain failed", e);
    L4:
        if (r0 >= (r7.size() - 1)) goto L6;
        X509Certificate r2 = (X509Certificate) ZeusTransformUtils.preCheckCast(r7.get(r0), X509Certificate.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12 CryptoException -> L15
        r0 = r0 + 1;     // Catch: Exception -> L12 CryptoException -> L15
        r2.verify(((X509Certificate) ZeusTransformUtils.preCheckCast(r7.get(r0), X509Certificate.class, "com.obric.memorydata.plugin")).getPublicKey());     // Catch: Exception -> L12 CryptoException -> L15
        goto L17
    L6:
        X509Certificate r8 = (X509Certificate) ZeusTransformUtils.preCheckCast(r7.get(r7.size() - 1), X509Certificate.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12 CryptoException -> L15
        if (Arrays.equals(r8.getPublicKey().getEncoded(), this.trustRootPublicKey.getEncoded()) == false) goto L11;
        r8.verify(this.trustRootPublicKey);     // Catch: Exception -> L12 CryptoException -> L15
        return true;
    L11:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "root public key mismatch");     // Catch: Exception -> L12 CryptoException -> L15
    }

    @Override // com.bytedance.crypto.e2eetrans.IAttestationService
    public void destroy() {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = true;
        if (this.deleteOnDestroy == false) goto L9;
        LogUtils.i(TAG, "delete session attestation key, alias:" + this.keyAlias + " ret:" + FrameworkSecurityCompat.deleteKey(this.context, this.keyAlias, new Bundle()));
        return;
    }

    @Override // com.bytedance.crypto.e2eetrans.IAttestationService
    public String extractChallenge(X509Certificate r4) {
        if (r4 == null) goto L34;
        byte[] r3 = r4.getExtensionValue(ATTESTATION_EXTENSION_OID);
        if (r3 == null) goto L32;
        if (r3.length == 0) goto L32;
        byte[] r5 = unwrapOctetString(r3);     // Catch: Exception -> L26 CryptoException -> L29
        int r6 = 0;
        DerElement r0 = readDerElement(r5, 0);     // Catch: Exception -> L26 CryptoException -> L29
        if (r0.tag != 48) goto L25;
        if (r0.nextOffset != r5.length) goto L25;
        int r1 = r0.contentOffset;     // Catch: Exception -> L26 CryptoException -> L29
        int r2 = r0.contentLength + r1;     // Catch: Exception -> L26 CryptoException -> L29
    L12:
        if (r1 >= r2) goto L23;
        DerElement r7 = readDerElement(r5, r1);     // Catch: Exception -> L26 CryptoException -> L29
        if (r6 == 2) goto L16;
        r1 = r7.nextOffset;     // Catch: Exception -> L26 CryptoException -> L29
        r6 = r6 + 1;     // Catch: Exception -> L26 CryptoException -> L29
        goto L12
    L16:
        if (r7.tag != 4) goto L20;
        return new String(r5, r7.contentOffset, r7.contentLength, StandardCharsets.UTF_8);
    L20:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "challenge field is not OCTET STRING");     // Catch: Exception -> L26 CryptoException -> L29
    L23:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "challenge field missing");     // Catch: Exception -> L26 CryptoException -> L29
    L25:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "invalid attestation extension sequence");     // Catch: Exception -> L26 CryptoException -> L29
    L29:
        e = move-exception;
        throw e;
    L26:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "extract challenge failed", e);
    L32:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "attestation challenge extension missing");
    L34:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "leafCert is null");
    }

    @Override // com.bytedance.crypto.e2eetrans.IAttestationService
    public byte[] generateSharedSecret(PublicKey r4) {
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r4, PublicKey.class, "com.obric.memorydata.plugin");
        checkAlive();
        if (r5 == null) goto L21;
        if (r5.getEncoded() == null) goto L21;
        if (r5.getEncoded().length == 0) goto L21;
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        byte[] r6 = CryptoUtils.publicKeyToUncompressedECPubKey(r5);     // Catch: IllegalArgumentException -> L17
        FrameworkSecurityCompat.KmResult r7 = FrameworkSecurityCompat.keyAgreement(this.context, this.keyAlias, r6, r0);
        checkKmResult(r7, "keyAgreement failed");
        byte[] r3 = r7.getOutData();
        if (r3 == null) goto L16;
        if (r3.length == 0) goto L16;
        return r3;
    L16:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "shared secret is empty");
    L17:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "invalid peerPublicKey format", e);
    L21:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "peerPublicKey is empty");
    }

    @Override // com.bytedance.crypto.e2eetrans.IAttestationService
    public List<X509Certificate> getCertificateChain(String r4) {
        checkAlive();
        if (r4 == null) goto L24;
        if (r4.isEmpty() == true) goto L24;
        if (r4.length() > 256) goto L24;
        Bundle r0 = new Bundle();
        r0.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r4);
        FrameworkSecurityCompat.KmResult r5 = FrameworkSecurityCompat.keyAttestation(this.context, this.keyAlias, r0);
        checkKmResult(r5, "keyAttestation failed");
        List<Certificate> r3 = r5.getCertChain();
        if (r3 == null) goto L22;
        if (r3.isEmpty() == true) goto L22;
        ArrayList r6 = new ArrayList(r3.size());
        Iterator<Certificate> r7 = r3.iterator();
    L14:
        if (r7.hasNext() == false) goto L20;
        Certificate r1 = (Certificate) ZeusTransformUtils.preCheckCast(r7.next(), Certificate.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, X509Certificate.class) == false) goto L19;
        r6.add((X509Certificate) ZeusTransformUtils.preCheckCast(r1, X509Certificate.class, "com.obric.memorydata.plugin"));
        goto L14
    L19:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "non-X509 certificate in chain");
    L20:
        return r6;
    L22:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "attestation cert chain is empty");
    L24:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "invalid challenge");
    }

    @Override // com.bytedance.crypto.e2eetrans.IAttestationService
    public boolean validateCertificateChain(List<X509Certificate> r6) {
        List<X509Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L26;
        if (r7.isEmpty() == true) goto L26;
        Iterator<X509Certificate> r0 = r7.iterator();
    L8:
        if (r0.hasNext() == false) goto L20;
        X509Certificate r2 = (X509Certificate) ZeusTransformUtils.preCheckCast(r0.next(), X509Certificate.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        r2.checkValidity();     // Catch: Exception -> L13 CertificateNotYetValidException -> L16
    L16:
        LogUtils.w(TAG, "skip peer cert validity check for not-yet-valid certificate, subject:" + r2.getSubjectDN() + ", notBefore:" + r2.getNotBefore());
    L13:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "peer cert is not valid", e);
    L18:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "peer cert is null");
    L20:
        if (this.trustRootPublicKey == null) goto L24;
        return validateChainWithPinnedRootKey(r7);
    L24:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "trust root public key is null");
    L26:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "peer cert chain is empty");
    }
}
