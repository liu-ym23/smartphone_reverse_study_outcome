package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public final class XMSSParameters {
    private static final Map<Integer, XMSSParameters> paramsLookupTable = null;
    private final int height;
    private final int k;
    private final XMSSOid oid;
    private final String treeDigest;
    private final ASN1ObjectIdentifier treeDigestOID;
    private final int treeDigestSize;
    private final int winternitzParameter;
    private final WOTSPlusParameters wotsPlusParams;

    static {
        HashMap r0 = new HashMap();
        r0.put(Integers.valueOf(1), new XMSSParameters(10, NISTObjectIdentifiers.id_sha256));
        r0.put(Integers.valueOf(2), new XMSSParameters(16, NISTObjectIdentifiers.id_sha256));
        r0.put(Integers.valueOf(3), new XMSSParameters(20, NISTObjectIdentifiers.id_sha256));
        r0.put(Integers.valueOf(4), new XMSSParameters(10, NISTObjectIdentifiers.id_sha512));
        r0.put(Integers.valueOf(5), new XMSSParameters(16, NISTObjectIdentifiers.id_sha512));
        r0.put(Integers.valueOf(6), new XMSSParameters(20, NISTObjectIdentifiers.id_sha512));
        r0.put(Integers.valueOf(7), new XMSSParameters(10, NISTObjectIdentifiers.id_shake128));
        r0.put(Integers.valueOf(8), new XMSSParameters(16, NISTObjectIdentifiers.id_shake128));
        r0.put(Integers.valueOf(9), new XMSSParameters(20, NISTObjectIdentifiers.id_shake128));
        r0.put(Integers.valueOf(10), new XMSSParameters(10, NISTObjectIdentifiers.id_shake256));
        r0.put(Integers.valueOf(11), new XMSSParameters(16, NISTObjectIdentifiers.id_shake256));
        r0.put(Integers.valueOf(12), new XMSSParameters(20, NISTObjectIdentifiers.id_shake256));
        paramsLookupTable = Collections.unmodifiableMap(r0);
    }

    public XMSSParameters(int r4, ASN1ObjectIdentifier r5) {
        if (r4 < 2) goto L7;
        Objects.requireNonNull(r5, "digest == null");
        this.height = r4;
        this.k = determineMinK();
        String r0 = DigestUtil.getDigestName(r5);
        this.treeDigest = r0;
        this.treeDigestOID = r5;
        WOTSPlusParameters r1 = new WOTSPlusParameters(r5);
        this.wotsPlusParams = r1;
        int r6 = r1.getTreeDigestSize();
        this.treeDigestSize = r6;
        int r2 = r1.getWinternitzParameter();
        this.winternitzParameter = r2;
        this.oid = DefaultXMSSOid.lookup(r0, r6, r2, r1.getLen(), r4);
        return;
    L7:
        throw new IllegalArgumentException("height must be >= 2");
    }

    public XMSSParameters(int r3, Digest r4) {
        this(r3, DigestUtil.getDigestOID(((Digest) ZeusTransformUtils.wrapperContextForParams(r4, Digest.class, "com.obric.memorydata.plugin")).getAlgorithmName()));
    }

    private int determineMinK() {
        int r1 = 2;
    L3:
        int r2 = this.height;
        if (r1 > r2) goto L10;
        if (((r2 - r1) % 2) == 0) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L10:
        throw new IllegalStateException("should never happen...");
    }

    public static XMSSParameters lookupByOID(int r2) {
        return (XMSSParameters) ZeusTransformUtils.preCheckCast(paramsLookupTable.get(Integers.valueOf(r2)), XMSSParameters.class, "com.obric.memorydata.plugin");
    }

    public int getHeight() {
        return this.height;
    }

    int getK() {
        return this.k;
    }

    int getLen() {
        return this.wotsPlusParams.getLen();
    }

    XMSSOid getOid() {
        return this.oid;
    }

    String getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigestOID;
    }

    public int getTreeDigestSize() {
        return this.treeDigestSize;
    }

    WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }

    int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
