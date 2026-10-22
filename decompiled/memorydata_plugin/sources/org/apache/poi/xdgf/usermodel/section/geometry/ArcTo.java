package org.apache.poi.xdgf.usermodel.section.geometry;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xdgf.usermodel.XDGFCell;

/* JADX INFO: loaded from: classes7.dex */
public class ArcTo implements GeometryRow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f17948a;
    Boolean deleted;
    Double x;
    Double y;

    public ArcTo(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.memorydata.plugin");
        if (r9.isSetDel() == false) goto L5;
        this.deleted = Boolean.valueOf(r9.getDel());
    L5:
        a[] r10 = r9.getCellArray();
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L29;
        a r3 = r10[r2];
        String r4 = r3.getN();
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case 65: goto L19;
            case 88: goto L15;
            case 89: goto L11;
            default: goto L22;
        };
    L22:
        switch(r5) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L24;
        };
    L25:
        this.y = XDGFCell.parseDoubleValue(r3);
    L28:
        r2 = r2 + 1;
        goto L6
    L26:
        this.x = XDGFCell.parseDoubleValue(r3);
        goto L28
    L27:
        this.f17948a = XDGFCell.parseDoubleValue(r3);
        goto L28
    L24:
        throw new POIXMLException("Invalid cell '" + r4 + "' in ArcTo row");
    L11:
        if (r4.equals("Y") == false) goto L22;
        r5 = 2;
        goto L22
    L15:
        if (r4.equals("X") == false) goto L22;
        r5 = 1;
        goto L22
    L19:
        if (r4.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == false) goto L22;
        r5 = 0;
        goto L22
    }

    public String toString() {
        return String.format(LocaleUtil.getUserLocale(), "ArcTo: x=%f; y=%f; a=%f", new Object[]{this.x, this.y, this.f17948a});
    }
}
