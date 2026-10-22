package com.bytedance.crash.protector;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum ProtectorConfigBuilder$AbiType extends Enum<ProtectorConfigBuilder$AbiType> {
    public static final ProtectorConfigBuilder$AbiType ARM64_V8A = null;
    public static final ProtectorConfigBuilder$AbiType ARMEABI_V7A = null;
    public static final ProtectorConfigBuilder$AbiType BOTH = null;
    public static final /* synthetic */ ProtectorConfigBuilder$AbiType[] a = null;
    private final int value;

    static {
        ProtectorConfigBuilder$AbiType r0 = new ProtectorConfigBuilder$AbiType("BOTH", 0, 0);
        BOTH = r0;
        ProtectorConfigBuilder$AbiType r1 = new ProtectorConfigBuilder$AbiType("ARM64_V8A", 1, 1);
        ARM64_V8A = r1;
        ProtectorConfigBuilder$AbiType r3 = new ProtectorConfigBuilder$AbiType("ARMEABI_V7A", 2, 2);
        ARMEABI_V7A = r3;
        a = new ProtectorConfigBuilder$AbiType[]{r0, r1, r3};
    }

    public static ProtectorConfigBuilder$AbiType[] values() {
        return (ProtectorConfigBuilder$AbiType[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static /* synthetic */ int access$000(ProtectorConfigBuilder$AbiType r0) {
        return r0.value;
    }

    public static ProtectorConfigBuilder$AbiType valueOf(String r1) {
        return (ProtectorConfigBuilder$AbiType) a.a(ProtectorConfigBuilder$AbiType.class, r1);
    }

    public ProtectorConfigBuilder$AbiType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
