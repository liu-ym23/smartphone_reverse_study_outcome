package org.apache.poi.poifs.property;

/* JADX INFO: loaded from: classes7.dex */
public final class RootProperty extends DirectoryProperty {
    RootProperty() {
        super("Root Entry");
        setNodeColor((byte) 1);
        setPropertyType((byte) 5);
        setStartBlock(-2);
    }

    RootProperty(int r1, byte[] r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // org.apache.poi.poifs.property.Property
    public String getName() {
        return "Root Entry";
    }

    @Override // org.apache.poi.poifs.property.Property
    public void setSize(int r2) {
        super.setSize(Math.multiplyExact(r2, 64));
    }
}
