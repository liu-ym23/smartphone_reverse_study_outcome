package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherBlipRecord extends EscherRecord {
    private static int MAX_RECORD_LENGTH = 104857600;
    public static final short RECORD_ID_END = 0;
    public static final short RECORD_ID_START = 0;
    private byte[] field_pictureData;

    static {
        RECORD_ID_START = EscherRecordTypes.BLIP_START.typeID;
        RECORD_ID_END = EscherRecordTypes.BLIP_END.typeID;
    }

    public EscherBlipRecord() {
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        this.field_pictureData = IOUtils.safelyClone(r3, r4 + 8, r7, MAX_RECORD_LENGTH);
        return r7 + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherBlipRecord$Da6WER_YvT614IDqx2F6teLL4sc(this), "pictureData", new $$Lambda$tI1JBRyEzPZlRN8b1gUKp6uJbg(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        EscherRecordTypes r1 = EscherRecordTypes.forTypeID(getRecordId());
        if (r1 == EscherRecordTypes.UNKNOWN) goto L6;
        return r1;
    L6:
        return EscherRecordTypes.BLIP_START;
    }

    public byte[] getPicturedata() {
        return this.field_pictureData;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_pictureData.length + 8;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherBlipRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r4, byte[] r5, EscherSerializationListener r6) {
        EscherSerializationListener r7 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r6, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r7.beforeRecordSerialize(r4, getRecordId(), this);
        LittleEndian.putShort(r5, r4, getOptions());
        LittleEndian.putShort(r5, r4 + 2, getRecordId());
        byte[] r0 = this.field_pictureData;
        int r8 = r4 + 4;
        System.arraycopy(r0, 0, r5, r8, r0.length);
        r7.afterRecordSerialize(r8 + this.field_pictureData.length, getRecordId(), this.field_pictureData.length + 4, this);
        return this.field_pictureData.length + 4;
    }

    public void setPictureData(byte[] r3) {
        if (r3 != null) goto L5;
        int r1 = 0;
    L6:
        setPictureData(r3, 0, r1);
        return;
    L5:
        r1 = r3.length;
        goto L6
    }

    public void setPictureData(byte[] r3, int r4, int r5) {
        if (r3 == null) goto L10;
        if (r4 < 0) goto L10;
        if (r5 < 0) goto L10;
        if (r3.length < (r4 + r5)) goto L10;
        this.field_pictureData = IOUtils.safelyClone(r3, r4, r5, MAX_RECORD_LENGTH);
        return;
    L10:
        throw new IllegalArgumentException("picture data can't be null");
    }
}
