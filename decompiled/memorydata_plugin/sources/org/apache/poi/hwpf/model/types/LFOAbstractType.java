package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.Grfhic;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LFOAbstractType {
    protected int field_1_lsid;
    protected int field_2_unused1;
    protected int field_3_unused2;
    protected byte field_4_clfolvl;
    protected byte field_5_ibstFltAutoNum;
    protected Grfhic field_6_grfhic;
    protected byte field_7_unused3;

    public LFOAbstractType() {
        this.field_6_grfhic = new Grfhic();
    }

    public static int getSize() {
        return 16;
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
        LFOAbstractType r6 = (LFOAbstractType) ZeusTransformUtils.preCheckCast(r5, LFOAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_lsid == r6.field_1_lsid) goto L15;
        return false;
    L15:
        if (this.field_2_unused1 == r6.field_2_unused1) goto L18;
        return false;
    L18:
        if (this.field_3_unused2 == r6.field_3_unused2) goto L21;
        return false;
    L21:
        if (this.field_4_clfolvl == r6.field_4_clfolvl) goto L24;
        return false;
    L24:
        if (this.field_5_ibstFltAutoNum == r6.field_5_ibstFltAutoNum) goto L26;
        return false;
    L26:
        Grfhic r2 = this.field_6_grfhic;
        if (r2 != null) goto L32;
        if (r6.field_6_grfhic == null) goto L35;
        return false;
    L35:
        if (this.field_7_unused3 == r6.field_7_unused3) goto L37;
        return false;
    L37:
        return true;
    L32:
        if (r2.equals(r6.field_6_grfhic) == true) goto L35;
        return false;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_lsid = LittleEndian.getInt(r3, r4 + 0);
        this.field_2_unused1 = LittleEndian.getInt(r3, r4 + 4);
        this.field_3_unused2 = LittleEndian.getInt(r3, r4 + 8);
        this.field_4_clfolvl = r3[r4 + 12];
        this.field_5_ibstFltAutoNum = r3[r4 + 13];
        this.field_6_grfhic = new Grfhic(r3, r4 + 14);
        this.field_7_unused3 = r3[r4 + 15];
    }

    public byte getClfolvl() {
        return this.field_4_clfolvl;
    }

    public int getLsid() {
        return this.field_1_lsid;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.field_1_lsid), Integer.valueOf(this.field_2_unused1), Integer.valueOf(this.field_3_unused2), Byte.valueOf(this.field_4_clfolvl), Byte.valueOf(this.field_5_ibstFltAutoNum), this.field_6_grfhic, Byte.valueOf(this.field_7_unused3)});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("[LFO]\n    .lsid                 =  ( ").append(this.field_1_lsid).append(" )\n    .unused1              =  ( ").append(this.field_2_unused1).append(" )\n    .unused2              =  ( ").append(this.field_3_unused2).append(" )\n    .clfolvl              =  ( ").append(this.field_4_clfolvl).append(" )\n    .ibstFltAutoNum       =  ( ").append(this.field_5_ibstFltAutoNum).append(" )\n    .grfhic               =  ( ");
        Grfhic r1 = this.field_6_grfhic;
        if (r1 != null) goto L5;
        String r2 = "null";
    L7:
        return r0.append(r2).append(" )\n    .unused3              =  ( ").append(this.field_7_unused3).append(" )\n[/LFO]").toString();
    L5:
        r2 = r1.toString().replace("\n", "\n    ");
        goto L7
    }
}
