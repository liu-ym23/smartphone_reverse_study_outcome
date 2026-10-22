package com.bytedance.rpc.serialize;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum FieldType extends Enum<FieldType> {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final FieldType BODY = null;
    public static final FieldType HEADER = null;
    public static final FieldType QUERY = null;

    static {
        FieldType r0 = new FieldType("HEADER", 0);
        HEADER = r0;
        FieldType r1 = new FieldType("QUERY", 1);
        QUERY = r1;
        FieldType r3 = new FieldType("BODY", 2);
        BODY = r3;
        $VALUES = new FieldType[]{r0, r1, r3};
    }

    private FieldType(String r1, int r2) {
        super(r1, r2);
    }

    public static FieldType valueOf(String r2) {
        return (FieldType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FieldType.class, r2), FieldType.class, "com.obric.memorydata.plugin");
    }

    public static FieldType[] values() {
        return (FieldType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldType[].class, "com.obric.memorydata.plugin");
    }
}
