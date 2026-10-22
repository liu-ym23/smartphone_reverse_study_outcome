package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.ClientAnchor;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFClientAnchor extends HSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_COL = 0;
    public static final int MAX_ROW = 0;
    private EscherClientAnchorRecord _escherClientAnchor;

    static {
        MAX_COL = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        MAX_ROW = SpreadsheetVersion.EXCEL97.getLastRowIndex();
    }

    public HSSFClientAnchor() {
    }

    public HSSFClientAnchor(EscherClientAnchorRecord r1) {
        this._escherClientAnchor = r1;
    }

    private static int unsignedValue(short r1) {
        if (r1 < 0) goto L4;
        return r1;
    L4:
        return r1 + 65536;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void createEscherAnchor() {
        this._escherClientAnchor = new EscherClientAnchorRecord();
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
        HSSFClientAnchor r6 = (HSSFClientAnchor) ZeusTransformUtils.preCheckCast(r5, HSSFClientAnchor.class, "com.obric.memorydata.plugin");
        if (r6.getCol1() == getCol1()) goto L14;
        return false;
    L14:
        if (r6.getCol2() == getCol2()) goto L16;
        return false;
    L16:
        if (r6.getDx1() == getDx1()) goto L18;
        return false;
    L18:
        if (r6.getDx2() == getDx2()) goto L20;
        return false;
    L20:
        if (r6.getDy1() == getDy1()) goto L22;
        return false;
    L22:
        if (r6.getDy2() == getDy2()) goto L24;
        return false;
    L24:
        if (r6.getRow1() == getRow1()) goto L26;
        return false;
    L26:
        if (r6.getRow2() == getRow2()) goto L28;
        return false;
    L28:
        if (r6.getAnchorType() == getAnchorType()) goto L30;
        return false;
    L30:
        return true;
    }

    public ClientAnchor.AnchorType getAnchorType() {
        return ClientAnchor.AnchorType.byId(this._escherClientAnchor.getFlag());
    }

    public short getCol1() {
        return this._escherClientAnchor.getCol1();
    }

    public short getCol2() {
        return this._escherClientAnchor.getCol2();
    }

    public int getDx1() {
        return this._escherClientAnchor.getDx1();
    }

    public int getDx2() {
        return this._escherClientAnchor.getDx2();
    }

    public int getDy1() {
        return this._escherClientAnchor.getDy1();
    }

    public int getDy2() {
        return this._escherClientAnchor.getDy2();
    }

    public int getRow1() {
        return unsignedValue(this._escherClientAnchor.getRow1());
    }

    public int getRow2() {
        return unsignedValue(this._escherClientAnchor.getRow2());
    }

    public int hashCode() {
        return 42;
    }
}
