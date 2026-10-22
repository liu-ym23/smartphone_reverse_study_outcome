package org.apache.commons.codec.digest;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum HmacAlgorithms extends Enum<HmacAlgorithms> {
    private static final /* synthetic */ HmacAlgorithms[] $VALUES = null;
    public static final HmacAlgorithms HMAC_MD5 = null;
    public static final HmacAlgorithms HMAC_SHA_1 = null;
    public static final HmacAlgorithms HMAC_SHA_224 = null;
    public static final HmacAlgorithms HMAC_SHA_256 = null;
    public static final HmacAlgorithms HMAC_SHA_384 = null;
    public static final HmacAlgorithms HMAC_SHA_512 = null;
    private final String name;

    static {
        HmacAlgorithms r0 = new HmacAlgorithms("HMAC_MD5", 0, "HmacMD5");
        HMAC_MD5 = r0;
        HmacAlgorithms r1 = new HmacAlgorithms("HMAC_SHA_1", 1, "HmacSHA1");
        HMAC_SHA_1 = r1;
        HmacAlgorithms r3 = new HmacAlgorithms("HMAC_SHA_224", 2, "HmacSHA224");
        HMAC_SHA_224 = r3;
        HmacAlgorithms r5 = new HmacAlgorithms("HMAC_SHA_256", 3, "HmacSHA256");
        HMAC_SHA_256 = r5;
        HmacAlgorithms r7 = new HmacAlgorithms("HMAC_SHA_384", 4, "HmacSHA384");
        HMAC_SHA_384 = r7;
        HmacAlgorithms r9 = new HmacAlgorithms("HMAC_SHA_512", 5, "HmacSHA512");
        HMAC_SHA_512 = r9;
        $VALUES = new HmacAlgorithms[]{r0, r1, r3, r5, r7, r9};
    }

    private HmacAlgorithms(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }

    public static HmacAlgorithms valueOf(String r2) {
        return (HmacAlgorithms) ZeusTransformUtils.preCheckCast(Enum.valueOf(HmacAlgorithms.class, r2), HmacAlgorithms.class, "com.obric.memorydata.plugin");
    }

    public static HmacAlgorithms[] values() {
        return (HmacAlgorithms[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HmacAlgorithms[].class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.name;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
