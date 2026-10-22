package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.by;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFFontFormatting implements FontFormatting {
    private IndexedColorMap _colorMap;
    private by _font;

    XSSFFontFormatting(by r3, IndexedColorMap r4) {
        by r5 = (by) ZeusTransformUtils.wrapperContextForParams(r3, by.class, "com.obric.memorydata.plugin");
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this._font = r5;
        this._colorMap = r6;
    }
}
