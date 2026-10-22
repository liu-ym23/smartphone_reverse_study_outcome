package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class BinaryValueType implements Serializable {
    private static final long serialVersionUID = -2609017982625895534L;
    public byte[] rawData;

    public BinaryValueType(byte[] r1) {
        this.rawData = r1;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
    L18:
        return false;
    L5:
        if (r6.getClass() != BinaryValueType.class) goto L18;
        BinaryValueType r7 = (BinaryValueType) ZeusTransformUtils.preCheckCast(r6, BinaryValueType.class, "com.obric.memorydata.plugin");
        byte[] r0 = this.rawData;
        if (r0.length == r7.rawData.length) goto L10;
        return false;
    L10:
        int r1 = r0.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L16;
        if (this.rawData[r2] != r7.rawData[r2]) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    public int hashCode() {
        byte[] r3 = this.rawData;
        if (r3.length != 0) goto L7;
        return 293;
    L7:
        if (r3.length != 1) goto L11;
        return r3[0];
    L11:
        return (r3.length * r3[0]) * r3[1];
    }
}
