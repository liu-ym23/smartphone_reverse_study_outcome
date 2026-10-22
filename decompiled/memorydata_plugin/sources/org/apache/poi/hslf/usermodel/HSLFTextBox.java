package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.TextBox;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFTextBox extends HSLFTextShape implements TextBox<HSLFShape, HSLFTextParagraph> {
    public HSLFTextBox() {
        this(null);
    }

    public HSLFTextBox(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    public HSLFTextBox(ShapeContainer<HSLFShape, HSLFTextParagraph> r3) {
        super((ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r3, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSimpleShape, org.apache.poi.hslf.usermodel.HSLFShape
    public EscherContainerRecord createSpContainer(boolean r3) {
        EscherContainerRecord r4 = super.createSpContainer(r3);
        setShapeType(ShapeType.TEXT_BOX);
        setEscherProperty(EscherPropertyTypes.FILL__FILLCOLOR, 134217732);
        setEscherProperty(EscherPropertyTypes.FILL__FILLBACKCOLOR, 134217728);
        setEscherProperty(EscherPropertyTypes.FILL__NOFILLHITTEST, 1048576);
        setEscherProperty(EscherPropertyTypes.LINESTYLE__COLOR, 134217729);
        setEscherProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524288);
        setEscherProperty(EscherPropertyTypes.SHADOWSTYLE__COLOR, 134217730);
        getTextParagraphs();
        return r4;
    }
}
