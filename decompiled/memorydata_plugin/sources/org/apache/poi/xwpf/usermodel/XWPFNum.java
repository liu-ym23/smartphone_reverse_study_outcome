package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bn;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFNum {
    private bn ctNum;
    protected XWPFNumbering numbering;

    public XWPFNum() {
        this.ctNum = null;
        this.numbering = null;
    }

    public XWPFNum(bn r3, XWPFNumbering r4) {
        this.ctNum = (bn) ZeusTransformUtils.wrapperContextForParams(r3, bn.class, "com.obric.memorydata.plugin");
        this.numbering = r4;
    }
}
