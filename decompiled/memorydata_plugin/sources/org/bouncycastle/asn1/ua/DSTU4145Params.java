package org.bouncycastle.asn1.ua;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class DSTU4145Params extends ASN1Object {
    private static final byte[] DEFAULT_DKE = null;
    private byte[] dke;
    private DSTU4145ECBinary ecbinary;
    private ASN1ObjectIdentifier namedCurve;

    static {
        DEFAULT_DKE = new byte[]{-87, MessagePack.Code.FIXEXT4, -21, 69, -15, 60, 112, -126, -128, MessagePack.Code.BIN8, -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, MessagePack.Code.NIL, 55, 41, 29, 56, MessagePack.Code.STR8, 107, -16, 37, MessagePack.Code.FLOAT32, 78, 23, -8, -23, 114, 13, MessagePack.Code.BIN32, 21, -76, 58, 40, -105, 95, 11, MessagePack.Code.NEVER_USED, MessagePack.Code.MAP16, -93, 100, 56, -75, 100, -22, 44, 23, -97, MessagePack.Code.INT8, 18, 62, 109, -72, -6, MessagePack.Code.BIN16, 121, 4};
    }

    public DSTU4145Params(ASN1ObjectIdentifier r2) {
        this.dke = DEFAULT_DKE;
        this.namedCurve = r2;
    }

    public DSTU4145Params(DSTU4145ECBinary r2) {
        this.dke = DEFAULT_DKE;
        this.ecbinary = r2;
    }

    public static byte[] getDefaultDKE() {
        return Arrays.clone(DEFAULT_DKE);
    }

    public static DSTU4145Params getInstance(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DSTU4145Params.class) == false) goto L7;
        return (DSTU4145Params) ZeusTransformUtils.preCheckCast(r4, DSTU4145Params.class, "com.obric.memorydata.plugin");
    L7:
        if (r4 == null) goto L21;
        ASN1Sequence r5 = ASN1Sequence.getInstance(r4);
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1ObjectIdentifier.class) == false) goto L11;
        DSTU4145Params r2 = new DSTU4145Params(ASN1ObjectIdentifier.getInstance(r5.getObjectAt(0)));
    L13:
        if (r5.size() != 2) goto L19;
        byte[] r6 = ASN1OctetString.getInstance(r5.getObjectAt(1)).getOctets();
        r2.dke = r6;
        if (r6.length == DEFAULT_DKE.length) goto L19;
        throw new IllegalArgumentException("object parse error");
    L19:
        return r2;
    L11:
        r2 = new DSTU4145Params(DSTU4145ECBinary.getInstance(r5.getObjectAt(0)));
        goto L13
    L21:
        throw new IllegalArgumentException("object parse error");
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }

    public DSTU4145ECBinary getECBinary() {
        return this.ecbinary;
    }

    public ASN1ObjectIdentifier getNamedCurve() {
        return this.namedCurve;
    }

    public boolean isNamedCurve() {
        if (this.namedCurve == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        ASN1Encodable r1 = this.namedCurve;
        if (r1 != null) goto L6;
        r1 = this.ecbinary;
    L6:
        r0.add(r1);
        if (Arrays.areEqual(this.dke, DEFAULT_DKE) == true) goto L10;
        r0.add(new DEROctetString(this.dke));
    L10:
        return new DERSequence(r0);
    }
}
