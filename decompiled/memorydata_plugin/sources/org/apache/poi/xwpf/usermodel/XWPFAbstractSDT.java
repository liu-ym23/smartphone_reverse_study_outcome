package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.Cdo;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XWPFAbstractSDT {
    private final IBody part;
    private final String tag;
    private final String title;

    public XWPFAbstractSDT(Cdo r3, IBody r4) {
        Cdo r5 = (Cdo) ZeusTransformUtils.wrapperContextForParams(r3, Cdo.class, "com.obric.memorydata.plugin");
        IBody r6 = (IBody) ZeusTransformUtils.wrapperContextForParams(r4, IBody.class, "com.obric.memorydata.plugin");
        String r0 = "";
        if (r5 != null) goto L5;
    L7:
        String r1 = "";
    L8:
        this.title = r1;
        if (r5 != null) goto L11;
    L13:
        this.tag = r0;
        this.part = r6;
        return;
    L11:
        if (r5.isSetTag() == false) goto L13;
        r0 = r5.getTag().getVal();
        goto L13
    L5:
        if (r5.isSetAlias() == false) goto L7;
        r1 = r5.getAlias().getVal();
        goto L8
    }

    public XWPFDocument getDocument() {
        return this.part.getXWPFDocument();
    }

    public POIXMLDocumentPart getPart() {
        return this.part.getPart();
    }
}
