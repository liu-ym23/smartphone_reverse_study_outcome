package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class X509CertificateObject extends X509CertificateImpl implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier;
    private final Object cacheLock;
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CertificateInternal internalCertificateValue;
    private X500Principal issuerValue;
    private PublicKey publicKeyValue;
    private X500Principal subjectValue;
    private long[] validityValues;

    private static class X509CertificateEncodingException extends CertificateEncodingException {
        private final Throwable cause;

        X509CertificateEncodingException(Throwable r1) {
            this.cause = r1;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    X509CertificateObject(JcaJceHelper r8, Certificate r9) {
        super((JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r8, JcaJceHelper.class, "com.obric.memorydata.plugin"), r9, createBasicConstraints(r9), createKeyUsage(r9), createSigAlgName(r9), createSigAlgParams(r9));
        this.cacheLock = new Object();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private static BasicConstraints createBasicConstraints(Certificate r3) {
        byte[] r4 = getExtensionOctets(r3, "2.5.29.19");     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return BasicConstraints.getInstance(ASN1Primitive.fromByteArray(r4));
    L8:
        e = move-exception;
        throw new CertificateParsingException("cannot construct BasicConstraints: " + e);
    }

    private static boolean[] createKeyUsage(Certificate r7) {
        byte[] r8 = getExtensionOctets(r7, "2.5.29.15");     // Catch: Exception -> L19
        if (r8 != null) goto L6;
        return null;
    L6:
        DERBitString r9 = DERBitString.getInstance(ASN1Primitive.fromByteArray(r8));     // Catch: Exception -> L19
        byte[] r0 = r9.getBytes();     // Catch: Exception -> L19
        int r1 = (r0.length * 8) - r9.getPadBits();     // Catch: Exception -> L19
        int r10 = 9;
        if (r1 < 9) goto L10;
        r10 = r1;
    L10:
        boolean[] r11 = new boolean[r10];     // Catch: Exception -> L19
        int r3 = 0;
    L11:
        if (r3 == r1) goto L18;
        if ((r0[r3 / 8] & (128 >>> (r3 % 8))) == 0) goto L15;
        boolean r4 = true;
    L16:
        r11[r3] = r4;     // Catch: Exception -> L19
        r3 = r3 + 1;
        goto L11
    L15:
        r4 = false;
        goto L16
    L18:
        return r11;
    L19:
        e = move-exception;
        throw new CertificateParsingException("cannot construct KeyUsage: " + e);
    }

    private static String createSigAlgName(Certificate r3) {
        return X509SignatureUtil.getSignatureName(r3.getSignatureAlgorithm());
    L4:
        e = move-exception;
        throw new CertificateParsingException("cannot construct SigAlgName: " + e);
    }

    private static byte[] createSigAlgParams(Certificate r3) {
        ASN1Encodable r4 = r3.getSignatureAlgorithm().getParameters();     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4.toASN1Primitive().getEncoded("DER");
    L8:
        e = move-exception;
        throw new CertificateParsingException("cannot construct SigAlgParams: " + e);
    }

    private X509CertificateInternal getInternalCertificate() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        X509CertificateInternal r1 = this.internalCertificateValue;     // Catch: Throwable -> L25
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L25
        X509CertificateEncodingException r11 = null;
        byte[] r10 = this.c.getEncoded("DER");     // Catch: IOException -> L12
    L14:
        X509CertificateInternal r2 = new X509CertificateInternal(this.bcHelper, this.c, this.basicConstraints, this.keyUsage, this.sigAlgName, this.sigAlgParams, r10, r11);
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L17:
        if (this.internalCertificateValue != null) goto L19;
        this.internalCertificateValue = r2;     // Catch: Throwable -> L22
    L19:
        X509CertificateInternal r12 = this.internalCertificateValue;     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        return r12;
    L12:
        e = move-exception;
        r10 = null;
        r11 = new X509CertificateEncodingException(e);
    L25:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public void checkValidity(Date r5) {
        long r0 = r5.getTime();
        long[] r6 = getValidityValues();
        if (r0 > r6[1]) goto L10;
        if (r0 < r6[0]) goto L8;
        return;
    L8:
        throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
    L10:
        throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, X509CertificateObject.class) == false) goto L27;
        X509CertificateObject r5 = (X509CertificateObject) ZeusTransformUtils.preCheckCast(r4, X509CertificateObject.class, "com.obric.memorydata.plugin");
        if (this.hashValueSet == false) goto L16;
        if (r5.hashValueSet == false) goto L16;
        if (this.hashValue == r5.hashValue) goto L24;
        return false;
    L24:
        X509CertificateInternal r3 = getInternalCertificate();
        r4 = r5.getInternalCertificate();
    L26:
        return r3.equals(r4);
    L16:
        if (this.internalCertificateValue != null) goto L18;
    L19:
        ASN1BitString r0 = this.c.getSignature();
        if (r0 == null) goto L24;
        if (r0.equals(r5.c.getSignature()) == true) goto L24;
        return false;
    L18:
        if (r5.internalCertificateValue != null) goto L24;
    L27:
        r3 = getInternalCertificate();
        goto L26
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1) {
        return this.attrCarrier.getBagAttribute(r1);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        return Arrays.clone(getInternalCertificate().getEncoded());
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        X500Principal r1 = this.issuerValue;     // Catch: Throwable -> L20
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L20
        X500Principal r2 = super.getIssuerX500Principal();
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (this.issuerValue != null) goto L14;
        this.issuerValue = r2;     // Catch: Throwable -> L17
    L14:
        X500Principal r4 = this.issuerValue;     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r4;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public PublicKey getPublicKey() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        PublicKey r1 = this.publicKeyValue;     // Catch: Throwable -> L24
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L24
        PublicKey r2 = super.getPublicKey();
        if (r2 != null) goto L13;
        return null;
    L13:
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L21:
        th = move-exception;
        throw th;
    L16:
        if (this.publicKeyValue != null) goto L18;
        this.publicKeyValue = r2;     // Catch: Throwable -> L21
    L18:
        PublicKey r4 = this.publicKeyValue;     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        return r4;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        X500Principal r1 = this.subjectValue;     // Catch: Throwable -> L20
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L20
        X500Principal r2 = super.getSubjectX500Principal();
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (this.subjectValue != null) goto L14;
        this.subjectValue = r2;     // Catch: Throwable -> L17
    L14:
        X500Principal r4 = this.subjectValue;     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r4;
    L20:
        th = move-exception;
        throw th;
    }

    public long[] getValidityValues() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        long[] r1 = this.validityValues;     // Catch: Throwable -> L20
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L20
        long[] r2 = {super.getNotBefore().getTime(), super.getNotAfter().getTime()};
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (this.validityValues != null) goto L14;
        this.validityValues = r2;     // Catch: Throwable -> L17
    L14:
        long[] r4 = this.validityValues;     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r4;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.hashValueSet == true) goto L6;
        this.hashValue = getInternalCertificate().hashCode();
        this.hashValueSet = true;
    L6:
        return this.hashValue;
    }

    public int originalHashCode() {
        byte[] r4 = getInternalCertificate().getEncoded();     // Catch: CertificateEncodingException -> L9
        int r1 = 1;
        int r2 = 0;
    L5:
        if (r1 >= r4.length) goto L8;
        r2 = r2 + (r4[r1] * r1);
        r1 = r1 + 1;
        goto L5
    L8:
        return r2;
    L9:
        return 0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }
}
