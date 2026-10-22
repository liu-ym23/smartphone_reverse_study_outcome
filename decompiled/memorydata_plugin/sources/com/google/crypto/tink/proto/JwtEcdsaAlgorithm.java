package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum JwtEcdsaAlgorithm extends Enum<JwtEcdsaAlgorithm> implements ab.c {
    private static final /* synthetic */ JwtEcdsaAlgorithm[] $VALUES = null;
    public static final JwtEcdsaAlgorithm ES256 = null;
    public static final int ES256_VALUE = 1;
    public static final JwtEcdsaAlgorithm ES384 = null;
    public static final int ES384_VALUE = 2;
    public static final JwtEcdsaAlgorithm ES512 = null;
    public static final int ES512_VALUE = 3;
    public static final JwtEcdsaAlgorithm ES_UNKNOWN = null;
    public static final int ES_UNKNOWN_VALUE = 0;
    public static final JwtEcdsaAlgorithm UNRECOGNIZED = null;
    private static final ab.d<JwtEcdsaAlgorithm> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4888a = null;

        static {
            f4888a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (JwtEcdsaAlgorithm.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        JwtEcdsaAlgorithm r0 = new JwtEcdsaAlgorithm("ES_UNKNOWN", 0, 0);
        ES_UNKNOWN = r0;
        JwtEcdsaAlgorithm r1 = new JwtEcdsaAlgorithm("ES256", 1, 1);
        ES256 = r1;
        JwtEcdsaAlgorithm r3 = new JwtEcdsaAlgorithm("ES384", 2, 2);
        ES384 = r3;
        JwtEcdsaAlgorithm r5 = new JwtEcdsaAlgorithm("ES512", 3, 3);
        ES512 = r5;
        JwtEcdsaAlgorithm r7 = new JwtEcdsaAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtEcdsaAlgorithm[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private JwtEcdsaAlgorithm(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static JwtEcdsaAlgorithm forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return ES512;
    L14:
        return ES384;
    L16:
        return ES256;
    L18:
        return ES_UNKNOWN;
    }

    public static ab.d<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4888a;
    }

    @Deprecated
    public static JwtEcdsaAlgorithm valueOf(int r0) {
        return forNumber(r0);
    }

    public static JwtEcdsaAlgorithm valueOf(String r2) {
        return (JwtEcdsaAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(JwtEcdsaAlgorithm.class, r2), JwtEcdsaAlgorithm.class, "com.obric.memorydata.plugin");
    }

    public static JwtEcdsaAlgorithm[] values() {
        return (JwtEcdsaAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JwtEcdsaAlgorithm[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
