package org.bouncycastle.cert;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AttCertIssuer;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.V2Form;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes7.dex */
public class AttributeCertificateIssuer implements Selector {
    final ASN1Encodable form;

    public AttributeCertificateIssuer(AttCertIssuer r1) {
        this.form = r1.getIssuer();
    }

    private boolean matchesDN(X500Name r5, GeneralNames r6) {
        GeneralName[] r4 = r6.getNames();
        int r0 = 0;
    L4:
        if (r0 == r4.length) goto L12;
        GeneralName r1 = r4[r0];
        if (r1.getTagNo() != 4) goto L11;
        if (X500Name.getInstance(r1.getName()).equals(r5) == false) goto L11;
        return true;
    L11:
        r0 = r0 + 1;
        goto L4
    L12:
        return false;
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.form));
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, AttributeCertificateIssuer.class) == true) goto L10;
        return false;
    L10:
        AttributeCertificateIssuer r4 = (AttributeCertificateIssuer) ZeusTransformUtils.preCheckCast(r3, AttributeCertificateIssuer.class, "com.obric.memorydata.plugin");
        return this.form.equals(r4.form);
    }

    public int hashCode() {
        return this.form.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, X509CertificateHolder.class) == true) goto L5;
        return false;
    L5:
        X509CertificateHolder r7 = (X509CertificateHolder) ZeusTransformUtils.preCheckCast(r6, X509CertificateHolder.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.form, V2Form.class) == false) goto L18;
        V2Form r0 = (V2Form) ZeusTransformUtils.preCheckCast(this.form, V2Form.class, "com.obric.memorydata.plugin");
        if (r0.getBaseCertificateID() != null) goto L10;
        GeneralNames r1 = r0.getIssuerName();
        if (matchesDN(r7.getSubject(), r1) == false) goto L21;
        return true;
    L21:
        return false;
    L10:
        if (r0.getBaseCertificateID().getSerial().hasValue(r7.getSerialNumber()) == true) goto L12;
        return false;
    L12:
        if (matchesDN(r7.getIssuer(), r0.getBaseCertificateID().getIssuer()) == true) goto L14;
        return false;
    L14:
        return true;
    L18:
        GeneralNames r2 = (GeneralNames) ZeusTransformUtils.preCheckCast(this.form, GeneralNames.class, "com.obric.memorydata.plugin");
        if (matchesDN(r7.getSubject(), r2) == false) goto L21;
        return true;
    }
}
