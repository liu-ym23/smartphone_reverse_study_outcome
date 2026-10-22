package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.AbstractEscherOptRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherPropertyFactory;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hslf.model.MovieShape;
import org.apache.poi.hslf.record.ExObjRefAtom;
import org.apache.poi.hslf.record.HSLFEscherClientDataRecord;
import org.apache.poi.hslf.record.InteractiveInfo;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFShapeFactory {
    private static final c LOG = null;

    /* JADX INFO: renamed from: org.apache.poi.hslf.usermodel.HSLFShapeFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$ShapeType = null;

        static {
            int[] r0 = new int[ShapeType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$ShapeType = r0;
            r0[ShapeType.TEXT_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$sl$usermodel$ShapeType[ShapeType.HOST_CONTROL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$sl$usermodel$ShapeType[ShapeType.FRAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$poi$sl$usermodel$ShapeType[ShapeType.LINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$poi$sl$usermodel$ShapeType[ShapeType.NOT_PRIMITIVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        LOG = b.a(HSLFShapeFactory.class);
    }

    public HSLFShapeFactory() {
    }

    private static HSLFShape createFrame(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        ShapeContainer r5 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin");
        InteractiveInfo r0 = (InteractiveInfo) ZeusTransformUtils.preCheckCast(getClientDataRecord(r3, RecordTypes.InteractiveInfo.typeID), InteractiveInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L16;
        if (r0.getInteractiveInfoAtom() == null) goto L16;
        byte r1 = r0.getInteractiveInfoAtom().getAction();
        if (r1 == 5) goto L14;
        if (r1 != 6) goto L16;
        return new MovieShape(r3, r5);
    L14:
        return new HSLFObjectShape(r3, r5);
    L16:
        if (((ExObjRefAtom) ZeusTransformUtils.preCheckCast(getClientDataRecord(r3, RecordTypes.ExObjRefAtom.typeID), ExObjRefAtom.class, "com.obric.memorydata.plugin")) == null) goto L19;
        return new HSLFObjectShape(r3, r5);
    L19:
        return new HSLFPictureShape(r3, r5);
    }

    private static HSLFShape createNonPrimitive(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        ShapeContainer r5 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin");
        if (HSLFShape.getEscherProperty((AbstractEscherOptRecord) ZeusTransformUtils.preCheckCast(HSLFShape.getEscherChild(r3, EscherOptRecord.RECORD_ID), AbstractEscherOptRecord.class, "com.obric.memorydata.plugin"), EscherPropertyTypes.GEOMETRY__VERTICES) != null) goto L5;
        LOG.atInfo().a("Creating AutoShape for a NotPrimitive shape");
        return new HSLFAutoShape(r3, r5);
    L5:
        return new HSLFFreeformShape(r3, r5);
    }

    public static HSLFShape createShape(EscherContainerRecord r2, ShapeContainer<HSLFShape, HSLFTextParagraph> r3) {
        ShapeContainer r4 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r3, ShapeContainer.class, "com.obric.memorydata.plugin");
        if (r2.getRecordId() != EscherContainerRecord.SPGR_CONTAINER) goto L7;
        return createShapeGroup(r2, r4);
    L7:
        return createSimpleShape(r2, r4);
    }

    public static HSLFGroupShape createShapeGroup(EscherContainerRecord r7, ShapeContainer<HSLFShape, HSLFTextParagraph> r8) {
        ShapeContainer r9 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r8, ShapeContainer.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        EscherRecord r2 = HSLFShape.getEscherChild((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r7.getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin"), EscherRecordTypes.USER_DEFINED);
        if (r2 == null) goto L14;
        Iterator<EscherProperty> r3 = new EscherPropertyFactory().createProperties(r2.serialize(), 8, r2.getInstance()).iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        EscherProperty r4 = (EscherProperty) ZeusTransformUtils.preCheckCast(r3.next(), EscherProperty.class, "com.obric.memorydata.plugin");
        if (r4.getPropertyNumber() != EscherPropertyTypes.GROUPSHAPE__TABLEPROPERTIES.propNumber) goto L6;
        if (ZeusTransformUtils.instanceOf(r4, EscherSimpleProperty.class) == false) goto L6;
        if ((((EscherSimpleProperty) ZeusTransformUtils.preCheckCast(r4, EscherSimpleProperty.class, "com.obric.memorydata.plugin")).getPropertyValue() & 1) != 1) goto L6;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        return new HSLFTable(r7, r9);
    L17:
        return new HSLFGroupShape(r7, r9);
    }

    public static HSLFShape createSimpleShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        ShapeContainer r5 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin");
        EscherSpRecord r0 = (EscherSpRecord) ZeusTransformUtils.preCheckCast(r3.getChildById(EscherSpRecord.RECORD_ID), EscherSpRecord.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L27;
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$ShapeType[ShapeType.forId(r0.getShapeType(), false).ordinal()];
        if (r1 == 1) goto L25;
        if (r1 == 2) goto L32;
        if (r1 == 3) goto L32;
        if (r1 == 4) goto L31;
        if (r1 == 5) goto L30;
        if (ZeusTransformUtils.instanceOf(r5, HSLFTable.class) == false) goto L29;
        if (((EscherTextboxRecord) ZeusTransformUtils.preCheckCast(r3.getChildById(EscherTextboxRecord.RECORD_ID), EscherTextboxRecord.class, "com.obric.memorydata.plugin")) != null) goto L28;
        LOG.atWarn().a("invalid ppt - add EscherTextboxRecord to cell");
        EscherTextboxRecord r2 = new EscherTextboxRecord();
        r2.setRecordId(EscherTextboxRecord.RECORD_ID);
        r2.setOptions(15);
        r3.addChildRecord(r2);
    L28:
        return new HSLFTableCell(r3, (HSLFTable) ZeusTransformUtils.preCheckCast(r5, HSLFTable.class, "com.obric.memorydata.plugin"));
    L29:
        return new HSLFAutoShape(r3, r5);
    L30:
        return createNonPrimitive(r3, r5);
    L31:
        return new HSLFLine(r3, r5);
    L32:
        return createFrame(r3, r5);
    L25:
        return new HSLFTextBox(r3, r5);
    L27:
        throw new RecordFormatException("Could not read EscherSpRecord as child of " + r3.getRecordName());
    }

    public static <T extends Record> T getClientDataRecord(EscherContainerRecord r6, int r7) {
        HSLFEscherClientDataRecord r8 = (HSLFEscherClientDataRecord) ZeusTransformUtils.preCheckCast(r6.getChildById(EscherClientDataRecord.RECORD_ID), HSLFEscherClientDataRecord.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L10;
        Iterator<? extends Record> r9 = r8.getHSLFChildRecords().iterator();
    L6:
        if (r9.hasNext() == false) goto L15;
        T r0 = (T) ZeusTransformUtils.preCheckCast(r9.next(), Record.class, "com.obric.memorydata.plugin");
        if (r0.getRecordType() != r7) goto L6;
        return r0;
    L15:
        return null;
    L10:
        return null;
    }
}
