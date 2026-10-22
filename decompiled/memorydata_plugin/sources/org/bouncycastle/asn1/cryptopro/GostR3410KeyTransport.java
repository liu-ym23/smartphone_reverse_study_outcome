package org.bouncycastle.asn1.cryptopro;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class GostR3410KeyTransport extends ASN1Object {
    private final Gost2814789EncryptedKey sessionEncryptedKey;
    private final GostR3410TransportParameters transportParameters;

    private GostR3410KeyTransport(ASN1Sequence r3) {
        this.sessionEncryptedKey = Gost2814789EncryptedKey.getInstance(r3.getObjectAt(0));
        this.transportParameters = GostR3410TransportParameters.getInstance(ASN1TaggedObject.getInstance(r3.getObjectAt(1)), false);
    }

    public static GostR3410KeyTransport getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, GostR3410KeyTransport.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new GostR3410KeyTransport(ASN1Sequence.getInstance(r2));
    L5:
        return (GostR3410KeyTransport) ZeusTransformUtils.preCheckCast(r2, GostR3410KeyTransport.class, "com.obric.memorydata.plugin");
    }

    public Gost2814789EncryptedKey getSessionEncryptedKey() {
        return this.sessionEncryptedKey;
    }

    public GostR3410TransportParameters getTransportParameters() {
        return this.transportParameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.sessionEncryptedKey);
        if (this.transportParameters == null) goto L6;
        r0.add(new DERTaggedObject(false, 0, this.transportParameters));
    L6:
        return new DERSequence(r0);
    }
}
