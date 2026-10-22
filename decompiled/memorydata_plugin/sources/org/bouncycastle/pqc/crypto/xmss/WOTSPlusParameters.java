package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
final class WOTSPlusParameters {
    private final int digestSize;
    private final int len;
    private final int len1;
    private final int len2;
    private final XMSSOid oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter;

    public WOTSPlusParameters(ASN1ObjectIdentifier r7) {
        Objects.requireNonNull(r7, "treeDigest == null");
        this.treeDigest = r7;
        Digest r8 = DigestUtil.getDigest(r7);
        int r0 = XMSSUtil.getDigestSize(r8);
        this.digestSize = r0;
        this.winternitzParameter = 16;
        int r2 = (int) Math.ceil(((double) (r0 * 8)) / ((double) XMSSUtil.log2(16)));
        this.len1 = r2;
        int r4 = ((int) Math.floor(XMSSUtil.log2((16 - 1) * r2) / XMSSUtil.log2(16))) + 1;
        this.len2 = r4;
        int r3 = r2 + r4;
        this.len = r3;
        WOTSPlusOid r1 = WOTSPlusOid.lookup(r8.getAlgorithmName(), r0, 16, r3);
        this.oid = r1;
        if (r1 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + r8.getAlgorithmName());
    }

    public int getLen() {
        return this.len;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int getTreeDigestSize() {
        return this.digestSize;
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
