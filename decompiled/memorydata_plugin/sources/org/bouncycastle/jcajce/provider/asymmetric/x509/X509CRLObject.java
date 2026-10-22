package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.cert.CRLException;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class X509CRLObject extends X509CRLImpl {
    private final Object cacheLock;
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CRLInternal internalCRLValue;

    private static class X509CRLException extends CRLException {
        private final Throwable cause;

        X509CRLException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        X509CRLException(Throwable r1) {
            this.cause = r1;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    X509CRLObject(JcaJceHelper r7, CertificateList r8) {
        super((JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r7, JcaJceHelper.class, "com.obric.memorydata.plugin"), r8, createSigAlgName(r8), createSigAlgParams(r8), isIndirectCRL(r8));
        this.cacheLock = new Object();
    }

    private static String createSigAlgName(CertificateList r3) {
        return X509SignatureUtil.getSignatureName(r3.getSignatureAlgorithm());
    L4:
        e = move-exception;
        throw new X509CRLException("CRL contents invalid: " + e.getMessage(), e);
    }

    private static byte[] createSigAlgParams(CertificateList r3) {
        ASN1Encodable r4 = r3.getSignatureAlgorithm().getParameters();     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4.toASN1Primitive().getEncoded("DER");
    L8:
        e = move-exception;
        throw new CRLException("CRL contents invalid: " + e);
    }

    private X509CRLInternal getInternalCRL() {
        Object r0 = this.cacheLock;
        monitor-enter(r0);
        X509CRLInternal r1 = this.internalCRLValue;     // Catch: Throwable -> L25
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L25
        X509CRLException r10 = null;
        byte[] r9 = this.c.getEncoded("DER");     // Catch: IOException -> L12
    L14:
        X509CRLInternal r2 = new X509CRLInternal(this.bcHelper, this.c, this.sigAlgName, this.sigAlgParams, this.isIndirect, r9, r10);
        Object r3 = this.cacheLock;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L17:
        if (this.internalCRLValue != null) goto L19;
        this.internalCRLValue = r2;     // Catch: Throwable -> L22
    L19:
        X509CRLInternal r11 = this.internalCRLValue;     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        return r11;
    L12:
        e = move-exception;
        r9 = null;
        r10 = new X509CRLException(e);
    L25:
        th = move-exception;
        throw th;
    }

    private static boolean isIndirectCRL(CertificateList r2) {
        byte[] r3 = getExtensionOctets(r2, Extension.issuingDistributionPoint.getId());     // Catch: Exception -> L8
        if (r3 != null) goto L6;
        return false;
    L6:
        return IssuingDistributionPoint.getInstance(r3).isIndirectCRL();
    L8:
        e = move-exception;
        throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
    }

    @Override // java.security.cert.X509CRL
    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, X509CRLObject.class) == false) goto L27;
        X509CRLObject r5 = (X509CRLObject) ZeusTransformUtils.preCheckCast(r4, X509CRLObject.class, "com.obric.memorydata.plugin");
        if (this.hashValueSet == false) goto L16;
        if (r5.hashValueSet == false) goto L16;
        if (this.hashValue == r5.hashValue) goto L24;
        return false;
    L24:
        X509CRLInternal r3 = getInternalCRL();
        r4 = r5.getInternalCRL();
    L26:
        return r3.equals(r4);
    L16:
        if (this.internalCRLValue != null) goto L18;
    L19:
        ASN1BitString r0 = this.c.getSignature();
        if (r0 == null) goto L24;
        if (r0.equals(r5.c.getSignature()) == true) goto L24;
        return false;
    L18:
        if (r5.internalCRLValue != null) goto L24;
    L27:
        r3 = getInternalCRL();
        goto L26
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() {
        return Arrays.clone(getInternalCRL().getEncoded());
    }

    @Override // java.security.cert.X509CRL
    public int hashCode() {
        if (this.hashValueSet == true) goto L6;
        this.hashValue = getInternalCRL().hashCode();
        this.hashValueSet = true;
    L6:
        return this.hashValue;
    }
}
