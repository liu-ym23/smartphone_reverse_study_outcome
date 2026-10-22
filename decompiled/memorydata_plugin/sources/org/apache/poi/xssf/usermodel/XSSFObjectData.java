package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.n;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFObjectData extends XSSFSimpleShape {
    private static final c LOG = null;

    static {
        LOG = b.a(XSSFObjectData.class);
    }

    public XSSFObjectData(XSSFDrawing r3, n r4) {
        super(r3, (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin"));
    }
}
