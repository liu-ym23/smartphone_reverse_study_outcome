package org.apache.poi.hssf.record.cf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class IconMultiStateFormatting implements GenericRecord {
    private static BitField ICON_ONLY;
    private static final c LOG = null;
    private static BitField REVERSED;
    private org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet;
    private byte options;
    private Threshold[] thresholds;

    static {
        LOG = b.a(IconMultiStateFormatting.class);
        ICON_ONLY = BitFieldFactory.getInstance(1);
        REVERSED = BitFieldFactory.getInstance(4);
    }

    public IconMultiStateFormatting() {
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet r0 = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.GYR_3_TRAFFIC_LIGHTS;
        this.iconSet = r0;
        this.options = 0;
        this.thresholds = new Threshold[r0.num];
    }

    public IconMultiStateFormatting(LittleEndianInput r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r5, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r6.readShort();
        r6.readByte();
        byte r0 = r6.readByte();
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet r1 = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.byId(r6.readByte());
        this.iconSet = r1;
        if (r1.num == r0) goto L5;
        LOG.atWarn().a("Inconsistent Icon Set definition, found {} but defined as {} entries", this.iconSet, v.a(r0));
    L5:
        this.options = r6.readByte();
        this.thresholds = new Threshold[this.iconSet.num];
        int r2 = 0;
    L6:
        Threshold[] r3 = this.thresholds;
        if (r2 >= r3.length) goto L9;
        r3[r2] = new IconMultiStateThreshold(r6);
        r2 = r2 + 1;
        goto L6
    }

    public int getDataLength() {
        Threshold[] r4 = this.thresholds;
        int r0 = r4.length;
        int r1 = 6;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 + r4[r2].getDataLength();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("iconSet", new $$Lambda$7Ey5mOHzSYK80veketjwMFfMy4(this), "iconOnly", new $$Lambda$v3aeTi_GzHtB8TX8rAgdif7edbQ(this), "reversed", new $$Lambda$wc2EvQRsOVRCQfSMHiri0EoIPo(this), "thresholds", new $$Lambda$umFGMSKhQIXC6EcoGNKqJdPS5M(this));
    }

    public org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet getIconSet() {
        return this.iconSet;
    }

    public Threshold[] getThresholds() {
        return this.thresholds;
    }

    public boolean isIconOnly() {
        return ICON_ONLY.isSet(this.options);
    }

    public boolean isReversed() {
        return REVERSED.isSet(this.options);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
