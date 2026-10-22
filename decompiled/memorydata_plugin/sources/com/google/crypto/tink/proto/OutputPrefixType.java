package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OutputPrefixType extends Enum<OutputPrefixType> implements ab.c {
    private static final /* synthetic */ OutputPrefixType[] $VALUES = null;
    public static final OutputPrefixType CRUNCHY = null;
    public static final int CRUNCHY_VALUE = 4;
    public static final OutputPrefixType LEGACY = null;
    public static final int LEGACY_VALUE = 2;
    public static final OutputPrefixType RAW = null;
    public static final int RAW_VALUE = 3;
    public static final OutputPrefixType TINK = null;
    public static final int TINK_VALUE = 1;
    public static final OutputPrefixType UNKNOWN_PREFIX = null;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    public static final OutputPrefixType UNRECOGNIZED = null;
    private static final ab.d<OutputPrefixType> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4895a = null;

        static {
            f4895a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (OutputPrefixType.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        OutputPrefixType r0 = new OutputPrefixType("UNKNOWN_PREFIX", 0, 0);
        UNKNOWN_PREFIX = r0;
        OutputPrefixType r1 = new OutputPrefixType("TINK", 1, 1);
        TINK = r1;
        OutputPrefixType r3 = new OutputPrefixType("LEGACY", 2, 2);
        LEGACY = r3;
        OutputPrefixType r5 = new OutputPrefixType("RAW", 3, 3);
        RAW = r5;
        OutputPrefixType r7 = new OutputPrefixType("CRUNCHY", 4, 4);
        CRUNCHY = r7;
        OutputPrefixType r9 = new OutputPrefixType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r9;
        $VALUES = new OutputPrefixType[]{r0, r1, r3, r5, r7, r9};
        internalValueMap = new AnonymousClass1();
    }

    private OutputPrefixType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OutputPrefixType forNumber(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return CRUNCHY;
    L16:
        return RAW;
    L18:
        return LEGACY;
    L20:
        return TINK;
    L22:
        return UNKNOWN_PREFIX;
    }

    public static ab.d<OutputPrefixType> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4895a;
    }

    @Deprecated
    public static OutputPrefixType valueOf(int r0) {
        return forNumber(r0);
    }

    public static OutputPrefixType valueOf(String r2) {
        return (OutputPrefixType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OutputPrefixType.class, r2), OutputPrefixType.class, "com.obric.memorydata.plugin");
    }

    public static OutputPrefixType[] values() {
        return (OutputPrefixType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutputPrefixType[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
