package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StdfBaseAbstractType {
    private static final BitField cupx = null;
    private static final BitField f97LidsSet = null;
    private static final BitField fAutoRedef = null;
    private static final BitField fCopyLang = null;
    private static final BitField fHasUpe = null;
    private static final BitField fHidden = null;
    private static final BitField fInternalUse = null;
    private static final BitField fInvalHeight = null;
    private static final BitField fLocked = null;
    private static final BitField fMassCopy = null;
    private static final BitField fNoHtmlExport = null;
    private static final BitField fPersonal = null;
    private static final BitField fPersonalCompose = null;
    private static final BitField fPersonalReply = null;
    private static final BitField fQFormat = null;
    private static final BitField fReserved = null;
    private static final BitField fScratch = null;
    private static final BitField fSemiHidden = null;
    private static final BitField fUnhideWhenUsed = null;
    private static final BitField istdBase = null;
    private static final BitField istdNext = null;
    private static final BitField sti = null;
    private static final BitField stk = null;
    protected short field_1_info1;
    protected short field_2_info2;
    protected short field_3_info3;
    protected int field_4_bchUpe;
    protected short field_5_grfstd;

    static {
        sti = new BitField(4095);
        fScratch = new BitField(4096);
        fInvalHeight = new BitField(8192);
        fHasUpe = new BitField(16384);
        fMassCopy = new BitField(32768);
        stk = new BitField(15);
        istdBase = new BitField(65520);
        cupx = new BitField(15);
        istdNext = new BitField(65520);
        fAutoRedef = new BitField(1);
        fHidden = new BitField(2);
        f97LidsSet = new BitField(4);
        fCopyLang = new BitField(8);
        fPersonalCompose = new BitField(16);
        fPersonalReply = new BitField(32);
        fPersonal = new BitField(64);
        fNoHtmlExport = new BitField(128);
        fSemiHidden = new BitField(256);
        fLocked = new BitField(512);
        fInternalUse = new BitField(1024);
        fUnhideWhenUsed = new BitField(2048);
        fQFormat = new BitField(4096);
        fReserved = new BitField(57344);
    }

    public StdfBaseAbstractType() {
    }

    public static int getSize() {
        return 10;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_info1 = LittleEndian.getShort(r2, r3 + 0);
        this.field_2_info2 = LittleEndian.getShort(r2, r3 + 2);
        this.field_3_info3 = LittleEndian.getShort(r2, r3 + 4);
        this.field_4_bchUpe = LittleEndian.getShort(r2, r3 + 6);
        this.field_5_grfstd = LittleEndian.getShort(r2, r3 + 8);
    }

    public int getBchUpe() {
        return this.field_4_bchUpe;
    }

    public byte getCupx() {
        return (byte) cupx.getValue(this.field_3_info3);
    }

    public byte getFReserved() {
        return (byte) fReserved.getValue(this.field_5_grfstd);
    }

    public short getGrfstd() {
        return this.field_5_grfstd;
    }

    public short getInfo1() {
        return this.field_1_info1;
    }

    public short getInfo2() {
        return this.field_2_info2;
    }

    public short getInfo3() {
        return this.field_3_info3;
    }

    public short getIstdBase() {
        return (short) istdBase.getValue(this.field_2_info2);
    }

    public short getIstdNext() {
        return (short) istdNext.getValue(this.field_3_info3);
    }

    public short getSti() {
        return (short) sti.getValue(this.field_1_info1);
    }

    public byte getStk() {
        return (byte) stk.getValue(this.field_2_info2);
    }

    public boolean isF97LidsSet() {
        return f97LidsSet.isSet(this.field_5_grfstd);
    }

    public boolean isFAutoRedef() {
        return fAutoRedef.isSet(this.field_5_grfstd);
    }

    public boolean isFCopyLang() {
        return fCopyLang.isSet(this.field_5_grfstd);
    }

    public boolean isFHasUpe() {
        return fHasUpe.isSet(this.field_1_info1);
    }

    public boolean isFHidden() {
        return fHidden.isSet(this.field_5_grfstd);
    }

    public boolean isFInternalUse() {
        return fInternalUse.isSet(this.field_5_grfstd);
    }

    public boolean isFInvalHeight() {
        return fInvalHeight.isSet(this.field_1_info1);
    }

    public boolean isFLocked() {
        return fLocked.isSet(this.field_5_grfstd);
    }

    public boolean isFMassCopy() {
        return fMassCopy.isSet(this.field_1_info1);
    }

    public boolean isFNoHtmlExport() {
        return fNoHtmlExport.isSet(this.field_5_grfstd);
    }

    public boolean isFPersonal() {
        return fPersonal.isSet(this.field_5_grfstd);
    }

    public boolean isFPersonalCompose() {
        return fPersonalCompose.isSet(this.field_5_grfstd);
    }

    public boolean isFPersonalReply() {
        return fPersonalReply.isSet(this.field_5_grfstd);
    }

    public boolean isFQFormat() {
        return fQFormat.isSet(this.field_5_grfstd);
    }

    public boolean isFScratch() {
        return fScratch.isSet(this.field_1_info1);
    }

    public boolean isFSemiHidden() {
        return fSemiHidden.isSet(this.field_5_grfstd);
    }

    public boolean isFUnhideWhenUsed() {
        return fUnhideWhenUsed.isSet(this.field_5_grfstd);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[StdfBase]\n");
        r0.append("    .info1                = ");
        r0.append(" (").append(getInfo1()).append(" )\n");
        r0.append("         .sti                      = ").append(getSti()).append('\n');
        r0.append("         .fScratch                 = ").append(isFScratch()).append('\n');
        r0.append("         .fInvalHeight             = ").append(isFInvalHeight()).append('\n');
        r0.append("         .fHasUpe                  = ").append(isFHasUpe()).append('\n');
        r0.append("         .fMassCopy                = ").append(isFMassCopy()).append('\n');
        r0.append("    .info2                = ");
        r0.append(" (").append(getInfo2()).append(" )\n");
        r0.append("         .stk                      = ").append(getStk()).append('\n');
        r0.append("         .istdBase                 = ").append(getIstdBase()).append('\n');
        r0.append("    .info3                = ");
        r0.append(" (").append(getInfo3()).append(" )\n");
        r0.append("         .cupx                     = ").append(getCupx()).append('\n');
        r0.append("         .istdNext                 = ").append(getIstdNext()).append('\n');
        r0.append("    .bchUpe               = ");
        r0.append(" (").append(getBchUpe()).append(" )\n");
        r0.append("    .grfstd               = ");
        r0.append(" (").append(getGrfstd()).append(" )\n");
        r0.append("         .fAutoRedef               = ").append(isFAutoRedef()).append('\n');
        r0.append("         .fHidden                  = ").append(isFHidden()).append('\n');
        r0.append("         .f97LidsSet               = ").append(isF97LidsSet()).append('\n');
        r0.append("         .fCopyLang                = ").append(isFCopyLang()).append('\n');
        r0.append("         .fPersonalCompose         = ").append(isFPersonalCompose()).append('\n');
        r0.append("         .fPersonalReply           = ").append(isFPersonalReply()).append('\n');
        r0.append("         .fPersonal                = ").append(isFPersonal()).append('\n');
        r0.append("         .fNoHtmlExport            = ").append(isFNoHtmlExport()).append('\n');
        r0.append("         .fSemiHidden              = ").append(isFSemiHidden()).append('\n');
        r0.append("         .fLocked                  = ").append(isFLocked()).append('\n');
        r0.append("         .fInternalUse             = ").append(isFInternalUse()).append('\n');
        r0.append("         .fUnhideWhenUsed          = ").append(isFUnhideWhenUsed()).append('\n');
        r0.append("         .fQFormat                 = ").append(isFQFormat()).append('\n');
        r0.append("         .fReserved                = ").append(getFReserved()).append('\n');
        r0.append("[/StdfBase]\n");
        return r0.toString();
    }
}
