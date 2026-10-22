package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.cd;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTextRun {
    private final XSSFTextParagraph _p;
    private final cd _r;

    XSSFTextRun(cd r3, XSSFTextParagraph r4) {
        this._r = (cd) ZeusTransformUtils.wrapperContextForParams(r3, cd.class, "com.obric.memorydata.plugin");
        this._p = r4;
    }

    public String getText() {
        return this._r.getT();
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }
}
