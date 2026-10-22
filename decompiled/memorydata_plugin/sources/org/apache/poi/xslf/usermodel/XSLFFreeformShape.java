package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.openxmlformats.schemas.presentationml.x2006.main.ah;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFFreeformShape extends XSLFAutoShape implements FreeformShape<XSLFShape, XSLFTextParagraph> {
    private static final c LOG = null;

    static {
        LOG = b.a(XSLFFreeformShape.class);
    }

    XSLFFreeformShape(ah r3, XSLFSheet r4) {
        super((ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin"), r4);
    }
}
