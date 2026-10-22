package org.apache.poi.hssf.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class CellRangeAddress8Bit extends CellRangeAddressBase {
    public CellRangeAddress8Bit(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public CellRangeAddress8Bit(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        super(readUShortAndCheck(r5), r5.readUShort(), r5.readUByte(), r5.readUByte());
    }

    public static int getEncodedSize(int r0) {
        return r0 * 6;
    }

    private static int readUShortAndCheck(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r4.available() < 6) goto L7;
        return r4.readUShort();
    L7:
        throw new IllegalArgumentException("Ran out of data reading CellRangeAddress, available: " + r4.available());
    }
}
