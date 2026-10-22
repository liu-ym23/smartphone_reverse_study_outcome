package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FontBasisRecord extends StandardRecord {
    private short field_1_xBasis;
    private short field_2_yBasis;
    private short field_3_heightBasis;
    private short field_4_scale;
    private short field_5_indexToFontTable;

    public FontBasisRecord() {
    }

    public FontBasisRecord(RecordInputStream r2) {
        this.field_1_xBasis = r2.readShort();
        this.field_2_yBasis = r2.readShort();
        this.field_3_heightBasis = r2.readShort();
        this.field_4_scale = r2.readShort();
        this.field_5_indexToFontTable = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("xBasis", new $$Lambda$uj2KoTxpZcNprTUECwWuBxWMWPs(this), "yBasis", new $$Lambda$HT7IGwH_aP47Ahmy5MB1fZ50UX0(this), "heightBasis", new $$Lambda$XsE_zKbvc8C_pQVcTa4iH6l_Eoc(this), "scale", new $$Lambda$3F81sOxDoPTTqGmGGYYe7ralgQ(this), "indexToFontTable", new $$Lambda$ynxbc8c2iGHnOzaUHVz7kvxpqwQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FONT_BASIS;
    }

    public short getHeightBasis() {
        return this.field_3_heightBasis;
    }

    public short getIndexToFontTable() {
        return this.field_5_indexToFontTable;
    }

    public short getScale() {
        return this.field_4_scale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4192;
    }

    public short getXBasis() {
        return this.field_1_xBasis;
    }

    public short getYBasis() {
        return this.field_2_yBasis;
    }
}
