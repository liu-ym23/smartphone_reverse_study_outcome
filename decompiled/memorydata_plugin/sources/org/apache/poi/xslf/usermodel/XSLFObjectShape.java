package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.sl.usermodel.ObjectShape;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.ab;
import org.openxmlformats.schemas.presentationml.x2006.main.q;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFObjectShape extends XSLFGraphicFrame implements ObjectShape<XSLFShape, XSLFTextParagraph> {
    private static final QName[] CT_PICTURE = null;
    private static final QName[] GRAPHIC = null;
    private static final QName[] GRAPHIC_DATA = null;
    private static final QName[] OLE_OBJ = null;
    private final ab _oleObject;

    static {
        GRAPHIC = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic")};
        GRAPHIC_DATA = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphicData")};
        OLE_OBJ = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "oleObj")};
        CT_PICTURE = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "pic")};
    }

    XSLFObjectShape(q r6, XSLFSheet r7) {
        super((q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin"), r7);
        this._oleObject = (ab) ZeusTransformUtils.preCheckCast(XPathHelper.selectProperty(getXmlObject(), ab.class, null, new QName[][]{GRAPHIC, GRAPHIC_DATA, OLE_OBJ}), ab.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }
}
