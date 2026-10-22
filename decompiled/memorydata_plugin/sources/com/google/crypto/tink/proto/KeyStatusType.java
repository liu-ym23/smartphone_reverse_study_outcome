package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum KeyStatusType extends Enum<KeyStatusType> implements ab.c {
    private static final /* synthetic */ KeyStatusType[] $VALUES = null;
    public static final KeyStatusType DESTROYED = null;
    public static final int DESTROYED_VALUE = 3;
    public static final KeyStatusType DISABLED = null;
    public static final int DISABLED_VALUE = 2;
    public static final KeyStatusType ENABLED = null;
    public static final int ENABLED_VALUE = 1;
    public static final KeyStatusType UNKNOWN_STATUS = null;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    public static final KeyStatusType UNRECOGNIZED = null;
    private static final ab.d<KeyStatusType> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4894a = null;

        static {
            f4894a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (KeyStatusType.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        KeyStatusType r0 = new KeyStatusType("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r0;
        KeyStatusType r1 = new KeyStatusType("ENABLED", 1, 1);
        ENABLED = r1;
        KeyStatusType r3 = new KeyStatusType("DISABLED", 2, 2);
        DISABLED = r3;
        KeyStatusType r5 = new KeyStatusType("DESTROYED", 3, 3);
        DESTROYED = r5;
        KeyStatusType r7 = new KeyStatusType("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new KeyStatusType[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private KeyStatusType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static KeyStatusType forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return DESTROYED;
    L14:
        return DISABLED;
    L16:
        return ENABLED;
    L18:
        return UNKNOWN_STATUS;
    }

    public static ab.d<KeyStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4894a;
    }

    @Deprecated
    public static KeyStatusType valueOf(int r0) {
        return forNumber(r0);
    }

    public static KeyStatusType valueOf(String r2) {
        return (KeyStatusType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyStatusType.class, r2), KeyStatusType.class, "com.obric.memorydata.plugin");
    }

    public static KeyStatusType[] values() {
        return (KeyStatusType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyStatusType[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
