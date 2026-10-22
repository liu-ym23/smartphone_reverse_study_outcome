package org.apache.poi.ddf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherBSERecord extends EscherRecord {
    private static int MAX_RECORD_LENGTH = 100000;
    public static final short RECORD_ID = 0;
    private byte[] _remainingData;
    private byte field_10_unused2;
    private byte field_11_unused3;
    private EscherBlipRecord field_12_blipRecord;
    private byte field_1_blipTypeWin32;
    private byte field_2_blipTypeMacOS;
    private final byte[] field_3_uid;
    private short field_4_tag;
    private int field_5_size;
    private int field_6_ref;
    private int field_7_offset;
    private byte field_8_usage;
    private byte field_9_name;

    static {
        RECORD_ID = EscherRecordTypes.BSE.typeID;
    }

    public EscherBSERecord() {
        this.field_3_uid = new byte[16];
        this._remainingData = new byte[0];
        setRecordId(RECORD_ID);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r7, int r8, EscherRecordFactory r9) {
        EscherRecordFactory r10 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r9, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r0 = readHeader(r7, r8);
        int r11 = r8 + 8;
        this.field_1_blipTypeWin32 = r7[r11];
        this.field_2_blipTypeMacOS = r7[r11 + 1];
        int r4 = 0;
        System.arraycopy(r7, r11 + 2, this.field_3_uid, 0, 16);
        this.field_4_tag = LittleEndian.getShort(r7, r11 + 18);
        this.field_5_size = LittleEndian.getInt(r7, r11 + 20);
        this.field_6_ref = LittleEndian.getInt(r7, r11 + 24);
        this.field_7_offset = LittleEndian.getInt(r7, r11 + 28);
        this.field_8_usage = r7[r11 + 32];
        this.field_9_name = r7[r11 + 33];
        this.field_10_unused2 = r7[r11 + 34];
        this.field_11_unused3 = r7[r11 + 35];
        int r1 = r0 - 36;
        if (r1 <= 0) goto L5;
        int r2 = r11 + 36;
        EscherBlipRecord r3 = (EscherBlipRecord) ZeusTransformUtils.preCheckCast(r10.createRecord(r7, r2), EscherBlipRecord.class, "com.obric.memorydata.plugin");
        this.field_12_blipRecord = r3;
        int r12 = r3.fillFields(r7, r2, r10);
    L6:
        int r5 = r1 - r12;
        this._remainingData = IOUtils.safelyClone(r7, r11 + (r12 + 36), r5, MAX_RECORD_LENGTH);
        int r6 = (r5 + 8) + 36;
        EscherBlipRecord r13 = this.field_12_blipRecord;
        if (r13 == null) goto L11;
        r4 = r13.getRecordSize();
    L11:
        return r6 + r4;
    L5:
        r12 = 0;
        goto L6
    }

    public EscherBlipRecord getBlipRecord() {
        return this.field_12_blipRecord;
    }

    public byte getBlipTypeMacOS() {
        return this.field_2_blipTypeMacOS;
    }

    public byte getBlipTypeWin32() {
        return this.field_1_blipTypeWin32;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap(super.getGenericProperties());
        r0.put("blipTypeWin32", new $$Lambda$zGfx_ZPz6aFQ2fkJp73wTig6uc(this));
        r0.put("pictureTypeWin32", new $$Lambda$kdFKlM4_YnQpz7yslBYQ0ejMi4(this));
        r0.put("blipTypeMacOS", new $$Lambda$7OxdZOjpdDoCPtPnYIXJ7rFn8L4(this));
        r0.put("pictureTypeMacOS", new $$Lambda$57oCLeTPOrVg8zl4BW4LNGf1Fo(this));
        r0.put("suid", new $$Lambda$4l5x7jsBJkTzegVhpOJi8kpxFj8(this));
        r0.put(LocationMonitorConst.TAG, new $$Lambda$ODLWaffVdcLewAknDDYKTfdgCIc(this));
        r0.put("size", new $$Lambda$t_GxeLvqJdb0GXFNAoPi9h2d9FI(this));
        r0.put("ref", new $$Lambda$z8LkmFGVTExJeLDRPATRtwn2SEY(this));
        r0.put(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$u1FOsw8WokBjGdQvmdZAIdCyW_I(this));
        r0.put("usage", new $$Lambda$2GRhsvaunqwWfblSm16zladvv5s(this));
        r0.put(ActivityLifecycle.NAME, new $$Lambda$TcFzthhw5qGmZulS0nI6MqllsO4(this));
        r0.put("unused2", new $$Lambda$1Z600FleWtrwVXSKDXmTll_3emk(this));
        r0.put("unused3", new $$Lambda$d8XPZpNp1YvbHlJApkDURGTywo(this));
        r0.put("blipRecord", new $$Lambda$SIiuCPjNJCq6Jrwryoor3j00A(this));
        r0.put("remainingData", new $$Lambda$Qyn0ZHBm1gD4q595muqgzqWTx9Q(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.BSE;
    }

    public byte getName() {
        return this.field_9_name;
    }

    public int getOffset() {
        return this.field_7_offset;
    }

    public PictureData.PictureType getPictureTypeMacOS() {
        return PictureData.PictureType.forNativeID(this.field_2_blipTypeMacOS);
    }

    public PictureData.PictureType getPictureTypeWin32() {
        return PictureData.PictureType.forNativeID(this.field_1_blipTypeWin32);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        EscherBlipRecord r0 = this.field_12_blipRecord;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getRecordSize();
    L6:
        byte[] r3 = this._remainingData;
        if (r3 == null) goto L10;
        r1 = r3.length;
    L10:
        return (r2 + 44) + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public int getRef() {
        return this.field_6_ref;
    }

    public byte[] getRemainingData() {
        return this._remainingData;
    }

    public int getSize() {
        return this.field_5_size;
    }

    public short getTag() {
        return this.field_4_tag;
    }

    public byte[] getUid() {
        return this.field_3_uid;
    }

    public byte getUnused2() {
        return this.field_10_unused2;
    }

    public byte getUnused3() {
        return this.field_11_unused3;
    }

    public byte getUsage() {
        return this.field_8_usage;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r7, byte[] r8, EscherSerializationListener r9) {
        EscherSerializationListener r10 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r9, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r10.beforeRecordSerialize(r7, getRecordId(), this);
        if (this._remainingData != null) goto L5;
        this._remainingData = new byte[0];
    L5:
        LittleEndian.putShort(r8, r7, getOptions());
        LittleEndian.putShort(r8, r7 + 2, getRecordId());
        EscherBlipRecord r0 = this.field_12_blipRecord;
        if (r0 != null) goto L8;
        int r1 = 0;
    L9:
        LittleEndian.putInt(r8, r7 + 4, (this._remainingData.length + 36) + r1);
        int r2 = r7 + 8;
        r8[r2] = this.field_1_blipTypeWin32;
        r8[r7 + 9] = this.field_2_blipTypeMacOS;
        System.arraycopy(this.field_3_uid, 0, r8, r7 + 10, 16);
        LittleEndian.putShort(r8, r7 + 26, this.field_4_tag);
        LittleEndian.putInt(r8, r7 + 28, this.field_5_size);
        LittleEndian.putInt(r8, r7 + 32, this.field_6_ref);
        LittleEndian.putInt(r8, r7 + 36, this.field_7_offset);
        r8[r7 + 40] = this.field_8_usage;
        r8[r7 + 41] = this.field_9_name;
        r8[r7 + 42] = this.field_10_unused2;
        r8[r7 + 43] = this.field_11_unused3;
        EscherBlipRecord r3 = this.field_12_blipRecord;
        if (r3 == null) goto L12;
        int r4 = r3.serialize(r7 + 44, r8, new NullEscherSerializationListener());
    L13:
        byte[] r5 = this._remainingData;
        System.arraycopy(r5, 0, r8, (r7 + 44) + r4, r5.length);
        int r6 = ((r2 + 36) + this._remainingData.length) + r4;
        int r11 = r6 - r7;
        r10.afterRecordSerialize(r6, getRecordId(), r11, this);
        return r11;
    L12:
        r4 = 0;
        goto L13
    L8:
        r1 = r0.getRecordSize();
        goto L9
    }

    public void setBlipTypeMacOS(byte r1) {
        this.field_2_blipTypeMacOS = r1;
    }

    public void setBlipTypeWin32(byte r1) {
        this.field_1_blipTypeWin32 = r1;
    }

    public void setOffset(int r1) {
        this.field_7_offset = r1;
    }

    public void setSize(int r1) {
        this.field_5_size = r1;
    }

    public void setUid(byte[] r3) {
        if (r3 == null) goto L8;
        if (r3.length != 16) goto L8;
        byte[] r2 = this.field_3_uid;
        System.arraycopy(r3, 0, r2, 0, r2.length);
        return;
    L8:
        throw new IllegalArgumentException("uid must be byte[16]");
    }
}
