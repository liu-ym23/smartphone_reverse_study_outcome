package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.AbstractEscherOptRecord;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hslf.record.HSLFEscherClientDataRecord;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFShape implements Shape<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;
    private EscherContainerRecord _escherContainer;
    private final ShapeContainer<HSLFShape, HSLFTextParagraph> _parent;
    private HSLFSheet _sheet;

    static {
        LOG = b.a(HSLFShape.class);
    }

    public HSLFShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        ShapeContainer<HSLFShape, HSLFTextParagraph> r5 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin");
        this._escherContainer = r3;
        this._parent = r5;
    }

    public static <T extends EscherRecord> T getEscherChild(EscherContainerRecord r0, int r1) {
        return (T) r0.getChildById((short) r1);
    }

    public static <T extends EscherRecord> T getEscherChild(EscherContainerRecord r0, EscherRecordTypes r1) {
        return (T) getEscherChild(r0, r1.typeID);
    }

    public static <T extends EscherProperty> T getEscherProperty(AbstractEscherOptRecord r0, EscherPropertyTypes r1) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return (T) r0.lookup(r1);
    }

    public static void setEscherProperty(AbstractEscherOptRecord r1, EscherPropertyTypes r2, int r3) {
        setEscherProperty(r1, r2, false, r3);
    }

    public static void setEscherProperty(AbstractEscherOptRecord r4, EscherPropertyTypes r5, boolean r6, int r7) {
        Iterator<EscherProperty> r0 = r4.getEscherProperties().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((EscherProperty) ZeusTransformUtils.preCheckCast(r0.next(), EscherProperty.class, "com.obric.memorydata.plugin")).getPropertyNumber() != r5.propNumber) goto L4;
        r0.remove();
    L9:
        if (r7 == (-1)) goto L15;
        r4.addEscherProperty(new EscherSimpleProperty(r5, false, r6, r7));
        r4.sortProperties();
        return;
    }

    public EscherContainerRecord createSpContainer(boolean r2) {
        if (this._escherContainer != null) goto L6;
        EscherContainerRecord r3 = new EscherContainerRecord();
        this._escherContainer = r3;
        r3.setOptions(15);
    L6:
        return this._escherContainer;
    }

    public Rectangle2D getAnchor() {
        int r0 = ((EscherSpRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherSpRecord.RECORD_ID), EscherSpRecord.class, "com.obric.memorydata.plugin")).getFlags();
        EscherChildAnchorRecord r1 = (EscherChildAnchorRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherChildAnchorRecord.RECORD_ID), EscherChildAnchorRecord.class, "com.obric.memorydata.plugin");
        if ((r0 & 2) == 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        if (r1 == null) goto L9;
        int r14 = r1.getDx1();
        int r3 = r1.getDy1();
        int r4 = r1.getDx2();
        int r5 = r1.getDy2();
    L15:
        if (r14 != (-1)) goto L17;
        double r6 = -1.0d;
    L18:
        if (r3 != (-1)) goto L20;
        double r8 = -1.0d;
    L21:
        if (r4 != (-1)) goto L23;
        double r10 = -1.0d;
    L24:
        if (r5 != (-1)) goto L26;
        double r7 = -1.0d;
    L28:
        return new Rectangle2D.Double(r6, r8, r10, r7);
    L26:
        r7 = Units.masterToPoints(r5 - r3);
        goto L28
    L23:
        r10 = Units.masterToPoints(r4 - r14);
        goto L24
    L20:
        r8 = Units.masterToPoints(r3);
        goto L21
    L17:
        r6 = Units.masterToPoints(r14);
    L9:
        if (r2 == false) goto L11;
        LOG.atWarn().a("EscherSpRecord.FLAG_CHILD is set but EscherChildAnchorRecord was not found");
    L11:
        EscherClientAnchorRecord r15 = (EscherClientAnchorRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherClientAnchorRecord.RECORD_ID), EscherClientAnchorRecord.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L30;
        short r9 = r15.getCol1();
        short r11 = r15.getFlag();
        r4 = r15.getDx1();
        r5 = r15.getRow1();
        r14 = r9;
        r3 = r11;
        goto L15
    L30:
        throw new RecordFormatException("Could not read record 'CLIENT_ANCHOR' with record-id: " + EscherClientAnchorRecord.RECORD_ID);
    L5:
        r2 = false;
        goto L6
    }

    public HSLFEscherClientDataRecord getClientData(boolean r4) {
        HSLFEscherClientDataRecord r0 = (HSLFEscherClientDataRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherClientDataRecord.RECORD_ID), HSLFEscherClientDataRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        if (r4 == false) goto L8;
        HSLFEscherClientDataRecord r1 = new HSLFEscherClientDataRecord();
        r1.setOptions(15);
        r1.setRecordId(EscherClientDataRecord.RECORD_ID);
        getSpContainer().addChildBefore(r1, EscherTextboxRecord.RECORD_ID);
        return r1;
    L8:
        return r0;
    L7:
        return r0;
    }

    public <T extends EscherRecord> T getEscherChild(int r1) {
        return (T) this._escherContainer.getChildById((short) r1);
    }

    public <T extends EscherRecord> T getEscherChild(EscherRecordTypes r1) {
        return (T) getEscherChild(r1.typeID);
    }

    public AbstractEscherOptRecord getEscherOptRecord() {
        AbstractEscherOptRecord r0 = (AbstractEscherOptRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherRecordTypes.OPT), AbstractEscherOptRecord.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (AbstractEscherOptRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherRecordTypes.USER_DEFINED), AbstractEscherOptRecord.class, "com.obric.memorydata.plugin");
    }

    public HSLFSheet getSheet() {
        return this._sheet;
    }

    public EscherContainerRecord getSpContainer() {
        return this._escherContainer;
    }

    public void setEscherProperty(EscherPropertyTypes r1, int r2) {
        setEscherProperty(getEscherOptRecord(), r1, r2);
    }

    public void setShapeType(ShapeType r3) {
        EscherSpRecord r2 = (EscherSpRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherSpRecord.RECORD_ID), EscherSpRecord.class, "com.obric.memorydata.plugin");
        r2.setShapeType((short) r3.nativeId);
        r2.setVersion(2);
    }

    public void setSheet(HSLFSheet r1) {
        this._sheet = r1;
    }
}
