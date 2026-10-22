package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: loaded from: classes7.dex */
public final enum TableWidthType extends Enum<TableWidthType> {
    private static final /* synthetic */ TableWidthType[] $VALUES = null;
    public static final TableWidthType AUTO = null;
    public static final TableWidthType DXA = null;
    public static final TableWidthType NIL = null;
    public static final TableWidthType PCT = null;
    private STTblWidth.Enum type;

    static {
        TableWidthType r0 = new TableWidthType("AUTO", 0, STTblWidth.f);
        AUTO = r0;
        TableWidthType r1 = new TableWidthType("DXA", 1, STTblWidth.e);
        DXA = r1;
        TableWidthType r2 = new TableWidthType("NIL", 2, STTblWidth.c);
        NIL = r2;
        TableWidthType r4 = new TableWidthType("PCT", 3, STTblWidth.d);
        PCT = r4;
        $VALUES = new TableWidthType[]{r0, r1, r2, r4};
    }

    private TableWidthType(String r1, int r2, STTblWidth.Enum r3) {
        super(r1, r2);
        this.type = STTblWidth.c;
        this.type = r3;
    }

    public static TableWidthType valueOf(String r2) {
        return (TableWidthType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TableWidthType.class, r2), TableWidthType.class, "com.obric.memorydata.plugin");
    }

    public static TableWidthType[] values() {
        return (TableWidthType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TableWidthType[].class, "com.obric.memorydata.plugin");
    }

    public STTblWidth.Enum getStWidthType() {
        return this.type;
    }
}
