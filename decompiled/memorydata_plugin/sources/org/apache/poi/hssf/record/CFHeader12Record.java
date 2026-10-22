package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CFHeader12Record extends CFHeaderBase {
    private FtrHeader futureHeader;

    public CFHeader12Record() {
        createEmpty();
        FtrHeader r0 = new FtrHeader();
        this.futureHeader = r0;
        r0.setRecordType(2169);
    }

    public CFHeader12Record(RecordInputStream r2) {
        this.futureHeader = new FtrHeader(r2);
        read(r2);
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return FtrHeader.getDataSize() + super.getDataSize();
    }

    public FtrHeader getFutureHeader() {
        return this.futureHeader;
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$CFHeader12Record$IRlUlPMZrur5l9JY7A7YpBjsgwI(this), "futureHeader", new $$Lambda$fMSmYmYOlWbRoL6a2E3Kqf6WKI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_HEADER_12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2169;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CFHeader12Record() {
        return super.getGenericProperties();
    }
}
