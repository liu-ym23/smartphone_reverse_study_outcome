package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherDgRecord extends EscherRecord {
    public static final short RECORD_ID = 0;
    private int field_1_numShapes;
    private int field_2_lastMSOSPID;

    static {
        RECORD_ID = EscherRecordTypes.DG.typeID;
    }

    public EscherDgRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        readHeader(r3, r4);
        int r7 = r4 + 8;
        this.field_1_numShapes = LittleEndian.getInt(r3, r7 + 0);
        this.field_2_lastMSOSPID = LittleEndian.getInt(r3, r7 + 4);
        return getRecordSize();
    }

    public short getDrawingGroupId() {
        return (short) (getOptions() >> 4);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherDgRecord$FRX4ZOSYg8u61SVuTJWtAkAAypc(this), "numShapes", new $$Lambda$1IVFRXxwdiPXATbxLjt76cv5XX8(this), "lastMSOSPID", new $$Lambda$Jg3WfZhdcDe6ENzUwAU1KwAVMk(this), "drawingGroupId", new $$Lambda$7GBarAutlAktbfnFmj4ZadJBP8g(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.DG;
    }

    public int getLastMSOSPID() {
        return this.field_2_lastMSOSPID;
    }

    public int getNumShapes() {
        return this.field_1_numShapes;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherDgRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r3, byte[] r4, EscherSerializationListener r5) {
        EscherSerializationListener r6 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r5, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r6.beforeRecordSerialize(r3, getRecordId(), this);
        LittleEndian.putShort(r4, r3, getOptions());
        LittleEndian.putShort(r4, r3 + 2, getRecordId());
        LittleEndian.putInt(r4, r3 + 4, 8);
        LittleEndian.putInt(r4, r3 + 8, this.field_1_numShapes);
        LittleEndian.putInt(r4, r3 + 12, this.field_2_lastMSOSPID);
        r6.afterRecordSerialize(r3 + 16, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setLastMSOSPID(int r1) {
        this.field_2_lastMSOSPID = r1;
    }

    public void setNumShapes(int r1) {
        this.field_1_numShapes = r1;
    }
}
