package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.c;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFConnector extends XSSFShape {
    private final c ctShape;

    public XSSFConnector(XSSFDrawing r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.drawing = r3;
        this.ctShape = r5;
    }
}
