package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FibRgLw97AbstractType {
    protected int field_10_ccpTxbx;
    protected int field_11_ccpHdrTxbx;

    @Deprecated
    protected int field_12_reserved4;

    @Deprecated
    protected int field_13_reserved5;

    @Deprecated
    protected int field_14_reserved6;

    @Deprecated
    protected int field_15_reserved7;

    @Deprecated
    protected int field_16_reserved8;

    @Deprecated
    protected int field_17_reserved9;

    @Deprecated
    protected int field_18_reserved10;

    @Deprecated
    protected int field_19_reserved11;
    protected int field_1_cbMac;

    @Deprecated
    protected int field_20_reserved12;

    @Deprecated
    protected int field_21_reserved13;

    @Deprecated
    protected int field_22_reserved14;

    @Deprecated
    protected int field_2_reserved1;

    @Deprecated
    protected int field_3_reserved2;
    protected int field_4_ccpText;
    protected int field_5_ccpFtn;
    protected int field_6_ccpHdd;

    @Deprecated
    protected int field_7_reserved3;
    protected int field_8_ccpAtn;
    protected int field_9_ccpEdn;

    public FibRgLw97AbstractType() {
    }

    public static int getSize() {
        return 88;
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
        FibRgLw97AbstractType r6 = (FibRgLw97AbstractType) ZeusTransformUtils.preCheckCast(r5, FibRgLw97AbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_cbMac == r6.field_1_cbMac) goto L15;
        return false;
    L15:
        if (this.field_2_reserved1 == r6.field_2_reserved1) goto L18;
        return false;
    L18:
        if (this.field_3_reserved2 == r6.field_3_reserved2) goto L21;
        return false;
    L21:
        if (this.field_4_ccpText == r6.field_4_ccpText) goto L24;
        return false;
    L24:
        if (this.field_5_ccpFtn == r6.field_5_ccpFtn) goto L27;
        return false;
    L27:
        if (this.field_6_ccpHdd == r6.field_6_ccpHdd) goto L30;
        return false;
    L30:
        if (this.field_7_reserved3 == r6.field_7_reserved3) goto L33;
        return false;
    L33:
        if (this.field_8_ccpAtn == r6.field_8_ccpAtn) goto L36;
        return false;
    L36:
        if (this.field_9_ccpEdn == r6.field_9_ccpEdn) goto L39;
        return false;
    L39:
        if (this.field_10_ccpTxbx == r6.field_10_ccpTxbx) goto L42;
        return false;
    L42:
        if (this.field_11_ccpHdrTxbx == r6.field_11_ccpHdrTxbx) goto L45;
        return false;
    L45:
        if (this.field_12_reserved4 == r6.field_12_reserved4) goto L48;
        return false;
    L48:
        if (this.field_13_reserved5 == r6.field_13_reserved5) goto L51;
        return false;
    L51:
        if (this.field_14_reserved6 == r6.field_14_reserved6) goto L54;
        return false;
    L54:
        if (this.field_15_reserved7 == r6.field_15_reserved7) goto L57;
        return false;
    L57:
        if (this.field_16_reserved8 == r6.field_16_reserved8) goto L60;
        return false;
    L60:
        if (this.field_17_reserved9 == r6.field_17_reserved9) goto L63;
        return false;
    L63:
        if (this.field_18_reserved10 == r6.field_18_reserved10) goto L66;
        return false;
    L66:
        if (this.field_19_reserved11 == r6.field_19_reserved11) goto L69;
        return false;
    L69:
        if (this.field_20_reserved12 == r6.field_20_reserved12) goto L72;
        return false;
    L72:
        if (this.field_21_reserved13 == r6.field_21_reserved13) goto L75;
        return false;
    L75:
        if (this.field_22_reserved14 == r6.field_22_reserved14) goto L77;
        return false;
    L77:
        return true;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_cbMac = LittleEndian.getInt(r2, r3 + 0);
        this.field_2_reserved1 = LittleEndian.getInt(r2, r3 + 4);
        this.field_3_reserved2 = LittleEndian.getInt(r2, r3 + 8);
        this.field_4_ccpText = LittleEndian.getInt(r2, r3 + 12);
        this.field_5_ccpFtn = LittleEndian.getInt(r2, r3 + 16);
        this.field_6_ccpHdd = LittleEndian.getInt(r2, r3 + 20);
        this.field_7_reserved3 = LittleEndian.getInt(r2, r3 + 24);
        this.field_8_ccpAtn = LittleEndian.getInt(r2, r3 + 28);
        this.field_9_ccpEdn = LittleEndian.getInt(r2, r3 + 32);
        this.field_10_ccpTxbx = LittleEndian.getInt(r2, r3 + 36);
        this.field_11_ccpHdrTxbx = LittleEndian.getInt(r2, r3 + 40);
        this.field_12_reserved4 = LittleEndian.getInt(r2, r3 + 44);
        this.field_13_reserved5 = LittleEndian.getInt(r2, r3 + 48);
        this.field_14_reserved6 = LittleEndian.getInt(r2, r3 + 52);
        this.field_15_reserved7 = LittleEndian.getInt(r2, r3 + 56);
        this.field_16_reserved8 = LittleEndian.getInt(r2, r3 + 60);
        this.field_17_reserved9 = LittleEndian.getInt(r2, r3 + 64);
        this.field_18_reserved10 = LittleEndian.getInt(r2, r3 + 68);
        this.field_19_reserved11 = LittleEndian.getInt(r2, r3 + 72);
        this.field_20_reserved12 = LittleEndian.getInt(r2, r3 + 76);
        this.field_21_reserved13 = LittleEndian.getInt(r2, r3 + 80);
        this.field_22_reserved14 = LittleEndian.getInt(r2, r3 + 84);
    }

    public int getCbMac() {
        return this.field_1_cbMac;
    }

    public int getCcpAtn() {
        return this.field_8_ccpAtn;
    }

    public int getCcpEdn() {
        return this.field_9_ccpEdn;
    }

    public int getCcpFtn() {
        return this.field_5_ccpFtn;
    }

    public int getCcpHdd() {
        return this.field_6_ccpHdd;
    }

    public int getCcpHdrTxbx() {
        return this.field_11_ccpHdrTxbx;
    }

    public int getCcpText() {
        return this.field_4_ccpText;
    }

    public int getCcpTxbx() {
        return this.field_10_ccpTxbx;
    }

    public int getReserved1() {
        return this.field_2_reserved1;
    }

    public int getReserved10() {
        return this.field_18_reserved10;
    }

    public int getReserved11() {
        return this.field_19_reserved11;
    }

    public int getReserved12() {
        return this.field_20_reserved12;
    }

    public int getReserved13() {
        return this.field_21_reserved13;
    }

    public int getReserved14() {
        return this.field_22_reserved14;
    }

    public int getReserved2() {
        return this.field_3_reserved2;
    }

    public int getReserved3() {
        return this.field_7_reserved3;
    }

    public int getReserved4() {
        return this.field_12_reserved4;
    }

    public int getReserved5() {
        return this.field_13_reserved5;
    }

    public int getReserved6() {
        return this.field_14_reserved6;
    }

    public int getReserved7() {
        return this.field_15_reserved7;
    }

    public int getReserved8() {
        return this.field_16_reserved8;
    }

    public int getReserved9() {
        return this.field_17_reserved9;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_cbMac), Integer.valueOf(this.field_2_reserved1), Integer.valueOf(this.field_3_reserved2), Integer.valueOf(this.field_4_ccpText), Integer.valueOf(this.field_5_ccpFtn), Integer.valueOf(this.field_6_ccpHdd), Integer.valueOf(this.field_7_reserved3), Integer.valueOf(this.field_8_ccpAtn), Integer.valueOf(this.field_9_ccpEdn), Integer.valueOf(this.field_10_ccpTxbx), Integer.valueOf(this.field_11_ccpHdrTxbx), Integer.valueOf(this.field_12_reserved4), Integer.valueOf(this.field_13_reserved5), Integer.valueOf(this.field_14_reserved6), Integer.valueOf(this.field_15_reserved7), Integer.valueOf(this.field_16_reserved8), Integer.valueOf(this.field_17_reserved9), Integer.valueOf(this.field_18_reserved10), Integer.valueOf(this.field_19_reserved11), Integer.valueOf(this.field_20_reserved12), Integer.valueOf(this.field_21_reserved13), Integer.valueOf(this.field_22_reserved14)});
    }

    public void setCcpAtn(int r1) {
        this.field_8_ccpAtn = r1;
    }

    public void setCcpEdn(int r1) {
        this.field_9_ccpEdn = r1;
    }

    public void setCcpFtn(int r1) {
        this.field_5_ccpFtn = r1;
    }

    public void setCcpHdd(int r1) {
        this.field_6_ccpHdd = r1;
    }

    public void setCcpHdrTxbx(int r1) {
        this.field_11_ccpHdrTxbx = r1;
    }

    public void setCcpText(int r1) {
        this.field_4_ccpText = r1;
    }

    public void setCcpTxbx(int r1) {
        this.field_10_ccpTxbx = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FibRgLw97]\n");
        r0.append("    .cbMac                = ");
        r0.append(" (").append(getCbMac()).append(" )\n");
        r0.append("    .reserved1            = ");
        r0.append(" (").append(getReserved1()).append(" )\n");
        r0.append("    .reserved2            = ");
        r0.append(" (").append(getReserved2()).append(" )\n");
        r0.append("    .ccpText              = ");
        r0.append(" (").append(getCcpText()).append(" )\n");
        r0.append("    .ccpFtn               = ");
        r0.append(" (").append(getCcpFtn()).append(" )\n");
        r0.append("    .ccpHdd               = ");
        r0.append(" (").append(getCcpHdd()).append(" )\n");
        r0.append("    .reserved3            = ");
        r0.append(" (").append(getReserved3()).append(" )\n");
        r0.append("    .ccpAtn               = ");
        r0.append(" (").append(getCcpAtn()).append(" )\n");
        r0.append("    .ccpEdn               = ");
        r0.append(" (").append(getCcpEdn()).append(" )\n");
        r0.append("    .ccpTxbx              = ");
        r0.append(" (").append(getCcpTxbx()).append(" )\n");
        r0.append("    .ccpHdrTxbx           = ");
        r0.append(" (").append(getCcpHdrTxbx()).append(" )\n");
        r0.append("    .reserved4            = ");
        r0.append(" (").append(getReserved4()).append(" )\n");
        r0.append("    .reserved5            = ");
        r0.append(" (").append(getReserved5()).append(" )\n");
        r0.append("    .reserved6            = ");
        r0.append(" (").append(getReserved6()).append(" )\n");
        r0.append("    .reserved7            = ");
        r0.append(" (").append(getReserved7()).append(" )\n");
        r0.append("    .reserved8            = ");
        r0.append(" (").append(getReserved8()).append(" )\n");
        r0.append("    .reserved9            = ");
        r0.append(" (").append(getReserved9()).append(" )\n");
        r0.append("    .reserved10           = ");
        r0.append(" (").append(getReserved10()).append(" )\n");
        r0.append("    .reserved11           = ");
        r0.append(" (").append(getReserved11()).append(" )\n");
        r0.append("    .reserved12           = ");
        r0.append(" (").append(getReserved12()).append(" )\n");
        r0.append("    .reserved13           = ");
        r0.append(" (").append(getReserved13()).append(" )\n");
        r0.append("    .reserved14           = ");
        r0.append(" (").append(getReserved14()).append(" )\n");
        r0.append("[/FibRgLw97]\n");
        return r0.toString();
    }
}
