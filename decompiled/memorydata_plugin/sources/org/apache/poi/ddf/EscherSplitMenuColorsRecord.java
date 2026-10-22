package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes6.dex */
public class EscherSplitMenuColorsRecord extends EscherRecord {
    public static final short RECORD_ID = 0;
    private int field_1_color1;
    private int field_2_color2;
    private int field_3_color3;
    private int field_4_color4;

    static {
        RECORD_ID = EscherRecordTypes.SPLIT_MENU_COLORS.typeID;
    }

    public EscherSplitMenuColorsRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        int r8 = r4 + 8;
        this.field_1_color1 = LittleEndian.getInt(r3, r8 + 0);
        this.field_2_color2 = LittleEndian.getInt(r3, r8 + 4);
        this.field_3_color3 = LittleEndian.getInt(r3, r8 + 8);
        this.field_4_color4 = LittleEndian.getInt(r3, r8 + 12);
        int r9 = r7 - 16;
        if (r9 != 0) goto L7;
        return 24 + r9;
    L7:
        throw new RecordFormatException("Expecting no remaining data but got " + r9 + " byte(s).");
    }

    public int getColor1() {
        return this.field_1_color1;
    }

    public int getColor2() {
        return this.field_2_color2;
    }

    public int getColor3() {
        return this.field_3_color3;
    }

    public int getColor4() {
        return this.field_4_color4;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherSplitMenuColorsRecord$GhP7cq90ljKrZ2LndD3zjjvzKmY(this), "color1", new $$Lambda$osEr9ylMjw6wjYpIlAnoi39sxAs(this), "color2", new $$Lambda$wSMgCRB7DdMVf1SNcnZ19PV7k(this), "color3", new $$Lambda$GnvexpWGVEVRO0Yi4iXq97J6ZV8(this), "color4", new $$Lambda$6pOTSPZp9ZcgClFCWmtVklYxkRM(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SPLIT_MENU_COLORS;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherSplitMenuColorsRecord() {
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
        LittleEndian.putInt(r4, r2, this.field_1_color1);
        int r7 = r2 + 4;
        LittleEndian.putInt(r4, r7, this.field_2_color2);
        int r8 = r7 + 4;
        LittleEndian.putInt(r4, r8, this.field_3_color3);
        int r9 = r8 + 4;
        LittleEndian.putInt(r4, r9, this.field_4_color4);
        int r10 = r9 + 4;
        r6.afterRecordSerialize(r10, getRecordId(), r10 - r3, this);
        return getRecordSize();
    }

    public void setColor1(int r1) {
        this.field_1_color1 = r1;
    }

    public void setColor2(int r1) {
        this.field_2_color2 = r1;
    }

    public void setColor3(int r1) {
        this.field_3_color3 = r1;
    }

    public void setColor4(int r1) {
        this.field_4_color4 = r1;
    }
}
