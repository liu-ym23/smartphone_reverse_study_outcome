package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherClientDataRecord extends EscherRecord {
    private static final byte[] EMPTY = null;
    private static int MAX_RECORD_LENGTH;
    public static final short RECORD_ID = 0;
    private byte[] remainingData;

    static {
        RECORD_ID = EscherRecordTypes.CLIENT_DATA.typeID;
        MAX_RECORD_LENGTH = 100000;
        EMPTY = new byte[0];
    }

    public EscherClientDataRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        int r8 = r4 + 8;
        if (r7 != 0) goto L5;
        byte[] r9 = EMPTY;
    L6:
        this.remainingData = r9;
        return r7 + 8;
    L5:
        r9 = IOUtils.safelyClone(r3, r8, r7, MAX_RECORD_LENGTH);
        goto L6
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherClientDataRecord$cwN8etHF8KFOqa3l5b2VXS9TEc0(this), "remainingData", new $$Lambda$LJzVnSHcEFo3GK0YBqImPpI_R0Y(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_DATA;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        byte[] r0 = this.remainingData;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return r1 + 8;
    L5:
        r1 = r0.length;
        goto L7
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherClientDataRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        if (this.remainingData != null) goto L5;
        this.remainingData = EMPTY;
    L5:
        LittleEndian.putShort(r6, r5, getOptions());
        LittleEndian.putShort(r6, r5 + 2, getRecordId());
        LittleEndian.putInt(r6, r5 + 4, this.remainingData.length);
        byte[] r0 = this.remainingData;
        int r2 = r5 + 8;
        System.arraycopy(r0, 0, r6, r2, r0.length);
        int r3 = r2 + this.remainingData.length;
        int r9 = r3 - r5;
        r8.afterRecordSerialize(r3, getRecordId(), r9, this);
        return r9;
    }

    public void setRemainingData(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = new byte[0];
    L5:
        this.remainingData = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }
}
