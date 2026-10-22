package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.hwpf.model.Grfhic;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LSTFAbstractType {
    private static final BitField fAutoNum = null;
    private static final BitField fHybrid = null;
    private static final BitField fSimpleList = null;
    private static final BitField reserved1 = null;
    private static final BitField unused1 = null;
    private static final BitField unused2 = null;
    protected int field_1_lsid;
    protected int field_2_tplc;
    protected short[] field_3_rgistdPara;
    protected byte field_4_flags;
    protected Grfhic field_5_grfhic;

    static {
        fSimpleList = new BitField(1);
        unused1 = new BitField(2);
        fAutoNum = new BitField(4);
        unused2 = new BitField(8);
        fHybrid = new BitField(16);
        reserved1 = new BitField(224);
    }

    public LSTFAbstractType() {
        this.field_3_rgistdPara = new short[0];
        this.field_5_grfhic = new Grfhic();
    }

    public static int getSize() {
        return 28;
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
        LSTFAbstractType r6 = (LSTFAbstractType) ZeusTransformUtils.preCheckCast(r5, LSTFAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_lsid == r6.field_1_lsid) goto L15;
        return false;
    L15:
        if (this.field_2_tplc == r6.field_2_tplc) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.field_3_rgistdPara, r6.field_3_rgistdPara) == true) goto L21;
        return false;
    L21:
        if (this.field_4_flags == r6.field_4_flags) goto L23;
        return false;
    L23:
        Grfhic r4 = this.field_5_grfhic;
        if (r4 != null) goto L29;
        if (r6.field_5_grfhic == null) goto L31;
        return false;
    L31:
        return true;
    L29:
        if (r4.equals(r6.field_5_grfhic) == true) goto L31;
        return false;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_lsid = LittleEndian.getInt(r3, r4 + 0);
        this.field_2_tplc = LittleEndian.getInt(r3, r4 + 4);
        this.field_3_rgistdPara = LittleEndian.getShortArray(r3, r4 + 8, 18);
        this.field_4_flags = r3[r4 + 26];
        this.field_5_grfhic = new Grfhic(r3, r4 + 27);
    }

    public byte getFlags() {
        return this.field_4_flags;
    }

    public Grfhic getGrfhic() {
        return this.field_5_grfhic;
    }

    public int getLsid() {
        return this.field_1_lsid;
    }

    @Deprecated
    public byte getReserved1() {
        return (byte) reserved1.getValue(this.field_4_flags);
    }

    public short[] getRgistdPara() {
        return this.field_3_rgistdPara;
    }

    public int getTplc() {
        return this.field_2_tplc;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this.field_1_lsid), Integer.valueOf(this.field_2_tplc), this.field_3_rgistdPara, Byte.valueOf(this.field_4_flags), this.field_5_grfhic});
    }

    public boolean isFAutoNum() {
        return fAutoNum.isSet(this.field_4_flags);
    }

    public boolean isFHybrid() {
        return fHybrid.isSet(this.field_4_flags);
    }

    public boolean isFSimpleList() {
        return fSimpleList.isSet(this.field_4_flags);
    }

    @Deprecated
    public boolean isUnused1() {
        return unused1.isSet(this.field_4_flags);
    }

    @Deprecated
    public boolean isUnused2() {
        return unused2.isSet(this.field_4_flags);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[LSTF]\n");
        r0.append("    .lsid                 = ");
        r0.append(" (").append(getLsid()).append(" )\n");
        r0.append("    .tplc                 = ");
        r0.append(" (").append(getTplc()).append(" )\n");
        r0.append("    .rgistdPara           = ");
        r0.append(" (").append(Arrays.toString(getRgistdPara())).append(" )\n");
        r0.append("    .flags                = ");
        r0.append(" (").append(getFlags()).append(" )\n");
        r0.append("         .fSimpleList              = ").append(isFSimpleList()).append('\n');
        r0.append("         .unused1                  = ").append(isUnused1()).append('\n');
        r0.append("         .fAutoNum                 = ").append(isFAutoNum()).append('\n');
        r0.append("         .unused2                  = ").append(isUnused2()).append('\n');
        r0.append("         .fHybrid                  = ").append(isFHybrid()).append('\n');
        r0.append("         .reserved1                = ").append(getReserved1()).append('\n');
        r0.append("    .grfhic               = ");
        r0.append(" (").append(getGrfhic()).append(" )\n");
        r0.append("[/LSTF]\n");
        return r0.toString();
    }
}
