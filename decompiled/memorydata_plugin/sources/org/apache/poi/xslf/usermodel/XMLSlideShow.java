package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.af;
import org.openxmlformats.schemas.presentationml.x2006.main.al;
import org.openxmlformats.schemas.presentationml.x2006.main.ap;
import org.openxmlformats.schemas.presentationml.x2006.main.bh;

/* JADX INFO: loaded from: classes7.dex */
public class XMLSlideShow extends POIXMLDocument implements SlideShow<XSLFShape, XSLFTextParagraph> {
    private static final Pattern GET_ALL_EMBEDDED_PARTS_PATTERN = null;
    private static final Pattern GET_PICTURE_DATA_PATTERN = null;
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH;
    private final List<XSLFChart> _charts;
    private XSLFCommentAuthors _commentAuthors;
    private final List<XSLFSlideMaster> _masters;
    private XSLFNotesMaster _notesMaster;
    private final List<XSLFPictureData> _pictures;
    private af _presentation;
    private final List<XSLFSlide> _slides;
    private XSLFTableStyles _tableStyles;

    static {
        LOG = b.a(XMLSlideShow.class);
        MAX_RECORD_LENGTH = 1000000;
        GET_ALL_EMBEDDED_PARTS_PATTERN = Pattern.compile("/ppt/embeddings/.*?");
        GET_PICTURE_DATA_PATTERN = Pattern.compile("/ppt/media/.*?");
    }

    public XMLSlideShow() {
        this(empty());
    }

    public XMLSlideShow(InputStream r1) {
        this(PackageHelper.open(r1));
    }

    public XMLSlideShow(OPCPackage r2) {
        super(r2);
        this._slides = new ArrayList();
        this._masters = new ArrayList();
        this._pictures = new ArrayList();
        this._charts = new ArrayList();
    L8:
        e = move-exception;
        throw new POIXMLException(e);
    L4:
        if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType()) == false) goto L6;
        rebase(getPackage());     // Catch: Exception -> L8
    L6:
        load(XSLFFactory.getInstance());     // Catch: Exception -> L8
    }

    static OPCPackage empty() {
        InputStream r0 = XMLSlideShow.class.getResourceAsStream("empty.pptx");
        if (r0 == null) goto L15;
        OPCPackage r1 = OPCPackage.open(r0);     // Catch: Throwable -> L7 Exception -> L9
        IOUtils.closeQuietly(r0);
        return r1;
    L9:
        e = move-exception;
        throw new POIXMLException(e);     // Catch: Throwable -> L7
    L15:
        throw new POIXMLException("Missing resource 'empty.pptx'");
    L7:
        th = move-exception;
        IOUtils.closeQuietly(r0);
        throw th;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        this._presentation.save(r0, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFSlide> getSlides() {
        return this._slides;
    }

    public /* synthetic */ void lambda$onDocumentRead$0$XMLSlideShow(Map r3, ap r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        ap r6 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.memorydata.plugin");
        this._masters.add((XSLFSlideMaster) r5.get(r6.getId2()));
    }

    public /* synthetic */ void lambda$onDocumentRead$1$XMLSlideShow(Map r3, al r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        XSLFSlide r7 = (XSLFSlide) ZeusTransformUtils.preCheckCast(r5.get(r6.getId2()), XSLFSlide.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        LOG.atWarn().a("Slide with r:id {} was defined, but didn't exist in package, skipping", v.a(r6.getId()));
        return;
    L5:
        this._slides.add(r7);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r1 = getCorePart().getInputStream();     // Catch: XmlException -> L46
        this._presentation = ((bh) ZeusTransformUtils.preCheckCast(bh.f19267a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bh.class, "com.obric.memorydata.plugin")).getPresentation();     // Catch: Throwable -> L37
        if (r1 == null) goto L7;
        r1.close();     // Catch: XmlException -> L46
    L7:
        final HashMap r2 = new HashMap();     // Catch: XmlException -> L46
        final HashMap r3 = new HashMap();     // Catch: XmlException -> L46
        HashMap r4 = new HashMap();     // Catch: XmlException -> L46
        Iterator<POIXMLDocumentPart.RelationPart> r5 = getRelationParts().iterator();     // Catch: XmlException -> L46
    L9:
        if (r5.hasNext() == false) goto L30;
        POIXMLDocumentPart.RelationPart r6 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r5.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L46
        POIXMLDocumentPart r7 = r6.getDocumentPart();     // Catch: XmlException -> L46
        if (ZeusTransformUtils.instanceOf(r7, XSLFSlide.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r7, XSLFSlideMaster.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, XSLFTableStyles.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, XSLFNotesMaster.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r7, XSLFCommentAuthors.class) == false) goto L9;
        this._commentAuthors = (XSLFCommentAuthors) ZeusTransformUtils.preCheckCast(r7, XSLFCommentAuthors.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L46
        goto L9
    L26:
        this._notesMaster = (XSLFNotesMaster) ZeusTransformUtils.preCheckCast(r7, XSLFNotesMaster.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L46
        goto L9
    L23:
        this._tableStyles = (XSLFTableStyles) ZeusTransformUtils.preCheckCast(r7, XSLFTableStyles.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L46
        goto L9
    L20:
        r2.put(getRelationId(r7), (XSLFSlideMaster) ZeusTransformUtils.preCheckCast(r7, XSLFSlideMaster.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L46
        goto L9
    L12:
        r3.put(r6.getRelationship().getId(), (XSLFSlide) ZeusTransformUtils.preCheckCast(r7, XSLFSlide.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L46
        Iterator<POIXMLDocumentPart> r8 = r7.getRelations().iterator();     // Catch: XmlException -> L46
    L14:
        if (r8.hasNext() == false) goto L9;
        POIXMLDocumentPart r9 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r8.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L46
        if (ZeusTransformUtils.instanceOf(r9, XSLFChart.class) == false) goto L14;
        r4.put(r9.getPackagePart().getPartName().getName(), (XSLFChart) ZeusTransformUtils.preCheckCast(r9, XSLFChart.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L46
        goto L14
    L30:
        this._charts.clear();     // Catch: XmlException -> L46
        this._charts.addAll(r4.values());     // Catch: XmlException -> L46
        this._masters.clear();     // Catch: XmlException -> L46
        if (this._presentation.isSetSldMasterIdLst() == false) goto L33;
        this._presentation.getSldMasterIdLst().getSldMasterIdList().forEach(new $$Lambda$XMLSlideShow$UkMr_KOGGtNrAk2BDkq0bP4AVrY(this, r2));     // Catch: XmlException -> L46
    L33:
        this._slides.clear();     // Catch: XmlException -> L46
        if (this._presentation.isSetSldIdLst() == false) goto L77;
        this._presentation.getSldIdLst().getSldIdList().forEach(new $$Lambda$XMLSlideShow$TMfRf8CgQFdkcseBiP_FhXQ24D4(this, r3));     // Catch: XmlException -> L46
        return;
    L77:
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r1 != null) goto L49;
    L45:
        throw th;     // Catch: XmlException -> L46
    L49:
        r1.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L46
    L46:
        e = move-exception;
        throw new POIXMLException(e);
    }
}
