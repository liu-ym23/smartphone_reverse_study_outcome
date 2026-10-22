package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ap;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFEndnote extends XWPFAbstractFootnoteEndnote {
    public XWPFEndnote() {
    }

    public XWPFEndnote(ap r3, XWPFAbstractFootnotesEndnotes r4) {
        super((ap) ZeusTransformUtils.wrapperContextForParams(r3, ap.class, "com.obric.memorydata.plugin"), r4);
    }
}
