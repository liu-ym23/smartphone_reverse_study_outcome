package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.model.types.FLDAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class FieldDescriptor extends FLDAbstractType {
    public FieldDescriptor(byte[] r2) {
        fillFields(r2, 0);
    }

    public int getBoundaryType() {
        return getCh();
    }

    public int getFieldType() {
        if (getCh() != 19) goto L7;
        return getFlt();
    L7:
        throw new UnsupportedOperationException("This field is only defined for begin marks.");
    }
}
