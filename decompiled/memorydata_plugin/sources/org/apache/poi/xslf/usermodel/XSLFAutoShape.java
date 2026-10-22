package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.sl.usermodel.AutoShape;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.df;
import org.openxmlformats.schemas.presentationml.x2006.main.ah;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFAutoShape extends XSLFTextShape implements AutoShape<XSLFShape, XSLFTextParagraph> {
    XSLFAutoShape(ah r3, XSLFSheet r4) {
        super((ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin"), r4);
    }

    static XSLFAutoShape create(ah r2, XSLFSheet r3) {
        ah r4 = (ah) ZeusTransformUtils.wrapperContextForParams(r2, ah.class, "com.obric.memorydata.plugin");
        if (r4.getSpPr().isSetCustGeom() == false) goto L7;
        return new XSLFFreeformShape(r4, r3);
    L7:
        if (r4.getNvSpPr().getCNvSpPr().isSetTxBox() == false) goto L11;
        return new XSLFTextBox(r4, r3);
    L11:
        return new XSLFAutoShape(r4, r3);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public df getTextBody(boolean r4) {
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(getXmlObject(), ah.class, "com.obric.memorydata.plugin");
        df r1 = r0.getTxBody();
        if (r1 != null) goto L7;
        if (r4 == false) goto L8;
        r0.setTxBody(new XDDFTextBody(this).getXmlObject());
        return r0.getTxBody();
    L8:
        return r1;
    L7:
        return r1;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getShapeName();
    }
}
