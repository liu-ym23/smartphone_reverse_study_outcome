package org.apache.poi.xdgf.usermodel.section.geometry;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;

/* JADX INFO: loaded from: classes7.dex */
public class NURBSTo implements GeometryRow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f17955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Double f17956b;
    Double c;
    Double d;
    Boolean deleted;
    String e;
    Double x;
    Double y;

    public NURBSTo(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.memorydata.plugin");
        if (r9.isSetDel() == false) goto L5;
        this.deleted = Boolean.valueOf(r9.getDel());
    L5:
        a[] r10 = r9.getCellArray();
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L49;
        a r3 = r10[r2];
        String r4 = r3.getN();
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case 65: goto L35;
            case 66: goto L31;
            case 67: goto L27;
            case 68: goto L23;
            case 69: goto L19;
            case 88: goto L15;
            case 89: goto L11;
            default: goto L38;
        };
    L38:
        switch(r5) {
            case 0: goto L47;
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            default: goto L40;
        };
    L41:
        this.y = XDGFCell.parseDoubleValue(r3);
    L48:
        r2 = r2 + 1;
        goto L6
    L42:
        this.x = XDGFCell.parseDoubleValue(r3);
        goto L48
    L43:
        this.e = r3.getV();
        goto L48
    L44:
        this.d = XDGFCell.parseDoubleValue(r3);
        goto L48
    L45:
        this.c = XDGFCell.parseDoubleValue(r3);
        goto L48
    L46:
        this.f17956b = XDGFCell.parseDoubleValue(r3);
        goto L48
    L47:
        this.f17955a = XDGFCell.parseDoubleValue(r3);
        goto L48
    L40:
        throw new POIXMLException("Invalid cell '" + r4 + "' in NURBS row");
    L11:
        if (r4.equals("Y") == false) goto L38;
        r5 = 6;
        goto L38
    L15:
        if (r4.equals("X") == false) goto L38;
        r5 = 5;
        goto L38
    L19:
        if (r4.equals(ExifInterface.LONGITUDE_EAST) == false) goto L38;
        r5 = 4;
        goto L38
    L23:
        if (r4.equals(com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b) == false) goto L38;
        r5 = 3;
        goto L38
    L27:
        if (r4.equals("C") == false) goto L38;
        r5 = 2;
        goto L38
    L31:
        if (r4.equals("B") == false) goto L38;
        r5 = 1;
        goto L38
    L35:
        if (r4.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == false) goto L38;
        r5 = 0;
        goto L38
    }
}
