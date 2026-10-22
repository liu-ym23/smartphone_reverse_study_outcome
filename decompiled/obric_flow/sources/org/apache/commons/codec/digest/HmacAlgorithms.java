package org.apache.commons.codec.digest;

/* JADX INFO: loaded from: classes3.dex */
public final enum HmacAlgorithms extends Enum<HmacAlgorithms> {
    public static final HmacAlgorithms HMAC_MD5 = null;
    public static final HmacAlgorithms HMAC_SHA_1 = null;
    public static final HmacAlgorithms HMAC_SHA_224 = null;
    public static final HmacAlgorithms HMAC_SHA_256 = null;
    public static final HmacAlgorithms HMAC_SHA_384 = null;
    public static final HmacAlgorithms HMAC_SHA_512 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HmacAlgorithms[] f20942a = null;
    private final String name;

    static {
        HmacAlgorithms r5 = new HmacAlgorithms("HMAC_MD5", 0, "HmacMD5");
        HMAC_MD5 = r5;
        HmacAlgorithms r10 = new HmacAlgorithms("HMAC_SHA_1", 1, "HmacSHA1");
        HMAC_SHA_1 = r10;
        HmacAlgorithms r11 = new HmacAlgorithms("HMAC_SHA_224", 2, "HmacSHA224");
        HMAC_SHA_224 = r11;
        HmacAlgorithms r12 = new HmacAlgorithms("HMAC_SHA_256", 3, "HmacSHA256");
        HMAC_SHA_256 = r12;
        HmacAlgorithms r13 = new HmacAlgorithms("HMAC_SHA_384", 4, "HmacSHA384");
        HMAC_SHA_384 = r13;
        HmacAlgorithms r14 = new HmacAlgorithms("HMAC_SHA_512", 5, "HmacSHA512");
        HMAC_SHA_512 = r14;
        f20942a = new HmacAlgorithms[]{r5, r10, r11, r12, r13, r14};
    }

    public HmacAlgorithms(String r5, int r10, String r11) {
        super(r5, r10);
        this.name = r11;
    }

    public static HmacAlgorithms valueOf(String r5) {
        return (HmacAlgorithms) Enum.valueOf(HmacAlgorithms.class, r5);
    }

    public static HmacAlgorithms[] values() {
        return (HmacAlgorithms[]) f20942a.clone();
    }

    public String getName() {
        return this.name;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
