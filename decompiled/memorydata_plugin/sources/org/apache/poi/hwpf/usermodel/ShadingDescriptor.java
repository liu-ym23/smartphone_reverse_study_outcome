package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.types.SHDAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class ShadingDescriptor extends SHDAbstractType {
    public ShadingDescriptor() {
    }

    public ShadingDescriptor(ShadingDescriptor r1) {
        super(r1);
    }

    public ShadingDescriptor(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    public ShadingDescriptor copy() {
        return new ShadingDescriptor(this);
    }

    public boolean isEmpty() {
        if (this.field_3_ipat != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.hwpf.model.types.SHDAbstractType
    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[SHD] EMPTY";
    L7:
        return "[SHD] (cvFore: " + getCvFore() + "; cvBack: " + getCvBack() + "; iPat: " + getIpat() + ")";
    }
}
