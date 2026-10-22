package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class XMSSPublicKey extends ASN1Object {
    private final byte[] publicSeed;
    private final byte[] root;

    private XMSSPublicKey(ASN1Sequence r3) {
        if (ASN1Integer.getInstance(r3.getObjectAt(0)).hasValue(0) == false) goto L7;
        this.publicSeed = Arrays.clone(DEROctetString.getInstance(r3.getObjectAt(1)).getOctets());
        this.root = Arrays.clone(DEROctetString.getInstance(r3.getObjectAt(2)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public XMSSPublicKey(byte[] r1, byte[] r2) {
        this.publicSeed = Arrays.clone(r1);
        this.root = Arrays.clone(r2);
    }

    public static XMSSPublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, XMSSPublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new XMSSPublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (XMSSPublicKey) ZeusTransformUtils.preCheckCast(r2, XMSSPublicKey.class, "com.obric.memorydata.plugin");
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new ASN1Integer(0));
        r0.add(new DEROctetString(this.publicSeed));
        r0.add(new DEROctetString(this.root));
        return new DERSequence(r0);
    }
}
