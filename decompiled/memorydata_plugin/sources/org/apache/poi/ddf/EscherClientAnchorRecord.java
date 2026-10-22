package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherClientAnchorRecord extends EscherRecord {
    private static int MAX_RECORD_LENGTH = 100000;
    public static final short RECORD_ID = 0;
    private short field_1_flag;
    private short field_2_col1;
    private short field_3_dx1;
    private short field_4_row1;
    private short field_5_dy1;
    private short field_6_col2;
    private short field_7_dx2;
    private short field_8_row2;
    private short field_9_dy2;
    private byte[] remainingData;
    private boolean shortRecord;

    static {
        RECORD_ID = EscherRecordTypes.CLIENT_ANCHOR.typeID;
    }

    public EscherClientAnchorRecord() {
        this.remainingData = new byte[0];
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r5, int r6, EscherRecordFactory r7) {
        EscherRecordFactory r8 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r7, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r9 = readHeader(r5, r6);
        int r10 = r6 + 8;
        int r1 = 18;
        if (r9 == 4) goto L8;
        this.field_1_flag = LittleEndian.getShort(r5, r10 + 0);
        this.field_2_col1 = LittleEndian.getShort(r5, r10 + 2);
        this.field_3_dx1 = LittleEndian.getShort(r5, r10 + 4);
        this.field_4_row1 = LittleEndian.getShort(r5, r10 + 6);
        if (r9 < 18) goto L7;
        this.field_5_dy1 = LittleEndian.getShort(r5, r10 + 8);
        this.field_6_col2 = LittleEndian.getShort(r5, r10 + 10);
        this.field_7_dx2 = LittleEndian.getShort(r5, r10 + 12);
        this.field_8_row2 = LittleEndian.getShort(r5, r10 + 14);
        this.field_9_dy2 = LittleEndian.getShort(r5, r10 + 16);
        this.shortRecord = false;
    L9:
        int r11 = r9 - r1;
        this.remainingData = IOUtils.safelyClone(r5, r10 + r1, r11, MAX_RECORD_LENGTH);
        return (r1 + 8) + r11;
    L7:
        this.shortRecord = true;
        r1 = 8;
        goto L9
    L8:
        r1 = 0;
        goto L9
    }

    public short getCol1() {
        return this.field_2_col1;
    }

    public short getCol2() {
        return this.field_6_col2;
    }

    public short getDx1() {
        return this.field_3_dx1;
    }

    public short getDx2() {
        return this.field_7_dx2;
    }

    public short getDy1() {
        return this.field_5_dy1;
    }

    public short getDy2() {
        return this.field_9_dy2;
    }

    public short getFlag() {
        return this.field_1_flag;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap(super.getGenericProperties());
        r0.put("flag", new $$Lambda$5ggqTg1_KPBY8GaF9zPe2XgVEY(this));
        r0.put("col1", new $$Lambda$rEf5mC4GrpEoitiMV5hVVNl1aw(this));
        r0.put("dx1", new $$Lambda$ZxN4E1t7mYg7azo8IRoYBOsC9u0(this));
        r0.put("row1", new $$Lambda$3UW2hwI4_wyqDL1ceVSmjqWIkA(this));
        r0.put("dy1", new $$Lambda$Frz7akRga0DHcTUsh_l9fIxX_A(this));
        r0.put("col2", new $$Lambda$PWFValqM0bmFbrhSNFXfE3o8fZk(this));
        r0.put("dx2", new $$Lambda$LZJwZRU8Gj2NOpcl3L6jiq6JtDc(this));
        r0.put("row2", new $$Lambda$dsElSoN5oELCi8QGE1zv9a3RRO8(this));
        r0.put("dy2", new $$Lambda$rO6DLIZbueiTwgCvWxKnEo0EEY(this));
        r0.put("remainingData", new $$Lambda$TetefaajInlh04TloRQFdxLtNY(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_ANCHOR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        if (this.shortRecord == false) goto L5;
        int r0 = 8;
    L6:
        int r1 = r0 + 8;
        byte[] r2 = this.remainingData;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.length;
        goto L11
    L5:
        r0 = 18;
        goto L6
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public short getRow1() {
        return this.field_4_row1;
    }

    public short getRow2() {
        return this.field_8_row2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r8, byte[] r9, EscherSerializationListener r10) {
        EscherSerializationListener r11 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r10, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r11.beforeRecordSerialize(r8, getRecordId(), this);
        if (this.remainingData != null) goto L5;
        this.remainingData = new byte[0];
    L5:
        LittleEndian.putShort(r9, r8, getOptions());
        LittleEndian.putShort(r9, r8 + 2, getRecordId());
        int r0 = this.remainingData.length;
        int r3 = 8;
        if (this.shortRecord == false) goto L8;
        int r2 = 8;
    L9:
        LittleEndian.putInt(r9, r8 + 4, r0 + r2);
        int r1 = r8 + 8;
        LittleEndian.putShort(r9, r1, this.field_1_flag);
        LittleEndian.putShort(r9, r8 + 10, this.field_2_col1);
        LittleEndian.putShort(r9, r8 + 12, this.field_3_dx1);
        LittleEndian.putShort(r9, r8 + 14, this.field_4_row1);
        if (this.shortRecord == true) goto L12;
        LittleEndian.putShort(r9, r8 + 16, this.field_5_dy1);
        LittleEndian.putShort(r9, r8 + 18, this.field_6_col2);
        LittleEndian.putShort(r9, r8 + 20, this.field_7_dx2);
        LittleEndian.putShort(r9, r8 + 22, this.field_8_row2);
        LittleEndian.putShort(r9, r8 + 24, this.field_9_dy2);
    L12:
        byte[] r4 = this.remainingData;
        if (this.shortRecord == false) goto L15;
        int r5 = 16;
    L16:
        System.arraycopy(r4, 0, r9, r5 + r8, r4.length);
        if (this.shortRecord == true) goto L20;
        r3 = 18;
    L20:
        int r6 = (r1 + r3) + this.remainingData.length;
        int r12 = r6 - r8;
        r11.afterRecordSerialize(r6, getRecordId(), r12, this);
        return r12;
    L15:
        r5 = 26;
        goto L16
    L8:
        r2 = 18;
        goto L9
    }
}
