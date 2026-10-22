package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.sl.usermodel.ObjectShape;
import org.apache.poi.sl.usermodel.ShapeContainer;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFObjectShape extends HSLFPictureShape implements ObjectShape<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;

    static {
        LOG = b.a(HSLFObjectShape.class);
    }

    public HSLFObjectShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }
}
