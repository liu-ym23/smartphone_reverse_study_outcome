package org.apache.poi.hssf.record.cf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class IconMultiStateThreshold extends Threshold {
    private byte equals;

    public IconMultiStateThreshold() {
        this.equals = 1;
    }

    public IconMultiStateThreshold(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        super(r4);
        this.equals = r4.readByte();
        r4.readInt();
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public int getDataLength() {
        return super.getDataLength() + 5;
    }
}
