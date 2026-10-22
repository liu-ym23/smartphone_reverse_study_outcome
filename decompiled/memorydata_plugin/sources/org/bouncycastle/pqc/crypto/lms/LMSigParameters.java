package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public class LMSigParameters {
    public static final LMSigParameters lms_sha256_n32_h10 = null;
    public static final LMSigParameters lms_sha256_n32_h15 = null;
    public static final LMSigParameters lms_sha256_n32_h20 = null;
    public static final LMSigParameters lms_sha256_n32_h25 = null;
    public static final LMSigParameters lms_sha256_n32_h5 = null;
    private static Map<Object, LMSigParameters> paramBuilders;
    private final ASN1ObjectIdentifier digestOid;
    private final int h;
    private final int m;
    private final int type;

    static {
        lms_sha256_n32_h5 = new LMSigParameters(5, 32, 5, NISTObjectIdentifiers.id_sha256);
        lms_sha256_n32_h10 = new LMSigParameters(6, 32, 10, NISTObjectIdentifiers.id_sha256);
        lms_sha256_n32_h15 = new LMSigParameters(7, 32, 15, NISTObjectIdentifiers.id_sha256);
        lms_sha256_n32_h20 = new LMSigParameters(8, 32, 20, NISTObjectIdentifiers.id_sha256);
        lms_sha256_n32_h25 = new LMSigParameters(9, 32, 25, NISTObjectIdentifiers.id_sha256);
        paramBuilders = new AnonymousClass1();
    }

    public LMSigParameters(int r1, int r2, int r3, ASN1ObjectIdentifier r4) {
        this.type = r1;
        this.m = r2;
        this.h = r3;
        this.digestOid = r4;
    }

    static /* synthetic */ int access$000(LMSigParameters r0) {
        return r0.type;
    }

    static LMSigParameters getParametersForType(int r2) {
        return (LMSigParameters) ZeusTransformUtils.preCheckCast(paramBuilders.get(Integer.valueOf(r2)), LMSigParameters.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOid;
    }

    public int getH() {
        return this.h;
    }

    public int getM() {
        return this.m;
    }

    public int getType() {
        return this.type;
    }
}
