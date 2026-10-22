package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

/* JADX INFO: loaded from: classes7.dex */
public class X9IntegerConverter {
    public X9IntegerConverter() {
    }

    public int getByteLength(ECCurve r1) {
        return (r1.getFieldSize() + 7) / 8;
    }

    public int getByteLength(ECFieldElement r1) {
        return (r1.getFieldSize() + 7) / 8;
    }

    public byte[] integerToBytes(BigInteger r3, int r4) {
        byte[] r2 = r3.toByteArray();
        if (r4 >= r2.length) goto L7;
        byte[] r5 = new byte[r4];
        System.arraycopy(r2, r2.length - r4, r5, 0, r4);
        return r5;
    L7:
        if (r4 <= r2.length) goto L10;
        byte[] r6 = new byte[r4];
        System.arraycopy(r2, 0, r6, r4 - r2.length, r2.length);
        return r6;
    L10:
        return r2;
    }
}
