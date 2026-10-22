package com.google.zxing.datamatrix.encoder;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum SymbolShapeHint extends Enum<SymbolShapeHint> {
    private static final /* synthetic */ SymbolShapeHint[] $VALUES = null;
    public static final SymbolShapeHint FORCE_NONE = null;
    public static final SymbolShapeHint FORCE_RECTANGLE = null;
    public static final SymbolShapeHint FORCE_SQUARE = null;

    static {
        SymbolShapeHint r0 = new SymbolShapeHint("FORCE_NONE", 0);
        FORCE_NONE = r0;
        SymbolShapeHint r1 = new SymbolShapeHint("FORCE_SQUARE", 1);
        FORCE_SQUARE = r1;
        SymbolShapeHint r3 = new SymbolShapeHint("FORCE_RECTANGLE", 2);
        FORCE_RECTANGLE = r3;
        $VALUES = new SymbolShapeHint[]{r0, r1, r3};
    }

    private SymbolShapeHint(String r1, int r2) {
        super(r1, r2);
    }

    public static SymbolShapeHint valueOf(String r2) {
        return (SymbolShapeHint) ZeusTransformUtils.preCheckCast(Enum.valueOf(SymbolShapeHint.class, r2), SymbolShapeHint.class, "com.obric.memorydata.plugin");
    }

    public static SymbolShapeHint[] values() {
        return (SymbolShapeHint[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SymbolShapeHint[].class, "com.obric.memorydata.plugin");
    }
}
