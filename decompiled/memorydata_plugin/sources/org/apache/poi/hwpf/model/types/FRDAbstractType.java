package org.apache.poi.hwpf.model.types;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FRDAbstractType {
    protected short field_1_nAuto;

    public static int getSize() {
        return 2;
    }

    public short getNAuto() {
        return this.field_1_nAuto;
    }

    public String toString() {
        return "[FRD]\n    .nAuto                =  (" + getNAuto() + " )\n[/FRD]\n";
    }
}
