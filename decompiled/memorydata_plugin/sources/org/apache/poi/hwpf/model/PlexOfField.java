package org.apache.poi.hwpf.model;

import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class PlexOfField {
    private final FieldDescriptor fld;
    private final GenericPropertyNode propertyNode;

    public PlexOfField(GenericPropertyNode r2) {
        this.propertyNode = r2;
        this.fld = new FieldDescriptor(r2.getBytes());
    }

    public int getFcEnd() {
        return this.propertyNode.getEnd();
    }

    public int getFcStart() {
        return this.propertyNode.getStart();
    }

    public FieldDescriptor getFld() {
        return this.fld;
    }

    public String toString() {
        return String.format(Locale.ROOT, "[%d, %d) - FLD - 0x%x; 0x%x", new Object[]{Integer.valueOf(getFcStart()), Integer.valueOf(getFcEnd()), Integer.valueOf(this.fld.getBoundaryType()), Byte.valueOf(this.fld.getFlt())});
    }
}
