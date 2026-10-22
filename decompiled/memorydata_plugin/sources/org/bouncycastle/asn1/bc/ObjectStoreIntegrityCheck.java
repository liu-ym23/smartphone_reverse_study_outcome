package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectStoreIntegrityCheck extends ASN1Object implements ASN1Choice {
    private final ASN1Object integrityCheck;
    private final int type;

    private ObjectStoreIntegrityCheck(ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ASN1Sequence.class) == false) goto L5;
    L12:
        this.type = 0;
        ASN1Object r5 = PbkdMacIntegrityCheck.getInstance(r4);
    L13:
        this.integrityCheck = r5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, PbkdMacIntegrityCheck.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, ASN1TaggedObject.class) == false) goto L11;
        this.type = 1;
        r5 = SignatureCheck.getInstance(((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r4, ASN1TaggedObject.class, "com.obric.memorydata.plugin")).getObject());
        goto L13
    L11:
        throw new IllegalArgumentException("Unknown check object in integrity check.");
    }

    public ObjectStoreIntegrityCheck(PbkdMacIntegrityCheck r1) {
        this(r1);
    }

    public ObjectStoreIntegrityCheck(SignatureCheck r3) {
        this(new DERTaggedObject(0, r3));
    }

    public static ObjectStoreIntegrityCheck getInstance(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ObjectStoreIntegrityCheck.class) == false) goto L7;
        return (ObjectStoreIntegrityCheck) ZeusTransformUtils.preCheckCast(r4, ObjectStoreIntegrityCheck.class, "com.obric.memorydata.plugin");
    L7:
        if ((r4 instanceof byte[]) == true) goto L17;
        if (r4 != null) goto L14;
        return null;
    L14:
        return new ObjectStoreIntegrityCheck((ASN1Encodable) ZeusTransformUtils.preCheckCast((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"), ASN1Encodable.class, "com.obric.memorydata.plugin"));
    L17:
        return new ObjectStoreIntegrityCheck(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    L11:
        throw new IllegalArgumentException("Unable to parse integrity check details.");
    }

    public ASN1Object getIntegrityCheck() {
        return this.integrityCheck;
    }

    public int getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (ZeusTransformUtils.instanceOf(this.integrityCheck, SignatureCheck.class) == false) goto L7;
        return new DERTaggedObject(0, this.integrityCheck);
    L7:
        return this.integrityCheck.toASN1Primitive();
    }
}
