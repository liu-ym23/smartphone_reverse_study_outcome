package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final class BOFRecord extends StandardRecord {
    private int field_1_version;
    private int field_2_type;
    private int field_3_build;
    private int field_4_year;
    private int field_5_history;
    private int field_6_rversion;

    public BOFRecord() {
    }

    public BOFRecord(RecordInputStream r3) {
        this.field_1_version = r3.readShort();
        this.field_2_type = r3.readShort();
        if (r3.remaining() < 2) goto L6;
        this.field_3_build = r3.readShort();
    L6:
        if (r3.remaining() < 2) goto L9;
        this.field_4_year = r3.readShort();
    L9:
        if (r3.remaining() < 4) goto L12;
        this.field_5_history = r3.readInt();
    L12:
        if (r3.remaining() < 4) goto L15;
        this.field_6_rversion = r3.readInt();
        return;
    }

    private String getTypeName() {
        int r1 = this.field_2_type;
        if (r1 != 5) goto L5;
        return "workbook";
    L5:
        if (r1 != 6) goto L7;
        return "vb module";
    L7:
        if (r1 != 16) goto L9;
        return "worksheet";
    L9:
        if (r1 != 32) goto L11;
        return "chart";
    L11:
        if (r1 != 64) goto L13;
        return "excel 4 macro";
    L13:
        if (r1 == 256) goto L16;
        return "#error unknown type#";
    L16:
        return "workspace file";
    }

    public static /* synthetic */ String lambda$ZzCfIgj3uwa_PgOI99FqF0LLM7s(BOFRecord r0) {
        return r0.getTypeName();
    }

    public int getBuild() {
        return this.field_3_build;
    }

    public int getBuildYear() {
        return this.field_4_year;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("version", new $$Lambda$rPpUrGotmk50H_p3oxcymYywnaE(this));
        r0.put("type", new $$Lambda$oS80IxhjmqXZWLTWiTOzVKUY65A(this));
        r0.put("typeName", new $$Lambda$BOFRecord$ZzCfIgj3uwa_PgOI99FqF0LLM7s(this));
        r0.put("build", new $$Lambda$Z4MUCOKhvQQU5ZBJdOckO28qWs(this));
        r0.put("buildYear", new $$Lambda$qgSQe8Ul4KmWALI1PLmcnOHAr4(this));
        r0.put("history", new $$Lambda$bLrjPP6gdBq0hmywaZAwjEO7tk(this));
        r0.put("requiredVersion", new $$Lambda$fSmYBNS1xXG2Q3elJ172a2FyAw(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOF;
    }

    public int getHistoryBitMask() {
        return this.field_5_history;
    }

    public int getRequiredVersion() {
        return this.field_6_rversion;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2057;
    }

    public int getType() {
        return this.field_2_type;
    }

    public int getVersion() {
        return this.field_1_version;
    }

    public void setBuild(int r1) {
        this.field_3_build = r1;
    }

    public void setBuildYear(int r1) {
        this.field_4_year = r1;
    }

    public void setHistoryBitMask(int r1) {
        this.field_5_history = r1;
    }

    public void setRequiredVersion(int r1) {
        this.field_6_rversion = r1;
    }

    public void setType(int r1) {
        this.field_2_type = r1;
    }

    public void setVersion(int r1) {
        this.field_1_version = r1;
    }
}
