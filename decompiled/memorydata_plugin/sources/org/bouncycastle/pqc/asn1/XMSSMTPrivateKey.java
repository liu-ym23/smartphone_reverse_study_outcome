package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class XMSSMTPrivateKey extends ASN1Object {
    private final byte[] bdsState;
    private final long index;
    private final long maxIndex;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;
    private final int version;

    public XMSSMTPrivateKey(long r2, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8) {
        this.version = 0;
        this.index = r2;
        this.secretKeySeed = Arrays.clone(r4);
        this.secretKeyPRF = Arrays.clone(r5);
        this.publicSeed = Arrays.clone(r6);
        this.root = Arrays.clone(r7);
        this.bdsState = Arrays.clone(r8);
        this.maxIndex = -1;
    }

    public XMSSMTPrivateKey(long r2, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8, long r9) {
        this.version = 1;
        this.index = r2;
        this.secretKeySeed = Arrays.clone(r4);
        this.secretKeyPRF = Arrays.clone(r5);
        this.publicSeed = Arrays.clone(r6);
        this.root = Arrays.clone(r7);
        this.bdsState = Arrays.clone(r8);
        this.maxIndex = r9;
    }

    private XMSSMTPrivateKey(ASN1Sequence r9) {
        ASN1Integer r1 = ASN1Integer.getInstance(r9.getObjectAt(0));
        if (r1.hasValue(0) == false) goto L5;
    L9:
        this.version = r1.intValueExact();
        if (r9.size() != 2) goto L12;
    L16:
        ASN1Sequence r2 = ASN1Sequence.getInstance(r9.getObjectAt(1));
        this.index = ASN1Integer.getInstance(r2.getObjectAt(0)).longValueExact();
        this.secretKeySeed = Arrays.clone(DEROctetString.getInstance(r2.getObjectAt(1)).getOctets());
        this.secretKeyPRF = Arrays.clone(DEROctetString.getInstance(r2.getObjectAt(2)).getOctets());
        this.publicSeed = Arrays.clone(DEROctetString.getInstance(r2.getObjectAt(3)).getOctets());
        this.root = Arrays.clone(DEROctetString.getInstance(r2.getObjectAt(4)).getOctets());
        if (r2.size() != 6) goto L24;
        ASN1TaggedObject r3 = ASN1TaggedObject.getInstance(r2.getObjectAt(5));
        if (r3.getTagNo() != 0) goto L22;
        long r0 = ASN1Integer.getInstance(r3, false).longValueExact();
    L26:
        this.maxIndex = r0;
        if (r9.size() != 3) goto L29;
        this.bdsState = Arrays.clone(DEROctetString.getInstance(ASN1TaggedObject.getInstance(r9.getObjectAt(2)), true).getOctets());
        return;
    L29:
        this.bdsState = null;
        return;
    L22:
        throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
    L24:
        if (r2.size() != 5) goto L32;
        r0 = -1;
        goto L26
    L32:
        throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
    L12:
        if (r9.size() == 3) goto L16;
        throw new IllegalArgumentException("key sequence wrong size");
    L5:
        if (r1.hasValue(1) == true) goto L9;
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public static XMSSMTPrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, XMSSMTPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new XMSSMTPrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (XMSSMTPrivateKey) ZeusTransformUtils.preCheckCast(r2, XMSSMTPrivateKey.class, "com.obric.memorydata.plugin");
    }

    public byte[] getBdsState() {
        return Arrays.clone(this.bdsState);
    }

    public long getIndex() {
        return this.index;
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return Arrays.clone(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.secretKeySeed);
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        if (this.maxIndex < 0) goto L5;
        ASN1Integer r1 = new ASN1Integer(1);
    L6:
        r0.add(r1);
        ASN1EncodableVector r2 = new ASN1EncodableVector();
        r2.add(new ASN1Integer(this.index));
        r2.add(new DEROctetString(this.secretKeySeed));
        r2.add(new DEROctetString(this.secretKeyPRF));
        r2.add(new DEROctetString(this.publicSeed));
        r2.add(new DEROctetString(this.root));
        if (this.maxIndex < 0) goto L9;
        r2.add(new DERTaggedObject(false, 0, new ASN1Integer(this.maxIndex)));
    L9:
        r0.add(new DERSequence(r2));
        r0.add(new DERTaggedObject(true, 0, new DEROctetString(this.bdsState)));
        return new DERSequence(r0);
    L5:
        r1 = new ASN1Integer(0);
        goto L6
    }
}
