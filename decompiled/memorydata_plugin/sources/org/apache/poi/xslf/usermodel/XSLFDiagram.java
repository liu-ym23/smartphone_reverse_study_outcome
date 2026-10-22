package org.apache.poi.xslf.usermodel;

import com.microsoft.schemas.office.drawing.x2008.diagram.b;
import com.microsoft.schemas.office.drawing.x2008.diagram.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.cd;
import org.openxmlformats.schemas.drawingml.x2006.main.ck;
import org.openxmlformats.schemas.drawingml.x2006.main.dv;
import org.openxmlformats.schemas.presentationml.x2006.main.a;
import org.openxmlformats.schemas.presentationml.x2006.main.ah;
import org.openxmlformats.schemas.presentationml.x2006.main.ai;
import org.openxmlformats.schemas.presentationml.x2006.main.q;
import org.openxmlformats.schemas.presentationml.x2006.main.s;
import org.openxmlformats.schemas.presentationml.x2006.main.t;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFDiagram extends XSLFGraphicFrame {
    private final XSLFDiagramDrawing _drawing;
    private final XSLFDiagramGroupShape _groupShape;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFDiagram$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class XSLFDiagramGroupShape extends XSLFGroupShape {
        private XSLFDiagramDrawing diagramDrawing;

        private XSLFDiagramGroupShape(s r3, XSLFSheet r4, XSLFDiagramDrawing r5) {
            super((s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin"), r4);
            this.diagramDrawing = r5;
        }

        /* synthetic */ XSLFDiagramGroupShape(s r2, XSLFSheet r3, XSLFDiagramDrawing r4, AnonymousClass1 r5) {
            this((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    XSLFDiagram(q r3, XSLFSheet r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        super(r5, r4);
        this._drawing = readDiagramDrawing(r5, r4);
        this._groupShape = initGroupShape();
    }

    private XSLFDiagramGroupShape convertMsGroupToGroupShape(b r12, XSLFDiagramDrawing r13) {
        b r14 = (b) ZeusTransformUtils.wrapperContextForParams(r12, b.class, "com.obric.memorydata.plugin");
        s r0 = (s) ZeusTransformUtils.preCheckCast(s.f19317a.newInstance(), s.class, "com.obric.memorydata.plugin");
        r0.addNewGrpSpPr();
        t r2 = r0.addNewNvGrpSpPr();
        r2.setCNvPr(r14.getNvGrpSpPr().getCNvPr());
        r2.setCNvGrpSpPr(r14.getNvGrpSpPr().getCNvGrpSpPr());
        r2.setNvPr((a) ZeusTransformUtils.preCheckCast(a.f19197a.newInstance(), a.class, "com.obric.memorydata.plugin"));
        Iterator<d> r15 = r14.getSpList().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        List<ah> r3 = convertShape((d) ZeusTransformUtils.preCheckCast(r15.next(), d.class, "com.obric.memorydata.plugin"));
        r0.getSpList().addAll(r3);
        goto L4
    L6:
        Rectangle2D r16 = super.getAnchor();
        Rectangle2D r10 = new Rectangle2D.Double(0.0d, 0.0d, r16.getWidth(), r16.getHeight());
        XSLFDiagramGroupShape r1 = new XSLFDiagramGroupShape(r0, getSheet(), r13, null);
        r1.setAnchor(r16);
        r1.setInteriorAnchor(r10);
        r1.setRotation(super.getRotation());
        return r1;
    }

    private List<ah> convertShape(d r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(ah.f19213a.newInstance(), ah.class, "com.obric.memorydata.plugin");
        r0.setStyle(r7.getStyle());
        r0.setSpPr(r7.getSpPr());
        ai r2 = r0.addNewNvSpPr();
        r2.setCNvPr(r7.getNvSpPr().getCNvPr());
        r2.setCNvSpPr(r7.getNvSpPr().getCNvSpPr());
        r2.setNvPr((a) ZeusTransformUtils.preCheckCast(a.f19197a.newInstance(), a.class, "com.obric.memorydata.plugin"));
        r0.setNvSpPr(r2);
        ArrayList r1 = new ArrayList();
        r1.add(r0);
        if (hasTextContent(r7) == false) goto L5;
        r1.add(convertText(r7, r2));
    L5:
        return r1;
    }

    private ah convertText(d r4, ai r5) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        ai r6 = (ai) ZeusTransformUtils.wrapperContextForParams(r5, ai.class, "com.obric.memorydata.plugin");
        ah r7 = (ah) ZeusTransformUtils.preCheckCast(ah.f19213a.newInstance(), ah.class, "com.obric.memorydata.plugin");
        ck r1 = r7.addNewSpPr();
        r7.setTxBody(r3.getTxBody());
        r7.setStyle(r3.getStyle());
        r7.setNvSpPr((ai) ZeusTransformUtils.preCheckCast(r6.copy(), ai.class, "com.obric.memorydata.plugin"));
        r7.getNvSpPr().getCNvSpPr().setTxBox(true);
        r1.setXfrm(r3.getTxXfrm());
        int r8 = r3.getSpPr().getXfrm().getRot();
        int r9 = r3.getTxXfrm().getRot();
        if (r9 == 0) goto L5;
        int r10 = r8 + r9;
        r1.getXfrm().setRot(r10);
    L5:
        return r7;
    }

    private static boolean hasTextContent(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        if (r3.getTxBody() != null) goto L5;
        return false;
    L5:
        if (r3.getTxXfrm() != null) goto L8;
        return false;
    L8:
        return r3.getTxBody().getPList().stream().flatMap($$Lambda$XSLFDiagram$CO1ZWBlzVwHBIW96KQbMUZK_2g.INSTANCE).anyMatch($$Lambda$XSLFDiagram$0a9ZmtQaEcRpezs3qaBG4fjuYU.INSTANCE);
    }

    private XSLFDiagramGroupShape initGroupShape() {
        XSLFDiagramDrawing r0 = getDiagramDrawing();
        if (r0 != null) goto L5;
    L14:
        return null;
    L5:
        if (r0.getDrawingDocument() == null) goto L14;
        b r2 = r0.getDrawingDocument().getDrawing().getSpTree();
        if (r2 == null) goto L14;
        if (r2.getSpList().isEmpty() == true) goto L14;
        return convertMsGroupToGroupShape(r2, r0);
    }

    static /* synthetic */ Stream lambda$hasTextContent$0(dv r2) {
        return ((dv) ZeusTransformUtils.wrapperContextForParams(r2, dv.class, "com.obric.memorydata.plugin")).getRList().stream();
    }

    static /* synthetic */ boolean lambda$hasTextContent$1(cd r2) {
        cd r3 = (cd) ZeusTransformUtils.wrapperContextForParams(r2, cd.class, "com.obric.memorydata.plugin");
        if (r3.getT() != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.getT().trim().isEmpty() == true) goto L7;
        return true;
    }

    private static XSLFDiagramDrawing readDiagramDrawing(q r5, XSLFSheet r6) {
        XmlObject[] r7 = ((q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.memorydata.plugin")).getGraphic().getGraphicData().selectChildren(new QName("http://schemas.openxmlformats.org/drawingml/2006/diagram", "relIds"));
        if (r7.length != 0) goto L5;
        return null;
    L5:
        POIXMLDocumentPart r8 = r6.getRelationById(((org.openxmlformats.schemas.drawingml.x2006.diagram.a) ZeusTransformUtils.preCheckCast(r7[0], org.openxmlformats.schemas.drawingml.x2006.diagram.a.class, "com.obric.memorydata.plugin")).getDm());
        if (r8 != null) goto L8;
        return null;
    L8:
        String r9 = r8.getPackagePart().getPartName().getName().replace("data", "drawing");
        Iterator<POIXMLDocumentPart.RelationPart> r10 = r6.getRelationParts().iterator();
    L10:
        if (r10.hasNext() == false) goto L17;
        POIXMLDocumentPart.RelationPart r0 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r10.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        if (r9.equals(r0.getDocumentPart().getPackagePart().getPartName().getName()) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r0.getDocumentPart(), XSLFDiagramDrawing.class) == false) goto L10;
        return (XSLFDiagramDrawing) ZeusTransformUtils.preCheckCast(r0.getDocumentPart(), XSLFDiagramDrawing.class, "com.obric.memorydata.plugin");
    L17:
        return null;
    }

    public XSLFDiagramDrawing getDiagramDrawing() {
        return this._drawing;
    }
}
