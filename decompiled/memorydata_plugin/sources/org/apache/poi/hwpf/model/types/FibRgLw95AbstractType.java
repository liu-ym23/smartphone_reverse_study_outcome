package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FibRgLw95AbstractType {
    protected int field_10_ccpAtn;
    protected int field_11_ccpEdn;
    protected int field_12_ccpTxbx;
    protected int field_13_ccpHdrTxbx;

    @Deprecated
    protected int field_14_reserved5;
    protected int field_1_cbMac;

    @Deprecated
    protected int field_2_reserved1;

    @Deprecated
    protected int field_3_reserved2;

    @Deprecated
    protected int field_4_reserved3;

    @Deprecated
    protected int field_5_reserved4;
    protected int field_6_ccpText;
    protected int field_7_ccpFtn;
    protected int field_8_ccpHdd;
    protected int field_9_ccpMcr;

    public FibRgLw95AbstractType() {
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
        FibRgLw95AbstractType r6 = (FibRgLw95AbstractType) ZeusTransformUtils.preCheckCast(r5, FibRgLw95AbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_cbMac == r6.field_1_cbMac) goto L15;
        return false;
    L15:
        if (this.field_2_reserved1 == r6.field_2_reserved1) goto L18;
        return false;
    L18:
        if (this.field_3_reserved2 == r6.field_3_reserved2) goto L21;
        return false;
    L21:
        if (this.field_4_reserved3 == r6.field_4_reserved3) goto L24;
        return false;
    L24:
        if (this.field_5_reserved4 == r6.field_5_reserved4) goto L27;
        return false;
    L27:
        if (this.field_6_ccpText == r6.field_6_ccpText) goto L30;
        return false;
    L30:
        if (this.field_7_ccpFtn == r6.field_7_ccpFtn) goto L33;
        return false;
    L33:
        if (this.field_8_ccpHdd == r6.field_8_ccpHdd) goto L36;
        return false;
    L36:
        if (this.field_9_ccpMcr == r6.field_9_ccpMcr) goto L39;
        return false;
    L39:
        if (this.field_10_ccpAtn == r6.field_10_ccpAtn) goto L42;
        return false;
    L42:
        if (this.field_11_ccpEdn == r6.field_11_ccpEdn) goto L45;
        return false;
    L45:
        if (this.field_12_ccpTxbx == r6.field_12_ccpTxbx) goto L48;
        return false;
    L48:
        if (this.field_13_ccpHdrTxbx == r6.field_13_ccpHdrTxbx) goto L51;
        return false;
    L51:
        if (this.field_14_reserved5 == r6.field_14_reserved5) goto L53;
        return false;
    L53:
        return true;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_cbMac = LittleEndian.getInt(r2, r3 + 0);
        this.field_2_reserved1 = LittleEndian.getInt(r2, r3 + 4);
        this.field_3_reserved2 = LittleEndian.getInt(r2, r3 + 8);
        this.field_4_reserved3 = LittleEndian.getInt(r2, r3 + 12);
        this.field_5_reserved4 = LittleEndian.getInt(r2, r3 + 16);
        this.field_6_ccpText = LittleEndian.getInt(r2, r3 + 20);
        this.field_7_ccpFtn = LittleEndian.getInt(r2, r3 + 24);
        this.field_8_ccpHdd = LittleEndian.getInt(r2, r3 + 28);
        this.field_9_ccpMcr = LittleEndian.getInt(r2, r3 + 32);
        this.field_10_ccpAtn = LittleEndian.getInt(r2, r3 + 36);
        this.field_11_ccpEdn = LittleEndian.getInt(r2, r3 + 40);
        this.field_12_ccpTxbx = LittleEndian.getInt(r2, r3 + 44);
        this.field_13_ccpHdrTxbx = LittleEndian.getInt(r2, r3 + 48);
        this.field_14_reserved5 = LittleEndian.getInt(r2, r3 + 52);
    }

    public int getCbMac() {
        return this.field_1_cbMac;
    }

    public int getCcpAtn() {
        return this.field_10_ccpAtn;
    }

    public int getCcpEdn() {
        return this.field_11_ccpEdn;
    }

    public int getCcpFtn() {
        return this.field_7_ccpFtn;
    }

    public int getCcpHdd() {
        return this.field_8_ccpHdd;
    }

    public int getCcpHdrTxbx() {
        return this.field_13_ccpHdrTxbx;
    }

    public int getCcpMcr() {
        return this.field_9_ccpMcr;
    }

    public int getCcpText() {
        return this.field_6_ccpText;
    }

    public int getCcpTxbx() {
        return this.field_12_ccpTxbx;
    }

    public int getReserved1() {
        return this.field_2_reserved1;
    }

    public int getReserved2() {
        return this.field_3_reserved2;
    }

    public int getReserved3() {
        return this.field_4_reserved3;
    }

    public int getReserved4() {
        return this.field_5_reserved4;
    }

    public int getReserved5() {
        return this.field_14_reserved5;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_cbMac), Integer.valueOf(this.field_2_reserved1), Integer.valueOf(this.field_3_reserved2), Integer.valueOf(this.field_4_reserved3), Integer.valueOf(this.field_5_reserved4), Integer.valueOf(this.field_6_ccpText), Integer.valueOf(this.field_7_ccpFtn), Integer.valueOf(this.field_8_ccpHdd), Integer.valueOf(this.field_9_ccpMcr), Integer.valueOf(this.field_10_ccpAtn), Integer.valueOf(this.field_11_ccpEdn), Integer.valueOf(this.field_12_ccpTxbx), Integer.valueOf(this.field_13_ccpHdrTxbx), Integer.valueOf(this.field_14_reserved5)});
    }

    public void setCbMac(int r1) {
        this.field_1_cbMac = r1;
    }

    public void setCcpAtn(int r1) {
        this.field_10_ccpAtn = r1;
    }

    public void setCcpEdn(int r1) {
        this.field_11_ccpEdn = r1;
    }

    public void setCcpFtn(int r1) {
        this.field_7_ccpFtn = r1;
    }

    public void setCcpHdd(int r1) {
        this.field_8_ccpHdd = r1;
    }

    public void setCcpHdrTxbx(int r1) {
        this.field_13_ccpHdrTxbx = r1;
    }

    public void setCcpText(int r1) {
        this.field_6_ccpText = r1;
    }

    public void setCcpTxbx(int r1) {
        this.field_12_ccpTxbx = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FibRgLw95]\n");
        r0.append("    .cbMac                = ");
        r0.append(" (").append(getCbMac()).append(" )\n");
        r0.append("    .reserved1            = ");
        r0.append(" (").append(getReserved1()).append(" )\n");
        r0.append("    .reserved2            = ");
        r0.append(" (").append(getReserved2()).append(" )\n");
        r0.append("    .reserved3            = ");
        r0.append(" (").append(getReserved3()).append(" )\n");
        r0.append("    .reserved4            = ");
        r0.append(" (").append(getReserved4()).append(" )\n");
        r0.append("    .ccpText              = ");
        r0.append(" (").append(getCcpText()).append(" )\n");
        r0.append("    .ccpFtn               = ");
        r0.append(" (").append(getCcpFtn()).append(" )\n");
        r0.append("    .ccpHdd               = ");
        r0.append(" (").append(getCcpHdd()).append(" )\n");
        r0.append("    .ccpMcr               = ");
        r0.append(" (").append(getCcpMcr()).append(" )\n");
        r0.append("    .ccpAtn               = ");
        r0.append(" (").append(getCcpAtn()).append(" )\n");
        r0.append("    .ccpEdn               = ");
        r0.append(" (").append(getCcpEdn()).append(" )\n");
        r0.append("    .ccpTxbx              = ");
        r0.append(" (").append(getCcpTxbx()).append(" )\n");
        r0.append("    .ccpHdrTxbx           = ");
        r0.append(" (").append(getCcpHdrTxbx()).append(" )\n");
        r0.append("    .reserved5            = ");
        r0.append(" (").append(getReserved5()).append(" )\n");
        r0.append("[/FibRgLw95]\n");
        return r0.toString();
    }
}
