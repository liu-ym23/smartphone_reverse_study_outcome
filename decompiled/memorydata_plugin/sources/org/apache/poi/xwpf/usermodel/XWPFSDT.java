package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dp;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFSDT extends XWPFAbstractSDT implements IBodyElement, IRunBody, IRunElement {
    private final ISDTContent content;

    public XWPFSDT(dc r3, IBody r4) {
        dc r5 = (dc) ZeusTransformUtils.wrapperContextForParams(r3, dc.class, "com.obric.memorydata.plugin");
        IBody r6 = (IBody) ZeusTransformUtils.wrapperContextForParams(r4, IBody.class, "com.obric.memorydata.plugin");
        super(r5.getSdtPr(), r6);
        this.content = new XWPFSDTContent(r5.getSdtContent(), r6, this);
    }

    public XWPFSDT(dp r3, IBody r4) {
        dp r5 = (dp) ZeusTransformUtils.wrapperContextForParams(r3, dp.class, "com.obric.memorydata.plugin");
        IBody r6 = (IBody) ZeusTransformUtils.wrapperContextForParams(r4, IBody.class, "com.obric.memorydata.plugin");
        super(r5.getSdtPr(), r6);
        this.content = new XWPFSDTContent(r5.getSdtContent(), r6, this);
    }

    public ISDTContent getContent() {
        return this.content;
    }
}
