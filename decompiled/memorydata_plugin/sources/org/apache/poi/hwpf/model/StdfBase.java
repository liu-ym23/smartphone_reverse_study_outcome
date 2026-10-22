package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.StdfBaseAbstractType;

/* JADX INFO: loaded from: classes7.dex */
class StdfBase extends StdfBaseAbstractType {
    public StdfBase() {
    }

    public StdfBase(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        StdfBase r6 = (StdfBase) ZeusTransformUtils.preCheckCast(r5, StdfBase.class, "com.obric.memorydata.plugin");
        if (this.field_1_info1 == r6.field_1_info1) goto L15;
        return false;
    L15:
        if (this.field_2_info2 == r6.field_2_info2) goto L18;
        return false;
    L18:
        if (this.field_3_info3 == r6.field_3_info3) goto L21;
        return false;
    L21:
        if (this.field_4_bchUpe == r6.field_4_bchUpe) goto L24;
        return false;
    L24:
        if (this.field_5_grfstd == r6.field_5_grfstd) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_info1), Short.valueOf(this.field_2_info2), Short.valueOf(this.field_3_info3), Integer.valueOf(this.field_4_bchUpe), Short.valueOf(this.field_5_grfstd)});
    }
}
