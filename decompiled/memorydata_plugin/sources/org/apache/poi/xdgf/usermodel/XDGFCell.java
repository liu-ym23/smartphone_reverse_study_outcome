package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLException;

/* JADX INFO: loaded from: classes7.dex */
public class XDGFCell {
    a _cell;

    public XDGFCell(a r3) {
        this._cell = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public static Double maybeGetDouble(Map<String, XDGFCell> r2, String r3) {
        XDGFCell r4 = (XDGFCell) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get(r3), XDGFCell.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        return parseDoubleValue(r4._cell);
    }

    public static String maybeGetString(Map<String, XDGFCell> r2, String r3) {
        XDGFCell r4 = (XDGFCell) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get(r3), XDGFCell.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        String r5 = r4._cell.getV();
        if (r5 == null) goto L10;
        if (r5.equals("Themed") == true) goto L10;
        return r5;
    L10:
        return null;
    }

    public static Double parseDoubleValue(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5.getV() != null) goto L13;
        return null;
    L13:
        return Double.valueOf(Double.parseDouble(r5.getV()));
    L7:
        e = move-exception;
        if (r5.getV().equals("Themed") == false) goto L12;
        return null;
    L12:
        throw new POIXMLException("Invalid float value for '" + r5.getN() + "': " + e);
    }

    public static Integer parseIntegerValue(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5.getV() != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(Integer.parseInt(r5.getV()));
    L7:
        e = move-exception;
        if (r5.getV().equals("Themed") == false) goto L12;
        return null;
    L12:
        throw new POIXMLException("Invalid integer value for '" + r5.getN() + "': " + e);
    }
}
