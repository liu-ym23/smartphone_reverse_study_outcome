package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hwpf.sprm.SprmBuffer;

/* JADX INFO: loaded from: classes7.dex */
public final class SEPX extends PropertyNode<SEPX> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    SectionDescriptor _sed;

    static {
    }

    public SEPX(SectionDescriptor r3, int r4, int r5, byte[] r6) {
        super(r4, r5, new SprmBuffer(r6, 0));
        this._sed = r3;
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SEPX.class) == true) goto L5;
        return false;
    L5:
        SEPX r0 = (SEPX) ZeusTransformUtils.preCheckCast(r4, SEPX.class, "com.obric.memorydata.plugin");
        if (super.equals(r4) == true) goto L8;
        return false;
    L8:
        return r0._sed.equals(this._sed);
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "SEPX from " + getStart() + " to " + getEnd();
    }
}
