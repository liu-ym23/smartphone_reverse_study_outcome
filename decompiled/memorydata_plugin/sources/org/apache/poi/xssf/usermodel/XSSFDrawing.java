package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.a;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.e;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.f;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.h;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.j;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.k;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.l;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.n;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.p;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFDrawing extends POIXMLDocumentPart implements Drawing<XSSFShape> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private e drawing;

    static {
        LOG = b.a(XSSFDrawing.class);
    }

    public XSSFDrawing() {
        this.drawing = newDrawing();
    }

    public XSSFDrawing(PackagePart r4) {
        super(r4);
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setLoadReplaceDocumentElement(null);
        InputStream r5 = r4.getInputStream();
        this.drawing = (e) ZeusTransformUtils.preCheckCast(e.f19028a.parse(r5, r0), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        if (r5 == null) goto L22;
        r5.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r5 != null) goto L16;
    L15:
        throw th;
    L16:
        r5.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private void addShapes(XmlCursor r5, List<XSSFShape> r6) {
        XmlCursor r7 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r5, XmlCursor.class, "com.obric.memorydata.plugin");
        List<XSSFShape> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
    L3:
        r7.push();
        if (r7.toFirstChild() == false) goto L55;
    L5:
        XmlObject r0 = r7.getObject();
        if (ZeusTransformUtils.instanceOf(r0, j.class) == true) goto L54;
        if (ZeusTransformUtils.instanceOf(r0, l.class) == false) goto L12;
        XSSFShape r2 = new XSSFPicture(this, (l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.memorydata.plugin"));
    L26:
        r2.anchor = getAnchorFromParent(r0);
        r8.add(r2);
        goto L54
    L12:
        if (ZeusTransformUtils.instanceOf(r0, org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.c.class) == false) goto L15;
        r2 = new XSSFConnector(this, (org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.c) ZeusTransformUtils.preCheckCast(r0, org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.c.class, "com.obric.memorydata.plugin"));
        goto L26
    L15:
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L21;
        if (hasOleLink(r0) == false) goto L19;
        r2 = new XSSFObjectData(this, (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin"));
        goto L26
    L19:
        r2 = new XSSFSimpleShape(this, (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin"));
        goto L26
    L21:
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L24;
        r2 = new XSSFGraphicFrame(this, (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin"));
        goto L26
    L24:
        if (ZeusTransformUtils.instanceOf(r0, h.class) == false) goto L28;
        r2 = new XSSFShapeGroup(this, (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.memorydata.plugin"));
        goto L26
    L28:
        if (ZeusTransformUtils.instanceOf(r0, XmlAnyTypeImpl.class) == false) goto L54;
        LOG.atWarn().a("trying to parse AlternateContent, this unlinks the returned Shapes from the underlying xml content, so those shapes can't be used to modify the drawing, i.e. modifications will be ignored!");
        r7.push();
        r7.toFirstChild();
        XmlCursor r1 = ((e) ZeusTransformUtils.preCheckCast(e.f19028a.parse(r7.newXMLStreamReader()), e.class, "com.obric.memorydata.plugin")).newCursor();     // Catch: Throwable -> L46 XmlException -> L48
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r1 != null) goto L65;
    L45:
        throw th;     // Catch: Throwable -> L46 XmlException -> L48
    L65:
        r1.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L46 XmlException -> L48
        goto L45
    L32:
        if (r1.toFirstChild() == false) goto L34;
        addShapes(r1, r8);     // Catch: Throwable -> L37
    L34:
        if (r1 == null) goto L50;
        r1.close();     // Catch: Throwable -> L46 XmlException -> L48
    L50:
        r7.pop();
    L48:
        e = move-exception;
        LOG.atWarn().a(e).a("unable to parse CTDrawing in alternate content.");     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r7.pop();
        throw th;
    L54:
        if (r7.toNextSibling() == true) goto L5;
    L55:
        r7.pop();
        if (r7.toNextSibling() == true) goto L3;
    }

    private XSSFAnchor getAnchorFromParent(XmlObject r4) {
        XmlCursor r5 = ((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin")).newCursor();
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r5 != null) goto L34;
    L29:
        throw th;
    L34:
        r5.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    L4:
        if (r5.toParent() == false) goto L7;
        XmlObject r0 = r5.getObject();     // Catch: Throwable -> L21
    L8:
        if (r5 == null) goto L10;
        r5.close();
    L10:
        if (r0 != null) goto L12;
        return null;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, p.class) == false) goto L15;
        p r3 = (p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.memorydata.plugin");
        return new XSSFClientAnchor(r3.getFrom(), r3.getTo());
    L15:
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L18;
        k r6 = (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin");
        return new XSSFClientAnchor(getSheet(), r6.getFrom(), r6.getExt());
    L18:
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L39;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        return new XSSFClientAnchor(getSheet(), r7.getPos(), r7.getExt());
    L39:
        return null;
    L7:
        r0 = null;
        goto L8
    }

    private boolean hasOleLink(XmlObject r3) {
        XmlObject r2 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        QName r4 = new QName(null, "uri");
        XmlCursor r5 = r2.newCursor();
        r5.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:extLst/a:ext");     // Catch: Throwable -> L16
    L5:
        if (r5.toNextSelection() == false) goto L12;
        if ("{63B3BB69-23CF-44E3-9099-C40C66FF867C}".equals(r5.getAttributeText(r4)) == false) goto L5;
        if (r5 == null) goto L11;
        r5.close();
    L11:
        return true;
    L12:
        if (r5 == null) goto L34;
        r5.close();
        return false;
    L34:
        return false;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r5 != null) goto L25;
    L24:
        throw th;
    L25:
        r5.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private static e newDrawing() {
        return (e) ZeusTransformUtils.preCheckCast(e.f19028a.newInstance(), e.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(e.f19029b.getName().getNamespaceURI(), "wsDr", "xdr"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.drawing.save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public List<XSSFShape> getShapes() {
        ArrayList r0 = new ArrayList();
        XmlCursor r1 = this.drawing.newCursor();
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r1 != null) goto L18;
    L17:
        throw th;
    L18:
        r1.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L4:
        if (r1.toFirstChild() == false) goto L6;
        addShapes(r1, r0);     // Catch: Throwable -> L9
    L6:
        if (r1 == null) goto L8;
        r1.close();
    L8:
        return r0;
    }

    public List<XSSFShape> getShapes(XSSFShapeGroup r2) {
        ArrayList r0 = new ArrayList();
        XmlCursor r3 = r2.getCTGroupShape().newCursor();
        addShapes(r3, r0);     // Catch: Throwable -> L7
        if (r3 == null) goto L6;
        r3.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public XSSFSheet getSheet() {
        return (XSSFSheet) ZeusTransformUtils.preCheckCast(getParent(), XSSFSheet.class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getShapes().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFShape> spliterator() {
        return getShapes().spliterator();
    }
}
