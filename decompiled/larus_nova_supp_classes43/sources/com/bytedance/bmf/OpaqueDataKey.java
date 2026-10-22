package com.bytedance.bmf;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
final enum OpaqueDataKey extends Enum<OpaqueDataKey> {
    private static final /* synthetic */ OpaqueDataKey[] $VALUES = null;
    public static final OpaqueDataKey kJsonParam = null;
    private int value;

    static {
        OpaqueDataKey r0 = new OpaqueDataKey("kJsonParam", 0, 2);
        kJsonParam = r0;
        $VALUES = new OpaqueDataKey[]{r0};
    }

    public static OpaqueDataKey[] values() {
        return (OpaqueDataKey[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static OpaqueDataKey valueOf(String r1) {
        return (OpaqueDataKey) a.a(OpaqueDataKey.class, r1);
    }

    private OpaqueDataKey(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
