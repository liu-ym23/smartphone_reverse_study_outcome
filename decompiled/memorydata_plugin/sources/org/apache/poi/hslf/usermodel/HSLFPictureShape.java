package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.a;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.ShapeContainer;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFPictureShape extends HSLFSimpleShape implements PictureShape<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;

    static {
        LOG = b.a(HSLFPictureShape.class);
    }

    public HSLFPictureShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    public EscherBSERecord getEscherBSERecord() {
        EscherContainerRecord r0 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(HSLFShape.getEscherChild(getSheet().getSlideShow().getDocumentRecord().getPPDrawingGroup().getDggContainer(), EscherContainerRecord.BSTORE_CONTAINER), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        a r3 = LOG.atDebug();
        String r1 = "EscherContainerRecord.BSTORE_CONTAINER was not found ";
    L5:
        r3.a(r1);
        return null;
    L7:
        int r4 = getPictureIndex();
        if (r4 != 0) goto L11;
        r3 = LOG.atDebug();
        r1 = "picture index was not found, returning ";
        goto L5
    L11:
        return (EscherBSERecord) ZeusTransformUtils.preCheckCast(r0.getChild(r4 - 1), EscherBSERecord.class, "com.obric.memorydata.plugin");
    }

    public HSLFPictureData getPictureData() {
        List<HSLFPictureData> r0 = getSheet().getSlideShow().getPictureData();
        EscherBSERecord r4 = getEscherBSERecord();
        if (r4 != null) goto L5;
        LOG.atError().a("no reference to picture data found ");
        return null;
    L5:
        Iterator<HSLFPictureData> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        HSLFPictureData r2 = (HSLFPictureData) ZeusTransformUtils.preCheckCast(r1.next(), HSLFPictureData.class, "com.obric.memorydata.plugin");
        if (r2.bse != r4) goto L7;
        return r2;
    L11:
        LOG.atError().a("no picture found for our BSE offset {}", v.a(r4.getOffset()));
        return null;
    }

    public int getPictureIndex() {
        EscherSimpleProperty r2 = (EscherSimpleProperty) ZeusTransformUtils.preCheckCast(getEscherProperty(getEscherOptRecord(), EscherPropertyTypes.BLIP__BLIPTODISPLAY), EscherSimpleProperty.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getPropertyValue();
    }
}
