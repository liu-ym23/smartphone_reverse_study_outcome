package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.drawingml.x2006.main.ak;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.f;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFGraphicFrame extends XSSFShape {
    private final f graphicFrame;

    public XSSFGraphicFrame(XSSFDrawing r6, f r7) {
        f r8 = (f) ZeusTransformUtils.wrapperContextForParams(r7, f.class, "com.obric.memorydata.plugin");
        this.drawing = r6;
        this.graphicFrame = r8;
        ak r9 = r8.getGraphic().getGraphicData();
        if (r9 == null) goto L13;
        NodeList r10 = r9.getDomNode().getChildNodes();
        int r0 = 0;
    L6:
        if (r0 >= r10.getLength()) goto L18;
        Node r2 = r10.item(r0);
        if (r2.getNodeName().equals("c:chart") == false) goto L12;
        POIXMLDocumentPart r3 = r6.getRelationById(r2.getAttributes().getNamedItem("r:id").getNodeValue());
        if (ZeusTransformUtils.instanceOf(r3, XSSFChart.class) == false) goto L12;
        ((XSSFChart) ZeusTransformUtils.preCheckCast(r3, XSSFChart.class, "com.obric.memorydata.plugin")).setGraphicFrame(this);
    L12:
        r0 = r0 + 1;
        goto L6
    L18:
        return;
    }
}
