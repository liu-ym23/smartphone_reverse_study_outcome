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
public final class SeriesLabelsRecord extends StandardRecord {
    private static final BitField labelAsPercentage = null;
    private static final BitField showActual = null;
    private static final BitField showBubbleSizes = null;
    private static final BitField showLabel = null;
    private static final BitField showPercent = null;
    private static final BitField smoothedLine = null;
    private short field_1_formatFlags;

    static {
        showActual = BitFieldFactory.getInstance(1);
        showPercent = BitFieldFactory.getInstance(2);
        labelAsPercentage = BitFieldFactory.getInstance(4);
        smoothedLine = BitFieldFactory.getInstance(8);
        showLabel = BitFieldFactory.getInstance(16);
        showBubbleSizes = BitFieldFactory.getInstance(32);
    }

    public SeriesLabelsRecord() {
    }

    public SeriesLabelsRecord(RecordInputStream r1) {
        this.field_1_formatFlags = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public short getFormatFlags() {
        return this.field_1_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("formatFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$BWGsIpuR2P5ajz5VQkJaAC1ufTA(this), new BitField[]{showActual, showPercent, labelAsPercentage, smoothedLine, showLabel, showBubbleSizes}, new String[]{"SHOW_ACTUAL", "SHOW_PERCENT", "LABEL_AS_PERCENTAGE", "SMOOTHED_LINE", "SHOW_LABEL", "SHOW_BUBBLE_SIZES"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES_LABELS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4108;
    }
}
