package org.apache.poi.hwpf.model.types;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HRESIAbstractType {
    protected byte field_1_hres;
    protected byte field_2_chHres;

    public HRESIAbstractType() {
    }

    public HRESIAbstractType(HRESIAbstractType r2) {
        this.field_1_hres = r2.field_1_hres;
        this.field_2_chHres = r2.field_2_chHres;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_hres = r2[r3 + 0];
        this.field_2_chHres = r2[r3 + 1];
    }

    public byte getChHres() {
        return this.field_2_chHres;
    }

    public byte getHres() {
        return this.field_1_hres;
    }

    public String toString() {
        return "[HRESI]\n    .hres                 =  (" + getHres() + " )\n    .chHres               =  (" + getChHres() + " )\n[/HRESI]\n";
    }
}
