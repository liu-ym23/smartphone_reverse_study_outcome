package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum HashType extends Enum<HashType> implements ab.c {
    private static final /* synthetic */ HashType[] $VALUES = null;
    public static final HashType SHA1 = null;
    public static final int SHA1_VALUE = 1;
    public static final HashType SHA224 = null;
    public static final int SHA224_VALUE = 5;
    public static final HashType SHA256 = null;
    public static final int SHA256_VALUE = 3;
    public static final HashType SHA384 = null;
    public static final int SHA384_VALUE = 2;
    public static final HashType SHA512 = null;
    public static final int SHA512_VALUE = 4;
    public static final HashType UNKNOWN_HASH = null;
    public static final int UNKNOWN_HASH_VALUE = 0;
    public static final HashType UNRECOGNIZED = null;
    private static final ab.d<HashType> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4884a = null;

        static {
            f4884a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (HashType.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        HashType r0 = new HashType("UNKNOWN_HASH", 0, 0);
        UNKNOWN_HASH = r0;
        HashType r1 = new HashType("SHA1", 1, 1);
        SHA1 = r1;
        HashType r3 = new HashType("SHA384", 2, 2);
        SHA384 = r3;
        HashType r5 = new HashType("SHA256", 3, 3);
        SHA256 = r5;
        HashType r7 = new HashType("SHA512", 4, 4);
        SHA512 = r7;
        HashType r9 = new HashType("SHA224", 5, 5);
        SHA224 = r9;
        HashType r11 = new HashType("UNRECOGNIZED", 6, -1);
        UNRECOGNIZED = r11;
        $VALUES = new HashType[]{r0, r1, r3, r5, r7, r9, r11};
        internalValueMap = new AnonymousClass1();
    }

    private HashType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static HashType forNumber(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return SHA224;
    L18:
        return SHA512;
    L20:
        return SHA256;
    L22:
        return SHA384;
    L24:
        return SHA1;
    L26:
        return UNKNOWN_HASH;
    }

    public static ab.d<HashType> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4884a;
    }

    @Deprecated
    public static HashType valueOf(int r0) {
        return forNumber(r0);
    }

    public static HashType valueOf(String r2) {
        return (HashType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HashType.class, r2), HashType.class, "com.obric.memorydata.plugin");
    }

    public static HashType[] values() {
        return (HashType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HashType[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
