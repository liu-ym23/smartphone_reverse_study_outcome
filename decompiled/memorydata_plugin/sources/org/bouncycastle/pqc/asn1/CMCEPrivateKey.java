package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEPrivateKey extends ASN1Object {
    private byte[] C;
    private CMCEPublicKey PublicKey;
    private byte[] alpha;
    private byte[] delta;
    private byte[] g;
    private byte[] s;
    private int version;

    public CMCEPrivateKey(int r1, byte[] r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, CMCEPublicKey r7) {
        this.version = r1;
        if (r1 != 0) goto L7;
        this.delta = Arrays.clone(r2);
        this.C = Arrays.clone(r3);
        this.g = Arrays.clone(r4);
        this.alpha = Arrays.clone(r5);
        this.s = Arrays.clone(r6);
        this.PublicKey = r7;
        return;
    L7:
        throw new IllegalArgumentException("unrecognized version");
    }

    private CMCEPrivateKey(ASN1Sequence r3) {
        int r0 = BigIntegers.intValueExact(ASN1Integer.getInstance(r3.getObjectAt(0)).getValue());
        this.version = r0;
        if (r0 != 0) goto L9;
        this.delta = Arrays.clone(ASN1OctetString.getInstance(r3.getObjectAt(1)).getOctets());
        this.C = Arrays.clone(ASN1OctetString.getInstance(r3.getObjectAt(2)).getOctets());
        this.g = Arrays.clone(ASN1OctetString.getInstance(r3.getObjectAt(3)).getOctets());
        this.alpha = Arrays.clone(ASN1OctetString.getInstance(r3.getObjectAt(4)).getOctets());
        this.s = Arrays.clone(ASN1OctetString.getInstance(r3.getObjectAt(5)).getOctets());
        if (r3.size() != 7) goto L10;
        this.PublicKey = CMCEPublicKey.getInstance(r3.getObjectAt(6));
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("unrecognized version");
    }

    public static CMCEPrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CMCEPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new CMCEPrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (CMCEPrivateKey) ZeusTransformUtils.preCheckCast(r2, CMCEPrivateKey.class, "com.obric.memorydata.plugin");
    }

    public byte[] getAlpha() {
        return Arrays.clone(this.alpha);
    }

    public byte[] getC() {
        return Arrays.clone(this.C);
    }

    public byte[] getDelta() {
        return Arrays.clone(this.delta);
    }

    public byte[] getG() {
        return Arrays.clone(this.g);
    }

    public byte[] getS() {
        return Arrays.clone(this.s);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new ASN1Integer(this.version));
        r0.add(new DEROctetString(this.delta));
        r0.add(new DEROctetString(this.C));
        r0.add(new DEROctetString(this.g));
        r0.add(new DEROctetString(this.alpha));
        r0.add(new DEROctetString(this.s));
        if (this.PublicKey == null) goto L6;
        r0.add(new CMCEPublicKey(this.PublicKey.getT()));
    L6:
        return new DERSequence(r0);
    }
}
