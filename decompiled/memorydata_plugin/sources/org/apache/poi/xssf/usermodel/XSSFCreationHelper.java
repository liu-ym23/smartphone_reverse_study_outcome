package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFCreationHelper {
    private final Map<String, Workbook> referencedWorkbooks;
    private final XSSFWorkbook workbook;

    public XSSFCreationHelper(XSSFWorkbook r1) {
        this.workbook = r1;
        this.referencedWorkbooks = new HashMap();
    }

    public Map<String, Workbook> getReferencedWorkbooks() {
        return this.referencedWorkbooks;
    }
}
