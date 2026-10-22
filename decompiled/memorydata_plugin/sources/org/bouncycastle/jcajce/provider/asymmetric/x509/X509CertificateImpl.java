package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
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
import org.bouncycastle.asn1.ASN1OctetString;
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
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
abstract class X509CertificateImpl extends X509Certificate {
    protected BasicConstraints basicConstraints;
    protected JcaJceHelper bcHelper;
    protected Certificate c;
    protected boolean[] keyUsage;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    X509CertificateImpl(JcaJceHelper r3, Certificate r4, BasicConstraints r5, boolean[] r6, String r7, byte[] r8) {
        this.bcHelper = (JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r3, JcaJceHelper.class, "com.obric.memorydata.plugin");
        this.c = r4;
        this.basicConstraints = r5;
        this.keyUsage = r6;
        this.sigAlgName = r7;
        this.sigAlgParams = r8;
    }

    private void checkSignature(PublicKey r3, Signature r4, ASN1Encodable r5, byte[] r6) {
        PublicKey r7 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        ASN1Encodable r8 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (isAlgIdEqual(this.c.getSignatureAlgorithm(), this.c.getTBSCertificate().getSignature()) == false) goto L15;
        X509SignatureUtil.setSignatureParameters(r4, r8);
        r4.initVerify(r7);
        BufferedOutputStream r9 = new BufferedOutputStream(OutputStreamFactory.createStream(r4), 512);     // Catch: IOException -> L11
        this.c.getTBSCertificate().encodeTo(r9, "DER");     // Catch: IOException -> L11
        r9.close();     // Catch: IOException -> L11
        if (r4.verify(r6) == false) goto L10;
        return;
    L10:
        throw new SignatureException("certificate does not verify with supplied key");
    L11:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    L15:
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    private void doVerify(PublicKey r13, SignatureCreator r14) {
        PublicKey r15 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r13, PublicKey.class, "com.obric.memorydata.plugin");
        SignatureCreator r16 = (SignatureCreator) ZeusTransformUtils.wrapperContextForParams(r14, SignatureCreator.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r15, CompositePublicKey.class) == false) goto L24;
        if (X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm()) == false) goto L24;
        List<PublicKey> r17 = ((CompositePublicKey) ZeusTransformUtils.preCheckCast(r15, CompositePublicKey.class, "com.obric.memorydata.plugin")).getPublicKeys();
        ASN1Sequence r0 = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r6 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
        boolean r7 = false;
    L8:
        if (r5 == r17.size()) goto L19;
        if (r17.get(r5) == null) goto L17;
        AlgorithmIdentifier r8 = AlgorithmIdentifier.getInstance(r0.getObjectAt(r5));
        checkSignature((PublicKey) ZeusTransformUtils.preCheckCast(r17.get(r5), PublicKey.class, "com.obric.memorydata.plugin"), r16.createSignature(X509SignatureUtil.getSignatureName(r8)), r8.getParameters(), DERBitString.getInstance(r6.getObjectAt(r5)).getBytes());     // Catch: SignatureException -> L15
        e = null;
        r7 = true;
    L16:
        if (e == null) goto L17;
        throw e;
    L15:
        e = e;
    L17:
        r5 = r5 + 1;
        goto L8
    L19:
        if (r7 == false) goto L22;
        return;
    L22:
        throw new InvalidKeyException("no matching key found");
    L24:
        if (X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm()) == false) goto L41;
        ASN1Sequence r1 = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r2 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
        boolean r9 = false;
    L27:
        if (r5 == r2.size()) goto L37;
        AlgorithmIdentifier r10 = AlgorithmIdentifier.getInstance(r1.getObjectAt(r5));
        checkSignature(r15, r16.createSignature(X509SignatureUtil.getSignatureName(r10)), r10.getParameters(), DERBitString.getInstance(r2.getObjectAt(r5)).getBytes());     // Catch: SignatureException -> L31 Throwable -> L33
        e = null;
        r9 = true;
    L34:
        if (e != null) goto L36;
        r5 = r5 + 1;
        goto L27
    L36:
        throw e;
    L33:
        e = null;
    L31:
        e = e;
        goto L34
    L37:
        if (r9 == false) goto L40;
        return;
    L40:
        throw new InvalidKeyException("no matching key found");
    L41:
        Signature r18 = r16.createSignature(X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm()));
        if (ZeusTransformUtils.instanceOf(r15, CompositePublicKey.class) == false) goto L51;
        List<PublicKey> r19 = ((CompositePublicKey) ZeusTransformUtils.preCheckCast(r15, CompositePublicKey.class, "com.obric.memorydata.plugin")).getPublicKeys();
    L45:
        if (r5 == r19.size()) goto L50;
        checkSignature((PublicKey) ZeusTransformUtils.preCheckCast(r19.get(r5), PublicKey.class, "com.obric.memorydata.plugin"), r18, this.c.getSignatureAlgorithm().getParameters(), getSignature());     // Catch: InvalidKeyException -> L48
        return;
    L48:
        r5 = r5 + 1;
        goto L45
    L50:
        throw new InvalidKeyException("no matching signature found");
    L51:
        checkSignature(r15, r18, this.c.getSignatureAlgorithm().getParameters(), getSignature());
    }

    private static Collection getAlternativeNames(Certificate r5, String r6) {
        byte[] r7 = getExtensionOctets(r5, r6);
        if (r7 != null) goto L31;
        return null;
    L31:
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L27
        Enumeration r8 = ASN1Sequence.getInstance(r7).getObjects();     // Catch: Exception -> L27
    L7:
        if (r8.hasMoreElements() == false) goto L23;
        GeneralName r1 = GeneralName.getInstance(r8.nextElement());     // Catch: Exception -> L27
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L27
        r2.add(Integers.valueOf(r1.getTagNo()));     // Catch: Exception -> L27
        switch(r1.getTagNo()) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L32;
            case 8: goto L11;
            default: goto L21;
        };     // Catch: Exception -> L27
    L32:
        String r3 = InetAddress.getByAddress(DEROctetString.getInstance(r1.getName()).getOctets()).getHostAddress();     // Catch: UnknownHostException -> L30 Exception -> L27
    L12:
        r2.add(r3);     // Catch: Exception -> L27
    L19:
        r0.add(Collections.unmodifiableList(r2));     // Catch: Exception -> L27
        goto L7
    L21:
        throw new IOException("Bad tag number: " + r1.getTagNo());     // Catch: Exception -> L27
    L11:
        r3 = ASN1ObjectIdentifier.getInstance(r1.getName()).getId();     // Catch: Exception -> L27
        goto L12
    L16:
        r3 = X500Name.getInstance(RFC4519Style.INSTANCE, r1.getName()).toString();     // Catch: Exception -> L27
        goto L12
    L17:
        r3 = ((ASN1String) ZeusTransformUtils.preCheckCast(r1.getName(), ASN1String.class, "com.obric.memorydata.plugin")).getString();     // Catch: Exception -> L27
        goto L12
    L18:
        r2.add(r1.getEncoded());     // Catch: Exception -> L27
        goto L19
    L23:
        if (r0.size() != 0) goto L26;
        return null;
    L26:
        return Collections.unmodifiableCollection(r0);
    L27:
        e = move-exception;
        throw new CertificateParsingException(e.getMessage());
    }

    public static byte[] getExtensionOctets(Certificate r0, String r1) {
        ASN1OctetString r2 = getExtensionValue(r0, r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getOctets();
    }

    public static ASN1OctetString getExtensionValue(Certificate r1, String r2) {
        Extensions r3 = r1.getTBSCertificate().getExtensions();
        if (r3 == null) goto L8;
        Extension r4 = r3.getExtension(new ASN1ObjectIdentifier(r2));
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getExtnValue();
    L8:
        return null;
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier r3, AlgorithmIdentifier r4) {
        if (r3.getAlgorithm().equals(r4.getAlgorithm()) == true) goto L6;
        return false;
    L6:
        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_absent_equiv_NULL") == false) goto L24;
        if (r3.getParameters() != null) goto L16;
        if (r4.getParameters() != null) goto L12;
    L14:
        return true;
    L12:
        if (r4.getParameters().equals(DERNull.INSTANCE) == true) goto L14;
        return false;
    L16:
        if (r4.getParameters() != null) goto L24;
        if (r3.getParameters() != null) goto L20;
    L22:
        return true;
    L20:
        if (r3.getParameters().equals(DERNull.INSTANCE) == true) goto L22;
        return false;
    L24:
        if (r3.getParameters() == null) goto L29;
        ASN1Encodable r2 = r3.getParameters();
        ASN1Encodable r5 = r4.getParameters();
    L27:
        return r2.equals(r5);
    L29:
        if (r4.getParameters() == null) goto L31;
        r2 = r4.getParameters();
        r5 = r3.getParameters();
        goto L27
    L31:
        return true;
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

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() {
        byte[] r5 = getExtensionOctets(this.c, "2.5.29.37");
        if (r5 != null) goto L14;
        return null;
    L14:
        ASN1Sequence r6 = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(r5));     // Catch: Exception -> L12
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L12
        int r1 = 0;
    L8:
        if (r1 == r6.size()) goto L10;
        r0.add(((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r1), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")).getId());     // Catch: Exception -> L12
        r1 = r1 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        return Collections.unmodifiableList(r0);
    L13:
        throw new CertificateParsingException("error processing extended key usage extension");
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

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() {
        return getAlternativeNames(this.c, Extension.issuerAlternativeName.getId());
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

    public X500Name getIssuerX500Name() {
        return this.c.getIssuer();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.c.getIssuer().getEncoded("DER"));
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return Arrays.clone(this.keyUsage);
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
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() {
        return getAlternativeNames(this.c, Extension.subjectAlternativeName.getId());
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

    public X500Name getSubjectX500Name() {
        return this.c.getSubject();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.c.getSubject().getEncoded("DER"));
    L5:
        throw new IllegalStateException("can't encode subject DN");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        return this.c.getTBSCertificate().getEncoded("DER");
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    public TBSCertificate getTBSCertificateNative() {
        return this.c.getTBSCertificate();
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
        if (r1.equals(Extension.keyUsage) == true) goto L8;
        if (r1.equals(Extension.certificatePolicies) == true) goto L8;
        if (r1.equals(Extension.policyMappings) == true) goto L8;
        if (r1.equals(Extension.inhibitAnyPolicy) == true) goto L8;
        if (r1.equals(Extension.cRLDistributionPoints) == true) goto L8;
        if (r1.equals(Extension.issuingDistributionPoint) == true) goto L8;
        if (r1.equals(Extension.deltaCRLIndicator) == true) goto L8;
        if (r1.equals(Extension.policyConstraints) == true) goto L8;
        if (r1.equals(Extension.basicConstraints) == true) goto L8;
        if (r1.equals(Extension.subjectAlternativeName) == true) goto L8;
        if (r1.equals(Extension.nameConstraints) == true) goto L8;
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
        X509SignatureUtil.prettyPrintSignature(getSignature(), r1, r2);
        Extensions r8 = this.c.getTBSCertificate().getExtensions();
        if (r8 == null) goto L34;
        Enumeration r3 = r8.oids();
        if (r3.hasMoreElements() == false) goto L8;
        r1.append("       Extensions: \n");
    L8:
        if (r3.hasMoreElements() == false) goto L34;
        ASN1ObjectIdentifier r4 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        Extension r5 = r8.getExtension(r4);
        if (r5.getExtnValue() != null) goto L11;
        r1.append(r2);
        goto L8
    L11:
        ASN1InputStream r7 = new ASN1InputStream(r5.getExtnValue().getOctets());
        r1.append("                       critical(").append(r5.isCritical()).append(") ");
        if (r4.equals(Extension.basicConstraints) == false) goto L18;
        Object r6 = BasicConstraints.getInstance(r7.readObject());     // Catch: Exception -> L31
    L15:
        StringBuffer r9 = r1.append(r6);     // Catch: Exception -> L31
    L16:
        r9.append(r2);     // Catch: Exception -> L31
        goto L8
    L18:
        if (r4.equals(Extension.keyUsage) == false) goto L21;
        r6 = KeyUsage.getInstance(r7.readObject());     // Catch: Exception -> L31
        goto L15
    L21:
        if (r4.equals(MiscObjectIdentifiers.netscapeCertType) == false) goto L24;
        r6 = new NetscapeCertType(DERBitString.getInstance(r7.readObject()));     // Catch: Exception -> L31
        goto L15
    L24:
        if (r4.equals(MiscObjectIdentifiers.netscapeRevocationURL) == false) goto L27;
        r6 = new NetscapeRevocationURL(ASN1IA5String.getInstance(r7.readObject()));     // Catch: Exception -> L31
        goto L15
    L27:
        if (r4.equals(MiscObjectIdentifiers.verisignCzagExtension) == false) goto L29;
        r6 = new VerisignCzagExtension(ASN1IA5String.getInstance(r7.readObject()));     // Catch: Exception -> L31
        goto L15
    L29:
        r1.append(r4.getId());     // Catch: Exception -> L31
        r9 = r1.append(" value = ").append(ASN1Dump.dumpAsString(r7.readObject()));     // Catch: Exception -> L31
    L31:
        r1.append(r4.getId());
        r1.append(" value = ").append("*****").append(r2);
    L34:
        return r1.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r3) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass1(this));
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r3, final String r4) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass2(this, r4));
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey r3, final Provider r4) {
        doVerify((PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin"), new AnonymousClass3(this, r4));     // Catch: NoSuchProviderException -> L5
        return;
    L5:
        e = move-exception;
        throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
    }
}
