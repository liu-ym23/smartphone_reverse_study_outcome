package org.bouncycastle.cert;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class X509CertificateHolder implements Serializable, Encodable {
    private static final long serialVersionUID = 20170722001L;
    private transient Extensions extensions;
    private transient Certificate x509Certificate;

    public X509CertificateHolder(Certificate r1) {
        init(r1);
    }

    public X509CertificateHolder(byte[] r1) {
        this(parseBytes(r1));
    }

    private void init(Certificate r1) {
        this.x509Certificate = r1;
        this.extensions = r1.getTBSCertificate().getExtensions();
    }

    private static Certificate parseBytes(byte[] r3) {
        return Certificate.getInstance(CertUtils.parseNonEmptyASN1(r3));
    L8:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    L5:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        init(Certificate.getInstance(r1.readObject()));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X509CertificateHolder.class) == true) goto L10;
        return false;
    L10:
        X509CertificateHolder r4 = (X509CertificateHolder) ZeusTransformUtils.preCheckCast(r3, X509CertificateHolder.class, "com.obric.memorydata.plugin");
        return this.x509Certificate.equals(r4.x509Certificate);
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return this.x509Certificate.getEncoded();
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

    public X500Name getIssuer() {
        return X500Name.getInstance(this.x509Certificate.getIssuer());
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public Date getNotAfter() {
        return this.x509Certificate.getEndDate().getDate();
    }

    public Date getNotBefore() {
        return this.x509Certificate.getStartDate().getDate();
    }

    public BigInteger getSerialNumber() {
        return this.x509Certificate.getSerialNumber().getValue();
    }

    public byte[] getSignature() {
        return this.x509Certificate.getSignature().getOctets();
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.x509Certificate.getSignatureAlgorithm();
    }

    public X500Name getSubject() {
        return X500Name.getInstance(this.x509Certificate.getSubject());
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.x509Certificate.getSubjectPublicKeyInfo();
    }

    public int getVersion() {
        return this.x509Certificate.getVersionNumber();
    }

    public int getVersionNumber() {
        return this.x509Certificate.getVersionNumber();
    }

    public boolean hasExtensions() {
        if (this.extensions == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.x509Certificate.hashCode();
    }

    public boolean isSignatureValid(ContentVerifierProvider r4) {
        ContentVerifierProvider r5 = (ContentVerifierProvider) ZeusTransformUtils.wrapperContextForParams(r4, ContentVerifierProvider.class, "com.obric.memorydata.plugin");
        TBSCertificate r0 = this.x509Certificate.getTBSCertificate();
        if (CertUtils.isAlgIdEqual(r0.getSignature(), this.x509Certificate.getSignatureAlgorithm()) == false) goto L11;
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
        if (r2.before(this.x509Certificate.getStartDate().getDate()) == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.after(this.x509Certificate.getEndDate().getDate()) == true) goto L7;
        return true;
    }

    public Certificate toASN1Structure() {
        return this.x509Certificate;
    }
}
