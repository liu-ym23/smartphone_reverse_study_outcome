package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherTextboxRecord extends EscherRecord {
    private static int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static int MAX_RECORD_LENGTH = 100000;
    private static final byte[] NO_BYTES = null;
    public static final short RECORD_ID = 0;
    private byte[] thedata;

    static {
        RECORD_ID = EscherRecordTypes.CLIENT_TEXTBOX.typeID;
        NO_BYTES = new byte[0];
    }

    public EscherTextboxRecord() {
        this.thedata = NO_BYTES;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        this.thedata = IOUtils.safelyClone(r3, r4 + 8, r7, MAX_RECORD_LENGTH);
        return r7 + 8;
    }

    public byte[] getData() {
        return this.thedata;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherTextboxRecord$9bNIVtZRpTnk_Ihb4NFBYseKKEE(this), "isContainer", new $$Lambda$BgVfNbKz8_Np37FvU0NuwxI8_3Q(this), "extraData", new $$Lambda$tWMquXYbXvRUBKzokurRQJT914(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_TEXTBOX;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherTextboxRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        LittleEndian.putShort(r6, r5, getOptions());
        LittleEndian.putShort(r6, r5 + 2, getRecordId());
        LittleEndian.putInt(r6, r5 + 4, this.thedata.length);
        byte[] r0 = this.thedata;
        int r1 = r5 + 8;
        System.arraycopy(r0, 0, r6, r1, r0.length);
        int r2 = r1 + this.thedata.length;
        int r9 = r2 - r5;
        r8.afterRecordSerialize(r2, getRecordId(), r9, this);
        if (r9 != getRecordSize()) goto L6;
        return r9;
    L6:
        throw new RecordFormatException(r9 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    public void setData(byte[] r3) {
        setData(r3, 0, r3.length);
    }

    public void setData(byte[] r2, int r3, int r4) {
        this.thedata = IOUtils.safelyClone(r2, r3, r4, MAX_RECORD_LENGTH);
    }
}
