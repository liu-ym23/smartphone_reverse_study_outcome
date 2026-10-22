package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum JwtRsaSsaPssAlgorithm extends Enum<JwtRsaSsaPssAlgorithm> implements ab.c {
    private static final /* synthetic */ JwtRsaSsaPssAlgorithm[] $VALUES = null;
    public static final JwtRsaSsaPssAlgorithm PS256 = null;
    public static final int PS256_VALUE = 1;
    public static final JwtRsaSsaPssAlgorithm PS384 = null;
    public static final int PS384_VALUE = 2;
    public static final JwtRsaSsaPssAlgorithm PS512 = null;
    public static final int PS512_VALUE = 3;
    public static final JwtRsaSsaPssAlgorithm PS_UNKNOWN = null;
    public static final int PS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPssAlgorithm UNRECOGNIZED = null;
    private static final ab.d<JwtRsaSsaPssAlgorithm> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4891a = null;

        static {
            f4891a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (JwtRsaSsaPssAlgorithm.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        JwtRsaSsaPssAlgorithm r0 = new JwtRsaSsaPssAlgorithm("PS_UNKNOWN", 0, 0);
        PS_UNKNOWN = r0;
        JwtRsaSsaPssAlgorithm r1 = new JwtRsaSsaPssAlgorithm("PS256", 1, 1);
        PS256 = r1;
        JwtRsaSsaPssAlgorithm r3 = new JwtRsaSsaPssAlgorithm("PS384", 2, 2);
        PS384 = r3;
        JwtRsaSsaPssAlgorithm r5 = new JwtRsaSsaPssAlgorithm("PS512", 3, 3);
        PS512 = r5;
        JwtRsaSsaPssAlgorithm r7 = new JwtRsaSsaPssAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtRsaSsaPssAlgorithm[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private JwtRsaSsaPssAlgorithm(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static JwtRsaSsaPssAlgorithm forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return PS512;
    L14:
        return PS384;
    L16:
        return PS256;
    L18:
        return PS_UNKNOWN;
    }

    public static ab.d<JwtRsaSsaPssAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4891a;
    }

    @Deprecated
    public static JwtRsaSsaPssAlgorithm valueOf(int r0) {
        return forNumber(r0);
    }

    public static JwtRsaSsaPssAlgorithm valueOf(String r2) {
        return (JwtRsaSsaPssAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(JwtRsaSsaPssAlgorithm.class, r2), JwtRsaSsaPssAlgorithm.class, "com.obric.memorydata.plugin");
    }

    public static JwtRsaSsaPssAlgorithm[] values() {
        return (JwtRsaSsaPssAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JwtRsaSsaPssAlgorithm[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
