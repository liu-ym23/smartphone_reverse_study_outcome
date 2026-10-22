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
public class XMSSMTKeyParams extends ASN1Object {
    private final int height;
    private final int layers;
    private final AlgorithmIdentifier treeDigest;
    private final ASN1Integer version;

    public XMSSMTKeyParams(int r4, int r5, AlgorithmIdentifier r6) {
        this.version = new ASN1Integer(0);
        this.height = r4;
        this.layers = r5;
        this.treeDigest = r6;
    }

    private XMSSMTKeyParams(ASN1Sequence r2) {
        this.version = ASN1Integer.getInstance(r2.getObjectAt(0));
        this.height = ASN1Integer.getInstance(r2.getObjectAt(1)).intValueExact();
        this.layers = ASN1Integer.getInstance(r2.getObjectAt(2)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(r2.getObjectAt(3));
    }

    public static XMSSMTKeyParams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, XMSSMTKeyParams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new XMSSMTKeyParams(ASN1Sequence.getInstance(r2));
    L5:
        return (XMSSMTKeyParams) ZeusTransformUtils.preCheckCast(r2, XMSSMTKeyParams.class, "com.obric.memorydata.plugin");
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(this.version);
        r0.add(new ASN1Integer(this.height));
        r0.add(new ASN1Integer(this.layers));
        r0.add(this.treeDigest);
        return new DERSequence(r0);
    }
}
