package org.bouncycastle.cert;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes7.dex */
public class AttributeCertificateHolder implements Selector {
    private static DigestCalculatorProvider digestCalculatorProvider;
    final Holder holder;

    AttributeCertificateHolder(ASN1Sequence r1) {
        this.holder = Holder.getInstance(r1);
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
        return new AttributeCertificateHolder((ASN1Sequence) ZeusTransformUtils.preCheckCast(this.holder.toASN1Primitive(), ASN1Sequence.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, AttributeCertificateHolder.class) == true) goto L10;
        return false;
    L10:
        AttributeCertificateHolder r4 = (AttributeCertificateHolder) ZeusTransformUtils.preCheckCast(r3, AttributeCertificateHolder.class, "com.obric.memorydata.plugin");
        return this.holder.equals(r4.holder);
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) goto L5;
        return -1;
    L5:
        return this.holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) goto L5;
        return null;
    L5:
        return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
    }

    public int hashCode() {
        return this.holder.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, X509CertificateHolder.class) == true) goto L5;
        return false;
    L5:
        X509CertificateHolder r7 = (X509CertificateHolder) ZeusTransformUtils.preCheckCast(r6, X509CertificateHolder.class, "com.obric.memorydata.plugin");
        if (this.holder.getBaseCertificateID() == null) goto L14;
        if (this.holder.getBaseCertificateID().getSerial().hasValue(r7.getSerialNumber()) == true) goto L10;
        return false;
    L10:
        if (matchesDN(r7.getIssuer(), this.holder.getBaseCertificateID().getIssuer()) == true) goto L12;
        return false;
    L12:
        return true;
    L14:
        if (this.holder.getEntityName() == null) goto L19;
        if (matchesDN(r7.getSubject(), this.holder.getEntityName()) == false) goto L19;
        return true;
    L19:
        if (this.holder.getObjectDigestInfo() != null) goto L30;
    L28:
        return false;
    L30:
        DigestCalculator r0 = digestCalculatorProvider.get(this.holder.getObjectDigestInfo().getDigestAlgorithm());     // Catch: Exception -> L29
        OutputStream r3 = r0.getOutputStream();     // Catch: Exception -> L29
        int r4 = getDigestedObjectType();     // Catch: Exception -> L29
        if (r4 == 0) goto L25;
        if (r4 != 1) goto L26;
        r3.write(r7.getEncoded());     // Catch: Exception -> L29
    L26:
        r3.close();     // Catch: Exception -> L29
        if (Arrays.areEqual(r0.getDigest(), getObjectDigest()) == true) goto L28;
        goto L28
    L25:
        r3.write(r7.getSubjectPublicKeyInfo().getEncoded());     // Catch: Exception -> L29
        goto L26
    }
}
