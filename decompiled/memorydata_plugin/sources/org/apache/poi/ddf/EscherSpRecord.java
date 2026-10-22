package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherSpRecord extends EscherRecord {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    public static final short RECORD_ID = 0;
    private int field_1_shapeId;
    private int field_2_flags;

    static {
        RECORD_ID = EscherRecordTypes.SP.typeID;
        FLAGS_MASKS = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
        FLAGS_NAMES = new String[]{"GROUP", "CHILD", "PATRIARCH", "DELETED", "OLESHAPE", "HAVEMASTER", "FLIPHORIZ", "FLIPVERT", "CONNECTOR", "HAVEANCHOR", "BACKGROUND", "HASSHAPETYPE"};
    }

    public EscherSpRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        readHeader(r3, r4);
        int r7 = r4 + 8;
        this.field_1_shapeId = LittleEndian.getInt(r3, r7 + 0);
        this.field_2_flags = LittleEndian.getInt(r3, r7 + 4);
        return getRecordSize();
    }

    public int getFlags() {
        return this.field_2_flags;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherSpRecord$d7J0wHkYUh8o5qR7AHsXR90hs(this), "shapeType", new $$Lambda$iR12aidINj9FVCZ1C2VGDR6r6vs(this), "shapeId", new $$Lambda$y5S2fovxyUNrqTWfewc9X_Fq3k(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$kW6hbWMWcCcIA6GAVVsxEYtyFNA(this), FLAGS_MASKS, FLAGS_NAMES));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SP;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    public int getShapeId() {
        return this.field_1_shapeId;
    }

    public short getShapeType() {
        return getInstance();
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherSpRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r3, byte[] r4, EscherSerializationListener r5) {
        EscherSerializationListener r6 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r5, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r6.beforeRecordSerialize(r3, getRecordId(), this);
        LittleEndian.putShort(r4, r3, getOptions());
        LittleEndian.putShort(r4, r3 + 2, getRecordId());
        LittleEndian.putInt(r4, r3 + 4, 8);
        LittleEndian.putInt(r4, r3 + 8, this.field_1_shapeId);
        LittleEndian.putInt(r4, r3 + 12, this.field_2_flags);
        r6.afterRecordSerialize(r3 + getRecordSize(), getRecordId(), getRecordSize(), this);
        return 16;
    }

    public void setFlags(int r1) {
        this.field_2_flags = r1;
    }

    public void setShapeId(int r1) {
        this.field_1_shapeId = r1;
    }

    public void setShapeType(short r1) {
        setInstance(r1);
    }
}
