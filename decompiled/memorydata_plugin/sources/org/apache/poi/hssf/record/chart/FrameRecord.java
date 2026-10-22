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
public final class FrameRecord extends StandardRecord {
    private static final BitField autoPosition = null;
    private static final BitField autoSize = null;
    private short field_1_borderType;
    private short field_2_options;

    static {
        autoSize = BitFieldFactory.getInstance(1);
        autoPosition = BitFieldFactory.getInstance(2);
    }

    public FrameRecord() {
    }

    public FrameRecord(RecordInputStream r2) {
        this.field_1_borderType = r2.readShort();
        this.field_2_options = r2.readShort();
    }

    public short getBorderType() {
        return this.field_1_borderType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("borderType", new $$Lambda$8mZRGhVwKs4jNx4B0uNwNqa1Etw(this), "options", new $$Lambda$PZPrH4Ev3xVN3RmdtMxoVhZkZvs(this), "autoSize", new $$Lambda$XhUredK2IBNbWL_gPb9RMsL6vTs(this), "autoPosition", new $$Lambda$VHy6w9Pe6X9KKXnbaix6Jm3pWoE(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FRAME;
    }

    public short getOptions() {
        return this.field_2_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4146;
    }

    public boolean isAutoPosition() {
        return autoPosition.isSet(this.field_2_options);
    }

    public boolean isAutoSize() {
        return autoSize.isSet(this.field_2_options);
    }
}
