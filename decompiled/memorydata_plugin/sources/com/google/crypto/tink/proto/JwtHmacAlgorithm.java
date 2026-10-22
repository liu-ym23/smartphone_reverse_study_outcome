package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum JwtHmacAlgorithm extends Enum<JwtHmacAlgorithm> implements ab.c {
    private static final /* synthetic */ JwtHmacAlgorithm[] $VALUES = null;
    public static final JwtHmacAlgorithm HS256 = null;
    public static final int HS256_VALUE = 1;
    public static final JwtHmacAlgorithm HS384 = null;
    public static final int HS384_VALUE = 2;
    public static final JwtHmacAlgorithm HS512 = null;
    public static final int HS512_VALUE = 3;
    public static final JwtHmacAlgorithm HS_UNKNOWN = null;
    public static final int HS_UNKNOWN_VALUE = 0;
    public static final JwtHmacAlgorithm UNRECOGNIZED = null;
    private static final ab.d<JwtHmacAlgorithm> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4889a = null;

        static {
            f4889a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (JwtHmacAlgorithm.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        JwtHmacAlgorithm r0 = new JwtHmacAlgorithm("HS_UNKNOWN", 0, 0);
        HS_UNKNOWN = r0;
        JwtHmacAlgorithm r1 = new JwtHmacAlgorithm("HS256", 1, 1);
        HS256 = r1;
        JwtHmacAlgorithm r3 = new JwtHmacAlgorithm("HS384", 2, 2);
        HS384 = r3;
        JwtHmacAlgorithm r5 = new JwtHmacAlgorithm("HS512", 3, 3);
        HS512 = r5;
        JwtHmacAlgorithm r7 = new JwtHmacAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtHmacAlgorithm[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private JwtHmacAlgorithm(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static JwtHmacAlgorithm forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return HS512;
    L14:
        return HS384;
    L16:
        return HS256;
    L18:
        return HS_UNKNOWN;
    }

    public static ab.d<JwtHmacAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4889a;
    }

    @Deprecated
    public static JwtHmacAlgorithm valueOf(int r0) {
        return forNumber(r0);
    }

    public static JwtHmacAlgorithm valueOf(String r2) {
        return (JwtHmacAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(JwtHmacAlgorithm.class, r2), JwtHmacAlgorithm.class, "com.obric.memorydata.plugin");
    }

    public static JwtHmacAlgorithm[] values() {
        return (JwtHmacAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JwtHmacAlgorithm[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
