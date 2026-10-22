package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FLDAbstractType {
    private static final BitField ch = null;
    private static final BitField fDiffer = null;
    private static final BitField fHasSep = null;
    private static final BitField fLocked = null;
    private static final BitField fNested = null;
    private static final BitField fPrivateResult = null;
    private static final BitField fResultDirty = null;
    private static final BitField fResultEdited = null;
    private static final BitField fZombieEmbed = null;
    private static final BitField reserved = null;
    protected byte field_1_chHolder;
    protected byte field_2_flt;

    static {
        ch = new BitField(31);
        reserved = new BitField(224);
        fDiffer = new BitField(1);
        fZombieEmbed = new BitField(2);
        fResultDirty = new BitField(4);
        fResultEdited = new BitField(8);
        fLocked = new BitField(16);
        fPrivateResult = new BitField(32);
        fNested = new BitField(64);
        fHasSep = new BitField(64);
    }

    public FLDAbstractType() {
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_chHolder = r2[r3 + 0];
        this.field_2_flt = r2[r3 + 1];
    }

    public byte getCh() {
        return (byte) ch.getValue(this.field_1_chHolder);
    }

    public byte getChHolder() {
        return this.field_1_chHolder;
    }

    public byte getFlt() {
        return this.field_2_flt;
    }

    public byte getReserved() {
        return (byte) reserved.getValue(this.field_1_chHolder);
    }

    public boolean isFDiffer() {
        return fDiffer.isSet(this.field_2_flt);
    }

    public boolean isFHasSep() {
        return fHasSep.isSet(this.field_2_flt);
    }

    public boolean isFLocked() {
        return fLocked.isSet(this.field_2_flt);
    }

    public boolean isFNested() {
        return fNested.isSet(this.field_2_flt);
    }

    public boolean isFPrivateResult() {
        return fPrivateResult.isSet(this.field_2_flt);
    }

    public boolean isFResultDirty() {
        return fResultDirty.isSet(this.field_2_flt);
    }

    public boolean isFResultEdited() {
        return fResultEdited.isSet(this.field_2_flt);
    }

    public boolean isFZombieEmbed() {
        return fZombieEmbed.isSet(this.field_2_flt);
    }

    public String toString() {
        return "[FLD]\n    .chHolder             =  (" + getChHolder() + " )\n         .ch                       = " + getCh() + "\n         .reserved                 = " + getReserved() + "\n    .flt                  =  (" + getFlt() + " )\n         .fDiffer                  = " + isFDiffer() + "\n         .fZombieEmbed             = " + isFZombieEmbed() + "\n         .fResultDirty             = " + isFResultDirty() + "\n         .fResultEdited            = " + isFResultEdited() + "\n         .fLocked                  = " + isFLocked() + "\n         .fPrivateResult           = " + isFPrivateResult() + "\n         .fNested                  = " + isFNested() + "\n         .fHasSep                  = " + isFHasSep() + "\n[/FLD]\n";
    }
}
