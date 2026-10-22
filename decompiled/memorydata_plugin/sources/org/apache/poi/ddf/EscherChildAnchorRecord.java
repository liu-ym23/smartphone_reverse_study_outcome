package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherChildAnchorRecord extends EscherRecord {
    public static final short RECORD_ID = 0;
    private int field_1_dx1;
    private int field_2_dy1;
    private int field_3_dx2;
    private int field_4_dy2;

    static {
        RECORD_ID = EscherRecordTypes.CHILD_ANCHOR.typeID;
    }

    public EscherChildAnchorRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        int r8 = r4 + 8;
        int r1 = 16;
        if (r7 == 8) goto L8;
        if (r7 != 16) goto L7;
        this.field_1_dx1 = LittleEndian.getInt(r3, r8 + 0);
        this.field_2_dy1 = LittleEndian.getInt(r3, r8 + 4);
        this.field_3_dx2 = LittleEndian.getInt(r3, r8 + 8);
        this.field_4_dy2 = LittleEndian.getInt(r3, r8 + 12);
    L10:
        return r1 + 8;
    L7:
        throw new RuntimeException("Invalid EscherChildAnchorRecord - neither 8 nor 16 bytes.");
    L8:
        this.field_1_dx1 = LittleEndian.getShort(r3, r8 + 0);
        this.field_2_dy1 = LittleEndian.getShort(r3, r8 + 2);
        this.field_3_dx2 = LittleEndian.getShort(r3, r8 + 4);
        this.field_4_dy2 = LittleEndian.getShort(r3, r8 + 6);
        r1 = 8;
        goto L10
    }

    public int getDx1() {
        return this.field_1_dx1;
    }

    public int getDx2() {
        return this.field_3_dx2;
    }

    public int getDy1() {
        return this.field_2_dy1;
    }

    public int getDy2() {
        return this.field_4_dy2;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherChildAnchorRecord$RxWGLQ7rqs6CSM7_0P5abVT44s(this), "x1", new $$Lambda$_0ccb1dajovq1eT1_p9BHuXGZfE(this), "y1", new $$Lambda$pwuhM5AR5dDC9YTWdzDcw_SqUow(this), "x2", new $$Lambda$EzvlILlhZn2D1WApYjjW_SO2npM(this), "y2", new $$Lambda$etk0zqYIgWuWKm55JrxXDYGPD0(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CHILD_ANCHOR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherChildAnchorRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r3, byte[] r4, EscherSerializationListener r5) {
        EscherSerializationListener r6 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r5, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r6.beforeRecordSerialize(r3, getRecordId(), this);
        LittleEndian.putShort(r4, r3, getOptions());
        int r0 = r3 + 2;
        LittleEndian.putShort(r4, r0, getRecordId());
        int r1 = r0 + 2;
        LittleEndian.putInt(r4, r1, getRecordSize() - 8);
        int r2 = r1 + 4;
        LittleEndian.putInt(r4, r2, this.field_1_dx1);
        int r7 = r2 + 4;
        LittleEndian.putInt(r4, r7, this.field_2_dy1);
        int r8 = r7 + 4;
        LittleEndian.putInt(r4, r8, this.field_3_dx2);
        int r9 = r8 + 4;
        LittleEndian.putInt(r4, r9, this.field_4_dy2);
        int r10 = r9 + 4;
        int r11 = r10 - r3;
        r6.afterRecordSerialize(r10, getRecordId(), r11, this);
        return r11;
    }
}
