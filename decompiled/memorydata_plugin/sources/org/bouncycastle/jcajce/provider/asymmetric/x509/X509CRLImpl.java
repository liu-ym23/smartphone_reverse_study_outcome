package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.CRLNumber;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
abstract class X509CRLImpl extends X509CRL {
    protected JcaJceHelper bcHelper;
    protected CertificateList c;
    protected boolean isIndirect;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    X509CRLImpl(JcaJceHelper r3, CertificateList r4, String r5, byte[] r6, boolean r7) {
        this.bcHelper = (JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r3, JcaJceHelper.class, "com.obric.memorydata.plugin");
        this.c = r4;
        this.sigAlgName = r5;
        this.sigAlgParams = r6;
        this.isIndirect = r7;
    }

    private void checkSignature(PublicKey r3, Signature r4, ASN1Encodable r5, byte[] r6) {
        PublicKey r7 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        ASN1Encodable r8 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L5;
        X509SignatureUtil.setSignatureParameters(r4, r8);
    L5:
        r4.initVerify(r7);
        BufferedOutputStream r9 = new BufferedOutputStream(OutputStreamFactory.createStream(r4), 512);     // Catch: IOException -> L12
        this.c.getTBSCertList().encodeTo(r9, "DER");     // Catch: IOException -> L12
        r9.close();     // Catch: IOException -> L12
        if (r4.verify(r6) == false) goto L11;
        return;
    L11:
        throw new SignatureException("CRL does not verify with supplied public key.");
    L12:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    private void doVerify(PublicKey r13, SignatureCreator r14) {
        PublicKey r15 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r13, PublicKey.class, "com.obric.memorydata.plugin");
        SignatureCreator r16 = (SignatureCreator) ZeusTransformUtils.wrapperContextForParams(r14, SignatureCreator.class, "com.obric.memorydata.plugin");
        if (this.c.getSignatureAlgorithm().equals(this.c.getTBSCertList().getSignature()) == false) goto L52;
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r15, CompositePublicKey.class) == false) goto L26;
        if (X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm()) == false) goto L26;
        List<PublicKey> r17 = ((CompositePublicKey) ZeusTransformUtils.preCheckCast(r15, CompositePublicKey.class, "com.obric.memorydata.plugin")).getPublicKeys();
        ASN1Sequence r0 = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r6 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
        boolean r7 = false;
    L10:
        if (r5 == r17.size()) goto L21;
        if (r17.get(r5) == null) goto L19;
        AlgorithmIdentifier r8 = AlgorithmIdentifier.getInstance(r0.getObjectAt(r5));
        checkSignature((PublicKey) ZeusTransformUtils.preCheckCast(r17.get(r5), PublicKey.class, "com.obric.memorydata.plugin"), r16.createSignature(X509SignatureUtil.getSignatureName(r8)), r8.getParameters(), DERBitString.getInstance(r6.getObjectAt(r5)).getBytes());     // Catch: SignatureException -> L17
        e = null;
        r7 = true;
    L18:
        if (e == null) goto L19;
        throw e;
    L17:
        e = e;
    L19:
        r5 = r5 + 1;
        goto L10
    L21:
        if (r7 == false) goto L24;
        return;
    L24:
        throw new InvalidKeyException("no matching key found");
    L26:
        if (X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm()) == false) goto L43;
        ASN1Sequence r1 = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r2 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
        boolean r9 = false;
    L29:
        if (r5 == r2.size()) goto L39;
        AlgorithmIdentifier r10 = AlgorithmIdentifier.getInstance(r1.getObjectAt(r5));
        checkSignature(r15, r16.createSignature(X509SignatureUtil.getSignatureName(r10)), r10.getParameters(), DERBitString.getInstance(r2.getObjectAt(r5)).getBytes());     // Catch: SignatureException -> L33 Throwable -> L35
        e = null;
        r9 = true;
    L36:
        if (e != null) goto L38;
        r5 = r5 + 1;
        goto L29
    L38:
        throw e;
    L35:
        e = null;
    L33:
        e = e;
        goto L36
    L39:
        if (r9 == false) goto L42;
        return;
    L42:
        throw new InvalidKeyException("no matching key found");
    L43:
        Signature r18 = r16.createSignature(getSigAlgName());
        byte[] r3 = this.sigAlgParams;
        if (r3 != null) goto L53;
        checkSignature(r15, r18, null, getSignature());
        return;
    L53:
        checkSignature(r15, r18, ASN1Primitive.fromByteArray(r3), getSignature());     // Catch: IOException -> L48
        return;
    L48:
        e = move-exception;
        throw new SignatureException("cannot decode signature parameters: " + e.getMessage());
    L52:
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    private Set getExtensionOIDs(boolean r6) {
        if (getVersion() != 2) goto L13;
        Extensions r5 = this.c.getTBSCertList().getExtensions();
        if (r5 == null) goto L20;
        HashSet r0 = new HashSet();
        Enumeration r1 = r5.oids();
    L8:
        if (r1.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r6 != r5.getExtension(r2).isCritical()) goto L8;
        r0.add(r2.getId());
        goto L8
    L12:
        return r0;
    L20:
        return null;
    L13:
        return null;
    }

    public static byte[] getExtensionOctets(CertificateList r0, String r1) {
        ASN1OctetString r2 = getExtensionValue(r0, r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getOctets();
    }

    public static ASN1OctetString getExtensionValue(CertificateList r1, String r2) {
        Extensions r3 = r1.getTBSCertList().getExtensions();
        if (r3 == null) goto L8;
        Extension r4 = r3.getExtension(new ASN1ObjectIdentifier(r2));
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getExtnValue();
    L8:
        return null;
    }

    private Set loadCRLEntries() {
        HashSet r0 = new HashSet();
        Enumeration r1 = this.c.getRevokedCertificateEnumeration();
        X500Name r2 = null;
    L4:
        if (r1.hasMoreElements() == false) goto L12;
        TBSCertList.CRLEntry r3 = (TBSCertList.CRLEntry) ZeusTransformUtils.preCheckCast(r1.nextElement(), TBSCertList.CRLEntry.class, "com.obric.memorydata.plugin");
        r0.add(new X509CRLEntryObject(r3, this.isIndirect, r2));
        if (this.isIndirect == false) goto L4;
        if (r3.hasExtensions() == false) goto L4;
        Extension r4 = r3.getExtensions().getExtension(Extension.certificateIssuer);
        if (r4 == null) goto L4;
        r2 = X500Name.getInstance(GeneralNames.getInstance(r4.getParsedValue()).getNames()[0].getName());
        goto L4
    L12:
        return r0;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String r3) {
        ASN1OctetString r2 = getExtensionValue(this.c, r3);
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getEncoded();
    L6:
        e = move-exception;
        throw new IllegalStateException("error parsing " + e.toString());
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new X509Principal(X500Name.getInstance(this.c.getIssuer().toASN1Primitive()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.c.getIssuer().getEncoded());
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        Time r0 = this.c.getNextUpdate();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getDate();
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger r7) {
        Enumeration r0 = this.c.getRevokedCertificateEnumeration();
        X500Name r2 = null;
    L4:
        if (r0.hasMoreElements() == false) goto L16;
        TBSCertList.CRLEntry r3 = (TBSCertList.CRLEntry) ZeusTransformUtils.preCheckCast(r0.nextElement(), TBSCertList.CRLEntry.class, "com.obric.memorydata.plugin");
        if (r3.getUserCertificate().hasValue(r7) == true) goto L8;
        if (this.isIndirect == false) goto L4;
        if (r3.hasExtensions() == false) goto L4;
        Extension r4 = r3.getExtensions().getExtension(Extension.certificateIssuer);
        if (r4 == null) goto L4;
        r2 = X500Name.getInstance(GeneralNames.getInstance(r4.getParsedValue()).getNames()[0].getName());
        goto L4
    L8:
        return new X509CRLEntryObject(r3, this.isIndirect, r2);
    L16:
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set r1 = loadCRLEntries();
        if (r1.isEmpty() == false) goto L5;
        return null;
    L5:
        return Collections.unmodifiableSet(r1);
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() {
        return this.c.getTBSCertList().getEncoded("DER");
    L4:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.c.getThisUpdate().getDate();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set r1 = getCriticalExtensionOIDs();
        if (r1 != null) goto L6;
        return false;
    L6:
        r1.remove(Extension.issuingDistributionPoint.getId());
        r1.remove(Extension.deltaCRLIndicator.getId());
        return !r1.isEmpty();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate r9) {
        if (r9.getType().equals("X.509") == false) goto L32;
        Enumeration r0 = this.c.getRevokedCertificateEnumeration();
        X500Name r1 = this.c.getIssuer();
        if (r0.hasMoreElements() == false) goto L30;
        BigInteger r2 = ((X509Certificate) ZeusTransformUtils.preCheckCast(r9, X509Certificate.class, "com.obric.memorydata.plugin")).getSerialNumber();
    L8:
        if (r0.hasMoreElements() == false) goto L30;
        TBSCertList.CRLEntry r5 = TBSCertList.CRLEntry.getInstance(r0.nextElement());
        if (this.isIndirect == false) goto L17;
        if (r5.hasExtensions() == false) goto L17;
        Extension r6 = r5.getExtensions().getExtension(Extension.certificateIssuer);
        if (r6 == null) goto L17;
        r1 = X500Name.getInstance(GeneralNames.getInstance(r6.getParsedValue()).getNames()[0].getName());
    L17:
        if (r5.getUserCertificate().hasValue(r2) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r9, X509Certificate.class) == false) goto L33;
        X500Name r8 = X500Name.getInstance(((X509Certificate) ZeusTransformUtils.preCheckCast(r9, X509Certificate.class, "com.obric.memorydata.plugin")).getIssuerX500Principal().getEncoded());
    L23:
        if (r1.equals(r8) == true) goto L25;
        return false;
    L25:
        return true;
    L33:
        r8 = org.bouncycastle.asn1.x509.Certificate.getInstance(r9.getEncoded()).getIssuer();     // Catch: CertificateEncodingException -> L27
    L27:
        e = move-exception;
        throw new IllegalArgumentException("Cannot process certificate: " + e.getMessage());
    L30:
        return false;
    L32:
        throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
    }

    @Override // java.security.cert.CRL
    public String toString() {
        StringBuffer r1 = new StringBuffer();
        String r2 = Strings.lineSeparator();
        r1.append("              Version: ").append(getVersion()).append(r2);
        r1.append("             IssuerDN: ").append(getIssuerDN()).append(r2);
        r1.append("          This update: ").append(getThisUpdate()).append(r2);
        r1.append("          Next update: ").append(getNextUpdate()).append(r2);
        r1.append("  Signature Algorithm: ").append(getSigAlgName()).append(r2);
        X509SignatureUtil.prettyPrintSignature(getSignature(), r1, r2);
        Extensions r3 = this.c.getTBSCertList().getExtensions();
        if (r3 == null) goto L34;
        Enumeration r4 = r3.oids();
        if (r4.hasMoreElements() == false) goto L9;
        r1.append("           Extensions: ").append(r2);
    L9:
        if (r4.hasMoreElements() == false) goto L34;
        ASN1ObjectIdentifier r5 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        Extension r6 = r3.getExtension(r5);
        if (r6.getExtnValue() != null) goto L12;
        r1.append(r2);
        goto L9
    L12:
        ASN1InputStream r8 = new ASN1InputStream(r6.getExtnValue().getOctets());
        r1.append("                       critical(").append(r6.isCritical()).append(") ");
        if (r5.equals(Extension.cRLNumber) == false) goto L19;
        Object r7 = new CRLNumber(ASN1Integer.getInstance(r8.readObject()).getPositiveValue());     // Catch: Exception -> L32
    L16:
        StringBuffer r9 = r1.append(r7);     // Catch: Exception -> L32
    L17:
        r9.append(r2);     // Catch: Exception -> L32
        goto L9
    L19:
        if (r5.equals(Extension.deltaCRLIndicator) == false) goto L22;
        r9 = r1.append("Base CRL: " + new CRLNumber(ASN1Integer.getInstance(r8.readObject()).getPositiveValue()));     // Catch: Exception -> L32
        goto L17
    L22:
        if (r5.equals(Extension.issuingDistributionPoint) == false) goto L25;
        r7 = IssuingDistributionPoint.getInstance(r8.readObject());     // Catch: Exception -> L32
        goto L16
    L25:
        if (r5.equals(Extension.cRLDistributionPoints) == false) goto L28;
        r7 = CRLDistPoint.getInstance(r8.readObject());     // Catch: Exception -> L32
        goto L16
    L28:
        if (r5.equals(Extension.freshestCRL) == false) goto L30;
        r7 = CRLDistPoint.getInstance(r8.readObject());     // Catch: Exception -> L32
        goto L16
    L30:
        r1.append(r5.getId());     // Catch: Exception -> L32
        r9 = r1.append(" value = ").append(ASN1Dump.dumpAsString(r8.readObject()));     // Catch: Exception -> L32
    L32:
        r1.append(r5.getId());
        r1.append(" value = ").append("*****").append(r2);
    L34:
        Set r10 = getRevokedCertificates();
        if (r10 == null) goto L41;
        Iterator r11 = r10.iterator();
    L38:
        if (r11.hasNext() == false) goto L41;
        r1.append(r11.next());
        r1.append(r2);
    L41:
        return r1.toString();
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r3) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass1(this));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r3, final String r4) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass2(this, r4));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r3, final Provider r4) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass3(this, r4));     // Catch: NoSuchProviderException -> L5
        return;
    L5:
        e = move-exception;
        throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
    }
}
