package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
class X509CRLEntryObject extends X509CRLEntry {
    private TBSCertList.CRLEntry c;
    private X500Name certificateIssuer;
    private volatile int hashValue;
    private volatile boolean hashValueSet;

    public X509CRLEntryObject(TBSCertList.CRLEntry r1, boolean r2, X500Name r3) {
        this.c = r1;
        this.certificateIssuer = loadCertificateIssuer(r2, r3);
    }

    private Extension getExtension(ASN1ObjectIdentifier r1) {
        Extensions r0 = this.c.getExtensions();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getExtension(r1);
    }

    private Set getExtensionOIDs(boolean r6) {
        Extensions r5 = this.c.getExtensions();
        if (r5 == null) goto L11;
        HashSet r0 = new HashSet();
        Enumeration r1 = r5.oids();
    L6:
        if (r1.hasMoreElements() == false) goto L10;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r6 != r5.getExtension(r2).isCritical()) goto L6;
        r0.add(r2.getId());
        goto L6
    L10:
        return r0;
    L11:
        return null;
    }

    private X500Name loadCertificateIssuer(boolean r3, X500Name r4) {
        if (r3 == true) goto L5;
        return null;
    L5:
        Extension r2 = getExtension(Extension.certificateIssuer);
        if (r2 != null) goto L18;
        return r4;
    L18:
        GeneralName[] r5 = GeneralNames.getInstance(r2.getParsedValue()).getNames();     // Catch: Exception -> L17
        int r6 = 0;
    L10:
        if (r6 >= r5.length) goto L16;
        if (r5[r6].getTagNo() == 4) goto L13;
        r6 = r6 + 1;
        goto L10
    L13:
        return X500Name.getInstance(r5[r6].getName());
    L16:
        return null;
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X509CRLEntryObject.class) == false) goto L19;
        X509CRLEntryObject r4 = (X509CRLEntryObject) ZeusTransformUtils.preCheckCast(r3, X509CRLEntryObject.class, "com.obric.memorydata.plugin");
        if (this.hashValueSet == false) goto L17;
        if (r4.hashValueSet == false) goto L17;
        if (this.hashValue == r4.hashValue) goto L17;
        return false;
    L17:
        return this.c.equals(r4.c);
    L19:
        return super.equals(this);
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        if (this.certificateIssuer != null) goto L8;
        return null;
    L8:
        return new X500Principal(this.certificateIssuer.getEncoded());
    L7:
        return null;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509CRLEntry
    public byte[] getEncoded() {
        return this.c.getEncoded("DER");
    L4:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String r3) {
        Extension r2 = getExtension(new ASN1ObjectIdentifier(r3));
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getExtnValue().getEncoded();
    L6:
        e = move-exception;
        throw new IllegalStateException("Exception encoding: " + e.toString());
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return this.c.getRevocationDate().getDate();
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.c.getUserCertificate().getValue();
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        if (this.c.getExtensions() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set r0 = getCriticalExtensionOIDs();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    @Override // java.security.cert.X509CRLEntry
    public int hashCode() {
        if (this.hashValueSet == true) goto L6;
        this.hashValue = super.hashCode();
        this.hashValueSet = true;
    L6:
        return this.hashValue;
    }

    @Override // java.security.cert.X509CRLEntry
    public String toString() {
        StringBuffer r1 = new StringBuffer();
        String r2 = Strings.lineSeparator();
        r1.append("      userCertificate: ").append(getSerialNumber()).append(r2);
        r1.append("       revocationDate: ").append(getRevocationDate()).append(r2);
        r1.append("       certificateIssuer: ").append(getCertificateIssuer()).append(r2);
        Extensions r8 = this.c.getExtensions();
        if (r8 == null) goto L25;
        Enumeration r3 = r8.oids();
        if (r3.hasMoreElements() == false) goto L25;
        StringBuffer r4 = r1.append("   crlEntryExtensions:");
    L7:
        r4.append(r2);
    L9:
        if (r3.hasMoreElements() == false) goto L25;
        ASN1ObjectIdentifier r5 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        Extension r6 = r8.getExtension(r5);
        if (r6.getExtnValue() != null) goto L12;
        r1.append(r2);
        goto L9
    L12:
        ASN1InputStream r7 = new ASN1InputStream(r6.getExtnValue().getOctets());
        r1.append("                       critical(").append(r6.isCritical()).append(") ");
        if (r5.equals(Extension.reasonCode) == false) goto L18;
        StringBuffer r9 = r1.append(CRLReason.getInstance(ASN1Enumerated.getInstance(r7.readObject())));     // Catch: Exception -> L22
    L16:
        r9.append(r2);     // Catch: Exception -> L22
        goto L9
    L18:
        if (r5.equals(Extension.certificateIssuer) == false) goto L20;
        r9 = r1.append("Certificate issuer: ").append(GeneralNames.getInstance(r7.readObject()));     // Catch: Exception -> L22
        goto L16
    L20:
        r1.append(r5.getId());     // Catch: Exception -> L22
        r9 = r1.append(" value = ").append(ASN1Dump.dumpAsString(r7.readObject()));     // Catch: Exception -> L22
    L22:
        r1.append(r5.getId());
        r4 = r1.append(" value = ").append("*****");
    L25:
        return r1.toString();
    }
}
