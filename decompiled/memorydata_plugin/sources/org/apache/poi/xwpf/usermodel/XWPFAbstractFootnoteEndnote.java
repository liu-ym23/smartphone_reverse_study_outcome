package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XWPFAbstractFootnoteEndnote implements Iterable<XWPFParagraph>, IBody {
    private final List<IBodyElement> bodyElements;
    protected ap ctFtnEdn;
    protected XWPFDocument document;
    protected XWPFAbstractFootnotesEndnotes footnotes;
    private final List<XWPFParagraph> paragraphs;
    private final List<XWPFPictureData> pictures;
    private final List<XWPFTable> tables;

    public XWPFAbstractFootnoteEndnote() {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
    }

    public XWPFAbstractFootnoteEndnote(ap r3, XWPFAbstractFootnotesEndnotes r4) {
        ap r5 = (ap) ZeusTransformUtils.wrapperContextForParams(r3, ap.class, "com.obric.memorydata.plugin");
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        this.footnotes = r4;
        this.ctFtnEdn = r5;
        this.document = r4.getXWPFDocument();
        init();
    }

    public ap getCTFtnEdn() {
        return this.ctFtnEdn;
    }

    public List<XWPFParagraph> getParagraphs() {
        return this.paragraphs;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.document;
    }

    public void init() {
        XmlCursor r0 = this.ctFtnEdn.newCursor();
        r0.selectPath("./*");     // Catch: Throwable -> L21
    L4:
        if (r0.toNextSelection() == false) goto L18;
        XmlObject r1 = r0.getObject();     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r1, bv.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, eh.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, dc.class) == false) goto L4;
        IBodyElement r2 = new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r1, dc.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L21
        List r3 = this.bodyElements;     // Catch: Throwable -> L21
    L10:
        r3.add(r2);     // Catch: Throwable -> L21
        goto L4
    L13:
        r2 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r1, eh.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L21
        this.bodyElements.add(r2);     // Catch: Throwable -> L21
        r3 = this.tables;     // Catch: Throwable -> L21
        goto L10
    L9:
        r2 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r1, bv.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L21
        this.bodyElements.add(r2);     // Catch: Throwable -> L21
        r3 = this.paragraphs;     // Catch: Throwable -> L21
        goto L10
    L18:
        if (r0 == null) goto L43;
        r0.close();
        return;
    L43:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r0 != null) goto L34;
    L29:
        throw th;
    L34:
        r0.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }

    @Override // java.lang.Iterable
    public Iterator<XWPFParagraph> iterator() {
        return this.paragraphs.iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XWPFParagraph> spliterator() {
        return this.paragraphs.spliterator();
    }
}
