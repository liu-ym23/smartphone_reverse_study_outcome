package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.PlexOfField;

/* JADX INFO: loaded from: classes7.dex */
class FieldImpl {
    private PlexOfField endPlex;
    private PlexOfField separatorPlex;
    private PlexOfField startPlex;

    public FieldImpl(PlexOfField r3, PlexOfField r4, PlexOfField r5) {
        if (r3 == null) goto L24;
        if (r5 == null) goto L22;
        if (r3.getFld().getBoundaryType() != 19) goto L20;
        if (r4 == null) goto L14;
        if (r4.getFld().getBoundaryType() == 20) goto L14;
        throw new IllegalArgumentException("separatorPlex" + r4 + ") is not type of FIELD_SEPARATOR");
    L14:
        if (r5.getFld().getBoundaryType() != 21) goto L18;
        this.startPlex = r3;
        this.separatorPlex = r4;
        this.endPlex = r5;
        return;
    L18:
        throw new IllegalArgumentException("endPlex (" + r5 + ") is not type of FIELD_END");
    L20:
        throw new IllegalArgumentException("startPlex (" + r3 + ") is not type of FIELD_BEGIN");
    L22:
        throw new IllegalArgumentException("endPlex == null");
    L24:
        throw new IllegalArgumentException("startPlex == null");
    }

    public int getFieldEndOffset() {
        return this.endPlex.getFcStart() + 1;
    }

    public int getFieldStartOffset() {
        return this.startPlex.getFcStart();
    }

    public int getType() {
        return this.startPlex.getFld().getFieldType();
    }

    public String toString() {
        return "Field [" + getFieldStartOffset() + "; " + getFieldEndOffset() + "] (type: 0x" + Integer.toHexString(getType()) + " = " + getType() + " )";
    }
}
