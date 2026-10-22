package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.FibBaseAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class FibBase extends FibBaseAbstractType {
    public FibBase() {
    }

    public FibBase(byte[] r1, int r2) {
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
        FibBase r6 = (FibBase) ZeusTransformUtils.preCheckCast(r5, FibBase.class, "com.obric.memorydata.plugin");
        if (this.field_10_flags2 == r6.field_10_flags2) goto L15;
        return false;
    L15:
        if (this.field_11_Chs == r6.field_11_Chs) goto L18;
        return false;
    L18:
        if (this.field_12_chsTables == r6.field_12_chsTables) goto L21;
        return false;
    L21:
        if (this.field_13_fcMin == r6.field_13_fcMin) goto L24;
        return false;
    L24:
        if (this.field_14_fcMac == r6.field_14_fcMac) goto L27;
        return false;
    L27:
        if (this.field_1_wIdent == r6.field_1_wIdent) goto L30;
        return false;
    L30:
        if (this.field_2_nFib == r6.field_2_nFib) goto L33;
        return false;
    L33:
        if (this.field_3_unused == r6.field_3_unused) goto L36;
        return false;
    L36:
        if (this.field_4_lid == r6.field_4_lid) goto L39;
        return false;
    L39:
        if (this.field_5_pnNext == r6.field_5_pnNext) goto L42;
        return false;
    L42:
        if (this.field_6_flags1 == r6.field_6_flags1) goto L45;
        return false;
    L45:
        if (this.field_7_nFibBack == r6.field_7_nFibBack) goto L48;
        return false;
    L48:
        if (this.field_8_lKey == r6.field_8_lKey) goto L51;
        return false;
    L51:
        if (this.field_9_envr == r6.field_9_envr) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_wIdent), Integer.valueOf(this.field_2_nFib), Integer.valueOf(this.field_3_unused), Integer.valueOf(this.field_4_lid), Integer.valueOf(this.field_5_pnNext), Short.valueOf(this.field_6_flags1), Integer.valueOf(this.field_7_nFibBack), Integer.valueOf(this.field_8_lKey), Byte.valueOf(this.field_9_envr), Byte.valueOf(this.field_10_flags2), Short.valueOf(this.field_11_Chs), Short.valueOf(this.field_12_chsTables), Integer.valueOf(this.field_13_fcMin), Integer.valueOf(this.field_14_fcMac)});
    }
}
