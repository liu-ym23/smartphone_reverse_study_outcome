package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class DefaultXMSSMTOid implements XMSSOid {
    private static final Map<String, DefaultXMSSMTOid> oidLookupTable = null;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap r0 = new HashMap();
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 20, 2), new DefaultXMSSMTOid(1, "XMSSMT_SHA2_20/2_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 20, 4), new DefaultXMSSMTOid(2, "XMSSMT_SHA2_20/4_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 40, 2), new DefaultXMSSMTOid(3, "XMSSMT_SHA2_40/2_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 40, 4), new DefaultXMSSMTOid(4, "XMSSMT_SHA2_40/4_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 40, 8), new DefaultXMSSMTOid(5, "XMSSMT_SHA2_40/8_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 60, 3), new DefaultXMSSMTOid(6, "XMSSMT_SHA2_60/3_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 60, 6), new DefaultXMSSMTOid(7, "XMSSMT_SHA2_60/6_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 60, 12), new DefaultXMSSMTOid(8, "XMSSMT_SHA2_60/12_256"));
        r0.put(createKey("SHA-512", 64, 16, 131, 20, 2), new DefaultXMSSMTOid(9, "XMSSMT_SHA2_20/2_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 20, 4), new DefaultXMSSMTOid(10, "XMSSMT_SHA2_20/4_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 40, 2), new DefaultXMSSMTOid(11, "XMSSMT_SHA2_40/2_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 40, 4), new DefaultXMSSMTOid(12, "XMSSMT_SHA2_40/4_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 40, 8), new DefaultXMSSMTOid(13, "XMSSMT_SHA2_40/8_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 60, 3), new DefaultXMSSMTOid(14, "XMSSMT_SHA2_60/3_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 60, 6), new DefaultXMSSMTOid(15, "XMSSMT_SHA2_60/6_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 60, 12), new DefaultXMSSMTOid(16, "XMSSMT_SHA2_60/12_512"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 20, 2), new DefaultXMSSMTOid(17, "XMSSMT_SHAKE_20/2_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 20, 4), new DefaultXMSSMTOid(18, "XMSSMT_SHAKE_20/4_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 40, 2), new DefaultXMSSMTOid(19, "XMSSMT_SHAKE_40/2_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 40, 4), new DefaultXMSSMTOid(20, "XMSSMT_SHAKE_40/4_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 40, 8), new DefaultXMSSMTOid(21, "XMSSMT_SHAKE_40/8_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 60, 3), new DefaultXMSSMTOid(22, "XMSSMT_SHAKE_60/3_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 60, 6), new DefaultXMSSMTOid(23, "XMSSMT_SHAKE_60/6_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 60, 12), new DefaultXMSSMTOid(24, "XMSSMT_SHAKE_60/12_256"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 20, 2), new DefaultXMSSMTOid(25, "XMSSMT_SHAKE_20/2_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 20, 4), new DefaultXMSSMTOid(26, "XMSSMT_SHAKE_20/4_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 40, 2), new DefaultXMSSMTOid(27, "XMSSMT_SHAKE_40/2_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 40, 4), new DefaultXMSSMTOid(28, "XMSSMT_SHAKE_40/4_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 40, 8), new DefaultXMSSMTOid(29, "XMSSMT_SHAKE_40/8_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 60, 3), new DefaultXMSSMTOid(30, "XMSSMT_SHAKE_60/3_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 60, 6), new DefaultXMSSMTOid(31, "XMSSMT_SHAKE_60/6_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 60, 12), new DefaultXMSSMTOid(32, "XMSSMT_SHAKE_60/12_512"));
        oidLookupTable = Collections.unmodifiableMap(r0);
    }

    private DefaultXMSSMTOid(int r1, String r2) {
        this.oid = r1;
        this.stringRepresentation = r2;
    }

    private static String createKey(String r1, int r2, int r3, int r4, int r5, int r6) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4 + "-" + r5 + "-" + r6;
    }

    public static DefaultXMSSMTOid lookup(String r1, int r2, int r3, int r4, int r5, int r6) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return (DefaultXMSSMTOid) ZeusTransformUtils.preCheckCast(oidLookupTable.get(createKey(r1, r2, r3, r4, r5, r6)), DefaultXMSSMTOid.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
