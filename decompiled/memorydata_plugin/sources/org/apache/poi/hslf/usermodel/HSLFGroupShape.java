package org.apache.poi.hslf.usermodel;

import androidx.core.view.InputDeviceCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFGroupShape extends HSLFShape implements HSLFShapeContainer, GroupShape<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;

    static {
        LOG = b.a(HSLFGroupShape.class);
    }

    public HSLFGroupShape() {
        this(null, null);
        createSpContainer(false);
    }

    public HSLFGroupShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public EscherContainerRecord createSpContainer(boolean r3) {
        EscherContainerRecord r2 = super.createSpContainer(r3);
        r2.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        EscherContainerRecord r4 = new EscherContainerRecord();
        r4.setRecordId(EscherContainerRecord.SP_CONTAINER);
        r4.setOptions(15);
        EscherSpgrRecord r0 = new EscherSpgrRecord();
        r0.setOptions(1);
        r4.addChildRecord(r0);
        EscherSpRecord r1 = new EscherSpRecord();
        r1.setOptions((short) ((ShapeType.NOT_PRIMITIVE.nativeId << 4) + 2));
        r1.setFlags(InputDeviceCompat.SOURCE_DPAD);
        r4.addChildRecord(r1);
        r4.addChildRecord(new EscherClientAnchorRecord());
        r2.addChildRecord(r4);
        return r2;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public Rectangle2D getAnchor() {
        EscherClientAnchorRecord r0 = (EscherClientAnchorRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherClientAnchorRecord.RECORD_ID), EscherClientAnchorRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        LOG.atInfo().a("EscherClientAnchorRecord was not found for shape group. Searching for EscherChildAnchorRecord.");
        EscherChildAnchorRecord r14 = (EscherChildAnchorRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherChildAnchorRecord.RECORD_ID), EscherChildAnchorRecord.class, "com.obric.memorydata.plugin");
        int r1 = r14.getDx1();
        int r2 = r14.getDy1();
        int r3 = r14.getDx2();
        int r15 = r14.getDy2();
    L7:
        if (r1 != (-1)) goto L9;
        double r6 = -1.0d;
    L10:
        if (r2 != (-1)) goto L12;
        double r8 = -1.0d;
    L13:
        if (r3 != (-1)) goto L15;
        double r10 = -1.0d;
    L16:
        if (r15 != (-1)) goto L18;
        double r4 = -1.0d;
    L20:
        return new Rectangle2D.Double(r6, r8, r10, r4);
    L18:
        r4 = Units.masterToPoints(r15 - r2);
        goto L20
    L15:
        r10 = Units.masterToPoints(r3 - r1);
        goto L16
    L12:
        r8 = Units.masterToPoints(r2);
        goto L13
    L9:
        r6 = Units.masterToPoints(r1);
        goto L10
    L5:
        short r16 = r0.getCol1();
        r2 = r0.getFlag();
        r3 = r0.getDx1();
        short r5 = r0.getRow1();
        r1 = r16;
        r15 = r5;
        goto L7
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public <T extends EscherRecord> T getEscherChild(int r3) {
        return (T) ((EscherContainerRecord) ZeusTransformUtils.preCheckCast(getSpContainer().getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChildById((short) r3);
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<HSLFShape> getShapes() {
        ArrayList r0 = new ArrayList();
        Iterator<EscherRecord> r1 = getSpContainer().iterator();
        boolean r2 = true;
    L4:
        if (r1.hasNext() == false) goto L12;
        EscherRecord r3 = (EscherRecord) ZeusTransformUtils.preCheckCast(r1.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r3, EscherContainerRecord.class) == true) goto L10;
        LOG.atError().a("Shape contained non container escher record, was {}", r3.getClass().getName());
        goto L4
    L10:
        HSLFShape r4 = HSLFShapeFactory.createShape((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r3, EscherContainerRecord.class, "com.obric.memorydata.plugin"), this);
        r4.setSheet(getSheet());
        r0.add(r4);
        goto L4
    L7:
        r2 = false;
        goto L4
    L12:
        return r0;
    }

    @Override // java.lang.Iterable
    public Iterator<HSLFShape> iterator() {
        return getShapes().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<HSLFShape> spliterator() {
        return getShapes().spliterator();
    }
}
