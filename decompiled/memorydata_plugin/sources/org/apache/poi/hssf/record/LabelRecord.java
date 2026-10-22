package org.apache.poi.hssf.record;

import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class LabelRecord extends Record implements CellValueRecordInterface {
    private static final c LOG = null;
    private int field_1_row;
    private short field_2_column;
    private short field_3_xf_index;
    private short field_4_string_len;
    private byte field_5_unicode_flag;
    private String field_6_value;

    static {
        LOG = b.a(LabelRecord.class);
    }

    public LabelRecord() {
    }

    public LabelRecord(RecordInputStream r3) {
        this.field_1_row = r3.readUShort();
        this.field_2_column = r3.readShort();
        this.field_3_xf_index = r3.readShort();
        this.field_4_string_len = r3.readShort();
        this.field_5_unicode_flag = r3.readByte();
        if (this.field_4_string_len > 0) goto L5;
        String r0 = "";
    L9:
        this.field_6_value = r0;
        if (r3.remaining() <= 0) goto L13;
        LOG.atInfo().a("LabelRecord data remains: {} : {}", v.a(r3.remaining()), HexDump.toHex(r3.readRemainder()));
        return;
    L13:
        return;
    L5:
        if (isUnCompressedUnicode() == false) goto L7;
        r0 = r3.readUnicodeLEString(this.field_4_string_len);
        goto L9
    L7:
        r0 = r3.readCompressedUnicode(this.field_4_string_len);
        goto L9
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_column;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$8TLhGNsiSlQTawHfh6FWjZ5185I(this), "column", new $$Lambda$Mj0FoU0F97DebvwGAzWrc4NXyBY(this), "xfIndex", new $$Lambda$cGk8AZ6URV_LL2xViSgP6EUXg0(this), "stringLen", new $$Lambda$kw7lrzJA2_VvJmKaultXIcFy8qU(this), "unCompressedUnicode", new $$Lambda$UT7lxOQlL_4PbzUfLagyrnRbd0(this), EventBody.KEY_VALUE, new $$Lambda$PZqqSFuoutWrwsQh2v4VW7Z6NJQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LABEL;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 516;
    }

    public short getStringLength() {
        return this.field_4_string_len;
    }

    public String getValue() {
        return this.field_6_value;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf_index;
    }

    public boolean isUnCompressedUnicode() {
        if ((this.field_5_unicode_flag & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }
}
