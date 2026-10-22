package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class AxisRecord extends StandardRecord {
    private short field_1_axisType;
    private int field_2_reserved1;
    private int field_3_reserved2;
    private int field_4_reserved3;
    private int field_5_reserved4;

    public AxisRecord() {
    }

    public AxisRecord(RecordInputStream r2) {
        this.field_1_axisType = r2.readShort();
        this.field_2_reserved1 = r2.readInt();
        this.field_3_reserved2 = r2.readInt();
        this.field_4_reserved3 = r2.readInt();
        this.field_5_reserved4 = r2.readInt();
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("axisType", new $$Lambda$h0McXzyhmm9R0MEopyrXABq5KI(this), "reserved1", new $$Lambda$yzaNVALuBtOoLYlxTxZambjQ7_E(this), "reserved2", new $$Lambda$vnc73vim00RRzSWNQucLEDiy1GQ(this), "reserved3", new $$Lambda$GmMoOH366_o0pDkbDcxeUWO38c(this), "reserved4", new $$Lambda$csN7iulaRgAMYN8DThInGwFyxdo(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS;
    }

    public int getReserved1() {
        return this.field_2_reserved1;
    }

    public int getReserved2() {
        return this.field_3_reserved2;
    }

    public int getReserved3() {
        return this.field_4_reserved3;
    }

    public int getReserved4() {
        return this.field_5_reserved4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4125;
    }
}
