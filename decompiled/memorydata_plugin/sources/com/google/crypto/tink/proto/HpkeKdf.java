package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum HpkeKdf extends Enum<HpkeKdf> implements ab.c {
    private static final /* synthetic */ HpkeKdf[] $VALUES = null;
    public static final HpkeKdf HKDF_SHA256 = null;
    public static final int HKDF_SHA256_VALUE = 1;
    public static final HpkeKdf HKDF_SHA384 = null;
    public static final int HKDF_SHA384_VALUE = 2;
    public static final HpkeKdf HKDF_SHA512 = null;
    public static final int HKDF_SHA512_VALUE = 3;
    public static final HpkeKdf KDF_UNKNOWN = null;
    public static final int KDF_UNKNOWN_VALUE = 0;
    public static final HpkeKdf UNRECOGNIZED = null;
    private static final ab.d<HpkeKdf> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4886a = null;

        static {
            f4886a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (HpkeKdf.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        HpkeKdf r0 = new HpkeKdf("KDF_UNKNOWN", 0, 0);
        KDF_UNKNOWN = r0;
        HpkeKdf r1 = new HpkeKdf("HKDF_SHA256", 1, 1);
        HKDF_SHA256 = r1;
        HpkeKdf r3 = new HpkeKdf("HKDF_SHA384", 2, 2);
        HKDF_SHA384 = r3;
        HpkeKdf r5 = new HpkeKdf("HKDF_SHA512", 3, 3);
        HKDF_SHA512 = r5;
        HpkeKdf r7 = new HpkeKdf("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new HpkeKdf[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private HpkeKdf(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static HpkeKdf forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return HKDF_SHA512;
    L14:
        return HKDF_SHA384;
    L16:
        return HKDF_SHA256;
    L18:
        return KDF_UNKNOWN;
    }

    public static ab.d<HpkeKdf> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4886a;
    }

    @Deprecated
    public static HpkeKdf valueOf(int r0) {
        return forNumber(r0);
    }

    public static HpkeKdf valueOf(String r2) {
        return (HpkeKdf) ZeusTransformUtils.preCheckCast(Enum.valueOf(HpkeKdf.class, r2), HpkeKdf.class, "com.obric.memorydata.plugin");
    }

    public static HpkeKdf[] values() {
        return (HpkeKdf[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HpkeKdf[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
