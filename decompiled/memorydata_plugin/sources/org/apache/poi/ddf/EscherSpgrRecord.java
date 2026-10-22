package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes6.dex */
public class EscherSpgrRecord extends EscherRecord {
    public static final short RECORD_ID = 0;
    private int field_1_rectX1;
    private int field_2_rectY1;
    private int field_3_rectX2;
    private int field_4_rectY2;

    static {
        RECORD_ID = EscherRecordTypes.SPGR.typeID;
    }

    public EscherSpgrRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        int r8 = r4 + 8;
        this.field_1_rectX1 = LittleEndian.getInt(r3, r8 + 0);
        this.field_2_rectY1 = LittleEndian.getInt(r3, r8 + 4);
        this.field_3_rectX2 = LittleEndian.getInt(r3, r8 + 8);
        this.field_4_rectY2 = LittleEndian.getInt(r3, r8 + 12);
        int r9 = r7 - 16;
        if (r9 != 0) goto L7;
        return 24 + r9;
    L7:
        throw new RecordFormatException("Expected no remaining bytes but got " + r9);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherSpgrRecord$ejMai3kWW0xCEXJykkRZET6P_E(this), "rectX1", new $$Lambda$MhQkCcNrM6WYQ2HGH9za1A67SjM(this), "rectY1", new $$Lambda$pHPv6TB9KcqhLtjUcwSGuwrjc_k(this), "rectX2", new $$Lambda$bzFnCsbGRfLtzJi6xEwfAeCPXYo(this), "rectY2", new $$Lambda$BmMEghGsRY_dnOq1UuczZvDdFA(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SPGR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    public int getRectX1() {
        return this.field_1_rectX1;
    }

    public int getRectX2() {
        return this.field_3_rectX2;
    }

    public int getRectY1() {
        return this.field_2_rectY1;
    }

    public int getRectY2() {
        return this.field_4_rectY2;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherSpgrRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r3, byte[] r4, EscherSerializationListener r5) {
        EscherSerializationListener r6 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r5, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r6.beforeRecordSerialize(r3, getRecordId(), this);
        LittleEndian.putShort(r4, r3, getOptions());
        LittleEndian.putShort(r4, r3 + 2, getRecordId());
        LittleEndian.putInt(r4, r3 + 4, 16);
        LittleEndian.putInt(r4, r3 + 8, this.field_1_rectX1);
        LittleEndian.putInt(r4, r3 + 12, this.field_2_rectY1);
        LittleEndian.putInt(r4, r3 + 16, this.field_3_rectX2);
        LittleEndian.putInt(r4, r3 + 20, this.field_4_rectY2);
        r6.afterRecordSerialize(getRecordSize() + r3, getRecordId(), r3 + getRecordSize(), this);
        return 24;
    }

    public void setRectX1(int r1) {
        this.field_1_rectX1 = r1;
    }

    public void setRectX2(int r1) {
        this.field_3_rectX2 = r1;
    }

    public void setRectY1(int r1) {
        this.field_2_rectY1 = r1;
    }

    public void setRectY2(int r1) {
        this.field_4_rectY2 = r1;
    }
}
