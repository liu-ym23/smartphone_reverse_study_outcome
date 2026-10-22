package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes7.dex */
class OriginatorId implements Selector {
    private X500Name issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public OriginatorId(X500Name r1, BigInteger r2) {
        setIssuerAndSerial(r1, r2);
    }

    public OriginatorId(X500Name r1, BigInteger r2, byte[] r3) {
        setIssuerAndSerial(r1, r2);
        setSubjectKeyID(r3);
    }

    public OriginatorId(byte[] r1) {
        setSubjectKeyID(r1);
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

    private void setIssuerAndSerial(X500Name r1, BigInteger r2) {
        this.issuer = r1;
        this.serialNumber = r2;
    }

    private void setSubjectKeyID(byte[] r1) {
        this.subjectKeyId = r1;
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        return new OriginatorId(this.issuer, this.serialNumber, this.subjectKeyId);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, OriginatorId.class) == true) goto L5;
        return false;
    L5:
        OriginatorId r5 = (OriginatorId) ZeusTransformUtils.preCheckCast(r4, OriginatorId.class, "com.obric.memorydata.plugin");
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
    public boolean match(Object r1) {
        return false;
    }
}
