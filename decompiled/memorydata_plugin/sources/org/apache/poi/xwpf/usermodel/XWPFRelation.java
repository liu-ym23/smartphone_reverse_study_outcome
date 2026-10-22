package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLRelation;

/* JADX INFO: loaded from: classes7.dex */
public final class XWPFRelation extends POIXMLRelation {
    public static final XWPFRelation CHART = null;
    public static final XWPFRelation COMMENT = null;
    public static final XWPFRelation DOCUMENT = null;
    public static final XWPFRelation ENDNOTE = null;
    public static final XWPFRelation FONT_TABLE = null;
    public static final XWPFRelation FOOTER = null;
    public static final XWPFRelation FOOTNOTE = null;
    public static final XWPFRelation GLOSSARY_DOCUMENT = null;
    public static final XWPFRelation HDPHOTO_WDP = null;
    public static final XWPFRelation HEADER = null;
    public static final XWPFRelation HYPERLINK = null;
    public static final XWPFRelation IMAGES = null;
    public static final XWPFRelation IMAGE_BMP = null;
    public static final XWPFRelation IMAGE_DIB = null;
    public static final XWPFRelation IMAGE_EMF = null;
    public static final XWPFRelation IMAGE_EPS = null;
    public static final XWPFRelation IMAGE_GIF = null;
    public static final XWPFRelation IMAGE_JPEG = null;
    public static final XWPFRelation IMAGE_PICT = null;
    public static final XWPFRelation IMAGE_PNG = null;
    public static final XWPFRelation IMAGE_TIFF = null;
    public static final XWPFRelation IMAGE_WMF = null;
    public static final XWPFRelation IMAGE_WPG = null;
    public static final XWPFRelation MACRO_DOCUMENT = null;
    public static final XWPFRelation MACRO_TEMPLATE_DOCUMENT = null;
    public static final XWPFRelation NUMBERING = null;
    public static final XWPFRelation SETTINGS = null;
    public static final XWPFRelation STYLES = null;
    public static final XWPFRelation TEMPLATE = null;
    public static final XWPFRelation THEME = null;
    public static final XWPFRelation WEB_SETTINGS = null;
    public static final XWPFRelation WORKBOOK = null;
    private static final Map<String, XWPFRelation> _table = null;

