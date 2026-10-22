package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.an;
import org.openxmlformats.schemas.drawingml.x2006.main.ao;
import org.openxmlformats.schemas.drawingml.x2006.main.bv;
import org.openxmlformats.schemas.drawingml.x2006.main.bz;
import org.openxmlformats.schemas.presentationml.x2006.main.s;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFGroupShape extends XSLFShape implements GroupShape<XSLFShape, XSLFTextParagraph>, XSLFShapeContainer {
    private static final c LOG = null;
    private final an _grpSpPr;
    private final List<XSLFShape> _shapes;

    static {
        LOG = b.a(XSLFGroupShape.class);
    }

    public XSLFGroupShape(s r3, XSLFSheet r4) {
        s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        super(r5, r4);
        this._shapes = XSLFSheet.buildShapes(r5, this);
        this._grpSpPr = r5.getGrpSpPr();
    }

    private ao getSafeXfrm() {
        ao r0 = getXfrm();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getGrpSpPr().addNewXfrm();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public an getGrpSpPr() {
        return this._grpSpPr;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        return this._shapes;
    }

    public ao getXfrm() {
        return getGrpSpPr().getXfrm();
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return this._shapes.iterator();
    }

    public void setAnchor(Rectangle2D r6) {
        Rectangle2D r7 = (Rectangle2D) ZeusTransformUtils.wrapperContextForParams(r6, Rectangle2D.class, "com.obric.memorydata.plugin");
        ao r5 = getSafeXfrm();
        if (r5.isSetOff() == false) goto L5;
        bv r0 = r5.getOff();
    L6:
        long r1 = Units.toEMU(r7.getX());
        long r3 = Units.toEMU(r7.getY());
        r0.setX(Long.valueOf(r1));
        r0.setY(Long.valueOf(r3));
        if (r5.isSetExt() == false) goto L9;
        bz r8 = r5.getExt();
    L10:
        long r2 = Units.toEMU(r7.getWidth());
        long r4 = Units.toEMU(r7.getHeight());
        r8.setCx(r2);
        r8.setCy(r4);
        return;
    L9:
        r8 = r5.addNewExt();
        goto L10
    L5:
        r0 = r5.addNewOff();
        goto L6
    }

    public void setInteriorAnchor(Rectangle2D r6) {
        Rectangle2D r7 = (Rectangle2D) ZeusTransformUtils.wrapperContextForParams(r6, Rectangle2D.class, "com.obric.memorydata.plugin");
        ao r5 = getSafeXfrm();
        if (r5.isSetChOff() == false) goto L5;
        bv r0 = r5.getChOff();
    L6:
        long r1 = Units.toEMU(r7.getX());
        long r3 = Units.toEMU(r7.getY());
        r0.setX(Long.valueOf(r1));
        r0.setY(Long.valueOf(r3));
        if (r5.isSetChExt() == false) goto L9;
        bz r8 = r5.getChExt();
    L10:
        long r2 = Units.toEMU(r7.getWidth());
        long r4 = Units.toEMU(r7.getHeight());
        r8.setCx(r2);
        r8.setCy(r4);
        return;
    L9:
        r8 = r5.addNewChExt();
        goto L10
    L5:
        r0 = r5.addNewChOff();
        goto L6
    }

    public void setRotation(double r3) {
        getSafeXfrm().setRot((int) (r3 * 60000.0d));
    }
}
