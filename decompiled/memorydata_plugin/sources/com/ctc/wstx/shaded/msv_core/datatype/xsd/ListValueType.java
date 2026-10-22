package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ListValueType implements Serializable {
    private static final long serialVersionUID = 1;
    public final Object[] values;

    public ListValueType(Object[] r1) {
        this.values = r1;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
    L18:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, ListValueType.class) == false) goto L18;
        ListValueType r7 = (ListValueType) ZeusTransformUtils.preCheckCast(r6, ListValueType.class, "com.obric.memorydata.plugin");
        int r0 = this.values.length;
        if (r0 == r7.values.length) goto L10;
        return false;
    L10:
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L16;
        if (this.values[r2].equals(r7.values[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    public int hashCode() {
        int r0 = this.values.length;
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 + this.values[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
