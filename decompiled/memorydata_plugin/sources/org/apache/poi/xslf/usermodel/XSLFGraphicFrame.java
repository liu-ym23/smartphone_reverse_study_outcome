package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.usermodel.GraphicalFrame;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.aj;
import org.openxmlformats.schemas.drawingml.x2006.main.ak;
import org.openxmlformats.schemas.drawingml.x2006.main.bv;
import org.openxmlformats.schemas.drawingml.x2006.main.bz;
import org.openxmlformats.schemas.drawingml.x2006.main.ef;
import org.openxmlformats.schemas.presentationml.x2006.main.q;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFGraphicFrame extends XSLFShape implements GraphicalFrame<XSLFShape, XSLFTextParagraph> {
    private static final c LOG = null;

    static {
        LOG = b.a(XSLFGraphicFrame.class);
    }

    XSLFGraphicFrame(q r3, XSLFSheet r4) {
        super((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin"), r4);
    }

    static XSLFGraphicFrame create(q r3, XSLFSheet r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        String r0 = getUri(r5);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r0.hashCode();
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -844661481: goto L17;
            case -809269002: goto L13;
            case -603062095: goto L9;
            default: goto L20;
        };
    L20:
        switch(r1) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            default: goto L22;
        };
    L22:
        return new XSLFGraphicFrame(r5, r4);
    L24:
        return new XSLFTable(r5, r4);
    L26:
        return new XSLFDiagram(r5, r4);
    L28:
        return new XSLFObjectShape(r5, r4);
    L9:
        if (r0.equals("http://schemas.openxmlformats.org/drawingml/2006/table") == false) goto L20;
        r1 = 2;
        goto L20
    L13:
        if (r0.equals("http://schemas.openxmlformats.org/drawingml/2006/diagram") == false) goto L20;
        r1 = 1;
        goto L20
    L17:
        if (r0.equals("http://schemas.openxmlformats.org/presentationml/2006/ole") == false) goto L20;
        r1 = 0;
        goto L20
    }

    private static String getUri(q r2) {
        aj r3 = ((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin")).getGraphic();
        if (r3 != null) goto L5;
        return null;
    L5:
        ak r4 = r3.getGraphicData();
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.getUri();
    }

    public Rectangle2D getAnchor() {
        ef r12 = ((q) ZeusTransformUtils.preCheckCast(getXmlObject(), q.class, "com.obric.memorydata.plugin")).getXfrm();
        bv r0 = r12.getOff();
        double r4 = Units.toPoints(POIXMLUnits.parseLength(r0.xgetX()));
        double r6 = Units.toPoints(POIXMLUnits.parseLength(r0.xgetY()));
        bz r13 = r12.getExt();
        return new Rectangle2D.Double(r4, r6, Units.toPoints(r13.getCx()), Units.toPoints(r13.getCy()));
    }

    public double getRotation() {
        return 0.0d;
    }
}
