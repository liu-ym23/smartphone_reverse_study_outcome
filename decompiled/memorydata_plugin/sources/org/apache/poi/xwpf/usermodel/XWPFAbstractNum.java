package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.a;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFAbstractNum {
    private a ctAbstractNum;
    protected XWPFNumbering numbering;

    public XWPFAbstractNum() {
        this.ctAbstractNum = null;
        this.numbering = null;
    }

    public XWPFAbstractNum(a r3, XWPFNumbering r4) {
        this.ctAbstractNum = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.numbering = r4;
    }
}
