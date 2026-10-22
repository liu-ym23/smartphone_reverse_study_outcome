package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.StshifAbstractType;

/* JADX INFO: loaded from: classes7.dex */
class Stshif extends StshifAbstractType {
    public Stshif() {
    }

    public Stshif(byte[] r1, int r2) {
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
        Stshif r6 = (Stshif) ZeusTransformUtils.preCheckCast(r5, Stshif.class, "com.obric.memorydata.plugin");
        if (this.field_1_cstd == r6.field_1_cstd) goto L15;
        return false;
    L15:
        if (this.field_2_cbSTDBaseInFile == r6.field_2_cbSTDBaseInFile) goto L18;
        return false;
    L18:
        if (this.field_3_info3 == r6.field_3_info3) goto L21;
        return false;
    L21:
        if (this.field_4_stiMaxWhenSaved == r6.field_4_stiMaxWhenSaved) goto L24;
        return false;
    L24:
        if (this.field_5_istdMaxFixedWhenSaved == r6.field_5_istdMaxFixedWhenSaved) goto L27;
        return false;
    L27:
        if (this.field_6_nVerBuiltInNamesWhenSaved == r6.field_6_nVerBuiltInNamesWhenSaved) goto L30;
        return false;
    L30:
        if (this.field_7_ftcAsci == r6.field_7_ftcAsci) goto L33;
        return false;
    L33:
        if (this.field_8_ftcFE == r6.field_8_ftcFE) goto L36;
        return false;
    L36:
        if (this.field_9_ftcOther == r6.field_9_ftcOther) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_cstd), Integer.valueOf(this.field_2_cbSTDBaseInFile), Integer.valueOf(this.field_3_info3), Integer.valueOf(this.field_4_stiMaxWhenSaved), Integer.valueOf(this.field_5_istdMaxFixedWhenSaved), Integer.valueOf(this.field_6_nVerBuiltInNamesWhenSaved), Short.valueOf(this.field_7_ftcAsci), Short.valueOf(this.field_8_ftcFE), Short.valueOf(this.field_9_ftcOther)});
    }
}
