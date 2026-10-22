package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.sl.usermodel.TextBox;
import org.openxmlformats.schemas.presentationml.x2006.main.ah;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTextBox extends XSLFAutoShape implements TextBox<XSLFShape, XSLFTextParagraph> {
    XSLFTextBox(ah r3, XSLFSheet r4) {
        super((ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin"), r4);
    }
}
