package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {
    private ASN1ObjectIdentifier id;
    private ASN1Primitive parameters;

    public X9FieldID(int r2, int r3) {
        this(r2, r3, 0, 0);
    }

    public X9FieldID(int r6, int r7, int r8, int r9) {
        this.id = characteristic_two_field;
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(new ASN1Integer(r6));
        if (r8 != 0) goto L8;
        if (r9 != 0) goto L7;
        r0.add(tpBasis);
        r0.add(new ASN1Integer(r7));
    L11:
        this.parameters = new DERSequence(r0);
        return;
    L7:
        throw new IllegalArgumentException("inconsistent k values");
    L8:
        if (r8 <= r7) goto L14;
        if (r9 <= r8) goto L14;
        r0.add(ppBasis);
        ASN1EncodableVector r10 = new ASN1EncodableVector(3);
        r10.add(new ASN1Integer(r7));
        r10.add(new ASN1Integer(r8));
        r10.add(new ASN1Integer(r9));
        r0.add(new DERSequence(r10));
    L14:
        throw new IllegalArgumentException("inconsistent k values");
    }

    public X9FieldID(BigInteger r2) {
        this.id = prime_field;
        this.parameters = new ASN1Integer(r2);
    }

    private X9FieldID(ASN1Sequence r2) {
        this.id = ASN1ObjectIdentifier.getInstance(r2.getObjectAt(0));
        this.parameters = r2.getObjectAt(1).toASN1Primitive();
    }

    public static X9FieldID getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, X9FieldID.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new X9FieldID(ASN1Sequence.getInstance(r2));
    L5:
        return (X9FieldID) ZeusTransformUtils.preCheckCast(r2, X9FieldID.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.id;
    }

    public ASN1Primitive getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.id);
        r0.add(this.parameters);
        return new DERSequence(r0);
    }
}
