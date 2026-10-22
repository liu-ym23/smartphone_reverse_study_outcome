package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
final class WOTSPlusOid implements XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable = null;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap r0 = new HashMap();
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        r0.put(createKey("SHA-512", 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        r0.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        r0.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(r0);
    }

    private WOTSPlusOid(int r1, String r2) {
        this.oid = r1;
        this.stringRepresentation = r2;
    }

    private static String createKey(String r1, int r2, int r3, int r4) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4;
    }

    public static WOTSPlusOid lookup(String r1, int r2, int r3, int r4) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return (WOTSPlusOid) ZeusTransformUtils.preCheckCast(oidLookupTable.get(createKey(r1, r2, r3, r4)), WOTSPlusOid.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
