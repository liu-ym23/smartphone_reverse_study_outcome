package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bf;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFLatentStyles {
    private bf latentStyles;
    protected XWPFStyles styles;

    public XWPFLatentStyles() {
    }

    public XWPFLatentStyles(bf r3, XWPFStyles r4) {
        this.latentStyles = (bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.memorydata.plugin");
        this.styles = r4;
    }
}
