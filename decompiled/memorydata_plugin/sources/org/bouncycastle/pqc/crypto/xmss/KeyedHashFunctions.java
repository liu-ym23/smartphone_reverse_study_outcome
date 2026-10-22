package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes7.dex */
final class KeyedHashFunctions {
    private final Digest digest;
    private final int digestSize;

    public KeyedHashFunctions(ASN1ObjectIdentifier r2, int r3) {
        Objects.requireNonNull(r2, "digest == null");
        this.digest = DigestUtil.getDigest(r2);
        this.digestSize = r3;
    }

    private byte[] coreDigest(int r4, byte[] r5, byte[] r6) {
        byte[] r7 = XMSSUtil.toBytesBigEndian(r4, this.digestSize);
        this.digest.update(r7, 0, r7.length);
        this.digest.update(r5, 0, r5.length);
        this.digest.update(r6, 0, r6.length);
        byte[] r8 = new byte[this.digestSize];
        if (ZeusTransformUtils.instanceOf(this.digest, Xof.class) == false) goto L5;
        ((Xof) ZeusTransformUtils.preCheckCast(this.digest, Xof.class, "com.obric.memorydata.plugin")).doFinal(r8, 0, this.digestSize);
    L6:
        return r8;
    L5:
        this.digest.doFinal(r8, 0);
        goto L6
    }

    public byte[] F(byte[] r3, byte[] r4) {
        int r0 = r3.length;
        int r1 = this.digestSize;
        if (r0 != r1) goto L11;
        if (r4.length != r1) goto L9;
        return coreDigest(0, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] H(byte[] r3, byte[] r4) {
        int r0 = r3.length;
        int r1 = this.digestSize;
        if (r0 != r1) goto L11;
        if (r4.length != (r1 * 2)) goto L9;
        return coreDigest(1, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] PRF(byte[] r3, byte[] r4) {
        if (r3.length != this.digestSize) goto L11;
        if (r4.length != 32) goto L9;
        return coreDigest(3, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong address length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }
}
