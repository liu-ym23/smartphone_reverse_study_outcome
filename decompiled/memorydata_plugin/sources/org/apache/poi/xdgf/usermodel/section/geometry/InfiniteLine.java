package org.apache.poi.xdgf.usermodel.section.geometry;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;

/* JADX INFO: loaded from: classes7.dex */
public class InfiniteLine implements GeometryRow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f17953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Double f17954b;
    Boolean deleted;
    Double x;
    Double y;

    public InfiniteLine(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.memorydata.plugin");
        if (r9.isSetDel() == false) goto L5;
        this.deleted = Boolean.valueOf(r9.getDel());
    L5:
        a[] r10 = r9.getCellArray();
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L34;
        a r3 = r10[r2];
        String r4 = r3.getN();
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case 65: goto L23;
            case 66: goto L19;
            case 88: goto L15;
            case 89: goto L11;
            default: goto L26;
        };
    L26:
        switch(r5) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            default: goto L28;
        };
    L29:
        this.y = XDGFCell.parseDoubleValue(r3);
    L33:
        r2 = r2 + 1;
        goto L6
    L30:
        this.x = XDGFCell.parseDoubleValue(r3);
        goto L33
    L31:
        this.f17954b = XDGFCell.parseDoubleValue(r3);
        goto L33
    L32:
        this.f17953a = XDGFCell.parseDoubleValue(r3);
        goto L33
    L28:
        throw new POIXMLException("Invalid cell '" + r4 + "' in InfiniteLine row");
    L11:
        if (r4.equals("Y") == false) goto L26;
        r5 = 3;
        goto L26
    L15:
        if (r4.equals("X") == false) goto L26;
        r5 = 2;
        goto L26
    L19:
        if (r4.equals("B") == false) goto L26;
        r5 = 1;
        goto L26
    L23:
        if (r4.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == false) goto L26;
        r5 = 0;
        goto L26
    }
}
