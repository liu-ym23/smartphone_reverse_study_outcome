package org.apache.poi.hssf.record.chart;

import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.bdlocation.trace.TraceCons;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class TickRecord extends StandardRecord {
    private static final BitField autoTextBackground = null;
    private static final BitField autoTextColor = null;
    private static final BitField autorotate = null;
    private static final BitField rotation = null;
    private short field_10_options;
    private short field_11_tickColor;
    private short field_12_zero5;
    private byte field_1_majorTickType;
    private byte field_2_minorTickType;
    private byte field_3_labelPosition;
    private byte field_4_background;
    private int field_5_labelColorRgb;
    private int field_6_zero1;
    private int field_7_zero2;
    private int field_8_zero3;
    private int field_9_zero4;

    static {
        autoTextColor = BitFieldFactory.getInstance(1);
        autoTextBackground = BitFieldFactory.getInstance(2);
        rotation = BitFieldFactory.getInstance(28);
        autorotate = BitFieldFactory.getInstance(32);
    }

    public TickRecord() {
    }

    public TickRecord(RecordInputStream r2) {
        this.field_1_majorTickType = r2.readByte();
        this.field_2_minorTickType = r2.readByte();
        this.field_3_labelPosition = r2.readByte();
        this.field_4_background = r2.readByte();
        this.field_5_labelColorRgb = r2.readInt();
        this.field_6_zero1 = r2.readInt();
        this.field_7_zero2 = r2.readInt();
        this.field_8_zero3 = r2.readInt();
        this.field_9_zero4 = r2.readInt();
        this.field_10_options = r2.readShort();
        this.field_11_tickColor = r2.readShort();
        this.field_12_zero5 = r2.readShort();
    }

    public byte getBackground() {
        return this.field_4_background;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 30;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("majorTickType", new $$Lambda$MKvkX8a7oHBnPrfGdz0rlVV6yN4(this));
        r0.put("minorTickType", new $$Lambda$onf8ELHv_Eu0KrePLAiFHNLJrE(this));
        r0.put("labelPosition", new $$Lambda$MIZ5cxJCA5MjJYYfwHbsrbu1JM(this));
        r0.put(TraceCons.METRIC_BACKGROUND, new $$Lambda$DTHyP4Frj2s9HCJKGI6hmh15GVo(this));
        r0.put("labelColorRgb", new $$Lambda$RDE5HbYWzRcsKgoLqlAAr5FdjVU(this));
        r0.put("zero1", new $$Lambda$t3d1Y5KXVVhmiSzdGmrvrwp_PgQ(this));
        r0.put("zero2", new $$Lambda$poHIiHSZKrIljy3v8FmF5w2kpI(this));
        r0.put("options", GenericRecordUtil.getBitsAsString(new $$Lambda$NZFsToEJjR7DP3Ganw42kmfiQKU(this), new BitField[]{autoTextColor, autoTextBackground, autorotate}, new String[]{"AUTO_TEXT_COLOR", "AUTO_TEXT_BACKGROUND", "AUTO_ROTATE"}));
        r0.put(Key.ROTATION, new $$Lambda$fqDsoACp6BzyQ1Y6vKu562S7Vh8(this));
        r0.put("tickColor", new $$Lambda$BKxRkBOcL4OdpcsyTS62ThDfbf4(this));
        r0.put("zero3", new $$Lambda$nBwMqAR8pcIvLpMmZJkwemzDYpI(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TICK;
    }

    public int getLabelColorRgb() {
        return this.field_5_labelColorRgb;
    }

    public byte getLabelPosition() {
        return this.field_3_labelPosition;
    }

    public byte getMajorTickType() {
        return this.field_1_majorTickType;
    }

    public byte getMinorTickType() {
        return this.field_2_minorTickType;
    }

    public short getOptions() {
        return this.field_10_options;
    }

    public short getRotation() {
        return rotation.getShortValue(this.field_10_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4126;
    }

    public short getTickColor() {
        return this.field_11_tickColor;
    }

    public int getZero1() {
        return this.field_6_zero1;
    }

    public int getZero2() {
        return this.field_7_zero2;
    }

    public short getZero3() {
        return this.field_12_zero5;
    }
}
