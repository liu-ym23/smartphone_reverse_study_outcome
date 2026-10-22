package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes7.dex */
public class X962Parameters extends ASN1Object implements ASN1Choice {
    private ASN1Primitive params;

    public X962Parameters(ASN1Null r2) {
        this.params = null;
        this.params = r2;
    }

    public X962Parameters(ASN1ObjectIdentifier r2) {
        this.params = null;
        this.params = r2;
    }

    private X962Parameters(ASN1Primitive r2) {
        this.params = null;
        this.params = r2;
    }

    public X962Parameters(X9ECParameters r2) {
        this.params = null;
        this.params = r2.toASN1Primitive();
    }

    public static X962Parameters getInstance(Object r4) {
        if (r4 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, X962Parameters.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Primitive.class) == false) goto L12;
        return new X962Parameters((ASN1Primitive) ZeusTransformUtils.preCheckCast(r4, ASN1Primitive.class, "com.obric.memorydata.plugin"));
    L12:
        if ((r4 instanceof byte[]) == false) goto L19;
        return new X962Parameters(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    L15:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse encoded data: " + e.getMessage());
    L19:
        throw new IllegalArgumentException("unknown object in getInstance()");
    L21:
        return (X962Parameters) ZeusTransformUtils.preCheckCast(r4, X962Parameters.class, "com.obric.memorydata.plugin");
    }

    public ASN1Primitive getParameters() {
        return this.params;
    }

    public boolean isImplicitlyCA() {
        return ZeusTransformUtils.instanceOf(this.params, ASN1Null.class);
    }

    public boolean isNamedCurve() {
        return ZeusTransformUtils.instanceOf(this.params, ASN1ObjectIdentifier.class);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.params;
    }
}
