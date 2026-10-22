package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum CellReferenceType extends Enum<CellReferenceType> {
    private static final /* synthetic */ CellReferenceType[] $VALUES = null;
    public static final CellReferenceType A1 = null;
    public static final CellReferenceType R1C1 = null;
    public static final CellReferenceType UNKNOWN = null;

    static {
        CellReferenceType r0 = new CellReferenceType("A1", 0);
        A1 = r0;
        CellReferenceType r1 = new CellReferenceType("R1C1", 1);
        R1C1 = r1;
        CellReferenceType r3 = new CellReferenceType("UNKNOWN", 2);
        UNKNOWN = r3;
        $VALUES = new CellReferenceType[]{r0, r1, r3};
    }

    private CellReferenceType(String r1, int r2) {
        super(r1, r2);
    }

    public static CellReferenceType valueOf(String r2) {
        return (CellReferenceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellReferenceType.class, r2), CellReferenceType.class, "com.obric.memorydata.plugin");
    }

    public static CellReferenceType[] values() {
        return (CellReferenceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellReferenceType[].class, "com.obric.memorydata.plugin");
    }
}
