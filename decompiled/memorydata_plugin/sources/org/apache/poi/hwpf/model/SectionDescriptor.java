package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SectionDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int fcMpr;
    private int fcSepx;
    private short fn;
    private short fnMpr;

    static {
    }

    public SectionDescriptor() {
    }

    public SectionDescriptor(byte[] r2, int r3) {
        this.fn = LittleEndian.getShort(r2, r3);
        int r4 = r3 + 2;
        this.fcSepx = LittleEndian.getInt(r2, r4);
        int r5 = r4 + 4;
        this.fnMpr = LittleEndian.getShort(r2, r5);
        this.fcMpr = LittleEndian.getInt(r2, r5 + 2);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SectionDescriptor.class) == true) goto L5;
        return false;
    L5:
        SectionDescriptor r5 = (SectionDescriptor) ZeusTransformUtils.preCheckCast(r4, SectionDescriptor.class, "com.obric.memorydata.plugin");
        if (r5.fn == this.fn) goto L8;
        return false;
    L8:
        if (r5.fnMpr != this.fnMpr) goto L12;
        return true;
    L12:
        return false;
    }

    public int getFc() {
        return this.fcSepx;
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "[SED] (fn: " + this.fn + "; fcSepx: " + this.fcSepx + "; fnMpr: " + this.fnMpr + "; fcMpr: " + this.fcMpr + ")";
    }
}
