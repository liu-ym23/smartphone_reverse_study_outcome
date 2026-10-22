package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum XSSFWorkbookType extends Enum<XSSFWorkbookType> {
    private static final /* synthetic */ XSSFWorkbookType[] $VALUES = null;
    public static final XSSFWorkbookType XLSM = null;
    public static final XSSFWorkbookType XLSX = null;
    private final String _contentType;
    private final String _extension;

    static {
        XSSFWorkbookType r0 = new XSSFWorkbookType("XLSX", 0, XSSFRelation.WORKBOOK.getContentType(), "xlsx");
        XLSX = r0;
        XSSFWorkbookType r1 = new XSSFWorkbookType("XLSM", 1, XSSFRelation.MACROS_WORKBOOK.getContentType(), "xlsm");
        XLSM = r1;
        $VALUES = new XSSFWorkbookType[]{r0, r1};
    }

    private XSSFWorkbookType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this._contentType = r3;
        this._extension = r4;
    }

    public static XSSFWorkbookType valueOf(String r2) {
        return (XSSFWorkbookType) ZeusTransformUtils.preCheckCast(Enum.valueOf(XSSFWorkbookType.class, r2), XSSFWorkbookType.class, "com.obric.memorydata.plugin");
    }

    public static XSSFWorkbookType[] values() {
        return (XSSFWorkbookType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XSSFWorkbookType[].class, "com.obric.memorydata.plugin");
    }

    public String getContentType() {
        return this._contentType;
    }

    public String getExtension() {
        return this._extension;
    }
}
