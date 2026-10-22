package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

/* JADX INFO: loaded from: classes7.dex */
public class PKIXCertPath extends CertPath {
    static final List certPathEncodings = null;
    private List certificates;
    private final JcaJceHelper helper;

    static {
        ArrayList r0 = new ArrayList();
        r0.add("PkiPath");
        r0.add("PEM");
        r0.add("PKCS7");
        certPathEncodings = Collections.unmodifiableList(r0);
    }

    PKIXCertPath(InputStream r6, String r7) {
        super("X.509");
        BCJcaJceHelper r2 = new BCJcaJceHelper();
        this.helper = r2;
    L30:
        e = move-exception;
        throw new CertificateException("IOException throw while decoding CertPath:\n" + e.toString());
    L27:
        e = move-exception;
        throw new CertificateException("BouncyCastle provider not found while trying to get a CertificateFactory:\n" + e.toString());
    L4:
        if (r7.equalsIgnoreCase("PkiPath") == false) goto L14;
        ASN1Primitive r8 = new ASN1InputStream(r6).readObject();     // Catch: NoSuchProviderException -> L27 IOException -> L30
        if (ZeusTransformUtils.instanceOf(r8, ASN1Sequence.class) == false) goto L12;
        Enumeration r9 = ((ASN1Sequence) ZeusTransformUtils.preCheckCast(r8, ASN1Sequence.class, "com.obric.memorydata.plugin")).getObjects();     // Catch: NoSuchProviderException -> L27 IOException -> L30
        this.certificates = new ArrayList();     // Catch: NoSuchProviderException -> L27 IOException -> L30
        java.security.cert.CertificateFactory r10 = r2.createCertificateFactory("X.509");     // Catch: NoSuchProviderException -> L27 IOException -> L30
    L9:
        if (r9.hasMoreElements() == false) goto L25;
        this.certificates.add(0, r10.generateCertificate(new ByteArrayInputStream(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r9.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive().getEncoded("DER"))));     // Catch: NoSuchProviderException -> L27 IOException -> L30
    L25:
        this.certificates = sortCerts(this.certificates);
        return;
    L12:
        throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");     // Catch: NoSuchProviderException -> L27 IOException -> L30
    L14:
        if (r7.equalsIgnoreCase("PKCS7") == false) goto L16;
    L20:
        BufferedInputStream r11 = new BufferedInputStream(r6);     // Catch: NoSuchProviderException -> L27 IOException -> L30
        this.certificates = new ArrayList();     // Catch: NoSuchProviderException -> L27 IOException -> L30
        java.security.cert.CertificateFactory r12 = r2.createCertificateFactory("X.509");     // Catch: NoSuchProviderException -> L27 IOException -> L30
    L21:
        Certificate r0 = r12.generateCertificate(r11);     // Catch: NoSuchProviderException -> L27 IOException -> L30
        if (r0 == null) goto L25;
        this.certificates.add(r0);     // Catch: NoSuchProviderException -> L27 IOException -> L30
        goto L21
    L16:
        if (r7.equalsIgnoreCase("PEM") == true) goto L20;
        throw new CertificateException("unsupported encoding: " + r7);     // Catch: NoSuchProviderException -> L27 IOException -> L30
    }

    PKIXCertPath(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        super("X.509");
        this.helper = new BCJcaJceHelper();
        this.certificates = sortCerts(new ArrayList(r4));
    }

