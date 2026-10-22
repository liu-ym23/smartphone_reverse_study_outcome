package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class NoteRecord extends StandardRecord {
    private static final Byte DEFAULT_PADDING = null;
    public static final NoteRecord[] EMPTY_ARRAY = null;
    private int field_1_row;
    private int field_2_col;
    private short field_3_flags;
    private int field_4_shapeid;
    private boolean field_5_hasMultibyte;
    private String field_6_author;
    private Byte field_7_padding;

    static {
        EMPTY_ARRAY = new NoteRecord[0];
        DEFAULT_PADDING = (byte) 0;
    }

    public NoteRecord() {
        this.field_6_author = "";
        this.field_3_flags = 0;
        this.field_7_padding = DEFAULT_PADDING;
    }

    public NoteRecord(RecordInputStream r4) {
        this.field_1_row = r4.readUShort();
        this.field_2_col = r4.readShort();
        this.field_3_flags = r4.readShort();
        this.field_4_shapeid = r4.readUShort();
        short r0 = r4.readShort();
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.field_5_hasMultibyte = r1;
        if (r1 == false) goto L9;
        String r2 = StringUtil.readUnicodeLE(r4, r0);
    L10:
        this.field_6_author = r2;
        if (r4.available() != 1) goto L14;
        this.field_7_padding = Byte.valueOf(r4.readByte());
        return;
    L14:
        if (r4.available() != 2) goto L19;
        if (r0 != 0) goto L20;
        this.field_7_padding = Byte.valueOf(r4.readByte());
        r4.readByte();
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r2 = StringUtil.readCompressedUnicode(r4, r0);
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public String getAuthor() {
        return this.field_6_author;
    }

    public int getColumn() {
        return this.field_2_col;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = this.field_6_author.length();
        int r2 = 1;
        if (this.field_5_hasMultibyte == false) goto L5;
        int r1 = 2;
    L6:
        int r3 = (r0 * r1) + 11;
        if (this.field_7_padding != null) goto L10;
        r2 = 0;
    L10:
        return r3 + r2;
    L5:
        r1 = 1;
        goto L6
    }

    public short getFlags() {
        return this.field_3_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$kfKIHt6GPCj1wudshPyaaciLZeM(this), "column", new $$Lambda$DyaL9jW0aRaiTJwxC4qohGUkwqg(this), "flags", new $$Lambda$_hvdimzYP0nCbPN18yxyIMfkKjU(this), "shapeId", new $$Lambda$F_iVwNZEid5qzfeEhBI2_H3CVE(this), "author", new $$Lambda$BmcysDoISYcVPytaZtvSIe1Ptuo(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NOTE;
    }

    public int getRow() {
        return this.field_1_row;
    }

    public int getShapeId() {
        return this.field_4_shapeid;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 28;
    }
}
