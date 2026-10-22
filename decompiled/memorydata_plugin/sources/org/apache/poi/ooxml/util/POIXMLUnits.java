package org.apache.poi.ooxml.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.openxmlformats.schemas.drawingml.x2006.main.el;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.f;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bu;

/* JADX INFO: loaded from: classes7.dex */
public class POIXMLUnits {
    public static long parseLength(el r2) {
        return parseLengthInner((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), 1.0d);
    }

    private static long parseLengthInner(XmlAnySimpleType r7, double r8) {
        String r9 = ((XmlAnySimpleType) ZeusTransformUtils.wrapperContextForParams(r7, XmlAnySimpleType.class, "com.obric.memorydata.plugin")).getStringValue().toLowerCase(Locale.ROOT);
        double r0 = Double.parseDouble(r9.replaceAll("(mm|cm|in|pt|pc|pi)", ""));
        if (r9.endsWith("mm") == false) goto L9;
        r0 = r0 / 10.0d;
    L5:
        r0 = r0 / 2.5399999618530273d;
    L6:
        double r1 = r0 * 914400.0d;
    L24:
        return (long) r1;
    L9:
        if (r9.endsWith("cm") == true) goto L5;
        if (r9.endsWith("in") == true) goto L6;
        if (r9.endsWith("pc") == false) goto L17;
    L23:
        r0 = r0 * 0.16599999368190765d;
        goto L6
    L17:
        if (r9.endsWith("pi") == true) goto L23;
        if (r9.endsWith("pt") == false) goto L22;
        r1 = r0 * 12700.0d;
        goto L24
    L22:
        r1 = r0 * r8;
        goto L24
    }

    public static boolean parseOnOff(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return false;
    L5:
        String r4 = r3.getStringValue();
        if ("true".equalsIgnoreCase(r4) == false) goto L8;
    L13:
        return true;
    L8:
        if (com.tom_roush.pdfbox.pdmodel.a.d.f.f.equalsIgnoreCase(r4) == true) goto L13;
        if ("x".equalsIgnoreCase(r4) == true) goto L13;
        if ("1".equals(r4) == true) goto L13;
        return false;
    }

    public static boolean parseOnOff(bu r2) {
        bu r3 = (bu) ZeusTransformUtils.wrapperContextForParams(r2, bu.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.isSetVal() == true) goto L11;
        return true;
    L11:
        return parseOnOff(r3.xgetVal());
    }
}
