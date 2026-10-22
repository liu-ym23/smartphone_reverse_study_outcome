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
public final class SheetPropertiesRecord extends StandardRecord {
    private static final BitField autoPlotArea = null;
    private static final BitField chartTypeManuallyFormatted = null;
    private static final BitField defaultPlotDimensions = null;
    private static final BitField doNotSizeWithWindow = null;
    private static final BitField plotVisibleOnly = null;
    private int field_1_flags;
    private int field_2_empty;

    static {
        chartTypeManuallyFormatted = BitFieldFactory.getInstance(1);
        plotVisibleOnly = BitFieldFactory.getInstance(2);
        doNotSizeWithWindow = BitFieldFactory.getInstance(4);
        defaultPlotDimensions = BitFieldFactory.getInstance(8);
        autoPlotArea = BitFieldFactory.getInstance(16);
    }

    public SheetPropertiesRecord() {
    }

    public SheetPropertiesRecord(RecordInputStream r2) {
        this.field_1_flags = r2.readUShort();
        this.field_2_empty = r2.readUShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public int getEmpty() {
        return this.field_2_empty;
    }

    public int getFlags() {
        return this.field_1_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$8xiv9fys0uUn0bz3hMW9NvlU7qk(this), new BitField[]{chartTypeManuallyFormatted, plotVisibleOnly, doNotSizeWithWindow, defaultPlotDimensions, autoPlotArea}, new String[]{"CHART_TYPE_MANUALLY_FORMATTED", "PLOT_VISIBLE_ONLY", "DO_NOT_SIZE_WITH_WINDOW", "DEFAULT_PLOT_DIMENSIONS", "AUTO_PLOT_AREA"}), "empty", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$cWX0fKNX6n0TaW_73iWyjWcB6oE(this), new int[]{0, 1, 2}, new String[]{"EMPTY_NOT_PLOTTED", "EMPTY_ZERO", "EMPTY_INTERPOLATED"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SHEET_PROPERTIES;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4164;
    }
}
