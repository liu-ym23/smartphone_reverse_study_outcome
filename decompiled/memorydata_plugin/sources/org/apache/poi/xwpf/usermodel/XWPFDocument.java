package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.IdentifierManager;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.f;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.z;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFDocument extends POIXMLDocument implements IBody {
    private static final c LOG = null;
    protected List<IBodyElement> bodyElements;
    protected final List<XWPFChart> charts;
    private XWPFComments comments;
    protected List<XWPFSDT> contentControls;
    private z ctDocument;
    private final IdentifierManager drawingIdManager;
    protected XWPFEndnotes endnotes;
    protected List<XWPFFooter> footers;
    private final FootnoteEndnoteIdManager footnoteIdManager;
    protected XWPFFootnotes footnotes;
    private XWPFHeaderFooterPolicy headerFooterPolicy;
    protected List<XWPFHeader> headers;
    protected List<XWPFHyperlink> hyperlinks;
    protected XWPFNumbering numbering;
    protected Map<Long, List<XWPFPictureData>> packagePictures;
    protected List<XWPFParagraph> paragraphs;
    protected List<XWPFPictureData> pictures;
    private XWPFSettings settings;
    protected XWPFStyles styles;
    protected List<XWPFTable> tables;

    static {
        LOG = b.a(XWPFDocument.class);
    }

    public XWPFDocument() {
        super(newPackage());
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.charts = new ArrayList();
        this.drawingIdManager = new IdentifierManager(0, 4294967295L);
        this.footnoteIdManager = new FootnoteEndnoteIdManager(this);
        onDocumentCreate();
    }

    public XWPFDocument(InputStream r5) {
        super(PackageHelper.open(r5));
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.charts = new ArrayList();
        this.drawingIdManager = new IdentifierManager(0, 4294967295L);
        this.footnoteIdManager = new FootnoteEndnoteIdManager(this);
        load(XWPFFactory.getInstance());
    }

    private void initFootnotes() {
        Iterator<POIXMLDocumentPart.RelationPart> r0 = getRelationParts().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        POIXMLDocumentPart.RelationPart r1 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r0.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        POIXMLDocumentPart r2 = r1.getDocumentPart();
        String r3 = r1.getRelationship().getRelationshipType();
        if (r3.equals(XWPFRelation.FOOTNOTE.getRelation()) == true) goto L7;
        if (r3.equals(XWPFRelation.ENDNOTE.getRelation()) == false) goto L4;
        XWPFEndnotes r4 = (XWPFEndnotes) ZeusTransformUtils.preCheckCast(r2, XWPFEndnotes.class, "com.obric.memorydata.plugin");
        this.endnotes = r4;
        r4.onDocumentRead();
        this.endnotes.setIdManager(this.footnoteIdManager);
        goto L4
    L7:
        XWPFFootnotes r5 = (XWPFFootnotes) ZeusTransformUtils.preCheckCast(r2, XWPFFootnotes.class, "com.obric.memorydata.plugin");
        this.footnotes = r5;
        r5.onDocumentRead();
        this.footnotes.setIdManager(this.footnoteIdManager);
        goto L4
    }

    private void initHyperlinks() {
        this.hyperlinks = new ArrayList();     // Catch: InvalidFormatException -> L8
        Iterator<PackageRelationship> r0 = getPackagePart().getRelationshipsByType(XWPFRelation.HYPERLINK.getRelation()).iterator();     // Catch: InvalidFormatException -> L8
    L4:
        if (r0.hasNext() == false) goto L7;
        PackageRelationship r1 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r0.next(), PackageRelationship.class, "com.obric.memorydata.plugin");     // Catch: InvalidFormatException -> L8
        this.hyperlinks.add(new XWPFHyperlink(r1.getId(), r1.getTargetURI().toString()));     // Catch: InvalidFormatException -> L8
        goto L4
    L7:
        return;
    L8:
        e = move-exception;
        throw new POIXMLException(e);
    }

    static /* synthetic */ List lambda$registerPackagePictureData$0(Long r1) {
        return new ArrayList(1);
    }

    public static OPCPackage newPackage() {
        OPCPackage r0 = null;
        r0 = OPCPackage.create(new UnsynchronizedByteArrayOutputStream());     // Catch: Exception -> L5
        PackagePartName r1 = PackagingURIHelper.createPartName(XWPFRelation.DOCUMENT.getDefaultFileName());     // Catch: Exception -> L5
        r0.addRelationship(r1, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");     // Catch: Exception -> L5
        r0.createPart(r1, XWPFRelation.DOCUMENT.getContentType());     // Catch: Exception -> L5
        r0.getPackageProperties().setCreatorProperty("Apache POI");     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        IOUtils.closeQuietly(r0);
        throw new POIXMLException(e);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(z.f20253b.getName().getNamespaceURI(), "document"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctDocument.save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L18;
    L15:
        throw th;
    L18:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public z getDocument() {
        return this.ctDocument;
    }

    IdentifierManager getDrawingIdManager() {
        return this.drawingIdManager;
    }

    public XWPFEndnote getEndnoteByID(int r1) {
        XWPFEndnotes r0 = this.endnotes;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFootnoteById(r1);
    }

    public XWPFFootnote getFootnoteByID(int r2) {
        XWPFFootnotes r1 = this.footnotes;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (XWPFFootnote) ZeusTransformUtils.preCheckCast(r1.getFootnoteById(r2), XWPFFootnote.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentCreate() {
        z r0 = (z) ZeusTransformUtils.preCheckCast(z.f20252a.newInstance(), z.class, "com.obric.memorydata.plugin");
        this.ctDocument = r0;
        r0.addNewBody();
        this.settings = (XWPFSettings) ZeusTransformUtils.preCheckCast(createRelationship(XWPFRelation.SETTINGS, XWPFFactory.getInstance()), XWPFSettings.class, "com.obric.memorydata.plugin");
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication("Apache POI");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r2 = getPackagePart().getInputStream();     // Catch: XmlException -> L99
        fr r3 = (fr) ZeusTransformUtils.preCheckCast(fr.f20170a.parse(r2, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fr.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        this.ctDocument = r3.getDocument();     // Catch: Throwable -> L90
        if (r2 == null) goto L7;
        r2.close();     // Catch: XmlException -> L99
    L7:
        initFootnotes();     // Catch: XmlException -> L99
        XmlCursor r4 = this.ctDocument.newCursor();     // Catch: XmlException -> L99
        r4.selectPath("./*");     // Catch: Throwable -> L81
    L10:
        if (r4.toNextSelection() == false) goto L40;
        XmlObject r5 = r4.getObject();     // Catch: Throwable -> L81
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L10;
        XmlCursor r6 = r5.newCursor();     // Catch: Throwable -> L81
        r6.selectPath("./*");     // Catch: Throwable -> L31
    L16:
        if (r6.toNextSelection() == false) goto L28;
        XmlObject r7 = r6.getObject();     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(r7, bv.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r7, eh.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, dc.class) == false) goto L16;
        IBodyElement r8 = new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r7, dc.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L31
        this.bodyElements.add(r8);     // Catch: Throwable -> L31
        List r9 = this.contentControls;     // Catch: Throwable -> L31
    L20:
        r9.add(r8);     // Catch: Throwable -> L31
        goto L16
    L23:
        r8 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r7, eh.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L31
        this.bodyElements.add(r8);     // Catch: Throwable -> L31
        r9 = this.tables;     // Catch: Throwable -> L31
        goto L20
    L19:
        r8 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r7, bv.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L31
        this.bodyElements.add(r8);     // Catch: Throwable -> L31
        r9 = this.paragraphs;     // Catch: Throwable -> L31
        goto L20
    L28:
        if (r6 == null) goto L10;
        r6.close();     // Catch: Throwable -> L81
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (r6 != null) goto L104;
    L39:
        throw th;     // Catch: Throwable -> L81
    L104:
        r6.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L81
        goto L39
    L40:
        if (r4 == null) goto L43;
        r4.close();     // Catch: XmlException -> L99
    L43:
        if (r3.getDocument().getBody().getSectPr() == null) goto L45;
        this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);     // Catch: XmlException -> L99
    L45:
        Iterator<POIXMLDocumentPart.RelationPart> r0 = getRelationParts().iterator();     // Catch: XmlException -> L99
    L47:
        if (r0.hasNext() == false) goto L79;
        POIXMLDocumentPart.RelationPart r10 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r0.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        POIXMLDocumentPart r11 = r10.getDocumentPart();     // Catch: XmlException -> L99
        String r12 = r10.getRelationship().getRelationshipType();     // Catch: XmlException -> L99
        if (r12.equals(XWPFRelation.STYLES.getRelation()) == true) goto L50;
        if (r12.equals(XWPFRelation.NUMBERING.getRelation()) == true) goto L53;
        if (r12.equals(XWPFRelation.FOOTER.getRelation()) == true) goto L56;
        if (r12.equals(XWPFRelation.HEADER.getRelation()) == true) goto L59;
        if (r12.equals(XWPFRelation.COMMENT.getRelation()) == true) goto L62;
        if (r12.equals(XWPFRelation.SETTINGS.getRelation()) == true) goto L65;
        if (r12.equals(XWPFRelation.IMAGES.getRelation()) == true) goto L68;
        if (r12.equals(XWPFRelation.CHART.getRelation()) == true) goto L72;
        if (r12.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation()) == false) goto L47;
        Iterator<POIXMLDocumentPart> r13 = r11.getRelations().iterator();     // Catch: XmlException -> L99
    L77:
        if (r13.hasNext() == false) goto L47;
        POIXMLDocumentPart._invokeOnDocumentRead((POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r13.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L99
        goto L77
    L72:
        XWPFChart r14 = (XWPFChart) ZeusTransformUtils.preCheckCast(r11, XWPFChart.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        List r15 = this.charts;     // Catch: XmlException -> L99
        Object r16 = r14;
    L69:
        r15.add(r16);     // Catch: XmlException -> L99
        goto L47
    L68:
        XWPFPictureData r17 = (XWPFPictureData) ZeusTransformUtils.preCheckCast(r11, XWPFPictureData.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        r17.onDocumentRead();     // Catch: XmlException -> L99
        registerPackagePictureData(r17);     // Catch: XmlException -> L99
        r15 = this.pictures;     // Catch: XmlException -> L99
        r16 = r17;
        goto L69
    L65:
        XWPFSettings r18 = (XWPFSettings) ZeusTransformUtils.preCheckCast(r11, XWPFSettings.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.settings = r18;     // Catch: XmlException -> L99
        r18.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L62:
        XWPFComments r19 = (XWPFComments) ZeusTransformUtils.preCheckCast(r11, XWPFComments.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.comments = r19;     // Catch: XmlException -> L99
        r19.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L59:
        XWPFHeader r20 = (XWPFHeader) ZeusTransformUtils.preCheckCast(r11, XWPFHeader.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.headers.add(r20);     // Catch: XmlException -> L99
        r20.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L56:
        XWPFFooter r21 = (XWPFFooter) ZeusTransformUtils.preCheckCast(r11, XWPFFooter.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.footers.add(r21);     // Catch: XmlException -> L99
        r21.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L53:
        XWPFNumbering r22 = (XWPFNumbering) ZeusTransformUtils.preCheckCast(r11, XWPFNumbering.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.numbering = r22;     // Catch: XmlException -> L99
        r22.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L50:
        XWPFStyles r23 = (XWPFStyles) ZeusTransformUtils.preCheckCast(r11, XWPFStyles.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L99
        this.styles = r23;     // Catch: XmlException -> L99
        r23.onDocumentRead();     // Catch: XmlException -> L99
        goto L47
    L79:
        initHyperlinks();     // Catch: XmlException -> L99
        return;
    L81:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        if (r4 != null) goto L113;
    L89:
        throw th;     // Catch: XmlException -> L99
    L113:
        r4.close();     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L99
        goto L89
    L90:
        th = move-exception;
        throw th;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        if (r2 != null) goto L109;
    L98:
        throw th;     // Catch: XmlException -> L99
    L109:
        r2.close();     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L99
    L99:
        e = move-exception;
        throw new POIXMLException(e);
    }

    void registerPackagePictureData(XWPFPictureData r3) {
        List r2 = (List) ZeusTransformUtils.preCheckCast(this.packagePictures.computeIfAbsent(r3.getChecksum(), $$Lambda$XWPFDocument$PdwhtGaKC5d1GGItIuInsKXJg.INSTANCE), List.class, "com.obric.memorydata.plugin");
        if (r2.contains(r3) == true) goto L6;
        r2.add(r3);
        return;
    }
}
