package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.xssf.model.MapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cr;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFMap {
    private cr ctMap;
    private MapInfo mapInfo;

    public XSSFMap(cr r3, MapInfo r4) {
        this.ctMap = (cr) ZeusTransformUtils.wrapperContextForParams(r3, cr.class, "com.obric.memorydata.plugin");
        this.mapInfo = r4;
    }
}
