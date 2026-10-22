package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.HRESIAbstractType;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class Hyphenation extends HRESIAbstractType {
    public Hyphenation() {
    }

    public Hyphenation(Hyphenation r1) {
        super(r1);
    }

    public Hyphenation(short r3) {
        byte[] r0 = new byte[2];
        LittleEndian.putShort(r0, 0, r3);
        fillFields(r0, 0);
    }

    public Hyphenation copy() {
        return new Hyphenation(this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        Hyphenation r6 = (Hyphenation) ZeusTransformUtils.preCheckCast(r5, Hyphenation.class, "com.obric.memorydata.plugin");
        if (this.field_1_hres == r6.field_1_hres) goto L15;
        return false;
    L15:
        if (this.field_2_chHres == r6.field_2_chHres) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Byte.valueOf(this.field_1_hres), Byte.valueOf(this.field_2_chHres)});
    }

    public boolean isEmpty() {
        if (this.field_1_hres == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.field_2_chHres != 0) goto L7;
        return true;
    }

    @Override // org.apache.poi.hwpf.model.types.HRESIAbstractType
    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[HRESI] EMPTY";
    L7:
        return super.toString();
    }
}
