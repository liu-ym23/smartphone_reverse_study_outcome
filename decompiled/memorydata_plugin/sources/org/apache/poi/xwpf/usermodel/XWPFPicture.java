package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.drawingml.x2006.main.g;
import org.openxmlformats.schemas.drawingml.x2006.picture.a;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFPicture {
    private final a ctPic;
    private final String description;
    private final XWPFRun run;

    public XWPFPicture(a r3, XWPFRun r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.run = r4;
        this.ctPic = r5;
        this.description = r5.getNvPicPr().getCNvPr().getDescr();
    }

    public XWPFPictureData getPictureData() {
        g r0 = this.ctPic.getBlipFill();
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.isSetBlip() == false) goto L13;
        String r1 = r0.getBlip().getEmbed();
        POIXMLDocumentPart r3 = this.run.getParent().getPart();
        if (r3 == null) goto L13;
        POIXMLDocumentPart r4 = r3.getRelationById(r1);
        if (ZeusTransformUtils.instanceOf(r4, XWPFPictureData.class) == false) goto L13;
        return (XWPFPictureData) ZeusTransformUtils.preCheckCast(r4, XWPFPictureData.class, "com.obric.memorydata.plugin");
    }
}
