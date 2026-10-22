package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes7.dex */
public class KeyUsage extends ASN1Object {
    private ASN1BitString bitString;

    private KeyUsage(ASN1BitString r1) {
        this.bitString = r1;
    }

    public static KeyUsage getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, KeyUsage.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new KeyUsage(ASN1BitString.getInstance(r2));
    L5:
        return (KeyUsage) ZeusTransformUtils.preCheckCast(r2, KeyUsage.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.bitString;
    }

    public String toString() {
        byte[] r4 = this.bitString.getBytes();
        if (r4.length != 1) goto L7;
        StringBuilder r0 = new StringBuilder().append("KeyUsage: 0x");
        int r5 = r4[0] & 255;
    L6:
        return r0.append(Integer.toHexString(r5)).toString();
    L7:
        r0 = new StringBuilder().append("KeyUsage: 0x");
        int r2 = (r4[1] & 255) << 8;
        r5 = (r4[0] & 255) | r2;
        goto L6
    }
}
