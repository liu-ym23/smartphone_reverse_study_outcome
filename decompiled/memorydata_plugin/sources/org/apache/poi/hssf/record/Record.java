package org.apache.poi.hssf.record;

import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Record extends RecordBase implements GenericRecord {
    public Record() {
    }

    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    public abstract HSSFRecordTypes getGenericRecordType();

    public abstract short getSid();

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
