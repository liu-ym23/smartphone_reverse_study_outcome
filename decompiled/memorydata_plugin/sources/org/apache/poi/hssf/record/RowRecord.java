package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class RowRecord extends StandardRecord {
    private static final BitField badFontHeight = null;
    private static final BitField bottomBorder = null;
    private static final BitField collapsed = null;
    private static final BitField formatted = null;
    private static final BitField outlineLevel = null;
    private static final BitField phoneticGuide = null;
    private static final BitField topBorder = null;
    private static final BitField xfIndex = null;
    private static final BitField zeroHeight = null;
    private int field_1_row_number;
    private int field_2_first_col;
    private int field_3_last_col;
    private short field_4_height;
    private short field_5_optimize;
    private short field_6_reserved;
    private int field_7_option_flags;
    private int field_8_option_flags;

    static {
        outlineLevel = BitFieldFactory.getInstance(7);
        collapsed = BitFieldFactory.getInstance(16);
        zeroHeight = BitFieldFactory.getInstance(32);
        badFontHeight = BitFieldFactory.getInstance(64);
        formatted = BitFieldFactory.getInstance(128);
        xfIndex = BitFieldFactory.getInstance(4095);
        topBorder = BitFieldFactory.getInstance(4096);
        bottomBorder = BitFieldFactory.getInstance(8192);
        phoneticGuide = BitFieldFactory.getInstance(16384);
    }

    public RowRecord(int r3) {
        if (r3 < 0) goto L7;
        this.field_1_row_number = r3;
        this.field_4_height = 255;
        this.field_5_optimize = 0;
        this.field_6_reserved = 0;
        this.field_7_option_flags = 256;
        this.field_8_option_flags = 15;
        setEmpty();
        return;
    L7:
        throw new IllegalArgumentException("Invalid row number (" + r3 + ")");
    }

    public RowRecord(RecordInputStream r3) {
        int r0 = r3.readUShort();
        this.field_1_row_number = r0;
        if (r0 < 0) goto L7;
        this.field_2_first_col = r3.readShort();
        this.field_3_last_col = r3.readShort();
        this.field_4_height = r3.readShort();
        this.field_5_optimize = r3.readShort();
        this.field_6_reserved = r3.readShort();
        this.field_7_option_flags = r3.readShort();
        this.field_8_option_flags = r3.readShort();
        return;
    L7:
        throw new IllegalArgumentException("Invalid row number " + this.field_1_row_number + " found in InputStream");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    public int getFirstCol() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("rowNumber", new $$Lambda$8qWVR5uEjdJUosA_UscCa02_tzg(this));
        r0.put("firstCol", new $$Lambda$tQV_xhpH4QH2trTfjTyZteEYRs(this));
        r0.put("lastCol", new $$Lambda$Sq64NLzxnbebcT8BB1TRTLtTpOA(this));
        r0.put("height", new $$Lambda$INfUBDpaIS_dkPsTAtGTTJEKHJs(this));
        r0.put("optimized", new $$Lambda$CH1YZCwRlhIAtwH0nVuF_bZdRcI(this));
        r0.put("reserved", new $$Lambda$RowRecord$X_51i65pcNyNDwhpIA9KVRqPt24(this));
        r0.put("options", GenericRecordUtil.getBitsAsString(new $$Lambda$7DGHoA8blubiDql0tg766LqDul8(this), new BitField[]{collapsed, zeroHeight, badFontHeight, formatted}, new String[]{"COLAPSED", "ZERO_HEIGHT", "BAD_FONT_HEIGHT", "FORMATTED"}));
        r0.put("outlineLevel", new $$Lambda$kxUfUGwvuc4KxKZpYRPPKDTjYUQ(this));
        r0.put("optionFlags2", GenericRecordUtil.getBitsAsString(new $$Lambda$y2geRpAILurDr2uLTFuEQVWMssY(this), new BitField[]{topBorder, bottomBorder, phoneticGuide}, new String[]{"TOP_BORDER", "BOTTOM_BORDER", "PHOENETIC_GUIDE"}));
        r0.put("xfIndex", new $$Lambda$Oeit_o1sOUH0D43lNbBsKxcUyw(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ROW;
    }

    public short getHeight() {
        return this.field_4_height;
    }

    public int getLastCol() {
        return this.field_3_last_col;
    }

    public short getOptimize() {
        return this.field_5_optimize;
    }

    public short getOptionFlags() {
        return (short) this.field_7_option_flags;
    }

    public short getOptionFlags2() {
        return (short) this.field_8_option_flags;
    }

    public short getOutlineLevel() {
        return (short) outlineLevel.getValue(this.field_7_option_flags);
    }

    public int getRowNumber() {
        return this.field_1_row_number;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 520;
    }

    public short getXFIndex() {
        return xfIndex.getShortValue((short) this.field_8_option_flags);
    }

    public boolean getZeroHeight() {
        return zeroHeight.isSet(this.field_7_option_flags);
    }

    public boolean isEmpty() {
        int r0 = this.field_2_first_col;
        if ((this.field_3_last_col | r0) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$RowRecord() {
        return Short.valueOf(this.field_6_reserved);
    }

    public void setBadFontHeight(boolean r3) {
        this.field_7_option_flags = badFontHeight.setBoolean(this.field_7_option_flags, r3);
    }

    public void setEmpty() {
        this.field_2_first_col = 0;
        this.field_3_last_col = 0;
    }

    public void setFirstCol(int r1) {
        this.field_2_first_col = r1;
    }

    public void setHeight(short r1) {
        this.field_4_height = r1;
    }

    public void setLastCol(int r1) {
        this.field_3_last_col = r1;
    }

    public void setRowNumber(int r1) {
        this.field_1_row_number = r1;
    }
}
