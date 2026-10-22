package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientEncryptedKey extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientIdentifier identifier;

    private RecipientEncryptedKey(ASN1Sequence r3) {
        this.identifier = KeyAgreeRecipientIdentifier.getInstance(r3.getObjectAt(0));
        this.encryptedKey = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r3.getObjectAt(1), ASN1OctetString.class, "com.obric.memorydata.plugin");
    }

    public static RecipientEncryptedKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RecipientEncryptedKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RecipientEncryptedKey(ASN1Sequence.getInstance(r2));
    L5:
        return (RecipientEncryptedKey) ZeusTransformUtils.preCheckCast(r2, RecipientEncryptedKey.class, "com.obric.memorydata.plugin");
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KeyAgreeRecipientIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.identifier);
        r0.add(this.encryptedKey);
        return new DERSequence(r0);
    }
}
