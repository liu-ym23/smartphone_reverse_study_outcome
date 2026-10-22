package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;

/* JADX INFO: loaded from: classes7.dex */
public class MoveTo implements GeometryRow {
    MoveTo _master;
    Boolean deleted;
    Double x;
    Double y;

    public MoveTo(p r6) {
        p r7 = (p) ZeusTransformUtils.wrapperContextForParams(r6, p.class, "com.obric.memorydata.plugin");
        if (r7.isSetDel() == false) goto L5;
        this.deleted = Boolean.valueOf(r7.getDel());
    L5:
        a[] r8 = r7.getCellArray();
        int r0 = r8.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L16;
        a r2 = r8[r1];
        String r3 = r2.getN();
        if (r3.equals("X") == false) goto L11;
        this.x = XDGFCell.parseDoubleValue(r2);
    L13:
        r1 = r1 + 1;
        goto L6
    L11:
        if (r3.equals("Y") == false) goto L15;
        this.y = XDGFCell.parseDoubleValue(r2);
        goto L13
    L15:
        throw new POIXMLException("Invalid cell '" + r3 + "' in MoveTo row");
    }

    public Double getX() {
        Double r0 = this.x;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.x;
    }

    public Double getY() {
        Double r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.y;
    }

    public String toString() {
        return "MoveTo: x=" + getX() + "; y=" + getY();
    }
}
