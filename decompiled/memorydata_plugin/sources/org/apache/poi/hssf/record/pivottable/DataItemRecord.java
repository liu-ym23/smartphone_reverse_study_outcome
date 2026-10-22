package org.apache.poi.hssf.record.pivottable;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DataItemRecord extends StandardRecord {
    private int df;
    private int ifmt;
    private int iiftab;
    private int isxvd;
    private int isxvdData;
    private int isxvi;
    private String name;

    public DataItemRecord(RecordInputStream r2) {
        this.isxvdData = r2.readUShort();
        this.iiftab = r2.readUShort();
        this.df = r2.readUShort();
        this.isxvd = r2.readUShort();
        this.isxvi = r2.readUShort();
        this.ifmt = r2.readUShort();
        this.name = r2.readString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return StringUtil.getEncodedSize(this.name) + 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("isxvdData", new $$Lambda$DataItemRecord$mOH0kY10NxA8Xi_WvY0KaiE7mw(this), "iiftab", new $$Lambda$DataItemRecord$zjstbDRuULFxrnQBkhecBn5quvo(this), "df", new $$Lambda$DataItemRecord$vT9k9ScCoLQiWtR4qt0M9B7npU(this), "isxvd", new $$Lambda$DataItemRecord$xrsoaVc3riWT1EkQkbObnmN5JLc(this), "isxvi", new $$Lambda$DataItemRecord$B0Y2m_xkh6S_fTE6Ue3bNjrBFKA(this), "ifmt", new $$Lambda$DataItemRecord$nGKaDqp5gShgxylgZ1WIsCM9wPs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DATA_ITEM;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 197;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DataItemRecord() {
        return Integer.valueOf(this.isxvdData);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DataItemRecord() {
        return Integer.valueOf(this.iiftab);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$DataItemRecord() {
        return Integer.valueOf(this.df);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$DataItemRecord() {
        return Integer.valueOf(this.isxvd);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$DataItemRecord() {
        return Integer.valueOf(this.isxvi);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$DataItemRecord() {
        return Integer.valueOf(this.ifmt);
    }
}
