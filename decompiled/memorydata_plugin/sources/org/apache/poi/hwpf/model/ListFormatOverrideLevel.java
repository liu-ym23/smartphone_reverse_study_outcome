package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hwpf.model.types.LFOLVLBaseAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class ListFormatOverrideLevel {
    private LFOLVLBase _base;
    private ListLevel _lvl;

    public ListFormatOverrideLevel(byte[] r2, int r3) {
        this._base = new LFOLVLBase(r2, r3);
        int r4 = r3 + LFOLVLBaseAbstractType.getSize();
        if (this._base.isFFormatting() == false) goto L6;
        this._lvl = new ListLevel(r2, r4);
        return;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, ListFormatOverrideLevel.class) == true) goto L5;
        return false;
    L5:
        ListFormatOverrideLevel r6 = (ListFormatOverrideLevel) ZeusTransformUtils.preCheckCast(r5, ListFormatOverrideLevel.class, "com.obric.memorydata.plugin");
        ListLevel r0 = this._lvl;
        if (r0 == null) goto L9;
        boolean r1 = r0.equals(r6._lvl);
    L12:
        if (r1 == true) goto L14;
        return false;
    L14:
        if (r6._base.equals(this._base) == true) goto L16;
        return false;
    L16:
        return true;
    L9:
        if (r6._lvl != null) goto L11;
        r1 = true;
        goto L12
    L11:
        r1 = false;
        goto L12
    }

    public int getSizeInBytes() {
        if (this._lvl == null) goto L7;
        int r0 = LFOLVLBaseAbstractType.getSize();
        return this._lvl.getSizeInBytes() + r0;
    L7:
        return LFOLVLBaseAbstractType.getSize();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this._base, this._lvl});
    }
}
