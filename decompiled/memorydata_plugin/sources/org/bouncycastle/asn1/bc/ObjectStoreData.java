package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectStoreData extends ASN1Object {
    private final String comment;
    private final ASN1GeneralizedTime creationDate;
    private final AlgorithmIdentifier integrityAlgorithm;
    private final ASN1GeneralizedTime lastModifiedDate;
    private final ObjectDataSequence objectDataSequence;
    private final BigInteger version;

    private ObjectStoreData(ASN1Sequence r3) {
        this.version = ASN1Integer.getInstance(r3.getObjectAt(0)).getValue();
        this.integrityAlgorithm = AlgorithmIdentifier.getInstance(r3.getObjectAt(1));
        this.creationDate = ASN1GeneralizedTime.getInstance(r3.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(r3.getObjectAt(3));
        this.objectDataSequence = ObjectDataSequence.getInstance(r3.getObjectAt(4));
        if (r3.size() != 6) goto L5;
        String r4 = ASN1UTF8String.getInstance(r3.getObjectAt(5)).getString();
    L6:
        this.comment = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public ObjectStoreData(AlgorithmIdentifier r3, Date r4, Date r5, ObjectDataSequence r6, String r7) {
        this.version = BigInteger.valueOf(1);
        this.integrityAlgorithm = r3;
        this.creationDate = new DERGeneralizedTime(r4);
        this.lastModifiedDate = new DERGeneralizedTime(r5);
        this.objectDataSequence = r6;
        this.comment = r7;
    }

    public static ObjectStoreData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ObjectStoreData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ObjectStoreData(ASN1Sequence.getInstance(r2));
    L5:
        return (ObjectStoreData) ZeusTransformUtils.preCheckCast(r2, ObjectStoreData.class, "com.obric.memorydata.plugin");
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    public AlgorithmIdentifier getIntegrityAlgorithm() {
        return this.integrityAlgorithm;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public ObjectDataSequence getObjectDataSequence() {
        return this.objectDataSequence;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(6);
        r0.add(new ASN1Integer(this.version));
        r0.add(this.integrityAlgorithm);
        r0.add(this.creationDate);
        r0.add(this.lastModifiedDate);
        r0.add(this.objectDataSequence);
        if (this.comment == null) goto L6;
        r0.add(new DERUTF8String(this.comment));
    L6:
        return new DERSequence(r0);
    }
}
