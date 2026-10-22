package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ec;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFStyle {
    private ec ctStyle;
    protected XWPFStyles styles;

    public XWPFStyle(ec r3, XWPFStyles r4) {
        this.ctStyle = (ec) ZeusTransformUtils.wrapperContextForParams(r3, ec.class, "com.obric.memorydata.plugin");
        this.styles = r4;
    }

    public STStyleType.Enum getType() {
        return this.ctStyle.getType();
    }
}
