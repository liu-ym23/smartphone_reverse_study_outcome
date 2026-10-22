package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dd;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFSDTCell extends XWPFAbstractSDT implements ICell {
    private final XWPFSDTContentCell cellContent;

    public XWPFSDTCell(dd r3, XWPFTableRow r4, IBody r5) {
        dd r6 = (dd) ZeusTransformUtils.wrapperContextForParams(r3, dd.class, "com.obric.memorydata.plugin");
        IBody r7 = (IBody) ZeusTransformUtils.wrapperContextForParams(r5, IBody.class, "com.obric.memorydata.plugin");
        super(r6.getSdtPr(), r7);
        this.cellContent = new XWPFSDTContentCell(r6.getSdtContent(), r4, r7);
    }

    public ISDTContent getContent() {
        return this.cellContent;
    }
}