    private List sortCerts(List r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r10.size() >= 2) goto L5;
        return r10;
    L5:
        X500Principal r1 = ((X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(0), X509Certificate.class, "com.obric.memorydata.plugin")).getIssuerX500Principal();
        int r3 = 1;
    L7:
        if (r3 == r10.size()) goto L12;
        if (r1.equals(((X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(r3), X509Certificate.class, "com.obric.memorydata.plugin")).getSubjectX500Principal()) == false) goto L11;
        r1 = ((X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(r3), X509Certificate.class, "com.obric.memorydata.plugin")).getIssuerX500Principal();
        r3 = r3 + 1;
        goto L7
    L11:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return r10;
    L15:
        ArrayList r4 = new ArrayList(r10.size());
        ArrayList r5 = new ArrayList(r10);
        int r6 = 0;
    L17:
        if (r6 >= r10.size()) goto L30;
        X509Certificate r7 = (X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(r6), X509Certificate.class, "com.obric.memorydata.plugin");
        X500Principal r8 = r7.getSubjectX500Principal();
        int r9 = 0;
    L20:
        if (r9 == r10.size()) goto L25;
        if (((X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(r9), X509Certificate.class, "com.obric.memorydata.plugin")).getIssuerX500Principal().equals(r8) == true) goto L23;
        r9 = r9 + 1;
        goto L20
    L23:
        boolean r12 = true;
    L26:
        if (r12 == true) goto L28;
        r4.add(r7);
        r10.remove(r6);
    L28:
        r6 = r6 + 1;
        goto L17
    L25:
        r12 = false;
        goto L26
    L30:
        if (r4.size() <= 1) goto L32;
        return r5;
    L32:
        int r13 = 0;
    L34:
        if (r13 == r4.size()) goto L44;
        X500Principal r14 = ((X509Certificate) ZeusTransformUtils.preCheckCast(r4.get(r13), X509Certificate.class, "com.obric.memorydata.plugin")).getIssuerX500Principal();
        int r15 = 0;
    L37:
        if (r15 >= r10.size()) goto L42;
        X509Certificate r16 = (X509Certificate) ZeusTransformUtils.preCheckCast(r10.get(r15), X509Certificate.class, "com.obric.memorydata.plugin");
        if (r14.equals(r16.getSubjectX500Principal()) == true) goto L40;
        r15 = r15 + 1;
        goto L37
    L40:
        r4.add(r16);
        r10.remove(r15);
    L42:
        r13 = r13 + 1;
        goto L34
    L44:
        if (r10.size() <= 0) goto L46;
        return r5;
    L46:
        return r4;
    L12:
        r2 = true;
        goto L13
    }

    private ASN1Primitive toASN1Object(X509Certificate r3) {
        return new ASN1InputStream(r3.getEncoded()).readObject();
    L4:
        e = move-exception;
        throw new CertificateEncodingException("Exception while encoding certificate: " + e.toString());
    }

    private byte[] toDEREncoded(ASN1Encodable r3) {
        return ((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive().getEncoded("DER");
    L5:
        e = move-exception;
        throw new CertificateEncodingException("Exception thrown: " + e);
    }

    @Override // java.security.cert.CertPath
    public List getCertificates() {
        return Collections.unmodifiableList(new ArrayList(this.certificates));
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() {
        Iterator r0 = getEncodings();
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L7;
        return null;
    L7:
        return getEncoded((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
    L8:
        return null;
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String r11) {
        if (r11.equalsIgnoreCase("PkiPath") == false) goto L10;
        ASN1EncodableVector r12 = new ASN1EncodableVector();
        List r0 = this.certificates;
        ListIterator r1 = r0.listIterator(r0.size());
    L6:
        if (r1.hasPrevious() == false) goto L9;
        r12.add(toASN1Object((X509Certificate) ZeusTransformUtils.preCheckCast(r1.previous(), X509Certificate.class, "com.obric.memorydata.plugin")));
        goto L6
    L9:
        return toDEREncoded(new DERSequence(r12));
    L10:
        int r2 = 0;
        if (r11.equalsIgnoreCase("PKCS7") == false) goto L19;
        ContentInfo r6 = new ContentInfo(PKCSObjectIdentifiers.data, null);
        ASN1EncodableVector r13 = new ASN1EncodableVector();
    L14:
        if (r2 == this.certificates.size()) goto L17;
        r13.add(toASN1Object((X509Certificate) ZeusTransformUtils.preCheckCast(this.certificates.get(r2), X509Certificate.class, "com.obric.memorydata.plugin")));
        r2 = r2 + 1;
        goto L14
    L17:
        return toDEREncoded(new ContentInfo(PKCSObjectIdentifiers.signedData, new SignedData(new ASN1Integer(1), new DERSet(), r6, new DERSet(r13), null, new DERSet())));
    L19:
        if (r11.equalsIgnoreCase("PEM") == false) goto L30;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();
        PemWriter r3 = new PemWriter(new OutputStreamWriter(r14));
    L31:
        if (r2 == this.certificates.size()) goto L24;
        r3.writeObject(new PemObject("CERTIFICATE", ((X509Certificate) ZeusTransformUtils.preCheckCast(this.certificates.get(r2), X509Certificate.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: Exception -> L27
        r2 = r2 + 1;     // Catch: Exception -> L27
        goto L31
    L24:
        r3.close();     // Catch: Exception -> L27
        return r14.toByteArray();
    L28:
        throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
    L30:
        throw new CertificateEncodingException("unsupported encoding: " + r11);
    }

    @Override // java.security.cert.CertPath
    public Iterator getEncodings() {
        return certPathEncodings.iterator();
    }
}
