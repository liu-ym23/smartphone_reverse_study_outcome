package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.StdfPost2000AbstractType;

/* JADX INFO: loaded from: classes7.dex */
class StdfPost2000 extends StdfPost2000AbstractType {
    public StdfPost2000() {
    }

    public StdfPost2000(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (getClass() == r7.getClass()) goto L11;
        return false;
    L11:
        StdfPost2000 r8 = (StdfPost2000) ZeusTransformUtils.preCheckCast(r7, StdfPost2000.class, "com.obric.memorydata.plugin");
        if (this.field_1_info1 == r8.field_1_info1) goto L15;
        return false;
    L15:
        if (this.field_2_rsid == r8.field_2_rsid) goto L18;
        return false;
    L18:
        if (this.field_3_info3 == r8.field_3_info3) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_info1), Long.valueOf(this.field_2_rsid), Short.valueOf(this.field_3_info3)});
    }
}
