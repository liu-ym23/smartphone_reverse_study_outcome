package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FSPAAbstractType {
    private static BitField bx;
    private static BitField by;
    private static BitField fAnchorLock;
    private static BitField fBelowText;
    private static BitField fHdr;
    private static BitField fRcaSimple;
    private static BitField wr;
    private static BitField wrk;
    protected int field_1_spid;
    protected int field_2_xaLeft;
    protected int field_3_yaTop;
    protected int field_4_xaRight;
    protected int field_5_yaBottom;
    protected short field_6_flags;
    protected int field_7_cTxbx;

    static {
        fHdr = new BitField(1);
        bx = new BitField(6);
        by = new BitField(24);
        wr = new BitField(480);
        wrk = new BitField(7680);
        fRcaSimple = new BitField(8192);
        fBelowText = new BitField(16384);
        fAnchorLock = new BitField(32768);
    }

    public FSPAAbstractType() {
    }

    public static int getSize() {
        return 26;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_spid = LittleEndian.getInt(r2, r3 + 0);
        this.field_2_xaLeft = LittleEndian.getInt(r2, r3 + 4);
        this.field_3_yaTop = LittleEndian.getInt(r2, r3 + 8);
        this.field_4_xaRight = LittleEndian.getInt(r2, r3 + 12);
        this.field_5_yaBottom = LittleEndian.getInt(r2, r3 + 16);
        this.field_6_flags = LittleEndian.getShort(r2, r3 + 20);
        this.field_7_cTxbx = LittleEndian.getInt(r2, r3 + 22);
    }

    public byte getBx() {
        return (byte) bx.getValue(this.field_6_flags);
    }

    public byte getBy() {
        return (byte) by.getValue(this.field_6_flags);
    }

    public int getCTxbx() {
        return this.field_7_cTxbx;
    }

    public short getFlags() {
        return this.field_6_flags;
    }

    public int getSpid() {
        return this.field_1_spid;
    }

    public byte getWr() {
        return (byte) wr.getValue(this.field_6_flags);
    }

    public byte getWrk() {
        return (byte) wrk.getValue(this.field_6_flags);
    }

    public int getXaLeft() {
        return this.field_2_xaLeft;
    }

    public int getXaRight() {
        return this.field_4_xaRight;
    }

    public int getYaBottom() {
        return this.field_5_yaBottom;
    }

    public int getYaTop() {
        return this.field_3_yaTop;
    }

    public boolean isFAnchorLock() {
        return fAnchorLock.isSet(this.field_6_flags);
    }

    public boolean isFBelowText() {
        return fBelowText.isSet(this.field_6_flags);
    }

    public boolean isFHdr() {
        return fHdr.isSet(this.field_6_flags);
    }

    public boolean isFRcaSimple() {
        return fRcaSimple.isSet(this.field_6_flags);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FSPA]\n");
        r0.append("    .spid                 = ");
        r0.append(" (").append(getSpid()).append(" )\n");
        r0.append("    .xaLeft               = ");
        r0.append(" (").append(getXaLeft()).append(" )\n");
        r0.append("    .yaTop                = ");
        r0.append(" (").append(getYaTop()).append(" )\n");
        r0.append("    .xaRight              = ");
        r0.append(" (").append(getXaRight()).append(" )\n");
        r0.append("    .yaBottom             = ");
        r0.append(" (").append(getYaBottom()).append(" )\n");
        r0.append("    .flags                = ");
        r0.append(" (").append(getFlags()).append(" )\n");
        r0.append("         .fHdr                     = ").append(isFHdr()).append('\n');
        r0.append("         .bx                       = ").append(getBx()).append('\n');
        r0.append("         .by                       = ").append(getBy()).append('\n');
        r0.append("         .wr                       = ").append(getWr()).append('\n');
        r0.append("         .wrk                      = ").append(getWrk()).append('\n');
        r0.append("         .fRcaSimple               = ").append(isFRcaSimple()).append('\n');
        r0.append("         .fBelowText               = ").append(isFBelowText()).append('\n');
        r0.append("         .fAnchorLock              = ").append(isFAnchorLock()).append('\n');
        r0.append("    .cTxbx                = ");
        r0.append(" (").append(getCTxbx()).append(" )\n");
        r0.append("[/FSPA]\n");
        return r0.toString();
    }
}
