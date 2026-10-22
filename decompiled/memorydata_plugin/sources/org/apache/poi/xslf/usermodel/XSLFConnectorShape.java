package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.sl.usermodel.ConnectorShape;
import org.openxmlformats.schemas.presentationml.x2006.main.i;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFConnectorShape extends XSLFSimpleShape implements ConnectorShape<XSLFShape, XSLFTextParagraph> {
    XSLFConnectorShape(i r3, XSLFSheet r4) {
        super((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), r4);
    }
}
