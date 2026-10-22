package org.bouncycastle.crypto.agreement.kdf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;
    private byte[] z;

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r17, int r18, int r19) {
        int r2 = r19;
        int r4 = r18;
        if ((r17.length - r2) < r4) goto L27;
        long r5 = r2;
        int r3 = this.digest.getDigestSize();
        if (r5 > 8589934591L) goto L25;
        long r7 = r3;
        int r8 = (int) (((r5 + r7) - 1) / r7);
        byte[] r9 = new byte[this.digest.getDigestSize()];
        int r10 = 0;
        int r11 = 0;
        int r12 = 1;
    L7:
        if (r11 >= r8) goto L22;
        Digest r13 = this.digest;
        byte[] r14 = this.z;
        r13.update(r14, r10, r14.length);
        ASN1EncodableVector r15 = new ASN1EncodableVector();
        ASN1EncodableVector r16 = new ASN1EncodableVector();
        r16.add(this.algorithm);
        r16.add(new DEROctetString(Pack.intToBigEndian(r12)));
        r15.add(new DERSequence(r16));
        if (this.partyAInfo == null) goto L11;
        boolean r110 = true;
        r15.add(new DERTaggedObject(true, r10, new DEROctetString(this.partyAInfo)));
    L12:
        r15.add(new DERTaggedObject(r110, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
        byte[] r20 = new DERSequence(r15).getEncoded("DER");     // Catch: IOException -> L19
        this.digest.update(r20, 0, r20.length);     // Catch: IOException -> L19
        this.digest.doFinal(r9, 0);
        if (r2 <= r3) goto L17;
        System.arraycopy(r9, 0, r17, r4, r3);
        r4 = r4 + r3;
        r2 = r2 - r3;
    L18:
        r12 = r12 + 1;
        r11 = r11 + 1;
        r10 = 0;
        goto L7
    L17:
        System.arraycopy(r9, 0, r17, r4, r2);
    L19:
        e = move-exception;
        throw new IllegalArgumentException("unable to encode parameter info: " + e.getMessage());
    L11:
        r110 = true;
        goto L12
    L22:
        this.digest.reset();
        return (int) r5;
    L25:
        throw new IllegalArgumentException("Output length too large");
    L27:
        throw new OutputLengthException("output buffer too small");
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r3) {
        DHKDFParameters r4 = (DHKDFParameters) ZeusTransformUtils.preCheckCast((DerivationParameters) ZeusTransformUtils.wrapperContextForParams(r3, DerivationParameters.class, "com.obric.memorydata.plugin"), DHKDFParameters.class, "com.obric.memorydata.plugin");
        this.algorithm = r4.getAlgorithm();
        this.keySize = r4.getKeySize();
        this.z = r4.getZ();
        this.partyAInfo = r4.getExtraInfo();
    }
}
