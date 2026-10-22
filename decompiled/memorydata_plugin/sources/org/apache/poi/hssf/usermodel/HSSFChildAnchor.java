package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherChildAnchorRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFChildAnchor extends HSSFAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private EscherChildAnchorRecord _escherChildAnchor;

    static {
    }

    public HSSFChildAnchor() {
        this._escherChildAnchor = new EscherChildAnchorRecord();
    }

    public HSSFChildAnchor(EscherChildAnchorRecord r1) {
        this._escherChildAnchor = r1;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void createEscherAnchor() {
        this._escherChildAnchor = new EscherChildAnchorRecord();
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (r5.getClass() == getClass()) goto L11;
        return false;
    L11:
        HSSFChildAnchor r6 = (HSSFChildAnchor) ZeusTransformUtils.preCheckCast(r5, HSSFChildAnchor.class, "com.obric.memorydata.plugin");
        if (r6.getDx1() == getDx1()) goto L14;
        return false;
    L14:
        if (r6.getDx2() == getDx2()) goto L16;
        return false;
    L16:
        if (r6.getDy1() == getDy1()) goto L18;
        return false;
    L18:
        if (r6.getDy2() == getDy2()) goto L20;
        return false;
    L20:
        return true;
    }

    public int getDx1() {
        return this._escherChildAnchor.getDx1();
    }

    public int getDx2() {
        return this._escherChildAnchor.getDx2();
    }

    public int getDy1() {
        return this._escherChildAnchor.getDy1();
    }

    public int getDy2() {
        return this._escherChildAnchor.getDy2();
    }

    public int hashCode() {
        return 42;
    }
}
