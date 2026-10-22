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
public final class LegendRecord extends StandardRecord {
    private static final BitField autoPosition = null;
    private static final BitField autoSeries = null;
    private static final BitField autoXPositioning = null;
    private static final BitField autoYPositioning = null;
    private static final BitField dataTable = null;
    private static final BitField vertical = null;
    private int field_1_xAxisUpperLeft;
    private int field_2_yAxisUpperLeft;
    private int field_3_xSize;
    private int field_4_ySize;
    private byte field_5_type;
    private byte field_6_spacing;
    private short field_7_options;

    static {
        autoPosition = BitFieldFactory.getInstance(1);
        autoSeries = BitFieldFactory.getInstance(2);
        autoXPositioning = BitFieldFactory.getInstance(4);
        autoYPositioning = BitFieldFactory.getInstance(8);
        vertical = BitFieldFactory.getInstance(16);
        dataTable = BitFieldFactory.getInstance(32);
    }

    public LegendRecord() {
    }

    public LegendRecord(RecordInputStream r2) {
        this.field_1_xAxisUpperLeft = r2.readInt();
        this.field_2_yAxisUpperLeft = r2.readInt();
        this.field_3_xSize = r2.readInt();
        this.field_4_ySize = r2.readInt();
        this.field_5_type = r2.readByte();
        this.field_6_spacing = r2.readByte();
        this.field_7_options = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("xAxisUpperLeft", new $$Lambda$0D2BXHOxeqyof43dS5w0nlR6d_A(this), "yAxisUpperLeft", new $$Lambda$L72rCVKwkpa_phlzvJm8HX22u0(this), "xSize", new $$Lambda$WcquTSWfLSNSi9JXpEvFMMDNtl0(this), "ySize", new $$Lambda$D88ve6Qjehg3aXGsXuCcr58AQJg(this), "type", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$CdDFkMSYkPksU0H0hN1vlmzJpbQ(this), new int[]{0, 1, 2, 3, 4, 7}, new String[]{"BOTTOM", "CORNER", "TOP", "RIGHT", "LEFT", "UNDOCKED"}), "spacing", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$P4ORa97_iBtZeZz8Y6VwWaIYjaM(this), new int[]{0, 1, 2}, new String[]{"CLOSE", "MEDIUM", "OPEN"}), "options", GenericRecordUtil.getBitsAsString(new $$Lambda$w09ASUyvwrs8TIgffh8JgT7I0ig(this), new BitField[]{autoPosition, autoSeries, autoXPositioning, autoYPositioning, vertical, dataTable}, new String[]{"AUTO_POSITION", "AUTO_SERIES", "AUTO_X_POSITIONING", "AUTO_Y_POSITIONING", "VERTICAL", "DATA_TABLE"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LEGEND;
    }

    public short getOptions() {
        return this.field_7_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4117;
    }

    public byte getSpacing() {
        return this.field_6_spacing;
    }

    public byte getType() {
        return this.field_5_type;
    }

    public int getXAxisUpperLeft() {
        return this.field_1_xAxisUpperLeft;
    }

    public int getXSize() {
        return this.field_3_xSize;
    }

    public int getYAxisUpperLeft() {
        return this.field_2_yAxisUpperLeft;
    }

    public int getYSize() {
        return this.field_4_ySize;
    }
}
