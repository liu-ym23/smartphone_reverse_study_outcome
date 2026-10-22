package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum EllipticCurveType extends Enum<EllipticCurveType> implements ab.c {
    private static final /* synthetic */ EllipticCurveType[] $VALUES = null;
    public static final EllipticCurveType CURVE25519 = null;
    public static final int CURVE25519_VALUE = 5;
    public static final EllipticCurveType NIST_P256 = null;
    public static final int NIST_P256_VALUE = 2;
    public static final EllipticCurveType NIST_P384 = null;
    public static final int NIST_P384_VALUE = 3;
    public static final EllipticCurveType NIST_P521 = null;
    public static final int NIST_P521_VALUE = 4;
    public static final EllipticCurveType UNKNOWN_CURVE = null;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    public static final EllipticCurveType UNRECOGNIZED = null;
    private static final ab.d<EllipticCurveType> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4883a = null;

        static {
            f4883a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (EllipticCurveType.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        EllipticCurveType r0 = new EllipticCurveType("UNKNOWN_CURVE", 0, 0);
        UNKNOWN_CURVE = r0;
        EllipticCurveType r1 = new EllipticCurveType("NIST_P256", 1, 2);
        NIST_P256 = r1;
        EllipticCurveType r3 = new EllipticCurveType("NIST_P384", 2, 3);
        NIST_P384 = r3;
        EllipticCurveType r6 = new EllipticCurveType("NIST_P521", 3, 4);
        NIST_P521 = r6;
        EllipticCurveType r8 = new EllipticCurveType("CURVE25519", 4, 5);
        CURVE25519 = r8;
        EllipticCurveType r10 = new EllipticCurveType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r10;
        $VALUES = new EllipticCurveType[]{r0, r1, r3, r6, r8, r10};
        internalValueMap = new AnonymousClass1();
    }

    private EllipticCurveType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EllipticCurveType forNumber(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L16;
        if (r1 == 5) goto L14;
        return null;
    L14:
        return CURVE25519;
    L16:
        return NIST_P521;
    L18:
        return NIST_P384;
    L20:
        return NIST_P256;
    L22:
        return UNKNOWN_CURVE;
    }

    public static ab.d<EllipticCurveType> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4883a;
    }

    @Deprecated
    public static EllipticCurveType valueOf(int r0) {
        return forNumber(r0);
    }

    public static EllipticCurveType valueOf(String r2) {
        return (EllipticCurveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EllipticCurveType.class, r2), EllipticCurveType.class, "com.obric.memorydata.plugin");
    }

    public static EllipticCurveType[] values() {
        return (EllipticCurveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EllipticCurveType[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
