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
public class SPHINCS256KeyParams extends ASN1Object {
    private final AlgorithmIdentifier treeDigest;
    private final ASN1Integer version;

    private SPHINCS256KeyParams(ASN1Sequence r2) {
        this.version = ASN1Integer.getInstance(r2.getObjectAt(0));
        this.treeDigest = AlgorithmIdentifier.getInstance(r2.getObjectAt(1));
    }

    public SPHINCS256KeyParams(AlgorithmIdentifier r4) {
        this.version = new ASN1Integer(0);
        this.treeDigest = r4;
    }

    public static final SPHINCS256KeyParams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SPHINCS256KeyParams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SPHINCS256KeyParams(ASN1Sequence.getInstance(r2));
    L5:
        return (SPHINCS256KeyParams) ZeusTransformUtils.preCheckCast(r2, SPHINCS256KeyParams.class, "com.obric.memorydata.plugin");
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(this.version);
        r0.add(this.treeDigest);
        return new DERSequence(r0);
    }
}
