package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bw;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPatternFormatting implements PatternFormatting {
    IndexedColorMap _colorMap;
    bw _fill;

    XSSFPatternFormatting(bw r3, IndexedColorMap r4) {
        bw r5 = (bw) ZeusTransformUtils.wrapperContextForParams(r3, bw.class, "com.obric.memorydata.plugin");
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this._fill = r5;
        this._colorMap = r6;
    }
}
