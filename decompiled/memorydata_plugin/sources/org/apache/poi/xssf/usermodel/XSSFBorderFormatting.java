package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.BorderFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.f;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFBorderFormatting implements BorderFormatting {
    f _border;
    IndexedColorMap _colorMap;

    XSSFBorderFormatting(f r3, IndexedColorMap r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this._border = r5;
        this._colorMap = r6;
    }
}
