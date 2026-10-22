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
public final class DatRecord extends StandardRecord {
    private static final BitField border = null;
    private static final BitField horizontalBorder = null;
    private static final BitField showSeriesKey = null;
    private static final BitField verticalBorder = null;
    private short field_1_options;

    static {
        horizontalBorder = BitFieldFactory.getInstance(1);
        verticalBorder = BitFieldFactory.getInstance(2);
        border = BitFieldFactory.getInstance(4);
        showSeriesKey = BitFieldFactory.getInstance(8);
    }

    public DatRecord() {
    }

    public DatRecord(RecordInputStream r1) {
        this.field_1_options = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$XPRb2Q8Kzo_RTdfyc1kqlUzw6bk(this), "horizontalBorder", new $$Lambda$18VJM08mXaENjnAuYWRqtBi7eQg(this), "verticalBorder", new $$Lambda$icSMyddsh4uebG1H5RyOlNELk(this), "border", new $$Lambda$s26dw5U4qMeYKE6PfZ8LjD90f7Y(this), "showSeriesKey", new $$Lambda$mKc1aU1Z8GaU3idMdVii3nEjE(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DAT;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4195;
    }

    public boolean isBorder() {
        return border.isSet(this.field_1_options);
    }

    public boolean isHorizontalBorder() {
        return horizontalBorder.isSet(this.field_1_options);
    }

    public boolean isShowSeriesKey() {
        return showSeriesKey.isSet(this.field_1_options);
    }

    public boolean isVerticalBorder() {
        return verticalBorder.isSet(this.field_1_options);
    }
}
