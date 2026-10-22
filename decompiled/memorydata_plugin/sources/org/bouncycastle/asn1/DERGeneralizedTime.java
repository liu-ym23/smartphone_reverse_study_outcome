package org.bouncycastle.asn1;

import java.util.Date;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(Date r1) {
        super(r1);
    }

    public DERGeneralizedTime(byte[] r1) {
        super(r1);
    }

    private byte[] getDERTime() {
        if (this.contents[this.contents.length - 1] != 90) goto L28;
        if (hasMinutes() == true) goto L9;
        byte[] r0 = new byte[this.contents.length + 4];
        System.arraycopy(this.contents, 0, r0, 0, this.contents.length - 1);
        System.arraycopy(Strings.toByteArray("0000Z"), 0, r0, this.contents.length - 1, 5);
        return r0;
    L9:
        if (hasSeconds() == true) goto L13;
        byte[] r1 = new byte[this.contents.length + 2];
        System.arraycopy(this.contents, 0, r1, 0, this.contents.length - 1);
        System.arraycopy(Strings.toByteArray("00Z"), 0, r1, this.contents.length - 1, 3);
        return r1;
    L13:
        if (hasFractionalSeconds() == false) goto L26;
        int r2 = this.contents.length - 2;
    L15:
        if (r2 <= 0) goto L20;
        if (this.contents[r2] != 48) goto L20;
        r2 = r2 - 1;
    L20:
        if (this.contents[r2] != 46) goto L23;
        byte[] r3 = new byte[r2 + 1];
        System.arraycopy(this.contents, 0, r3, 0, r2);
        r3[r2] = 90;
        return r3;
    L23:
        byte[] r4 = new byte[r2 + 2];
        int r5 = r2 + 1;
        System.arraycopy(this.contents, 0, r4, 0, r5);
        r4[r5] = 90;
        return r4;
    L26:
        return this.contents;
    L28:
        return this.contents;
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 24, getDERTime());
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, getDERTime().length);
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
