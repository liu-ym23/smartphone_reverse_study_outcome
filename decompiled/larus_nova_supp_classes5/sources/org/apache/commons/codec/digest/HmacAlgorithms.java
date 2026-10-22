package org.apache.commons.codec.digest;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum HmacAlgorithms extends Enum<HmacAlgorithms> {
    private static final /* synthetic */ HmacAlgorithms[] $VALUES = null;
    public static final HmacAlgorithms HMAC_MD5 = null;
    public static final HmacAlgorithms HMAC_SHA_1 = null;
    public static final HmacAlgorithms HMAC_SHA_224 = null;
    public static final HmacAlgorithms HMAC_SHA_256 = null;
    public static final HmacAlgorithms HMAC_SHA_384 = null;
    public static final HmacAlgorithms HMAC_SHA_512 = null;
    private final String name;

    private static /* synthetic */ HmacAlgorithms[] $values() {
        return new HmacAlgorithms[]{HMAC_MD5, HMAC_SHA_1, HMAC_SHA_224, HMAC_SHA_256, HMAC_SHA_384, HMAC_SHA_512};
    }

    static {
        HMAC_MD5 = new HmacAlgorithms("HMAC_MD5", 0, "HmacMD5");
        HMAC_SHA_1 = new HmacAlgorithms("HMAC_SHA_1", 1, "HmacSHA1");
        HMAC_SHA_224 = new HmacAlgorithms("HMAC_SHA_224", 2, "HmacSHA224");
        HMAC_SHA_256 = new HmacAlgorithms("HMAC_SHA_256", 3, "HmacSHA256");
        HMAC_SHA_384 = new HmacAlgorithms("HMAC_SHA_384", 4, "HmacSHA384");
        HMAC_SHA_512 = new HmacAlgorithms("HMAC_SHA_512", 5, "HmacSHA512");
        $VALUES = $values();
    }

    public static HmacAlgorithms[] values() {
        return (HmacAlgorithms[]) $VALUES.clone();
    }

    public String getName() {
        return this.name;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    public static HmacAlgorithms valueOf(String r1) {
        return (HmacAlgorithms) a.a(HmacAlgorithms.class, r1);
    }

    private HmacAlgorithms(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }
}
