package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class CommonObjectDataSubRecord extends SubRecord {
    private static final BitField autofill = null;
    private static final BitField autoline = null;
    private static final BitField locked = null;
    private static final BitField printable = null;
    private short field_1_objectType;
    private int field_2_objectId;
    private short field_3_option;
    private int field_4_reserved1;
    private int field_5_reserved2;
    private int field_6_reserved3;

    static {
        locked = BitFieldFactory.getInstance(1);
        printable = BitFieldFactory.getInstance(16);
        autofill = BitFieldFactory.getInstance(8192);
        autoline = BitFieldFactory.getInstance(16384);
    }

    public CommonObjectDataSubRecord() {
    }

    CommonObjectDataSubRecord(LittleEndianInput r2, int r3, int r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r3 != 18) goto L7;
        this.field_1_objectType = r5.readShort();
        this.field_2_objectId = r5.readUShort();
        this.field_3_option = r5.readShort();
        this.field_4_reserved1 = r5.readInt();
        this.field_5_reserved2 = r5.readInt();
        this.field_6_reserved3 = r5.readInt();
        return;
    L7:
        throw new RecordFormatException("Expected size 18 but got (" + r3 + ")");
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("objectType", new $$Lambda$dzeDKFMMBaXv58FREEyv4u7EKfw(this), "objectId", new $$Lambda$7Pn_EnpH2IcjxC_0ryAC1gj44NQ(this), "option", GenericRecordUtil.getBitsAsString(new $$Lambda$3UcfxgavA5SzhCWs_iRHUrCCFTE(this), new BitField[]{locked, printable, autofill, autoline}, new String[]{"LOCKED", "PRINTABLE", "AUTOFILL", "AUTOLINE"}), "reserved1", new $$Lambda$0Vg8IAm0JCgxM5DwweqmF8ry6A(this), "reserved2", new $$Lambda$ChAQhecVt37qaBZSsxsoP_g178o(this), "reserved3", new $$Lambda$9FrKqYx7U5c726uwuOU59wDqBU(this));
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.COMMON_OBJECT_DATA;
    }

    public int getObjectId() {
        return this.field_2_objectId;
    }

    public short getObjectType() {
        return this.field_1_objectType;
    }

    public short getOption() {
        return this.field_3_option;
    }

    public int getReserved1() {
        return this.field_4_reserved1;
    }

    public int getReserved2() {
        return this.field_5_reserved2;
    }

    public int getReserved3() {
        return this.field_6_reserved3;
    }
}
