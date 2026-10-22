package org.apache.poi.ss.usermodel;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum CellType extends Enum<CellType> {
    private static final /* synthetic */ CellType[] $VALUES = null;
    public static final CellType BLANK = null;
    public static final CellType BOOLEAN = null;
    public static final CellType ERROR = null;
    public static final CellType FORMULA = null;
    public static final CellType NUMERIC = null;
    public static final CellType STRING = null;
    public static final CellType _NONE = null;

    @Deprecated
    private final int code;

    static {
        CellType r0 = new CellType("_NONE", 0, -1);
        _NONE = r0;
        CellType r1 = new CellType("NUMERIC", 1, 0);
        NUMERIC = r1;
        CellType r3 = new CellType("STRING", 2, 1);
        STRING = r3;
        CellType r5 = new CellType("FORMULA", 3, 2);
        FORMULA = r5;
        CellType r7 = new CellType("BLANK", 4, 3);
        BLANK = r7;
        CellType r9 = new CellType("BOOLEAN", 5, 4);
        BOOLEAN = r9;
        CellType r11 = new CellType(CipherConst.LEVEL_ERROR, 6, 5);
        ERROR = r11;
        $VALUES = new CellType[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private CellType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    @Deprecated
    public static CellType forInt(int r5) {
        CellType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        CellType r3 = r0[r2];
        if (r3.code == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Invalid CellType code: " + r5);
    }

    public static CellType valueOf(String r2) {
        return (CellType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellType.class, r2), CellType.class, "com.obric.memorydata.plugin");
    }

    public static CellType[] values() {
        return (CellType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellType[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public int getCode() {
        return this.code;
    }
}
