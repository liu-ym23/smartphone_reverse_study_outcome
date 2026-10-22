package org.bouncycastle.cert;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class X509CRLHolder implements Serializable, Encodable {
    private static final long serialVersionUID = 20170722001L;
    private transient Extensions extensions;
    private transient boolean isIndirect;
    private transient GeneralNames issuerName;
    private transient CertificateList x509CRL;

    public X509CRLHolder(InputStream r1) {
        this(parseStream(r1));
    }

    public X509CRLHolder(CertificateList r1) {
        init(r1);
    }

    public X509CRLHolder(byte[] r2) {
        this(parseStream(new ByteArrayInputStream(r2)));
    }

    private void init(CertificateList r3) {
        this.x509CRL = r3;
        Extensions r0 = r3.getTBSCertList().getExtensions();
        this.extensions = r0;
        this.isIndirect = isIndirectCRL(r0);
        this.issuerName = new GeneralNames(new GeneralName(r3.getIssuer()));
    }

    private static boolean isIndirectCRL(Extensions r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Extension r3 = r2.getExtension(Extension.issuingDistributionPoint);
        if (r3 != null) goto L8;
        return false;
    L8:
        if (IssuingDistributionPoint.getInstance(r3.getParsedValue()).isIndirectCRL() == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static CertificateList parseStream(InputStream r3) {
        ASN1Primitive r4 = new ASN1InputStream(r3, true).readObject();     // Catch: IllegalArgumentException -> L9 ClassCastException -> L12
        if (r4 == null) goto L8;
        return CertificateList.getInstance(r4);
    L8:
        throw new IOException("no content found");     // Catch: IllegalArgumentException -> L9 ClassCastException -> L12
    L12:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    L9:
        e = move-exception;
        throw new CertIOException("malformed data: " + e.getMessage(), e);
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        init(CertificateList.getInstance(r1.readObject()));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X509CRLHolder.class) == true) goto L10;
        return false;
    L10:
        X509CRLHolder r4 = (X509CRLHolder) ZeusTransformUtils.preCheckCast(r3, X509CRLHolder.class, "com.obric.memorydata.plugin");
        return this.x509CRL.equals(r4.x509CRL);
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return this.x509CRL.getEncoded();
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
        return X500Name.getInstance(this.x509CRL.getIssuer());
    }

    public Date getNextUpdate() {
        Time r0 = this.x509CRL.getNextUpdate();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDate();
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public X509CRLEntryHolder getRevokedCertificate(BigInteger r6) {
        GeneralNames r0 = this.issuerName;
        Enumeration r1 = this.x509CRL.getRevokedCertificateEnumeration();
    L4:
        if (r1.hasMoreElements() == false) goto L16;
        TBSCertList.CRLEntry r2 = (TBSCertList.CRLEntry) ZeusTransformUtils.preCheckCast(r1.nextElement(), TBSCertList.CRLEntry.class, "com.obric.memorydata.plugin");
        if (r2.getUserCertificate().hasValue(r6) == true) goto L8;
        if (this.isIndirect == false) goto L4;
        if (r2.hasExtensions() == false) goto L4;
        Extension r3 = r2.getExtensions().getExtension(Extension.certificateIssuer);
        if (r3 == null) goto L4;
        r0 = GeneralNames.getInstance(r3.getParsedValue());
        goto L4
    L8:
        return new X509CRLEntryHolder(r2, this.isIndirect, r0);
    L16:
        return null;
    }

    public Collection getRevokedCertificates() {
        ArrayList r1 = new ArrayList(this.x509CRL.getRevokedCertificates().length);
        GeneralNames r0 = this.issuerName;
        Enumeration r2 = this.x509CRL.getRevokedCertificateEnumeration();
    L4:
        if (r2.hasMoreElements() == false) goto L6;
        X509CRLEntryHolder r4 = new X509CRLEntryHolder((TBSCertList.CRLEntry) ZeusTransformUtils.preCheckCast(r2.nextElement(), TBSCertList.CRLEntry.class, "com.obric.memorydata.plugin"), this.isIndirect, r0);
        r1.add(r4);
        r0 = r4.getCertificateIssuer();
        goto L4
    L6:
        return r1;
    }

    public Date getThisUpdate() {
        return this.x509CRL.getThisUpdate().getDate();
    }

    public boolean hasExtensions() {
        if (this.extensions == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.x509CRL.hashCode();
    }

    public boolean isSignatureValid(ContentVerifierProvider r4) {
        ContentVerifierProvider r5 = (ContentVerifierProvider) ZeusTransformUtils.wrapperContextForParams(r4, ContentVerifierProvider.class, "com.obric.memorydata.plugin");
        TBSCertList r0 = this.x509CRL.getTBSCertList();
        if (CertUtils.isAlgIdEqual(r0.getSignature(), this.x509CRL.getSignatureAlgorithm()) == false) goto L11;
        ContentVerifier r6 = r5.get(r0.getSignature());     // Catch: Exception -> L7
        OutputStream r1 = r6.getOutputStream();     // Catch: Exception -> L7
        r0.encodeTo(r1, "DER");     // Catch: Exception -> L7
        r1.close();     // Catch: Exception -> L7
        return r6.verify(this.x509CRL.getSignature().getOctets());
    L7:
        e = move-exception;
        throw new CertException("unable to process signature: " + e.getMessage(), e);
    L11:
        throw new CertException("signature invalid - algorithm identifier mismatch");
    }

    public CertificateList toASN1Structure() {
        return this.x509CRL;
    }
}
