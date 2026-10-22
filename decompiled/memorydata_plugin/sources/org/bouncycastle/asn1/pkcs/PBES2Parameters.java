package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    private KeyDerivationFunc func;
    private EncryptionScheme scheme;

    private PBES2Parameters(ASN1Sequence r5) {
        Enumeration r6 = r5.getObjects();
        ASN1Sequence r0 = ASN1Sequence.getInstance(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive());
        if (r0.getObjectAt(0).equals(id_PBKDF2) == false) goto L5;
        this.func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(r0.getObjectAt(1)));
    L6:
        this.scheme = EncryptionScheme.getInstance(r6.nextElement());
        return;
    L5:
        this.func = KeyDerivationFunc.getInstance(r0);
        goto L6
    }

    public PBES2Parameters(KeyDerivationFunc r1, EncryptionScheme r2) {
        this.func = r1;
        this.scheme = r2;
    }

    public static PBES2Parameters getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, PBES2Parameters.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PBES2Parameters(ASN1Sequence.getInstance(r2));
    L5:
        return (PBES2Parameters) ZeusTransformUtils.preCheckCast(r2, PBES2Parameters.class, "com.obric.memorydata.plugin");
    }

    public EncryptionScheme getEncryptionScheme() {
        return this.scheme;
    }

    public KeyDerivationFunc getKeyDerivationFunc() {
        return this.func;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.func);
        r0.add(this.scheme);
        return new DERSequence(r0);
    }
}
