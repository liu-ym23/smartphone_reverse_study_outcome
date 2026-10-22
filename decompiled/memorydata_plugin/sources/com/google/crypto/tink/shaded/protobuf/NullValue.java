package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum NullValue extends Enum<NullValue> implements ab.c {
    private static final /* synthetic */ NullValue[] $VALUES = null;
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;
    private static final ab.d<NullValue> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4920a = null;

        static {
            f4920a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (NullValue.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        NullValue r0 = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = r0;
        NullValue r1 = new NullValue("UNRECOGNIZED", 1, -1);
        UNRECOGNIZED = r1;
        $VALUES = new NullValue[]{r0, r1};
        internalValueMap = new AnonymousClass1();
    }

    private NullValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static NullValue forNumber(int r0) {
        if (r0 == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static ab.d<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4920a;
    }

    @Deprecated
    public static NullValue valueOf(int r0) {
        return forNumber(r0);
    }

    public static NullValue valueOf(String r2) {
        return (NullValue) ZeusTransformUtils.preCheckCast(Enum.valueOf(NullValue.class, r2), NullValue.class, "com.obric.memorydata.plugin");
    }

    public static NullValue[] values() {
        return (NullValue[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NullValue[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
