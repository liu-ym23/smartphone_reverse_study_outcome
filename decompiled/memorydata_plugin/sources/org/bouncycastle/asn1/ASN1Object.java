package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public ASN1Object() {
    }

    public void encodeTo(OutputStream r1) {
        toASN1Primitive().encodeTo(r1);
    }

    public void encodeTo(OutputStream r1, String r2) {
        toASN1Primitive().encodeTo(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ASN1Encodable.class) == true) goto L9;
        return false;
    L9:
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.preCheckCast(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        return toASN1Primitive().equals(r4.toASN1Primitive());
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(r0);
        return r0.toByteArray();
    }

    public byte[] getEncoded(String r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(r0, r2);
        return r0.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public abstract ASN1Primitive toASN1Primitive();
}
