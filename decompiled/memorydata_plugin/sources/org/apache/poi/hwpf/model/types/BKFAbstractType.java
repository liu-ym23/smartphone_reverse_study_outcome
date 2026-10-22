package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BKFAbstractType {
    private static final BitField fCol = null;
    private static final BitField fPub = null;
    private static final BitField itcFirst = null;
    private static final BitField itcLim = null;
    protected short field_1_ibkl;
    protected short field_2_bkf_flags;

    static {
        itcFirst = new BitField(127);
        fPub = new BitField(128);
        itcLim = new BitField(32512);
        fCol = new BitField(32768);
    }

    public static int getSize() {
        return 4;
    }

    public short getBkf_flags() {
        return this.field_2_bkf_flags;
    }

    public short getIbkl() {
        return this.field_1_ibkl;
    }

    public byte getItcFirst() {
        return (byte) itcFirst.getValue(this.field_2_bkf_flags);
    }

    public byte getItcLim() {
        return (byte) itcLim.getValue(this.field_2_bkf_flags);
    }

    public boolean isFCol() {
        return fCol.isSet(this.field_2_bkf_flags);
    }

    public boolean isFPub() {
        return fPub.isSet(this.field_2_bkf_flags);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[BKF]\n");
        r0.append("    .ibkl                 = ");
        r0.append(" (").append(getIbkl()).append(" )\n");
        r0.append("    .bkf_flags            = ");
        r0.append(" (").append(getBkf_flags()).append(" )\n");
        r0.append("         .itcFirst                 = ").append(getItcFirst()).append('\n');
        r0.append("         .fPub                     = ").append(isFPub()).append('\n');
        r0.append("         .itcLim                   = ").append(getItcLim()).append('\n');
        r0.append("         .fCol                     = ").append(isFCol()).append('\n');
        r0.append("[/BKF]\n");
        return r0.toString();
    }
}
