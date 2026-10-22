package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PbkdMacIntegrityCheck extends ASN1Object {
    private final ASN1OctetString mac;
    private final AlgorithmIdentifier macAlgorithm;
    private final KeyDerivationFunc pbkdAlgorithm;

    private PbkdMacIntegrityCheck(ASN1Sequence r2) {
        this.macAlgorithm = AlgorithmIdentifier.getInstance(r2.getObjectAt(0));
        this.pbkdAlgorithm = KeyDerivationFunc.getInstance(r2.getObjectAt(1));
        this.mac = ASN1OctetString.getInstance(r2.getObjectAt(2));
    }

    public PbkdMacIntegrityCheck(AlgorithmIdentifier r1, KeyDerivationFunc r2, byte[] r3) {
        this.macAlgorithm = r1;
        this.pbkdAlgorithm = r2;
        this.mac = new DEROctetString(Arrays.clone(r3));
    }

    public static PbkdMacIntegrityCheck getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, PbkdMacIntegrityCheck.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PbkdMacIntegrityCheck(ASN1Sequence.getInstance(r2));
    L5:
        return (PbkdMacIntegrityCheck) ZeusTransformUtils.preCheckCast(r2, PbkdMacIntegrityCheck.class, "com.obric.memorydata.plugin");
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac.getOctets());
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public KeyDerivationFunc getPbkdAlgorithm() {
        return this.pbkdAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.macAlgorithm);
        r0.add(this.pbkdAlgorithm);
        r0.add(this.mac);
        return new DERSequence(r0);
    }
}
