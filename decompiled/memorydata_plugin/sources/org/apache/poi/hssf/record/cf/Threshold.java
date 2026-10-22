package org.apache.poi.hssf.record.cf;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Threshold implements GenericRecord {
    private Formula formula;
    private byte type;
    private Double value;

    public Threshold() {
        this.type = (byte) ConditionalFormattingThreshold.RangeType.NUMBER.id;
        this.formula = Formula.create(null);
        this.value = Double.valueOf(0.0d);
    }

    public Threshold(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.type = r4.readByte();
        short r0 = r4.readShort();
        if (r0 <= 0) goto L5;
        Formula r1 = Formula.read(r0, r4);
    L6:
        this.formula = r1;
        if (r0 == 0) goto L9;
        return;
    L9:
        if (this.type != ConditionalFormattingThreshold.RangeType.MIN.id) goto L11;
        return;
    L11:
        if (this.type == ConditionalFormattingThreshold.RangeType.MAX.id) goto L16;
        this.value = Double.valueOf(r4.readDouble());
        return;
    L16:
        return;
    L5:
        r1 = Formula.create(null);
        goto L6
    }

    public int getDataLength() {
        int r0 = this.formula.getEncodedSize() + 1;
        if (this.value != null) goto L5;
        return r0;
    L5:
        return r0 + 8;
    }

    public Formula getFormula() {
        return this.formula;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("type", new $$Lambda$t6H3xtd1yxTU9mKe6MJy2yR2JK4(this), "formula", new $$Lambda$BmJ4YqDDlYT7hlB3HRZnuoj384M(this), EventBody.KEY_VALUE, new $$Lambda$ftIkufPxx3RhFNZt5qiZAXq2UFY(this));
    }

    public byte getType() {
        return this.type;
    }

    public Double getValue() {
        return this.value;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
