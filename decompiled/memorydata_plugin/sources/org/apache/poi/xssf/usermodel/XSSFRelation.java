package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFRelation extends POIXMLRelation {
    public static final XSSFRelation ACTIVEX_BINS = null;
    public static final XSSFRelation ACTIVEX_CONTROLS = null;
    public static final XSSFRelation CALC_CHAIN = null;
    public static final XSSFRelation CHART = null;
    public static final XSSFRelation CHARTSHEET = null;
    public static final XSSFRelation CTRL_PROP_RECORDS = null;
    public static final XSSFRelation CUSTOM_PROPERTIES = null;
    public static final XSSFRelation CUSTOM_XML_MAPPINGS = null;
    public static final XSSFRelation DIALOG_SHEET_BIN = null;
    public static final XSSFRelation DRAWINGS = null;
    public static final XSSFRelation EXTERNAL_LINKS = null;
    public static final XSSFRelation HDPHOTO_WDP = null;
    public static final XSSFRelation IMAGES = null;
    public static final XSSFRelation IMAGE_BMP = null;
    public static final XSSFRelation IMAGE_DIB = null;
    public static final XSSFRelation IMAGE_EMF = null;
    public static final XSSFRelation IMAGE_EPS = null;
    public static final XSSFRelation IMAGE_GIF = null;
    public static final XSSFRelation IMAGE_JPEG = null;
    public static final XSSFRelation IMAGE_PICT = null;
    public static final XSSFRelation IMAGE_PNG = null;
    public static final XSSFRelation IMAGE_TIFF = null;
    public static final XSSFRelation IMAGE_WMF = null;
    public static final XSSFRelation IMAGE_WPG = null;
    public static final XSSFRelation INTL_MACRO_SHEET_BIN = null;
    public static final XSSFRelation MACROS_WORKBOOK = null;
    public static final XSSFRelation MACRO_ADDIN_WORKBOOK = null;
    public static final XSSFRelation MACRO_SHEET_BIN = null;
    public static final XSSFRelation MACRO_TEMPLATE_WORKBOOK = null;
    public static final XSSFRelation OLEEMBEDDINGS = null;
    public static final XSSFRelation PACKEMBEDDINGS = null;
    public static final XSSFRelation PIVOT_CACHE_DEFINITION = null;
    public static final XSSFRelation PIVOT_CACHE_RECORDS = null;
    public static final XSSFRelation PIVOT_TABLE = null;
    public static final XSSFRelation PRINTER_SETTINGS = null;
    public static final XSSFRelation SHARED_STRINGS = null;
    public static final XSSFRelation SHEET_COMMENTS = null;
    public static final XSSFRelation SHEET_HYPERLINKS = null;
    public static final XSSFRelation SINGLE_XML_CELLS = null;
    public static final XSSFRelation STYLES = null;
    public static final XSSFRelation TABLE = null;
    public static final XSSFRelation TEMPLATE_WORKBOOK = null;
    public static final XSSFRelation THEME = null;
    public static final XSSFRelation VBA_MACROS = null;
    public static final XSSFRelation VML_DRAWINGS = null;
    public static final XSSFRelation WORKBOOK = null;
    public static final XSSFRelation WORKSHEET = null;
    public static final XSSFRelation XLSB_BINARY_WORKBOOK = null;
    private static final Map<String, XSSFRelation> _table = null;

    static {
        _table = new HashMap();
        WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/workbook", "/xl/workbook.xml");
        MACROS_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        MACRO_TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.template.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        MACRO_ADDIN_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.addin.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        XLSB_BINARY_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.binary.macroEnabled.main", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.bin");
        WORKSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet", "/xl/worksheets/sheet#.xml", $$Lambda$Q_xjVnJlhiFPSQwNSoW4gplqnI8.INSTANCE, $$Lambda$uoU7SQ_2EgDFnN8A00Vag6L8cJc.INSTANCE);
        CHARTSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chartsheet", "/xl/chartsheets/sheet#.xml", null, $$Lambda$EUXLOMYbTKzm3fJPus6tG95ZIU.INSTANCE);
        SHARED_STRINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings", "/xl/sharedStrings.xml", $$Lambda$BG9PrEfaqcEzbazQaSxbyqccA.INSTANCE, $$Lambda$zL3snIgNTItOezRohOZnPJP1ciI.INSTANCE);
        STYLES = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/xl/styles.xml", $$Lambda$5lRr1gTYtU3Gzzpbszay5sIPg5Q.INSTANCE, $$Lambda$Fp_HvyBbYIhwC68iHDVaM3jQONc.INSTANCE);
        DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawing+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/drawing", "/xl/drawings/drawing#.xml", $$Lambda$68i0keTQupck7WzS16dGdi0_4_s.INSTANCE, $$Lambda$bULCJbFOdgT6OOpwbNToxSXUI.INSTANCE);
        VML_DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/xl/drawings/vmlDrawing#.vml", $$Lambda$LedToa9ihF5O6YRkP0RDTl9VnxY.INSTANCE, $$Lambda$BR9jydVqugs00x4kqMlbt7Qs3GM.INSTANCE);
        CHART = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/xl/charts/chart#.xml", $$Lambda$obl6Yy8NwspXuPhFo1P6jmb2ek.INSTANCE, $$Lambda$ZcMfKhxFgnZCddI24wgv16BDXTE.INSTANCE);
        CUSTOM_XML_MAPPINGS = new XSSFRelation("application/xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/xmlMaps", "/xl/xmlMaps.xml", $$Lambda$baHx8jU9CzX_GA6OyUnRPNrFL5Q.INSTANCE, $$Lambda$ynP0DLmz7JNmZahHoShgkiOcGco.INSTANCE);
        SINGLE_XML_CELLS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableSingleCells", "/xl/tables/tableSingleCells#.xml", $$Lambda$I434E6xhHxt0LmiSFvAqzB28POY.INSTANCE, $$Lambda$EFt6O8EzopI5y39xpCLB2azv88.INSTANCE);
        TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/table", "/xl/tables/table#.xml", $$Lambda$V3l39A0E5tYdVj8V6YwtfVYWvRc.INSTANCE, $$Lambda$ciftsfO19e1UqAFW62Ll8uevsQ.INSTANCE);
        IMAGES = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_EMF = new XSSFRelation(PictureData.PictureType.EMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.emf", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_WMF = new XSSFRelation(PictureData.PictureType.WMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wmf", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_PICT = new XSSFRelation(PictureData.PictureType.PICT.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.pict", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_JPEG = new XSSFRelation(PictureData.PictureType.JPEG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.jpeg", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_PNG = new XSSFRelation(PictureData.PictureType.PNG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.png", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_DIB = new XSSFRelation(PictureData.PictureType.DIB.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.dib", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_GIF = new XSSFRelation(PictureData.PictureType.GIF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.gif", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_TIFF = new XSSFRelation(PictureData.PictureType.TIFF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.tiff", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_EPS = new XSSFRelation(PictureData.PictureType.EPS.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.eps", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_BMP = new XSSFRelation(PictureData.PictureType.BMP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.bmp", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        IMAGE_WPG = new XSSFRelation(PictureData.PictureType.WPG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wpg", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        HDPHOTO_WDP = new XSSFRelation(PictureData.PictureType.WDP.contentType, "http://schemas.microsoft.com/office/2007/relationships/hdphoto", "/xl/media/hdphoto#.wdp", $$Lambda$SqyMU6vtwfWbrX31UuEfUfy2M.INSTANCE, $$Lambda$pvRYTDakuuUrrsQIPx2uLpQWqAU.INSTANCE);
        SHEET_COMMENTS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/xl/comments#.xml", $$Lambda$Gf52AIKz7cy9kf_6U1dMHjXkEL8.INSTANCE, $$Lambda$65hS0p5F2qHitxUxAe853ZxYkxM.INSTANCE);
        SHEET_HYPERLINKS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null);
        OLEEMBEDDINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.oleObject", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject", "/xl/embeddings/oleObject#.bin");
        PACKEMBEDDINGS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package", null);
        VBA_MACROS = new XSSFRelation("application/vnd.ms-office.vbaProject", "http://schemas.microsoft.com/office/2006/relationships/vbaProject", "/xl/vbaProject.bin", $$Lambda$AZgVCkEOOq9wv5uj0_f7mlu186M.INSTANCE, $$Lambda$YKBIhbSqAmgQGy8VfkSXZVa0loE.INSTANCE);
        ACTIVEX_CONTROLS = new XSSFRelation("application/vnd.ms-office.activeX+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/control", "/xl/activeX/activeX#.xml");
        ACTIVEX_BINS = new XSSFRelation("application/vnd.ms-office.activeX", "http://schemas.microsoft.com/office/2006/relationships/activeXControlBinary", "/xl/activeX/activeX#.bin");
        MACRO_SHEET_BIN = new XSSFRelation(null, "http://schemas.microsoft.com/office/2006/relationships/xlMacrosheet", "/xl/macroSheets/sheet#.bin");
        INTL_MACRO_SHEET_BIN = new XSSFRelation(null, "http://schemas.microsoft.com/office/2006/relationships/xlIntlMacrosheet", "/xl/macroSheets/sheet#.bin");
        DIALOG_SHEET_BIN = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/dialogsheet", "/xl/dialogSheets/sheet#.bin");
        THEME = new XSSFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/xl/theme/theme#.xml", $$Lambda$g7oLt2zDHlF8n97F2coUg6Qt4os.INSTANCE, $$Lambda$aHAEGSKKrWHqrDl7wEbry96rXeU.INSTANCE);
        CALC_CHAIN = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/calcChain", "/xl/calcChain.xml", $$Lambda$8QFk7C_Esz8m7eZ2YOHBiqmgQ.INSTANCE, $$Lambda$DUi3X67Oap4jw2xFVAiwIyH6unw.INSTANCE);
        EXTERNAL_LINKS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLink", "/xl/externalLinks/externalLink#.xml", $$Lambda$mMgqdkFcZrTc7JgvVMO4W7ECY.INSTANCE, $$Lambda$6ya4IJjnGbyRXns7gEj90Gr3Q0A.INSTANCE);
        PRINTER_SETTINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.printerSettings", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/printerSettings", "/xl/printerSettings/printerSettings#.bin");
        PIVOT_TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotTable", "/xl/pivotTables/pivotTable#.xml", $$Lambda$ViXKN0d_VW4ifotlBPqFe2ZQPc.INSTANCE, $$Lambda$BHox81I2aBKWK8r4gOXvZoQQgk.INSTANCE);
        PIVOT_CACHE_DEFINITION = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheDefinition", "/xl/pivotCache/pivotCacheDefinition#.xml", $$Lambda$6bGLDE3sXAR4kIU1mJtn9rAbTFs.INSTANCE, $$Lambda$j2oOLjTvufsyH0BpEFsQXZ9PUpQ.INSTANCE);
        PIVOT_CACHE_RECORDS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheRecords", "/xl/pivotCache/pivotCacheRecords#.xml", $$Lambda$U7gV12g1MloAAEbw10a8FnwpfQ.INSTANCE, $$Lambda$dALB5lpriH_jU_ULOjMkOHg5U1o.INSTANCE);
        CTRL_PROP_RECORDS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/ctrlProp", "/xl/ctrlProps/ctrlProp#.xml");
        CUSTOM_PROPERTIES = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.customProperty", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/customProperty", "/xl/customProperty#.bin");
    }

    private XSSFRelation(String r7, String r8, String r9) {
        this(r7, r8, r9, null, null);
    }

    private XSSFRelation(String r10, String r11, String r12, POIXMLRelation.NoArgConstructor r13, POIXMLRelation.PackagePartConstructor r14) {
        super(r10, r11, r12, (POIXMLRelation.NoArgConstructor) ZeusTransformUtils.wrapperContextForParams(r13, POIXMLRelation.NoArgConstructor.class, "com.obric.memorydata.plugin"), (POIXMLRelation.PackagePartConstructor) ZeusTransformUtils.wrapperContextForParams(r14, POIXMLRelation.PackagePartConstructor.class, "com.obric.memorydata.plugin"), null);
        _table.put(r11, this);
    }

    public static XSSFRelation getInstance(String r2) {
        return (XSSFRelation) ZeusTransformUtils.preCheckCast(_table.get(r2), XSSFRelation.class, "com.obric.memorydata.plugin");
    }
}
