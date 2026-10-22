package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.az;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cq;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFHyperlinkRun extends XWPFRun {
    private az hyperlink;

    public XWPFHyperlinkRun(az r3, cq r4, IRunBody r5) {
        az r6 = (az) ZeusTransformUtils.wrapperContextForParams(r3, az.class, "com.obric.memorydata.plugin");
        super((cq) ZeusTransformUtils.wrapperContextForParams(r4, cq.class, "com.obric.memorydata.plugin"), (IRunBody) ZeusTransformUtils.wrapperContextForParams(r5, IRunBody.class, "com.obric.memorydata.plugin"));
        this.hyperlink = r6;
    }
}
