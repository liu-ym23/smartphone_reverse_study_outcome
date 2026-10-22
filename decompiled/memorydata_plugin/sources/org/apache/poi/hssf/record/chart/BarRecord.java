package org.apache.poi.hssf.record.chart;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;

/* JADX INFO: loaded from: classes7.dex */
public final class BarRecord extends StandardRecord {
    private static final BitField displayAsPercentage = null;
    private static final BitField horizontal = null;
    private static final BitField shadow = null;
    private static final BitField stacked = null;
    private short field_1_barSpace;
    private short field_2_categorySpace;
    private short field_3_formatFlags;

    static {
        horizontal = BitFieldFactory.getInstance(1);
        stacked = BitFieldFactory.getInstance(2);
        displayAsPercentage = BitFieldFactory.getInstance(4);
        shadow = BitFieldFactory.getInstance(8);
    }

    public BarRecord() {
    }

    public BarRecord(RecordInputStream r2) {
        this.field_1_barSpace = r2.readShort();
        this.field_2_categorySpace = r2.readShort();
        this.field_3_formatFlags = r2.readShort();
    }

    public short getBarSpace() {
        return this.field_1_barSpace;
    }

    public short getCategorySpace() {
        return this.field_2_categorySpace;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 6;
    }

    public short getFormatFlags() {
        return this.field_3_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("barSpace", new $$Lambda$_BxLrGQP2AOWEOBAg11n_X5Vcg(this));
        r0.put("categorySpace", new $$Lambda$VkGo7Y8GxD_wlYMnhNp8m9__pdU(this));
        r0.put("formatFlags", new $$Lambda$Xo_O8r41AKurAZZuCtnd0uif54(this));
        r0.put("horizontal", new $$Lambda$m420NLk7SVc72cnWZ_vVfp5xFZo(this));
        r0.put("stacked", new $$Lambda$lyfKR9hVGA0yl79WXMiUDfyOiVg(this));
        r0.put("displayAsPercentage", new $$Lambda$UyfpCMQHr95Cbn0TYg3JAne5oJ0(this));
        r0.put("shadow", new $$Lambda$LcS9DlTG0KYAxqDqRmwsasMwjE4(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BAR;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4119;
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_3_formatFlags);
    }

    public boolean isHorizontal() {
        return horizontal.isSet(this.field_3_formatFlags);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_3_formatFlags);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_3_formatFlags);
    }
}
