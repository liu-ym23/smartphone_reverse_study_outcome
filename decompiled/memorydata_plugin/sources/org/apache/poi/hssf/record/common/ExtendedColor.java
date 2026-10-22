package org.apache.poi.hssf.record.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class ExtendedColor implements GenericRecord {
    private int colorIndex;
    private byte[] rgba;
    private int themeIndex;
    private double tint;
    private int type;

    public ExtendedColor() {
        this.type = 1;
        this.colorIndex = 0;
        this.tint = 0.0d;
    }

    public ExtendedColor(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r4.readInt();
        this.type = r0;
        if (r0 != 1) goto L6;
        this.colorIndex = r4.readInt();
    L12:
        this.tint = r4.readDouble();
        return;
    L6:
        if (r0 != 2) goto L9;
        byte[] r1 = new byte[4];
        this.rgba = r1;
        r4.readFully(r1);
        goto L12
    L9:
        if (r0 != 3) goto L11;
        this.themeIndex = r4.readInt();
        goto L12
    L11:
        r4.readInt();
        goto L12
    }

    public int getColorIndex() {
        return this.colorIndex;
    }

    public int getDataLength() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("type", new $$Lambda$vqBm5yj6Fm21_psYNNXUGxtSA(this), "tint", new $$Lambda$q4ndQQEexYh8_nUnAXCjxCMYoOE(this), "colorIndex", new $$Lambda$YccNQKcl8ubBnwjs3F7_tRLnmg(this), "rgba", new $$Lambda$AxiIv75KltVV00iJ6HdpDSrPJ70(this), "themeIndex", new $$Lambda$wejBRkJUsusvkNUw_jiNI7ZcKgc(this));
    }

    public byte[] getRGBA() {
        return this.rgba;
    }

    public int getThemeIndex() {
        return this.themeIndex;
    }

    public double getTint() {
        return this.tint;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
