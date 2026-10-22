package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectStore extends ASN1Object {
    private final ObjectStoreIntegrityCheck integrityCheck;
    private final ASN1Encodable storeData;

    private ObjectStore(ASN1Sequence r4) {
        if (r4.size() != 2) goto L17;
        ASN1Encodable r0 = r4.getObjectAt(0);
        if (ZeusTransformUtils.instanceOf(r0, EncryptedObjectStoreData.class) == false) goto L8;
    L6:
        this.storeData = r0;
        this.integrityCheck = ObjectStoreIntegrityCheck.getInstance(r4.getObjectAt(1));
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, ObjectStoreData.class) == true) goto L6;
        ASN1Sequence r1 = ASN1Sequence.getInstance(r0);
        if (r1.size() != 2) goto L13;
        r0 = EncryptedObjectStoreData.getInstance(r1);
        goto L6
    L13:
        r0 = ObjectStoreData.getInstance(r1);
        goto L6
    L17:
        throw new IllegalArgumentException("malformed sequence");
    }

    public ObjectStore(EncryptedObjectStoreData r1, ObjectStoreIntegrityCheck r2) {
        this.storeData = r1;
        this.integrityCheck = r2;
    }

    public static ObjectStore getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ObjectStore.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ObjectStore(ASN1Sequence.getInstance(r2));
    L5:
        return (ObjectStore) ZeusTransformUtils.preCheckCast(r2, ObjectStore.class, "com.obric.memorydata.plugin");
    }

    public ObjectStoreIntegrityCheck getIntegrityCheck() {
        return this.integrityCheck;
    }

    public ASN1Encodable getStoreData() {
        return this.storeData;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.storeData);
        r0.add(this.integrityCheck);
        return new DERSequence(r0);
    }
}
