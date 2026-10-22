package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.Colorref;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SHDAbstractType {
    protected Colorref field_1_cvFore;
    protected Colorref field_2_cvBack;
    protected int field_3_ipat;

    public SHDAbstractType() {
        this.field_1_cvFore = new Colorref();
        this.field_2_cvBack = new Colorref();
    }

    public SHDAbstractType(SHDAbstractType r3) {
        Colorref r0 = r3.field_1_cvFore;
        Colorref r1 = null;
        if (r0 != null) goto L5;
        Colorref r2 = null;
    L6:
        this.field_1_cvFore = r2;
        Colorref r4 = r3.field_2_cvBack;
        if (r4 == null) goto L10;
        r1 = r4.copy();
    L10:
        this.field_2_cvBack = r1;
        this.field_3_ipat = r3.field_3_ipat;
        return;
    L5:
        r2 = r0.copy();
        goto L6
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
        SHDAbstractType r6 = (SHDAbstractType) ZeusTransformUtils.preCheckCast(r5, SHDAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_cvFore == r6.field_1_cvFore) goto L15;
        return false;
    L15:
        if (this.field_2_cvBack == r6.field_2_cvBack) goto L18;
        return false;
    L18:
        if (this.field_3_ipat == r6.field_3_ipat) goto L20;
        return false;
    L20:
        return true;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_cvFore = new Colorref(r3, r4 + 0);
        this.field_2_cvBack = new Colorref(r3, r4 + 4);
        this.field_3_ipat = LittleEndian.getShort(r3, r4 + 8);
    }

    public Colorref getCvBack() {
        return this.field_2_cvBack;
    }

    public Colorref getCvFore() {
        return this.field_1_cvFore;
    }

    public int getIpat() {
        return this.field_3_ipat;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.field_1_cvFore, this.field_2_cvBack, Integer.valueOf(this.field_3_ipat)});
    }

    public void setCvBack(Colorref r1) {
        this.field_2_cvBack = r1;
    }

    public void setCvFore(Colorref r1) {
        this.field_1_cvFore = r1;
    }

    public void setIpat(int r1) {
        this.field_3_ipat = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[SHD]\n");
        r0.append("    .cvFore               = ");
        r0.append(" (").append(getCvFore()).append(" )\n");
        r0.append("    .cvBack               = ");
        r0.append(" (").append(getCvBack()).append(" )\n");
        r0.append("    .ipat                 = ");
        r0.append(" (").append(getIpat()).append(" )\n");
        r0.append("[/SHD]\n");
        return r0.toString();
    }
}
