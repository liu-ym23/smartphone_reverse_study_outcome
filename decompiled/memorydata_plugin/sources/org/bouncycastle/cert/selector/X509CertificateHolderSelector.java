package org.bouncycastle.cert.selector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes7.dex */
public class X509CertificateHolderSelector implements Selector {
    private X500Name issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public X509CertificateHolderSelector(X500Name r1, BigInteger r2, byte[] r3) {
        this.issuer = r1;
        this.serialNumber = r2;
        this.subjectKeyId = r3;
    }

    private boolean equalsObj(Object r1, Object r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L6;
        return true;
    L6:
        return false;
    L8:
        return r1.equals(r2);
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        return new X509CertificateHolderSelector(this.issuer, this.serialNumber, this.subjectKeyId);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, X509CertificateHolderSelector.class) == true) goto L5;
        return false;
    L5:
        X509CertificateHolderSelector r5 = (X509CertificateHolderSelector) ZeusTransformUtils.preCheckCast(r4, X509CertificateHolderSelector.class, "com.obric.memorydata.plugin");
        if (Arrays.areEqual(this.subjectKeyId, r5.subjectKeyId) == true) goto L8;
        return false;
    L8:
        if (equalsObj(this.serialNumber, r5.serialNumber) == true) goto L10;
        return false;
    L10:
        if (equalsObj(this.issuer, r5.issuer) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(this.subjectKeyId);
        BigInteger r1 = this.serialNumber;
        if (r1 == null) goto L5;
        r0 = r0 ^ r1.hashCode();
    L5:
        X500Name r2 = this.issuer;
        if (r2 != null) goto L8;
        return r0;
    L8:
        return r0 ^ r2.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, X509CertificateHolder.class) == false) goto L21;
        X509CertificateHolder r6 = (X509CertificateHolder) ZeusTransformUtils.preCheckCast(r5, X509CertificateHolder.class, "com.obric.memorydata.plugin");
        if (getSerialNumber() == null) goto L13;
        IssuerAndSerialNumber r0 = new IssuerAndSerialNumber(r6.toASN1Structure());
        if (r0.getName().equals(this.issuer) == true) goto L9;
        return false;
    L9:
        if (r0.getSerialNumber().hasValue(this.serialNumber) == false) goto L26;
        return true;
    L26:
        return false;
    L13:
        if (this.subjectKeyId == null) goto L24;
        Extension r1 = r6.getExtension(Extension.subjectKeyIdentifier);
        if (r1 == null) goto L17;
        byte[] r7 = ASN1OctetString.getInstance(r1.getParsedValue()).getOctets();
        return Arrays.areEqual(this.subjectKeyId, r7);
    L17:
        return Arrays.areEqual(this.subjectKeyId, MSOutlookKeyIdCalculator.calculateKeyId(r6.getSubjectPublicKeyInfo()));
    L24:
        return false;
    L21:
        if ((r5 instanceof byte[]) == false) goto L24;
        return Arrays.areEqual(this.subjectKeyId, (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    }
}
