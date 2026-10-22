package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.ac;
import org.openxmlformats.schemas.presentationml.x2006.main.ah;
import org.openxmlformats.schemas.presentationml.x2006.main.i;
import org.openxmlformats.schemas.presentationml.x2006.main.q;
import org.openxmlformats.schemas.presentationml.x2006.main.s;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XSLFSheet extends POIXMLDocumentPart implements Sheet<XSLFShape, XSLFTextParagraph>, XSLFShapeContainer {
    private static final c LOG = null;
    private XSLFDrawing _drawing;
    private List<XSLFShape> _shapes;
    private s _spTree;
    private final SparseBitSet shapeIds;

    static {
        LOG = b.a(XSLFSheet.class);
    }

    public XSLFSheet() {
        this.shapeIds = new SparseBitSet();
    }

    public XSLFSheet(PackagePart r1) {
        super(r1);
        this.shapeIds = new SparseBitSet();
    }

    public static List<XSLFShape> buildShapes(s r6, XSLFShapeContainer r7) {
        s r8 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
        XSLFShapeContainer r9 = (XSLFShapeContainer) ZeusTransformUtils.wrapperContextForParams(r7, XSLFShapeContainer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, XSLFSheet.class) == false) goto L5;
        XSLFSheet r0 = (XSLFSheet) ZeusTransformUtils.preCheckCast(r9, XSLFSheet.class, "com.obric.memorydata.plugin");
    L6:
        ArrayList r1 = new ArrayList();
        XmlCursor r10 = r8.newCursor();
        boolean r3 = r10.toFirstChild();     // Catch: Throwable -> L46
    L8:
        if (r3 == false) goto L39;
        XmlObject r4 = r10.getObject();     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(r4, ah.class) == false) goto L14;
        XSLFShape r5 = XSLFAutoShape.create((ah) ZeusTransformUtils.preCheckCast(r4, ah.class, "com.obric.memorydata.plugin"), r0);     // Catch: Throwable -> L46
    L12:
        r1.add(r5);     // Catch: Throwable -> L46
    L37:
        r3 = r10.toNextSibling();     // Catch: Throwable -> L46
        goto L8
    L14:
        if (ZeusTransformUtils.instanceOf(r4, s.class) == false) goto L18;
        XSLFShape r11 = new XSLFGroupShape((s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.memorydata.plugin"), r0);     // Catch: Throwable -> L46
    L16:
        r1.add(r11);     // Catch: Throwable -> L46
        goto L37
    L18:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L21;
        r11 = new XSLFConnectorShape((i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin"), r0);     // Catch: Throwable -> L46
        goto L16
    L21:
        if (ZeusTransformUtils.instanceOf(r4, ac.class) == false) goto L24;
        r11 = new XSLFPictureShape((ac) ZeusTransformUtils.preCheckCast(r4, ac.class, "com.obric.memorydata.plugin"), r0);     // Catch: Throwable -> L46
        goto L16
    L24:
        if (ZeusTransformUtils.instanceOf(r4, q.class) == false) goto L27;
        r5 = XSLFGraphicFrame.create((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.memorydata.plugin"), r0);     // Catch: Throwable -> L46
        goto L12
    L27:
        if (ZeusTransformUtils.instanceOf(r4, XmlAnyTypeImpl.class) == false) goto L37;
        r10.push();     // Catch: Throwable -> L46
        if (r10.toChild("http://schemas.openxmlformats.org/markup-compatibility/2006", "Choice") == true) goto L31;
    L36:
        r10.pop();     // Catch: Throwable -> L46
        goto L37
    L31:
        if (r10.toFirstChild() == false) goto L36;
        r1.addAll(buildShapes((s) ZeusTransformUtils.preCheckCast(s.f19317a.parse(r10.newXMLStreamReader()), s.class, "com.obric.memorydata.plugin"), r9));     // Catch: XmlException -> L34 Throwable -> L46
    L34:
        e = move-exception;
        LOG.atDebug().a(e).a("unparsable alternate content");     // Catch: Throwable -> L46
        goto L36
    L39:
        if (r10 == null) goto L41;
        r10.close();
    L41:
        Iterator r12 = r1.iterator();
    L43:
        if (r12.hasNext() == false) goto L45;
        ((XSLFShape) ZeusTransformUtils.preCheckCast(r12.next(), XSLFShape.class, "com.obric.memorydata.plugin")).setParent(r9);
        goto L43
    L45:
        return r1;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (r10 != null) goto L61;
    L54:
        throw th;
    L61:
        r10.close();     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        th.addSuppressed(th);
        goto L54
    L5:
        r0 = ((XSLFShape) ZeusTransformUtils.preCheckCast(r9, XSLFShape.class, "com.obric.memorydata.plugin")).getSheet();
        goto L6
    }

    private void initDrawingAndShapes() {
        s r0 = getSpTree();
        if (this._drawing != null) goto L6;
        this._drawing = new XSLFDrawing(this, r0);
    L6:
        if (this._shapes != null) goto L9;
        this._shapes = buildShapes(r0, this);
        return;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public final void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        String r1 = getRootElementName();
        if (r1 == null) goto L5;
        r0.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/presentationml/2006/main", r1));
    L5:
        OutputStream r2 = getPackagePart().getOutputStream();
        getXmlObject().save(r2, r0);     // Catch: Throwable -> L10
        if (r2 == null) goto L25;
        r2.close();
        return;
    L25:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r2 != null) goto L19;
    L18:
        throw th;
    L19:
        r2.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    public abstract String getRootElementName();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        initDrawingAndShapes();
        return this._shapes;
    }

    public XMLSlideShow getSlideShow() {
        POIXMLDocumentPart r2 = getParent();
    L3:
        if (r2 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, XMLSlideShow.class) == true) goto L7;
        r2 = r2.getParent();
        goto L3
    L7:
        return (XMLSlideShow) ZeusTransformUtils.preCheckCast(r2, XMLSlideShow.class, "com.obric.memorydata.plugin");
    L10:
        throw new IllegalStateException("SlideShow was not found");
    }

    public s getSpTree() {
        if (this._spTree != null) goto L10;
        XmlObject[] r0 = getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:spTree");
        if (r0.length == 0) goto L8;
        this._spTree = (s) ZeusTransformUtils.preCheckCast(r0[0], s.class, "com.obric.memorydata.plugin");
        goto L10
    L8:
        throw new IllegalStateException("CTGroupShape was not found");
    L10:
        return this._spTree;
    }

    public XSLFTextShape getTextShapeByType(Placeholder r4) {
        Iterator<XSLFShape> r3 = getShapes().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        XSLFShape r0 = (XSLFShape) ZeusTransformUtils.preCheckCast(r3.next(), XSLFShape.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, XSLFTextShape.class) == false) goto L4;
        XSLFTextShape r1 = (XSLFTextShape) ZeusTransformUtils.preCheckCast(r0, XSLFTextShape.class, "com.obric.memorydata.plugin");
        if (r1.getTextType() != r4) goto L4;
        return r1;
    L10:
        return null;
    }

    public abstract XmlObject getXmlObject();

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return getShapes().iterator();
    }

    public void registerShapeId(int r4) {
        if (this.shapeIds.get(r4) == false) goto L5;
        LOG.atWarn().a("shape id {} has been already used.", v.a(r4));
    L5:
        this.shapeIds.set(r4);
    }
}
