package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectDataSequence extends ASN1Object implements Iterable<ASN1Encodable> {
    private final ASN1Encodable[] dataSequence;

    private ObjectDataSequence(ASN1Sequence r4) {
        this.dataSequence = new ASN1Encodable[r4.size()];
        int r0 = 0;
    L3:
        ASN1Encodable[] r1 = this.dataSequence;
        if (r0 == r1.length) goto L6;
        r1[r0] = ObjectData.getInstance(r4.getObjectAt(r0));
        r0 = r0 + 1;
        goto L3
    }

    public ObjectDataSequence(ObjectData[] r3) {
        ASN1Encodable[] r0 = new ASN1Encodable[r3.length];
        this.dataSequence = r0;
        System.arraycopy(r3, 0, r0, 0, r3.length);
    }

    public static ObjectDataSequence getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ObjectDataSequence.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ObjectDataSequence(ASN1Sequence.getInstance(r2));
    L5:
        return (ObjectDataSequence) ZeusTransformUtils.preCheckCast(r2, ObjectDataSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.dataSequence);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.dataSequence);
    }
}
