package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class DefaultXMSSOid implements XMSSOid {
    private static final Map<String, DefaultXMSSOid> oidLookupTable = null;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap r0 = new HashMap();
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 10), new DefaultXMSSOid(1, "XMSS_SHA2_10_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 16), new DefaultXMSSOid(2, "XMSS_SHA2_16_256"));
        r0.put(createKey(CryptoConst.ALGORITHM_SHA256, 32, 16, 67, 20), new DefaultXMSSOid(3, "XMSS_SHA2_20_256"));
        r0.put(createKey("SHA-512", 64, 16, 131, 10), new DefaultXMSSOid(4, "XMSS_SHA2_10_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 16), new DefaultXMSSOid(5, "XMSS_SHA2_16_512"));
        r0.put(createKey("SHA-512", 64, 16, 131, 20), new DefaultXMSSOid(6, "XMSS_SHA2_20_512"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 10), new DefaultXMSSOid(7, "XMSS_SHAKE_10_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 16), new DefaultXMSSOid(8, "XMSS_SHAKE_16_256"));
        r0.put(createKey("SHAKE128", 32, 16, 67, 20), new DefaultXMSSOid(9, "XMSS_SHAKE_20_256"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 10), new DefaultXMSSOid(10, "XMSS_SHAKE_10_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 16), new DefaultXMSSOid(11, "XMSS_SHAKE_16_512"));
        r0.put(createKey("SHAKE256", 64, 16, 131, 20), new DefaultXMSSOid(12, "XMSS_SHAKE_20_512"));
        oidLookupTable = Collections.unmodifiableMap(r0);
    }

    private DefaultXMSSOid(int r1, String r2) {
        this.oid = r1;
        this.stringRepresentation = r2;
    }

    private static String createKey(String r1, int r2, int r3, int r4, int r5) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4 + "-" + r5;
    }

    public static DefaultXMSSOid lookup(String r1, int r2, int r3, int r4, int r5) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return (DefaultXMSSOid) ZeusTransformUtils.preCheckCast(oidLookupTable.get(createKey(r1, r2, r3, r4, r5)), DefaultXMSSOid.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
