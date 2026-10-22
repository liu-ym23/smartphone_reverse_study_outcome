package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import javax.xml.stream.e;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.an;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XSLFShape implements Shape<XSLFShape, XSLFTextParagraph> {
    private static final QName[] CNV_PROPS = null;
    private static final QName[] NV_CONTAINER = null;
    private ba _nvPr;
    private XSLFShapeContainer _parent;
    private final XmlObject _shape;
    private final XSLFSheet _sheet;

    public interface ReparseFactory<T extends XmlObject> {
        T parse(e r1);
    }

    static {
        NV_CONTAINER = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvCxnSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGrpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPicPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr")};
        CNV_PROPS = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr")};
    }

    public XSLFShape(XmlObject r3, XSLFSheet r4) {
        this._shape = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        this._sheet = r4;
    }

    public ba getCNvPr() {
    L8:
        return null;
    L4:
        if (this._nvPr != null) goto L6;
        this._nvPr = (ba) ZeusTransformUtils.preCheckCast(XPathHelper.selectProperty(getXmlObject(), ba.class, null, new QName[][]{NV_CONTAINER, CNV_PROPS}), ba.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L8
    L6:
        return this._nvPr;
    }

    public <T extends XmlObject> T getChild(Class<T> r1, String r2, String r3) {
        XmlCursor r0 = getXmlObject().newCursor();
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r0 != null) goto L26;
    L21:
        throw th;
    L26:
        r0.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L4:
        if (r0.toChild(r2, r3) == false) goto L6;
        T r4 = (T) r0.getObject();
    L8:
        if (r0.toChild("http://schemas.openxmlformats.org/drawingml/2006/main", r3) == false) goto L10;
        r4 = (T) r0.getObject();
    L10:
        if (r0 == null) goto L12;
        r0.close();
    L12:
        return r4;
    L6:
        r4 = null;
        goto L8
    }

    public an getGrpSpPr() {
        return (an) ZeusTransformUtils.preCheckCast(getChild(an.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "grpSpPr"), an.class, "com.obric.memorydata.plugin");
    }

    public Placeholder getPlaceholder() {
        return getPlaceholderDetails().getPlaceholder();
    }

    public XSLFPlaceholderDetails getPlaceholderDetails() {
        return new XSLFPlaceholderDetails(this);
    }

    public String getShapeName() {
        ba r0 = getCNvPr();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getName();
    }

    public XSLFSheet getSheet() {
        return this._sheet;
    }

    public final XmlObject getXmlObject() {
        return this._shape;
    }

    public void setParent(XSLFShapeContainer r3) {
        this._parent = (XSLFShapeContainer) ZeusTransformUtils.wrapperContextForParams(r3, XSLFShapeContainer.class, "com.obric.memorydata.plugin");
    }
}
