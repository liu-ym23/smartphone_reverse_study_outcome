package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dl;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPivotCache extends POIXMLDocumentPart {
    private dl ctPivotCache;

    public XSSFPivotCache() {
        this.ctPivotCache = (dl) ZeusTransformUtils.preCheckCast(dl.f19589a.newInstance(), dl.class, "com.obric.memorydata.plugin");
    }
}
