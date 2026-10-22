package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.AbstractEscherOptRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.sl.usermodel.Line;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFLine extends HSLFTextShape implements Line<HSLFShape, HSLFTextParagraph> {
    public HSLFLine() {
        this(null);
    }

    public HSLFLine(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    public HSLFLine(ShapeContainer<HSLFShape, HSLFTextParagraph> r3) {
        ShapeContainer r4 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r3, ShapeContainer.class, "com.obric.memorydata.plugin");
        super(null, r4);
        createSpContainer(ZeusTransformUtils.instanceOf(r4, HSLFGroupShape.class));
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSimpleShape, org.apache.poi.hslf.usermodel.HSLFShape
    public EscherContainerRecord createSpContainer(boolean r4) {
        EscherContainerRecord r5 = super.createSpContainer(r4);
        setShapeType(ShapeType.LINE);
        ((EscherSpRecord) ZeusTransformUtils.preCheckCast(r5.getChildById(EscherSpRecord.RECORD_ID), EscherSpRecord.class, "com.obric.memorydata.plugin")).setOptions((short) ((ShapeType.LINE.nativeId << 4) | 2));
        AbstractEscherOptRecord r3 = getEscherOptRecord();
        setEscherProperty(r3, EscherPropertyTypes.GEOMETRY__SHAPEPATH, 4);
        setEscherProperty(r3, EscherPropertyTypes.GEOMETRY__FILLOK, 65536);
        setEscherProperty(r3, EscherPropertyTypes.FILL__NOFILLHITTEST, 1048576);
        setEscherProperty(r3, EscherPropertyTypes.LINESTYLE__COLOR, 134217729);
        setEscherProperty(r3, EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 655368);
        setEscherProperty(r3, EscherPropertyTypes.SHADOWSTYLE__COLOR, 134217730);
        return r5;
    }
}
