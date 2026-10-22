package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.Cdo;
import org.openxmlformats.schemas.drawingml.x2006.main.cd;
import org.openxmlformats.schemas.drawingml.x2006.main.dq;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTextRun implements TextRun {
    private static final c LOG = null;
    private final XSLFTextParagraph _p;
    private final XmlObject _r;

    static {
        LOG = b.a(XSLFTextRun.class);
    }

    public XSLFTextRun(XmlObject r3, XSLFTextParagraph r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        this._r = r5;
        this._p = r4;
        if (ZeusTransformUtils.instanceOf(r5, cd.class) == false) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, dq.class) == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, Cdo.class) == false) goto L10;
        return;
    L10:
        throw new OpenXML4JRuntimeException("unsupported text run of type " + r5.getClass());
    }

    public String getRawText() {
        if (ZeusTransformUtils.instanceOf(this._r, Cdo.class) == false) goto L7;
        return ((Cdo) ZeusTransformUtils.preCheckCast(this._r, Cdo.class, "com.obric.memorydata.plugin")).getT();
    L7:
        if (ZeusTransformUtils.instanceOf(this._r, dq.class) == false) goto L11;
        return "\n";
    L11:
        return ((cd) ZeusTransformUtils.preCheckCast(this._r, cd.class, "com.obric.memorydata.plugin")).getT();
    }

    public String toString() {
        return "[" + getClass() + "]" + getRawText();
    }
}
