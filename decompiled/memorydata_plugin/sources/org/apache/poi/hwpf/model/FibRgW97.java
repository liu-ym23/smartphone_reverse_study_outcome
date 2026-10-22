package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.FibRgW97AbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class FibRgW97 extends FibRgW97AbstractType {
    public FibRgW97() {
    }

    public FibRgW97(byte[] r1, int r2) {
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
        FibRgW97 r6 = (FibRgW97) ZeusTransformUtils.preCheckCast(r5, FibRgW97.class, "com.obric.memorydata.plugin");
        if (this.field_10_reserved10 == r6.field_10_reserved10) goto L15;
        return false;
    L15:
        if (this.field_11_reserved11 == r6.field_11_reserved11) goto L18;
        return false;
    L18:
        if (this.field_12_reserved12 == r6.field_12_reserved12) goto L21;
        return false;
    L21:
        if (this.field_13_reserved13 == r6.field_13_reserved13) goto L24;
        return false;
    L24:
        if (this.field_14_lidFE == r6.field_14_lidFE) goto L27;
        return false;
    L27:
        if (this.field_1_reserved1 == r6.field_1_reserved1) goto L30;
        return false;
    L30:
        if (this.field_2_reserved2 == r6.field_2_reserved2) goto L33;
        return false;
    L33:
        if (this.field_3_reserved3 == r6.field_3_reserved3) goto L36;
        return false;
    L36:
        if (this.field_4_reserved4 == r6.field_4_reserved4) goto L39;
        return false;
    L39:
        if (this.field_5_reserved5 == r6.field_5_reserved5) goto L42;
        return false;
    L42:
        if (this.field_6_reserved6 == r6.field_6_reserved6) goto L45;
        return false;
    L45:
        if (this.field_7_reserved7 == r6.field_7_reserved7) goto L48;
        return false;
    L48:
        if (this.field_8_reserved8 == r6.field_8_reserved8) goto L51;
        return false;
    L51:
        if (this.field_9_reserved9 == r6.field_9_reserved9) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_reserved1), Short.valueOf(this.field_2_reserved2), Short.valueOf(this.field_3_reserved3), Short.valueOf(this.field_4_reserved4), Short.valueOf(this.field_5_reserved5), Short.valueOf(this.field_6_reserved6), Short.valueOf(this.field_7_reserved7), Short.valueOf(this.field_8_reserved8), Short.valueOf(this.field_9_reserved9), Short.valueOf(this.field_10_reserved10), Short.valueOf(this.field_11_reserved11), Short.valueOf(this.field_12_reserved12), Short.valueOf(this.field_13_reserved13), Short.valueOf(this.field_14_lidFE)});
    }
}
