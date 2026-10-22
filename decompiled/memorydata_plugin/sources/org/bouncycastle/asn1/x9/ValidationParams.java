package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class ValidationParams extends ASN1Object {
    private ASN1Integer pgenCounter;
    private ASN1BitString seed;

    private ValidationParams(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        this.seed = ASN1BitString.getInstance(r3.getObjectAt(0));
        this.pgenCounter = ASN1Integer.getInstance(r3.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public ValidationParams(byte[] r3, int r4) {
        if (r3 == null) goto L7;
        this.seed = new DERBitString(r3);
        this.pgenCounter = new ASN1Integer(r4);
        return;
    L7:
        throw new IllegalArgumentException("'seed' cannot be null");
    }

    public static ValidationParams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ValidationParams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ValidationParams(ASN1Sequence.getInstance(r2));
    L5:
        return (ValidationParams) ZeusTransformUtils.preCheckCast(r2, ValidationParams.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getPgenCounter() {
        return this.pgenCounter.getPositiveValue();
    }

    public byte[] getSeed() {
        return this.seed.getBytes();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.seed);
        r0.add(this.pgenCounter);
        return new DERSequence(r0);
    }
}
