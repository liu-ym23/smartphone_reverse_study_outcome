package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.NetscapeCertType;
import org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import org.bouncycastle.asn1.misc.VerisignCzagExtension;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier;
    private BasicConstraints basicConstraints;
    private Certificate c;
    private int hashValue;
    private boolean hashValueSet;
    private boolean[] keyUsage;

    public X509CertificateObject(Certificate r8) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.c = r8;
        byte[] r9 = getExtensionBytes("2.5.29.19");     // Catch: Exception -> L24
        if (r9 == null) goto L29;
        this.basicConstraints = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(r9));     // Catch: Exception -> L24
    L29:
        byte[] r10 = getExtensionBytes("2.5.29.15");     // Catch: Exception -> L21
        if (r10 == null) goto L19;
        DERBitString r11 = DERBitString.getInstance(ASN1Primitive.fromByteArray(r10));     // Catch: Exception -> L21
        byte[] r0 = r11.getBytes();     // Catch: Exception -> L21
        int r1 = (r0.length * 8) - r11.getPadBits();     // Catch: Exception -> L21
        int r12 = 9;
        if (r1 < 9) goto L12;
        r12 = r1;
    L12:
        this.keyUsage = new boolean[r12];     // Catch: Exception -> L21
        int r2 = 0;
    L13:
        if (r2 == r1) goto L33;
        boolean[] r3 = this.keyUsage;     // Catch: Exception -> L21
        if ((r0[r2 / 8] & (128 >>> (r2 % 8))) == 0) goto L17;
        boolean r4 = true;
    L18:
        r3[r2] = r4;     // Catch: Exception -> L21
        r2 = r2 + 1;     // Catch: Exception -> L21
        goto L13
    L17:
        r4 = false;
        goto L18
    L33:
        return;
    L19:
        this.keyUsage = null;     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        throw new CertificateParsingException("cannot construct KeyUsage: " + e);
    L24:
        e = move-exception;
        throw new CertificateParsingException("cannot construct BasicConstraints: " + e);
    }

    private int calculateHashCode() {
        byte[] r4 = getEncoded();     // Catch: CertificateEncodingException -> L9
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

    private void checkSignature(PublicKey r3, Signature r4) {
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        if (isAlgIdEqual(this.c.getSignatureAlgorithm(), this.c.getTBSCertificate().getSignature()) == false) goto L10;
        X509SignatureUtil.setSignatureParameters(r4, this.c.getSignatureAlgorithm().getParameters());
        r4.initVerify(r5);
        r4.update(getTBSCertificate());
        if (r4.verify(getSignature()) == false) goto L8;
        return;
    L8:
        throw new SignatureException("certificate does not verify with supplied key");
    L10:
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    private static Collection getAlternativeNames(byte[] r6) {
        if (r6 != null) goto L33;
        return null;
    L33:
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L27
        Enumeration r7 = ASN1Sequence.getInstance(r6).getObjects();     // Catch: Exception -> L27
    L7:
        if (r7.hasMoreElements() == false) goto L23;
        GeneralName r2 = GeneralName.getInstance(r7.nextElement());     // Catch: Exception -> L27
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L27
        r3.add(Integers.valueOf(r2.getTagNo()));     // Catch: Exception -> L27
        switch(r2.getTagNo()) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L31;
            case 8: goto L11;
            default: goto L21;
        };     // Catch: Exception -> L27
    L31:
        String r4 = InetAddress.getByAddress(DEROctetString.getInstance(r2.getName()).getOctets()).getHostAddress();     // Catch: UnknownHostException -> L30 Exception -> L27
    L12:
        r3.add(r4);     // Catch: Exception -> L27
    L19:
        r1.add(Collections.unmodifiableList(r3));     // Catch: Exception -> L27
        goto L7
    L21:
        throw new IOException("Bad tag number: " + r2.getTagNo());     // Catch: Exception -> L27
    L11:
        r4 = ASN1ObjectIdentifier.getInstance(r2.getName()).getId();     // Catch: Exception -> L27
        goto L12
    L16:
        r4 = X500Name.getInstance(RFC4519Style.INSTANCE, r2.getName()).toString();     // Catch: Exception -> L27
        goto L12
    L17:
        r4 = ((ASN1String) ZeusTransformUtils.preCheckCast(r2.getName(), ASN1String.class, "com.obric.memorydata.plugin")).getString();     // Catch: Exception -> L27
        goto L12
    L18:
        r3.add(r2.getEncoded());     // Catch: Exception -> L27
        goto L19
    L23:
        if (r1.size() != 0) goto L26;
        return null;
    L26:
        return Collections.unmodifiableCollection(r1);
    L27:
        e = move-exception;
        throw new CertificateParsingException(e.getMessage());
    }

    private byte[] getExtensionBytes(String r2) {
        Extensions r1 = this.c.getTBSCertificate().getExtensions();
        if (r1 == null) goto L8;
        Extension r3 = r1.getExtension(new ASN1ObjectIdentifier(r2));
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getExtnValue().getOctets();
    L8:
        return null;
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier r3, AlgorithmIdentifier r4) {
        if (r3.getAlgorithm().equals(r4.getAlgorithm()) == true) goto L6;
        return false;
    L6:
        if (r3.getParameters() != null) goto L14;
        if (r4.getParameters() != null) goto L10;
    L12:
        return true;
    L10:
        if (r4.getParameters().equals(DERNull.INSTANCE) == true) goto L12;
        return false;
    L14:
        if (r4.getParameters() != null) goto L22;
        if (r3.getParameters() != null) goto L18;
    L20:
        return true;
    L18:
        if (r3.getParameters().equals(DERNull.INSTANCE) == true) goto L20;
        return false;
    L22:
        return r3.getParameters().equals(r4.getParameters());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date r5) {
        if (r5.getTime() > getNotAfter().getTime()) goto L10;
        if (r5.getTime() < getNotBefore().getTime()) goto L8;
        return;
    L8:
        throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
    L10:
        throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, java.security.cert.Certificate.class) == true) goto L8;
        return false;
    L8:
        java.security.cert.Certificate r5 = (java.security.cert.Certificate) ZeusTransformUtils.preCheckCast(r4, java.security.cert.Certificate.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(getEncoded(), r5.getEncoded());
    L11:
        return false;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1) {
        return this.attrCarrier.getBagAttribute(r1);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraints r0 = this.basicConstraints;
        if (r0 != null) goto L5;
    L12:
        return -1;
    L5:
        if (r0.isCA() == false) goto L12;
        if (this.basicConstraints.getPathLenConstraint() != null) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return this.basicConstraints.getPathLenConstraint().intValue();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) goto L13;
        HashSet r0 = new HashSet();
        Extensions r5 = this.c.getTBSCertificate().getExtensions();
        if (r5 == null) goto L20;
        Enumeration r1 = r5.oids();
    L8:
        if (r1.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r5.getExtension(r2).isCritical() == false) goto L8;
        r0.add(r2.getId());
        goto L8
    L12:
        return r0;
    L20:
        return null;
    L13:
        return null;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        return this.c.getEncoded("DER");
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() {
        byte[] r5 = getExtensionBytes("2.5.29.37");
        if (r5 != null) goto L14;
        return null;
    L14:
        ASN1Sequence r6 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(new ASN1InputStream(r5).readObject(), ASN1Sequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L10
        int r2 = 0;
    L6:
        if (r2 == r6.size()) goto L8;
        r1.add(((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")).getId());     // Catch: Exception -> L10
        r2 = r2 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Collections.unmodifiableList(r1);
    L11:
        throw new CertificateParsingException("error processing extended key usage extension");
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String r3) {
        Extensions r2 = this.c.getTBSCertificate().getExtensions();
        if (r2 == null) goto L11;
        Extension r4 = r2.getExtension(new ASN1ObjectIdentifier(r3));
        if (r4 == null) goto L15;
        return r4.getExtnValue().getEncoded();
    L8:
        e = move-exception;
        throw new IllegalStateException("error parsing " + e.toString());
    L15:
        return null;
    L11:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() {
        return getAlternativeNames(getExtensionBytes(Extension.issuerAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new X509Principal(this.c.getIssuer());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        ASN1BitString r7 = this.c.getTBSCertificate().getIssuerUniqueId();
        if (r7 == null) goto L12;
        byte[] r0 = r7.getBytes();
        int r1 = (r0.length * 8) - r7.getPadBits();
        boolean[] r8 = new boolean[r1];
        int r3 = 0;
    L5:
        if (r3 == r1) goto L11;
        if ((r0[r3 / 8] & (128 >>> (r3 % 8))) == 0) goto L9;
        boolean r4 = true;
    L10:
        r8[r3] = r4;
        r3 = r3 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L11:
        return r8;
    L12:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.c.getIssuer().getEncoded());
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) goto L13;
        HashSet r0 = new HashSet();
        Extensions r5 = this.c.getTBSCertificate().getExtensions();
        if (r5 == null) goto L20;
        Enumeration r1 = r5.oids();
    L8:
        if (r1.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r5.getExtension(r2).isCritical() == true) goto L8;
        r0.add(r2.getId());
        goto L8
    L12:
        return r0;
    L20:
        return null;
    L13:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.c.getEndDate().getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.c.getStartDate().getDate();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return BouncyCastleProvider.getPublicKey(this.c.getSubjectPublicKeyInfo());
    L4:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.c.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        Provider r0 = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (r0 == null) goto L7;
        String r1 = r0.getProperty("Alg.Alias.Signature." + getSigAlgOID());
        if (r1 == null) goto L7;
        return r1;
    L7:
        Provider[] r2 = Security.getProviders();
        int r3 = 0;
    L9:
        if (r3 == r2.length) goto L15;
        String r4 = r2[r3].getProperty("Alg.Alias.Signature." + getSigAlgOID());
        if (r4 != null) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return r4;
    L15:
        return getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.c.getSignatureAlgorithm().getParameters() != null) goto L8;
    L6:
        return null;
    L8:
        return this.c.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded("DER");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() {
        return getAlternativeNames(getExtensionBytes(Extension.subjectAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(this.c.getSubject());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        ASN1BitString r7 = this.c.getTBSCertificate().getSubjectUniqueId();
        if (r7 == null) goto L12;
        byte[] r0 = r7.getBytes();
        int r1 = (r0.length * 8) - r7.getPadBits();
        boolean[] r8 = new boolean[r1];
        int r3 = 0;
    L5:
        if (r3 == r1) goto L11;
        if ((r0[r3 / 8] & (128 >>> (r3 % 8))) == 0) goto L9;
        boolean r4 = true;
    L10:
        r8[r3] = r4;
        r3 = r3 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L11:
        return r8;
    L12:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.c.getSubject().getEncoded());
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        return this.c.getTBSCertificate().getEncoded("DER");
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        if (getVersion() != 3) goto L36;
        Extensions r4 = this.c.getTBSCertificate().getExtensions();
        if (r4 == null) goto L64;
        Enumeration r0 = r4.oids();
    L8:
        if (r0.hasMoreElements() == false) goto L65;
        ASN1ObjectIdentifier r1 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r0.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        String r2 = r1.getId();
        if (r2.equals(RFC3280CertPathUtilities.KEY_USAGE) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.CERTIFICATE_POLICIES) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.POLICY_MAPPINGS) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.POLICY_CONSTRAINTS) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.BASIC_CONSTRAINTS) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME) == true) goto L8;
        if (r2.equals(RFC3280CertPathUtilities.NAME_CONSTRAINTS) == true) goto L8;
        if (r4.getExtension(r1).isCritical() == false) goto L8;
        return true;
    L65:
        return false;
    L64:
        return false;
    L36:
        return false;
    }

    @Override // java.security.cert.Certificate
    public synchronized int hashCode() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.hashValueSet == true) goto L6;
        this.hashValue = calculateHashCode();     // Catch: Throwable -> L9
        this.hashValueSet = true;     // Catch: Throwable -> L9
    L6:
        int r0 = this.hashValue;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        StringBuffer r1 = new StringBuffer();
        String r2 = Strings.lineSeparator();
        r1.append("  [0]         Version: ").append(getVersion()).append(r2);
        r1.append("         SerialNumber: ").append(getSerialNumber()).append(r2);
        r1.append("             IssuerDN: ").append(getIssuerDN()).append(r2);
        r1.append("           Start Date: ").append(getNotBefore()).append(r2);
        r1.append("           Final Date: ").append(getNotAfter()).append(r2);
        r1.append("            SubjectDN: ").append(getSubjectDN()).append(r2);
        r1.append("           Public Key: ").append(getPublicKey()).append(r2);
        r1.append("  Signature Algorithm: ").append(getSigAlgName()).append(r2);
        byte[] r3 = getSignature();
        r1.append("            Signature: ").append(new String(Hex.encode(r3, 0, 20))).append(r2);
        int r4 = 20;
    L4:
        if (r4 >= r3.length) goto L10;
        if (r4 >= (r3.length - 20)) goto L8;
        StringBuffer r5 = r1.append("                       ");
        String r6 = new String(Hex.encode(r3, r4, 20));
    L9:
        r5.append(r6).append(r2);
        r4 = r4 + 20;
        goto L4
    L8:
        r5 = r1.append("                       ");
        r6 = new String(Hex.encode(r3, r4, r3.length - r4));
        goto L9
    L10:
        Extensions r9 = this.c.getTBSCertificate().getExtensions();
        if (r9 == null) goto L42;
        Enumeration r7 = r9.oids();
        if (r7.hasMoreElements() == false) goto L16;
        r1.append("       Extensions: \n");
    L16:
        if (r7.hasMoreElements() == false) goto L42;
        ASN1ObjectIdentifier r8 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r7.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        Extension r10 = r9.getExtension(r8);
        if (r10.getExtnValue() != null) goto L19;
        r1.append(r2);
        goto L16
    L19:
        ASN1InputStream r11 = new ASN1InputStream(r10.getExtnValue().getOctets());
        r1.append("                       critical(").append(r10.isCritical()).append(") ");
        if (r8.equals(Extension.basicConstraints) == false) goto L26;
        Object r12 = BasicConstraints.getInstance(r11.readObject());     // Catch: Exception -> L39
    L23:
        StringBuffer r13 = r1.append(r12);     // Catch: Exception -> L39
    L24:
        r13.append(r2);     // Catch: Exception -> L39
        goto L16
    L26:
        if (r8.equals(Extension.keyUsage) == false) goto L29;
        r12 = KeyUsage.getInstance(r11.readObject());     // Catch: Exception -> L39
        goto L23
    L29:
        if (r8.equals(MiscObjectIdentifiers.netscapeCertType) == false) goto L32;
        r12 = new NetscapeCertType((DERBitString) ZeusTransformUtils.preCheckCast(r11.readObject(), DERBitString.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        goto L23
    L32:
        if (r8.equals(MiscObjectIdentifiers.netscapeRevocationURL) == false) goto L35;
        r12 = new NetscapeRevocationURL((ASN1IA5String) ZeusTransformUtils.preCheckCast(r11.readObject(), ASN1IA5String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        goto L23
    L35:
        if (r8.equals(MiscObjectIdentifiers.verisignCzagExtension) == false) goto L37;
        r12 = new VerisignCzagExtension((ASN1IA5String) ZeusTransformUtils.preCheckCast(r11.readObject(), ASN1IA5String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        goto L23
    L37:
        r1.append(r8.getId());     // Catch: Exception -> L39
        r13 = r1.append(" value = ").append(ASN1Dump.dumpAsString(r11.readObject()));     // Catch: Exception -> L39
    L39:
        r1.append(r8.getId());
        r1.append(" value = ").append("*****").append(r2);
    L42:
        return r1.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r3) {
        PublicKey r4 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        String r0 = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
        Signature r1 = Signature.getInstance(r0, BouncyCastleProvider.PROVIDER_NAME);     // Catch: Exception -> L5
    L6:
        checkSignature(r4, r1);
        return;
    L5:
        r1 = Signature.getInstance(r0);
        goto L6
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r3, String r4) {
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        String r0 = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
        if (r4 == null) goto L5;
        Signature r6 = Signature.getInstance(r0, r4);
    L6:
        checkSignature(r5, r6);
        return;
    L5:
        r6 = Signature.getInstance(r0);
        goto L6
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey r3, Provider r4) {
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        String r0 = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
        if (r4 == null) goto L5;
        Signature r6 = Signature.getInstance(r0, r4);
    L6:
        checkSignature(r5, r6);
        return;
    L5:
        r6 = Signature.getInstance(r0);
        goto L6
    }
}
