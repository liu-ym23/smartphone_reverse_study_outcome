package org.apache.poi.xdgf.usermodel.section.geometry;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;

/* JADX INFO: loaded from: classes7.dex */
public class SplineStart implements GeometryRow {
    SplineStart _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f17965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Double f17966b;
    Double c;
    Integer d;
    Boolean deleted;
    Double x;
    Double y;

    public SplineStart(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.memorydata.plugin");
        if (r9.isSetDel() == false) goto L5;
        this.deleted = Boolean.valueOf(r9.getDel());
    L5:
        a[] r10 = r9.getCellArray();
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L44;
        a r3 = r10[r2];
        String r4 = r3.getN();
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case 65: goto L31;
            case 66: goto L27;
            case 67: goto L23;
            case 68: goto L19;
            case 88: goto L15;
            case 89: goto L11;
            default: goto L34;
        };
    L34:
        switch(r5) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            default: goto L36;
        };
    L37:
        this.y = XDGFCell.parseDoubleValue(r3);
    L43:
        r2 = r2 + 1;
        goto L6
    L38:
        this.x = XDGFCell.parseDoubleValue(r3);
        goto L43
    L39:
        this.d = XDGFCell.parseIntegerValue(r3);
        goto L43
    L40:
        this.c = XDGFCell.parseDoubleValue(r3);
        goto L43
    L41:
        this.f17966b = XDGFCell.parseDoubleValue(r3);
        goto L43
    L42:
        this.f17965a = XDGFCell.parseDoubleValue(r3);
        goto L43
    L36:
        throw new POIXMLException("Invalid cell '" + r4 + "' in SplineStart row");
    L11:
        if (r4.equals("Y") == false) goto L34;
        r5 = 5;
        goto L34
    L15:
        if (r4.equals("X") == false) goto L34;
        r5 = 4;
        goto L34
    L19:
        if (r4.equals(com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b) == false) goto L34;
        r5 = 3;
        goto L34
    L23:
        if (r4.equals("C") == false) goto L34;
        r5 = 2;
        goto L34
    L27:
        if (r4.equals("B") == false) goto L34;
        r5 = 1;
        goto L34
    L31:
        if (r4.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == false) goto L34;
        r5 = 0;
        goto L34
    }

    public Double getA() {
        Double r0 = this.f17965a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.f17965a;
    }

    public Double getB() {
        Double r0 = this.f17966b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.f17966b;
    }

    public Double getC() {
        Double r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.c;
    }

    public Integer getD() {
        Integer r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this._master.d;
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
        return "{SplineStart x=" + getX() + " y=" + getY() + " a=" + getA() + " b=" + getB() + " c=" + getC() + " d=" + getD() + "}";
    }
}
