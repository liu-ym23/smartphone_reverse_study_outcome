package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dx;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFFieldRun extends XWPFRun {
    private dx field;

    public XWPFFieldRun(dx r3, cq r4, IRunBody r5) {
        dx r6 = (dx) ZeusTransformUtils.wrapperContextForParams(r3, dx.class, "com.obric.memorydata.plugin");
        super((cq) ZeusTransformUtils.wrapperContextForParams(r4, cq.class, "com.obric.memorydata.plugin"), (IRunBody) ZeusTransformUtils.wrapperContextForParams(r5, IRunBody.class, "com.obric.memorydata.plugin"));
        this.field = r6;
    }
}
