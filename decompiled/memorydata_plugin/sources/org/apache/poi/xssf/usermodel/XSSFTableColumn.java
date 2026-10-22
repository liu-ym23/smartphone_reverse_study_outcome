package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ex;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTableColumn {
    private final ex ctTableColumn;
    private final XSSFTable table;

    public XSSFTableColumn(XSSFTable r3, ex r4) {
        ex r5 = (ex) ZeusTransformUtils.wrapperContextForParams(r4, ex.class, "com.obric.memorydata.plugin");
        this.table = r3;
        this.ctTableColumn = r5;
    }

    public String getName() {
        return this.ctTableColumn.getName();
    }
}
