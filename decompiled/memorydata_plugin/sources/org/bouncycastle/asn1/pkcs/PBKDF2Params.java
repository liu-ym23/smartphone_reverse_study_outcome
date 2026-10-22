package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2Params extends ASN1Object {
    private static final AlgorithmIdentifier algid_hmacWithSHA1 = null;
    private final ASN1Integer iterationCount;
    private final ASN1Integer keyLength;
    private final ASN1OctetString octStr;
    private final AlgorithmIdentifier prf;

    static {
        algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    }

    private PBKDF2Params(ASN1Sequence r4) {
        Enumeration r5 = r4.getObjects();
        this.octStr = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r5.nextElement(), ASN1OctetString.class, "com.obric.memorydata.plugin");
        this.iterationCount = (ASN1Integer) ZeusTransformUtils.preCheckCast(r5.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
        if (r5.hasMoreElements() == false) goto L13;
        Object r0 = r5.nextElement();
        if (ZeusTransformUtils.instanceOf(r0, ASN1Integer.class) == false) goto L10;
        this.keyLength = ASN1Integer.getInstance(r0);
        if (r5.hasMoreElements() == false) goto L9;
        r0 = r5.nextElement();
    L11:
        if (r0 == null) goto L14;
        this.prf = AlgorithmIdentifier.getInstance(r0);
        return;
    L14:
        this.prf = null;
        return;
    L9:
        r0 = null;
        goto L11
    L10:
        this.keyLength = null;
        goto L11
    L13:
        this.keyLength = null;
        goto L14
    }

    public PBKDF2Params(byte[] r3, int r4, int r5, AlgorithmIdentifier r6) {
        this.octStr = new DEROctetString(Arrays.clone(r3));
        this.iterationCount = new ASN1Integer(r4);
        if (r5 <= 0) goto L5;
        ASN1Integer r7 = new ASN1Integer(r5);
    L6:
        this.keyLength = r7;
        this.prf = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static PBKDF2Params getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, PBKDF2Params.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PBKDF2Params(ASN1Sequence.getInstance(r2));
    L5:
        return (PBKDF2Params) ZeusTransformUtils.preCheckCast(r2, PBKDF2Params.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer r0 = this.keyLength;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getValue();
    }

    public AlgorithmIdentifier getPrf() {
        AlgorithmIdentifier r0 = this.prf;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return algid_hmacWithSHA1;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.octStr.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(this.octStr);
        r0.add(this.iterationCount);
        ASN1Integer r1 = this.keyLength;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        AlgorithmIdentifier r2 = this.prf;
        if (r2 == null) goto L11;
        if (r2.equals(algid_hmacWithSHA1) == true) goto L11;
        r0.add(this.prf);
    L11:
        return new DERSequence(r0);
    }
}
