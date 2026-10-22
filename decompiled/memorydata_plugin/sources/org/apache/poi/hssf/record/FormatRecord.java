package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FormatRecord extends StandardRecord {
    private static final c LOG = null;
    private final int field_1_index_code;
    private final boolean field_3_hasMultibyte;
    private final String field_4_formatstring;

    static {
        LOG = b.a(FormatRecord.class);
    }

    public FormatRecord(int r1, String r2) {
        this.field_1_index_code = r1;
        this.field_4_formatstring = r2;
        this.field_3_hasMultibyte = StringUtil.hasMultibyte(r2);
    }

    public FormatRecord(RecordInputStream r5) {
        this.field_1_index_code = r5.readShort();
        int r0 = r5.readUShort();
        if ((r5.readByte() & 1) == 0) goto L5;
        boolean r1 = true;
    L6:
        this.field_3_hasMultibyte = r1;
        if (r1 == false) goto L9;
        String r6 = readStringCommon(r5, r0, false);
    L10:
        this.field_4_formatstring = r6;
        return;
    L9:
        r6 = readStringCommon(r5, r0, true);
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private static String readStringCommon(RecordInputStream r2, int r3, boolean r4) {
        if (r3 < 0) goto L31;
        if (r3 > 1048576) goto L31;
        int r0 = r2.remaining();
        if (r4 == true) goto L9;
        r0 = r0 / 2;
    L9:
        if (r3 != r0) goto L11;
        char[] r5 = new char[r3];
    L12:
        int r1 = 0;
    L14:
        if (r1 >= r5.length) goto L20;
        if (r4 == false) goto L17;
        int r6 = r2.readUByte();
    L18:
        r5[r1] = (char) r6;
        r1 = r1 + 1;
        goto L14
    L17:
        r6 = r2.readShort();
        goto L18
    L20:
        if (r2.available() != 1) goto L23;
        char[] r7 = Arrays.copyOf(r5, r5.length + 1);
        r7[r5.length] = (char) r2.readUByte();
        r5 = r7;
    L23:
        if (r2.available() <= 0) goto L29;
        LOG.atInfo().a("FormatRecord has {} unexplained bytes. Silently skipping", v.a(r2.available()));
    L26:
        if (r2.available() <= 0) goto L29;
        r2.readByte();
    L29:
        return new String(r5);
    L11:
        r5 = new char[r0];
    L31:
        throw new IllegalArgumentException("Bad requested string length (" + r3 + ")");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = getFormatString().length();
        if (this.field_3_hasMultibyte == false) goto L5;
        int r1 = 2;
    L7:
        return (r0 * r1) + 5;
    L5:
        r1 = 1;
        goto L7
    }

    public String getFormatString() {
        return this.field_4_formatstring;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("indexCode", new $$Lambda$Dteyf1F8CdIB2LMI8ay4C7J2No(this), "unicode", new $$Lambda$FormatRecord$bG8myktnq_3yrPfxqhAN_3ozkbc(this), "formatString", new $$Lambda$6FcqeIsAJEc0vvmiCZtyLhMb4(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FORMAT;
    }

    public int getIndexCode() {
        return this.field_1_index_code;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 1054;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FormatRecord() {
        return Boolean.valueOf(this.field_3_hasMultibyte);
    }
}
