package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SubjectKeyIdentifier extends ASN1Object {
    private byte[] keyidentifier;

    public SubjectKeyIdentifier(ASN1OctetString r1) {
        this(r1.getOctets());
    }

    public SubjectKeyIdentifier(byte[] r1) {
        this.keyidentifier = Arrays.clone(r1);
    }

    public static SubjectKeyIdentifier getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SubjectKeyIdentifier.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SubjectKeyIdentifier(ASN1OctetString.getInstance(r2));
    L5:
        return (SubjectKeyIdentifier) ZeusTransformUtils.preCheckCast(r2, SubjectKeyIdentifier.class, "com.obric.memorydata.plugin");
    }

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1OctetString.getInstance(r0, r1));
    }

    public byte[] getKeyIdentifier() {
        return Arrays.clone(this.keyidentifier);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(getKeyIdentifier());
    }
}
