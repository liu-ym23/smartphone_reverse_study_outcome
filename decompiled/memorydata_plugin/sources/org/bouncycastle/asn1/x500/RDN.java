package org.bouncycastle.asn1.x500;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;

/* JADX INFO: loaded from: classes7.dex */
public class RDN extends ASN1Object {
    private ASN1Set values;

    private RDN(ASN1Set r1) {
        this.values = r1;
    }

    public static RDN getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RDN.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RDN(ASN1Set.getInstance(r2));
    L5:
        return (RDN) ZeusTransformUtils.preCheckCast(r2, RDN.class, "com.obric.memorydata.plugin");
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() != 0) goto L7;
        return null;
    L7:
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int r0 = this.values.size();
        AttributeTypeAndValue[] r1 = new AttributeTypeAndValue[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public boolean isMultiValued() {
        if (this.values.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int size() {
        return this.values.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
