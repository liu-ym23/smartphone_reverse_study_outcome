package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class TableRecord extends SharedValueRecordBase {
    private static final BitField alwaysCalc = null;
    private static final BitField calcOnOpen = null;
    private static final BitField colDeleted = null;
    private static final BitField oneOrTwoVar = null;
    private static final BitField rowDeleted = null;
    private static final BitField rowOrColInpCell = null;
    private int field_10_colInputCol;
    private int field_5_flags;
    private int field_6_res;
    private int field_7_rowInputRow;
    private int field_8_colInputRow;
    private int field_9_rowInputCol;

    static {
        alwaysCalc = BitFieldFactory.getInstance(1);
        calcOnOpen = BitFieldFactory.getInstance(2);
        rowOrColInpCell = BitFieldFactory.getInstance(4);
        oneOrTwoVar = BitFieldFactory.getInstance(8);
        rowDeleted = BitFieldFactory.getInstance(16);
        colDeleted = BitFieldFactory.getInstance(32);
    }

    public TableRecord(RecordInputStream r2) {
        super(r2);
        this.field_5_flags = r2.readByte();
        this.field_6_res = r2.readByte();
        this.field_7_rowInputRow = r2.readShort();
        this.field_8_colInputRow = r2.readShort();
        this.field_9_rowInputCol = r2.readShort();
        this.field_10_colInputCol = r2.readShort();
    }

    private static CellReference cr(int r4, int r5) {
        int r0 = r5 & 255;
        boolean r2 = true;
        if ((32768 & r5) != 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r5 & 16384) == 0) goto L11;
        r2 = false;
    L11:
        return new CellReference(r4, r0, r1, r2);
    L5:
        r1 = false;
        goto L7
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    public int getExtraDataSize() {
        return 10;
    }

    public int getFlags() {
        return this.field_5_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("range", new $$Lambda$1GWXM46CDMnkW3Ic2OG4EZ6B0(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$Xe_S5Dhw5z8kbZJ7wDLwqqPJFc(this), new BitField[]{alwaysCalc, calcOnOpen, rowOrColInpCell, oneOrTwoVar, rowDeleted, colDeleted}, new String[]{"ALWAYS_CALC", "CALC_ON_OPEN", "ROW_OR_COL_INP_CELL", "ONE_OR_TWO_VAR", "ROW_DELETED", "COL_DELETED"}), "reserved", new $$Lambda$TableRecord$wIsQsdQc2Hf00rEkeQBKDzHI5U8(this), "rowInput", new $$Lambda$TableRecord$cgWZkRu6wjDjkOlaxbQ38HUrZg(this), "colInput", new $$Lambda$TableRecord$vLReP7N9oz8tujLpVynU4Cc08M(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TABLE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 566;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TableRecord() {
        return Integer.valueOf(this.field_6_res);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$TableRecord() {
        return cr(this.field_7_rowInputRow, this.field_8_colInputRow);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$TableRecord() {
        return cr(this.field_9_rowInputCol, this.field_10_colInputCol);
    }
}
