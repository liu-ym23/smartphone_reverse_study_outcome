package com.alibaba.excel.enums;

import com.alibaba.excel.i.o;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum CellDataTypeEnum extends Enum<CellDataTypeEnum> {
    private static final /* synthetic */ CellDataTypeEnum[] $VALUES = null;
    public static final CellDataTypeEnum BOOLEAN = null;
    public static final CellDataTypeEnum DATE = null;
    public static final CellDataTypeEnum DIRECT_STRING = null;
    public static final CellDataTypeEnum EMPTY = null;
    public static final CellDataTypeEnum ERROR = null;
    public static final CellDataTypeEnum NUMBER = null;
    public static final CellDataTypeEnum RICH_TEXT_STRING = null;
    public static final CellDataTypeEnum STRING = null;
    private static final Map<String, CellDataTypeEnum> TYPE_ROUTING_MAP = null;

    static {
        CellDataTypeEnum r0 = new CellDataTypeEnum("STRING", 0);
        STRING = r0;
        CellDataTypeEnum r1 = new CellDataTypeEnum("DIRECT_STRING", 1);
        DIRECT_STRING = r1;
        CellDataTypeEnum r3 = new CellDataTypeEnum("NUMBER", 2);
        NUMBER = r3;
        CellDataTypeEnum r5 = new CellDataTypeEnum("BOOLEAN", 3);
        BOOLEAN = r5;
        CellDataTypeEnum r7 = new CellDataTypeEnum("EMPTY", 4);
        EMPTY = r7;
        CellDataTypeEnum r9 = new CellDataTypeEnum(CipherConst.LEVEL_ERROR, 5);
        ERROR = r9;
        CellDataTypeEnum r11 = new CellDataTypeEnum("DATE", 6);
        DATE = r11;
        CellDataTypeEnum r13 = new CellDataTypeEnum("RICH_TEXT_STRING", 7);
        RICH_TEXT_STRING = r13;
        $VALUES = new CellDataTypeEnum[]{r0, r1, r3, r5, r7, r9, r11, r13};
        HashMap r2 = new HashMap(16);
        TYPE_ROUTING_MAP = r2;
        r2.put("s", r0);
        r2.put("str", r1);
        r2.put("inlineStr", r1);
        r2.put("e", r9);
        r2.put("b", r5);
        r2.put("n", r3);
    }

    private CellDataTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CellDataTypeEnum buildFromCellType(String r2) {
        if (o.a(r2) == false) goto L7;
        return EMPTY;
    L7:
        return (CellDataTypeEnum) ZeusTransformUtils.preCheckCast(TYPE_ROUTING_MAP.get(r2), CellDataTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static CellDataTypeEnum valueOf(String r2) {
        return (CellDataTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellDataTypeEnum.class, r2), CellDataTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static CellDataTypeEnum[] values() {
        return (CellDataTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellDataTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
