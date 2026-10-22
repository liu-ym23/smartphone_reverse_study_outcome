package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class CertificateFactory extends CertificateFactorySpi {
    private static final PEMUtil PEM_CERT_PARSER = null;
    private static final PEMUtil PEM_CRL_PARSER = null;
    private static final PEMUtil PEM_PKCS7_PARSER = null;
    private final JcaJceHelper bcHelper;
    private InputStream currentCrlStream;
    private InputStream currentStream;
    private ASN1Set sCrlData;
    private int sCrlDataObjectCount;
    private ASN1Set sData;
    private int sDataObjectCount;

    private static class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        public ExCertificateException(Throwable r1) {
            this.cause = r1;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        PEM_CERT_PARSER = new PEMUtil("CERTIFICATE");
        PEM_CRL_PARSER = new PEMUtil("CRL");
        PEM_PKCS7_PARSER = new PEMUtil("PKCS7");
    }

    private CRL doGenerateCRL(InputStream r5, boolean r6) {
        InputStream r0 = this.currentCrlStream;
        if (r0 != null) goto L5;
    L4:
        this.currentCrlStream = r5;
        this.sCrlData = null;
        this.sCrlDataObjectCount = 0;
    L33:
        ASN1Set r1 = this.sCrlData;     // Catch: Exception -> L28 CRLException -> L31
        if (r1 == null) goto L16;
        if (this.sCrlDataObjectCount != r1.size()) goto L12;
        this.sCrlData = null;     // Catch: Exception -> L28 CRLException -> L31
        this.sCrlDataObjectCount = 0;     // Catch: Exception -> L28 CRLException -> L31
        return null;
    L12:
        return getCRL();
    L16:
        if (r5.markSupported() == true) goto L19;
        r5 = new ByteArrayInputStream(Streams.readAll(r5));     // Catch: Exception -> L28 CRLException -> L31
    L19:
        r5.mark(1);     // Catch: Exception -> L28 CRLException -> L31
        int r2 = r5.read();     // Catch: Exception -> L28 CRLException -> L31
        if (r2 != (-1)) goto L22;
        return null;
    L22:
        r5.reset();     // Catch: Exception -> L28 CRLException -> L31
        if (r2 == 48) goto L27;
        return readPEMCRL(r5, r6);
    L27:
        return readDERCRL(new ASN1InputStream(r5, true));
    L31:
        e = move-exception;
        throw e;
    L28:
        e = move-exception;
        throw new CRLException(e.toString());
    L5:
        if (r0 == r5) goto L33;
        goto L4
    }

    private Certificate doGenerateCertificate(InputStream r4, boolean r5) {
        InputStream r0 = this.currentStream;
        if (r0 != null) goto L5;
    L4:
        this.currentStream = r4;
        this.sData = null;
        this.sDataObjectCount = 0;
    L31:
        ASN1Set r1 = this.sData;     // Catch: Exception -> L28
        if (r1 == null) goto L16;
        if (this.sDataObjectCount != r1.size()) goto L12;
        this.sData = null;     // Catch: Exception -> L28
        this.sDataObjectCount = 0;     // Catch: Exception -> L28
        return null;
    L12:
        return getCertificate();
    L16:
        if (r4.markSupported() == true) goto L19;
        r4 = new ByteArrayInputStream(Streams.readAll(r4));     // Catch: Exception -> L28
    L19:
        r4.mark(1);     // Catch: Exception -> L28
        int r2 = r4.read();     // Catch: Exception -> L28
        if (r2 != (-1)) goto L22;
        return null;
    L22:
        r4.reset();     // Catch: Exception -> L28
        if (r2 == 48) goto L27;
        return readPEMCertificate(r4, r5);
    L27:
        return readDERCertificate(new ASN1InputStream(r4));
    L28:
        e = move-exception;
        throw new ExCertificateException("parsing issue: " + e.getMessage(), e);
    L5:
        if (r0 == r4) goto L31;
        goto L4
    }

    private CRL getCRL() {
        ASN1Set r0 = this.sCrlData;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (this.sCrlDataObjectCount >= r0.size()) goto L11;
        ASN1Set r1 = this.sCrlData;
        int r2 = this.sCrlDataObjectCount;
        this.sCrlDataObjectCount = r2 + 1;
        return createCRL(CertificateList.getInstance(r1.getObjectAt(r2)));
    L11:
        return null;
    }

    private CRL getCRL(ASN1Sequence r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.size() <= 1) goto L14;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1ObjectIdentifier.class) == false) goto L14;
        if (r5.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData) == false) goto L14;
        this.sCrlData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true)).getCRLs();
        return getCRL();
    L14:
        return createCRL(CertificateList.getInstance(r5));
    }

    private Certificate getCertificate() {
        if (this.sData != null) goto L5;
        return null;
    L5:
        if (this.sDataObjectCount >= this.sData.size()) goto L15;
        ASN1Set r0 = this.sData;
        int r1 = this.sDataObjectCount;
        this.sDataObjectCount = r1 + 1;
        ASN1Encodable r2 = r0.getObjectAt(r1);
        if (ZeusTransformUtils.instanceOf(r2, ASN1Sequence.class) == false) goto L5;
        return new X509CertificateObject(this.bcHelper, org.bouncycastle.asn1.x509.Certificate.getInstance(r2));
    L15:
        return null;
    }

    private Certificate getCertificate(ASN1Sequence r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.size() <= 1) goto L14;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1ObjectIdentifier.class) == false) goto L14;
        if (r5.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData) == false) goto L14;
        this.sData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true)).getCertificates();
        return getCertificate();
    L14:
        return new X509CertificateObject(this.bcHelper, org.bouncycastle.asn1.x509.Certificate.getInstance(r5));
    }

    private CRL readDERCRL(ASN1InputStream r1) {
        return getCRL(ASN1Sequence.getInstance(r1.readObject()));
    }

    private Certificate readDERCertificate(ASN1InputStream r1) {
        return getCertificate(ASN1Sequence.getInstance(r1.readObject()));
    }

    private CRL readPEMCRL(InputStream r2, boolean r3) {
        return getCRL(PEM_CRL_PARSER.readPEMObject(r2, r3));
    }

    private Certificate readPEMCertificate(InputStream r2, boolean r3) {
        return getCertificate(PEM_CERT_PARSER.readPEMObject(r2, r3));
    }

    public CRL createCRL(CertificateList r2) {
        return new X509CRLObject(this.bcHelper, r2);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream r2) {
        return doGenerateCRL(r2, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCRLs(InputStream r3) {
        ArrayList r0 = new ArrayList();
        BufferedInputStream r1 = new BufferedInputStream(r3);
    L3:
        CRL r4 = doGenerateCRL(r1, r0.isEmpty());
        if (r4 == null) goto L6;
        r0.add(r4);
        goto L3
    L6:
        return r0;
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream r2) {
        return engineGenerateCertPath(r2, "PkiPath");
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream r1, String r2) {
        return new PKIXCertPath(r1, r2);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Object r0 = r4.next();
        if (r0 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r0, X509Certificate.class) == true) goto L4;
        throw new CertificateException("list contains non X509Certificate object while creating CertPath\n" + r0.toString());
    L13:
        return new PKIXCertPath(r2);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream r2) {
        return doGenerateCertificate(r2, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCertificates(InputStream r3) {
        BufferedInputStream r0 = new BufferedInputStream(r3);
        ArrayList r4 = new ArrayList();
    L3:
        Certificate r1 = doGenerateCertificate(r0, r4.isEmpty());
        if (r1 == null) goto L6;
        r4.add(r1);
        goto L3
    L6:
        return r4;
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.certPathEncodings.iterator();
    }
}
