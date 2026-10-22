package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherBitmapBlip extends EscherBlipRecord {
    public static final short RECORD_ID_DIB = 0;
    public static final short RECORD_ID_JPEG = 0;
    public static final short RECORD_ID_PNG = 0;
    private final byte[] field_1_UID;
    private byte field_2_marker;

    static {
        RECORD_ID_JPEG = EscherRecordTypes.BLIP_JPEG.typeID;
        RECORD_ID_PNG = EscherRecordTypes.BLIP_PNG.typeID;
        RECORD_ID_DIB = EscherRecordTypes.BLIP_DIB.typeID;
    }

    public EscherBitmapBlip() {
        this.field_1_UID = new byte[16];
        this.field_2_marker = -1;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r4, int r5, EscherRecordFactory r6) {
        EscherRecordFactory r7 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r6, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r8 = readHeader(r4, r5);
        int r9 = r5 + 8;
        System.arraycopy(r4, r9, this.field_1_UID, 0, 16);
        int r10 = r9 + 16;
        this.field_2_marker = r4[r10];
        setPictureData(r4, r10 + 1, r8 - 17);
        return r8 + 8;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherBitmapBlip$Blch8wedpi4iskhyZKryacNSHUo(this), "uid", new $$Lambda$4HKDQoM3GEnEzNv1y_WmLh8a13Q(this), "marker", new $$Lambda$_aHdkEQgV9urKuzjWELou9SC6aw(this));
    }

    public byte getMarker() {
        return this.field_2_marker;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        if (getPicturedata() != null) goto L5;
        int r1 = 0;
    L7:
        return r1 + 25;
    L5:
        r1 = getPicturedata().length;
        goto L7
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherBitmapBlip() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        LittleEndian.putShort(r6, r5, getOptions());
        LittleEndian.putShort(r6, r5 + 2, getRecordId());
        LittleEndian.putInt(r6, r5 + 4, getRecordSize() - 8);
        int r0 = r5 + 8;
        System.arraycopy(this.field_1_UID, 0, r6, r0, 16);
        r6[r0 + 16] = this.field_2_marker;
        byte[] r1 = getPicturedata();
        System.arraycopy(r1, 0, r6, r0 + 17, r1.length);
        r8.afterRecordSerialize(r5 + getRecordSize(), getRecordId(), getRecordSize(), this);
        return r1.length + 25;
    }
}
