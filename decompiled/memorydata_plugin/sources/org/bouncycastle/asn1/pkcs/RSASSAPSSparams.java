package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class RSASSAPSSparams extends ASN1Object {
    public static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = null;
    public static final AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = null;
    public static final ASN1Integer DEFAULT_SALT_LENGTH = null;
    public static final ASN1Integer DEFAULT_TRAILER_FIELD = null;
    private AlgorithmIdentifier hashAlgorithm;
    private AlgorithmIdentifier maskGenAlgorithm;
    private ASN1Integer saltLength;
    private ASN1Integer trailerField;

    static {
        AlgorithmIdentifier r0 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        DEFAULT_HASH_ALGORITHM = r0;
        DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, r0);
        DEFAULT_SALT_LENGTH = new ASN1Integer(20);
        DEFAULT_TRAILER_FIELD = new ASN1Integer(1);
    }

    public RSASSAPSSparams() {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.saltLength = DEFAULT_SALT_LENGTH;
        this.trailerField = DEFAULT_TRAILER_FIELD;
    }

    private RSASSAPSSparams(ASN1Sequence r6) {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.saltLength = DEFAULT_SALT_LENGTH;
        this.trailerField = DEFAULT_TRAILER_FIELD;
        int r0 = 0;
    L4:
        if (r0 == r6.size()) goto L19;
        ASN1TaggedObject r1 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r0), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r2 = r1.getTagNo();
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L9;
        this.maskGenAlgorithm = AlgorithmIdentifier.getInstance(r1, true);
    L18:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r2 != 2) goto L11;
        this.saltLength = ASN1Integer.getInstance(r1, true);
        goto L18
    L11:
        if (r2 != 3) goto L14;
        this.trailerField = ASN1Integer.getInstance(r1, true);
        goto L18
    L14:
        throw new IllegalArgumentException("unknown tag");
    L17:
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r1, true);
        goto L18
    }

    public static RSASSAPSSparams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RSASSAPSSparams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RSASSAPSSparams(ASN1Sequence.getInstance(r2));
    L5:
        return (RSASSAPSSparams) ZeusTransformUtils.preCheckCast(r2, RSASSAPSSparams.class, "com.obric.memorydata.plugin");
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        if (this.hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM) == true) goto L6;
        r0.add(new DERTaggedObject(true, 0, this.hashAlgorithm));
    L6:
        if (this.maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION) == true) goto L9;
        r0.add(new DERTaggedObject(true, 1, this.maskGenAlgorithm));
    L9:
        if (this.saltLength.equals(DEFAULT_SALT_LENGTH) == true) goto L12;
        r0.add(new DERTaggedObject(true, 2, this.saltLength));
    L12:
        if (this.trailerField.equals(DEFAULT_TRAILER_FIELD) == true) goto L15;
        r0.add(new DERTaggedObject(true, 3, this.trailerField));
    L15:
        return new DERSequence(r0);
    }
}
