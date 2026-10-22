package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class PrivateKeyInfo extends ASN1Object {
    private ASN1Set attributes;
    private ASN1OctetString privateKey;
    private AlgorithmIdentifier privateKeyAlgorithm;
    private ASN1BitString publicKey;
    private ASN1Integer version;

    private PrivateKeyInfo(ASN1Sequence r6) {
        Enumeration r7 = r6.getObjects();
        ASN1Integer r0 = ASN1Integer.getInstance(r7.nextElement());
        this.version = r0;
        int r1 = getVersionValue(r0);
        this.privateKeyAlgorithm = AlgorithmIdentifier.getInstance(r7.nextElement());
        this.privateKey = ASN1OctetString.getInstance(r7.nextElement());
        int r2 = -1;
    L4:
        if (r7.hasMoreElements() == false) goto L21;
        ASN1TaggedObject r3 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r7.nextElement(), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r4 = r3.getTagNo();
        if (r4 <= r2) goto L20;
        if (r4 != 0) goto L10;
        this.attributes = ASN1Set.getInstance(r3, false);
    L18:
        r2 = r4;
        goto L4
    L10:
        if (r4 != 1) goto L16;
        if (r1 < 1) goto L14;
        this.publicKey = DERBitString.getInstance(r3, false);
        goto L18
    L14:
        throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
    L16:
        throw new IllegalArgumentException("unknown optional field in private key info");
    L20:
        throw new IllegalArgumentException("invalid optional field in private key info");
    }

    public PrivateKeyInfo(AlgorithmIdentifier r3, ASN1Encodable r4) {
        this(r3, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"), null, null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier r3, ASN1Encodable r4, ASN1Set r5) {
        this(r3, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"), r5, null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier r3, ASN1Encodable r4, ASN1Set r5, byte[] r6) {
        ASN1Encodable r7 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        BigInteger r1 = BigIntegers.ONE;
    L6:
        this.version = new ASN1Integer(r1);
        this.privateKeyAlgorithm = r3;
        this.privateKey = new DEROctetString(r7);
        this.attributes = r5;
        if (r6 != null) goto L9;
        DERBitString r8 = null;
    L10:
        this.publicKey = r8;
        return;
    L9:
        r8 = new DERBitString(r6);
        goto L10
    L5:
        r1 = BigIntegers.ZERO;
        goto L6
    }

    public static PrivateKeyInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, PrivateKeyInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PrivateKeyInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (PrivateKeyInfo) ZeusTransformUtils.preCheckCast(r2, PrivateKeyInfo.class, "com.obric.memorydata.plugin");
    }

    private static int getVersionValue(ASN1Integer r1) {
        int r2 = r1.intValueExact();
        if (r2 < 0) goto L8;
        if (r2 > 1) goto L8;
        return r2;
    L8:
        throw new IllegalArgumentException("invalid version for private key info");
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public ASN1OctetString getPrivateKey() {
        return new DEROctetString(this.privateKey.getOctets());
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithm() {
        return this.privateKeyAlgorithm;
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    public boolean hasPublicKey() {
        if (this.publicKey == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ASN1Encodable parsePrivateKey() {
        return ASN1Primitive.fromByteArray(this.privateKey.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(this.version);
        r0.add(this.privateKeyAlgorithm);
        r0.add(this.privateKey);
        if (this.attributes == null) goto L6;
        r0.add(new DERTaggedObject(false, 0, this.attributes));
    L6:
        if (this.publicKey == null) goto L9;
        r0.add(new DERTaggedObject(false, 1, this.publicKey));
    L9:
        return new DERSequence(r0);
    }
}