    static {
        _table = new HashMap();
        DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        TEMPLATE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        MACRO_DOCUMENT = new XWPFRelation("application/vnd.ms-word.document.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        MACRO_TEMPLATE_DOCUMENT = new XWPFRelation("application/vnd.ms-word.template.macroEnabledTemplate.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        GLOSSARY_DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/glossaryDocument", "/word/glossary/document.xml");
        NUMBERING = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering", "/word/numbering.xml", $$Lambda$LbeLjvQhlzfXjgswTG8muYls.INSTANCE, $$Lambda$LSWOAyMue7kfvUIVwUMwCcpWev0.INSTANCE);
        FONT_TABLE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable", "/word/fontTable.xml");
        SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings", "/word/settings.xml", $$Lambda$IubE136zEiRsvMLdhuGcmTUUWg.INSTANCE, $$Lambda$nzx7UgnRZlx9IvA7zSh1e1blhJk.INSTANCE);
        STYLES = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/word/styles.xml", $$Lambda$ymZMckB8Uq8BIQJZh2nVDTBrVQ.INSTANCE, $$Lambda$VeHDTLnaD6VhFpwzjHwltvZ1rSE.INSTANCE);
        WEB_SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings", "/word/webSettings.xml");
        HEADER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.header+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header", "/word/header#.xml", $$Lambda$3N3El9WHPFDLj1lL_GbkLh5cFZI.INSTANCE, $$Lambda$LCXUZU47xJmQ6ZmITzUGApSyJQ.INSTANCE);
        FOOTER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer", "/word/footer#.xml", $$Lambda$8YVWoTJPss0PTcP7WMmyeyKziQ.INSTANCE, $$Lambda$SbeZ9sMPTRSVdJuwk0v2JzOmL4.INSTANCE);
        THEME = new XWPFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/word/theme/theme#.xml");
        WORKBOOK = new XWPFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package", "/word/embeddings/Microsoft_Excel_Worksheet#.xlsx", $$Lambda$Vq5Yusd9pAf1xg5QsRsMFdwAsbQ.INSTANCE, $$Lambda$RYt5IzC0A9X2JKLmj_TxUGRkXn4.INSTANCE);
        CHART = new XWPFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/word/charts/chart#.xml", $$Lambda$RQql81IeZRdPw9EIs7ooABoFobg.INSTANCE, $$Lambda$kF0lOCzMsUxnlToC58qhFE4Ukc4.INSTANCE);
        HYPERLINK = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null);
        COMMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/word/comments.xml", $$Lambda$jHFygYI9LSTu9e1rgwh85Cyx8Y.INSTANCE, $$Lambda$Z8txuLsZayossBvbriqpBKYlQjw.INSTANCE);
        FOOTNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footnotes", "/word/footnotes.xml", $$Lambda$T3_xX_Rn4fhQl4gtteIi27iN5rE.INSTANCE, $$Lambda$ACww6uKf4euVql1IWbd6RYgQ5CU.INSTANCE);
        ENDNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.endnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/endnotes", "/word/endnotes.xml", $$Lambda$8G6Eg5duOdjZcPVbK8eozAHAbhI.INSTANCE, $$Lambda$oKmsflagA6DnRB25OvEtSc52A.INSTANCE);
        IMAGE_EMF = new XWPFRelation(PictureType.EMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.emf", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_WMF = new XWPFRelation(PictureType.WMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wmf", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_PICT = new XWPFRelation(PictureType.PICT.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.pict", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_JPEG = new XWPFRelation(PictureType.JPEG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.jpeg", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_PNG = new XWPFRelation(PictureType.PNG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.png", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_DIB = new XWPFRelation(PictureType.DIB.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.dib", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_GIF = new XWPFRelation(PictureType.GIF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.gif", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_TIFF = new XWPFRelation(PictureType.TIFF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.tiff", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_EPS = new XWPFRelation(PictureType.EPS.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.eps", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_BMP = new XWPFRelation(PictureType.BMP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.bmp", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGE_WPG = new XWPFRelation(PictureType.WPG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wpg", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        HDPHOTO_WDP = new XWPFRelation(PictureType.WDP.contentType, "http://schemas.microsoft.com/office/2007/relationships/hdphoto", "/ppt/media/hdphoto#.wdp", $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
        IMAGES = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, $$Lambda$o2SsgsM5zlutXfLelzGdWLkewg.INSTANCE, $$Lambda$RMoyQvwQg4lbVgvtCGDDf2OViA.INSTANCE);
    }

    private XWPFRelation(String r1, String r2, String r3) {
        super(r1, r2, r3);
        _table.put(r2, this);
    }

    private XWPFRelation(String r10, String r11, String r12, POIXMLRelation.NoArgConstructor r13, POIXMLRelation.PackagePartConstructor r14) {
        super(r10, r11, r12, (POIXMLRelation.NoArgConstructor) ZeusTransformUtils.wrapperContextForParams(r13, POIXMLRelation.NoArgConstructor.class, "com.obric.memorydata.plugin"), (POIXMLRelation.PackagePartConstructor) ZeusTransformUtils.wrapperContextForParams(r14, POIXMLRelation.PackagePartConstructor.class, "com.obric.memorydata.plugin"), null);
        _table.put(r11, this);
    }

    private XWPFRelation(String r10, String r11, String r12, POIXMLRelation.NoArgConstructor r13, POIXMLRelation.ParentPartConstructor r14) {
        super(r10, r11, r12, (POIXMLRelation.NoArgConstructor) ZeusTransformUtils.wrapperContextForParams(r13, POIXMLRelation.NoArgConstructor.class, "com.obric.memorydata.plugin"), null, (POIXMLRelation.ParentPartConstructor) ZeusTransformUtils.wrapperContextForParams(r14, POIXMLRelation.ParentPartConstructor.class, "com.obric.memorydata.plugin"));
        _table.put(r11, this);
    }

    public static XWPFRelation getInstance(String r2) {
        return (XWPFRelation) ZeusTransformUtils.preCheckCast(_table.get(r2), XWPFRelation.class, "com.obric.memorydata.plugin");
    }
}
