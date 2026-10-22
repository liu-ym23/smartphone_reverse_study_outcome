package org.bouncycastle.cert;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttCertValidityPeriod;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class X509AttributeCertificateHolder implements Serializable, Encodable {
    private static Attribute[] EMPTY_ARRAY = null;
    private static final long serialVersionUID = 20170722001L;
    private transient AttributeCertificate attrCert;
    private transient Extensions extensions;

    static {
        EMPTY_ARRAY = new Attribute[0];
    }

    public X509AttributeCertificateHolder(AttributeCertificate r1) {
        init(r1);
    }

    public X509AttributeCertificateHolder(byte[] r1) {
        this(parseBytes(r1));
    }

    private void init(AttributeCertificate r1) {
        this.attrCert = r1;
        this.extensions = r1.getAcinfo().getExtensions();
    }

    private static AttributeCertificate parseBytes(byte[] r3) {
        return AttributeCertificate.getInstance(CertUtils.parseNonEmptyASN1(r3));
    L8:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    L5:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        init(AttributeCertificate.getInstance(r1.readObject()));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X509AttributeCertificateHolder.class) == true) goto L10;
        return false;
    L10:
        X509AttributeCertificateHolder r4 = (X509AttributeCertificateHolder) ZeusTransformUtils.preCheckCast(r3, X509AttributeCertificateHolder.class, "com.obric.memorydata.plugin");
        return this.attrCert.equals(r4.attrCert);
    }

    public Attribute[] getAttributes() {
        ASN1Sequence r3 = this.attrCert.getAcinfo().getAttributes();
        Attribute[] r0 = new Attribute[r3.size()];
        int r1 = 0;
    L4:
        if (r1 == r3.size()) goto L6;
        r0[r1] = Attribute.getInstance(r3.getObjectAt(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public Attribute[] getAttributes(ASN1ObjectIdentifier r5) {
        ASN1Sequence r4 = this.attrCert.getAcinfo().getAttributes();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 == r4.size()) goto L10;
        Attribute r2 = Attribute.getInstance(r4.getObjectAt(r1));
        if (r2.getAttrType().equals(r5) == false) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r0.size() != 0) goto L14;
        return EMPTY_ARRAY;
    L14:
        return (Attribute[]) ZeusTransformUtils.preCheckCast((Attribute[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Attribute[r0.size()]), Attribute[].class, "com.obric.memorydata.plugin"), Attribute[].class, "com.obric.memorydata.plugin");
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return this.attrCert.getEncoded();
    }

    public Extension getExtension(ASN1ObjectIdentifier r1) {
        Extensions r0 = this.extensions;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getExtension(r1);
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.extensions);
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public AttributeCertificateHolder getHolder() {
        return new AttributeCertificateHolder((ASN1Sequence) ZeusTransformUtils.preCheckCast(this.attrCert.getAcinfo().getHolder().toASN1Primitive(), ASN1Sequence.class, "com.obric.memorydata.plugin"));
    }

    public AttributeCertificateIssuer getIssuer() {
        return new AttributeCertificateIssuer(this.attrCert.getAcinfo().getIssuer());
    }

    public boolean[] getIssuerUniqueID() {
        return CertUtils.bitStringToBoolean(this.attrCert.getAcinfo().getIssuerUniqueID());
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public Date getNotAfter() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime());
    }

    public Date getNotBefore() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime());
    }

    public BigInteger getSerialNumber() {
        return this.attrCert.getAcinfo().getSerialNumber().getValue();
    }

    public byte[] getSignature() {
        return this.attrCert.getSignatureValue().getOctets();
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.attrCert.getSignatureAlgorithm();
    }

    public int getVersion() {
        return this.attrCert.getAcinfo().getVersion().intValueExact() + 1;
    }

    public boolean hasExtensions() {
        if (this.extensions == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.attrCert.hashCode();
    }

    public boolean isSignatureValid(ContentVerifierProvider r4) {
        ContentVerifierProvider r5 = (ContentVerifierProvider) ZeusTransformUtils.wrapperContextForParams(r4, ContentVerifierProvider.class, "com.obric.memorydata.plugin");
        AttributeCertificateInfo r0 = this.attrCert.getAcinfo();
        if (CertUtils.isAlgIdEqual(r0.getSignature(), this.attrCert.getSignatureAlgorithm()) == false) goto L11;
        ContentVerifier r6 = r5.get(r0.getSignature());     // Catch: Exception -> L7
        OutputStream r1 = r6.getOutputStream();     // Catch: Exception -> L7
        r0.encodeTo(r1, "DER");     // Catch: Exception -> L7
        r1.close();     // Catch: Exception -> L7
        return r6.verify(getSignature());
    L7:
        e = move-exception;
        throw new CertException("unable to process signature: " + e.getMessage(), e);
    L11:
        throw new CertException("signature invalid - algorithm identifier mismatch");
    }

    public boolean isValidOn(Date r2) {
        AttCertValidityPeriod r1 = this.attrCert.getAcinfo().getAttrCertValidityPeriod();
        if (r2.before(CertUtils.recoverDate(r1.getNotBeforeTime())) == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.after(CertUtils.recoverDate(r1.getNotAfterTime())) == true) goto L7;
        return true;
    }

    public AttributeCertificate toASN1Structure() {
        return this.attrCert;
    }
}
