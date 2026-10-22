package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum EscherPropertyTypesHolder extends Enum<EscherPropertyTypesHolder> {
    private static final /* synthetic */ EscherPropertyTypesHolder[] $VALUES = null;
    public static final EscherPropertyTypesHolder ARRAY = null;
    public static final EscherPropertyTypesHolder BOOLEAN = null;
    public static final EscherPropertyTypesHolder RGB = null;
    public static final EscherPropertyTypesHolder SHAPE_PATH = null;
    public static final EscherPropertyTypesHolder SIMPLE = null;
    public static final EscherPropertyTypesHolder UNKNOWN = null;

    static {
        EscherPropertyTypesHolder r0 = new EscherPropertyTypesHolder("UNKNOWN", 0);
        UNKNOWN = r0;
        EscherPropertyTypesHolder r1 = new EscherPropertyTypesHolder("BOOLEAN", 1);
        BOOLEAN = r1;
        EscherPropertyTypesHolder r3 = new EscherPropertyTypesHolder("RGB", 2);
        RGB = r3;
        EscherPropertyTypesHolder r5 = new EscherPropertyTypesHolder("SHAPE_PATH", 3);
        SHAPE_PATH = r5;
        EscherPropertyTypesHolder r7 = new EscherPropertyTypesHolder("SIMPLE", 4);
        SIMPLE = r7;
        EscherPropertyTypesHolder r9 = new EscherPropertyTypesHolder("ARRAY", 5);
        ARRAY = r9;
        $VALUES = new EscherPropertyTypesHolder[]{r0, r1, r3, r5, r7, r9};
    }

    private EscherPropertyTypesHolder(String r1, int r2) {
        super(r1, r2);
    }

    public static EscherPropertyTypesHolder valueOf(String r2) {
        return (EscherPropertyTypesHolder) ZeusTransformUtils.preCheckCast(Enum.valueOf(EscherPropertyTypesHolder.class, r2), EscherPropertyTypesHolder.class, "com.obric.memorydata.plugin");
    }

    public static EscherPropertyTypesHolder[] values() {
        return (EscherPropertyTypesHolder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EscherPropertyTypesHolder[].class, "com.obric.memorydata.plugin");
    }
}
