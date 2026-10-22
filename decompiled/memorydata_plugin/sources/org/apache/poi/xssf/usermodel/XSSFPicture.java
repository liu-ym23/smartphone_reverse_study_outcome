package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.l;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFPicture extends XSSFShape {
    private static final c LOG = null;
    private final l ctPicture;

    static {
        LOG = b.a(XSSFPicture.class);
    }

    public XSSFPicture(XSSFDrawing r3, l r4) {
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.memorydata.plugin");
        this.drawing = r3;
        this.ctPicture = r5;
    }

    public XSSFPictureData getPictureData() {
        String r0 = this.ctPicture.getBlipFill().getBlip().getEmbed();
        return (XSSFPictureData) ZeusTransformUtils.preCheckCast(getDrawing().getRelationById(r0), XSSFPictureData.class, "com.obric.memorydata.plugin");
    }
}
