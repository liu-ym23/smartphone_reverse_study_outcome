package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FtrHeader implements GenericRecord {
    private CellRangeAddress associatedRange;
    private short grbitFrt;
    private short recordType;

    public FtrHeader() {
        this.associatedRange = new CellRangeAddress(0, 0, 0, 0);
    }

    public FtrHeader(RecordInputStream r2) {
        this.recordType = r2.readShort();
        this.grbitFrt = r2.readShort();
        this.associatedRange = new CellRangeAddress(r2);
    }

    public static int getDataSize() {
        return 12;
    }

    public CellRangeAddress getAssociatedRange() {
        return this.associatedRange;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("recordType", new $$Lambda$kuFJx9OfYOudGYwjmrq53AcJRk8(this), "grbitFrt", new $$Lambda$dc5A59feidBlMxbdFDjPJNnkag(this), "associatedRange", new $$Lambda$Nu9YGz5So9ruzyVOWltMErcylQM(this));
    }

    public short getGrbitFrt() {
        return this.grbitFrt;
    }

    public short getRecordType() {
        return this.recordType;
    }

    public void setRecordType(short r1) {
        this.recordType = r1;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
