package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.au;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XWPFHeaderFooter extends POIXMLDocumentPart implements IBody {
    List<IBodyElement> bodyElements;
    XWPFDocument document;
    au headerFooter;
    List<XWPFParagraph> paragraphs;
    List<XWPFPictureData> pictures;
    List<XWPFTable> tables;

    public XWPFHeaderFooter() {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        this.headerFooter = (au) ZeusTransformUtils.preCheckCast(au.f19936a.newInstance(), au.class, "com.obric.memorydata.plugin");
        readHdrFtr();
    }

    public XWPFHeaderFooter(POIXMLDocumentPart r2, PackagePart r3) {
        super(r2, r3);
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        XWPFDocument r4 = (XWPFDocument) ZeusTransformUtils.preCheckCast(getParent(), XWPFDocument.class, "com.obric.memorydata.plugin");
        this.document = r4;
        Objects.requireNonNull(r4);
    }

    public au _getHdrFtr() {
        return this.headerFooter;
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph r0 = new XWPFParagraph(this.headerFooter.addNewP(), this);
        this.paragraphs.add(r0);
        this.bodyElements.add(r0);
        return r0;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        XWPFDocument r0 = this.document;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (XWPFDocument) ZeusTransformUtils.preCheckCast(getParent(), XWPFDocument.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        Iterator<POIXMLDocumentPart> r0 = getRelations().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        POIXMLDocumentPart r1 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r0.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, XWPFPictureData.class) == false) goto L4;
        XWPFPictureData r2 = (XWPFPictureData) ZeusTransformUtils.preCheckCast(r1, XWPFPictureData.class, "com.obric.memorydata.plugin");
        this.pictures.add(r2);
        this.document.registerPackagePictureData(r2);
        goto L4
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
        if (this.bodyElements.isEmpty() == false) goto L5;
        createParagraph();
    L5:
        Iterator<XWPFTable> r0 = this.tables.iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        Iterator<XWPFTableRow> r1 = ((XWPFTable) ZeusTransformUtils.preCheckCast(r0.next(), XWPFTable.class, "com.obric.memorydata.plugin")).tableRows.iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        Iterator<XWPFTableCell> r2 = ((XWPFTableRow) ZeusTransformUtils.preCheckCast(r1.next(), XWPFTableRow.class, "com.obric.memorydata.plugin")).getTableCells().iterator();
    L13:
        if (r2.hasNext() == false) goto L10;
        XWPFTableCell r4 = (XWPFTableCell) ZeusTransformUtils.preCheckCast(r2.next(), XWPFTableCell.class, "com.obric.memorydata.plugin");
        if (r4.getBodyElements().isEmpty() == false) goto L13;
        r4.addParagraph();
        goto L13
    L17:
        super.prepareForCommit();
    }

    public void readHdrFtr() {
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor r0 = this.headerFooter.newCursor();
        r0.selectPath("./*");     // Catch: Throwable -> L17
    L4:
        if (r0.toNextSelection() == false) goto L14;
        XmlObject r1 = r0.getObject();     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r1, bv.class) == false) goto L11;
        XWPFParagraph r2 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r1, bv.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L17
        this.paragraphs.add(r2);     // Catch: Throwable -> L17
        this.bodyElements.add(r2);     // Catch: Throwable -> L17
    L11:
        if (ZeusTransformUtils.instanceOf(r1, eh.class) == false) goto L4;
        XWPFTable r3 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r1, eh.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L17
        this.tables.add(r3);     // Catch: Throwable -> L17
        this.bodyElements.add(r3);     // Catch: Throwable -> L17
        goto L4
    L14:
        if (r0 == null) goto L37;
        r0.close();
        return;
    L37:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r0 != null) goto L30;
    L25:
        throw th;
    L30:
        r0.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }
}
