package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class XMSSKeyParams extends ASN1Object {
    private final int height;
    private final AlgorithmIdentifier treeDigest;
    private final ASN1Integer version;

    public XMSSKeyParams(int r4, AlgorithmIdentifier r5) {
        this.version = new ASN1Integer(0);
        this.height = r4;
        this.treeDigest = r5;
    }

    private XMSSKeyParams(ASN1Sequence r2) {
        this.version = ASN1Integer.getInstance(r2.getObjectAt(0));
        this.height = ASN1Integer.getInstance(r2.getObjectAt(1)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(r2.getObjectAt(2));
    }

    public static XMSSKeyParams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, XMSSKeyParams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new XMSSKeyParams(ASN1Sequence.getInstance(r2));
    L5:
        return (XMSSKeyParams) ZeusTransformUtils.preCheckCast(r2, XMSSKeyParams.class, "com.obric.memorydata.plugin");
    }

    public int getHeight() {
        return this.height;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(this.version);
        r0.add(new ASN1Integer(this.height));
        r0.add(this.treeDigest);
        return new DERSequence(r0);
    }
}
