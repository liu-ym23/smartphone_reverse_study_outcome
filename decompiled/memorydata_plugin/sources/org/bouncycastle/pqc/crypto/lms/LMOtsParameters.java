package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public class LMOtsParameters {
    public static final LMOtsParameters sha256_n32_w1 = null;
    public static final LMOtsParameters sha256_n32_w2 = null;
    public static final LMOtsParameters sha256_n32_w4 = null;
    public static final LMOtsParameters sha256_n32_w8 = null;
    private static final Map<Object, LMOtsParameters> suppliers = null;
    private final ASN1ObjectIdentifier digestOID;
    private final int ls;
    private final int n;
    private final int p;
    private final int sigLen;
    private final int type;
    private final int w;

    static {
        sha256_n32_w1 = new LMOtsParameters(1, 32, 1, 265, 7, 8516, NISTObjectIdentifiers.id_sha256);
        sha256_n32_w2 = new LMOtsParameters(2, 32, 2, 133, 6, 4292, NISTObjectIdentifiers.id_sha256);
        sha256_n32_w4 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, NISTObjectIdentifiers.id_sha256);
        sha256_n32_w8 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, NISTObjectIdentifiers.id_sha256);
        suppliers = new AnonymousClass1();
    }

    public LMOtsParameters(int r1, int r2, int r3, int r4, int r5, int r6, ASN1ObjectIdentifier r7) {
        this.type = r1;
        this.n = r2;
        this.w = r3;
        this.p = r4;
        this.ls = r5;
        this.sigLen = r6;
        this.digestOID = r7;
    }

    static /* synthetic */ int access$000(LMOtsParameters r0) {
        return r0.type;
    }

    public static LMOtsParameters getParametersForType(int r2) {
        return (LMOtsParameters) ZeusTransformUtils.preCheckCast(suppliers.get(Integer.valueOf(r2)), LMOtsParameters.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOID;
    }

    public int getLs() {
        return this.ls;
    }

    public int getN() {
        return this.n;
    }

    public int getP() {
        return this.p;
    }

    public int getType() {
        return this.type;
    }

    public int getW() {
        return this.w;
    }
}
