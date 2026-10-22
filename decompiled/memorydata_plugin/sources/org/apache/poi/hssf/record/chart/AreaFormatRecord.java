package org.apache.poi.hssf.record.chart;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
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
public final class AreaFormatRecord extends StandardRecord {
    private static final BitField automatic = null;
    private static final BitField invert = null;
    private int field_1_foregroundColor;
    private int field_2_backgroundColor;
    private short field_3_pattern;
    private short field_4_formatFlags;
    private short field_5_forecolorIndex;
    private short field_6_backcolorIndex;

    static {
        automatic = BitFieldFactory.getInstance(1);
        invert = BitFieldFactory.getInstance(2);
    }

    public AreaFormatRecord() {
    }

    public AreaFormatRecord(RecordInputStream r2) {
        this.field_1_foregroundColor = r2.readInt();
        this.field_2_backgroundColor = r2.readInt();
        this.field_3_pattern = r2.readShort();
        this.field_4_formatFlags = r2.readShort();
        this.field_5_forecolorIndex = r2.readShort();
        this.field_6_backcolorIndex = r2.readShort();
    }

    public short getBackcolorIndex() {
        return this.field_6_backcolorIndex;
    }

    public int getBackgroundColor() {
        return this.field_2_backgroundColor;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    public short getForecolorIndex() {
        return this.field_5_forecolorIndex;
    }

    public int getForegroundColor() {
        return this.field_1_foregroundColor;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("foregroundColor", new $$Lambda$oLas0iXtNA1JHMh6FqrNx2AmyM(this));
        r0.put("backgroundColor", new $$Lambda$gnEp0BJVRA7KEJxoIQzSNiUN6E(this));
        r0.put(XSDatatype.FACET_PATTERN, new $$Lambda$92zCoylX35DGw85yMAqk1jbPC6k(this));
        r0.put("inverted", new $$Lambda$vRPxRFM1xRrKsWn_QnQXxiROZY(this));
        r0.put("automatic", new $$Lambda$Oo5vd1QPk_7tt8IaaTWOlPM6Iks(this));
        r0.put("formatFlags", new $$Lambda$vO5Tgipy70QTsTD1M08kWRMsSI0(this));
        r0.put("forecolorIndex", new $$Lambda$yBt8RpckVRNmKxC2C78PB0NDSbE(this));
        r0.put("backcolorIndex", new $$Lambda$CXuTFNgTNUT4hV_C3TYsI0BDvb0(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AREA_FORMAT;
    }

    public short getPattern() {
        return this.field_3_pattern;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4106;
    }

    public boolean isAutomatic() {
        return automatic.isSet(this.field_4_formatFlags);
    }

    public boolean isInvert() {
        return invert.isSet(this.field_4_formatFlags);
    }
}
