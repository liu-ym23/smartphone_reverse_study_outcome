package org.bouncycastle.asn1.misc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ScryptParams extends ASN1Object {
    private final BigInteger blockSize;
    private final BigInteger costParameter;
    private final BigInteger keyLength;
    private final BigInteger parallelizationParameter;
    private final byte[] salt;

    private ScryptParams(ASN1Sequence r4) {
        if (r4.size() != 4) goto L5;
    L9:
        this.salt = Arrays.clone(ASN1OctetString.getInstance(r4.getObjectAt(0)).getOctets());
        this.costParameter = ASN1Integer.getInstance(r4.getObjectAt(1)).getValue();
        this.blockSize = ASN1Integer.getInstance(r4.getObjectAt(2)).getValue();
        this.parallelizationParameter = ASN1Integer.getInstance(r4.getObjectAt(3)).getValue();
        if (r4.size() != 5) goto L12;
        BigInteger r5 = ASN1Integer.getInstance(r4.getObjectAt(4)).getValue();
    L13:
        this.keyLength = r5;
        return;
    L12:
        r5 = null;
        goto L13
    L5:
        if (r4.size() == 5) goto L9;
        throw new IllegalArgumentException("invalid sequence: size = " + r4.size());
    }

    public ScryptParams(byte[] r9, int r10, int r11, int r12, int r13) {
        this(r9, BigInteger.valueOf(r10), BigInteger.valueOf(r11), BigInteger.valueOf(r12), BigInteger.valueOf(r13));
    }

    public ScryptParams(byte[] r1, BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5) {
        this.salt = Arrays.clone(r1);
        this.costParameter = r2;
        this.blockSize = r3;
        this.parallelizationParameter = r4;
        this.keyLength = r5;
    }

    public static ScryptParams getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ScryptParams.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ScryptParams(ASN1Sequence.getInstance(r2));
    L5:
        return (ScryptParams) ZeusTransformUtils.preCheckCast(r2, ScryptParams.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getBlockSize() {
        return this.blockSize;
    }

    public BigInteger getCostParameter() {
        return this.costParameter;
    }

    public BigInteger getKeyLength() {
        return this.keyLength;
    }

    public BigInteger getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(new DEROctetString(this.salt));
        r0.add(new ASN1Integer(this.costParameter));
        r0.add(new ASN1Integer(this.blockSize));
        r0.add(new ASN1Integer(this.parallelizationParameter));
        if (this.keyLength == null) goto L6;
        r0.add(new ASN1Integer(this.keyLength));
    L6:
        return new DERSequence(r0);
    }
}
