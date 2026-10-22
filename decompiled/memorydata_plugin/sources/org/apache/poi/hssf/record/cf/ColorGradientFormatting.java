package org.apache.poi.hssf.record.cf;

import com.bytedance.bdlocation.trace.TraceCons;
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
public final class ColorGradientFormatting implements GenericRecord {
    private static final c LOGGER = null;
    private static final BitField background = null;
    private static final BitField clamp = null;
    private ExtendedColor[] colors;
    private final byte options;
    private ColorGradientThreshold[] thresholds;

    static {
        LOGGER = b.a(ColorGradientFormatting.class);
        clamp = BitFieldFactory.getInstance(1);
        background = BitFieldFactory.getInstance(2);
    }

    public ColorGradientFormatting() {
        this.options = 3;
        this.thresholds = new ColorGradientThreshold[3];
        this.colors = new ExtendedColor[3];
    }

    public ColorGradientFormatting(LittleEndianInput r7) {
        LittleEndianInput r8 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r7, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r8.readShort();
        r8.readByte();
        int r0 = r8.readByte();
        int r1 = r8.readByte();
        if (r0 == r1) goto L5;
        LOGGER.atWarn().a("Inconsistent Color Gradient definition, found {} vs {} entries", v.a(r0), v.a(r1));
    L5:
        this.options = r8.readByte();
        this.thresholds = new ColorGradientThreshold[r0];
        int r2 = 0;
        int r3 = 0;
    L6:
        ColorGradientThreshold[] r4 = this.thresholds;
        if (r3 >= r4.length) goto L9;
        r4[r3] = new ColorGradientThreshold(r8);
        r3 = r3 + 1;
        goto L6
    L9:
        this.colors = new ExtendedColor[r1];
    L11:
        if (r2 >= this.colors.length) goto L13;
        r8.readDouble();
        this.colors[r2] = new ExtendedColor(r8);
        r2 = r2 + 1;
        goto L11
    }

    private boolean getOptionFlag(BitField r1) {
        return r1.isSet(this.options);
    }

    public ExtendedColor[] getColors() {
        return this.colors;
    }

    public int getDataLength() {
        ColorGradientThreshold[] r0 = this.thresholds;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 6;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r3 = r3 + r0[r4].getDataLength();
        r4 = r4 + 1;
        goto L3
    L5:
        ExtendedColor[] r6 = this.colors;
        int r5 = r6.length;
    L6:
        if (r2 >= r5) goto L8;
        r3 = (r3 + r6[r2].getDataLength()) + 8;
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("clampToCurve", new $$Lambda$iH_Vl67pSfQcYiImyGGmb9lcMI(this), TraceCons.METRIC_BACKGROUND, new $$Lambda$egTo1Rz8il8rJjlcEsKfR5CKIQ(this), "thresholds", new $$Lambda$8HUwgUva6W4nl5xYbA_BB2owtuQ(this), "colors", new $$Lambda$06Ucv4q4hSEf97MH_okuRVVHFDY(this));
    }

    public ColorGradientThreshold[] getThresholds() {
        return this.thresholds;
    }

    public boolean isAppliesToBackground() {
        return getOptionFlag(background);
    }

    public boolean isClampToCurve() {
        return getOptionFlag(clamp);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
