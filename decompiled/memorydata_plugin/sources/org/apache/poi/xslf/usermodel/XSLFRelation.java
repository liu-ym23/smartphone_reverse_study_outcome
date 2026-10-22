package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFRelation extends POIXMLRelation {
    public static final XSLFRelation CHART = null;
    public static final XSLFRelation COMMENTS = null;
    public static final XSLFRelation COMMENT_AUTHORS = null;
    public static final XSLFRelation DIAGRAM_DRAWING = null;
    public static final XSLFRelation FONT = null;
    public static final XSLFRelation HDPHOTO_WDP = null;
    public static final XSLFRelation HYPERLINK = null;
    public static final XSLFRelation IMAGES = null;
    public static final XSLFRelation IMAGE_BMP = null;
    public static final XSLFRelation IMAGE_DIB = null;
    public static final XSLFRelation IMAGE_EMF = null;
    public static final XSLFRelation IMAGE_EPS = null;
    public static final XSLFRelation IMAGE_GIF = null;
    public static final XSLFRelation IMAGE_JPEG = null;
    public static final XSLFRelation IMAGE_PICT = null;
    public static final XSLFRelation IMAGE_PNG = null;
    public static final XSLFRelation IMAGE_SVG = null;
    public static final XSLFRelation IMAGE_TIFF = null;
    public static final XSLFRelation IMAGE_WDP = null;
    public static final XSLFRelation IMAGE_WMF = null;
    public static final XSLFRelation IMAGE_WPG = null;
    public static final XSLFRelation MACRO = null;
    public static final XSLFRelation MACRO_TEMPLATE = null;
    public static final XSLFRelation MAIN = null;
    public static final XSLFRelation NOTES = null;
    public static final XSLFRelation NOTES_MASTER = null;
    public static final XSLFRelation OLE_OBJECT = null;
    public static final XSLFRelation PRESENTATIONML = null;
    public static final XSLFRelation PRESENTATIONML_TEMPLATE = null;
    public static final XSLFRelation PRESENTATION_MACRO = null;
    public static final XSLFRelation SLIDE = null;
    public static final XSLFRelation SLIDE_LAYOUT = null;
    public static final XSLFRelation SLIDE_MASTER = null;
    public static final XSLFRelation TABLE_STYLES = null;
    public static final XSLFRelation THEME = null;
    public static final XSLFRelation THEME_MANAGER = null;
    public static final XSLFRelation VML_DRAWING = null;
    public static final XSLFRelation WORKBOOK = null;
    private static final Map<String, XSLFRelation> _table = null;

    static {
        _table = new HashMap();
        MAIN = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml");
        MACRO = new XSLFRelation("application/vnd.ms-powerpoint.slideshow.macroEnabled.main+xml");
        MACRO_TEMPLATE = new XSLFRelation("application/vnd.ms-powerpoint.template.macroEnabled.main+xml");
        PRESENTATIONML = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml");
        PRESENTATIONML_TEMPLATE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.template.main+xml");
        PRESENTATION_MACRO = new XSLFRelation("application/vnd.ms-powerpoint.presentation.macroEnabled.main+xml");
        THEME_MANAGER = new XSLFRelation("application/vnd.openxmlformats-officedocument.themeManager+xml");
        NOTES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide", "/ppt/notesSlides/notesSlide#.xml", $$Lambda$9ViNIhwau8q94i6Dbk1EzwMnPQ.INSTANCE, $$Lambda$rxXdCvhp7LlVAtB20hH8wbXf8WI.INSTANCE);
        SLIDE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide", "/ppt/slides/slide#.xml", $$Lambda$YbgWdCuGm2vrSUbuHF8IylT2MZE.INSTANCE, $$Lambda$CXAYADpBOpOUtkVLJV1qznQI2FM.INSTANCE);
        SLIDE_LAYOUT = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout", "/ppt/slideLayouts/slideLayout#.xml", null, $$Lambda$C8J6nJ62vSyaRAE8sbc0w496fK0.INSTANCE);
        SLIDE_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster", "/ppt/slideMasters/slideMaster#.xml", null, $$Lambda$ZvW2LvvQSoE_eDY1WyWGjzaoXcM.INSTANCE);
        NOTES_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesMaster", "/ppt/notesMasters/notesMaster#.xml", $$Lambda$MTfTUr6M7mpGqjSxr3AYhWBMZRU.INSTANCE, $$Lambda$SrBoOlCdRsqtnRZkF81SSYZ1Ug.INSTANCE);
        COMMENTS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/ppt/comments/comment#.xml", $$Lambda$l5vYgHUtJofisjyafURD36lB0E.INSTANCE, $$Lambda$WPyopiVgtGwUYPc7pYmDd5te8c.INSTANCE);
        COMMENT_AUTHORS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/commentAuthors", "/ppt/commentAuthors.xml", $$Lambda$Ph8HKbBLlNy8oPlc0SceBd4b0U.INSTANCE, $$Lambda$fKiwMdkgJjbGPl1CIAUTriMca50.INSTANCE);
        HYPERLINK = new XSLFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null);
        THEME = new XSLFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/ppt/theme/theme#.xml", $$Lambda$lg8WTX4hYiYx5X0pGpqMZYwleeM.INSTANCE, $$Lambda$oA5eMOmY9OTQQk9w2K4ieeNuLcE.INSTANCE);
        VML_DRAWING = new XSLFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/ppt/drawings/vmlDrawing#.vml");
        WORKBOOK = new XSLFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package", "/ppt/embeddings/Microsoft_Excel_Worksheet#.xlsx", $$Lambda$Vq5Yusd9pAf1xg5QsRsMFdwAsbQ.INSTANCE, $$Lambda$RYt5IzC0A9X2JKLmj_TxUGRkXn4.INSTANCE);
        CHART = new XSLFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/ppt/charts/chart#.xml", $$Lambda$QlHZMmsAtczvzhHlVZtRi2q9feY.INSTANCE, $$Lambda$NG1y5IPPCUwAflS031BHFPU83IE.INSTANCE);
        DIAGRAM_DRAWING = new XSLFRelation("application/vnd.ms-office.drawingml.diagramDrawing+xml", "http://schemas.microsoft.com/office/2007/relationships/diagramDrawing", "/ppt/diagrams/drawing#.xml", $$Lambda$PaUCm9kb14mwiJ4cgWLO0qVnHUU.INSTANCE, $$Lambda$0q_TXjBkTmdHLquBWOhGlktOeMk.INSTANCE);
        IMAGE_EMF = new XSLFRelation(PictureData.PictureType.EMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.emf", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_WMF = new XSLFRelation(PictureData.PictureType.WMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wmf", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_PICT = new XSLFRelation(PictureData.PictureType.PICT.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.pict", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_JPEG = new XSLFRelation(PictureData.PictureType.JPEG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.jpeg", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_PNG = new XSLFRelation(PictureData.PictureType.PNG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.png", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_DIB = new XSLFRelation(PictureData.PictureType.DIB.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.dib", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_GIF = new XSLFRelation(PictureData.PictureType.GIF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.gif", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_TIFF = new XSLFRelation(PictureData.PictureType.TIFF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.tiff", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_EPS = new XSLFRelation(PictureData.PictureType.EPS.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.eps", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_BMP = new XSLFRelation(PictureData.PictureType.BMP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.bmp", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_WPG = new XSLFRelation(PictureData.PictureType.WPG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wpg", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_WDP = new XSLFRelation(PictureData.PictureType.WDP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wdp", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        HDPHOTO_WDP = new XSLFRelation(PictureData.PictureType.WDP.contentType, "http://schemas.microsoft.com/office/2007/relationships/hdphoto", "/ppt/media/hdphoto#.wdp", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGE_SVG = new XSLFRelation(PictureData.PictureType.SVG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.svg", $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        IMAGES = new XSLFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, $$Lambda$cmKUDpa2OLyxrt4Q5dRc6uQszK0.INSTANCE, $$Lambda$74h12XOL8h4UARVMii9zjAcW8.INSTANCE);
        TABLE_STYLES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableStyles", "/ppt/tableStyles.xml", $$Lambda$a49CNun9ldXc2pF73KggKW0ymFo.INSTANCE, $$Lambda$GsHJP0giTOIo1IbGcJb75aaQ7lU.INSTANCE);
        OLE_OBJECT = new XSLFRelation("application/vnd.openxmlformats-officedocument.oleObject", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject", "/ppt/embeddings/oleObject#.bin", $$Lambda$YlhNHdW3mnBOLaPI4JREaHPu4Ok.INSTANCE, $$Lambda$WNKeuy3OaE0y0_Dp4K9zAbPwylY.INSTANCE);
        FONT = new XSLFRelation("application/x-fontdata", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/font", "/ppt/fonts/font#.fntdata", $$Lambda$KVEdSL1xRJbtNaK8ayPCVu7OrDU.INSTANCE, $$Lambda$O4fnlzMwRT8PA7bg013XrbRqCQA.INSTANCE);
    }

    private XSLFRelation(String r7) {
        this(r7, null, null, null, null);
    }

    private XSLFRelation(String r7, String r8, String r9) {
        this(r7, r8, r9, null, null);
    }

    private XSLFRelation(String r10, String r11, String r12, POIXMLRelation.NoArgConstructor r13, POIXMLRelation.PackagePartConstructor r14) {
        super(r10, r11, r12, (POIXMLRelation.NoArgConstructor) ZeusTransformUtils.wrapperContextForParams(r13, POIXMLRelation.NoArgConstructor.class, "com.obric.memorydata.plugin"), (POIXMLRelation.PackagePartConstructor) ZeusTransformUtils.wrapperContextForParams(r14, POIXMLRelation.PackagePartConstructor.class, "com.obric.memorydata.plugin"), null);
        _table.put(r11, this);
    }

    public static XSLFRelation getInstance(String r2) {
        return (XSLFRelation) ZeusTransformUtils.preCheckCast(_table.get(r2), XSLFRelation.class, "com.obric.memorydata.plugin");
    }
}
