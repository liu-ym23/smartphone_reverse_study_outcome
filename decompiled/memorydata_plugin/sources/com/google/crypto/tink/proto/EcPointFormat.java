package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum EcPointFormat extends Enum<EcPointFormat> implements ab.c {
    private static final /* synthetic */ EcPointFormat[] $VALUES = null;
    public static final EcPointFormat COMPRESSED = null;
    public static final int COMPRESSED_VALUE = 2;
    public static final EcPointFormat DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    public static final EcPointFormat UNCOMPRESSED = null;
    public static final int UNCOMPRESSED_VALUE = 1;
    public static final EcPointFormat UNKNOWN_FORMAT = null;
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    public static final EcPointFormat UNRECOGNIZED = null;
    private static final ab.d<EcPointFormat> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4881a = null;

        static {
            f4881a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (EcPointFormat.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        EcPointFormat r0 = new EcPointFormat("UNKNOWN_FORMAT", 0, 0);
        UNKNOWN_FORMAT = r0;
        EcPointFormat r1 = new EcPointFormat("UNCOMPRESSED", 1, 1);
        UNCOMPRESSED = r1;
        EcPointFormat r3 = new EcPointFormat("COMPRESSED", 2, 2);
        COMPRESSED = r3;
        EcPointFormat r5 = new EcPointFormat("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 3, 3);
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r5;
        EcPointFormat r7 = new EcPointFormat("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new EcPointFormat[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private EcPointFormat(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EcPointFormat forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    L14:
        return COMPRESSED;
    L16:
        return UNCOMPRESSED;
    L18:
        return UNKNOWN_FORMAT;
    }

    public static ab.d<EcPointFormat> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4881a;
    }

    @Deprecated
    public static EcPointFormat valueOf(int r0) {
        return forNumber(r0);
    }

    public static EcPointFormat valueOf(String r2) {
        return (EcPointFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(EcPointFormat.class, r2), EcPointFormat.class, "com.obric.memorydata.plugin");
    }

    public static EcPointFormat[] values() {
        return (EcPointFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EcPointFormat[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
