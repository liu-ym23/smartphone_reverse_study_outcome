package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;
import org.openxmlformats.schemas.presentationml.x2006.main.s;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFDrawing {
    private XSLFSheet _sheet;
    private s _spTree;

    XSLFDrawing(XSLFSheet r5, s r6) {
        s r7 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
        this._sheet = r5;
        this._spTree = r7;
        XmlObject[] r4 = r5.getSpTree().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr");
        int r8 = r4.length;
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L8;
        XmlObject r2 = r4[r0];
        if (ZeusTransformUtils.instanceOf(r2, ba.class) == false) goto L7;
        r5.registerShapeId((int) ((ba) ZeusTransformUtils.preCheckCast(r2, ba.class, "com.obric.memorydata.plugin")).getId());
    L7:
        r0 = r0 + 1;
        goto L3
    }
}
