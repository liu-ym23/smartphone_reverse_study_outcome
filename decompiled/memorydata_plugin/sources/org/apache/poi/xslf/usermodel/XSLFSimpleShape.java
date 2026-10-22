package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.bi;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XSLFSimpleShape extends XSLFShape implements SimpleShape<XSLFShape, XSLFTextParagraph> {
    private static final c LOG = null;
    private static final bi NO_SHADOW = null;

    static {
        NO_SHADOW = (bi) ZeusTransformUtils.preCheckCast(bi.f18748a.newInstance(), bi.class, "com.obric.memorydata.plugin");
        LOG = b.a(XSLFSimpleShape.class);
    }

    XSLFSimpleShape(XmlObject r3, XSLFSheet r4) {
        super((XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"), r4);
    }
}
