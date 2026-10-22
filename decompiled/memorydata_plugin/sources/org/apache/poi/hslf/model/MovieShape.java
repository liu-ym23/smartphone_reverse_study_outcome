package org.apache.poi.hslf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.usermodel.HSLFPictureShape;
import org.apache.poi.hslf.usermodel.HSLFShape;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.sl.usermodel.ShapeContainer;

/* JADX INFO: loaded from: classes7.dex */
public final class MovieShape extends HSLFPictureShape {
    public MovieShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }
}
