package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class LineFormatRecord extends StandardRecord {
    private static final BitField auto = null;
    private static final BitField drawTicks = null;
    private static final BitField unknown = null;
    private int field_1_lineColor;
    private short field_2_linePattern;
    private short field_3_weight;
    private short field_4_format;
    private short field_5_colourPaletteIndex;

    static {
        auto = BitFieldFactory.getInstance(1);
        drawTicks = BitFieldFactory.getInstance(4);
        unknown = BitFieldFactory.getInstance(4);
    }

    public LineFormatRecord() {
    }

    public LineFormatRecord(RecordInputStream r2) {
        this.field_1_lineColor = r2.readInt();
        this.field_2_linePattern = r2.readShort();
        this.field_3_weight = r2.readShort();
        this.field_4_format = r2.readShort();
        this.field_5_colourPaletteIndex = r2.readShort();
    }

    public short getColourPaletteIndex() {
        return this.field_5_colourPaletteIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    public short getFormat() {
        return this.field_4_format;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("lineColor", new $$Lambda$S7P9Nz_1LXtSSxJY0lcvXlLQCdQ(this), "linePattern", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$a5mX5CrfmAT92vv83ej2IVuMw(this), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, new String[]{"SOLID", "DASH", "DOT", "DASH_DOT", "DASH_DOT_DOT", "NONE", "DARK_GRAY_PATTERN", "MEDIUM_GRAY_PATTERN", "LIGHT_GRAY_PATTERN"}), "weight", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$8iln2EYKE7KctDYXW5WTLg8ROs(this), new int[]{-1, 0, 1, 2}, new String[]{"HAIRLINE", "NARROW", "MEDIUM", "WIDE"}), "format", GenericRecordUtil.getBitsAsString(new $$Lambda$UtQUbTKx17a4RBXXCTk1Wt_JUrM(this), new BitField[]{auto, drawTicks, unknown}, new String[]{"AUTO", "DRAWTICKS", "UNKNOWN"}), "colourPaletteIndex", new $$Lambda$0cUzF0is4z6jzKCMKYiz7_ZEiZs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LINE_FORMAT;
    }

    public int getLineColor() {
        return this.field_1_lineColor;
    }

    public short getLinePattern() {
        return this.field_2_linePattern;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4103;
    }

    public short getWeight() {
        return this.field_3_weight;
    }
}
