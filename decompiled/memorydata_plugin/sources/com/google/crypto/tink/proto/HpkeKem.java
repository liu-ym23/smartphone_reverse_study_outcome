package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum HpkeKem extends Enum<HpkeKem> implements ab.c {
    private static final /* synthetic */ HpkeKem[] $VALUES = null;
    public static final HpkeKem DHKEM_P256_HKDF_SHA256 = null;
    public static final int DHKEM_P256_HKDF_SHA256_VALUE = 2;
    public static final HpkeKem DHKEM_P384_HKDF_SHA384 = null;
    public static final int DHKEM_P384_HKDF_SHA384_VALUE = 3;
    public static final HpkeKem DHKEM_P521_HKDF_SHA512 = null;
    public static final int DHKEM_P521_HKDF_SHA512_VALUE = 4;
    public static final HpkeKem DHKEM_X25519_HKDF_SHA256 = null;
    public static final int DHKEM_X25519_HKDF_SHA256_VALUE = 1;
    public static final HpkeKem KEM_UNKNOWN = null;
    public static final int KEM_UNKNOWN_VALUE = 0;
    public static final HpkeKem UNRECOGNIZED = null;
    private static final ab.d<HpkeKem> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4887a = null;

        static {
            f4887a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (HpkeKem.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        HpkeKem r0 = new HpkeKem("KEM_UNKNOWN", 0, 0);
        KEM_UNKNOWN = r0;
        HpkeKem r1 = new HpkeKem("DHKEM_X25519_HKDF_SHA256", 1, 1);
        DHKEM_X25519_HKDF_SHA256 = r1;
        HpkeKem r3 = new HpkeKem("DHKEM_P256_HKDF_SHA256", 2, 2);
        DHKEM_P256_HKDF_SHA256 = r3;
        HpkeKem r5 = new HpkeKem("DHKEM_P384_HKDF_SHA384", 3, 3);
        DHKEM_P384_HKDF_SHA384 = r5;
        HpkeKem r7 = new HpkeKem("DHKEM_P521_HKDF_SHA512", 4, 4);
        DHKEM_P521_HKDF_SHA512 = r7;
        HpkeKem r9 = new HpkeKem("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r9;
        $VALUES = new HpkeKem[]{r0, r1, r3, r5, r7, r9};
        internalValueMap = new AnonymousClass1();
    }

    private HpkeKem(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static HpkeKem forNumber(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return DHKEM_P521_HKDF_SHA512;
    L16:
        return DHKEM_P384_HKDF_SHA384;
    L18:
        return DHKEM_P256_HKDF_SHA256;
    L20:
        return DHKEM_X25519_HKDF_SHA256;
    L22:
        return KEM_UNKNOWN;
    }

    public static ab.d<HpkeKem> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4887a;
    }

    @Deprecated
    public static HpkeKem valueOf(int r0) {
        return forNumber(r0);
    }

    public static HpkeKem valueOf(String r2) {
        return (HpkeKem) ZeusTransformUtils.preCheckCast(Enum.valueOf(HpkeKem.class, r2), HpkeKem.class, "com.obric.memorydata.plugin");
    }

    public static HpkeKem[] values() {
        return (HpkeKem[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HpkeKem[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
