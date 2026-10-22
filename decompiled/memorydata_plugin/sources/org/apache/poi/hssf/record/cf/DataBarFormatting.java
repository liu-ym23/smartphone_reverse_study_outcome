package org.apache.poi.hssf.record.cf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class DataBarFormatting implements GenericRecord {
    private static final BitField ICON_ONLY = null;
    private static final c LOG = null;
    private static final BitField REVERSED = null;
    private ExtendedColor color;
    private byte options;
    private byte percentMax;
    private byte percentMin;
    private DataBarThreshold thresholdMax;
    private DataBarThreshold thresholdMin;

    static {
        LOG = b.a(DataBarFormatting.class);
        ICON_ONLY = BitFieldFactory.getInstance(1);
        REVERSED = BitFieldFactory.getInstance(4);
    }

    public DataBarFormatting() {
        this.options = 2;
    }

    public DataBarFormatting(LittleEndianInput r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r5, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r6.readShort();
        r6.readByte();
        this.options = r6.readByte();
        this.percentMin = r6.readByte();
        this.percentMax = r6.readByte();
        byte r0 = this.percentMin;
        if (r0 < 0) goto L5;
        if (r0 > 100) goto L5;
    L6:
        byte r1 = this.percentMax;
        if (r1 < 0) goto L9;
        if (r1 > 100) goto L9;
    L10:
        this.color = new ExtendedColor(r6);
        this.thresholdMin = new DataBarThreshold(r6);
        this.thresholdMax = new DataBarThreshold(r6);
        return;
    L9:
        LOG.atWarn().a("Inconsistent Maximum Percentage found {}", v.a(this.percentMax));
    L5:
        LOG.atWarn().a("Inconsistent Minimum Percentage found {}", v.a(this.percentMin));
        goto L6
    }

    public ExtendedColor getColor() {
        return this.color;
    }

    public int getDataLength() {
        return ((this.color.getDataLength() + 6) + this.thresholdMin.getDataLength()) + this.thresholdMax.getDataLength();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", GenericRecordUtil.getBitsAsString(new $$Lambda$DataBarFormatting$0yXo860VABl0XbuPv7FRdA4dY(this), new BitField[]{ICON_ONLY, REVERSED}, new String[]{"ICON_ONLY", "REVERSED"}), TypedValues.Custom.S_COLOR, new $$Lambda$xSoD2G1vFeoCDGRTfmzdT4sXKws(this), "percentMin", new $$Lambda$7DfmaEIw3FgUWHrQHgyJsHKrZE(this), "percentMax", new $$Lambda$II7qpcJey_zwlpCyC9MK2iBEjSs(this), "thresholdMin", new $$Lambda$USLrDF6ZWDdCsqlyJt6AZYVvgg(this), "thresholdMax", new $$Lambda$3A0vFH0SKadh3w1l2_vBpoFh8o(this));
    }

    public byte getPercentMax() {
        return this.percentMax;
    }

    public byte getPercentMin() {
        return this.percentMin;
    }

    public DataBarThreshold getThresholdMax() {
        return this.thresholdMax;
    }

    public DataBarThreshold getThresholdMin() {
        return this.thresholdMin;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$DataBarFormatting() {
        return Byte.valueOf(this.options);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
