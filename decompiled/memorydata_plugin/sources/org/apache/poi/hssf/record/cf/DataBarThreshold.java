package org.apache.poi.hssf.record.cf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class DataBarThreshold extends Threshold {
    public DataBarThreshold() {
    }

    public DataBarThreshold(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }
}
