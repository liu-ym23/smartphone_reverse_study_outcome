package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum JwtRsaSsaPkcs1Algorithm extends Enum<JwtRsaSsaPkcs1Algorithm> implements ab.c {
    private static final /* synthetic */ JwtRsaSsaPkcs1Algorithm[] $VALUES = null;
    public static final JwtRsaSsaPkcs1Algorithm RS256 = null;
    public static final int RS256_VALUE = 1;
    public static final JwtRsaSsaPkcs1Algorithm RS384 = null;
    public static final int RS384_VALUE = 2;
    public static final JwtRsaSsaPkcs1Algorithm RS512 = null;
    public static final int RS512_VALUE = 3;
    public static final JwtRsaSsaPkcs1Algorithm RS_UNKNOWN = null;
    public static final int RS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPkcs1Algorithm UNRECOGNIZED = null;
    private static final ab.d<JwtRsaSsaPkcs1Algorithm> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4890a = null;

        static {
            f4890a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (JwtRsaSsaPkcs1Algorithm.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        JwtRsaSsaPkcs1Algorithm r0 = new JwtRsaSsaPkcs1Algorithm("RS_UNKNOWN", 0, 0);
        RS_UNKNOWN = r0;
        JwtRsaSsaPkcs1Algorithm r1 = new JwtRsaSsaPkcs1Algorithm("RS256", 1, 1);
        RS256 = r1;
        JwtRsaSsaPkcs1Algorithm r3 = new JwtRsaSsaPkcs1Algorithm("RS384", 2, 2);
        RS384 = r3;
        JwtRsaSsaPkcs1Algorithm r5 = new JwtRsaSsaPkcs1Algorithm("RS512", 3, 3);
        RS512 = r5;
        JwtRsaSsaPkcs1Algorithm r7 = new JwtRsaSsaPkcs1Algorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtRsaSsaPkcs1Algorithm[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private JwtRsaSsaPkcs1Algorithm(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static JwtRsaSsaPkcs1Algorithm forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return RS512;
    L14:
        return RS384;
    L16:
        return RS256;
    L18:
        return RS_UNKNOWN;
    }

    public static ab.d<JwtRsaSsaPkcs1Algorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4890a;
    }

    @Deprecated
    public static JwtRsaSsaPkcs1Algorithm valueOf(int r0) {
        return forNumber(r0);
    }

    public static JwtRsaSsaPkcs1Algorithm valueOf(String r2) {
        return (JwtRsaSsaPkcs1Algorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(JwtRsaSsaPkcs1Algorithm.class, r2), JwtRsaSsaPkcs1Algorithm.class, "com.obric.memorydata.plugin");
    }

    public static JwtRsaSsaPkcs1Algorithm[] values() {
        return (JwtRsaSsaPkcs1Algorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JwtRsaSsaPkcs1Algorithm[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
