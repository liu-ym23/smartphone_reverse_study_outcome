package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LFOLVLBaseAbstractType {
    private static final BitField fFormatting = null;
    private static final BitField fStartAt = null;
    private static final BitField grfhic = null;
    private static final BitField iLvl = null;
    private static final BitField unused1 = null;
    private static final BitField unused2 = null;
    protected int field_1_iStartAt;
    protected int field_2_flags;

    static {
        iLvl = new BitField(15);
        fStartAt = new BitField(16);
        fFormatting = new BitField(32);
        grfhic = new BitField(16320);
        unused1 = new BitField(536854528);
        unused2 = new BitField(-536870912);
    }

    public LFOLVLBaseAbstractType() {
    }

    public static int getSize() {
        return 8;
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
        LFOLVLBaseAbstractType r6 = (LFOLVLBaseAbstractType) ZeusTransformUtils.preCheckCast(r5, LFOLVLBaseAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_iStartAt == r6.field_1_iStartAt) goto L15;
        return false;
    L15:
        if (this.field_2_flags == r6.field_2_flags) goto L17;
        return false;
    L17:
        return true;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_iStartAt = LittleEndian.getInt(r2, r3 + 0);
        this.field_2_flags = LittleEndian.getInt(r2, r3 + 4);
    }

    public int getFlags() {
        return this.field_2_flags;
    }

    public short getGrfhic() {
        return (short) grfhic.getValue(this.field_2_flags);
    }

    public byte getILvl() {
        return (byte) iLvl.getValue(this.field_2_flags);
    }

    public int getIStartAt() {
        return this.field_1_iStartAt;
    }

    @Deprecated
    public short getUnused1() {
        return (short) unused1.getValue(this.field_2_flags);
    }

    @Deprecated
    public byte getUnused2() {
        return (byte) unused2.getValue(this.field_2_flags);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_iStartAt), Integer.valueOf(this.field_2_flags)});
    }

    public boolean isFFormatting() {
        return fFormatting.isSet(this.field_2_flags);
    }

    public boolean isFStartAt() {
        return fStartAt.isSet(this.field_2_flags);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[LFOLVLBase]\n");
        r0.append("    .iStartAt             = ");
        r0.append(" (").append(getIStartAt()).append(" )\n");
        r0.append("    .flags                = ");
        r0.append(" (").append(getFlags()).append(" )\n");
        r0.append("         .iLvl                     = ").append(getILvl()).append('\n');
        r0.append("         .fStartAt                 = ").append(isFStartAt()).append('\n');
        r0.append("         .fFormatting              = ").append(isFFormatting()).append('\n');
        r0.append("         .grfhic                   = ").append(getGrfhic()).append('\n');
        r0.append("         .unused1                  = ").append(getUnused1()).append('\n');
        r0.append("         .unused2                  = ").append(getUnused2()).append('\n');
        r0.append("[/LFOLVLBase]\n");
        return r0.toString();
    }
}
