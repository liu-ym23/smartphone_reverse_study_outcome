package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.Colorref;
import org.apache.poi.hwpf.model.types.SHD80AbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class ShadingDescriptor80 extends SHD80AbstractType {
    public ShadingDescriptor80() {
    }

    public ShadingDescriptor80(short r1) {
        this.field_1_value = r1;
    }

    public ShadingDescriptor80(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    public boolean isEmpty() {
        if (this.field_1_value != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ShadingDescriptor toShadingDescriptor() {
        ShadingDescriptor r0 = new ShadingDescriptor();
        r0.setCvFore(Colorref.valueOfIco(getIcoFore()));
        r0.setCvBack(Colorref.valueOfIco(getIcoBack()));
        r0.setIpat(getIpat());
        return r0;
    }

    @Override // org.apache.poi.hwpf.model.types.SHD80AbstractType
    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[SHD80] EMPTY";
    L7:
        return "[SHD80] (icoFore: " + getIcoFore() + "; icoBack: " + getIcoBack() + "; iPat: " + getIpat() + ")";
    }
}
