package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.hwpf.model.types.PICFAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class PICF extends PICFAbstractType {
    public PICF() {
    }

    public PICF(byte[] r1, int r2) {
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
        PICF r6 = (PICF) ZeusTransformUtils.preCheckCast(r5, PICF.class, "com.obric.memorydata.plugin");
        if (this.field_10_padding2 == r6.field_10_padding2) goto L15;
        return false;
    L15:
        if (this.field_11_dxaGoal == r6.field_11_dxaGoal) goto L18;
        return false;
    L18:
        if (this.field_12_dyaGoal == r6.field_12_dyaGoal) goto L21;
        return false;
    L21:
        if (this.field_13_mx == r6.field_13_mx) goto L24;
        return false;
    L24:
        if (this.field_14_my == r6.field_14_my) goto L27;
        return false;
    L27:
        if (this.field_15_dxaReserved1 == r6.field_15_dxaReserved1) goto L30;
        return false;
    L30:
        if (this.field_16_dyaReserved1 == r6.field_16_dyaReserved1) goto L33;
        return false;
    L33:
        if (this.field_17_dxaReserved2 == r6.field_17_dxaReserved2) goto L36;
        return false;
    L36:
        if (this.field_18_dyaReserved2 == r6.field_18_dyaReserved2) goto L39;
        return false;
    L39:
        if (this.field_19_fReserved == r6.field_19_fReserved) goto L42;
        return false;
    L42:
        if (this.field_1_lcb == r6.field_1_lcb) goto L45;
        return false;
    L45:
        if (this.field_20_bpp == r6.field_20_bpp) goto L48;
        return false;
    L48:
        if (Arrays.equals(this.field_21_brcTop80, r6.field_21_brcTop80) == true) goto L51;
        return false;
    L51:
        if (Arrays.equals(this.field_22_brcLeft80, r6.field_22_brcLeft80) == true) goto L54;
        return false;
    L54:
        if (Arrays.equals(this.field_23_brcBottom80, r6.field_23_brcBottom80) == true) goto L57;
        return false;
    L57:
        if (Arrays.equals(this.field_24_brcRight80, r6.field_24_brcRight80) == true) goto L60;
        return false;
    L60:
        if (this.field_25_dxaReserved3 == r6.field_25_dxaReserved3) goto L63;
        return false;
    L63:
        if (this.field_26_dyaReserved3 == r6.field_26_dyaReserved3) goto L66;
        return false;
    L66:
        if (this.field_27_cProps == r6.field_27_cProps) goto L69;
        return false;
    L69:
        if (this.field_2_cbHeader == r6.field_2_cbHeader) goto L72;
        return false;
    L72:
        if (this.field_3_mm == r6.field_3_mm) goto L75;
        return false;
    L75:
        if (this.field_4_xExt == r6.field_4_xExt) goto L78;
        return false;
    L78:
        if (this.field_5_yExt == r6.field_5_yExt) goto L81;
        return false;
    L81:
        if (this.field_6_swHMF == r6.field_6_swHMF) goto L84;
        return false;
    L84:
        if (this.field_7_grf == r6.field_7_grf) goto L87;
        return false;
    L87:
        if (this.field_8_padding == r6.field_8_padding) goto L90;
        return false;
    L90:
        if (this.field_9_mmPM == r6.field_9_mmPM) goto L92;
        return false;
    L92:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this.field_1_lcb), Integer.valueOf(this.field_2_cbHeader), Short.valueOf(this.field_3_mm), Short.valueOf(this.field_4_xExt), Short.valueOf(this.field_5_yExt), Short.valueOf(this.field_6_swHMF), Integer.valueOf(this.field_7_grf), Integer.valueOf(this.field_8_padding), Integer.valueOf(this.field_9_mmPM), Integer.valueOf(this.field_10_padding2), Short.valueOf(this.field_11_dxaGoal), Short.valueOf(this.field_12_dyaGoal), Integer.valueOf(this.field_13_mx), Integer.valueOf(this.field_14_my), Short.valueOf(this.field_15_dxaReserved1), Short.valueOf(this.field_16_dyaReserved1), Short.valueOf(this.field_17_dxaReserved2), Short.valueOf(this.field_18_dyaReserved2), Byte.valueOf(this.field_19_fReserved), Byte.valueOf(this.field_20_bpp), this.field_21_brcTop80, this.field_22_brcLeft80, this.field_23_brcBottom80, this.field_24_brcRight80, Short.valueOf(this.field_25_dxaReserved3), Short.valueOf(this.field_26_dyaReserved3), Short.valueOf(this.field_27_cProps)});
    }
}
